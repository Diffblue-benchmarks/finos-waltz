package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.service.workflow.ImmutableContextVariableReference.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariableReference Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableContextVariableReference actualImmutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Assert
    assertEquals("42", actualImmutableContextVariableReference.externalId());
    assertEquals(EntityKind.ALL, actualImmutableContextVariableReference.kind());
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)}.
   *
   * <ul>
   *   <li>Then builder build externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference); then builder build externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFrom_thenBuilderBuildExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build());

    // Assert
    ImmutableContextVariableReference immutableContextVariableReference = builderResult.build();
    assertEquals("42", immutableContextVariableReference.externalId());
    assertEquals(EntityKind.ALL, immutableContextVariableReference.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)}.
   *
   * <ul>
   *   <li>Then builder build is builder externalId {@code 42} kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ContextVariableReference); then builder build is builder externalId '42' kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderExternalId42KindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();
    ImmutableContextVariableReference instance =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableContextVariableReference actualImmutableContextVariableReference =
        builderResult.build();
    assertEquals(instance, actualImmutableContextVariableReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test {@link ImmutableContextVariableReference#copyOf(ContextVariableReference)}.
   *
   * <ul>
   *   <li>When builder externalId {@code 42} kind {@code ALL} build.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableContextVariableReference#copyOf(ContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ContextVariableReference); when builder externalId '42' kind 'ALL' build; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableReference ImmutableContextVariableReference.copyOf(ContextVariableReference)"
  })
  void testCopyOf_whenBuilderExternalId42KindAllBuild_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableContextVariableReference instance =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Act
    ImmutableContextVariableReference actualCopyOfResult =
        ImmutableContextVariableReference.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableContextVariableReference#copyOf(ContextVariableReference)}.
   *
   * <ul>
   *   <li>When builder externalId {@code 42} kind {@code ALL} surveyExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableContextVariableReference#copyOf(ContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ContextVariableReference); when builder externalId '42' kind 'ALL' surveyExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableReference ImmutableContextVariableReference.copyOf(ContextVariableReference)"
  })
  void testCopyOf_whenBuilderExternalId42KindAllSurveyExternalId42Build() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference instance =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build();

    // Act
    ImmutableContextVariableReference actualCopyOfResult =
        ImmutableContextVariableReference.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableContextVariableReference#equals(Object)}, and {@link
   * ImmutableContextVariableReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariableReference#equals(Object)}
   *   <li>{@link ImmutableContextVariableReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableReference.equals(Object)",
    "int ImmutableContextVariableReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();
    ImmutableContextVariableReference immutableContextVariableReference2 =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableContextVariableReference, immutableContextVariableReference2);
    assertEquals(
        immutableContextVariableReference.hashCode(),
        immutableContextVariableReference2.hashCode());
  }

  /**
   * Test {@link ImmutableContextVariableReference#equals(Object)}, and {@link
   * ImmutableContextVariableReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariableReference#equals(Object)}
   *   <li>{@link ImmutableContextVariableReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableReference.equals(Object)",
    "int ImmutableContextVariableReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableContextVariableReference, immutableContextVariableReference);
    int expectedHashCodeResult = immutableContextVariableReference.hashCode();
    assertEquals(expectedHashCodeResult, immutableContextVariableReference.hashCode());
  }

  /**
   * Test {@link ImmutableContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableReference.equals(Object)",
    "int ImmutableContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder()
            .externalId("External Id")
            .kind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableContextVariableReference,
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableReference.equals(Object)",
    "int ImmutableContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ACTOR).build();

    // Act and Assert
    assertNotEquals(
        immutableContextVariableReference,
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableReference.equals(Object)",
    "int ImmutableContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build(),
        null);
  }

  /**
   * Test {@link ImmutableContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariableReference.equals(Object)",
    "int ImmutableContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build(),
        "Different type to ImmutableContextVariableReference");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariableReference#toString()}
   *   <li>{@link ImmutableContextVariableReference#externalId()}
   *   <li>{@link ImmutableContextVariableReference#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableContextVariableReference.externalId()",
    "EntityKind ImmutableContextVariableReference.kind()",
    "String ImmutableContextVariableReference.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Act
    String actualToStringResult = immutableContextVariableReference.toString();
    String actualExternalIdResult = immutableContextVariableReference.externalId();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("ContextVariableReference{kind=ALL, externalId=42}", actualToStringResult);
    assertEquals(EntityKind.ALL, immutableContextVariableReference.kind());
  }

  /**
   * Test {@link ImmutableContextVariableReference#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder externalId {@code 0123456789ABCDEF} kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String); then return builder externalId '0123456789ABCDEF' kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableReference ImmutableContextVariableReference.withExternalId(String)"
  })
  void testWithExternalId_thenReturnBuilderExternalId0123456789abcdefKindAllBuild() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder()
            .externalId("0123456789ABCDEF")
            .kind(EntityKind.ALL)
            .build();

    // Act
    ImmutableContextVariableReference actualWithExternalIdResult =
        immutableContextVariableReference.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableContextVariableReference, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableContextVariableReference#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableReference ImmutableContextVariableReference.withExternalId(String)"
  })
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableContextVariableReference actualWithExternalIdResult =
        ImmutableContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
  }

  /**
   * Test {@link ImmutableContextVariableReference#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given builder externalId {@code 42} kind {@code ACTOR} build.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); given builder externalId '42' kind 'ACTOR' build; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableReference ImmutableContextVariableReference.withKind(EntityKind)"
  })
  void testWithKind_givenBuilderExternalId42KindActorBuild_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableContextVariableReference actualWithKindResult =
        ImmutableContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ACTOR)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("42", actualWithKindResult.externalId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
  }

  /**
   * Test {@link ImmutableContextVariableReference#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return builder externalId {@code 42} kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariableReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return builder externalId '42' kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariableReference ImmutableContextVariableReference.withKind(EntityKind)"
  })
  void testWithKind_thenReturnBuilderExternalId42KindAllBuild() {
    // Arrange
    ImmutableContextVariableReference immutableContextVariableReference =
        ImmutableContextVariableReference.builder().externalId("42").kind(EntityKind.ALL).build();

    // Act
    ImmutableContextVariableReference actualWithKindResult =
        immutableContextVariableReference.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableContextVariableReference, actualWithKindResult);
  }
}
