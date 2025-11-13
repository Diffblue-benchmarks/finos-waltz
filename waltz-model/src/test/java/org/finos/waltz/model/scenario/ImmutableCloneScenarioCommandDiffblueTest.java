package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.scenario.ImmutableCloneScenarioCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCloneScenarioCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCloneScenarioCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCloneScenarioCommand actualImmutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableCloneScenarioCommand.userId());
    assertEquals("New Name", actualImmutableCloneScenarioCommand.newName());
    assertEquals(1L, actualImmutableCloneScenarioCommand.scenarioId());
  }

  /**
   * Test Builder {@link Builder#from(CloneScenarioCommand)}.
   *
   * <p>Method under test: {@link Builder#from(CloneScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CloneScenarioCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CloneScenarioCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();
    ImmutableCloneScenarioCommand instance =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCloneScenarioCommand actualImmutableCloneScenarioCommand = builderResult.build();
    assertEquals(instance, actualImmutableCloneScenarioCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newName(String)}.
   *
   * <ul>
   *   <li>When {@code New Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#newName(String)}
   */
  @Test
  @DisplayName("Test Builder newName(String); when 'New Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newName(String)"})
  void testBuilderNewName_whenNewName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act
    Builder actualNewNameResult = builderResult.newName("New Name");

    // Assert
    assertSame(builderResult, actualNewNameResult);
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   *
   * <p>Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act
    Builder actualScenarioIdResult = builderResult.scenarioId(1L);

    // Assert
    assertSame(builderResult, actualScenarioIdResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#copyOf(CloneScenarioCommand)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#copyOf(CloneScenarioCommand)}
   */
  @Test
  @DisplayName("Test copyOf(CloneScenarioCommand); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.copyOf(CloneScenarioCommand)"
  })
  void testCopyOf_thenReturnUserIdIs42() {
    // Arrange
    ImmutableCloneScenarioCommand instance =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Act
    ImmutableCloneScenarioCommand actualCopyOfResult =
        ImmutableCloneScenarioCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("New Name", actualCopyOfResult.newName());
    assertEquals(1L, actualCopyOfResult.scenarioId());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}, and {@link
   * ImmutableCloneScenarioCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCloneScenarioCommand#equals(Object)}
   *   <li>{@link ImmutableCloneScenarioCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand2 =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableCloneScenarioCommand, immutableCloneScenarioCommand2);
    assertEquals(
        immutableCloneScenarioCommand.hashCode(), immutableCloneScenarioCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}, and {@link
   * ImmutableCloneScenarioCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCloneScenarioCommand#equals(Object)}
   *   <li>{@link ImmutableCloneScenarioCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableCloneScenarioCommand, immutableCloneScenarioCommand);
    int expectedHashCodeResult = immutableCloneScenarioCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableCloneScenarioCommand.hashCode());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder().newName("42").scenarioId(1L).userId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableCloneScenarioCommand,
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(2L)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCloneScenarioCommand,
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("New Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCloneScenarioCommand,
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCloneScenarioCommand.equals(Object)",
    "int ImmutableCloneScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build(),
        "Different type to ImmutableCloneScenarioCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCloneScenarioCommand#toString()}
   *   <li>{@link ImmutableCloneScenarioCommand#newName()}
   *   <li>{@link ImmutableCloneScenarioCommand#scenarioId()}
   *   <li>{@link ImmutableCloneScenarioCommand#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCloneScenarioCommand.newName()",
    "long ImmutableCloneScenarioCommand.scenarioId()",
    "String ImmutableCloneScenarioCommand.toString()",
    "String ImmutableCloneScenarioCommand.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Act
    String actualToStringResult = immutableCloneScenarioCommand.toString();
    String actualNewNameResult = immutableCloneScenarioCommand.newName();
    long actualScenarioIdResult = immutableCloneScenarioCommand.scenarioId();

    // Assert
    assertEquals("42", immutableCloneScenarioCommand.userId());
    assertEquals(
        "CloneScenarioCommand{scenarioId=1, userId=42, newName=New Name}", actualToStringResult);
    assertEquals("New Name", actualNewNameResult);
    assertEquals(1L, actualScenarioIdResult);
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#withNewName(String)}.
   *
   * <ul>
   *   <li>Then return builder newName {@code 42} scenarioId one userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#withNewName(String)}
   */
  @Test
  @DisplayName(
      "Test withNewName(String); then return builder newName '42' scenarioId one userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.withNewName(String)"
  })
  void testWithNewName_thenReturnBuilderNewName42ScenarioIdOneUserId42Build() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder().newName("42").scenarioId(1L).userId("42").build();

    // Act
    ImmutableCloneScenarioCommand actualWithNewNameResult =
        immutableCloneScenarioCommand.withNewName("42");

    // Assert
    assertSame(immutableCloneScenarioCommand, actualWithNewNameResult);
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#withNewName(String)}.
   *
   * <ul>
   *   <li>Then return newName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#withNewName(String)}
   */
  @Test
  @DisplayName("Test withNewName(String); then return newName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.withNewName(String)"
  })
  void testWithNewName_thenReturnNewNameIs42() {
    // Arrange and Act
    ImmutableCloneScenarioCommand actualWithNewNameResult =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build()
            .withNewName("42");

    // Assert
    assertEquals("42", actualWithNewNameResult.newName());
    assertEquals("42", actualWithNewNameResult.userId());
    assertEquals(1L, actualWithNewNameResult.scenarioId());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#withScenarioId(long)}.
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.withScenarioId(long)"
  })
  void testWithScenarioId() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(42L)
            .userId("42")
            .build();

    // Act
    ImmutableCloneScenarioCommand actualWithScenarioIdResult =
        immutableCloneScenarioCommand.withScenarioId(42L);

    // Assert
    assertSame(immutableCloneScenarioCommand, actualWithScenarioIdResult);
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#withScenarioId(long)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.withScenarioId(long)"
  })
  void testWithScenarioId_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableCloneScenarioCommand actualWithScenarioIdResult =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build()
            .withScenarioId(42L);

    // Assert
    assertEquals("42", actualWithScenarioIdResult.userId());
    assertEquals("New Name", actualWithScenarioIdResult.newName());
    assertEquals(42L, actualWithScenarioIdResult.scenarioId());
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return builder newName {@code New Name} scenarioId one userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#withUserId(String)}
   */
  @Test
  @DisplayName(
      "Test withUserId(String); then return builder newName 'New Name' scenarioId one userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.withUserId(String)"
  })
  void testWithUserId_thenReturnBuilderNewNameNewNameScenarioIdOneUserId42Build() {
    // Arrange
    ImmutableCloneScenarioCommand immutableCloneScenarioCommand =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("42")
            .build();

    // Act
    ImmutableCloneScenarioCommand actualWithUserIdResult =
        immutableCloneScenarioCommand.withUserId("42");

    // Assert
    assertSame(immutableCloneScenarioCommand, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableCloneScenarioCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCloneScenarioCommand#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCloneScenarioCommand ImmutableCloneScenarioCommand.withUserId(String)"
  })
  void testWithUserId_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableCloneScenarioCommand actualWithUserIdResult =
        ImmutableCloneScenarioCommand.builder()
            .newName("New Name")
            .scenarioId(1L)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals("New Name", actualWithUserIdResult.newName());
    assertEquals(1L, actualWithUserIdResult.scenarioId());
  }
}
