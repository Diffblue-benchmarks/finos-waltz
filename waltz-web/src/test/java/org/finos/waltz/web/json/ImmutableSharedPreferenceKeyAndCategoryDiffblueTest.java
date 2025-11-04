package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceKeyAndCategoryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory.Builder#category(String)}
   */
  @Test
  void testBuilderCategory() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory.Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory.Builder#from(SharedPreferenceKeyAndCategory)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory.Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();
    SharedPreferenceKeyAndCategory instance = mock(SharedPreferenceKeyAndCategory.class);
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableSharedPreferenceKeyAndCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).key();
    ImmutableSharedPreferenceKeyAndCategory buildResult = builderResult.build();
    assertEquals("Category", buildResult.category());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory.Builder#from(SharedPreferenceKeyAndCategory)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory.Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();
    SharedPreferenceKeyAndCategory instance = mock(SharedPreferenceKeyAndCategory.class);
    when(instance.category()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).key();
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory.Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory#copyOf(SharedPreferenceKeyAndCategory)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SharedPreferenceKeyAndCategory instance = mock(SharedPreferenceKeyAndCategory.class);
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableSharedPreferenceKeyAndCategory actualCopyOfResult = ImmutableSharedPreferenceKeyAndCategory
        .copyOf(instance);

    // Assert
    verify(instance).category();
    verify(instance).key();
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Key", actualCopyOfResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory#fromJson(ImmutableSharedPreferenceKeyAndCategory.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSharedPreferenceKeyAndCategory.Json json = new ImmutableSharedPreferenceKeyAndCategory.Json();
    json.setKey("Json");
    json.setCategory("Json");

    // Act
    ImmutableSharedPreferenceKeyAndCategory actualFromJsonResult = ImmutableSharedPreferenceKeyAndCategory
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.category());
    assertEquals("Json", actualFromJsonResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableSharedPreferenceKeyAndCategory.Json#category()}
   */
  @Test
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSharedPreferenceKeyAndCategory.Json()).category());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSharedPreferenceKeyAndCategory.Json}
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory.Json#setCategory(String)}
   *   <li>{@link ImmutableSharedPreferenceKeyAndCategory.Json#setKey(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSharedPreferenceKeyAndCategory.Json actualJson = new ImmutableSharedPreferenceKeyAndCategory.Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");

    // Assert
    assertEquals("Category", actualJson.category);
    assertEquals("Key", actualJson.key);
  }

  /**
   * Method under test: {@link ImmutableSharedPreferenceKeyAndCategory.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSharedPreferenceKeyAndCategory.Json()).key());
  }
}
