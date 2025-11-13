package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableUpdateRatingCodeCommand.Builder;
import org.finos.waltz.model.ImmutableUpdateRatingCodeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRatingCodeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateRatingCodeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        "New Code",
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build().newCode());
  }

  /**
   * Test Builder {@link Builder#from(UpdateRatingCodeCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newCode {@code New Code} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateRatingCodeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateRatingCodeCommand); then builder build is builder newCode 'New Code' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateRatingCodeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewCodeNewCodeBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCodeCommand.builder();
    ImmutableUpdateRatingCodeCommand instance =
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateRatingCodeCommand actualImmutableUpdateRatingCodeCommand = builderResult.build();
    assertEquals(instance, actualImmutableUpdateRatingCodeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newCode(String)}.
   *
   * <ul>
   *   <li>When {@code New Code}.
   *   <li>Then builder build newCode is {@code New Code}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#newCode(String)}
   */
  @Test
  @DisplayName(
      "Test Builder newCode(String); when 'New Code'; then builder build newCode is 'New Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newCode(String)"})
  void testBuilderNewCode_whenNewCode_thenBuilderBuildNewCodeIsNewCode() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCodeCommand.builder();

    // Act
    Builder actualNewCodeResult = builderResult.newCode("New Code");

    // Assert
    assertEquals("New Code", builderResult.build().newCode());
    assertSame(builderResult, actualNewCodeResult);
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#copyOf(UpdateRatingCodeCommand)}.
   *
   * <ul>
   *   <li>When builder newCode {@code New Code} build.
   *   <li>Then return {@code New Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#copyOf(UpdateRatingCodeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateRatingCodeCommand); when builder newCode 'New Code' build; then return 'New Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCodeCommand ImmutableUpdateRatingCodeCommand.copyOf(UpdateRatingCodeCommand)"
  })
  void testCopyOf_whenBuilderNewCodeNewCodeBuild_thenReturnNewCode() {
    // Arrange
    ImmutableUpdateRatingCodeCommand instance =
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build();

    // Act and Assert
    assertEquals("New Code", ImmutableUpdateRatingCodeCommand.copyOf(instance).newCode());
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#equals(Object)}, and {@link
   * ImmutableUpdateRatingCodeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRatingCodeCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRatingCodeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCodeCommand.equals(Object)",
    "int ImmutableUpdateRatingCodeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRatingCodeCommand immutableUpdateRatingCodeCommand =
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build();
    ImmutableUpdateRatingCodeCommand immutableUpdateRatingCodeCommand2 =
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build();

    // Act and Assert
    assertEquals(immutableUpdateRatingCodeCommand, immutableUpdateRatingCodeCommand2);
    assertEquals(
        immutableUpdateRatingCodeCommand.hashCode(), immutableUpdateRatingCodeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#equals(Object)}, and {@link
   * ImmutableUpdateRatingCodeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRatingCodeCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRatingCodeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCodeCommand.equals(Object)",
    "int ImmutableUpdateRatingCodeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRatingCodeCommand immutableUpdateRatingCodeCommand =
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build();

    // Act and Assert
    assertEquals(immutableUpdateRatingCodeCommand, immutableUpdateRatingCodeCommand);
    int expectedHashCodeResult = immutableUpdateRatingCodeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateRatingCodeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCodeCommand.equals(Object)",
    "int ImmutableUpdateRatingCodeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateRatingCodeCommand immutableUpdateRatingCodeCommand =
        ImmutableUpdateRatingCodeCommand.builder().newCode("java.lang.String").build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateRatingCodeCommand,
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build());
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCodeCommand.equals(Object)",
    "int ImmutableUpdateRatingCodeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build(), null);
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCodeCommand.equals(Object)",
    "int ImmutableUpdateRatingCodeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build(),
        "Different type to ImmutableUpdateRatingCodeCommand");
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) NewCode is {@code Json}.
   *   <li>Then return newCode is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) NewCode is 'Json'; then return newCode is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCodeCommand ImmutableUpdateRatingCodeCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonNewCodeIsJson_thenReturnNewCodeIsJson() {
    // Arrange
    Json json = new Json();
    json.setNewCode("Json");

    // Act
    ImmutableUpdateRatingCodeCommand actualFromJsonResult =
        ImmutableUpdateRatingCodeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.newCode());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRatingCodeCommand#toString()}
   *   <li>{@link ImmutableUpdateRatingCodeCommand#newCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUpdateRatingCodeCommand.newCode()",
    "String ImmutableUpdateRatingCodeCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateRatingCodeCommand immutableUpdateRatingCodeCommand =
        ImmutableUpdateRatingCodeCommand.builder().newCode("New Code").build();

    // Act
    String actualToStringResult = immutableUpdateRatingCodeCommand.toString();

    // Assert
    assertEquals("New Code", immutableUpdateRatingCodeCommand.newCode());
    assertEquals("UpdateRatingCodeCommand{newCode=New Code}", actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewCode(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewCode(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewCode("New Code");

    // Assert
    assertEquals("New Code", actualJson.newCode);
  }

  /**
   * Test Json {@link Json#newCode()}.
   *
   * <p>Method under test: {@link Json#newCode()}
   */
  @Test
  @DisplayName("Test Json newCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.newCode()"})
  void testJsonNewCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newCode());
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#withNewCode(String)}.
   *
   * <ul>
   *   <li>Given builder newCode {@code 42} build.
   *   <li>Then return builder newCode {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#withNewCode(String)}
   */
  @Test
  @DisplayName(
      "Test withNewCode(String); given builder newCode '42' build; then return builder newCode '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCodeCommand ImmutableUpdateRatingCodeCommand.withNewCode(String)"
  })
  void testWithNewCode_givenBuilderNewCode42Build_thenReturnBuilderNewCode42Build() {
    // Arrange
    ImmutableUpdateRatingCodeCommand immutableUpdateRatingCodeCommand =
        ImmutableUpdateRatingCodeCommand.builder().newCode("42").build();

    // Act
    ImmutableUpdateRatingCodeCommand actualWithNewCodeResult =
        immutableUpdateRatingCodeCommand.withNewCode("42");

    // Assert
    assertSame(immutableUpdateRatingCodeCommand, actualWithNewCodeResult);
  }

  /**
   * Test {@link ImmutableUpdateRatingCodeCommand#withNewCode(String)}.
   *
   * <ul>
   *   <li>Given builder newCode {@code New Code} build.
   *   <li>Then return newCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCodeCommand#withNewCode(String)}
   */
  @Test
  @DisplayName(
      "Test withNewCode(String); given builder newCode 'New Code' build; then return newCode is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCodeCommand ImmutableUpdateRatingCodeCommand.withNewCode(String)"
  })
  void testWithNewCode_givenBuilderNewCodeNewCodeBuild_thenReturnNewCodeIs42() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        ImmutableUpdateRatingCodeCommand.builder()
            .newCode("New Code")
            .build()
            .withNewCode("42")
            .newCode());
  }
}
