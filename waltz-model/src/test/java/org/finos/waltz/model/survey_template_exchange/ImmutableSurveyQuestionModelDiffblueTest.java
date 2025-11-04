package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionModelDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionModel#builder()}
   *   <li>{@link ImmutableSurveyQuestionModel#externalId(String)}
   *   <li>{@link ImmutableSurveyQuestionModel#helpText(String)}
   *   <li>{@link ImmutableSurveyQuestionModel#inclusionPredicate(String)}
   *   <li>{@link ImmutableSurveyQuestionModel#label(String)}
   *   <li>{@link ImmutableSurveyQuestionModel#parentExternalId(String)}
   *   <li>{@link ImmutableSurveyQuestionModel#qualifierEntity(EntityReference)}
   *   <li>{@link ImmutableSurveyQuestionModel#sectionName(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyQuestionModel.Builder actualExternalIdResult = ImmutableSurveyQuestionModel.builder()
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableSurveyQuestionModel.Builder actualQualifierEntityResult = actualExternalIdResult.externalId(externalId)
        .helpText("Help Text")
        .inclusionPredicate("Inclusion Predicate")
        .label("Label")
        .parentExternalId("42")
        .qualifierEntity(null);

    // Assert
    assertSame(actualQualifierEntityResult, actualQualifierEntityResult.sectionName("Section Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#addAllDropdownEntries(Iterable)}
   */
  @Test
  void testBuilderAddAllDropdownEntries() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDropdownEntries(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#addAllDropdownEntries(Iterable)}
   */
  @Test
  void testBuilderAddAllDropdownEntries2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDropdownEntries(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#addDropdownEntries(SurveyDropdownEntryModel)}
   */
  @Test
  void testBuilderAddDropdownEntries() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#addDropdownEntries(SurveyDropdownEntryModel)}
   */
  @Test
  void testBuilderAddDropdownEntries2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#addDropdownEntries(SurveyDropdownEntryModel[])}
   */
  @Test
  void testBuilderAddDropdownEntries3() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#addDropdownEntries(SurveyDropdownEntryModel[])}
   */
  @Test
  void testBuilderAddDropdownEntries4() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#allowComment(boolean)}
   */
  @Test
  void testBuilderAllowComment() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allowComment(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#allowComment(boolean)}
   */
  @Test
  void testBuilderAllowComment2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.allowComment(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#dropdownEntries(Iterable)}
   */
  @Test
  void testBuilderDropdownEntries() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dropdownEntries(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#dropdownEntries(Iterable)}
   */
  @Test
  void testBuilderDropdownEntries2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.dropdownEntries(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#fieldType(SurveyQuestionFieldType)}
   */
  @Test
  void testBuilderFieldType() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fieldType(SurveyQuestionFieldType.APPLICATION));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#fieldType(SurveyQuestionFieldType)}
   */
  @Test
  void testBuilderFieldType2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.fieldType(SurveyQuestionFieldType.APPLICATION));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.qualifierEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(mock(EntityReference.class));
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn(null);
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.parentExternalId());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn(null);
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertNull(buildResult.sectionName());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn(null);
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.helpText());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn(null);
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.inclusionPredicate());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn(null);
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.label());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    ArrayList<SurveyDropdownEntryModel> surveyDropdownEntryModelList = new ArrayList<>();
    ImmutableSurveyDropdownEntryModel.Json json = new ImmutableSurveyDropdownEntryModel.Json();
    surveyDropdownEntryModelList.add(json);
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(surveyDropdownEntryModelList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.qualifierEntity());
    List<SurveyDropdownEntryModel> dropdownEntriesResult = buildResult.dropdownEntries();
    assertEquals(1, dropdownEntriesResult.size());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(json, dropdownEntriesResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#from(SurveyQuestionModel)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyQuestionModel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    ImmutableSurveyQuestionModel buildResult = builderResult.build();
    assertEquals("42", buildResult.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Question Text", buildResult.questionText());
    assertEquals("Section Name", buildResult.sectionName());
    assertNull(buildResult.qualifierEntity());
    assertEquals(1, buildResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, buildResult.fieldType());
    assertTrue(buildResult.allowComment());
    assertTrue(buildResult.isMandatory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#isMandatory(boolean)}
   */
  @Test
  void testBuilderIsMandatory() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isMandatory(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#isMandatory(boolean)}
   */
  @Test
  void testBuilderIsMandatory2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isMandatory(true));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Builder#position(int)}
   */
  @Test
  void testBuilderPosition2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#questionText(String)}
   */
  @Test
  void testBuilderQuestionText() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionText("Question Text"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Builder#questionText(String)}
   */
  @Test
  void testBuilderQuestionText2() {
    // Arrange
    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.qualifierEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.questionText("Question Text"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel actualCopyOfResult = ImmutableSurveyQuestionModel.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Help Text", actualCopyOfResult.helpText());
    assertEquals("Inclusion Predicate", actualCopyOfResult.inclusionPredicate());
    assertEquals("Label", actualCopyOfResult.label());
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.dropdownEntries().isEmpty());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(mock(EntityReference.class));
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel actualCopyOfResult = ImmutableSurveyQuestionModel.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Help Text", actualCopyOfResult.helpText());
    assertEquals("Inclusion Predicate", actualCopyOfResult.inclusionPredicate());
    assertEquals("Label", actualCopyOfResult.label());
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.dropdownEntries().isEmpty());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<SurveyDropdownEntryModel> surveyDropdownEntryModelList = new ArrayList<>();
    surveyDropdownEntryModelList.add(new ImmutableSurveyDropdownEntryModel.Json());
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(surveyDropdownEntryModelList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel actualCopyOfResult = ImmutableSurveyQuestionModel.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Help Text", actualCopyOfResult.helpText());
    assertEquals("Inclusion Predicate", actualCopyOfResult.inclusionPredicate());
    assertEquals("Label", actualCopyOfResult.label());
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
    assertEquals(surveyDropdownEntryModelList, actualCopyOfResult.dropdownEntries());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<SurveyDropdownEntryModel> surveyDropdownEntryModelList = new ArrayList<>();
    surveyDropdownEntryModelList.add(new ImmutableSurveyDropdownEntryModel.Json());
    surveyDropdownEntryModelList.add(new ImmutableSurveyDropdownEntryModel.Json());
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(surveyDropdownEntryModelList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyQuestionModel actualCopyOfResult = ImmutableSurveyQuestionModel.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Help Text", actualCopyOfResult.helpText());
    assertEquals("Inclusion Predicate", actualCopyOfResult.inclusionPredicate());
    assertEquals("Label", actualCopyOfResult.label());
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
    assertEquals(surveyDropdownEntryModelList, actualCopyOfResult.dropdownEntries());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SurveyQuestionModel instance = mock(SurveyQuestionModel.class);
    when(instance.isMandatory()).thenReturn(true);
    when(instance.qualifierEntity()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.parentExternalId()).thenReturn("42");
    when(instance.sectionName()).thenReturn("Section Name");
    when(instance.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(instance.allowComment()).thenReturn(true);
    when(instance.helpText()).thenReturn("Help Text");
    when(instance.inclusionPredicate()).thenReturn("Inclusion Predicate");
    when(instance.label()).thenReturn("Label");
    when(instance.questionText()).thenReturn("Question Text");
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyQuestionModel actualCopyOfResult = ImmutableSurveyQuestionModel.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).allowComment();
    verify(instance).dropdownEntries();
    verify(instance).fieldType();
    verify(instance).helpText();
    verify(instance).inclusionPredicate();
    verify(instance).isMandatory();
    verify(instance).label();
    verify(instance).parentExternalId();
    verify(instance).position();
    verify(instance).qualifierEntity();
    verify(instance).questionText();
    verify(instance).sectionName();
    assertEquals("42", actualCopyOfResult.parentExternalId());
    assertEquals("Help Text", actualCopyOfResult.helpText());
    assertEquals("Inclusion Predicate", actualCopyOfResult.inclusionPredicate());
    assertEquals("Label", actualCopyOfResult.label());
    assertEquals("Question Text", actualCopyOfResult.questionText());
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertNull(actualCopyOfResult.qualifierEntity());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualCopyOfResult.fieldType());
    assertTrue(actualCopyOfResult.dropdownEntries().isEmpty());
    assertTrue(actualCopyOfResult.allowComment());
    assertTrue(actualCopyOfResult.isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#allowComment()}
   */
  @Test
  void testJsonAllowComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).allowComment());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#dropdownEntries()}
   */
  @Test
  void testJsonDropdownEntries() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionModel.Json()).dropdownEntries());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#fieldType()}
   */
  @Test
  void testJsonFieldType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).fieldType());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#helpText()}
   */
  @Test
  void testJsonHelpText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).helpText());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#inclusionPredicate()}
   */
  @Test
  void testJsonInclusionPredicate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionModel.Json()).inclusionPredicate());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#isMandatory()}
   */
  @Test
  void testJsonIsMandatory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).isMandatory());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#label()}
   */
  @Test
  void testJsonLabel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).label());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyQuestionModel.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyQuestionModel.Json actualJson = new ImmutableSurveyQuestionModel.Json();

    // Assert
    assertNull(actualJson.helpText);
    assertNull(actualJson.inclusionPredicate);
    assertNull(actualJson.label);
    assertNull(actualJson.parentExternalId);
    assertNull(actualJson.questionText);
    assertNull(actualJson.sectionName);
    assertNull(actualJson.qualifierEntity);
    assertNull(actualJson.fieldType);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.allowComment);
    assertFalse(actualJson.allowCommentIsSet);
    assertFalse(actualJson.isMandatory);
    assertFalse(actualJson.isMandatoryIsSet);
    assertFalse(actualJson.positionIsSet);
    assertTrue(actualJson.dropdownEntries.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#parentExternalId()}
   */
  @Test
  void testJsonParentExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionModel.Json()).parentExternalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#qualifierEntity()}
   */
  @Test
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionModel.Json()).qualifierEntity());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#questionText()}
   */
  @Test
  void testJsonQuestionText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).questionText());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#sectionName()}
   */
  @Test
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionModel.Json()).sectionName());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#setAllowComment(boolean)}
   */
  @Test
  void testJsonSetAllowComment() {
    // Arrange
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();

    // Act
    json.setAllowComment(true);

    // Assert
    assertTrue(json.allowComment);
    assertTrue(json.allowCommentIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#setAllowComment(boolean)}
   */
  @Test
  void testJsonSetAllowComment2() {
    // Arrange
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    json.setQualifierEntity(mock(EntityReference.class));

    // Act
    json.setAllowComment(true);

    // Assert
    assertTrue(json.allowComment);
    assertTrue(json.allowCommentIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#setIsMandatory(boolean)}
   */
  @Test
  void testJsonSetIsMandatory() {
    // Arrange
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();

    // Act
    json.setIsMandatory(true);

    // Assert
    assertTrue(json.isMandatory);
    assertTrue(json.isMandatoryIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionModel.Json#setIsMandatory(boolean)}
   */
  @Test
  void testJsonSetIsMandatory2() {
    // Arrange
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    json.setQualifierEntity(mock(EntityReference.class));

    // Act
    json.setIsMandatory(true);

    // Assert
    assertTrue(json.isMandatory);
    assertTrue(json.isMandatoryIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionModel.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition2() {
    // Arrange
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    json.setQualifierEntity(mock(EntityReference.class));

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
