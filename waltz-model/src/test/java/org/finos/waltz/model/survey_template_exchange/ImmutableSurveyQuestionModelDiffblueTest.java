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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyQuestionModel.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyQuestionModel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionModelDiffblueTest {
  /**
   * Test {@link ImmutableSurveyQuestionModel#builder()}.
   * <p>
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
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyQuestionModel Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.helpText(String)", "Builder Builder.inclusionPredicate(String)", "Builder Builder.label(String)",
      "Builder Builder.parentExternalId(String)", "Builder Builder.qualifierEntity(EntityReference)",
      "Builder Builder.sectionName(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableSurveyQuestionModel.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualQualifierEntityResult = actualExternalIdResult.externalId(externalId)
        .helpText("Help Text")
        .inclusionPredicate("Inclusion Predicate")
        .label("Label")
        .parentExternalId("42")
        .qualifierEntity(null);

    // Assert
    assertSame(actualQualifierEntityResult, actualQualifierEntityResult.sectionName("Section Name"));
  }

  /**
   * Test Builder {@link Builder#addAllDropdownEntries(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDropdownEntries(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDropdownEntries(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDropdownEntries(Iterable)"})
  void testBuilderAddAllDropdownEntries_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDropdownEntries(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyDropdownEntryModel)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableSurveyDropdownEntryModel.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDropdownEntries(SurveyDropdownEntryModel)}
   */
  @Test
  @DisplayName("Test Builder addDropdownEntries(SurveyDropdownEntryModel) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyDropdownEntryModel)"})
  void testBuilderAddDropdownEntriesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json()));
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyDropdownEntryModel[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableSurveyDropdownEntryModel.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDropdownEntries(SurveyDropdownEntryModel[])}
   */
  @Test
  @DisplayName("Test Builder addDropdownEntries(SurveyDropdownEntryModel[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyDropdownEntryModel[])"})
  void testBuilderAddDropdownEntriesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json()));
  }

  /**
   * Test Builder {@link Builder#allowComment(boolean)}.
   * <p>
   * Method under test: {@link Builder#allowComment(boolean)}
   */
  @Test
  @DisplayName("Test Builder allowComment(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allowComment(boolean)"})
  void testBuilderAllowComment() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allowComment(true));
  }

  /**
   * Test Builder {@link Builder#dropdownEntries(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dropdownEntries(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dropdownEntries(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dropdownEntries(Iterable)"})
  void testBuilderDropdownEntries_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dropdownEntries(new ArrayList<>()));
  }

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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Given {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; given EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_givenEntityReference() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then builder build dropdownEntries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then builder build dropdownEntries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenBuilderBuildDropdownEntriesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

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
    Builder actualFromResult = builderResult.from(instance);

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
    List<SurveyDropdownEntryModel> dropdownEntriesResult = builderResult.build().dropdownEntries();
    assertEquals(1, dropdownEntriesResult.size());
    assertEquals(surveyDropdownEntryModelList, actualFromResult.build().dropdownEntries());
    assertSame(json, dropdownEntriesResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then return build helpText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build helpText is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildHelpTextIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
    assertNull(buildResult.helpText());
    assertNull(buildResult2.helpText());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then return build inclusionPredicate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build inclusionPredicate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildInclusionPredicateIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
    assertNull(buildResult.inclusionPredicate());
    assertNull(buildResult2.inclusionPredicate());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then return build label is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build label is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildLabelIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
    assertNull(buildResult.label());
    assertNull(buildResult2.label());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then return build parentExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build parentExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildParentExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then return build parentExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build parentExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildParentExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("Help Text", buildResult.helpText());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals("Section Name", buildResult2.sectionName());
    assertNull(buildResult.parentExternalId());
    assertNull(buildResult2.parentExternalId());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then return build sectionName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build sectionName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildSectionNameIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableSurveyQuestionModel buildResult = actualFromResult.build();
    assertEquals("42", buildResult.parentExternalId());
    ImmutableSurveyQuestionModel buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.parentExternalId());
    assertEquals("Help Text", buildResult.helpText());
    assertEquals("Help Text", buildResult2.helpText());
    assertEquals("Inclusion Predicate", buildResult.inclusionPredicate());
    assertEquals("Inclusion Predicate", buildResult2.inclusionPredicate());
    assertEquals("Label", buildResult.label());
    assertEquals("Label", buildResult2.label());
    assertNull(buildResult.sectionName());
    assertNull(buildResult2.sectionName());
    assertNull(buildResult.qualifierEntity());
    assertNull(buildResult2.qualifierEntity());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isMandatory(true));
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionText("Question Text"));
  }

  /**
   * Test Json {@link Json#allowComment()}.
   * <p>
   * Method under test: {@link Json#allowComment()}
   */
  @Test
  @DisplayName("Test Json allowComment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.allowComment()"})
  void testJsonAllowComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allowComment());
  }

  /**
   * Test Json {@link Json#dropdownEntries()}.
   * <p>
   * Method under test: {@link Json#dropdownEntries()}
   */
  @Test
  @DisplayName("Test Json dropdownEntries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.dropdownEntries()"})
  void testJsonDropdownEntries() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dropdownEntries());
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
  @MethodsUnderTest({"String Json.helpText()"})
  void testJsonHelpText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).helpText());
  }

  /**
   * Test Json {@link Json#inclusionPredicate()}.
   * <p>
   * Method under test: {@link Json#inclusionPredicate()}
   */
  @Test
  @DisplayName("Test Json inclusionPredicate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.inclusionPredicate()"})
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
   * Test Json {@link Json#label()}.
   * <p>
   * Method under test: {@link Json#label()}
   */
  @Test
  @DisplayName("Test Json label()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.label()"})
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
   * Test Json {@link Json#parentExternalId()}.
   * <p>
   * Method under test: {@link Json#parentExternalId()}
   */
  @Test
  @DisplayName("Test Json parentExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.parentExternalId()"})
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
  @MethodsUnderTest({"int Json.position()"})
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
  @MethodsUnderTest({"EntityReference Json.qualifierEntity()"})
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
  @MethodsUnderTest({"String Json.sectionName()"})
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sectionName());
  }

  /**
   * Test Json {@link Json#setAllowComment(boolean)}.
   * <p>
   * Method under test: {@link Json#setAllowComment(boolean)}
   */
  @Test
  @DisplayName("Test Json setAllowComment(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAllowComment(boolean)"})
  void testJsonSetAllowComment() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAllowComment(true);

    // Assert
    assertTrue(json.allowComment);
    assertTrue(json.allowCommentIsSet);
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
   * Test Json {@link Json#setPosition(int)}.
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
