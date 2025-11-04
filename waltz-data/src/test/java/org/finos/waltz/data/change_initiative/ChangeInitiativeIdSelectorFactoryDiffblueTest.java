package org.finos.waltz.data.change_initiative;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.junit.jupiter.api.Test;

class ChangeInitiativeIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions2() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions3() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions4() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions5() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions6() {
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

  /**
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions7() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions8() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions9() {
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
   * Method under test:
   * {@link ChangeInitiativeIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions10() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory2() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory3() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory4() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory5() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory6() {
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
   * Method under test: default or parameterless constructor of
   * {@link ChangeInitiativeIdSelectorFactory}
   */
  @Test
  void testNewChangeInitiativeIdSelectorFactory7() {
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
}
