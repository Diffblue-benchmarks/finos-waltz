package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwningRoleSaveCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwningRoleSaveCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwningRoleSaveCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#owningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceOwningRoleSaveCommand Builder.build()",
      "Builder Builder.owningRole(String)"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals("Owning Role",
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build().owningRole());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}.
   * <ul>
   *   <li>Then builder build is builder owningRole {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceOwningRoleSaveCommand); then builder build is builder owningRole 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwningRoleSaveCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderOwningRoleNullBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder();
    ImmutableSurveyInstanceOwningRoleSaveCommand instance = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole(null)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}.
   * <ul>
   *   <li>Then builder build is builder owningRole {@code Owning Role} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceOwningRoleSaveCommand); then builder build is builder owningRole 'Owning Role' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwningRoleSaveCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderOwningRoleOwningRoleBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder();
    ImmutableSurveyInstanceOwningRoleSaveCommand instance = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#copyOf(SurveyInstanceOwningRoleSaveCommand)}.
   * <ul>
   *   <li>When builder owningRole {@code Owning Role} build.</li>
   *   <li>Then return {@code Owning Role}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#copyOf(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyInstanceOwningRoleSaveCommand); when builder owningRole 'Owning Role' build; then return 'Owning Role'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.copyOf(SurveyInstanceOwningRoleSaveCommand)"})
  void testCopyOf_whenBuilderOwningRoleOwningRoleBuild_thenReturnOwningRole() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand instance = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertEquals("Owning Role", ImmutableSurveyInstanceOwningRoleSaveCommand.copyOf(instance).owningRole());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}, and {@link ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
      "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult2 = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}, and {@link ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
      "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
      "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("42")
        .build();
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult2 = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
      "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceOwningRoleSaveCommand.equals(Object)",
      "int ImmutableSurveyInstanceOwningRoleSaveCommand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSurveyInstanceOwningRoleSaveCommand");
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link Json} (default constructor) OwningRole is {@code Json}.</li>
   *   <li>Then return owningRole is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) OwningRole is 'Json'; then return owningRole is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonOwningRoleIsJson_thenReturnOwningRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setOwningRole("Json");

    // Act and Assert
    assertEquals("Json", ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(json).owningRole());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return owningRole is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return owningRole is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnOwningRoleIsNull() {
    // Arrange, Act and Assert
    assertNull(ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(new Json()).owningRole());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#toString()}
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand#owningRole()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableSurveyInstanceOwningRoleSaveCommand.owningRole()",
      "String ImmutableSurveyInstanceOwningRoleSaveCommand.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("Owning Role", buildResult.owningRole());
    assertEquals("SurveyInstanceOwningRoleSaveCommand{owningRole=Owning Role}", actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOwningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#owningRole()}
   */
  @Test
  @DisplayName("Test Json owningRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.owningRole()"})
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).owningRole());
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}.
   * <ul>
   *   <li>Then return builder owningRole {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then return builder owningRole '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.withOwningRole(String)"})
  void testWithOwningRole_thenReturnBuilderOwningRole42Build() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("42")
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withOwningRole("42"));
  }

  /**
   * Test {@link ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}.
   * <ul>
   *   <li>Then return owningRole is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceOwningRoleSaveCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then return owningRole is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceOwningRoleSaveCommand ImmutableSurveyInstanceOwningRoleSaveCommand.withOwningRole(String)"})
  void testWithOwningRole_thenReturnOwningRoleIs42() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand buildResult = ImmutableSurveyInstanceOwningRoleSaveCommand.builder()
        .owningRole("Owning Role")
        .build();

    // Act and Assert
    assertEquals("42", buildResult.withOwningRole("42").owningRole());
  }
}
