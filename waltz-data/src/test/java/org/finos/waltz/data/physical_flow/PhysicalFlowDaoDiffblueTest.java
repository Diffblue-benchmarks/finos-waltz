package org.finos.waltz.data.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalFlowDaoDiffblueTest {
  /**
   * Test {@link PhysicalFlowDao#create(PhysicalFlow)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowDao#create(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlow); given ResultSet getLong(int) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long PhysicalFlowDao.create(PhysicalFlow)"})
  void testCreate_givenResultSetGetLongReturnOne_thenReturnOne() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any())).thenReturn(preparedStatement);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    UserTimestamp userTimestamp = mock(UserTimestamp.class);
    when(userTimestamp.by()).thenReturn("By");
    when(userTimestamp.atTimestamp()).thenReturn(mock(Timestamp.class));
    Optional<UserTimestamp> ofResult = Optional.of(userTimestamp);
    PhysicalFlow flow = mock(PhysicalFlow.class);
    when(flow.created()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(flow.externalId()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(flow.lastAttestedAt()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(flow.lastAttestedBy()).thenReturn(ofResult4);
    when(flow.isRemoved()).thenReturn(true);
    when(flow.description()).thenReturn("The characteristics of someone or something");
    when(flow.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flow.specificationId()).thenReturn(1L);
    when(flow.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(flow.basisOffset()).thenReturn(1);
    when(flow.criticality()).thenReturn(CriticalityValue.of("42"));
    when(flow.transport()).thenReturn(TransportKindValue.of("42"));
    when(flow.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(flow.id()).thenReturn(emptyResult);
    when(flow.logicalFlowId()).thenReturn(1L);
    when(flow.frequency()).thenReturn(FrequencyKindValue.of("42"));

    // Act
    long actualCreateResult = physicalFlowDao.create(flow);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"physical_flow\" (\"specification_id\", \"basis_offset\", \"frequency\", \"transport\", \"description\", \"provenance\", \"last_updated_at\", \"last_updated_by\", \"logical_flow_id\", \"is_removed\", \"last_attested_at\", \"last_attested_by\", \"criticality\", \"external_id\", \"created_at\", \"created_by\", \"name\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
        isA(String[].class));
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setBoolean(eq(10), eq(true));
    verify(preparedStatement).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(flow, atLeast(1)).created();
    verify(flow).description();
    verify(flow).externalId();
    verify(flow).id();
    verify(flow).isRemoved();
    verify(flow).lastAttestedAt();
    verify(flow).lastAttestedBy();
    verify(flow, atLeast(1)).lastUpdatedAt();
    verify(flow, atLeast(1)).lastUpdatedBy();
    verify(userTimestamp).atTimestamp();
    verify(userTimestamp).by();
    verify(flow).basisOffset();
    verify(flow).criticality();
    verify(flow).frequency();
    verify(flow).logicalFlowId();
    verify(flow).name();
    verify(flow).specificationId();
    verify(flow).transport();
    assertEquals(1L, actualCreateResult);
  }
}
