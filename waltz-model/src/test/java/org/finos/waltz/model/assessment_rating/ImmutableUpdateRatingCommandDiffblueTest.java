package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.ImmutableUpdateRatingCommand.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableUpdateRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRatingCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateRatingCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        1L,
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build().newRatingId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(UpdateRatingCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newRatingId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateRatingCommand); then builder build is builder newRatingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateRatingCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewRatingIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCommand.builder();
    ImmutableUpdateRatingCommand instance =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateRatingCommand actualImmutableUpdateRatingCommand = builderResult.build();
    assertEquals(instance, actualImmutableUpdateRatingCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newRatingId(Long)}.
   *
   * <p>Method under test: {@link Builder#newRatingId(Long)}
   */
  @Test
  @DisplayName("Test Builder newRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newRatingId(Long)"})
  void testBuilderNewRatingId() {
    // Arrange
    Builder builderResult = ImmutableUpdateRatingCommand.builder();

    // Act
    Builder actualNewRatingIdResult = builderResult.newRatingId(1L);

    // Assert
    assertEquals(1L, builderResult.build().newRatingId().longValue());
    assertSame(builderResult, actualNewRatingIdResult);
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#copyOf(UpdateRatingCommand)}.
   *
   * <ul>
   *   <li>When builder newRatingId one build.
   *   <li>Then return newRatingId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#copyOf(UpdateRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateRatingCommand); when builder newRatingId one build; then return newRatingId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCommand ImmutableUpdateRatingCommand.copyOf(UpdateRatingCommand)"
  })
  void testCopyOf_whenBuilderNewRatingIdOneBuild_thenReturnNewRatingIdLongValueIsOne() {
    // Arrange
    ImmutableUpdateRatingCommand instance =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();

    // Act and Assert
    assertEquals(1L, ImmutableUpdateRatingCommand.copyOf(instance).newRatingId().longValue());
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#equals(Object)}, and {@link
   * ImmutableUpdateRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRatingCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCommand.equals(Object)",
    "int ImmutableUpdateRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRatingCommand immutableUpdateRatingCommand =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();
    ImmutableUpdateRatingCommand immutableUpdateRatingCommand2 =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();

    // Act and Assert
    assertEquals(immutableUpdateRatingCommand, immutableUpdateRatingCommand2);
    assertEquals(immutableUpdateRatingCommand.hashCode(), immutableUpdateRatingCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#equals(Object)}, and {@link
   * ImmutableUpdateRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRatingCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCommand.equals(Object)",
    "int ImmutableUpdateRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRatingCommand immutableUpdateRatingCommand =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();

    // Act and Assert
    assertEquals(immutableUpdateRatingCommand, immutableUpdateRatingCommand);
    int expectedHashCodeResult = immutableUpdateRatingCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateRatingCommand.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCommand.equals(Object)",
    "int ImmutableUpdateRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateRatingCommand immutableUpdateRatingCommand =
        ImmutableUpdateRatingCommand.builder().newRatingId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateRatingCommand,
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build());
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCommand.equals(Object)",
    "int ImmutableUpdateRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRatingCommand.equals(Object)",
    "int ImmutableUpdateRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build(),
        "Different type to ImmutableUpdateRatingCommand");
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return newRatingId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given one; then return newRatingId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateRatingCommand ImmutableUpdateRatingCommand.fromJson(Json)"})
  void testFromJson_givenOne_thenReturnNewRatingIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setNewRatingId(1L);

    // Act
    ImmutableUpdateRatingCommand actualFromJsonResult = ImmutableUpdateRatingCommand.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.newRatingId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRatingCommand#toString()}
   *   <li>{@link ImmutableUpdateRatingCommand#newRatingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableUpdateRatingCommand.newRatingId()",
    "String ImmutableUpdateRatingCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateRatingCommand immutableUpdateRatingCommand =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();

    // Act
    String actualToStringResult = immutableUpdateRatingCommand.toString();

    // Assert
    assertEquals("UpdateRatingCommand{newRatingId=1}", actualToStringResult);
    assertEquals(1L, immutableUpdateRatingCommand.newRatingId().longValue());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewRatingId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewRatingId(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewRatingId(1L);

    // Assert
    assertEquals(1L, actualJson.newRatingId.longValue());
  }

  /**
   * Test Json {@link Json#newRatingId()}.
   *
   * <p>Method under test: {@link Json#newRatingId()}
   */
  @Test
  @DisplayName("Test Json newRatingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.newRatingId()"})
  void testJsonNewRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newRatingId());
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#withNewRatingId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return newRatingId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#withNewRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test withNewRatingId(Long); when forty-two; then return newRatingId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCommand ImmutableUpdateRatingCommand.withNewRatingId(Long)"
  })
  void testWithNewRatingId_whenFortyTwo_thenReturnNewRatingIdLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        ImmutableUpdateRatingCommand.builder()
            .newRatingId(1L)
            .build()
            .withNewRatingId(42L)
            .newRatingId()
            .longValue());
  }

  /**
   * Test {@link ImmutableUpdateRatingCommand#withNewRatingId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder newRatingId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRatingCommand#withNewRatingId(Long)}
   */
  @Test
  @DisplayName("Test withNewRatingId(Long); when one; then return builder newRatingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRatingCommand ImmutableUpdateRatingCommand.withNewRatingId(Long)"
  })
  void testWithNewRatingId_whenOne_thenReturnBuilderNewRatingIdOneBuild() {
    // Arrange
    ImmutableUpdateRatingCommand immutableUpdateRatingCommand =
        ImmutableUpdateRatingCommand.builder().newRatingId(1L).build();

    // Act
    ImmutableUpdateRatingCommand actualWithNewRatingIdResult =
        immutableUpdateRatingCommand.withNewRatingId(1L);

    // Assert
    assertSame(immutableUpdateRatingCommand, actualWithNewRatingIdResult);
  }
}
