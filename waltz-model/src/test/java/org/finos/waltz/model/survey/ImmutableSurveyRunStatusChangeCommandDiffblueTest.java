package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyRunStatusChangeCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunStatusChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunStatusChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyRunStatusChangeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        SurveyRunStatus.DRAFT,
        ImmutableSurveyRunStatusChangeCommand.builder()
            .newStatus(SurveyRunStatus.DRAFT)
            .build()
            .newStatus());
  }

  /**
   * Test Builder {@link Builder#from(SurveyRunStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder newStatus {@code DRAFT} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyRunStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyRunStatusChangeCommand); then builder build is builder newStatus 'DRAFT' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyRunStatusChangeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewStatusDraftBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunStatusChangeCommand.builder();
    ImmutableSurveyRunStatusChangeCommand instance =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyRunStatusChangeCommand actualImmutableSurveyRunStatusChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyRunStatusChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newStatus(SurveyRunStatus)}.
   *
   * <p>Method under test: {@link Builder#newStatus(SurveyRunStatus)}
   */
  @Test
  @DisplayName("Test Builder newStatus(SurveyRunStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newStatus(SurveyRunStatus)"})
  void testBuilderNewStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunStatusChangeCommand.builder();

    // Act
    Builder actualNewStatusResult = builderResult.newStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualNewStatusResult);
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#copyOf(SurveyRunStatusChangeCommand)}.
   *
   * <ul>
   *   <li>When builder newStatus {@code DRAFT} build.
   *   <li>Then return newStatus is {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunStatusChangeCommand#copyOf(SurveyRunStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyRunStatusChangeCommand); when builder newStatus 'DRAFT' build; then return newStatus is 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunStatusChangeCommand ImmutableSurveyRunStatusChangeCommand.copyOf(SurveyRunStatusChangeCommand)"
  })
  void testCopyOf_whenBuilderNewStatusDraftBuild_thenReturnNewStatusIsDraft() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand instance =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();

    // Act and Assert
    assertEquals(
        SurveyRunStatus.DRAFT, ImmutableSurveyRunStatusChangeCommand.copyOf(instance).newStatus());
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyRunStatusChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyRunStatusChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyRunStatusChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand immutableSurveyRunStatusChangeCommand =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();
    ImmutableSurveyRunStatusChangeCommand immutableSurveyRunStatusChangeCommand2 =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();

    // Act and Assert
    assertEquals(immutableSurveyRunStatusChangeCommand, immutableSurveyRunStatusChangeCommand2);
    assertEquals(
        immutableSurveyRunStatusChangeCommand.hashCode(),
        immutableSurveyRunStatusChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyRunStatusChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyRunStatusChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyRunStatusChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand immutableSurveyRunStatusChangeCommand =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();

    // Act and Assert
    assertEquals(immutableSurveyRunStatusChangeCommand, immutableSurveyRunStatusChangeCommand);
    int expectedHashCodeResult = immutableSurveyRunStatusChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyRunStatusChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyRunStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand immutableSurveyRunStatusChangeCommand =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.ISSUED).build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyRunStatusChangeCommand,
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build());
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyRunStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyRunStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyRunStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build(),
        "Different type to ImmutableSurveyRunStatusChangeCommand");
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code DRAFT}.
   *   <li>When {@link Json} (default constructor) NewStatus is {@code DRAFT}.
   *   <li>Then return newStatus is {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyRunStatusChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'DRAFT'; when Json (default constructor) NewStatus is 'DRAFT'; then return newStatus is 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunStatusChangeCommand ImmutableSurveyRunStatusChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenDraft_whenJsonNewStatusIsDraft_thenReturnNewStatusIsDraft() {
    // Arrange
    Json json = new Json();
    json.setNewStatus(SurveyRunStatus.DRAFT);

    // Act
    ImmutableSurveyRunStatusChangeCommand actualFromJsonResult =
        ImmutableSurveyRunStatusChangeCommand.fromJson(json);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, actualFromJsonResult.newStatus());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyRunStatusChangeCommand#toString()}
   *   <li>{@link ImmutableSurveyRunStatusChangeCommand#newStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyRunStatus ImmutableSurveyRunStatusChangeCommand.newStatus()",
    "String ImmutableSurveyRunStatusChangeCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand immutableSurveyRunStatusChangeCommand =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();

    // Act
    String actualToStringResult = immutableSurveyRunStatusChangeCommand.toString();

    // Assert
    assertEquals("SurveyRunStatusChangeCommand{newStatus=DRAFT}", actualToStringResult);
    assertEquals(SurveyRunStatus.DRAFT, immutableSurveyRunStatusChangeCommand.newStatus());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewStatus(SurveyRunStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewStatus(SurveyRunStatus)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, actualJson.newStatus);
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
  @MethodsUnderTest({"SurveyRunStatus Json.newStatus()"})
  void testJsonNewStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newStatus());
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#withNewStatus(SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Given builder newStatus {@code ISSUED} build.
   *   <li>Then return newStatus is {@code DRAFT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunStatusChangeCommand#withNewStatus(SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test withNewStatus(SurveyRunStatus); given builder newStatus 'ISSUED' build; then return newStatus is 'DRAFT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunStatusChangeCommand ImmutableSurveyRunStatusChangeCommand.withNewStatus(SurveyRunStatus)"
  })
  void testWithNewStatus_givenBuilderNewStatusIssuedBuild_thenReturnNewStatusIsDraft() {
    // Arrange, Act and Assert
    assertEquals(
        SurveyRunStatus.DRAFT,
        ImmutableSurveyRunStatusChangeCommand.builder()
            .newStatus(SurveyRunStatus.ISSUED)
            .build()
            .withNewStatus(SurveyRunStatus.DRAFT)
            .newStatus());
  }

  /**
   * Test {@link ImmutableSurveyRunStatusChangeCommand#withNewStatus(SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Then return builder newStatus {@code DRAFT} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyRunStatusChangeCommand#withNewStatus(SurveyRunStatus)}
   */
  @Test
  @DisplayName("Test withNewStatus(SurveyRunStatus); then return builder newStatus 'DRAFT' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyRunStatusChangeCommand ImmutableSurveyRunStatusChangeCommand.withNewStatus(SurveyRunStatus)"
  })
  void testWithNewStatus_thenReturnBuilderNewStatusDraftBuild() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand immutableSurveyRunStatusChangeCommand =
        ImmutableSurveyRunStatusChangeCommand.builder().newStatus(SurveyRunStatus.DRAFT).build();

    // Act
    ImmutableSurveyRunStatusChangeCommand actualWithNewStatusResult =
        immutableSurveyRunStatusChangeCommand.withNewStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertSame(immutableSurveyRunStatusChangeCommand, actualWithNewStatusResult);
  }
}
