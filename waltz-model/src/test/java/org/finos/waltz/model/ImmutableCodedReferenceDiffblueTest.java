package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableCodedReference.Builder;
import org.finos.waltz.model.ImmutableCodedReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCodedReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#code(String)}.
   * <p>
   * Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   * <ul>
   *   <li>Given {@code Code}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CodeProvider) with 'CodeProvider'; given 'Code'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_givenCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenReturn("Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CodeProvider)} with {@code CodeProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CodeProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CodeProvider) with 'CodeProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CodeProvider)"})
  void testBuilderFromWithCodeProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
  }

  /**
   * Test Builder {@link Builder#from(CodedReference)} with {@code CodedReference}.
   * <ul>
   *   <li>Given {@code Code}.</li>
   *   <li>Then builder build code is {@code Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CodedReference)}
   */
  @Test
  @DisplayName("Test Builder from(CodedReference) with 'CodedReference'; given 'Code'; then builder build code is 'Code'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CodedReference)"})
  void testBuilderFromWithCodedReference_givenCode_thenBuilderBuildCodeIsCode() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    CodedReference instance = mock(CodedReference.class);
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).name();
    ImmutableCodedReference buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CodedReference)} with {@code CodedReference}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CodedReference)}
   */
  @Test
  @DisplayName("Test Builder from(CodedReference) with 'CodedReference'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CodedReference)"})
  void testBuilderFromWithCodedReference_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    CodedReference instance = mock(CodedReference.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCodedReference.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableCodedReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#code()}.
   * <p>
   * Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).code());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCode(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCode(String)", "void Json.setName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCode("Code");
    actualJson.setName("Name");

    // Assert
    assertEquals("Code", actualJson.code);
    assertEquals("Name", actualJson.name);
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
