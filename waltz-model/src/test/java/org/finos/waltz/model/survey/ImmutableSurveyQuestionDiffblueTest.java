package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionDiffblueTest {
  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#fieldType(SurveyQuestionFieldType)}.
   * <p>
   * Method under test: {@link Builder#fieldType(SurveyQuestionFieldType)}
   */
  @Test
  @DisplayName("Test Builder fieldType(SurveyQuestionFieldType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fieldType(SurveyQuestionFieldType)"})
  void testBuilderFieldType() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fieldType(SurveyQuestionFieldType.APPLICATION));
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult3);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    Optional<String> emptyResult = Optional.empty();
    when(instance.inclusionPredicate()).thenReturn(emptyResult);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult5);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>Given {@link Optional} with {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; given Optional with EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_givenOptionalWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierEntity()).thenReturn(ofResult);
    when(instance.isMandatory()).thenReturn(true);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult4);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult7);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    verify(instance).surveyTemplateId();
    ImmutableSurveyQuestion buildResult = builderResult.build();
    assertEquals("Question Text", buildResult.questionText());
    assertEquals(1, buildResult.position().intValue());
    assertEquals(1L, buildResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult3);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult6);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult3);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult5);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#helpText()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion helpText() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionHelpTextReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult3);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult6);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.helpText()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult2);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult5);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#label()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion label() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionLabelReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult3);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult5);
    Optional<String> emptyResult = Optional.empty();
    when(instance.label()).thenReturn(emptyResult);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#parentExternalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion parentExternalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionParentExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.parentExternalId()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult2);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult5);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#qualifierEntity()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion qualifierEntity() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionQualifierEntityReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierEntity()).thenReturn(emptyResult);
    when(instance.isMandatory()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.sectionName()).thenReturn(ofResult3);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult6);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    verify(instance).surveyTemplateId();
    ImmutableSurveyQuestion buildResult = builderResult.build();
    assertEquals("Question Text", buildResult.questionText());
    assertEquals(1, buildResult.position().intValue());
    assertEquals(1L, buildResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestion)} with {@code SurveyQuestion}.
   * <ul>
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#sectionName()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestion) with 'SurveyQuestion'; when SurveyQuestion sectionName() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestion)"})
  void testBuilderFromWithSurveyQuestion_whenSurveyQuestionSectionNameReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.sectionName()).thenReturn(emptyResult);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.position()).thenReturn(1);
    when(instance.questionText()).thenReturn("Question Text");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult5);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult6);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).allowComment();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).kind();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#helpText(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#helpText(Optional)}
   */
  @Test
  @DisplayName("Test Builder helpText(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.helpText(Optional)"})
  void testBuilderHelpTextWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> helpText = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.helpText(helpText));
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#inclusionPredicate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#inclusionPredicate(Optional)}
   */
  @Test
  @DisplayName("Test Builder inclusionPredicate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inclusionPredicate(Optional)"})
  void testBuilderInclusionPredicateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> inclusionPredicate = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.inclusionPredicate(inclusionPredicate));
  }

  /**
   * Test Builder {@link Builder#isMandatory(boolean)}.
   * <p>
   * Method under test: {@link Builder#isMandatory(boolean)}
   */
  @Test
  @DisplayName("Test Builder isMandatory(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isMandatory(boolean)"})
  void testBuilderIsMandatory() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isMandatory(true));
  }

  /**
   * Test Builder {@link Builder#label(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#label(Optional)}
   */
  @Test
  @DisplayName("Test Builder label(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.label(Optional)"})
  void testBuilderLabelWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> label = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.label(label));
  }

  /**
   * Test Builder {@link Builder#parentExternalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentExternalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentExternalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentExternalId(Optional)"})
  void testBuilderParentExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> parentExternalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.parentExternalId(parentExternalId));
  }

  /**
   * Test Builder {@link Builder#qualifierEntity(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#qualifierEntity(Optional)}
   */
  @Test
  @DisplayName("Test Builder qualifierEntity(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.qualifierEntity(Optional)"})
  void testBuilderQualifierEntityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.qualifierEntity(qualifierEntity));
  }

  /**
   * Test Builder {@link Builder#questionText(String)}.
   * <p>
   * Method under test: {@link Builder#questionText(String)}
   */
  @Test
  @DisplayName("Test Builder questionText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.questionText(String)"})
  void testBuilderQuestionText() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionText("Question Text"));
  }

  /**
   * Test Builder {@link Builder#sectionName(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#sectionName(Optional)}
   */
  @Test
  @DisplayName("Test Builder sectionName(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sectionName(Optional)"})
  void testBuilderSectionNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> sectionName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.sectionName(sectionName));
  }

  /**
   * Test Builder {@link Builder#surveyTemplateId(Long)}.
   * <p>
   * Method under test: {@link Builder#surveyTemplateId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyTemplateId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyTemplateId(Long)"})
  void testBuilderSurveyTemplateId() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
  }

  /**
   * Test Json {@link Json#allowComment()}.
   * <p>
   * Method under test: {@link Json#allowComment()}
   */
  @Test
  @DisplayName("Test Json allowComment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean Json.allowComment()"})
  void testJsonAllowComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allowComment());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#fieldType()}.
   * <p>
   * Method under test: {@link Json#fieldType()}
   */
  @Test
  @DisplayName("Test Json fieldType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyQuestionFieldType Json.fieldType()"})
  void testJsonFieldType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fieldType());
  }

  /**
   * Test Json {@link Json#helpText()}.
   * <p>
   * Method under test: {@link Json#helpText()}
   */
  @Test
  @DisplayName("Test Json helpText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.helpText()"})
  void testJsonHelpText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).helpText());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#inclusionPredicate()}.
   * <p>
   * Method under test: {@link Json#inclusionPredicate()}
   */
  @Test
  @DisplayName("Test Json inclusionPredicate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.inclusionPredicate()"})
  void testJsonInclusionPredicate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inclusionPredicate());
  }

  /**
   * Test Json {@link Json#isMandatory()}.
   * <p>
   * Method under test: {@link Json#isMandatory()}
   */
  @Test
  @DisplayName("Test Json isMandatory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isMandatory()"})
  void testJsonIsMandatory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isMandatory());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#label()}.
   * <p>
   * Method under test: {@link Json#label()}
   */
  @Test
  @DisplayName("Test Json label()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.label()"})
  void testJsonLabel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).label());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#parentExternalId()}
   */
  @Test
  @DisplayName("Test Json parentExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentExternalId()"})
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentExternalId());
  }

  /**
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#qualifierEntity()}.
   * <p>
   * Method under test: {@link Json#qualifierEntity()}
   */
  @Test
  @DisplayName("Test Json qualifierEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.qualifierEntity()"})
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).qualifierEntity());
  }

  /**
   * Test Json {@link Json#questionText()}.
   * <p>
   * Method under test: {@link Json#questionText()}
   */
  @Test
  @DisplayName("Test Json questionText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.questionText()"})
  void testJsonQuestionText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).questionText());
  }

  /**
   * Test Json {@link Json#sectionName()}.
   * <p>
   * Method under test: {@link Json#sectionName()}
   */
  @Test
  @DisplayName("Test Json sectionName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.sectionName()"})
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sectionName());
  }

  /**
   * Test Json {@link Json#setIsMandatory(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsMandatory(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsMandatory(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#surveyTemplateId()}
   */
  @Test
  @DisplayName("Test Json surveyTemplateId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.surveyTemplateId()"})
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyTemplateId());
  }
}
