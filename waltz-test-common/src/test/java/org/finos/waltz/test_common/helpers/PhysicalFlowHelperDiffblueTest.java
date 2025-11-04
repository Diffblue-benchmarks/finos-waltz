package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.physical_specification.search.PhysicalSpecificationSearchDao;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommandResponse;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalFlowHelperDiffblueTest {
  /**
   * Method under test: {@link PhysicalFlowHelper#deletePhysicalFlow(Long)}
   */
  @Test
  void testDeletePhysicalFlow() {
    // Arrange
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.delete(Mockito.<PhysicalFlowDeleteCommand>any(), Mockito.<String>any())).thenReturn(null);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class));

    // Act
    PhysicalFlowDeleteCommandResponse actualDeletePhysicalFlowResult = (new PhysicalFlowHelper(physicalFlowService,
        physicalSpecificationService, new DefaultDSLContext(SQLDialect.SQL99))).deletePhysicalFlow(1L);

    // Assert
    verify(physicalFlowService).delete(isA(PhysicalFlowDeleteCommand.class),
        eq("deletingFlow_3c4d4d41-760a-4fe2-b20d-7694eb189fc8"));
    assertNull(actualDeletePhysicalFlowResult);
  }

  /**
   * Method under test: {@link PhysicalFlowHelper#markFlowAsReadOnly(long)}
   */
  @Test
  void testMarkFlowAsReadOnly() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dslContext = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    (new PhysicalFlowHelper(null,
        new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class)),
        dslContext)).markFlowAsReadOnly(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"is_readonly\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowHelper#updateExternalIdOnFlowDirectly(long, String)}
   */
  @Test
  void testUpdateExternalIdOnFlowDirectly() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dslContext = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    (new PhysicalFlowHelper(null,
        new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class)),
        dslContext)).updateExternalIdOnFlowDirectly(1L, "42");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"physical_flow\" set \"physical_flow\".\"external_id\" = ? where \"physical_flow\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }
}
