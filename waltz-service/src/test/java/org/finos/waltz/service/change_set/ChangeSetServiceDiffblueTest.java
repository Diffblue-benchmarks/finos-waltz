package org.finos.waltz.service.change_set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.change_set.ChangeSetDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.change_set.ChangeSet;
import org.finos.waltz.model.change_set.ImmutableChangeSet;
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
class ChangeSetServiceDiffblueTest {
  @Mock private ChangeSetDao changeSetDao;

  @InjectMocks private ChangeSetService changeSetService;

  /**
   * Test {@link ChangeSetService#getById(long)}.
   *
   * <p>Method under test: {@link ChangeSetService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeSet ChangeSetService.getById(long)"})
  void testGetById() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableChangeSet.Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    when(changeSetDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .parentEntity(parentEntity)
                .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Act
    ChangeSet actualById = new ChangeSetService(changeSetDao).getById(1L);

    // Assert
    verify(changeSetDao).getById(1L);
    assertTrue(actualById instanceof ImmutableChangeSet);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ChangeSetService#findByParentRef(EntityReference)}.
   *
   * <p>Method under test: {@link ChangeSetService#findByParentRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByParentRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findByParentRef(EntityReference)"})
  void testFindByParentRef() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findByParentRef(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ChangeSet> actualFindByParentRefResult =
        new ChangeSetService(changeSetDao).findByParentRef(null);

    // Assert
    verify(changeSetDao).findByParentRef(isNull());
    assertTrue(actualFindByParentRefResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);

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
    List<ChangeSet> actualFindBySelectorResult =
        changeSetService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());

    // Act
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);

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

    // Act
    List<ChangeSet> actualFindBySelectorResult =
        changeSetService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'EXACT'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenExact_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given 'EXACT'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenExact_thenCallsScope() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    List<ChangeSet> actualFindBySelectorResult = changeSetService.findBySelector(options);

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeSetService changeSetService = new ChangeSetService(changeSetDao);

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

    // Act
    List<ChangeSet> actualFindBySelectorResult =
        changeSetService.findBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(changeSetDao).findBySelector(isA(Select.class));
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeSetService#findByPerson(String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeSetDao} {@link ChangeSetDao#findByPerson(String)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeSetService#findByPerson(String)}
   */
  @Test
  @DisplayName(
      "Test findByPerson(String); given ChangeSetDao findByPerson(String) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeSetService.findByPerson(String)"})
  void testFindByPerson_givenChangeSetDaoFindByPersonReturnArrayList_thenReturnEmpty() {
    // Arrange
    ChangeSetDao changeSetDao = mock(ChangeSetDao.class);
    when(changeSetDao.findByPerson(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<ChangeSet> actualFindByPersonResult =
        new ChangeSetService(changeSetDao).findByPerson("42");

    // Assert
    verify(changeSetDao).findByPerson("42");
    assertTrue(actualFindByPersonResult.isEmpty());
  }
}
