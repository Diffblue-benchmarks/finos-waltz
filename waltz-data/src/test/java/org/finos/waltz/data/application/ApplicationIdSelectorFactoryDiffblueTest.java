package org.finos.waltz.data.application;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ApplicationIdSelectorFactory.class})
@ExtendWith(SpringExtension.class)
class ApplicationIdSelectorFactoryDiffblueTest {
  @Autowired
  private ApplicationIdSelectorFactory applicationIdSelectorFactory;

  /**
   * Method under test:
   * {@link ApplicationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> applicationIdSelectorFactory.apply(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    applicationIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new IllegalArgumentException("options cannot be null"));
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> applicationIdSelectorFactory.apply(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply4() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> applicationIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectorFactory#mkForAppGroup(IdSelectionOptions)}
   */
  @Test
  void testMkForAppGroup() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ApplicationIdSelectorFactory.mkForAppGroup(options));
    verify(options, atLeast(1)).scope();
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectorFactory#mkForAppGroup(IdSelectionOptions)}
   */
  @Test
  void testMkForAppGroup2() {
    // Arrange
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    ApplicationIdSelectorFactory.mkForAppGroup(options);

    // Assert
    verify(entityReference, atLeast(1)).id();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
  }
}
