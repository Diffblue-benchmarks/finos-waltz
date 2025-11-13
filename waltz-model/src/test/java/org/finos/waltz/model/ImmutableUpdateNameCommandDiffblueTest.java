package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableUpdateNameCommand.Builder;
import org.finos.waltz.model.ImmutableUpdateNameCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateNameCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateNameCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        "New Name", ImmutableUpdateNameCommand.builder().newName("New Name").build().newName());
  }

  /**
   * Test Builder {@link Builder#from(UpdateNameCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newName {@code New Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateNameCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateNameCommand); then builder build is builder newName 'New Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateNameCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewNameNewNameBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateNameCommand.builder();
    ImmutableUpdateNameCommand instance =
        ImmutableUpdateNameCommand.builder().newName("New Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateNameCommand actualImmutableUpdateNameCommand = builderResult.build();
    assertEquals(instance, actualImmutableUpdateNameCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newName(String)}.
   *
   * <ul>
   *   <li>When {@code New Name}.
   *   <li>Then builder build newName is {@code New Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#newName(String)}
   */
  @Test
  @DisplayName(
      "Test Builder newName(String); when 'New Name'; then builder build newName is 'New Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newName(String)"})
  void testBuilderNewName_whenNewName_thenBuilderBuildNewNameIsNewName() {
    // Arrange
    Builder builderResult = ImmutableUpdateNameCommand.builder();

    // Act
    Builder actualNewNameResult = builderResult.newName("New Name");

    // Assert
    assertEquals("New Name", builderResult.build().newName());
    assertSame(builderResult, actualNewNameResult);
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#copyOf(UpdateNameCommand)}.
   *
   * <ul>
   *   <li>When builder newName {@code New Name} build.
   *   <li>Then return {@code New Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#copyOf(UpdateNameCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateNameCommand); when builder newName 'New Name' build; then return 'New Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateNameCommand ImmutableUpdateNameCommand.copyOf(UpdateNameCommand)"
  })
  void testCopyOf_whenBuilderNewNameNewNameBuild_thenReturnNewName() {
    // Arrange
    ImmutableUpdateNameCommand instance =
        ImmutableUpdateNameCommand.builder().newName("New Name").build();

    // Act and Assert
    assertEquals("New Name", ImmutableUpdateNameCommand.copyOf(instance).newName());
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#equals(Object)}, and {@link
   * ImmutableUpdateNameCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateNameCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateNameCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateNameCommand.equals(Object)",
    "int ImmutableUpdateNameCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateNameCommand immutableUpdateNameCommand =
        ImmutableUpdateNameCommand.builder().newName("New Name").build();
    ImmutableUpdateNameCommand immutableUpdateNameCommand2 =
        ImmutableUpdateNameCommand.builder().newName("New Name").build();

    // Act and Assert
    assertEquals(immutableUpdateNameCommand, immutableUpdateNameCommand2);
    assertEquals(immutableUpdateNameCommand.hashCode(), immutableUpdateNameCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#equals(Object)}, and {@link
   * ImmutableUpdateNameCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateNameCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateNameCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateNameCommand.equals(Object)",
    "int ImmutableUpdateNameCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateNameCommand immutableUpdateNameCommand =
        ImmutableUpdateNameCommand.builder().newName("New Name").build();

    // Act and Assert
    assertEquals(immutableUpdateNameCommand, immutableUpdateNameCommand);
    int expectedHashCodeResult = immutableUpdateNameCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateNameCommand.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateNameCommand.equals(Object)",
    "int ImmutableUpdateNameCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateNameCommand immutableUpdateNameCommand =
        ImmutableUpdateNameCommand.builder().newName("java.lang.String").build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateNameCommand,
        ImmutableUpdateNameCommand.builder().newName("New Name").build());
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateNameCommand.equals(Object)",
    "int ImmutableUpdateNameCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUpdateNameCommand.builder().newName("New Name").build(), null);
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateNameCommand.equals(Object)",
    "int ImmutableUpdateNameCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateNameCommand.builder().newName("New Name").build(),
        "Different type to ImmutableUpdateNameCommand");
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) NewName is {@code Json}.
   *   <li>Then return newName is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) NewName is 'Json'; then return newName is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateNameCommand ImmutableUpdateNameCommand.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNewNameIsJson_thenReturnNewNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setNewName("Json");

    // Act
    ImmutableUpdateNameCommand actualFromJsonResult = ImmutableUpdateNameCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.newName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateNameCommand#toString()}
   *   <li>{@link ImmutableUpdateNameCommand#newName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUpdateNameCommand.newName()",
    "String ImmutableUpdateNameCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateNameCommand immutableUpdateNameCommand =
        ImmutableUpdateNameCommand.builder().newName("New Name").build();

    // Act
    String actualToStringResult = immutableUpdateNameCommand.toString();

    // Assert
    assertEquals("New Name", immutableUpdateNameCommand.newName());
    assertEquals("UpdateNameCommand{newName=New Name}", actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewName("New Name");

    // Assert
    assertEquals("New Name", actualJson.newName);
  }

  /**
   * Test Json {@link Json#newName()}.
   *
   * <p>Method under test: {@link Json#newName()}
   */
  @Test
  @DisplayName("Test Json newName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.newName()"})
  void testJsonNewName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newName());
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#withNewName(String)}.
   *
   * <ul>
   *   <li>Given builder newName {@code 42} build.
   *   <li>Then return builder newName {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#withNewName(String)}
   */
  @Test
  @DisplayName(
      "Test withNewName(String); given builder newName '42' build; then return builder newName '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateNameCommand ImmutableUpdateNameCommand.withNewName(String)"})
  void testWithNewName_givenBuilderNewName42Build_thenReturnBuilderNewName42Build() {
    // Arrange
    ImmutableUpdateNameCommand immutableUpdateNameCommand =
        ImmutableUpdateNameCommand.builder().newName("42").build();

    // Act
    ImmutableUpdateNameCommand actualWithNewNameResult =
        immutableUpdateNameCommand.withNewName("42");

    // Assert
    assertSame(immutableUpdateNameCommand, actualWithNewNameResult);
  }

  /**
   * Test {@link ImmutableUpdateNameCommand#withNewName(String)}.
   *
   * <ul>
   *   <li>Given builder newName {@code New Name} build.
   *   <li>Then return newName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateNameCommand#withNewName(String)}
   */
  @Test
  @DisplayName(
      "Test withNewName(String); given builder newName 'New Name' build; then return newName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUpdateNameCommand ImmutableUpdateNameCommand.withNewName(String)"})
  void testWithNewName_givenBuilderNewNameNewNameBuild_thenReturnNewNameIs42() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        ImmutableUpdateNameCommand.builder()
            .newName("New Name")
            .build()
            .withNewName("42")
            .newName());
  }
}
