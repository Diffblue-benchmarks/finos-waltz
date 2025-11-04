package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.Test;

class GenericSelectorFactoryDiffblueTest {
  /**
   * Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
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
   * Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
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
   * Method under test: {@link GenericSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply3() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new GenericSelectorFactory()).applyForKind(EntityKind.ALL, mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind2() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind3() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind4() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind5() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind6() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind7() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind8() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind9() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind10() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind11() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind12() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind13() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind14() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind15() {
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind16() {
    // Arrange
    GenericSelectorFactory genericSelectorFactory = new GenericSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
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
   * Method under test:
   * {@link GenericSelectorFactory#applyForKind(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testApplyForKind17() {
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
}
