package org.finos.waltz.service.complexity_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.complexity.ComplexityKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableSelectionFilters.Builder;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.complexity.ComplexityKind;
import org.finos.waltz.model.complexity.ImmutableComplexityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ComplexityKindServiceDiffblueTest {
  @Mock private ComplexityKindDao complexityKindDao;

  @InjectMocks private ComplexityKindService complexityKindService;

  /**
   * Test {@link ComplexityKindService#findAll()}.
   *
   * <p>Method under test: {@link ComplexityKindService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findAll()"})
  void testFindAll() {
    // Arrange
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<ComplexityKind> actualFindAllResult = complexityKindService.findAll();

    // Assert
    verify(complexityKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#getById(Long)}.
   *
   * <p>Method under test: {@link ComplexityKindService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplexityKind ComplexityKindService.getById(Long)"})
  void testGetById() {
    // Arrange
    when(complexityKindDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ComplexityKind actualById = complexityKindService.getById(1L);

    // Assert
    verify(complexityKindDao).getById(1L);
    assertTrue(actualById instanceof ImmutableComplexityKind);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertTrue(actualById.isDefault());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector3() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector4() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector5() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector6() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector7() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
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
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector8() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code CHILDREN}.
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given 'CHILDREN'; then calls joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenChildren_thenCallsJoiningEntityKind() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddActive() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddPending() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddPending2() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(EntityKind, IdSelectionOptions); given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddRemoved() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ComplexityKindService#findBySelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.
   * </ul>
   *
   * <p>Method under test: {@link ComplexityKindService#findBySelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(EntityKind, IdSelectionOptions); given of 'ALL'; then calls joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ComplexityKindService.findBySelector(EntityKind, IdSelectionOptions)"})
  void testFindBySelector_givenOfAll_thenCallsJoiningEntityKind() {
    // Arrange
    when(complexityKindDao.findBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
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
    Set<ComplexityKind> actualFindBySelectorResult =
        complexityKindService.findBySelector(EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(complexityKindDao).findBySelector(isA(GenericSelector.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }
}
