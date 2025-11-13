package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionDiffblueTest {
  /**
   * Test {@link ImmutableSurveyQuestion#allowComment()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#allowComment()}
   */
  @Test
  @DisplayName("Test allowComment(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ImmutableSurveyQuestion.allowComment()"})
  void testAllowComment_thenReturnFalse() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(false)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertFalse(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#allowComment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#allowComment()}
   */
  @Test
  @DisplayName("Test allowComment(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ImmutableSurveyQuestion.allowComment()"})
  void testAllowComment_thenReturnTrue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertTrue(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .allowComment());
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#allowComment(Boolean)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#helpText(String)}
   *   <li>{@link Builder#inclusionPredicate(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#label(String)}
   *   <li>{@link Builder#parentExternalId(String)}
   *   <li>{@link Builder#position(Integer)}
   *   <li>{@link Builder#qualifierEntity(EntityReference)}
   *   <li>{@link Builder#sectionName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.allowComment(Boolean)",
    "ImmutableSurveyQuestion Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.helpText(String)",
    "Builder Builder.inclusionPredicate(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.label(String)",
    "Builder Builder.parentExternalId(String)",
    "Builder Builder.position(Integer)",
    "Builder Builder.qualifierEntity(EntityReference)",
    "Builder Builder.sectionName(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableSurveyQuestion.builder().allowComment(true).externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualHelpTextResult =
        actualExternalIdResult
            .externalId(externalId)
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text");
    Optional<String> helpText = Optional.of("42");
    Builder actualIdResult = actualHelpTextResult.helpText(helpText).id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualInclusionPredicateResult =
        actualIdResult.id(id).inclusionPredicate("Inclusion Predicate");
    Optional<String> inclusionPredicate = Optional.of("42");
    Builder actualLabelResult =
        actualInclusionPredicateResult
            .inclusionPredicate(inclusionPredicate)
            .kind(EntityKind.ALL)
            .label("Label");
    Optional<String> label = Optional.of("42");
    Builder actualParentExternalIdResult = actualLabelResult.label(label).parentExternalId("42");
    Optional<String> parentExternalId = Optional.of("42");
    Builder actualPositionResult =
        actualParentExternalIdResult.parentExternalId(parentExternalId).position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    Builder actualQualifierEntityResult = actualPositionResult.qualifierEntity(qualifierEntity);
    Builder actualSectionNameResult =
        actualQualifierEntityResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name");
    Optional<String> sectionName = Optional.of("42");
    ImmutableSurveyQuestion actualImmutableSurveyQuestion =
        actualSectionNameResult.sectionName(sectionName).surveyTemplateId(1L).build();

    // Assert
    assertEquals("Question Text", actualImmutableSurveyQuestion.questionText());
    assertEquals(1, actualImmutableSurveyQuestion.position().intValue());
    assertEquals(1L, actualImmutableSurveyQuestion.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableSurveyQuestion.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualImmutableSurveyQuestion.fieldType());
    assertFalse(actualImmutableSurveyQuestion.isMandatory());
    assertTrue(actualImmutableSurveyQuestion.allowComment());
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#fieldType(SurveyQuestionFieldType)}.
   *
   * <p>Method under test: {@link Builder#fieldType(SurveyQuestionFieldType)}
   */
  @Test
  @DisplayName("Test Builder fieldType(SurveyQuestionFieldType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fieldType(SurveyQuestionFieldType)"})
  void testBuilderFieldType() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act
    Builder actualFieldTypeResult = builderResult.fieldType(SurveyQuestionFieldType.APPLICATION);

    // Assert
    assertSame(builderResult, actualFieldTypeResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion instance =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSurveyQuestion actualImmutableSurveyQuestion = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestion);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion instance =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSurveyQuestion actualImmutableSurveyQuestion = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestion);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion instance =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestion actualImmutableSurveyQuestion = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestion);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    Optional<? extends EntityReference> qualifierEntity = Optional.empty();
    ImmutableSurveyQuestion instance =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestion actualImmutableSurveyQuestion = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestion);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#helpText(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#helpText(Optional)}
   */
  @Test
  @DisplayName("Test Builder helpText(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.helpText(Optional)"})
  void testBuilderHelpTextWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> helpText = Optional.of("42");

    // Act
    Builder actualHelpTextResult = builderResult.helpText(helpText);

    // Assert
    assertSame(builderResult, actualHelpTextResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#inclusionPredicate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#inclusionPredicate(Optional)}
   */
  @Test
  @DisplayName("Test Builder inclusionPredicate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inclusionPredicate(Optional)"})
  void testBuilderInclusionPredicateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> inclusionPredicate = Optional.of("42");

    // Act
    Builder actualInclusionPredicateResult = builderResult.inclusionPredicate(inclusionPredicate);

    // Assert
    assertSame(builderResult, actualInclusionPredicateResult);
  }

  /**
   * Test Builder {@link Builder#isMandatory(boolean)}.
   *
   * <p>Method under test: {@link Builder#isMandatory(boolean)}
   */
  @Test
  @DisplayName("Test Builder isMandatory(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isMandatory(boolean)"})
  void testBuilderIsMandatory() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act
    Builder actualIsMandatoryResult = builderResult.isMandatory(true);

    // Assert
    assertSame(builderResult, actualIsMandatoryResult);
  }

  /**
   * Test Builder {@link Builder#label(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#label(Optional)}
   */
  @Test
  @DisplayName("Test Builder label(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.label(Optional)"})
  void testBuilderLabelWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> label = Optional.of("42");

    // Act
    Builder actualLabelResult = builderResult.label(label);

    // Assert
    assertSame(builderResult, actualLabelResult);
  }

  /**
   * Test Builder {@link Builder#parentExternalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentExternalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentExternalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentExternalId(Optional)"})
  void testBuilderParentExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> parentExternalId = Optional.of("42");

    // Act
    Builder actualParentExternalIdResult = builderResult.parentExternalId(parentExternalId);

    // Assert
    assertSame(builderResult, actualParentExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#qualifierEntity(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#qualifierEntity(Optional)}
   */
  @Test
  @DisplayName("Test Builder qualifierEntity(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.qualifierEntity(Optional)"})
  void testBuilderQualifierEntityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Builder actualQualifierEntityResult = builderResult.qualifierEntity(qualifierEntity);

    // Assert
    assertSame(builderResult, actualQualifierEntityResult);
  }

  /**
   * Test Builder {@link Builder#questionText(String)}.
   *
   * <ul>
   *   <li>When {@code Question Text}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#questionText(String)}
   */
  @Test
  @DisplayName("Test Builder questionText(String); when 'Question Text'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questionText(String)"})
  void testBuilderQuestionText_whenQuestionText_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act
    Builder actualQuestionTextResult = builderResult.questionText("Question Text");

    // Assert
    assertSame(builderResult, actualQuestionTextResult);
  }

  /**
   * Test Builder {@link Builder#sectionName(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#sectionName(Optional)}
   */
  @Test
  @DisplayName("Test Builder sectionName(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sectionName(Optional)"})
  void testBuilderSectionNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> sectionName = Optional.of("42");

    // Act
    Builder actualSectionNameResult = builderResult.sectionName(sectionName);

    // Assert
    assertSame(builderResult, actualSectionNameResult);
  }

  /**
   * Test Builder {@link Builder#surveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link Builder#surveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyTemplateId(Long)"})
  void testBuilderSurveyTemplateId() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act
    Builder actualSurveyTemplateIdResult = builderResult.surveyTemplateId(1L);

    // Assert
    assertSame(builderResult, actualSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyQuestion); then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.copyOf(SurveyQuestion)"})
  void testCopyOf_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion instance =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

    // Assert
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertFalse(actualCopyOfResult.isMandatory());
    assertTrue(actualCopyOfResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}, and {@link
   * ImmutableSurveyQuestion#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestion#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);
    ImmutableSurveyQuestion immutableSurveyQuestion2 =
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestion, immutableSurveyQuestion2);
    assertEquals(immutableSurveyQuestion.hashCode(), immutableSurveyQuestion2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}, and {@link
   * ImmutableSurveyQuestion#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestion#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestion, immutableSurveyQuestion);
    int expectedHashCodeResult = immutableSurveyQuestion.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyQuestion.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(false)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("Question Text")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.BOOLEAN)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Question Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(2L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Question Text")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ACTOR)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Question Text")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("Question Text")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(0);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("allowComment")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Question Text")
            .surveyTemplateId(1L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(2L)
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestion,
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestion.equals(Object)",
    "int ImmutableSurveyQuestion.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build(),
        "Different type to ImmutableSurveyQuestion");
  }

  /**
   * Test {@link ImmutableSurveyQuestion#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.externalId()"})
  void testExternalId() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualExternalIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestion#fieldType()}
   *   <li>{@link ImmutableSurveyQuestion#questionText()}
   *   <li>{@link ImmutableSurveyQuestion#surveyTemplateId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyQuestionFieldType ImmutableSurveyQuestion.fieldType()",
    "String ImmutableSurveyQuestion.questionText()",
    "Long ImmutableSurveyQuestion.surveyTemplateId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    SurveyQuestionFieldType actualFieldTypeResult = immutableSurveyQuestion.fieldType();
    String actualQuestionTextResult = immutableSurveyQuestion.questionText();

    // Assert
    assertEquals("Question Text", actualQuestionTextResult);
    assertEquals(1L, immutableSurveyQuestion.surveyTemplateId().longValue());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualFieldTypeResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#helpText()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#helpText()}
   */
  @Test
  @DisplayName("Test helpText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.helpText()"})
  void testHelpText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualHelpTextResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .helpText();

    // Assert
    assertEquals("Help Text", actualHelpTextResult.get());
    assertTrue(actualHelpTextResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.id()"})
  void testId() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<Long> actualIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#inclusionPredicate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#inclusionPredicate()}
   */
  @Test
  @DisplayName("Test inclusionPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.inclusionPredicate()"})
  void testInclusionPredicate() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualInclusionPredicateResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .inclusionPredicate();

    // Assert
    assertEquals("Inclusion Predicate", actualInclusionPredicateResult.get());
    assertTrue(actualInclusionPredicateResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#isMandatory()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#isMandatory()}
   */
  @Test
  @DisplayName("Test isMandatory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSurveyQuestion.isMandatory()"})
  void testIsMandatory() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertFalse(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .isMandatory());
  }

  /**
   * Test Json {@link Json#allowComment()}.
   *
   * <p>Method under test: {@link Json#allowComment()}
   */
  @Test
  @DisplayName("Test Json allowComment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Json.allowComment()"})
  void testJsonAllowComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allowComment());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#fieldType()}.
   *
   * <p>Method under test: {@link Json#fieldType()}
   */
  @Test
  @DisplayName("Test Json fieldType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyQuestionFieldType Json.fieldType()"})
  void testJsonFieldType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fieldType());
  }

  /**
   * Test Json {@link Json#helpText()}.
   *
   * <p>Method under test: {@link Json#helpText()}
   */
  @Test
  @DisplayName("Test Json helpText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.helpText()"})
  void testJsonHelpText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().helpText());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#inclusionPredicate()}.
   *
   * <p>Method under test: {@link Json#inclusionPredicate()}
   */
  @Test
  @DisplayName("Test Json inclusionPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.inclusionPredicate()"})
  void testJsonInclusionPredicate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inclusionPredicate());
  }

  /**
   * Test Json {@link Json#isMandatory()}.
   *
   * <p>Method under test: {@link Json#isMandatory()}
   */
  @Test
  @DisplayName("Test Json isMandatory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isMandatory()"})
  void testJsonIsMandatory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isMandatory());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#label()}.
   *
   * <p>Method under test: {@link Json#label()}
   */
  @Test
  @DisplayName("Test Json label()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.label()"})
  void testJsonLabel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().label());
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
    assertNull(actualJson.allowComment);
    assertNull(actualJson.position);
    assertNull(actualJson.surveyTemplateId);
    assertNull(actualJson.questionText);
    assertNull(actualJson.kind);
    assertNull(actualJson.fieldType);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.helpText.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.inclusionPredicate.isPresent());
    assertFalse(actualJson.label.isPresent());
    assertFalse(actualJson.parentExternalId.isPresent());
    assertFalse(actualJson.qualifierEntity.isPresent());
    assertFalse(actualJson.sectionName.isPresent());
    assertFalse(actualJson.isMandatory);
    assertFalse(actualJson.isMandatoryIsSet);
  }

  /**
   * Test Json {@link Json#parentExternalId()}.
   *
   * <p>Method under test: {@link Json#parentExternalId()}
   */
  @Test
  @DisplayName("Test Json parentExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentExternalId()"})
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentExternalId());
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#qualifierEntity()}.
   *
   * <p>Method under test: {@link Json#qualifierEntity()}
   */
  @Test
  @DisplayName("Test Json qualifierEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.qualifierEntity()"})
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().qualifierEntity());
  }

  /**
   * Test Json {@link Json#questionText()}.
   *
   * <p>Method under test: {@link Json#questionText()}
   */
  @Test
  @DisplayName("Test Json questionText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.questionText()"})
  void testJsonQuestionText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().questionText());
  }

  /**
   * Test Json {@link Json#sectionName()}.
   *
   * <p>Method under test: {@link Json#sectionName()}
   */
  @Test
  @DisplayName("Test Json sectionName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.sectionName()"})
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sectionName());
  }

  /**
   * Test Json {@link Json#setIsMandatory(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsMandatory(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsMandatory(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsMandatory(boolean)"})
  void testJsonSetIsMandatory() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsMandatory(true);

    // Assert
    assertTrue(json.isMandatory);
    assertTrue(json.isMandatoryIsSet);
  }

  /**
   * Test Json {@link Json#surveyTemplateId()}.
   *
   * <p>Method under test: {@link Json#surveyTemplateId()}
   */
  @Test
  @DisplayName("Test Json surveyTemplateId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.surveyTemplateId()"})
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyTemplateId());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#kind()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableSurveyQuestion.kind()"})
  void testKind() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#label()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#label()}
   */
  @Test
  @DisplayName("Test label()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.label()"})
  void testLabel() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualLabelResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .label();

    // Assert
    assertEquals("Label", actualLabelResult.get());
    assertTrue(actualLabelResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#parentExternalId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#parentExternalId()}
   */
  @Test
  @DisplayName("Test parentExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.parentExternalId()"})
  void testParentExternalId() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualParentExternalIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .parentExternalId();

    // Assert
    assertEquals("42", actualParentExternalIdResult.get());
    assertTrue(actualParentExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#position()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ImmutableSurveyQuestion.position()"})
  void testPosition() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        1,
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .position()
            .intValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#qualifierEntity()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#qualifierEntity()}
   */
  @Test
  @DisplayName("Test qualifierEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.qualifierEntity()"})
  void testQualifierEntity() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        qualifierEntity,
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .qualifierEntity());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#sectionName()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#sectionName()}
   */
  @Test
  @DisplayName("Test sectionName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestion.sectionName()"})
  void testSectionName() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualSectionNameResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .sectionName();

    // Assert
    assertEquals("Section Name", actualSectionNameResult.get());
    assertTrue(actualSectionNameResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestion.toString()"})
  void testToString() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "SurveyQuestion{id=1, externalId=42, surveyTemplateId=1, questionText=Question Text, helpText=Help Text,"
            + " fieldType=APPLICATION, sectionName=Section Name, inclusionPredicate=Inclusion Predicate, qualifierEntity"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, position=1, isMandatory=false,"
            + " allowComment=true, label=Label, parentExternalId=42, kind=ALL}",
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestion.toString()"})
  void testToString2() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    Optional<? extends EntityReference> qualifierEntity = Optional.empty();

    // Act and Assert
    assertEquals(
        "SurveyQuestion{id=1, externalId=42, surveyTemplateId=1, questionText=Question Text, helpText=Help Text,"
            + " fieldType=APPLICATION, sectionName=Section Name, inclusionPredicate=Inclusion Predicate, position=1,"
            + " isMandatory=false, allowComment=true, label=Label, parentExternalId=42, kind=ALL}",
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withAllowComment(Boolean)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withAllowComment(Boolean)}
   */
  @Test
  @DisplayName("Test withAllowComment(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withAllowComment(Boolean)"})
  void testWithAllowComment() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithAllowCommentResult =
        immutableSurveyQuestion.withAllowComment(true);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithAllowCommentResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withAllowComment(Boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withAllowComment(Boolean)}
   */
  @Test
  @DisplayName("Test withAllowComment(Boolean); then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withAllowComment(Boolean)"})
  void testWithAllowComment_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(false)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithAllowCommentResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withAllowComment(true);

    // Assert
    assertEquals("Question Text", actualWithAllowCommentResult.questionText());
    assertEquals(1, actualWithAllowCommentResult.position().intValue());
    assertEquals(1L, actualWithAllowCommentResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithAllowCommentResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithAllowCommentResult.fieldType());
    assertFalse(actualWithAllowCommentResult.isMandatory());
    assertTrue(actualWithAllowCommentResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithExternalIdResult =
        immutableSurveyQuestion.withExternalId(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("External Id")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithExternalIdResult =
        immutableSurveyQuestion.withExternalId(optional);

    // Assert
    assertEquals("Question Text", actualWithExternalIdResult.questionText());
    assertEquals(1, actualWithExternalIdResult.position().intValue());
    assertEquals(1L, actualWithExternalIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithExternalIdResult.fieldType());
    assertFalse(actualWithExternalIdResult.isMandatory());
    assertTrue(actualWithExternalIdResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithExternalIdResult =
        immutableSurveyQuestion.withExternalId("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithExternalIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Question Text", actualWithExternalIdResult.questionText());
    assertEquals(1, actualWithExternalIdResult.position().intValue());
    assertEquals(1L, actualWithExternalIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithExternalIdResult.fieldType());
    assertFalse(actualWithExternalIdResult.isMandatory());
    assertTrue(actualWithExternalIdResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withFieldType(SurveyQuestionFieldType)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withFieldType(SurveyQuestionFieldType)}
   */
  @Test
  @DisplayName("Test withFieldType(SurveyQuestionFieldType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withFieldType(SurveyQuestionFieldType)"
  })
  void testWithFieldType() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithFieldTypeResult =
        immutableSurveyQuestion.withFieldType(SurveyQuestionFieldType.APPLICATION);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithFieldTypeResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withFieldType(SurveyQuestionFieldType)}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withFieldType(SurveyQuestionFieldType)}
   */
  @Test
  @DisplayName("Test withFieldType(SurveyQuestionFieldType); then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withFieldType(SurveyQuestionFieldType)"
  })
  void testWithFieldType_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.BOOLEAN)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithFieldTypeResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withFieldType(SurveyQuestionFieldType.APPLICATION);

    // Assert
    assertEquals("Question Text", actualWithFieldTypeResult.questionText());
    assertEquals(1, actualWithFieldTypeResult.position().intValue());
    assertEquals(1L, actualWithFieldTypeResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithFieldTypeResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithFieldTypeResult.fieldType());
    assertFalse(actualWithFieldTypeResult.isMandatory());
    assertTrue(actualWithFieldTypeResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withHelpText(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withHelpText(Optional)}
   */
  @Test
  @DisplayName("Test withHelpText(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withHelpText(Optional)"})
  void testWithHelpTextWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("42")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithHelpTextResult =
        immutableSurveyQuestion.withHelpText(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithHelpTextResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withHelpText(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withHelpText(Optional)}
   */
  @Test
  @DisplayName("Test withHelpText(Optional) with 'optional'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withHelpText(Optional)"})
  void testWithHelpTextWithOptional_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithHelpTextResult =
        immutableSurveyQuestion.withHelpText(optional);

    // Assert
    assertEquals("Question Text", actualWithHelpTextResult.questionText());
    assertEquals(1, actualWithHelpTextResult.position().intValue());
    assertEquals(1L, actualWithHelpTextResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithHelpTextResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithHelpTextResult.fieldType());
    assertFalse(actualWithHelpTextResult.isMandatory());
    assertTrue(actualWithHelpTextResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withHelpText(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withHelpText(String)}
   */
  @Test
  @DisplayName("Test withHelpText(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withHelpText(String)"})
  void testWithHelpTextWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("42")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithHelpTextResult = immutableSurveyQuestion.withHelpText("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithHelpTextResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withHelpText(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withHelpText(String)}
   */
  @Test
  @DisplayName("Test withHelpText(String) with 'value'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withHelpText(String)"})
  void testWithHelpTextWithValue_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithHelpTextResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withHelpText("42");

    // Assert
    assertEquals("Question Text", actualWithHelpTextResult.questionText());
    assertEquals(1, actualWithHelpTextResult.position().intValue());
    assertEquals(1L, actualWithHelpTextResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithHelpTextResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithHelpTextResult.fieldType());
    assertFalse(actualWithHelpTextResult.isMandatory());
    assertTrue(actualWithHelpTextResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyQuestion actualWithIdResult = immutableSurveyQuestion.withId(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSurveyQuestion actualWithIdResult = immutableSurveyQuestion.withId(optional);

    // Assert
    assertEquals("Question Text", actualWithIdResult.questionText());
    assertEquals(1, actualWithIdResult.position().intValue());
    assertEquals(1L, actualWithIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithIdResult.fieldType());
    assertFalse(actualWithIdResult.isMandatory());
    assertTrue(actualWithIdResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithIdResult = immutableSurveyQuestion.withId(1L);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Question Text", actualWithIdResult.questionText());
    assertEquals(1, actualWithIdResult.position().intValue());
    assertEquals(1L, actualWithIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithIdResult.fieldType());
    assertFalse(actualWithIdResult.isMandatory());
    assertTrue(actualWithIdResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withInclusionPredicate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withInclusionPredicate(Optional)}
   */
  @Test
  @DisplayName("Test withInclusionPredicate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withInclusionPredicate(Optional)"
  })
  void testWithInclusionPredicateWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("42")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithInclusionPredicateResult =
        immutableSurveyQuestion.withInclusionPredicate(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithInclusionPredicateResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withInclusionPredicate(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withInclusionPredicate(Optional)}
   */
  @Test
  @DisplayName("Test withInclusionPredicate(Optional) with 'optional'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withInclusionPredicate(Optional)"
  })
  void testWithInclusionPredicateWithOptional_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithInclusionPredicateResult =
        immutableSurveyQuestion.withInclusionPredicate(optional);

    // Assert
    assertEquals("Question Text", actualWithInclusionPredicateResult.questionText());
    assertEquals(1, actualWithInclusionPredicateResult.position().intValue());
    assertEquals(1L, actualWithInclusionPredicateResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithInclusionPredicateResult.kind());
    assertEquals(
        SurveyQuestionFieldType.APPLICATION, actualWithInclusionPredicateResult.fieldType());
    assertFalse(actualWithInclusionPredicateResult.isMandatory());
    assertTrue(actualWithInclusionPredicateResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withInclusionPredicate(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withInclusionPredicate(String)}
   */
  @Test
  @DisplayName("Test withInclusionPredicate(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withInclusionPredicate(String)"
  })
  void testWithInclusionPredicateWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("42")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithInclusionPredicateResult =
        immutableSurveyQuestion.withInclusionPredicate("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithInclusionPredicateResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withInclusionPredicate(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withInclusionPredicate(String)}
   */
  @Test
  @DisplayName("Test withInclusionPredicate(String) with 'value'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withInclusionPredicate(String)"
  })
  void testWithInclusionPredicateWithValue_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithInclusionPredicateResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withInclusionPredicate("42");

    // Assert
    assertEquals("Question Text", actualWithInclusionPredicateResult.questionText());
    assertEquals(1, actualWithInclusionPredicateResult.position().intValue());
    assertEquals(1L, actualWithInclusionPredicateResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithInclusionPredicateResult.kind());
    assertEquals(
        SurveyQuestionFieldType.APPLICATION, actualWithInclusionPredicateResult.fieldType());
    assertFalse(actualWithInclusionPredicateResult.isMandatory());
    assertTrue(actualWithInclusionPredicateResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withIsMandatory(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withIsMandatory(boolean)}
   */
  @Test
  @DisplayName("Test withIsMandatory(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withIsMandatory(boolean)"})
  void testWithIsMandatory() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithIsMandatoryResult =
        immutableSurveyQuestion.withIsMandatory(false);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithIsMandatoryResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withIsMandatory(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withIsMandatory(boolean)}
   */
  @Test
  @DisplayName("Test withIsMandatory(boolean); when 'true'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withIsMandatory(boolean)"})
  void testWithIsMandatory_whenTrue_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithIsMandatoryResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withIsMandatory(true);

    // Assert
    assertEquals("Question Text", actualWithIsMandatoryResult.questionText());
    assertEquals(1, actualWithIsMandatoryResult.position().intValue());
    assertEquals(1L, actualWithIsMandatoryResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithIsMandatoryResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithIsMandatoryResult.fieldType());
    assertTrue(actualWithIsMandatoryResult.allowComment());
    assertTrue(actualWithIsMandatoryResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithKindResult = immutableSurveyQuestion.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withKind(EntityKind)"})
  void testWithKind_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ACTOR)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithKindResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Question Text", actualWithKindResult.questionText());
    assertEquals(1, actualWithKindResult.position().intValue());
    assertEquals(1L, actualWithKindResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithKindResult.fieldType());
    assertFalse(actualWithKindResult.isMandatory());
    assertTrue(actualWithKindResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withLabel(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withLabel(Optional)}
   */
  @Test
  @DisplayName("Test withLabel(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withLabel(Optional)"})
  void testWithLabelWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("42")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithLabelResult = immutableSurveyQuestion.withLabel(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithLabelResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withLabel(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withLabel(Optional)}
   */
  @Test
  @DisplayName("Test withLabel(Optional) with 'optional'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withLabel(Optional)"})
  void testWithLabelWithOptional_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithLabelResult = immutableSurveyQuestion.withLabel(optional);

    // Assert
    assertEquals("Question Text", actualWithLabelResult.questionText());
    assertEquals(1, actualWithLabelResult.position().intValue());
    assertEquals(1L, actualWithLabelResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithLabelResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithLabelResult.fieldType());
    assertFalse(actualWithLabelResult.isMandatory());
    assertTrue(actualWithLabelResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withLabel(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withLabel(String)}
   */
  @Test
  @DisplayName("Test withLabel(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withLabel(String)"})
  void testWithLabelWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("42")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithLabelResult = immutableSurveyQuestion.withLabel("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithLabelResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withLabel(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withLabel(String)}
   */
  @Test
  @DisplayName("Test withLabel(String) with 'value'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withLabel(String)"})
  void testWithLabelWithValue_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithLabelResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withLabel("42");

    // Assert
    assertEquals("Question Text", actualWithLabelResult.questionText());
    assertEquals(1, actualWithLabelResult.position().intValue());
    assertEquals(1L, actualWithLabelResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithLabelResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithLabelResult.fieldType());
    assertFalse(actualWithLabelResult.isMandatory());
    assertTrue(actualWithLabelResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withParentExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withParentExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withParentExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withParentExternalId(Optional)"
  })
  void testWithParentExternalIdWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithParentExternalIdResult =
        immutableSurveyQuestion.withParentExternalId(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithParentExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withParentExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withParentExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withParentExternalId(Optional) with 'optional'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withParentExternalId(Optional)"
  })
  void testWithParentExternalIdWithOptional_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("Parent External Id")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithParentExternalIdResult =
        immutableSurveyQuestion.withParentExternalId(optional);

    // Assert
    assertEquals("Question Text", actualWithParentExternalIdResult.questionText());
    assertEquals(1, actualWithParentExternalIdResult.position().intValue());
    assertEquals(1L, actualWithParentExternalIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithParentExternalIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithParentExternalIdResult.fieldType());
    assertFalse(actualWithParentExternalIdResult.isMandatory());
    assertTrue(actualWithParentExternalIdResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withParentExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withParentExternalId(String)}
   */
  @Test
  @DisplayName("Test withParentExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withParentExternalId(String)"
  })
  void testWithParentExternalIdWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithParentExternalIdResult =
        immutableSurveyQuestion.withParentExternalId("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithParentExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withParentExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withParentExternalId(String)}
   */
  @Test
  @DisplayName("Test withParentExternalId(String) with 'value'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withParentExternalId(String)"
  })
  void testWithParentExternalIdWithValue_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("parentExternalId")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithParentExternalIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withParentExternalId("42");

    // Assert
    assertEquals("Question Text", actualWithParentExternalIdResult.questionText());
    assertEquals(1, actualWithParentExternalIdResult.position().intValue());
    assertEquals(1L, actualWithParentExternalIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithParentExternalIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithParentExternalIdResult.fieldType());
    assertFalse(actualWithParentExternalIdResult.isMandatory());
    assertTrue(actualWithParentExternalIdResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withPosition(Integer)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withPosition(Integer)}
   */
  @Test
  @DisplayName("Test withPosition(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withPosition(Integer)"})
  void testWithPosition() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithPositionResult = immutableSurveyQuestion.withPosition(1);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withPosition(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withPosition(Integer)}
   */
  @Test
  @DisplayName("Test withPosition(Integer); when forty-two; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withPosition(Integer)"})
  void testWithPosition_whenFortyTwo_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithPositionResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Question Text", actualWithPositionResult.questionText());
    assertEquals(1L, actualWithPositionResult.surveyTemplateId().longValue());
    assertEquals(42, actualWithPositionResult.position().intValue());
    assertEquals(EntityKind.ALL, actualWithPositionResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithPositionResult.fieldType());
    assertFalse(actualWithPositionResult.isMandatory());
    assertTrue(actualWithPositionResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withQualifierEntity(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withQualifierEntity(Optional)}
   */
  @Test
  @DisplayName("Test withQualifierEntity(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withQualifierEntity(Optional)"
  })
  void testWithQualifierEntityWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableSurveyQuestion actualWithQualifierEntityResult =
        immutableSurveyQuestion.withQualifierEntity(optional);

    // Assert
    assertEquals(immutableSurveyQuestion, actualWithQualifierEntityResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withQualifierEntity(EntityReference)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withQualifierEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withQualifierEntity(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestion ImmutableSurveyQuestion.withQualifierEntity(EntityReference)"
  })
  void testWithQualifierEntityWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithQualifierEntityResult =
        immutableSurveyQuestion.withQualifierEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyQuestion, actualWithQualifierEntityResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withQuestionText(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withQuestionText(String)}
   */
  @Test
  @DisplayName("Test withQuestionText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withQuestionText(String)"})
  void testWithQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("42")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithQuestionTextResult =
        immutableSurveyQuestion.withQuestionText("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithQuestionTextResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withQuestionText(String)}.
   *
   * <ul>
   *   <li>Then return questionText is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withQuestionText(String)}
   */
  @Test
  @DisplayName("Test withQuestionText(String); then return questionText is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withQuestionText(String)"})
  void testWithQuestionText_thenReturnQuestionTextIs42() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithQuestionTextResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withQuestionText("42");

    // Assert
    assertEquals("42", actualWithQuestionTextResult.questionText());
    assertEquals(1, actualWithQuestionTextResult.position().intValue());
    assertEquals(1L, actualWithQuestionTextResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithQuestionTextResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithQuestionTextResult.fieldType());
    assertFalse(actualWithQuestionTextResult.isMandatory());
    assertTrue(actualWithQuestionTextResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withSectionName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withSectionName(Optional)}
   */
  @Test
  @DisplayName("Test withSectionName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withSectionName(Optional)"})
  void testWithSectionNameWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("42")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithSectionNameResult =
        immutableSurveyQuestion.withSectionName(optional);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithSectionNameResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withSectionName(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withSectionName(Optional)}
   */
  @Test
  @DisplayName("Test withSectionName(Optional) with 'optional'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withSectionName(Optional)"})
  void testWithSectionNameWithOptional_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestion actualWithSectionNameResult =
        immutableSurveyQuestion.withSectionName(optional);

    // Assert
    assertEquals("Question Text", actualWithSectionNameResult.questionText());
    assertEquals(1, actualWithSectionNameResult.position().intValue());
    assertEquals(1L, actualWithSectionNameResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithSectionNameResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithSectionNameResult.fieldType());
    assertFalse(actualWithSectionNameResult.isMandatory());
    assertTrue(actualWithSectionNameResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withSectionName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withSectionName(String)"})
  void testWithSectionNameWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("42")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithSectionNameResult =
        immutableSurveyQuestion.withSectionName("42");

    // Assert
    assertSame(immutableSurveyQuestion, actualWithSectionNameResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withSectionName(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String) with 'value'; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withSectionName(String)"})
  void testWithSectionNameWithValue_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithSectionNameResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withSectionName("42");

    // Assert
    assertEquals("Question Text", actualWithSectionNameResult.questionText());
    assertEquals(1, actualWithSectionNameResult.position().intValue());
    assertEquals(1L, actualWithSectionNameResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithSectionNameResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithSectionNameResult.fieldType());
    assertFalse(actualWithSectionNameResult.isMandatory());
    assertTrue(actualWithSectionNameResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withSurveyTemplateId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withSurveyTemplateId(Long)"})
  void testWithSurveyTemplateId() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion immutableSurveyQuestion =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    // Act
    ImmutableSurveyQuestion actualWithSurveyTemplateIdResult =
        immutableSurveyQuestion.withSurveyTemplateId(1L);

    // Assert
    assertSame(immutableSurveyQuestion, actualWithSurveyTemplateIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestion#withSurveyTemplateId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Question Text}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestion#withSurveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyTemplateId(Long); when forty-two; then return 'Question Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestion ImmutableSurveyQuestion.withSurveyTemplateId(Long)"})
  void testWithSurveyTemplateId_whenFortyTwo_thenReturnQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableSurveyQuestion actualWithSurveyTemplateIdResult =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build()
            .withSurveyTemplateId(42L);

    // Assert
    assertEquals("Question Text", actualWithSurveyTemplateIdResult.questionText());
    assertEquals(1, actualWithSurveyTemplateIdResult.position().intValue());
    assertEquals(42L, actualWithSurveyTemplateIdResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualWithSurveyTemplateIdResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithSurveyTemplateIdResult.fieldType());
    assertFalse(actualWithSurveyTemplateIdResult.isMandatory());
    assertTrue(actualWithSurveyTemplateIdResult.allowComment());
  }
}
