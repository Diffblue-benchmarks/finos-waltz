package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowSpecDefinitionChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowSpecDefinitionChangeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        1L,
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
            .newSpecDefinitionId(1L)
            .build()
            .newSpecDefinitionId());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newSpecDefinitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalFlowSpecDefinitionChangeCommand); then builder build is builder newSpecDefinitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowSpecDefinitionChangeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewSpecDefinitionIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder();
    ImmutablePhysicalFlowSpecDefinitionChangeCommand instance =
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder().newSpecDefinitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        actualImmutablePhysicalFlowSpecDefinitionChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowSpecDefinitionChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newSpecDefinitionId(long)}.
   *
   * <p>Method under test: {@link Builder#newSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder newSpecDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newSpecDefinitionId(long)"})
  void testBuilderNewSpecDefinitionId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder();

    // Act
    Builder actualNewSpecDefinitionIdResult = builderResult.newSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().newSpecDefinitionId());
    assertSame(builderResult, actualNewSpecDefinitionIdResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalFlowSpecDefinitionChangeCommand#copyOf(PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Then return newSpecDefinitionId is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowSpecDefinitionChangeCommand#copyOf(PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowSpecDefinitionChangeCommand); then return newSpecDefinitionId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowSpecDefinitionChangeCommand ImmutablePhysicalFlowSpecDefinitionChangeCommand.copyOf(PhysicalFlowSpecDefinitionChangeCommand)"
  })
  void testCopyOf_thenReturnNewSpecDefinitionIdIsOne() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand instance =
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder().newSpecDefinitionId(1L).build();

    // Act and Assert
    assertEquals(
        1L,
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.copyOf(instance).newSpecDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowSpecDefinitionChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalFlowSpecDefinitionChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        immutablePhysicalFlowSpecDefinitionChangeCommand =
            ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
                .newSpecDefinitionId(1L)
                .build();
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        immutablePhysicalFlowSpecDefinitionChangeCommand2 =
            ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
                .newSpecDefinitionId(1L)
                .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowSpecDefinitionChangeCommand,
        immutablePhysicalFlowSpecDefinitionChangeCommand2);
    assertEquals(
        immutablePhysicalFlowSpecDefinitionChangeCommand.hashCode(),
        immutablePhysicalFlowSpecDefinitionChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowSpecDefinitionChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalFlowSpecDefinitionChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        immutablePhysicalFlowSpecDefinitionChangeCommand =
            ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
                .newSpecDefinitionId(1L)
                .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalFlowSpecDefinitionChangeCommand,
        immutablePhysicalFlowSpecDefinitionChangeCommand);
    int expectedHashCodeResult = immutablePhysicalFlowSpecDefinitionChangeCommand.hashCode();
    assertEquals(
        expectedHashCodeResult, immutablePhysicalFlowSpecDefinitionChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalFlowSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        immutablePhysicalFlowSpecDefinitionChangeCommand =
            ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
                .newSpecDefinitionId(2L)
                .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowSpecDefinitionChangeCommand,
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder().newSpecDefinitionId(1L).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalFlowSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder().newSpecDefinitionId(1L).build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowSpecDefinitionChangeCommand.equals(Object)",
    "int ImmutablePhysicalFlowSpecDefinitionChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder().newSpecDefinitionId(1L).build(),
        "Different type to ImmutablePhysicalFlowSpecDefinitionChangeCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#toString()}
   *   <li>{@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#newSpecDefinitionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutablePhysicalFlowSpecDefinitionChangeCommand.newSpecDefinitionId()",
    "String ImmutablePhysicalFlowSpecDefinitionChangeCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        immutablePhysicalFlowSpecDefinitionChangeCommand =
            ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
                .newSpecDefinitionId(1L)
                .build();

    // Act
    String actualToStringResult = immutablePhysicalFlowSpecDefinitionChangeCommand.toString();

    // Assert
    assertEquals(
        "PhysicalFlowSpecDefinitionChangeCommand{newSpecDefinitionId=1}", actualToStringResult);
    assertEquals(1L, immutablePhysicalFlowSpecDefinitionChangeCommand.newSpecDefinitionId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0L, actualJson.newSpecDefinitionId);
    assertFalse(actualJson.newSpecDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#newSpecDefinitionId()}.
   *
   * <p>Method under test: {@link Json#newSpecDefinitionId()}
   */
  @Test
  @DisplayName("Test Json newSpecDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.newSpecDefinitionId()"})
  void testJsonNewSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newSpecDefinitionId());
  }

  /**
   * Test Json {@link Json#setNewSpecDefinitionId(long)}.
   *
   * <p>Method under test: {@link Json#setNewSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setNewSpecDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setNewSpecDefinitionId(long)"})
  void testJsonSetNewSpecDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setNewSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.newSpecDefinitionId);
    assertTrue(json.newSpecDefinitionIdIsSet);
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#withNewSpecDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return builder newSpecDefinitionId forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowSpecDefinitionChangeCommand#withNewSpecDefinitionId(long)}
   */
  @Test
  @DisplayName(
      "Test withNewSpecDefinitionId(long); then return builder newSpecDefinitionId forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowSpecDefinitionChangeCommand ImmutablePhysicalFlowSpecDefinitionChangeCommand.withNewSpecDefinitionId(long)"
  })
  void testWithNewSpecDefinitionId_thenReturnBuilderNewSpecDefinitionIdFortyTwoBuild() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand
        immutablePhysicalFlowSpecDefinitionChangeCommand =
            ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
                .newSpecDefinitionId(42L)
                .build();

    // Act
    ImmutablePhysicalFlowSpecDefinitionChangeCommand actualWithNewSpecDefinitionIdResult =
        immutablePhysicalFlowSpecDefinitionChangeCommand.withNewSpecDefinitionId(42L);

    // Assert
    assertSame(
        immutablePhysicalFlowSpecDefinitionChangeCommand, actualWithNewSpecDefinitionIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#withNewSpecDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return newSpecDefinitionId is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowSpecDefinitionChangeCommand#withNewSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withNewSpecDefinitionId(long); then return newSpecDefinitionId is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowSpecDefinitionChangeCommand ImmutablePhysicalFlowSpecDefinitionChangeCommand.withNewSpecDefinitionId(long)"
  })
  void testWithNewSpecDefinitionId_thenReturnNewSpecDefinitionIdIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder()
            .newSpecDefinitionId(1L)
            .build()
            .withNewSpecDefinitionId(42L)
            .newSpecDefinitionId());
  }
}
