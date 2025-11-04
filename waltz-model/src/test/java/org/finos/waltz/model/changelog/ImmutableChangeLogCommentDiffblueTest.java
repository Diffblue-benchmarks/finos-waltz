package org.finos.waltz.model.changelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogCommentDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeLogComment.Builder#build()}
   *   <li>{@link ImmutableChangeLogComment.Builder#comment(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals("Comment", ImmutableChangeLogComment.builder().comment("Comment").build().comment());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogComment.Builder#from(ChangeLogComment)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeLogComment.Builder builderResult = ImmutableChangeLogComment.builder();
    ChangeLogComment instance = mock(ChangeLogComment.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableChangeLogComment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertEquals("Comment", actualFromResult.build().comment());
    assertEquals("Comment", builderResult.build().comment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogComment.Builder#from(ChangeLogComment)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeLogComment.Builder builderResult = ImmutableChangeLogComment.builder();
    ChangeLogComment instance = mock(ChangeLogComment.class);
    when(instance.comment()).thenReturn(null);

    // Act
    ImmutableChangeLogComment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertNull(actualFromResult.build().comment());
    assertNull(builderResult.build().comment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeLogComment#copyOf(ChangeLogComment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeLogComment instance = mock(ChangeLogComment.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableChangeLogComment actualCopyOfResult = ImmutableChangeLogComment.copyOf(instance);

    // Assert
    verify(instance).comment();
    assertEquals("Comment", actualCopyOfResult.comment());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogComment#fromJson(ImmutableChangeLogComment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange, Act and Assert
    assertNull(ImmutableChangeLogComment.fromJson(new ImmutableChangeLogComment.Json()).comment());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogComment#fromJson(ImmutableChangeLogComment.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableChangeLogComment.Json json = new ImmutableChangeLogComment.Json();
    json.setComment("Json");

    // Act and Assert
    assertEquals("Json", ImmutableChangeLogComment.fromJson(json).comment());
  }

  /**
   * Method under test: {@link ImmutableChangeLogComment.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLogComment.Json()).comment());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableChangeLogComment.Json}
   *   <li>{@link ImmutableChangeLogComment.Json#setComment(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableChangeLogComment.Json actualJson = new ImmutableChangeLogComment.Json();
    actualJson.setComment("Comment");

    // Assert
    assertEquals("Comment", actualJson.comment);
  }
}
