package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.web.json.ImmutableSurveyQuestionInfo.Builder;
import org.finos.waltz.web.json.ImmutableSurveyQuestionInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDropdownEntries(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDropdownEntries(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllDropdownEntries(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDropdownEntries(Iterable)"})
  void testBuilderAddAllDropdownEntries_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act
    Builder actualAddAllDropdownEntriesResult =
        builderResult.addAllDropdownEntries(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry)} with {@code
   * element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addDropdownEntries(SurveyQuestionDropdownEntry) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyQuestionDropdownEntry)"})
  void testBuilderAddDropdownEntriesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act
    Builder actualAddDropdownEntriesResult =
        builderResult.addDropdownEntries(mock(SurveyQuestionDropdownEntry.class));

    // Assert
    assertSame(builderResult, actualAddDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDropdownEntries(SurveyQuestionDropdownEntry[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyQuestionDropdownEntry[])"})
  void testBuilderAddDropdownEntriesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act
    Builder actualAddDropdownEntriesResult =
        builderResult.addDropdownEntries(mock(SurveyQuestionDropdownEntry.class));

    // Assert
    assertSame(builderResult, actualAddDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyQuestionInfo.builder();
    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestion question =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();
    ImmutableSurveyQuestionInfo actualImmutableSurveyQuestionInfo =
        actualBuilderResult.question(question).build();

    // Assert
    assertTrue(actualImmutableSurveyQuestionInfo.dropdownEntries().isEmpty());
    assertSame(question, actualImmutableSurveyQuestionInfo.question());
  }

  /**
   * Test Builder {@link Builder#dropdownEntries(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dropdownEntries(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dropdownEntries(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dropdownEntries(Iterable)"})
  void testBuilderDropdownEntries_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act
    Builder actualDropdownEntriesResult = builderResult.dropdownEntries(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionInfo)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    Builder builderResult2 = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo instance =
        builderResult2
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionInfo actualImmutableSurveyQuestionInfo = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionInfo)}.
   *
   * <ul>
   *   <li>Then return build dropdownEntries size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyQuestionInfo); then return build dropdownEntries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionInfo)"})
  void testBuilderFrom_thenReturnBuildDropdownEntriesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    Builder builderResult2 = ImmutableSurveyQuestionInfo.builder();
    builderResult2.addDropdownEntries(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    ImmutableSurveyQuestion.Builder positionResult =
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
    List<SurveyQuestionDropdownEntry> dropdownEntriesResult =
        builderResult
            .from(
                builderResult2
                    .question(
                        positionResult
                            .qualifierEntity(qualifierEntity)
                            .questionText("Question Text")
                            .sectionName("Section Name")
                            .surveyTemplateId(1L)
                            .build())
                    .build())
            .build()
            .dropdownEntries();
    assertEquals(1, dropdownEntriesResult.size());
    SurveyQuestionDropdownEntry getResult = dropdownEntriesResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("42", getResult.value());
    assertEquals(1, getResult.position());
  }

  /**
   * Test Builder {@link Builder#question(SurveyQuestion)}.
   *
   * <ul>
   *   <li>When {@link SurveyQuestion}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#question(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder question(SurveyQuestion); when SurveyQuestion; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.question(SurveyQuestion)"})
  void testBuilderQuestion_whenSurveyQuestion_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestion question = mock(SurveyQuestion.class);

    // Act
    Builder actualQuestionResult = builderResult.question(question);

    // Assert
    assertSame(builderResult, actualQuestionResult);
    assertSame(question, builderResult.build().question());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#copyOf(SurveyQuestionInfo)}.
   *
   * <ul>
   *   <li>Then question return {@link ImmutableSurveyQuestion}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#copyOf(SurveyQuestionInfo)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyQuestionInfo); then question return ImmutableSurveyQuestion")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.copyOf(SurveyQuestionInfo)"
  })
  void testCopyOf_thenQuestionReturnImmutableSurveyQuestion() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo instance =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    ImmutableSurveyQuestionInfo actualCopyOfResult = ImmutableSurveyQuestionInfo.copyOf(instance);

    // Assert
    SurveyQuestion questionResult = actualCopyOfResult.question();
    assertTrue(questionResult instanceof ImmutableSurveyQuestion);
    assertEquals("Question Text", questionResult.questionText());
    assertEquals(1, questionResult.position().intValue());
    assertEquals(1L, questionResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, questionResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, questionResult.fieldType());
    assertFalse(questionResult.isMandatory());
    assertTrue(actualCopyOfResult.dropdownEntries().isEmpty());
    assertTrue(questionResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#equals(Object)}, and {@link
   * ImmutableSurveyQuestionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionInfo#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionInfo.equals(Object)",
    "int ImmutableSurveyQuestionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult2 =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo2 =
        builderResult2
            .question(
                positionResult2
                    .qualifierEntity(qualifierEntity2)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionInfo, immutableSurveyQuestionInfo2);
    assertEquals(immutableSurveyQuestionInfo.hashCode(), immutableSurveyQuestionInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#equals(Object)}, and {@link
   * ImmutableSurveyQuestionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionInfo#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionInfo.equals(Object)",
    "int ImmutableSurveyQuestionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionInfo, immutableSurveyQuestionInfo);
    int expectedHashCodeResult = immutableSurveyQuestionInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyQuestionInfo.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionInfo.equals(Object)",
    "int ImmutableSurveyQuestionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    builderResult.addDropdownEntries(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult2 =
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
        immutableSurveyQuestionInfo,
        builderResult2
            .question(
                positionResult2
                    .qualifierEntity(qualifierEntity2)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionInfo.equals(Object)",
    "int ImmutableSurveyQuestionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult2 =
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
        immutableSurveyQuestionInfo,
        builderResult2
            .question(
                positionResult2
                    .qualifierEntity(qualifierEntity2)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionInfo.equals(Object)",
    "int ImmutableSurveyQuestionInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionInfo.equals(Object)",
    "int ImmutableSurveyQuestionInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build(),
        "Different type to ImmutableSurveyQuestionInfo");
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return dropdownEntries Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return dropdownEntries Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnDropdownEntriesEmpty() {
    // Arrange
    Json json = new Json();

    ImmutableSurveyQuestion.Builder positionResult =
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
    json.setQuestion(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    json.setDropdownEntries(new ArrayList<>());

    // Act
    ImmutableSurveyQuestionInfo actualFromJsonResult = ImmutableSurveyQuestionInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.dropdownEntries().isEmpty());
    SurveyQuestion expectedQuestionResult = json.question;
    assertSame(expectedQuestionResult, actualFromJsonResult.question());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return dropdownEntries is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return dropdownEntries is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.fromJson(Json)"})
  void testFromJson_thenReturnDropdownEntriesIsArrayList() {
    // Arrange
    ArrayList<SurveyQuestionDropdownEntry> dropdownEntries = new ArrayList<>();
    dropdownEntries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    Json json = new Json();

    ImmutableSurveyQuestion.Builder positionResult =
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
    json.setQuestion(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    json.setDropdownEntries(dropdownEntries);

    // Act
    ImmutableSurveyQuestionInfo actualFromJsonResult = ImmutableSurveyQuestionInfo.fromJson(json);

    // Assert
    assertEquals(dropdownEntries, actualFromJsonResult.dropdownEntries());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return dropdownEntries is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return dropdownEntries is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.fromJson(Json)"})
  void testFromJson_thenReturnDropdownEntriesIsArrayList2() {
    // Arrange
    ArrayList<SurveyQuestionDropdownEntry> dropdownEntries = new ArrayList<>();
    dropdownEntries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());
    dropdownEntries.add(
        ImmutableSurveyQuestionDropdownEntry.builder()
            .id(1L)
            .position(1)
            .questionId(1L)
            .value("42")
            .build());

    Json json = new Json();

    ImmutableSurveyQuestion.Builder positionResult =
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
    json.setQuestion(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    json.setDropdownEntries(dropdownEntries);

    // Act
    ImmutableSurveyQuestionInfo actualFromJsonResult = ImmutableSurveyQuestionInfo.fromJson(json);

    // Assert
    assertEquals(dropdownEntries, actualFromJsonResult.dropdownEntries());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DropdownEntries is {@code null}.
   *   <li>Then return dropdownEntries Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DropdownEntries is 'null'; then return dropdownEntries Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.fromJson(Json)"})
  void testFromJson_whenJsonDropdownEntriesIsNull_thenReturnDropdownEntriesEmpty() {
    // Arrange
    Json json = new Json();

    ImmutableSurveyQuestion.Builder positionResult =
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
    json.setQuestion(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    json.setDropdownEntries(null);

    // Act
    ImmutableSurveyQuestionInfo actualFromJsonResult = ImmutableSurveyQuestionInfo.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.dropdownEntries().isEmpty());
    SurveyQuestion expectedQuestionResult = json.question;
    assertSame(expectedQuestionResult, actualFromJsonResult.question());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionInfo#toString()}
   *   <li>{@link ImmutableSurveyQuestionInfo#dropdownEntries()}
   *   <li>{@link ImmutableSurveyQuestionInfo#question()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSurveyQuestionInfo.dropdownEntries()",
    "SurveyQuestion ImmutableSurveyQuestionInfo.question()",
    "String ImmutableSurveyQuestionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableSurveyQuestionInfo.toString();
    List<SurveyQuestionDropdownEntry> actualDropdownEntriesResult =
        immutableSurveyQuestionInfo.dropdownEntries();

    // Assert
    assertTrue(immutableSurveyQuestionInfo.question() instanceof ImmutableSurveyQuestion);
    assertEquals(
        "SurveyQuestionInfo{question=SurveyQuestion{id=1, externalId=42, surveyTemplateId=1, questionText=Question"
            + " Text, helpText=Help Text, fieldType=APPLICATION, sectionName=Section Name, inclusionPredicate=Inclusion"
            + " Predicate, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, position=1,"
            + " isMandatory=false, allowComment=true, label=Label, parentExternalId=42, kind=ALL}, dropdownEntries="
            + "[]}",
        actualToStringResult);
    assertTrue(actualDropdownEntriesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#dropdownEntries()}.
   *
   * <p>Method under test: {@link Json#dropdownEntries()}
   */
  @Test
  @DisplayName("Test Json dropdownEntries()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.dropdownEntries()"})
  void testJsonDropdownEntries() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dropdownEntries());
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
    assertNull(actualJson.question);
    assertTrue(actualJson.dropdownEntries.isEmpty());
  }

  /**
   * Test Json {@link Json#question()}.
   *
   * <p>Method under test: {@link Json#question()}
   */
  @Test
  @DisplayName("Test Json question()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyQuestion Json.question()"})
  void testJsonQuestion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().question());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#withDropdownEntries(SurveyQuestionDropdownEntry[])}
   * with {@code SurveyQuestionDropdownEntry[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionInfo#withDropdownEntries(SurveyQuestionDropdownEntry[])}
   */
  @Test
  @DisplayName(
      "Test withDropdownEntries(SurveyQuestionDropdownEntry[]) with 'SurveyQuestionDropdownEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.withDropdownEntries(SurveyQuestionDropdownEntry[])"
  })
  void testWithDropdownEntriesWithSurveyQuestionDropdownEntry() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    // Act
    ImmutableSurveyQuestionInfo actualWithDropdownEntriesResult =
        immutableSurveyQuestionInfo.withDropdownEntries(
            ImmutableSurveyQuestionDropdownEntry.builder()
                .id(1L)
                .position(1)
                .questionId(1L)
                .value("42")
                .build());

    // Assert
    SurveyQuestion questionResult = actualWithDropdownEntriesResult.question();
    assertTrue(questionResult instanceof ImmutableSurveyQuestion);
    List<SurveyQuestionDropdownEntry> dropdownEntriesResult =
        actualWithDropdownEntriesResult.dropdownEntries();
    assertEquals(1, dropdownEntriesResult.size());
    SurveyQuestionDropdownEntry getResult = dropdownEntriesResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("42", getResult.value());
    assertEquals("Question Text", questionResult.questionText());
    assertEquals(1, questionResult.position().intValue());
    assertEquals(1, getResult.position());
    assertEquals(1L, questionResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, questionResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, questionResult.fieldType());
    assertFalse(questionResult.isMandatory());
    assertTrue(questionResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestionInfo#withQuestion(SurveyQuestion)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionInfo#withQuestion(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test withQuestion(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionInfo ImmutableSurveyQuestionInfo.withQuestion(SurveyQuestion)"
  })
  void testWithQuestion() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ImmutableSurveyQuestion.Builder positionResult =
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
    ImmutableSurveyQuestionInfo immutableSurveyQuestionInfo =
        builderResult
            .question(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build())
            .build();

    ImmutableSurveyQuestion.Builder positionResult2 =
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

    // Act
    ImmutableSurveyQuestionInfo actualWithQuestionResult =
        immutableSurveyQuestionInfo.withQuestion(
            positionResult2
                .qualifierEntity(qualifierEntity2)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    assertEquals(immutableSurveyQuestionInfo, actualWithQuestionResult);
  }
}
