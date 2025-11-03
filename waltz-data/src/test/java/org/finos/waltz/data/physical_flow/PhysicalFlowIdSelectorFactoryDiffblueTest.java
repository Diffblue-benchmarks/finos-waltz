package org.finos.waltz.data.physical_flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
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

class PhysicalFlowIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalFlowIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ACTOR}.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'ACTOR'; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnActor_thenCallsId() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnAll() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalFlowIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code APPLICATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'APPLICATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnApplication() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code CHANGE_INITIATIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'CHANGE_INITIATIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnChangeInitiative() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code CHANGE_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'CHANGE_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnChangeSet() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_SET);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code IN_HOUSE}.</li>
   *   <li>Then calls {@link IdSelectionOptions#filters()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'IN_HOUSE'; then calls filters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddInHouse_thenCallsFilters() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.</li>
   *   <li>Then calls {@link IdSelectionOptions#filters()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'REMOVED'; then calls filters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddRemoved_thenCallsFilters() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#filters()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; then calls filters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_thenCallsFilters() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getLifecycleCondition(IdSelectionOptions); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition PhysicalFlowIdSelectorFactory.getLifecycleCondition(IdSelectionOptions)"})
  void testGetLifecycleCondition_givenHashSet() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());

    // Act
    physicalFlowIdSelectorFactory.getLifecycleCondition(options);

    // Assert
    verify(options).entityLifecycleStatuses();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getLifecycleCondition(IdSelectionOptions); given HashSet() add 'REMOVED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition PhysicalFlowIdSelectorFactory.getLifecycleCondition(IdSelectionOptions)"})
  void testGetLifecycleCondition_givenHashSetAddRemoved() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    entityLifecycleStatusSet.addAll(new ArrayList<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);

    // Act
    physicalFlowIdSelectorFactory.getLifecycleCondition(options);

    // Assert
    verify(options).entityLifecycleStatuses();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getLifecycleCondition(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition PhysicalFlowIdSelectorFactory.getLifecycleCondition(IdSelectionOptions)"})
  void testGetLifecycleCondition_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory = new PhysicalFlowIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalFlowIdSelectorFactory.getLifecycleCondition(options));
    verify(options).entityLifecycleStatuses();
  }
}
