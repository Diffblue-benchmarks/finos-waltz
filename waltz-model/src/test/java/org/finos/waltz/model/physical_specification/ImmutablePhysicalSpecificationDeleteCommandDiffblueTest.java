package org.finos.waltz.model.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand.Builder;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecificationDeleteCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalSpecificationDeleteCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        1L,
        ImmutablePhysicalSpecificationDeleteCommand.builder()
            .specificationId(1L)
            .build()
            .specificationId());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecificationDeleteCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder specificationId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecificationDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecificationDeleteCommand); then builder build is builder specificationId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecificationDeleteCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderSpecificationIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationDeleteCommand.builder();
    ImmutablePhysicalSpecificationDeleteCommand instance =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecificationDeleteCommand actualImmutablePhysicalSpecificationDeleteCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecificationDeleteCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#specificationId(long)}.
   *
   * <p>Method under test: {@link Builder#specificationId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specificationId(long)"})
  void testBuilderSpecificationId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecificationDeleteCommand.builder();

    // Act
    Builder actualSpecificationIdResult = builderResult.specificationId(1L);

    // Assert
    assertEquals(1L, builderResult.build().specificationId());
    assertSame(builderResult, actualSpecificationIdResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecificationDeleteCommand#copyOf(PhysicalSpecificationDeleteCommand)}.
   *
   * <ul>
   *   <li>When builder specificationId one build.
   *   <li>Then return specificationId is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecificationDeleteCommand#copyOf(PhysicalSpecificationDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalSpecificationDeleteCommand); when builder specificationId one build; then return specificationId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationDeleteCommand ImmutablePhysicalSpecificationDeleteCommand.copyOf(PhysicalSpecificationDeleteCommand)"
  })
  void testCopyOf_whenBuilderSpecificationIdOneBuild_thenReturnSpecificationIdIsOne() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand instance =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act and Assert
    assertEquals(
        1L, ImmutablePhysicalSpecificationDeleteCommand.copyOf(instance).specificationId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecificationDeleteCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecificationDeleteCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationDeleteCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationDeleteCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand immutablePhysicalSpecificationDeleteCommand =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();
    ImmutablePhysicalSpecificationDeleteCommand immutablePhysicalSpecificationDeleteCommand2 =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecificationDeleteCommand, immutablePhysicalSpecificationDeleteCommand2);
    assertEquals(
        immutablePhysicalSpecificationDeleteCommand.hashCode(),
        immutablePhysicalSpecificationDeleteCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}, and {@link
   * ImmutablePhysicalSpecificationDeleteCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecificationDeleteCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationDeleteCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationDeleteCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand immutablePhysicalSpecificationDeleteCommand =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecificationDeleteCommand, immutablePhysicalSpecificationDeleteCommand);
    int expectedHashCodeResult = immutablePhysicalSpecificationDeleteCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalSpecificationDeleteCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationDeleteCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand immutablePhysicalSpecificationDeleteCommand =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecificationDeleteCommand,
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationDeleteCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build(), null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecificationDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecificationDeleteCommand.equals(Object)",
    "int ImmutablePhysicalSpecificationDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build(),
        "Different type to ImmutablePhysicalSpecificationDeleteCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecificationDeleteCommand#toString()}
   *   <li>{@link ImmutablePhysicalSpecificationDeleteCommand#specificationId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutablePhysicalSpecificationDeleteCommand.specificationId()",
    "String ImmutablePhysicalSpecificationDeleteCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand immutablePhysicalSpecificationDeleteCommand =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act
    String actualToStringResult = immutablePhysicalSpecificationDeleteCommand.toString();

    // Assert
    assertEquals("PhysicalSpecificationDeleteCommand{specificationId=1}", actualToStringResult);
    assertEquals(1L, immutablePhysicalSpecificationDeleteCommand.specificationId());
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
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#setSpecificationId(long)}.
   *
   * <p>Method under test: {@link Json#setSpecificationId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSpecificationId(long)"})
  void testJsonSetSpecificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#specificationId()}.
   *
   * <p>Method under test: {@link Json#specificationId()}
   */
  @Test
  @DisplayName("Test Json specificationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.specificationId()"})
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specificationId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#withSpecificationId(long)}.
   *
   * <ul>
   *   <li>Then return builder specificationId forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecificationDeleteCommand#withSpecificationId(long)}
   */
  @Test
  @DisplayName(
      "Test withSpecificationId(long); then return builder specificationId forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationDeleteCommand ImmutablePhysicalSpecificationDeleteCommand.withSpecificationId(long)"
  })
  void testWithSpecificationId_thenReturnBuilderSpecificationIdFortyTwoBuild() {
    // Arrange
    ImmutablePhysicalSpecificationDeleteCommand immutablePhysicalSpecificationDeleteCommand =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(42L).build();

    // Act
    ImmutablePhysicalSpecificationDeleteCommand actualWithSpecificationIdResult =
        immutablePhysicalSpecificationDeleteCommand.withSpecificationId(42L);

    // Assert
    assertSame(immutablePhysicalSpecificationDeleteCommand, actualWithSpecificationIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecificationDeleteCommand#withSpecificationId(long)}.
   *
   * <ul>
   *   <li>Then return specificationId is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecificationDeleteCommand#withSpecificationId(long)}
   */
  @Test
  @DisplayName("Test withSpecificationId(long); then return specificationId is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecificationDeleteCommand ImmutablePhysicalSpecificationDeleteCommand.withSpecificationId(long)"
  })
  void testWithSpecificationId_thenReturnSpecificationIdIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        ImmutablePhysicalSpecificationDeleteCommand.builder()
            .specificationId(1L)
            .build()
            .withSpecificationId(42L)
            .specificationId());
  }
}
