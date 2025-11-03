package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableUpdateDescriptionCommand.Builder;
import org.finos.waltz.model.ImmutableUpdateDescriptionCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDescriptionCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#newDescription(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateDescriptionCommand Builder.build()", "Builder Builder.newDescription(String)"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals("New Description",
        ImmutableUpdateDescriptionCommand.builder().newDescription("New Description").build().newDescription());
  }

  /**
   * Test Builder {@link Builder#from(UpdateDescriptionCommand)}.
   * <ul>
   *   <li>Then builder build is builder newDescription {@code New Description} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDescriptionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDescriptionCommand); then builder build is builder newDescription 'New Description' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDescriptionCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewDescriptionNewDescriptionBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateDescriptionCommand.builder();
    ImmutableUpdateDescriptionCommand instance = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDescriptionCommand)}.
   * <ul>
   *   <li>Then builder build is builder newDescription {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateDescriptionCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDescriptionCommand); then builder build is builder newDescription 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateDescriptionCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewDescriptionNullBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateDescriptionCommand.builder();
    ImmutableUpdateDescriptionCommand instance = ImmutableUpdateDescriptionCommand.builder()
        .newDescription(null)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#copyOf(UpdateDescriptionCommand)}.
   * <ul>
   *   <li>When builder newDescription {@code New Description} build.</li>
   *   <li>Then return {@code New Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#copyOf(UpdateDescriptionCommand)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateDescriptionCommand); when builder newDescription 'New Description' build; then return 'New Description'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableUpdateDescriptionCommand ImmutableUpdateDescriptionCommand.copyOf(UpdateDescriptionCommand)"})
  void testCopyOf_whenBuilderNewDescriptionNewDescriptionBuild_thenReturnNewDescription() {
    // Arrange
    ImmutableUpdateDescriptionCommand instance = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertEquals("New Description", ImmutableUpdateDescriptionCommand.copyOf(instance).newDescription());
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#equals(Object)}, and {@link ImmutableUpdateDescriptionCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateDescriptionCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateDescriptionCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateDescriptionCommand.equals(Object)",
      "int ImmutableUpdateDescriptionCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();
    ImmutableUpdateDescriptionCommand buildResult2 = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#equals(Object)}, and {@link ImmutableUpdateDescriptionCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateDescriptionCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateDescriptionCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateDescriptionCommand.equals(Object)",
      "int ImmutableUpdateDescriptionCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateDescriptionCommand.equals(Object)",
      "int ImmutableUpdateDescriptionCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("42")
        .build();
    ImmutableUpdateDescriptionCommand buildResult2 = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateDescriptionCommand.equals(Object)",
      "int ImmutableUpdateDescriptionCommand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateDescriptionCommand.equals(Object)",
      "int ImmutableUpdateDescriptionCommand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableUpdateDescriptionCommand");
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>Then return newDescription is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; then return newDescription is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateDescriptionCommand ImmutableUpdateDescriptionCommand.fromJson(Json)"})
  void testFromJson_givenJson_thenReturnNewDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setNewDescription("Json");

    // Act and Assert
    assertEquals("Json", ImmutableUpdateDescriptionCommand.fromJson(json).newDescription());
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return newDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return newDescription is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateDescriptionCommand ImmutableUpdateDescriptionCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNewDescriptionIsNull() {
    // Arrange, Act and Assert
    assertNull(ImmutableUpdateDescriptionCommand.fromJson(new Json()).newDescription());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateDescriptionCommand#toString()}
   *   <li>{@link ImmutableUpdateDescriptionCommand#newDescription()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableUpdateDescriptionCommand.newDescription()",
      "String ImmutableUpdateDescriptionCommand.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("New Description", buildResult.newDescription());
    assertEquals("UpdateDescriptionCommand{newDescription=New Description}", actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewDescription(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewDescription(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewDescription("New Description");

    // Assert
    assertEquals("New Description", actualJson.newDescription);
  }

  /**
   * Test Json {@link Json#newDescription()}.
   * <p>
   * Method under test: {@link Json#newDescription()}
   */
  @Test
  @DisplayName("Test Json newDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.newDescription()"})
  void testJsonNewDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newDescription());
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#withNewDescription(String)}.
   * <ul>
   *   <li>Then return builder newDescription {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#withNewDescription(String)}
   */
  @Test
  @DisplayName("Test withNewDescription(String); then return builder newDescription '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateDescriptionCommand ImmutableUpdateDescriptionCommand.withNewDescription(String)"})
  void testWithNewDescription_thenReturnBuilderNewDescription42Build() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("42")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withNewDescription("42"));
  }

  /**
   * Test {@link ImmutableUpdateDescriptionCommand#withNewDescription(String)}.
   * <ul>
   *   <li>Then return newDescription is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateDescriptionCommand#withNewDescription(String)}
   */
  @Test
  @DisplayName("Test withNewDescription(String); then return newDescription is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateDescriptionCommand ImmutableUpdateDescriptionCommand.withNewDescription(String)"})
  void testWithNewDescription_thenReturnNewDescriptionIs42() {
    // Arrange
    ImmutableUpdateDescriptionCommand buildResult = ImmutableUpdateDescriptionCommand.builder()
        .newDescription("New Description")
        .build();

    // Act and Assert
    assertEquals("42", buildResult.withNewDescription("42").newDescription());
  }
}
