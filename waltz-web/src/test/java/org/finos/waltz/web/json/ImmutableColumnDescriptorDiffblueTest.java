package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.web.json.ImmutableColumnDescriptor.Builder;
import org.finos.waltz.web.json.ImmutableColumnDescriptor.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableColumnDescriptorDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ColumnDescriptor)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then builder build id is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ColumnDescriptor)}
   */
  @Test
  @DisplayName("Test Builder from(ColumnDescriptor); given 'Name'; then builder build id is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ColumnDescriptor)"})
  void testBuilderFrom_givenName_thenBuilderBuildIdIs42() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();
    ColumnDescriptor instance = mock(ColumnDescriptor.class);
    when(instance.name()).thenReturn("Name");
    when(instance.id()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    ImmutableColumnDescriptor buildResult = builderResult.build();
    assertEquals("42", buildResult.id());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ColumnDescriptor)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ColumnDescriptor)}
   */
  @Test
  @DisplayName("Test Builder from(ColumnDescriptor); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ColumnDescriptor)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();
    ColumnDescriptor instance = mock(ColumnDescriptor.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));
    when(instance.id()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#id(String)}.
   * <p>
   * Method under test: {@link Builder#id(String)}
   */
  @Test
  @DisplayName("Test Builder id(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(String)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("42"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setId(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setId(String)", "void Json.setName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setId("42");
    actualJson.setName("Name");

    // Assert
    assertEquals("42", actualJson.id);
    assertEquals("Name", actualJson.name);
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }
}
