package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwningRoleSaveCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwningRoleSaveCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwningRoleSaveCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#owningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwningRoleSaveCommand Builder.build()",
    "Builder Builder.owningRole(String)"
  })
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        "Owning Role",
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
            .owningRole("Owning Role")
            .build()
            .owningRole());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder owningRole {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceOwningRoleSaveCommand); then builder build is builder owningRole 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwningRoleSaveCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderOwningRoleNullBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder();
    ImmutableSurveyInstanceOwningRoleSaveCommand instance =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole(null).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceOwningRoleSaveCommand
        actualImmutableSurveyInstanceOwningRoleSaveCommand = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceOwningRoleSaveCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder owningRole {@code Owning Role} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceOwningRoleSaveCommand); then builder build is builder owningRole 'Owning Role' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwningRoleSaveCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderOwningRoleOwningRoleBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder();
    ImmutableSurveyInstanceOwningRoleSaveCommand instance =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceOwningRoleSaveCommand
        actualImmutableSurveyInstanceOwningRoleSaveCommand = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceOwningRoleSaveCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceOwningRoleSaveCommand#copyOf(SurveyInstanceOwningRoleSaveCommand)}.
   *
   * <ul>
   *   <li>When builder owningRole {@code Owning Role} build.
   *   <li>Then return {@code Owning Role}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceOwningRoleSaveCommand#copyOf(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceOwningRoleSaveCommand); when builder owningRole 'Owning Role' build; then return 'Owning Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.copyOf(SurveyInstanceOwningRoleSaveCommand)"
  })
  void testCopyOf_whenBuilderOwningRoleOwningRoleBuild_thenReturnOwningRole() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand instance =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build();

    // Act and Assert
    assertEquals(
        "Owning Role", ImmutableSurveyInstanceOwningRoleSaveCommand.copyOf(instance).owningRole());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand immutableSurveyInstanceOwningRoleSaveCommand =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build();
    ImmutableSurveyInstanceOwningRoleSaveCommand immutableSurveyInstanceOwningRoleSaveCommand2 =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceOwningRoleSaveCommand,
        immutableSurveyInstanceOwningRoleSaveCommand2);
    assertEquals(
        immutableSurveyInstanceOwningRoleSaveCommand.hashCode(),
        immutableSurveyInstanceOwningRoleSaveCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand immutableSurveyInstanceOwningRoleSaveCommand =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceOwningRoleSaveCommand, immutableSurveyInstanceOwningRoleSaveCommand);
    int expectedHashCodeResult = immutableSurveyInstanceOwningRoleSaveCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceOwningRoleSaveCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand immutableSurveyInstanceOwningRoleSaveCommand =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("42").build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceOwningRoleSaveCommand,
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
    "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build(),
        "Different type to ImmutableSurveyInstanceOwningRoleSaveCommand");
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) OwningRole is {@code Json}.
   *   <li>Then return owningRole is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) OwningRole is 'Json'; then return owningRole is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonOwningRoleIsJson_thenReturnOwningRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setOwningRole("Json");

    // Act
    ImmutableSurveyInstanceOwningRoleSaveCommand actualFromJsonResult =
        ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.owningRole());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return owningRole is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return owningRole is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnOwningRoleIsNull() {
    // Arrange and Act
    ImmutableSurveyInstanceOwningRoleSaveCommand actualFromJsonResult =
        ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.owningRole());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#toString()}
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#owningRole()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyInstanceOwningRoleSaveCommand.owningRole()",
    "String ImmutableSurveyInstanceOwningRoleSaveCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand immutableSurveyInstanceOwningRoleSaveCommand =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build();

    // Act
    String actualToStringResult = immutableSurveyInstanceOwningRoleSaveCommand.toString();

    // Assert
    assertEquals("Owning Role", immutableSurveyInstanceOwningRoleSaveCommand.owningRole());
    assertEquals(
        "SurveyInstanceOwningRoleSaveCommand{owningRole=Owning Role}", actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOwningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setOwningRole(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setOwningRole("Owning Role");

    // Assert
    assertEquals("Owning Role", actualJson.owningRole);
  }

  /**
   * Test Json {@link Json#owningRole()}.
   *
   * <p>Method under test: {@link Json#owningRole()}
   */
  @Test
  @DisplayName("Test Json owningRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.owningRole()"})
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owningRole());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}.
   *
   * <ul>
   *   <li>Then return builder owningRole {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then return builder owningRole '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.withOwningRole(String)"
  })
  void testWithOwningRole_thenReturnBuilderOwningRole42Build() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand immutableSurveyInstanceOwningRoleSaveCommand =
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("42").build();

    // Act
    ImmutableSurveyInstanceOwningRoleSaveCommand actualWithOwningRoleResult =
        immutableSurveyInstanceOwningRoleSaveCommand.withOwningRole("42");

    // Assert
    assertSame(immutableSurveyInstanceOwningRoleSaveCommand, actualWithOwningRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}.
   *
   * <ul>
   *   <li>Then return owningRole is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then return owningRole is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.withOwningRole(String)"
  })
  void testWithOwningRole_thenReturnOwningRoleIs42() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
            .owningRole("Owning Role")
            .build()
            .withOwningRole("42")
            .owningRole());
  }
}
