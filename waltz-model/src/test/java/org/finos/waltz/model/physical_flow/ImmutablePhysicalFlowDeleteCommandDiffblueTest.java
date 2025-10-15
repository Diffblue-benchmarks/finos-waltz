package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDeleteCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowDeleteCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(1L, ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build().flowId());
  }

  /**
   * Test Builder {@link Builder#flowId(long)}.
   *
   * <p>Method under test: {@link Builder#flowId(long)}
   */
  @Test
  @DisplayName("Test Builder flowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowId(long)"})
  void testBuilderFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommand.builder();

    // Act
    Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertEquals(1L, builderResult.build().flowId());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder flowId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalFlowDeleteCommand); then builder build is builder flowId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderFlowIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommand.builder();
    ImmutablePhysicalFlowDeleteCommand instance =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowDeleteCommand actualImmutablePhysicalFlowDeleteCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowDeleteCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#copyOf(PhysicalFlowDeleteCommand)}.
   *
   * <ul>
   *   <li>When builder flowId one build.
   *   <li>Then return flowId is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowDeleteCommand#copyOf(PhysicalFlowDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowDeleteCommand); when builder flowId one build; then return flowId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommand ImmutablePhysicalFlowDeleteCommand.copyOf(PhysicalFlowDeleteCommand)"
  })
  void testCopyOf_whenBuilderFlowIdOneBuild_thenReturnFlowIdIsOne() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand instance =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();

    // Act and Assert
    assertEquals(1L, ImmutablePhysicalFlowDeleteCommand.copyOf(instance).flowId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowDeleteCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommand.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand immutablePhysicalFlowDeleteCommand =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();
    ImmutablePhysicalFlowDeleteCommand immutablePhysicalFlowDeleteCommand2 =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowDeleteCommand, immutablePhysicalFlowDeleteCommand2);
    assertEquals(
        immutablePhysicalFlowDeleteCommand.hashCode(),
        immutablePhysicalFlowDeleteCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowDeleteCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommand.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand immutablePhysicalFlowDeleteCommand =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowDeleteCommand, immutablePhysicalFlowDeleteCommand);
    int expectedHashCodeResult = immutablePhysicalFlowDeleteCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowDeleteCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommand.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand immutablePhysicalFlowDeleteCommand =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowDeleteCommand,
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommand.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build(), null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowDeleteCommand.equals(Object)",
    "int ImmutablePhysicalFlowDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build(),
        "Different type to ImmutablePhysicalFlowDeleteCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowDeleteCommand#toString()}
   *   <li>{@link ImmutablePhysicalFlowDeleteCommand#flowId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutablePhysicalFlowDeleteCommand.flowId()",
    "String ImmutablePhysicalFlowDeleteCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand immutablePhysicalFlowDeleteCommand =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();

    // Act
    String actualToStringResult = immutablePhysicalFlowDeleteCommand.toString();

    // Assert
    assertEquals("PhysicalFlowDeleteCommand{flowId=1}", actualToStringResult);
    assertEquals(1L, immutablePhysicalFlowDeleteCommand.flowId());
  }

  /**
   * Test Json {@link Json#flowId()}.
   *
   * <p>Method under test: {@link Json#flowId()}
   */
  @Test
  @DisplayName("Test Json flowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.flowId()"})
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowId());
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
    assertEquals(0L, actualJson.flowId);
    assertFalse(actualJson.flowIdIsSet);
  }

  /**
   * Test Json {@link Json#setFlowId(long)}.
   *
   * <p>Method under test: {@link Json#setFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setFlowId(long)"})
  void testJsonSetFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setFlowId(1L);

    // Assert
    assertEquals(1L, json.flowId);
    assertTrue(json.flowIdIsSet);
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#withFlowId(long)}.
   *
   * <ul>
   *   <li>Given builder flowId one build.
   *   <li>Then return flowId is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommand#withFlowId(long)}
   */
  @Test
  @DisplayName(
      "Test withFlowId(long); given builder flowId one build; then return flowId is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommand ImmutablePhysicalFlowDeleteCommand.withFlowId(long)"
  })
  void testWithFlowId_givenBuilderFlowIdOneBuild_thenReturnFlowIdIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build().withFlowId(42L).flowId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowDeleteCommand#withFlowId(long)}.
   *
   * <ul>
   *   <li>Then return builder flowId forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowDeleteCommand#withFlowId(long)}
   */
  @Test
  @DisplayName("Test withFlowId(long); then return builder flowId forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowDeleteCommand ImmutablePhysicalFlowDeleteCommand.withFlowId(long)"
  })
  void testWithFlowId_thenReturnBuilderFlowIdFortyTwoBuild() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand immutablePhysicalFlowDeleteCommand =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(42L).build();

    // Act
    ImmutablePhysicalFlowDeleteCommand actualWithFlowIdResult =
        immutablePhysicalFlowDeleteCommand.withFlowId(42L);

    // Assert
    assertSame(immutablePhysicalFlowDeleteCommand, actualWithFlowIdResult);
  }
}
