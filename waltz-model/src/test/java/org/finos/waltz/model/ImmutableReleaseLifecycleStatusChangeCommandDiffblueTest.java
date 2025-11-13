package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand.Builder;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReleaseLifecycleStatusChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReleaseLifecycleStatusChangeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        ReleaseLifecycleStatus.DRAFT,
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build()
            .newStatus());
  }

  /**
   * Test Builder {@link Builder#from(ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newStatus {@code DRAFT} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReleaseLifecycleStatusChangeCommand); then builder build is builder newStatus 'DRAFT' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReleaseLifecycleStatusChangeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewStatusDraftBuild() {
    // Arrange
    Builder builderResult = ImmutableReleaseLifecycleStatusChangeCommand.builder();
    ImmutableReleaseLifecycleStatusChangeCommand instance =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReleaseLifecycleStatusChangeCommand
        actualImmutableReleaseLifecycleStatusChangeCommand = builderResult.build();
    assertEquals(instance, actualImmutableReleaseLifecycleStatusChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#newStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder newStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newStatus(ReleaseLifecycleStatus)"})
  void testBuilderNewStatus() {
    // Arrange
    Builder builderResult = ImmutableReleaseLifecycleStatusChangeCommand.builder();

    // Act
    Builder actualNewStatusResult = builderResult.newStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualNewStatusResult);
  }

  /**
   * Test {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#copyOf(ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>When builder newStatus {@code DRAFT} build.
   *   <li>Then return newStatus is {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#copyOf(ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReleaseLifecycleStatusChangeCommand); when builder newStatus 'DRAFT' build; then return newStatus is 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReleaseLifecycleStatusChangeCommand ImmutableReleaseLifecycleStatusChangeCommand.copyOf(ReleaseLifecycleStatusChangeCommand)"
  })
  void testCopyOf_whenBuilderNewStatusDraftBuild_thenReturnNewStatusIsDraft() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand instance =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(
        ReleaseLifecycleStatus.DRAFT,
        ImmutableReleaseLifecycleStatusChangeCommand.copyOf(instance).newStatus());
  }

  /**
   * Test {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}, and {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}
   *   <li>{@link ImmutableReleaseLifecycleStatusChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReleaseLifecycleStatusChangeCommand.equals(Object)",
    "int ImmutableReleaseLifecycleStatusChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand immutableReleaseLifecycleStatusChangeCommand =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();
    ImmutableReleaseLifecycleStatusChangeCommand immutableReleaseLifecycleStatusChangeCommand2 =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(
        immutableReleaseLifecycleStatusChangeCommand,
        immutableReleaseLifecycleStatusChangeCommand2);
    assertEquals(
        immutableReleaseLifecycleStatusChangeCommand.hashCode(),
        immutableReleaseLifecycleStatusChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}, and {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}
   *   <li>{@link ImmutableReleaseLifecycleStatusChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReleaseLifecycleStatusChangeCommand.equals(Object)",
    "int ImmutableReleaseLifecycleStatusChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand immutableReleaseLifecycleStatusChangeCommand =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act and Assert
    assertEquals(
        immutableReleaseLifecycleStatusChangeCommand, immutableReleaseLifecycleStatusChangeCommand);
    int expectedHashCodeResult = immutableReleaseLifecycleStatusChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableReleaseLifecycleStatusChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReleaseLifecycleStatusChangeCommand.equals(Object)",
    "int ImmutableReleaseLifecycleStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand immutableReleaseLifecycleStatusChangeCommand =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReleaseLifecycleStatusChangeCommand,
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build());
  }

  /**
   * Test {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReleaseLifecycleStatusChangeCommand.equals(Object)",
    "int ImmutableReleaseLifecycleStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReleaseLifecycleStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReleaseLifecycleStatusChangeCommand.equals(Object)",
    "int ImmutableReleaseLifecycleStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build(),
        "Different type to ImmutableReleaseLifecycleStatusChangeCommand");
  }

  /**
   * Test {@link ImmutableReleaseLifecycleStatusChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code DRAFT}.
   *   <li>When {@link Json} (default constructor) NewStatus is {@code DRAFT}.
   *   <li>Then return newStatus is {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReleaseLifecycleStatusChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'DRAFT'; when Json (default constructor) NewStatus is 'DRAFT'; then return newStatus is 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReleaseLifecycleStatusChangeCommand ImmutableReleaseLifecycleStatusChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenDraft_whenJsonNewStatusIsDraft_thenReturnNewStatusIsDraft() {
    // Arrange
    Json json = new Json();
    json.setNewStatus(ReleaseLifecycleStatus.DRAFT);

    // Act
    ImmutableReleaseLifecycleStatusChangeCommand actualFromJsonResult =
        ImmutableReleaseLifecycleStatusChangeCommand.fromJson(json);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualFromJsonResult.newStatus());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReleaseLifecycleStatusChangeCommand#toString()}
   *   <li>{@link ImmutableReleaseLifecycleStatusChangeCommand#newStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReleaseLifecycleStatus ImmutableReleaseLifecycleStatusChangeCommand.newStatus()",
    "String ImmutableReleaseLifecycleStatusChangeCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand immutableReleaseLifecycleStatusChangeCommand =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    String actualToStringResult = immutableReleaseLifecycleStatusChangeCommand.toString();

    // Assert
    assertEquals("ReleaseLifecycleStatusChangeCommand{newStatus=DRAFT}", actualToStringResult);
    assertEquals(
        ReleaseLifecycleStatus.DRAFT, immutableReleaseLifecycleStatusChangeCommand.newStatus());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewStatus(ReleaseLifecycleStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewStatus(ReleaseLifecycleStatus)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualJson.newStatus);
  }

  /**
   * Test Json {@link Json#newStatus()}.
   *
   * <p>Method under test: {@link Json#newStatus()}
   */
  @Test
  @DisplayName("Test Json newStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.newStatus()"})
  void testJsonNewStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newStatus());
  }

  /**
   * Test {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#withNewStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Given builder newStatus {@code ACTIVE} build.
   *   <li>Then return newStatus is {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#withNewStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withNewStatus(ReleaseLifecycleStatus); given builder newStatus 'ACTIVE' build; then return newStatus is 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReleaseLifecycleStatusChangeCommand ImmutableReleaseLifecycleStatusChangeCommand.withNewStatus(ReleaseLifecycleStatus)"
  })
  void testWithNewStatus_givenBuilderNewStatusActiveBuild_thenReturnNewStatusIsDraft() {
    // Arrange, Act and Assert
    assertEquals(
        ReleaseLifecycleStatus.DRAFT,
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.ACTIVE)
            .build()
            .withNewStatus(ReleaseLifecycleStatus.DRAFT)
            .newStatus());
  }

  /**
   * Test {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#withNewStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return builder newStatus {@code DRAFT} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReleaseLifecycleStatusChangeCommand#withNewStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withNewStatus(ReleaseLifecycleStatus); then return builder newStatus 'DRAFT' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReleaseLifecycleStatusChangeCommand ImmutableReleaseLifecycleStatusChangeCommand.withNewStatus(ReleaseLifecycleStatus)"
  })
  void testWithNewStatus_thenReturnBuilderNewStatusDraftBuild() {
    // Arrange
    ImmutableReleaseLifecycleStatusChangeCommand immutableReleaseLifecycleStatusChangeCommand =
        ImmutableReleaseLifecycleStatusChangeCommand.builder()
            .newStatus(ReleaseLifecycleStatus.DRAFT)
            .build();

    // Act
    ImmutableReleaseLifecycleStatusChangeCommand actualWithNewStatusResult =
        immutableReleaseLifecycleStatusChangeCommand.withNewStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutableReleaseLifecycleStatusChangeCommand, actualWithNewStatusResult);
  }
}
