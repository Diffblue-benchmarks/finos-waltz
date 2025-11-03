package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.ImmutableStringChangeCommand.Builder;
import org.finos.waltz.model.ImmutableStringChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableStringChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(StringChangeCommand)}.
   * <ul>
   *   <li>Then builder build is builder newStringVal {@code New String Val} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(StringChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(StringChangeCommand); then builder build is builder newStringVal 'New String Val' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(StringChangeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewStringValNewStringValBuild() {
    // Arrange
    Builder builderResult = ImmutableStringChangeCommand.builder();
    ImmutableStringChangeCommand instance = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newStringVal(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#newStringVal(Optional)}
   */
  @Test
  @DisplayName("Test Builder newStringVal(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newStringVal(Optional)"})
  void testBuilderNewStringValWithOptional() {
    // Arrange
    Builder builderResult = ImmutableStringChangeCommand.builder();
    Optional<String> newStringVal = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.newStringVal(newStringVal));
  }

  /**
   * Test {@link ImmutableStringChangeCommand#copyOf(StringChangeCommand)}.
   * <ul>
   *   <li>When builder newStringVal {@code New String Val} build.</li>
   *   <li>Then return {@code New String Val}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#copyOf(StringChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(StringChangeCommand); when builder newStringVal 'New String Val' build; then return 'New String Val'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.copyOf(StringChangeCommand)"})
  void testCopyOf_whenBuilderNewStringValNewStringValBuild_thenReturnNewStringVal() {
    // Arrange
    ImmutableStringChangeCommand instance = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    Optional<String> newStringValResult = ImmutableStringChangeCommand.copyOf(instance).newStringVal();
    assertEquals("New String Val", newStringValResult.get());
    assertTrue(newStringValResult.isPresent());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#equals(Object)}, and {@link ImmutableStringChangeCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableStringChangeCommand#equals(Object)}
   *   <li>{@link ImmutableStringChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableStringChangeCommand.equals(Object)",
      "int ImmutableStringChangeCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();
    ImmutableStringChangeCommand buildResult2 = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#equals(Object)}, and {@link ImmutableStringChangeCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableStringChangeCommand#equals(Object)}
   *   <li>{@link ImmutableStringChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableStringChangeCommand.equals(Object)",
      "int ImmutableStringChangeCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableStringChangeCommand.equals(Object)",
      "int ImmutableStringChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("java.lang.String")
        .build();
    ImmutableStringChangeCommand buildResult2 = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableStringChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableStringChangeCommand.equals(Object)",
      "int ImmutableStringChangeCommand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableStringChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableStringChangeCommand.equals(Object)",
      "int ImmutableStringChangeCommand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableStringChangeCommand");
  }

  /**
   * Test {@link ImmutableStringChangeCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) NewStringVal is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) NewStringVal is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonNewStringValIsNull() {
    // Arrange
    Json json = new Json();
    json.setNewStringVal(null);

    // Act and Assert
    assertFalse(ImmutableStringChangeCommand.fromJson(json).newStringVal().isPresent());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return not newStringVal Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return not newStringVal Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNotNewStringValPresent() {
    // Arrange, Act and Assert
    assertFalse(ImmutableStringChangeCommand.fromJson(new Json()).newStringVal().isPresent());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertFalse((new Json()).newStringVal.isPresent());
  }

  /**
   * Test Json {@link Json#newStringVal()}.
   * <p>
   * Method under test: {@link Json#newStringVal()}
   */
  @Test
  @DisplayName("Test Json newStringVal()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.newStringVal()"})
  void testJsonNewStringVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newStringVal());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#newStringVal()}.
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#newStringVal()}
   */
  @Test
  @DisplayName("Test newStringVal()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableStringChangeCommand.newStringVal()"})
  void testNewStringVal() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act
    Optional<String> actualNewStringValResult = buildResult.newStringVal();

    // Assert
    assertEquals("New String Val", actualNewStringValResult.get());
    assertTrue(actualNewStringValResult.isPresent());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#withNewStringVal(Optional)} with {@code optional}.
   * <ul>
   *   <li>Then return builder newStringVal {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#withNewStringVal(Optional)}
   */
  @Test
  @DisplayName("Test withNewStringVal(Optional) with 'optional'; then return builder newStringVal '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.withNewStringVal(Optional)"})
  void testWithNewStringValWithOptional_thenReturnBuilderNewStringVal42Build() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder().newStringVal("42").build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertSame(buildResult, buildResult.withNewStringVal(optional));
  }

  /**
   * Test {@link ImmutableStringChangeCommand#withNewStringVal(Optional)} with {@code optional}.
   * <ul>
   *   <li>Then return newStringVal is {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#withNewStringVal(Optional)}
   */
  @Test
  @DisplayName("Test withNewStringVal(Optional) with 'optional'; then return newStringVal is Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.withNewStringVal(Optional)"})
  void testWithNewStringValWithOptional_thenReturnNewStringValIsOptionalWithFoo() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();
    Optional<String> optional = Optional.of("foo");

    // Act and Assert
    assertEquals(optional, buildResult.withNewStringVal(optional).newStringVal());
  }

  /**
   * Test {@link ImmutableStringChangeCommand#withNewStringVal(String)} with {@code value}.
   * <ul>
   *   <li>Then return builder newStringVal {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#withNewStringVal(String)}
   */
  @Test
  @DisplayName("Test withNewStringVal(String) with 'value'; then return builder newStringVal '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.withNewStringVal(String)"})
  void testWithNewStringValWithValue_thenReturnBuilderNewStringVal42Build() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder().newStringVal("42").build();

    // Act and Assert
    assertSame(buildResult, buildResult.withNewStringVal("42"));
  }

  /**
   * Test {@link ImmutableStringChangeCommand#withNewStringVal(String)} with {@code value}.
   * <ul>
   *   <li>Then return newStringVal is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableStringChangeCommand#withNewStringVal(String)}
   */
  @Test
  @DisplayName("Test withNewStringVal(String) with 'value'; then return newStringVal is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStringChangeCommand ImmutableStringChangeCommand.withNewStringVal(String)"})
  void testWithNewStringValWithValue_thenReturnNewStringValIs42() {
    // Arrange
    ImmutableStringChangeCommand buildResult = ImmutableStringChangeCommand.builder()
        .newStringVal("New String Val")
        .build();

    // Act and Assert
    Optional<String> newStringValResult = buildResult.withNewStringVal("42").newStringVal();
    assertEquals("42", newStringValResult.get());
    assertTrue(newStringValResult.isPresent());
  }
}
