package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.web.json.ImmutableSharedPreferenceKeyAndCategory.Builder;
import org.finos.waltz.web.json.ImmutableSharedPreferenceKeyAndCategory.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceKeyAndCategoryDiffblueTest {
  /**
   * Test Builder {@link Builder#category(String)}.
   * <p>
   * Method under test: {@link Builder#category(String)}
   */
  @Test
  @DisplayName("Test Builder category(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.category(String)"})
  void testBuilderCategory() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Test Builder {@link Builder#from(SharedPreferenceKeyAndCategory)}.
   * <ul>
   *   <li>Given {@code Category}.</li>
   *   <li>Then builder build category is {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SharedPreferenceKeyAndCategory)}
   */
  @Test
  @DisplayName("Test Builder from(SharedPreferenceKeyAndCategory); given 'Category'; then builder build category is 'Category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SharedPreferenceKeyAndCategory)"})
  void testBuilderFrom_givenCategory_thenBuilderBuildCategoryIsCategory() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();
    SharedPreferenceKeyAndCategory instance = mock(SharedPreferenceKeyAndCategory.class);
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).key();
    ImmutableSharedPreferenceKeyAndCategory buildResult = builderResult.build();
    assertEquals("Category", buildResult.category());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SharedPreferenceKeyAndCategory)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SharedPreferenceKeyAndCategory)}
   */
  @Test
  @DisplayName("Test Builder from(SharedPreferenceKeyAndCategory); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SharedPreferenceKeyAndCategory)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();
    SharedPreferenceKeyAndCategory instance = mock(SharedPreferenceKeyAndCategory.class);
    when(instance.category()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).key();
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   * <p>
   * Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceKeyAndCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Test Json {@link Json#category()}.
   * <p>
   * Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).category());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCategory(String)}
   *   <li>{@link Json#setKey(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCategory(String)", "void Json.setKey(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");

    // Assert
    assertEquals("Category", actualJson.category);
    assertEquals("Key", actualJson.key);
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).key());
  }
}
