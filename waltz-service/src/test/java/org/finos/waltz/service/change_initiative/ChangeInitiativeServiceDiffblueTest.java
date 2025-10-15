package org.finos.waltz.service.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.change_initiative.search.ChangeInitiativeSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.change_initiative.ChangeInitiative;
import org.finos.waltz.model.change_initiative.ChangeInitiativeKind;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipChangeCommand;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipChangeCommand;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeInitiativeServiceDiffblueTest {
  @Mock private ChangeInitiativeDao changeInitiativeDao;

  @Mock private ChangeInitiativeSearchDao changeInitiativeSearchDao;

  @InjectMocks private ChangeInitiativeService changeInitiativeService;

  @Mock private ChangeLogService changeLogService;

  @Mock private EntityRelationshipDao entityRelationshipDao;

  /**
   * Test {@link ChangeInitiativeService#getById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableChangeInitiative}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then return ImmutableChangeInitiative")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeInitiative ChangeInitiativeService.getById(Long)"})
  void testGetById_thenReturnImmutableChangeInitiative() {
    // Arrange
    ImmutableChangeInitiative.Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    ImmutableChangeInitiative.Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    ImmutableChangeInitiative.Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    when(changeInitiativeDao.getById(Mockito.<Long>any()))
        .thenReturn(
            provenanceResult
                .startDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());

    // Act
    ChangeInitiative actualById = changeInitiativeService.getById(1L);

    // Assert
    verify(changeInitiativeDao).getById(1L);
    assertTrue(actualById instanceof ImmutableChangeInitiative);
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualById.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualById.changeInitiativeKind());
  }

  /**
   * Test {@link ChangeInitiativeService#getById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeInitiative ChangeInitiativeService.getById(Long)"})
  void testGetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeDao.getById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> changeInitiativeService.getById(1L));
    verify(changeInitiativeDao).getById(1L);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult =
        changeInitiativeService.findForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector2() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult =
        changeInitiativeService.findForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector3() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult =
        changeInitiativeService.findForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector4() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult =
        changeInitiativeService.findForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.CHILDREN)
                .build());

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector5() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult =
        changeInitiativeService.findForSelector(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector6() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult =
        changeInitiativeService.findForSelector(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            changeInitiativeService.findForSelector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findHierarchyForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult =
        changeInitiativeService.findHierarchyForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findHierarchyForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector2() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult =
        changeInitiativeService.findHierarchyForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findHierarchyForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector3() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult =
        changeInitiativeService.findHierarchyForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findHierarchyForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector4() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

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

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult =
        changeInitiativeService.findHierarchyForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.CHILDREN)
                .build());

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findHierarchyForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector5() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult =
        changeInitiativeService.findHierarchyForSelector(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findHierarchyForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector6() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult =
        changeInitiativeService.findHierarchyForSelector(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findHierarchyForSelector(IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ChangeInitiativeService.findHierarchyForSelector(IdSelectionOptions)"
  })
  void testFindHierarchyForSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            changeInitiativeService.findHierarchyForSelector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
  }

  /**
   * Test {@link ChangeInitiativeService#search(EntitySearchOptions)} with {@code options}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.search(EntitySearchOptions)"})
  void testSearchWithOptions_thenReturnList() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(changeInitiativeList);

    // Act
    Collection<ChangeInitiative> actualSearchResult =
        changeInitiativeService.search((EntitySearchOptions) null);

    // Assert
    verify(changeInitiativeSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(changeInitiativeList, actualSearchResult);
  }

  /**
   * Test {@link ChangeInitiativeService#search(EntitySearchOptions)} with {@code options}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions) with 'options'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.search(EntitySearchOptions)"})
  void testSearchWithOptions_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> changeInitiativeService.search((EntitySearchOptions) null));
    verify(changeInitiativeSearchDao).search(isNull());
  }

  /**
   * Test {@link ChangeInitiativeService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Given {@link ChangeInitiativeSearchDao}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#search(String)}
   */
  @Test
  @DisplayName(
      "Test search(String) with 'query'; given ChangeInitiativeSearchDao; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.search(String)"})
  void testSearchWithQuery_givenChangeInitiativeSearchDao_whenEmptyString() {
    // Arrange and Act
    Collection<ChangeInitiative> actualSearchResult = changeInitiativeService.search("");

    // Assert
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ChangeInitiativeService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.search(String)"})
  void testSearchWithQuery_thenReturnArrayList() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(changeInitiativeList);

    // Act
    Collection<ChangeInitiative> actualSearchResult = changeInitiativeService.search("Query");

    // Assert
    verify(changeInitiativeSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(changeInitiativeList, actualSearchResult);
  }

  /**
   * Test {@link ChangeInitiativeService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.search(String)"})
  void testSearchWithQuery_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> changeInitiativeService.search("Query"));
    verify(changeInitiativeSearchDao).search(isA(EntitySearchOptions.class));
  }

  /**
   * Test {@link ChangeInitiativeService#getRelatedEntitiesForId(long)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#getRelatedEntitiesForId(long)}
   */
  @Test
  @DisplayName("Test getRelatedEntitiesForId(long); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.getRelatedEntitiesForId(long)"})
  void testGetRelatedEntitiesForId_thenReturnList() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualRelatedEntitiesForId =
        changeInitiativeService.getRelatedEntitiesForId(1L);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualRelatedEntitiesForId instanceof List);
    assertTrue(actualRelatedEntitiesForId.isEmpty());
    assertSame(entityRelationshipList, actualRelatedEntitiesForId);
  }

  /**
   * Test {@link ChangeInitiativeService#getRelatedEntitiesForId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#getRelatedEntitiesForId(long)}
   */
  @Test
  @DisplayName("Test getRelatedEntitiesForId(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.getRelatedEntitiesForId(long)"})
  void testGetRelatedEntitiesForId_thenThrowIllegalArgumentException() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> changeInitiativeService.getRelatedEntitiesForId(1L));
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
  }

  /**
   * Test {@link ChangeInitiativeService#addEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#addEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName("Test addEntityRelationship(long, EntityRelationshipChangeCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.addEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testAddEntityRelationship() {
    // Arrange
    ImmutableEntityRelationshipChangeCommand.Builder builderResult =
        ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            changeInitiativeService.addEntityRelationship(
                1L,
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
                    .operation(Operation.ADD)
                    .relationship(RelationshipKind.HAS)
                    .build(),
                "janedoe"));
  }

  /**
   * Test {@link ChangeInitiativeService#addEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link EntityRelationshipChangeCommand#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#addEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test addEntityRelationship(long, EntityRelationshipChangeCommand, String); given IllegalArgumentException(); then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.addEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testAddEntityRelationship_givenIllegalArgumentException_thenCallsEntityReference() {
    // Arrange
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> changeInitiativeService.addEntityRelationship(1L, command, "janedoe"));
    verify(command).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName("Test removeEntityRelationship(long, EntityRelationshipChangeCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.removeEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testRemoveEntityRelationship() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableEntityRelationshipChangeCommand.Builder builderResult =
        ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            changeInitiativeService.removeEntityRelationship(
                1L,
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
                    .operation(Operation.ADD)
                    .relationship(RelationshipKind.HAS)
                    .build(),
                "janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName("Test removeEntityRelationship(long, EntityRelationshipChangeCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.removeEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testRemoveEntityRelationship2() {
    // Arrange
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any()))
        .thenThrow(new IllegalArgumentException());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableEntityRelationshipChangeCommand.Builder builderResult =
        ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            changeInitiativeService.removeEntityRelationship(
                1L,
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
                    .operation(Operation.ADD)
                    .relationship(RelationshipKind.HAS)
                    .build(),
                "janedoe"));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test removeEntityRelationship(long, EntityRelationshipChangeCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.removeEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testRemoveEntityRelationship_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            mock(ChangeInitiativeDao.class),
            mock(ChangeInitiativeSearchDao.class),
            relationshipDao,
            changeLogService);

    ImmutableEntityRelationshipChangeCommand.Builder builderResult =
        ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    boolean actualRemoveEntityRelationshipResult =
        changeInitiativeService.removeEntityRelationship(
            1L,
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
                .operation(Operation.ADD)
                .relationship(RelationshipKind.HAS)
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).remove(isA(EntityRelationshipKey.class));
    assertTrue(actualRemoveEntityRelationshipResult);
  }

  /**
   * Test {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelationshipChangeCommand#entityReference()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test removeEntityRelationship(long, EntityRelationshipChangeCommand, String); then calls entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.removeEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testRemoveEntityRelationship_thenCallsEntityReference() {
    // Arrange
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> changeInitiativeService.removeEntityRelationship(1L, command, "janedoe"));
    verify(command).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test removeEntityRelationship(long, EntityRelationshipChangeCommand, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.removeEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testRemoveEntityRelationship_thenReturnFalse() {
    // Arrange
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(false);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableEntityRelationshipChangeCommand.Builder builderResult =
        ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    boolean actualRemoveEntityRelationshipResult =
        changeInitiativeService.removeEntityRelationship(
            1L,
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
                .operation(Operation.ADD)
                .relationship(RelationshipKind.HAS)
                .build(),
            "janedoe");

    // Assert
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualRemoveEntityRelationshipResult);
  }

  /**
   * Test {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#removeEntityRelationship(long,
   * EntityRelationshipChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test removeEntityRelationship(long, EntityRelationshipChangeCommand, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ChangeInitiativeService.removeEntityRelationship(long, EntityRelationshipChangeCommand, String)"
  })
  void testRemoveEntityRelationship_thenReturnTrue() {
    // Arrange
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableEntityRelationshipChangeCommand.Builder builderResult =
        ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    boolean actualRemoveEntityRelationshipResult =
        changeInitiativeService.removeEntityRelationship(
            1L,
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
                .operation(Operation.ADD)
                .relationship(RelationshipKind.HAS)
                .build(),
            "janedoe");

    // Assert
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveEntityRelationshipResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findByExternalId(String)"})
  void testFindByExternalId_thenReturnList() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findByExternalId(Mockito.<String>any()))
        .thenReturn(changeInitiativeList);

    // Act
    Collection<ChangeInitiative> actualFindByExternalIdResult =
        changeInitiativeService.findByExternalId("42");

    // Assert
    verify(changeInitiativeDao).findByExternalId("42");
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(changeInitiativeList, actualFindByExternalIdResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findByExternalId(String)"})
  void testFindByExternalId_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeDao.findByExternalId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> changeInitiativeService.findByExternalId("42"));
    verify(changeInitiativeDao).findByExternalId("42");
  }

  /**
   * Test {@link ChangeInitiativeService#findAll()}.
   *
   * <ul>
   *   <li>Given {@link ChangeInitiativeDao} {@link ChangeInitiativeDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given ChangeInitiativeDao findAll() return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findAll()"})
  void testFindAll_givenChangeInitiativeDaoFindAllReturnArrayList_thenReturnList() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findAll()).thenReturn(changeInitiativeList);

    // Act
    Collection<ChangeInitiative> actualFindAllResult = changeInitiativeService.findAll();

    // Assert
    verify(changeInitiativeDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(changeInitiativeList, actualFindAllResult);
  }

  /**
   * Test {@link ChangeInitiativeService#findAll()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ChangeInitiativeService.findAll()"})
  void testFindAll_thenThrowIllegalArgumentException() {
    // Arrange
    when(changeInitiativeDao.findAll()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> changeInitiativeService.findAll());
    verify(changeInitiativeDao).findAll();
  }

  /**
   * Test {@link ChangeInitiativeService#findEntriesForAppGroup(long)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findEntriesForAppGroup(long)}
   */
  @Test
  @DisplayName("Test findEntriesForAppGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeInitiativeService.findEntriesForAppGroup(long)"})
  void testFindEntriesForAppGroup() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    List<AppGroupEntry> actualFindEntriesForAppGroupResult =
        changeInitiativeService.findEntriesForAppGroup(1L);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindEntriesForAppGroupResult.isEmpty());
  }

  /**
   * Test {@link ChangeInitiativeService#findEntriesForAppGroup(long)}.
   *
   * <p>Method under test: {@link ChangeInitiativeService#findEntriesForAppGroup(long)}
   */
  @Test
  @DisplayName("Test findEntriesForAppGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeInitiativeService.findEntriesForAppGroup(long)"})
  void testFindEntriesForAppGroup2() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    ImmutableEntityRelationship.Builder builderResult = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    ImmutableEntityRelationship.Builder builderResult2 = ImmutableEntityRelationship.builder();

    ImmutableEntityRelationship.Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    List<AppGroupEntry> actualFindEntriesForAppGroupResult =
        changeInitiativeService.findEntriesForAppGroup(1L);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindEntriesForAppGroupResult.isEmpty());
  }

  /**
   * Test {@link ChangeInitiativeService#findEntriesForAppGroup(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findEntriesForAppGroup(long)}
   */
  @Test
  @DisplayName("Test findEntriesForAppGroup(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeInitiativeService.findEntriesForAppGroup(long)"})
  void testFindEntriesForAppGroup_thenReturnEmpty() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AppGroupEntry> actualFindEntriesForAppGroupResult =
        changeInitiativeService.findEntriesForAppGroup(1L);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindEntriesForAppGroupResult.isEmpty());
  }

  /**
   * Test {@link ChangeInitiativeService#findEntriesForAppGroup(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeInitiativeService#findEntriesForAppGroup(long)}
   */
  @Test
  @DisplayName("Test findEntriesForAppGroup(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeInitiativeService.findEntriesForAppGroup(long)"})
  void testFindEntriesForAppGroup_thenThrowIllegalArgumentException() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> changeInitiativeService.findEntriesForAppGroup(1L));
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
  }
}
