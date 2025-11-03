package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.web.action.ImmutableCreateBookmarkAction.Builder;
import org.finos.waltz.web.action.ImmutableCreateBookmarkAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCreateBookmarkActionDiffblueTest {
  /**
   * Test Builder {@link Builder#bookmark(Bookmark)}.
   * <ul>
   *   <li>When {@link Bookmark}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#bookmark(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder bookmark(Bookmark); when Bookmark; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.bookmark(Bookmark)"})
  void testBuilderBookmark_whenBookmark_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCreateBookmarkAction.builder();
    Bookmark bookmark = mock(Bookmark.class);

    // Act and Assert
    assertSame(builderResult, builderResult.bookmark(bookmark));
    assertSame(bookmark, builderResult.build().bookmark());
  }

  /**
   * Test Builder {@link Builder#from(CreateBookmarkAction)}.
   * <ul>
   *   <li>Given {@link Bookmark}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreateBookmarkAction)}
   */
  @Test
  @DisplayName("Test Builder from(CreateBookmarkAction); given Bookmark; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreateBookmarkAction)"})
  void testBuilderFrom_givenBookmark_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCreateBookmarkAction.builder();
    CreateBookmarkAction instance = mock(CreateBookmarkAction.class);
    when(instance.bookmark()).thenReturn(mock(Bookmark.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).bookmark();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#bookmark()}.
   * <p>
   * Method under test: {@link Json#bookmark()}
   */
  @Test
  @DisplayName("Test Json bookmark()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Bookmark Json.bookmark()"})
  void testJsonBookmark() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).bookmark());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setBookmark(Bookmark)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setBookmark(Bookmark)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setBookmark(null);

    // Assert
    assertNull(actualJson.bookmark);
  }
}
