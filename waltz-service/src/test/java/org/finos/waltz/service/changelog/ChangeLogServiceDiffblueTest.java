package org.finos.waltz.service.changelog;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.tally.DateTally;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeLogServiceDiffblueTest {
  /**
   * Test {@link ChangeLogService#findByParentReferenceForDateRange(EntityReference, Date, Date,
   * Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findByParentReferenceForDateRange(EntityReference, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByParentReferenceForDateRange(EntityReference, Date, Date, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findByParentReferenceForDateRange(EntityReference, Date, Date, Optional)"
  })
  void testFindByParentReferenceForDateRange_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.findByParentReferenceForDateRange(
            Mockito.<EntityReference>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLog> actualFindByParentReferenceForDateRangeResult =
        changeLogService.findByParentReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(changeLogDao)
        .findByParentReferenceForDateRange(
            isA(EntityReference.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    assertTrue(actualFindByParentReferenceForDateRangeResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findByPersonReferenceForDateRange(EntityReference, Date, Date,
   * Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional)"
  })
  void testFindByPersonReferenceForDateRange_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.findByPersonReferenceForDateRange(
            Mockito.<EntityReference>any(),
            Mockito.<Date>any(),
            Mockito.<Date>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLog> actualFindByPersonReferenceForDateRangeResult =
        changeLogService.findByPersonReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(changeLogDao)
        .findByPersonReferenceForDateRange(
            isA(EntityReference.class), isA(Date.class), isA(Date.class), isA(Optional.class));
    assertTrue(actualFindByPersonReferenceForDateRangeResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findByParentReference(EntityReference, Optional, Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogService#findByParentReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName("Test findByParentReference(EntityReference, Optional, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findByParentReference(EntityReference, Optional, Optional)"
  })
  void testFindByParentReference_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.findByParentReference(
            Mockito.<EntityReference>any(),
            Mockito.<Optional<java.util.Date>>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<java.util.Date> date =
        Optional.of(
            java.util.Date.from(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLog> actualFindByParentReferenceResult =
        changeLogService.findByParentReference(ref, date, limit);

    // Assert
    verify(changeLogDao)
        .findByParentReference(
            isA(EntityReference.class), isA(Optional.class), isA(Optional.class));
    assertTrue(actualFindByParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findByPersonReference(EntityReference, Optional, Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogService#findByPersonReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName("Test findByPersonReference(EntityReference, Optional, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findByPersonReference(EntityReference, Optional, Optional)"
  })
  void testFindByPersonReference_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.findByPersonReference(
            Mockito.<EntityReference>any(),
            Mockito.<Optional<java.util.Date>>any(),
            Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<java.util.Date> date =
        Optional.of(
            java.util.Date.from(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLog> actualFindByPersonReferenceResult =
        changeLogService.findByPersonReference(ref, date, limit);

    // Assert
    verify(changeLogDao)
        .findByPersonReference(
            isA(EntityReference.class), isA(Optional.class), isA(Optional.class));
    assertTrue(actualFindByPersonReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findByUser(String, Optional)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#findByUser(String, Optional)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogService#findByUser(String, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByUser(String, Optional); given ChangeLogDao findByUser(String, Optional) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogService.findByUser(String, Optional)"})
  void testFindByUser_givenChangeLogDaoFindByUserReturnArrayList_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.findByUser(Mockito.<String>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<ChangeLog> actualFindByUserResult = changeLogService.findByUser("janedoe", limit);

    // Assert
    verify(changeLogDao).findByUser(eq("janedoe"), isA(Optional.class));
    assertTrue(actualFindByUserResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#write(ChangeLog)} with {@code changeLog}.
   *
   * <p>Method under test: {@link ChangeLogService#write(ChangeLog)}
   */
  @Test
  @DisplayName("Test write(ChangeLog) with 'changeLog'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChangeLogService.write(ChangeLog)"})
  void testWriteWithChangeLog() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    // Act
    int actualWriteResult = changeLogService.write((ChangeLog) null);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isNull());
    assertEquals(19088743, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogService#write(Collection)} with {@code changeLogs}.
   *
   * <p>Method under test: {@link ChangeLogService#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogService.write(Collection)"})
  void testWriteWithChangeLogs() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();

    ImmutableChangeLog.Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    ImmutableChangeLog.Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    // Act
    int[] actualWriteResult = changeLogService.write(changeLogs);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    assertArrayEquals(new int[] {19088743, 1, 19088743, 1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogService#write(Collection)} with {@code changeLogs}.
   *
   * <p>Method under test: {@link ChangeLogService#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogService.write(Collection)"})
  void testWriteWithChangeLogs2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();

    ImmutableChangeLog.Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    ImmutableChangeLog.Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    ImmutableChangeLog.Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    ImmutableChangeLog.Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    // Act
    int[] actualWriteResult = changeLogService.write(changeLogs);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    assertArrayEquals(new int[] {19088743, 1, 19088743, 1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogService#write(Collection)} with {@code changeLogs}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogService#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogService.write(Collection)"})
  void testWriteWithChangeLogs_whenArrayList() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    // Act
    int[] actualWriteResult = changeLogService.write(new ArrayList<>());

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    assertArrayEquals(new int[] {19088743, 1, 19088743, 1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogService#write(Optional, ChangeLog)} with {@code tx}, {@code changeLog}.
   *
   * <p>Method under test: {@link ChangeLogService#write(Optional, ChangeLog)}
   */
  @Test
  @DisplayName("Test write(Optional, ChangeLog) with 'tx', 'changeLog'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChangeLogService.write(Optional, ChangeLog)"})
  void testWriteWithTxChangeLog() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    int actualWriteResult = changeLogService.write(tx, null);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isNull());
    assertEquals(19088743, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogService#findUnattestedChanges(EntityReference)}.
   *
   * <p>Method under test: {@link ChangeLogService#findUnattestedChanges(EntityReference)}
   */
  @Test
  @DisplayName("Test findUnattestedChanges(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogService.findUnattestedChanges(EntityReference)"})
  void testFindUnattestedChanges() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.findUnattestedChanges(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    // Act
    List<ChangeLog> actualFindUnattestedChangesResult =
        changeLogService.findUnattestedChanges(null);

    // Assert
    verify(changeLogDao).findUnattestedChanges(isNull());
    assertTrue(actualFindUnattestedChangesResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(LogicalFlow, String, String, Operation)}
   * with {@code logicalFlow}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(LogicalFlow, String,
   * String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(LogicalFlow, String, String, Operation) with 'logicalFlow', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(LogicalFlow, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithLogicalFlowUserIdPostambleOperation() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    changeLogService.writeChangeLogEntries(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(LogicalFlow, String, String, Operation)}
   * with {@code logicalFlow}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(LogicalFlow, String,
   * String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(LogicalFlow, String, String, Operation) with 'logicalFlow', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(LogicalFlow, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithLogicalFlowUserIdPostambleOperation2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(-2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    changeLogService.writeChangeLogEntries(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String,
   * String, Operation)} with {@code measurableRatingPlannedDecommission}, {@code userId}, {@code
   * postamble}, {@code operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation) with 'measurableRatingPlannedDecommission', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingPlannedDecommissionUserIdPostambleOperation() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver);

    // Act
    changeLogService.writeChangeLogEntries(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String,
   * String, Operation)} with {@code measurableRatingPlannedDecommission}, {@code userId}, {@code
   * postamble}, {@code operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation) with 'measurableRatingPlannedDecommission', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingPlannedDecommissionUserIdPostambleOperation2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                java.util.Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver);

    // Act
    changeLogService.writeChangeLogEntries(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String,
   * String, Operation)} with {@code measurableRatingPlannedDecommission}, {@code userId}, {@code
   * postamble}, {@code operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation) with 'measurableRatingPlannedDecommission', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingPlannedDecommissionUserIdPostambleOperation3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver);

    // Act
    changeLogService.writeChangeLogEntries(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String,
   * String, Operation)} with {@code measurableRatingPlannedDecommission}, {@code userId}, {@code
   * postamble}, {@code operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation) with 'measurableRatingPlannedDecommission', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingPlannedDecommissionUserIdPostambleOperation4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.APPLICATION)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            applicationDao,
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver);

    // Act
    changeLogService.writeChangeLogEntries(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(applicationDao).getById(1L);
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String,
   * String, Operation)} with {@code measurableRatingPlannedDecommission}, {@code userId}, {@code
   * postamble}, {@code operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation) with 'measurableRatingPlannedDecommission', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingPlannedDecommission, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingPlannedDecommissionUserIdPostambleOperation5() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                java.util.Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    MeasurableRatingReplacementDao measurableRatingReplacementDao =
        mock(MeasurableRatingReplacementDao.class);
    when(measurableRatingReplacementDao.fetchByDecommissionId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.APPLICATION)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            applicationDao,
            measurableRatingReplacementDao,
            measurableRatingdao,
            mock(MeasurableRatingPlannedDecommissionDao.class),
            nameResolver);

    // Act
    changeLogService.writeChangeLogEntries(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(applicationDao).getById(1L);
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingReplacementDao).fetchByDecommissionId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String,
   * Operation)} with {@code measurableRatingReplacement}, {@code userId}, {@code postamble}, {@code
   * operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation) with 'measurableRatingReplacement', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingReplacementUserIdPostambleOperation() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao,
            nameResolver);

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    changeLogService.writeChangeLogEntries(
        lastUpdatedByResult
            .plannedCommissionDate(
                java.util.Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String,
   * Operation)} with {@code measurableRatingReplacement}, {@code userId}, {@code postamble}, {@code
   * operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation) with 'measurableRatingReplacement', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingReplacementUserIdPostambleOperation2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao,
            nameResolver);

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    changeLogService.writeChangeLogEntries(
        lastUpdatedByResult
            .plannedCommissionDate(
                java.util.Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String,
   * Operation)} with {@code measurableRatingReplacement}, {@code userId}, {@code postamble}, {@code
   * operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation) with 'measurableRatingReplacement', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingReplacementUserIdPostambleOperation3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(-2L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao,
            nameResolver);

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    changeLogService.writeChangeLogEntries(
        lastUpdatedByResult
            .plannedCommissionDate(
                java.util.Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String,
   * Operation)} with {@code measurableRatingReplacement}, {@code userId}, {@code postamble}, {@code
   * operation}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation) with 'measurableRatingReplacement', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(MeasurableRatingReplacement, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithMeasurableRatingReplacementUserIdPostambleOperation4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    MeasurableRatingDao measurableRatingdao = mock(MeasurableRatingDao.class);

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingdao.getById(anyLong()))
        .thenReturn(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    MeasurableRatingPlannedDecommissionDao measurableRatingPlannedDecommissionDao =
        mock(MeasurableRatingPlannedDecommissionDao.class);
    when(measurableRatingPlannedDecommissionDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            measurableRatingdao,
            measurableRatingPlannedDecommissionDao,
            nameResolver);

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    changeLogService.writeChangeLogEntries(
        lastUpdatedByResult
            .plannedCommissionDate(
                java.util.Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(nameResolver, atLeast(1)).resolve(Mockito.<EntityReference>any());
    verify(changeLogDao).write(isA(Collection.class));
    verify(measurableRatingdao).getById(1L);
    verify(measurableRatingPlannedDecommissionDao).getById(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(PhysicalFlow, String, String, Operation)}
   * with {@code physicalFlow}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(PhysicalFlow, String,
   * String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(PhysicalFlow, String, String, Operation) with 'physicalFlow', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(PhysicalFlow, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithPhysicalFlowUserIdPostambleOperation() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult2
            .created(created2)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            physicalSpecificationDao,
            logicalFlowDao,
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created3);

    ImmutablePhysicalFlow.Builder externalIdResult2 =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    changeLogService.writeChangeLogEntries(
        specificationIdResult.transport(TransportKindValue.of("42")).build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(physicalSpecificationDao).getById(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(PhysicalFlow, String, String, Operation)}
   * with {@code physicalFlow}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(PhysicalFlow, String,
   * String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(PhysicalFlow, String, String, Operation) with 'physicalFlow', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(PhysicalFlow, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithPhysicalFlowUserIdPostambleOperation2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult2
            .created(created2)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(-2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            physicalSpecificationDao,
            logicalFlowDao,
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created3);

    ImmutablePhysicalFlow.Builder externalIdResult2 =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    changeLogService.writeChangeLogEntries(
        specificationIdResult.transport(TransportKindValue.of("42")).build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(logicalFlowDao).getByFlowId(1L);
    verify(physicalSpecificationDao).getById(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification, String, String,
   * Operation)} with {@code physicalSpec}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification,
   * String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(PhysicalSpecification, String, String, Operation) with 'physicalSpec', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(PhysicalSpecification, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithPhysicalSpecUserIdPostambleOperation() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());

    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    when(physicalFlowDao.findBySpecificationId(anyLong())).thenReturn(physicalFlowList);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            physicalFlowDao,
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    changeLogService.writeChangeLogEntries(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(physicalFlowDao).findBySpecificationId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification, String, String,
   * Operation)} with {@code physicalSpec}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification,
   * String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(PhysicalSpecification, String, String, Operation) with 'physicalSpec', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(PhysicalSpecification, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithPhysicalSpecUserIdPostambleOperation2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalFlow.Builder basisOffsetResult2 =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalFlow.Builder createdResult2 = basisOffsetResult2.created(created2);

    ImmutablePhysicalFlow.Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult2.transport(TransportKindValue.of("42")).build());

    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    when(physicalFlowDao.findBySpecificationId(anyLong())).thenReturn(physicalFlowList);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            physicalFlowDao,
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult3 =
        builderResult
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult3
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    changeLogService.writeChangeLogEntries(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(physicalFlowDao).findBySpecificationId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification, String, String,
   * Operation)} with {@code physicalSpec}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification,
   * String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(PhysicalSpecification, String, String, Operation) with 'physicalSpec', 'userId', 'postamble', 'operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(PhysicalSpecification, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithPhysicalSpecUserIdPostambleOperation3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalFlow.Builder basisOffsetResult2 =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalFlow.Builder createdResult2 = basisOffsetResult2.created(created2);

    ImmutablePhysicalFlow.Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(-2L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult2.transport(TransportKindValue.of("42")).build());

    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    when(physicalFlowDao.findBySpecificationId(anyLong())).thenReturn(physicalFlowList);

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            physicalFlowDao,
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult3 =
        builderResult
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult3
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    changeLogService.writeChangeLogEntries(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(physicalFlowDao).findBySpecificationId(1L);
  }

  /**
   * Test {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification, String, String,
   * Operation)} with {@code physicalSpec}, {@code userId}, {@code postamble}, {@code operation}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogService#writeChangeLogEntries(PhysicalSpecification,
   * String, String, Operation)}
   */
  @Test
  @DisplayName(
      "Test writeChangeLogEntries(PhysicalSpecification, String, String, Operation) with 'physicalSpec', 'userId', 'postamble', 'operation'; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeLogService.writeChangeLogEntries(PhysicalSpecification, String, String, Operation)"
  })
  void testWriteChangeLogEntriesWithPhysicalSpecUserIdPostambleOperation_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    when(physicalFlowDao.findBySpecificationId(anyLong())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            physicalFlowDao,
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    changeLogService.writeChangeLogEntries(
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build(),
        "42",
        "Postamble",
        Operation.ADD);

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(physicalFlowDao).findBySpecificationId(1L);
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector3() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_givenActive() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_givenInHouse() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_givenPending() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'APPLICATION'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenApplication_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.APPLICATION, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'CHANGE_INITIATIVE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenChangeInitiative_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'CHANGE_INITIATIVE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenChangeInitiative_thenReturnEmpty2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'CHANGE_UNIT'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenChangeUnit_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.CHANGE_UNIT, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'CHANGE_UNIT'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenChangeUnit_thenReturnEmpty2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.CHANGE_UNIT, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'FLOW_DIAGRAM'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenFlowDiagram_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.FLOW_DIAGRAM, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code LICENCE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'LICENCE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenLicence_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.LICENCE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'LOGICAL_DATA_FLOW'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenLogicalDataFlow_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code LOGICAL_DATA_FLOW}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'LOGICAL_DATA_FLOW'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenLogicalDataFlow_thenReturnEmpty2() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogService#findCountByDateForParentKindBySelector(EntityKind,
   * IdSelectionOptions, Optional)}.
   *
   * <ul>
   *   <li>When {@code MEASURABLE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeLogService#findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional); when 'MEASURABLE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogService.findCountByDateForParentKindBySelector(EntityKind, IdSelectionOptions, Optional)"
  })
  void testFindCountByDateForParentKindBySelector_whenMeasurable_thenReturnEmpty() {
    // Arrange
    ChangeLogSummariesDao changeLogSummariesDao = mock(ChangeLogSummariesDao.class);
    when(changeLogSummariesDao.findCountByDateForParentKindBySelector(
            Mockito.<GenericSelector>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            changeLogSummariesDao,
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<DateTally> actualFindCountByDateForParentKindBySelectorResult =
        changeLogService.findCountByDateForParentKindBySelector(
            EntityKind.MEASURABLE, selectionOptions, limit);

    // Assert
    verify(changeLogSummariesDao)
        .findCountByDateForParentKindBySelector(isA(GenericSelector.class), isA(Optional.class));
    assertTrue(actualFindCountByDateForParentKindBySelectorResult.isEmpty());
  }
}
