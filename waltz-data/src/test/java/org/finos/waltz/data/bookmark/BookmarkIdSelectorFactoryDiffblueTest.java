package org.finos.waltz.data.bookmark;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class BookmarkIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link BookmarkIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
    // Arrange
    BookmarkIdSelectorFactory bookmarkIdSelectorFactory = new BookmarkIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    bookmarkIdSelectorFactory.apply(selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Method under test:
   * {@link BookmarkIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
    // Arrange
    BookmarkIdSelectorFactory bookmarkIdSelectorFactory = new BookmarkIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    bookmarkIdSelectorFactory.apply(selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).scope();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BookmarkIdSelectorFactory}
   */
  @Test
  void testNewBookmarkIdSelectorFactory() {
    // Arrange and Act
    BookmarkIdSelectorFactory actualBookmarkIdSelectorFactory = new BookmarkIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    actualBookmarkIdSelectorFactory.apply(selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BookmarkIdSelectorFactory}
   */
  @Test
  void testNewBookmarkIdSelectorFactory2() {
    // Arrange and Act
    BookmarkIdSelectorFactory actualBookmarkIdSelectorFactory = new BookmarkIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);
    actualBookmarkIdSelectorFactory.apply(selectionOptions);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).scope();
  }
}
