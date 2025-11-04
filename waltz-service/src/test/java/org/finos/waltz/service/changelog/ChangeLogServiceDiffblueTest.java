package org.finos.waltz.service.changelog;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.tally.DateTally;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeLogServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeLogService#findByParentReferenceForDateRange(EntityReference, Date, Date, Optional)}
   */
  @Test
  void testFindByParentReferenceForDateRange() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    when(changeLogDao.findByParentReferenceForDateRange(Mockito.<EntityReference>any(), Mockito.<java.sql.Date>any(),
        Mockito.<java.sql.Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference ref = mock(EntityReference.class);
    java.sql.Date startDate = mock(java.sql.Date.class);
    java.sql.Date endDate = mock(java.sql.Date.class);
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceForDateRangeResult = changeLogService
        .findByParentReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(changeLogDao).findByParentReferenceForDateRange(isA(EntityReference.class), isA(java.sql.Date.class),
        isA(java.sql.Date.class), isA(Optional.class));
    assertTrue(actualFindByParentReferenceForDateRangeResult.isEmpty());
    assertSame(changeLogList, actualFindByParentReferenceForDateRangeResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional)}
   */
  @Test
  void testFindByPersonReferenceForDateRange() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    when(changeLogDao.findByPersonReferenceForDateRange(Mockito.<EntityReference>any(), Mockito.<java.sql.Date>any(),
        Mockito.<java.sql.Date>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference ref = mock(EntityReference.class);
    java.sql.Date startDate = mock(java.sql.Date.class);
    java.sql.Date endDate = mock(java.sql.Date.class);
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceForDateRangeResult = changeLogService
        .findByPersonReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(changeLogDao).findByPersonReferenceForDateRange(isA(EntityReference.class), isA(java.sql.Date.class),
        isA(java.sql.Date.class), isA(Optional.class));
    assertTrue(actualFindByPersonReferenceForDateRangeResult.isEmpty());
    assertSame(changeLogList, actualFindByPersonReferenceForDateRangeResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findByParentReference(EntityReference, Optional, Optional)}
   */
  @Test
  void testFindByParentReference() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    when(changeLogDao.findByParentReference(Mockito.<EntityReference>any(), Mockito.<Optional<Date>>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference ref = mock(EntityReference.class);
    Optional<Date> date = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceResult = changeLogService.findByParentReference(ref, date, limit);

    // Assert
    verify(changeLogDao).findByParentReference(isA(EntityReference.class), isA(Optional.class), isA(Optional.class));
    assertTrue(actualFindByParentReferenceResult.isEmpty());
    assertSame(changeLogList, actualFindByParentReferenceResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findByPersonReference(EntityReference, Optional, Optional)}
   */
  @Test
  void testFindByPersonReference() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    when(changeLogDao.findByPersonReference(Mockito.<EntityReference>any(), Mockito.<Optional<Date>>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference ref = mock(EntityReference.class);
    Optional<Date> date = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceResult = changeLogService.findByPersonReference(ref, date, limit);

    // Assert
    verify(changeLogDao).findByPersonReference(isA(EntityReference.class), isA(Optional.class), isA(Optional.class));
    assertTrue(actualFindByPersonReferenceResult.isEmpty());
    assertSame(changeLogList, actualFindByPersonReferenceResult);
  }

  /**
   * Method under test: {@link ChangeLogService#findByUser(String, Optional)}
   */
  @Test
  void testFindByUser() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    when(changeLogDao.findByUser(Mockito.<String>any(), Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<ChangeLog> actualFindByUserResult = changeLogService.findByUser("janedoe", limit);

    // Assert
    verify(changeLogDao).findByUser(eq("janedoe"), isA(Optional.class));
    assertTrue(actualFindByUserResult.isEmpty());
    assertSame(changeLogList, actualFindByUserResult);
  }

  /**
   * Method under test: {@link ChangeLogService#write(Collection)}
   */
  @Test
  void testWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    // Act
    int[] actualWriteResult = changeLogService.write(new ArrayList<>());

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    assertArrayEquals(new int[]{19088743, 1, 19088743, 1}, actualWriteResult);
  }

  /**
   * Method under test: {@link ChangeLogService#write(Collection)}
   */
  @Test
  void testWrite2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();
    changeLogs.add(mock(ChangeLog.class));

    // Act
    int[] actualWriteResult = changeLogService.write(changeLogs);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    assertArrayEquals(new int[]{19088743, 1, 19088743, 1}, actualWriteResult);
  }

  /**
   * Method under test: {@link ChangeLogService#write(Collection)}
   */
  @Test
  void testWrite3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();
    changeLogs.add(mock(ChangeLog.class));
    changeLogs.add(mock(ChangeLog.class));

    // Act
    int[] actualWriteResult = changeLogService.write(changeLogs);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    assertArrayEquals(new int[]{19088743, 1, 19088743, 1}, actualWriteResult);
  }

  /**
   * Method under test: {@link ChangeLogService#write(Optional, ChangeLog)}
   */
  @Test
  void testWrite4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualWriteResult = changeLogService.write(tx, null);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isNull());
    assertEquals(19088743, actualWriteResult);
  }

  /**
   * Method under test: {@link ChangeLogService#write(ChangeLog)}
   */
  @Test
  void testWrite5() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    int actualWriteResult = (new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))
            .write((ChangeLog) null);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isNull());
    assertEquals(19088743, actualWriteResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findUnattestedChanges(EntityReference)}
   */
  @Test
  void testFindUnattestedChanges() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    when(changeLogDao.findUnattestedChanges(Mockito.<EntityReference>any())).thenReturn(changeLogList);

    // Act
    List<ChangeLog> actualFindUnattestedChangesResult = (new ChangeLogService(changeLogDao,
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class))).findUnattestedChanges(null);

    // Assert
    verify(changeLogDao).findUnattestedChanges(isNull());
    assertTrue(actualFindUnattestedChangesResult.isEmpty());
    assertSame(changeLogList, actualFindUnattestedChangesResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(EntityReference, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    changeLogService.writeChangeLogEntries(ref, "42", "Postamble", Operation.ADD);

    // Assert that nothing has changed
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(LogicalFlow, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);
    when(entityReference2.id()).thenReturn(1L);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.entityReference()).thenReturn(entityReference3);
    when(logicalFlow.target()).thenReturn(entityReference2);
    when(logicalFlow.source()).thenReturn(entityReference);

    // Act
    changeLogService.writeChangeLogEntries(logicalFlow, "42", "Postamble", Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference3, atLeast(1)).id();
    verify(entityReference3, atLeast(1)).kind();
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(logicalFlow, atLeast(1)).entityReference();
    verify(logicalFlow, atLeast(1)).source();
    verify(logicalFlow, atLeast(1)).target();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    when(measurableRating.entityReference()).thenReturn(entityReference);
    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);
    when(measurableRatingdao.getById(anyLong())).thenReturn(measurableRating);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference2);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), measurableRatingReplacementDao, measurableRatingdao,
        mock(MeasurableRatingPlannedDecommissionDao.class), nameResolver);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    when(measurableRatingPlannedDecommission.measurableRatingId()).thenReturn(1L);

    // Act
    changeLogService.writeChangeLogEntries(measurableRatingPlannedDecommission, "42", "Postamble", Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(eq(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference2, atLeast(1)).name();
    verify(measurableRating).entityReference();
    verify(measurableRating, atLeast(1)).measurableId();
    verify(measurableRatingPlannedDecommission).id();
    verify(measurableRatingPlannedDecommission).measurableRatingId();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    MeasurableRatingReplacement measurableRatingReplacement = mock(MeasurableRatingReplacement.class);
    when(measurableRatingReplacement.entityReference()).thenReturn(mock(EntityReference.class));

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(measurableRatingReplacement);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    when(measurableRating.entityReference()).thenReturn(entityReference);
    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);
    when(measurableRatingdao.getById(anyLong())).thenReturn(measurableRating);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference2);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), measurableRatingReplacementDao, measurableRatingdao,
        mock(MeasurableRatingPlannedDecommissionDao.class), nameResolver);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    when(measurableRatingPlannedDecommission.measurableRatingId()).thenReturn(1L);

    // Act
    changeLogService.writeChangeLogEntries(measurableRatingPlannedDecommission, "42", "Postamble", Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(eq(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference2, atLeast(1)).name();
    verify(measurableRating).entityReference();
    verify(measurableRating, atLeast(1)).measurableId();
    verify(measurableRatingPlannedDecommission).id();
    verify(measurableRatingPlannedDecommission).measurableRatingId();
    verify(measurableRatingReplacement).entityReference();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries5() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    Application application = mock(Application.class);
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(application);
    MeasurableRatingReplacement measurableRatingReplacement = mock(MeasurableRatingReplacement.class);
    when(measurableRatingReplacement.entityReference()).thenReturn(mock(EntityReference.class));

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(measurableRatingReplacement);
    MeasurableRatingReplacementDao measurableRatingReplacementDao = mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    when(measurableRating.entityReference()).thenReturn(entityReference);
    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);
    when(measurableRatingdao.getById(anyLong())).thenReturn(measurableRating);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);
    Optional<EntityReference> ofResult3 = Optional.of(entityReference2);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult3);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), applicationDao,
        measurableRatingReplacementDao, measurableRatingdao, mock(MeasurableRatingPlannedDecommissionDao.class),
        nameResolver);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    when(measurableRatingPlannedDecommission.measurableRatingId()).thenReturn(1L);

    // Act
    changeLogService.writeChangeLogEntries(measurableRatingPlannedDecommission, "42", "Postamble", Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(eq(1L));
    verify(measurableRatingReplacementDao).fetchByDecommissionId(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference2, atLeast(1)).name();
    verify(application).assetCode();
    verify(measurableRating).entityReference();
    verify(measurableRating, atLeast(1)).measurableId();
    verify(measurableRatingPlannedDecommission).id();
    verify(measurableRatingPlannedDecommission).measurableRatingId();
    verify(measurableRatingReplacement).entityReference();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries6() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    when(measurableRating.entityReference()).thenReturn(entityReference);
    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);
    when(measurableRatingdao.getById(anyLong())).thenReturn(measurableRating);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.measurableRatingId()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao = mock(
        MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference2);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), measurableRatingdao,
        measurableRatingPlannedDecommissionDao, nameResolver);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    MeasurableRatingReplacement measurableRatingReplacement = mock(MeasurableRatingReplacement.class);
    when(measurableRatingReplacement.entityReference()).thenReturn(entityReference3);
    when(measurableRatingReplacement.decommissionId()).thenReturn(1L);

    // Act
    changeLogService.writeChangeLogEntries(measurableRatingReplacement, "42", "Postamble", Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionDao).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference3, atLeast(1)).id();
    verify(entityReference).kind();
    verify(entityReference3, atLeast(1)).kind();
    verify(entityReference2, atLeast(1)).name();
    verify(measurableRating, atLeast(1)).entityReference();
    verify(measurableRating, atLeast(1)).measurableId();
    verify(measurableRatingPlannedDecommission).measurableRatingId();
    verify(measurableRatingReplacement).decommissionId();
    verify(measurableRatingReplacement, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#writeChangeLogEntries(PhysicalFlow, String, String, Operation)}
   */
  @Test
  void testWriteChangeLogEntries7() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    when(physicalSpecificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.id()).thenReturn(1L);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(entityReference2.name()).thenReturn(emptyResult);
    when(entityReference2.id()).thenReturn(1L);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.entityReference()).thenReturn(mock(EntityReference.class));
    when(logicalFlow.target()).thenReturn(entityReference2);
    when(logicalFlow.source()).thenReturn(entityReference);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), physicalSpecificationDao, logicalFlowDao, mock(ApplicationDao.class),
        mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.entityReference()).thenReturn(entityReference3);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);

    // Act
    changeLogService.writeChangeLogEntries(physicalFlow, "42", "Postamble", Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(physicalSpecificationDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference3, atLeast(1)).id();
    verify(entityReference3, atLeast(1)).kind();
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(physicalSpecification).name();
    verify(logicalFlow).entityReference();
    verify(logicalFlow, atLeast(1)).source();
    verify(logicalFlow, atLeast(1)).target();
    verify(physicalFlow, atLeast(1)).entityReference();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector3() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector4() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector5() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector6() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector7() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector8() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector9() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)}
   */
  @Test
  void testFindCountByDateForParentKindBySelector10() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    ArrayList<DateTally> dateTallyList = new ArrayList<>();
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(Mockito.<GenericSelector>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(dateTallyList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class), changeLogSummariesDao,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    Optional<Integer> limit = Optional.<Integer>of(3);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult = changeLogService
        .findCountByDateForParentKindBySelector(EntityKind.ATTESTATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao).findCountByDateForParentKindBySelector(isA(GenericSelector.class),
        isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
    assertSame(dateTallyList, actualFindCountByDateForParentKindBySelectorResult);
  }
}
