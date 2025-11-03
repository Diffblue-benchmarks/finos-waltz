package org.finos.waltz.data.change_initiative;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChangeInitiativeIdSelectorFactoryDiffblueTest {
  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsEntityLifecycleStatuses() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsEntityLifecycleStatuses2() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsId() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsKind() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsScope() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsScope2() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test new {@link ChangeInitiativeIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new ChangeInitiativeIdSelectorFactory (default constructor); then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChangeInitiativeIdSelectorFactory.<init>()"})
  void testNewChangeInitiativeIdSelectorFactory_thenCallsScope3() {
    // Arrange and Act
    ChangeInitiativeIdSelectorFactory actualChangeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);
    actualChangeInitiativeIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("foo"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> changeInitiativeIdSelectorFactory.mkForOptions(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code CHILDREN}.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given 'CHILDREN'; when IdSelectionOptions scope() return 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenChildren_whenIdSelectionOptionsScopeReturnChildren() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#joiningEntityKind()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given empty; when IdSelectionOptions joiningEntityKind() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEmpty_whenIdSelectionOptionsJoiningEntityKindReturnEmpty() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} throw {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference id() throw UnsupportedOperationException(String) with 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceIdThrowUnsupportedOperationExceptionWithId() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("id"));
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> changeInitiativeIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ACTOR}.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ACTOR'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnActor_thenCallsId() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code AGGREGATE_OVERLAY_DIAGRAM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'AGGREGATE_OVERLAY_DIAGRAM'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAggregateOverlayDiagram() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> changeInitiativeIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   *   <li>Then calls {@link EntityReference#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'ALL'; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnAll_thenCallsKind() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code CHANGE_INITIATIVE}.</li>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given EntityReference kind() return 'CHANGE_INITIATIVE'; then calls scope()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenEntityReferenceKindReturnChangeInitiative_thenCallsScope() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.</li>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenHashSetAddActive_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }

  /**
   * Test {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code ALL}.</li>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions); given Optional with 'ALL'; then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select ChangeInitiativeIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenOptionalWithAll_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ChangeInitiativeIdSelectorFactory changeInitiativeIdSelectorFactory = new ChangeInitiativeIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(mock(SelectionFilters.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    changeInitiativeIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
  }
}
