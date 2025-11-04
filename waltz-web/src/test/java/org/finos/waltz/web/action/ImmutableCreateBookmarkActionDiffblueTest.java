package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.bookmark.Bookmark;
import org.junit.jupiter.api.Test;

class ImmutableCreateBookmarkActionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCreateBookmarkAction.Builder#bookmark(Bookmark)}
   */
  @Test
  void testBuilderBookmark() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();
    Bookmark bookmark = mock(Bookmark.class);

    // Act
    ImmutableCreateBookmarkAction.Builder actualBookmarkResult = builderResult.bookmark(bookmark);

    // Assert
    assertSame(builderResult, actualBookmarkResult);
    assertSame(bookmark, actualBookmarkResult.build().bookmark());
    assertSame(bookmark, builderResult.build().bookmark());
  }

  /**
   * Method under test:
   * {@link ImmutableCreateBookmarkAction.Builder#from(CreateBookmarkAction)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();
    CreateBookmarkAction instance = mock(CreateBookmarkAction.class);
    when(instance.bookmark()).thenReturn(mock(Bookmark.class));

    // Act
    ImmutableCreateBookmarkAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).bookmark();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCreateBookmarkAction#copyOf(CreateBookmarkAction)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CreateBookmarkAction instance = mock(CreateBookmarkAction.class);
    when(instance.bookmark()).thenReturn(mock(Bookmark.class));

    // Act
    ImmutableCreateBookmarkAction.copyOf(instance);

    // Assert
    verify(instance).bookmark();
  }

  /**
   * Method under test:
   * {@link ImmutableCreateBookmarkAction#fromJson(ImmutableCreateBookmarkAction.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCreateBookmarkAction.Json json = new ImmutableCreateBookmarkAction.Json();
    json.setBookmark(mock(Bookmark.class));

    // Act and Assert
    Bookmark expectedBookmarkResult = json.bookmark;
    assertSame(expectedBookmarkResult, ImmutableCreateBookmarkAction.fromJson(json).bookmark());
  }

  /**
   * Method under test: {@link ImmutableCreateBookmarkAction.Json#bookmark()}
   */
  @Test
  void testJsonBookmark() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCreateBookmarkAction.Json()).bookmark());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableCreateBookmarkAction.Json}
   *   <li>{@link ImmutableCreateBookmarkAction.Json#setBookmark(Bookmark)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCreateBookmarkAction.Json actualJson = new ImmutableCreateBookmarkAction.Json();
    actualJson.setBookmark(null);

    // Assert
    assertNull(actualJson.bookmark);
  }
}
