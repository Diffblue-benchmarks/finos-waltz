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
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#fieldType(SurveyQuestionFieldType)}
   */
  @Test
  void testBuilderFieldType() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fieldType(SurveyQuestionFieldType.APPLICATION));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#fieldType(SurveyQuestionFieldType)}
   */
  @Test
  void testBuilderFieldType2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.fieldType(SurveyQuestionFieldType.APPLICATION));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyQuestion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyQuestion.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
    ImmutableSurveyQuestion.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
    ImmutableSurveyQuestion.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#from(SurveyQuestion)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
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
   * Method under test: {@link ImmutableSurveyQuestion.Builder#helpText(Optional)}
   */
  @Test
  void testBuilderHelpText() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> helpText = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.helpText(helpText));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#helpText(Optional)}
   */
  @Test
  void testBuilderHelpText2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> helpText = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.helpText(helpText));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#inclusionPredicate(Optional)}
   */
  @Test
  void testBuilderInclusionPredicate() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> inclusionPredicate = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.inclusionPredicate(inclusionPredicate));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#inclusionPredicate(Optional)}
   */
  @Test
  void testBuilderInclusionPredicate2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> inclusionPredicate = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.inclusionPredicate(inclusionPredicate));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#isMandatory(boolean)}
   */
  @Test
  void testBuilderIsMandatory() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isMandatory(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#isMandatory(boolean)}
   */
  @Test
  void testBuilderIsMandatory2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isMandatory(true));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#label(Optional)}
   */
  @Test
  void testBuilderLabel() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> label = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.label(label));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Builder#label(Optional)}
   */
  @Test
  void testBuilderLabel2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> label = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.label(label));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#parentExternalId(Optional)}
   */
  @Test
  void testBuilderParentExternalId() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> parentExternalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.parentExternalId(parentExternalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#parentExternalId(Optional)}
   */
  @Test
  void testBuilderParentExternalId2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> parentExternalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.parentExternalId(parentExternalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#questionText(String)}
   */
  @Test
  void testBuilderQuestionText() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionText("Question Text"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#questionText(String)}
   */
  @Test
  void testBuilderQuestionText2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.questionText("Question Text"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#sectionName(Optional)}
   */
  @Test
  void testBuilderSectionName() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    Optional<String> sectionName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.sectionName(sectionName));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#sectionName(Optional)}
   */
  @Test
  void testBuilderSectionName2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> sectionName = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.sectionName(sectionName));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#surveyTemplateId(Long)}
   */
  @Test
  void testBuilderSurveyTemplateId() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Builder#surveyTemplateId(Long)}
   */
  @Test
  void testBuilderSurveyTemplateId2() {
    // Arrange
    ImmutableSurveyQuestion.Builder builderResult = ImmutableSurveyQuestion.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.surveyTemplateId(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierEntity()).thenReturn(ofResult);
    when(instance.isMandatory()).thenReturn(false);
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
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertFalse(actualCopyOfResult.isMandatory());
    assertTrue(actualCopyOfResult.allowComment());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierEntity()).thenReturn(ofResult);
    when(instance.isMandatory()).thenReturn(true);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
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
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierEntity()).thenReturn(ofResult);
    when(instance.isMandatory()).thenReturn(true);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.parentExternalId()).thenReturn(emptyResult);
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
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    SurveyQuestion instance = mock(SurveyQuestion.class);
    when(instance.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.qualifierEntity()).thenReturn(ofResult);
    when(instance.isMandatory()).thenReturn(true);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.parentExternalId()).thenReturn(ofResult3);
    Optional<String> emptyResult = Optional.empty();
    when(instance.sectionName()).thenReturn(emptyResult);
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
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
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
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.inclusionPredicate()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult6);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
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
    Optional<String> emptyResult = Optional.empty();
    when(instance.inclusionPredicate()).thenReturn(emptyResult);
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.label()).thenReturn(ofResult6);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
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
    Optional<String> emptyResult = Optional.empty();
    when(instance.label()).thenReturn(emptyResult);
    when(instance.allowComment()).thenReturn(true);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.helpText()).thenReturn(ofResult7);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion#copyOf(SurveyQuestion)}
   */
  @Test
  void testCopyOf10() {
    // Arrange
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
    Optional<String> emptyResult = Optional.empty();
    when(instance.helpText()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSurveyQuestion actualCopyOfResult = ImmutableSurveyQuestion.copyOf(instance);

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
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals(1, actualCopyOfResult.position().intValue());
    assertEquals(1L, actualCopyOfResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#allowComment()}
   */
  @Test
  void testJsonAllowComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).allowComment());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#fieldType()}
   */
  @Test
  void testJsonFieldType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).fieldType());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#helpText()}
   */
  @Test
  void testJsonHelpText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).helpText());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#inclusionPredicate()}
   */
  @Test
  void testJsonInclusionPredicate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).inclusionPredicate());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#isMandatory()}
   */
  @Test
  void testJsonIsMandatory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#label()}
   */
  @Test
  void testJsonLabel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).label());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyQuestion.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyQuestion.Json actualJson = new ImmutableSurveyQuestion.Json();

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
   * Method under test: {@link ImmutableSurveyQuestion.Json#parentExternalId()}
   */
  @Test
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).parentExternalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#qualifierEntity()}
   */
  @Test
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).qualifierEntity());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#questionText()}
   */
  @Test
  void testJsonQuestionText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).questionText());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#sectionName()}
   */
  @Test
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).sectionName());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Json#setIsMandatory(boolean)}
   */
  @Test
  void testJsonSetIsMandatory() {
    // Arrange
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();

    // Act
    json.setIsMandatory(true);

    // Assert
    assertTrue(json.isMandatory);
    assertTrue(json.isMandatoryIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestion.Json#setIsMandatory(boolean)}
   */
  @Test
  void testJsonSetIsMandatory2() {
    // Arrange
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    Optional<EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));
    json.setQualifierEntity(qualifierEntity);

    // Act
    json.setIsMandatory(true);

    // Assert
    assertTrue(json.isMandatory);
    assertTrue(json.isMandatoryIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestion.Json#surveyTemplateId()}
   */
  @Test
  void testJsonSurveyTemplateId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestion.Json()).surveyTemplateId());
  }
}
