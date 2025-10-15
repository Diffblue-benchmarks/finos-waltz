package org.finos.waltz.model.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobStep.Builder;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobStep.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRipplerJobStepDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRipplerJobStep Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobStep actualImmutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();

    // Assert
    assertEquals("To Def", actualImmutableAssessmentRipplerJobStep.toDef());
    assertEquals("jane.doe@example.org", actualImmutableAssessmentRipplerJobStep.fromDef());
  }

  /**
   * Test Builder {@link Builder#fromDef(String)}.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fromDef(String)}
   */
  @Test
  @DisplayName("Test Builder fromDef(String); when 'jane.doe@example.org'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fromDef(String)"})
  void testBuilderFromDef_whenJaneDoeExampleOrg_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();

    // Act
    Builder actualFromDefResult = builderResult.fromDef("jane.doe@example.org");

    // Assert
    assertSame(builderResult, actualFromDefResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobStep)}.
   *
   * <ul>
   *   <li>Then builder build is builder fromDef {@code jane.doe@example.org} toDef {@code To Def}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRipplerJobStep)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRipplerJobStep); then builder build is builder fromDef 'jane.doe@example.org' toDef 'To Def' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobStep)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderFromDefJaneDoeExampleOrgToDefToDefBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();
    ImmutableAssessmentRipplerJobStep instance =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRipplerJobStep actualImmutableAssessmentRipplerJobStep =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRipplerJobStep);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#toDef(String)}.
   *
   * <ul>
   *   <li>When {@code To Def}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#toDef(String)}
   */
  @Test
  @DisplayName("Test Builder toDef(String); when 'To Def'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.toDef(String)"})
  void testBuilderToDef_whenToDef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();

    // Act
    Builder actualToDefResult = builderResult.toDef("To Def");

    // Assert
    assertSame(builderResult, actualToDefResult);
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#copyOf(AssessmentRipplerJobStep)}.
   *
   * <ul>
   *   <li>When builder fromDef {@code jane.doe@example.org} toDef {@code To Def} build.
   *   <li>Then return {@code To Def}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRipplerJobStep#copyOf(AssessmentRipplerJobStep)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRipplerJobStep); when builder fromDef 'jane.doe@example.org' toDef 'To Def' build; then return 'To Def'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobStep ImmutableAssessmentRipplerJobStep.copyOf(AssessmentRipplerJobStep)"
  })
  void testCopyOf_whenBuilderFromDefJaneDoeExampleOrgToDefToDefBuild_thenReturnToDef() {
    // Arrange
    ImmutableAssessmentRipplerJobStep instance =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();

    // Act
    ImmutableAssessmentRipplerJobStep actualCopyOfResult =
        ImmutableAssessmentRipplerJobStep.copyOf(instance);

    // Assert
    assertEquals("To Def", actualCopyOfResult.toDef());
    assertEquals("jane.doe@example.org", actualCopyOfResult.fromDef());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#equals(Object)}, and {@link
   * ImmutableAssessmentRipplerJobStep#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRipplerJobStep#equals(Object)}
   *   <li>{@link ImmutableAssessmentRipplerJobStep#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobStep.equals(Object)",
    "int ImmutableAssessmentRipplerJobStep.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep2 =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRipplerJobStep, immutableAssessmentRipplerJobStep2);
    assertEquals(
        immutableAssessmentRipplerJobStep.hashCode(),
        immutableAssessmentRipplerJobStep2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#equals(Object)}, and {@link
   * ImmutableAssessmentRipplerJobStep#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRipplerJobStep#equals(Object)}
   *   <li>{@link ImmutableAssessmentRipplerJobStep#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobStep.equals(Object)",
    "int ImmutableAssessmentRipplerJobStep.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRipplerJobStep, immutableAssessmentRipplerJobStep);
    int expectedHashCodeResult = immutableAssessmentRipplerJobStep.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRipplerJobStep.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobStep.equals(Object)",
    "int ImmutableAssessmentRipplerJobStep.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder().fromDef("To Def").toDef("To Def").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRipplerJobStep,
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobStep.equals(Object)",
    "int ImmutableAssessmentRipplerJobStep.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("jane.doe@example.org")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRipplerJobStep,
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobStep.equals(Object)",
    "int ImmutableAssessmentRipplerJobStep.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobStep.equals(Object)",
    "int ImmutableAssessmentRipplerJobStep.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build(),
        "Different type to ImmutableAssessmentRipplerJobStep");
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) FromDef is {@code Json}.
   *   <li>Then return fromDef is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) FromDef is 'Json'; then return fromDef is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobStep ImmutableAssessmentRipplerJobStep.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonFromDefIsJson_thenReturnFromDefIsJson() {
    // Arrange
    Json json = new Json();
    json.setFromDef("Json");
    json.setToDef("Json");

    // Act
    ImmutableAssessmentRipplerJobStep actualFromJsonResult =
        ImmutableAssessmentRipplerJobStep.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fromDef());
    assertEquals("Json", actualFromJsonResult.toDef());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRipplerJobStep#toString()}
   *   <li>{@link ImmutableAssessmentRipplerJobStep#fromDef()}
   *   <li>{@link ImmutableAssessmentRipplerJobStep#toDef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentRipplerJobStep.fromDef()",
    "String ImmutableAssessmentRipplerJobStep.toDef()",
    "String ImmutableAssessmentRipplerJobStep.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRipplerJobStep.toString();
    String actualFromDefResult = immutableAssessmentRipplerJobStep.fromDef();

    // Assert
    assertEquals(
        "AssessmentRipplerJobStep{fromDef=jane.doe@example.org, toDef=To Def}",
        actualToStringResult);
    assertEquals("To Def", immutableAssessmentRipplerJobStep.toDef());
    assertEquals("jane.doe@example.org", actualFromDefResult);
  }

  /**
   * Test Json {@link Json#fromDef()}.
   *
   * <p>Method under test: {@link Json#fromDef()}
   */
  @Test
  @DisplayName("Test Json fromDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.fromDef()"})
  void testJsonFromDef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fromDef());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setFromDef(String)}
   *   <li>{@link Json#setToDef(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setFromDef(String)",
    "void Json.setToDef(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setFromDef("jane.doe@example.org");
    actualJson.setToDef("To Def");

    // Assert
    assertEquals("To Def", actualJson.toDef);
    assertEquals("jane.doe@example.org", actualJson.fromDef);
  }

  /**
   * Test Json {@link Json#toDef()}.
   *
   * <p>Method under test: {@link Json#toDef()}
   */
  @Test
  @DisplayName("Test Json toDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.toDef()"})
  void testJsonToDef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().toDef());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#withFromDef(String)}.
   *
   * <ul>
   *   <li>Then return builder fromDef {@code 42} toDef {@code To Def} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#withFromDef(String)}
   */
  @Test
  @DisplayName("Test withFromDef(String); then return builder fromDef '42' toDef 'To Def' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobStep ImmutableAssessmentRipplerJobStep.withFromDef(String)"
  })
  void testWithFromDef_thenReturnBuilderFromDef42ToDefToDefBuild() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder().fromDef("42").toDef("To Def").build();

    // Act
    ImmutableAssessmentRipplerJobStep actualWithFromDefResult =
        immutableAssessmentRipplerJobStep.withFromDef("42");

    // Assert
    assertSame(immutableAssessmentRipplerJobStep, actualWithFromDefResult);
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#withFromDef(String)}.
   *
   * <ul>
   *   <li>Then return fromDef is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#withFromDef(String)}
   */
  @Test
  @DisplayName("Test withFromDef(String); then return fromDef is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobStep ImmutableAssessmentRipplerJobStep.withFromDef(String)"
  })
  void testWithFromDef_thenReturnFromDefIs42() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobStep actualWithFromDefResult =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build()
            .withFromDef("42");

    // Assert
    assertEquals("42", actualWithFromDefResult.fromDef());
    assertEquals("To Def", actualWithFromDefResult.toDef());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#withToDef(String)}.
   *
   * <ul>
   *   <li>Then return builder fromDef {@code jane.doe@example.org} toDef {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#withToDef(String)}
   */
  @Test
  @DisplayName(
      "Test withToDef(String); then return builder fromDef 'jane.doe@example.org' toDef '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobStep ImmutableAssessmentRipplerJobStep.withToDef(String)"
  })
  void testWithToDef_thenReturnBuilderFromDefJaneDoeExampleOrgToDef42Build() {
    // Arrange
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("42")
            .build();

    // Act
    ImmutableAssessmentRipplerJobStep actualWithToDefResult =
        immutableAssessmentRipplerJobStep.withToDef("42");

    // Assert
    assertSame(immutableAssessmentRipplerJobStep, actualWithToDefResult);
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobStep#withToDef(String)}.
   *
   * <ul>
   *   <li>Then return toDef is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobStep#withToDef(String)}
   */
  @Test
  @DisplayName("Test withToDef(String); then return toDef is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobStep ImmutableAssessmentRipplerJobStep.withToDef(String)"
  })
  void testWithToDef_thenReturnToDefIs42() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobStep actualWithToDefResult =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build()
            .withToDef("42");

    // Assert
    assertEquals("42", actualWithToDefResult.toDef());
    assertEquals("jane.doe@example.org", actualWithToDefResult.fromDef());
  }
}
