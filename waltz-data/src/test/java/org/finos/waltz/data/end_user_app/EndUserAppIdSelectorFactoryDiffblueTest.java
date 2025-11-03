package org.finos.waltz.data.end_user_app;

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

class EndUserAppIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select EndUserAppIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new IllegalArgumentException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> endUserAppIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select EndUserAppIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenChildren() {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    endUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select EndUserAppIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEmpty() {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    endUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select EndUserAppIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceIdReturnOne_thenCallsId() {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    endUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select EndUserAppIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnAll() {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> endUserAppIdSelectorFactory.apply(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EndUserAppIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'ACTIVE'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select EndUserAppIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddActive_thenCallsId() {
    // Arrange
    EndUserAppIdSelectorFactory endUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    endUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test new {@link EndUserAppIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link EndUserAppIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new EndUserAppIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EndUserAppIdSelectorFactory.<init>()"})
  void testNewEndUserAppIdSelectorFactory_thenCallsId() {
    // Arrange and Act
    EndUserAppIdSelectorFactory actualEndUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);
    actualEndUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test new {@link EndUserAppIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link EndUserAppIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new EndUserAppIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EndUserAppIdSelectorFactory.<init>()"})
  void testNewEndUserAppIdSelectorFactory_thenCallsId2() {
    // Arrange and Act
    EndUserAppIdSelectorFactory actualEndUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);
    actualEndUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test new {@link EndUserAppIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link EndUserAppIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new EndUserAppIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EndUserAppIdSelectorFactory.<init>()"})
  void testNewEndUserAppIdSelectorFactory_thenCallsId3() {
    // Arrange and Act
    EndUserAppIdSelectorFactory actualEndUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);
    actualEndUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test new {@link EndUserAppIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link EndUserAppIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new EndUserAppIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EndUserAppIdSelectorFactory.<init>()"})
  void testNewEndUserAppIdSelectorFactory_thenCallsId4() {
    // Arrange and Act
    EndUserAppIdSelectorFactory actualEndUserAppIdSelectorFactory = new EndUserAppIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);
    actualEndUserAppIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }
}
