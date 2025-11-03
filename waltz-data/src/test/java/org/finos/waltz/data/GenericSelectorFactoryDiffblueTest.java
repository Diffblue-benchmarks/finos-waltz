package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GenericSelectorFactoryDiffblueTest {
  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} throw {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code kind}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions); given EntityReference id() throw UnsupportedOperationException(String) with 'kind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_givenEntityReferenceIdThrowUnsupportedOperationExceptionWithKind() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("kind"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> genericSelectorFactory.apply(selectionOptions));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code EXACT}.</li>
   *   <li>Then return {@link ImmutableGenericSelector}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions); given 'EXACT'; then return ImmutableGenericSelector")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_givenExact_thenReturnImmutableGenericSelector() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyResult = genericSelectorFactory.apply(selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.ALL, actualApplyResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#apply(IdSelectionOptions)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.apply(IdSelectionOptions)"})
  void testApply_thenThrowUnsupportedOperationException() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> genericSelectorFactory.apply(selectionOptions));
    verify(entityReference).kind();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code CHILDREN}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
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

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given empty; when IdSelectionOptions joiningEntityKind() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenEmpty_whenIdSelectionOptionsJoiningEntityKindReturnEmpty() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(selectionOptions.joiningEntityKind()).thenReturn(emptyResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ACTOR}.</li>
   *   <li>Then return kind is {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given EntityReference kind() return 'ACTOR'; then return kind is 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenEntityReferenceKindReturnActor_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
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

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   *   <li>Then return kind is {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given EntityReference kind() return 'ALL'; then return kind is 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenEntityReferenceKindReturnAll_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given EntityReference kind() return 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenEntityReferenceKindReturnApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.</li>
   *   <li>Then return kind is {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'; then return kind is 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenHashSetAddActive_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code IN_HOUSE}.</li>
   *   <li>Then return kind is {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given HashSet() add 'IN_HOUSE'; then return kind is 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenHashSetAddInHouse_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
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

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.</li>
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'; then calls joiningEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenHashSetAddPending_thenCallsJoiningEntityKind() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.</li>
   *   <li>Then return kind is {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'; then return kind is 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenHashSetAddPending_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link SelectionFilters}.</li>
   *   <li>Then calls {@link IdSelectionOptions#joiningEntityKind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); given SelectionFilters; then calls joiningEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_givenSelectionFilters_thenCallsJoiningEntityKind() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
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

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Then return kind is {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); then return kind is 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_thenReturnKindIsApplication() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
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

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.APPLICATION,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.APPLICATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Then return kind is {@code CHANGE_INITIATIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); then return kind is 'CHANGE_INITIATIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_thenReturnKindIsChangeInitiative() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>Then return kind is {@code CHANGE_INITIATIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); then return kind is 'CHANGE_INITIATIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_thenReturnKindIsChangeInitiative2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_INITIATIVE,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_INITIATIVE, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>When {@code ALL}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); when 'ALL'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_whenAll_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new GenericSelectorFactory()).applyForKind(EntityKind.ALL, mock(IdSelectionOptions.class)));
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>When {@code ATTESTATION}.</li>
   *   <li>Then return kind is {@code ATTESTATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); when 'ATTESTATION'; then return kind is 'ATTESTATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_whenAttestation_thenReturnKindIsAttestation() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
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

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.ATTESTATION,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.ATTESTATION, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.</li>
   *   <li>Then return kind is {@code CHANGE_UNIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then return kind is 'CHANGE_UNIT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_whenChangeUnit_thenReturnKindIsChangeUnit() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_UNIT,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.</li>
   *   <li>Then return kind is {@code CHANGE_UNIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then return kind is 'CHANGE_UNIT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_whenChangeUnit_thenReturnKindIsChangeUnit2() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.CHANGE_UNIT,
        selectionOptions);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.CHANGE_UNIT, actualApplyForKindResult.kind());
  }

  /**
   * Test {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}.
   * <ul>
   *   <li>When {@code FLOW_DIAGRAM}.</li>
   *   <li>Then return kind is {@code FLOW_DIAGRAM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test applyForKind(EntityKind, IdSelectionOptions); when 'FLOW_DIAGRAM'; then return kind is 'FLOW_DIAGRAM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GenericSelector GenericSelectorFactory.applyForKind(EntityKind, IdSelectionOptions)"})
  void testApplyForKind_whenFlowDiagram_thenReturnKindIsFlowDiagram() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    GenericSelector actualApplyForKindResult = genericSelectorFactory.applyForKind(EntityKind.FLOW_DIAGRAM,
        selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualApplyForKindResult instanceof ImmutableGenericSelector);
    assertEquals(EntityKind.FLOW_DIAGRAM, actualApplyForKindResult.kind());
  }
}
