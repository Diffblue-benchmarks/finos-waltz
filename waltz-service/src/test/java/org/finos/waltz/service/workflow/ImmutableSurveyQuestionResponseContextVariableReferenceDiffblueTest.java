package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.service.workflow.ImmutableSurveyQuestionResponseContextVariableReference.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseContextVariableReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionResponseContextVariableReference Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextVariableReference
        actualImmutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Assert
    assertEquals("42", actualImmutableSurveyQuestionResponseContextVariableReference.externalId());
    assertEquals(
        "42", actualImmutableSurveyQuestionResponseContextVariableReference.surveyExternalId());
    assertEquals(
        EntityKind.ALL, actualImmutableSurveyQuestionResponseContextVariableReference.kind());
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
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)} with {@code
   * ContextVariableReference}.
   *
   * <p>Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference) with 'ContextVariableReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFromWithContextVariableReference() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
    ImmutableSurveyQuestionResponseContextVariableReference instance =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ContextVariableReference) instance);

    // Assert
    ImmutableSurveyQuestionResponseContextVariableReference
        actualImmutableSurveyQuestionResponseContextVariableReference = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponseContextVariableReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)} with {@code
   * ContextVariableReference}.
   *
   * <ul>
   *   <li>When builder externalId {@code 42} kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ContextVariableReference) with 'ContextVariableReference'; when builder externalId '42' kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFromWithContextVariableReference_whenBuilderExternalId42KindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextVariableReference)} with {@code
   * SurveyQuestionResponseContextVariableReference}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyQuestionResponseContextVariableReference) with 'SurveyQuestionResponseContextVariableReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextVariableReference)"})
  void testBuilderFromWithSurveyQuestionResponseContextVariableReference() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
    ImmutableSurveyQuestionResponseContextVariableReference instance =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionResponseContextVariableReference
        actualImmutableSurveyQuestionResponseContextVariableReference = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponseContextVariableReference);
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
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#surveyExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#surveyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder surveyExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyExternalId(String)"})
  void testBuilderSurveyExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act
    Builder actualSurveyExternalIdResult = builderResult.surveyExternalId("42");

    // Assert
    assertSame(builderResult, actualSurveyExternalIdResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#copyOf(SurveyQuestionResponseContextVariableReference)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#copyOf(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyQuestionResponseContextVariableReference); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.copyOf(SurveyQuestionResponseContextVariableReference)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference instance =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build();

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference actualCopyOfResult =
        ImmutableSurveyQuestionResponseContextVariableReference.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.surveyExternalId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}, and {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference2 =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act and Assert
    assertEquals(
        immutableSurveyQuestionResponseContextVariableReference,
        immutableSurveyQuestionResponseContextVariableReference2);
    assertEquals(
        immutableSurveyQuestionResponseContextVariableReference.hashCode(),
        immutableSurveyQuestionResponseContextVariableReference2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}, and {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act and Assert
    assertEquals(
        immutableSurveyQuestionResponseContextVariableReference,
        immutableSurveyQuestionResponseContextVariableReference);
    int expectedHashCodeResult = immutableSurveyQuestionResponseContextVariableReference.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableSurveyQuestionResponseContextVariableReference.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("External Id")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponseContextVariableReference,
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ACTOR)
                .surveyExternalId("42")
                .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponseContextVariableReference,
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("Survey External Id")
                .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponseContextVariableReference,
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextVariableReference.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextVariableReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build(),
        "Different type to ImmutableSurveyQuestionResponseContextVariableReference");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#toString()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#externalId()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#kind()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextVariableReference#surveyExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyQuestionResponseContextVariableReference.externalId()",
    "EntityKind ImmutableSurveyQuestionResponseContextVariableReference.kind()",
    "String ImmutableSurveyQuestionResponseContextVariableReference.surveyExternalId()",
    "String ImmutableSurveyQuestionResponseContextVariableReference.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act
    String actualToStringResult =
        immutableSurveyQuestionResponseContextVariableReference.toString();
    String actualExternalIdResult =
        immutableSurveyQuestionResponseContextVariableReference.externalId();
    EntityKind actualKindResult = immutableSurveyQuestionResponseContextVariableReference.kind();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("42", immutableSurveyQuestionResponseContextVariableReference.surveyExternalId());
    assertEquals(
        "SurveyQuestionResponseContextVariableReference{kind=ALL, externalId=42, surveyExternalId=42}",
        actualToStringResult);
    assertEquals(EntityKind.ALL, actualKindResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#withExternalId(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("0123456789ABCDEF")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference actualWithExternalIdResult =
        immutableSurveyQuestionResponseContextVariableReference.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableSurveyQuestionResponseContextVariableReference, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.withExternalId(String)"
  })
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextVariableReference actualWithExternalIdResult =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("42")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("42", actualWithExternalIdResult.surveyExternalId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return builder externalId {@code 42} kind {@code ALL} surveyExternalId {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return builder externalId '42' kind 'ALL' surveyExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.withKind(EntityKind)"
  })
  void testWithKind_thenReturnBuilderExternalId42KindAllSurveyExternalId42Build() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference actualWithKindResult =
        immutableSurveyQuestionResponseContextVariableReference.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyQuestionResponseContextVariableReference, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextVariableReference#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.withKind(EntityKind)"
  })
  void testWithKind_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextVariableReference actualWithKindResult =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ACTOR)
            .surveyExternalId("42")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("42", actualWithKindResult.externalId());
    assertEquals("42", actualWithKindResult.surveyExternalId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
  }

  /**
   * Test {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withSurveyExternalId(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test withSurveyExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.withSurveyExternalId(String)"
  })
  void testWithSurveyExternalId() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference
        immutableSurveyQuestionResponseContextVariableReference =
            ImmutableSurveyQuestionResponseContextVariableReference.builder()
                .externalId("42")
                .kind(EntityKind.ALL)
                .surveyExternalId("42")
                .build();

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference actualWithSurveyExternalIdResult =
        immutableSurveyQuestionResponseContextVariableReference.withSurveyExternalId("42");

    // Assert
    assertSame(
        immutableSurveyQuestionResponseContextVariableReference, actualWithSurveyExternalIdResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withSurveyExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextVariableReference#withSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test withSurveyExternalId(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextVariableReference ImmutableSurveyQuestionResponseContextVariableReference.withSurveyExternalId(String)"
  })
  void testWithSurveyExternalId_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextVariableReference actualWithSurveyExternalIdResult =
        ImmutableSurveyQuestionResponseContextVariableReference.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .surveyExternalId("surveyExternalId")
            .build()
            .withSurveyExternalId("42");

    // Assert
    assertEquals("42", actualWithSurveyExternalIdResult.externalId());
    assertEquals("42", actualWithSurveyExternalIdResult.surveyExternalId());
    assertEquals(EntityKind.ALL, actualWithSurveyExternalIdResult.kind());
  }
}
