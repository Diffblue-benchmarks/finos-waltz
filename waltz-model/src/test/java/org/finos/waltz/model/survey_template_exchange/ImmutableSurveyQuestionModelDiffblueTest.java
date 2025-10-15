package org.finos.waltz.model.survey_template_exchange;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyQuestionModel.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyQuestionModel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionModelDiffblueTest {
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualAddAllDropdownEntriesResult =
        builderResult.addAllDropdownEntries(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyDropdownEntryModel)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyDropdownEntryModel.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDropdownEntries(SurveyDropdownEntryModel)}
   */
  @Test
  @DisplayName(
      "Test Builder addDropdownEntries(SurveyDropdownEntryModel) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyDropdownEntryModel)"})
  void testBuilderAddDropdownEntriesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualAddDropdownEntriesResult =
        builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json());

    // Assert
    assertSame(builderResult, actualAddDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyDropdownEntryModel[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyDropdownEntryModel.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDropdownEntries(SurveyDropdownEntryModel[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDropdownEntries(SurveyDropdownEntryModel[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyDropdownEntryModel[])"})
  void testBuilderAddDropdownEntriesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualAddDropdownEntriesResult =
        builderResult.addDropdownEntries(new ImmutableSurveyDropdownEntryModel.Json());

    // Assert
    assertSame(builderResult, actualAddDropdownEntriesResult);
  }

  /**
   * Test Builder {@link Builder#allowComment(boolean)}.
   *
   * <p>Method under test: {@link Builder#allowComment(boolean)}
   */
  @Test
  @DisplayName("Test Builder allowComment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allowComment(boolean)"})
  void testBuilderAllowComment() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualAllowCommentResult = builderResult.allowComment(true);

    // Assert
    assertSame(builderResult, actualAllowCommentResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#helpText(String)}
   *   <li>{@link Builder#inclusionPredicate(String)}
   *   <li>{@link Builder#label(String)}
   *   <li>{@link Builder#parentExternalId(String)}
   *   <li>{@link Builder#qualifierEntity(EntityReference)}
   *   <li>{@link Builder#sectionName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.helpText(String)",
    "Builder Builder.inclusionPredicate(String)",
    "Builder Builder.label(String)",
    "Builder Builder.parentExternalId(String)",
    "Builder Builder.qualifierEntity(EntityReference)",
    "Builder Builder.sectionName(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableSurveyQuestionModel.builder().allowComment(true).externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualPositionResult =
        actualExternalIdResult
            .externalId(externalId)
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference qualifierEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        actualPositionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .build();

    // Assert
    assertEquals("42", actualImmutableSurveyQuestionModel.parentExternalId());
    assertEquals("Help Text", actualImmutableSurveyQuestionModel.helpText());
    assertEquals("Inclusion Predicate", actualImmutableSurveyQuestionModel.inclusionPredicate());
    assertEquals("Label", actualImmutableSurveyQuestionModel.label());
    assertEquals("Question Text", actualImmutableSurveyQuestionModel.questionText());
    assertEquals("Section Name", actualImmutableSurveyQuestionModel.sectionName());
    assertEquals(1, actualImmutableSurveyQuestionModel.position());
    assertEquals(
        SurveyQuestionFieldType.APPLICATION, actualImmutableSurveyQuestionModel.fieldType());
    assertTrue(actualImmutableSurveyQuestionModel.dropdownEntries().isEmpty());
    assertTrue(actualImmutableSurveyQuestionModel.allowComment());
    assertTrue(actualImmutableSurveyQuestionModel.isMandatory());
    assertSame(qualifierEntity, actualImmutableSurveyQuestionModel.qualifierEntity());
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualDropdownEntriesResult = builderResult.dropdownEntries(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDropdownEntriesResult);
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
    Optional<String> externalId = Optional.of("foo");

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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
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
   *
   * <ul>
   *   <li>Given of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOfFoo() {
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId(null)
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel3() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(false)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel4() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText(null)
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel5() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate(null)
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel6() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label(null)
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel7() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName(null)
            .build();

    // Act and Assert
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyQuestionModel);
    ImmutableSurveyQuestionModel actualImmutableSurveyQuestionModel2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionModel2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionModel)} with {@code SurveyQuestionModel}.
   *
   * <ul>
   *   <li>Then return build dropdownEntries size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionModel)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyQuestionModel) with 'SurveyQuestionModel'; then return build dropdownEntries size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionModel)"})
  void testBuilderFromWithSurveyQuestionModel_thenReturnBuildDropdownEntriesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    Builder builderResult2 = ImmutableSurveyQuestionModel.builder();
    builderResult2.addDropdownEntries(
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());

    Builder positionResult =
        builderResult2
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    List<SurveyDropdownEntryModel> dropdownEntriesResult =
        builderResult
            .from(
                positionResult
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
                    .sectionName("Section Name")
                    .build())
            .build()
            .dropdownEntries();
    assertEquals(1, dropdownEntriesResult.size());
    SurveyDropdownEntryModel getResult = dropdownEntriesResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyDropdownEntryModel);
    assertEquals("42", getResult.value());
    assertEquals(1, getResult.position());
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualIsMandatoryResult = builderResult.isMandatory(true);

    // Assert
    assertSame(builderResult, actualIsMandatoryResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
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
    Builder builderResult = ImmutableSurveyQuestionModel.builder();

    // Act
    Builder actualQuestionTextResult = builderResult.questionText("Question Text");

    // Assert
    assertSame(builderResult, actualQuestionTextResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#copyOf(SurveyQuestionModel)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyQuestionModel); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.copyOf(SurveyQuestionModel)"
  })
  void testCopyOf_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel instance =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualCopyOfResult = ImmutableSurveyQuestionModel.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.qualifierEntity() instanceof ImmutableEntityReference);
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
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}, and {@link
   * ImmutableSurveyQuestionModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionModel#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel2 =
        positionResult2
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionModel, immutableSurveyQuestionModel2);
    assertEquals(immutableSurveyQuestionModel.hashCode(), immutableSurveyQuestionModel2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}, and {@link
   * ImmutableSurveyQuestionModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionModel#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionModel, immutableSurveyQuestionModel);
    int expectedHashCodeResult = immutableSurveyQuestionModel.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyQuestionModel.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.addDropdownEntries(
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());

    Builder positionResult =
        builderResult
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(false)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("Question Text")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.BOOLEAN)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Question Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Question Text")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(false)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Question Text")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("Question Text")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(0);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("allowComment")
            .sectionName("Section Name")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Question Text")
            .build();

    Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionModel,
        positionResult2
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
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        positionResult
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
            .sectionName("Section Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.equals(Object)",
    "int ImmutableSurveyQuestionModel.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertNotEquals(
        positionResult
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
            .sectionName("Section Name")
            .build(),
        "Different type to ImmutableSurveyQuestionModel");
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionModel.externalId()"})
  void testExternalId() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    Optional<String> actualExternalIdResult =
        positionResult
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
            .sectionName("Section Name")
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
   *   <li>{@link ImmutableSurveyQuestionModel#allowComment()}
   *   <li>{@link ImmutableSurveyQuestionModel#dropdownEntries()}
   *   <li>{@link ImmutableSurveyQuestionModel#fieldType()}
   *   <li>{@link ImmutableSurveyQuestionModel#helpText()}
   *   <li>{@link ImmutableSurveyQuestionModel#inclusionPredicate()}
   *   <li>{@link ImmutableSurveyQuestionModel#isMandatory()}
   *   <li>{@link ImmutableSurveyQuestionModel#label()}
   *   <li>{@link ImmutableSurveyQuestionModel#parentExternalId()}
   *   <li>{@link ImmutableSurveyQuestionModel#position()}
   *   <li>{@link ImmutableSurveyQuestionModel#qualifierEntity()}
   *   <li>{@link ImmutableSurveyQuestionModel#questionText()}
   *   <li>{@link ImmutableSurveyQuestionModel#sectionName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionModel.allowComment()",
    "List ImmutableSurveyQuestionModel.dropdownEntries()",
    "SurveyQuestionFieldType ImmutableSurveyQuestionModel.fieldType()",
    "String ImmutableSurveyQuestionModel.helpText()",
    "String ImmutableSurveyQuestionModel.inclusionPredicate()",
    "boolean ImmutableSurveyQuestionModel.isMandatory()",
    "String ImmutableSurveyQuestionModel.label()",
    "String ImmutableSurveyQuestionModel.parentExternalId()",
    "int ImmutableSurveyQuestionModel.position()",
    "EntityReference ImmutableSurveyQuestionModel.qualifierEntity()",
    "String ImmutableSurveyQuestionModel.questionText()",
    "String ImmutableSurveyQuestionModel.sectionName()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    boolean actualAllowCommentResult = immutableSurveyQuestionModel.allowComment();
    List<SurveyDropdownEntryModel> actualDropdownEntriesResult =
        immutableSurveyQuestionModel.dropdownEntries();
    SurveyQuestionFieldType actualFieldTypeResult = immutableSurveyQuestionModel.fieldType();
    String actualHelpTextResult = immutableSurveyQuestionModel.helpText();
    String actualInclusionPredicateResult = immutableSurveyQuestionModel.inclusionPredicate();
    boolean actualIsMandatoryResult = immutableSurveyQuestionModel.isMandatory();
    String actualLabelResult = immutableSurveyQuestionModel.label();
    String actualParentExternalIdResult = immutableSurveyQuestionModel.parentExternalId();
    int actualPositionResult = immutableSurveyQuestionModel.position();
    EntityReference actualQualifierEntityResult = immutableSurveyQuestionModel.qualifierEntity();
    String actualQuestionTextResult = immutableSurveyQuestionModel.questionText();

    // Assert
    assertTrue(actualQualifierEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualParentExternalIdResult);
    assertEquals("Help Text", actualHelpTextResult);
    assertEquals("Inclusion Predicate", actualInclusionPredicateResult);
    assertEquals("Label", actualLabelResult);
    assertEquals("Question Text", actualQuestionTextResult);
    assertEquals("Section Name", immutableSurveyQuestionModel.sectionName());
    assertEquals(1, actualPositionResult);
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualFieldTypeResult);
    assertTrue(actualDropdownEntriesResult.isEmpty());
    assertTrue(actualAllowCommentResult);
    assertTrue(actualIsMandatoryResult);
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
  @MethodsUnderTest({"boolean Json.allowComment()"})
  void testJsonAllowComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allowComment());
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
  @MethodsUnderTest({"String Json.helpText()"})
  void testJsonHelpText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().helpText());
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
  @MethodsUnderTest({"String Json.inclusionPredicate()"})
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
   * Test Json {@link Json#label()}.
   *
   * <p>Method under test: {@link Json#label()}
   */
  @Test
  @DisplayName("Test Json label()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.label()"})
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
   *
   * <p>Method under test: {@link Json#parentExternalId()}
   */
  @Test
  @DisplayName("Test Json parentExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.parentExternalId()"})
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
  @MethodsUnderTest({"int Json.position()"})
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
  @MethodsUnderTest({"EntityReference Json.qualifierEntity()"})
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
  @MethodsUnderTest({"String Json.sectionName()"})
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sectionName());
  }

  /**
   * Test Json {@link Json#setAllowComment(boolean)}.
   *
   * <p>Method under test: {@link Json#setAllowComment(boolean)}
   */
  @Test
  @DisplayName("Test Json setAllowComment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableSurveyQuestionModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionModel.toString()"})
  void testToString() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertEquals(
        "SurveyQuestionModel{externalId=42, questionText=Question Text, fieldType=APPLICATION, position=1,"
            + " isMandatory=true, allowComment=true, dropdownEntries=[], qualifierEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, helpText=Help Text, label=Label, parentExternalId=42,"
            + " sectionName=Section Name, inclusionPredicate=Inclusion Predicate}",
        positionResult
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
            .sectionName("Section Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionModel.toString()"})
  void testToString2() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText(null)
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertEquals(
        "SurveyQuestionModel{externalId=42, questionText=Question Text, fieldType=APPLICATION, position=1,"
            + " isMandatory=true, allowComment=true, dropdownEntries=[], qualifierEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, label=Label, parentExternalId=42, sectionName=Section Name,"
            + " inclusionPredicate=Inclusion Predicate}",
        positionResult
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
            .sectionName("Section Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionModel.toString()"})
  void testToString3() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate(null)
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertEquals(
        "SurveyQuestionModel{externalId=42, questionText=Question Text, fieldType=APPLICATION, position=1,"
            + " isMandatory=true, allowComment=true, dropdownEntries=[], qualifierEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, helpText=Help Text, label=Label, parentExternalId=42,"
            + " sectionName=Section Name}",
        positionResult
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
            .sectionName("Section Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionModel.toString()"})
  void testToString4() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label(null)
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertEquals(
        "SurveyQuestionModel{externalId=42, questionText=Question Text, fieldType=APPLICATION, position=1,"
            + " isMandatory=true, allowComment=true, dropdownEntries=[], qualifierEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, helpText=Help Text, parentExternalId=42, sectionName=Section"
            + " Name, inclusionPredicate=Inclusion Predicate}",
        positionResult
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
            .sectionName("Section Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionModel.toString()"})
  void testToString5() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId(null)
            .position(1);

    // Act and Assert
    assertEquals(
        "SurveyQuestionModel{externalId=42, questionText=Question Text, fieldType=APPLICATION, position=1,"
            + " isMandatory=true, allowComment=true, dropdownEntries=[], qualifierEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, helpText=Help Text, label=Label, sectionName=Section Name,"
            + " inclusionPredicate=Inclusion Predicate}",
        positionResult
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
            .sectionName("Section Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionModel.toString()"})
  void testToString6() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act and Assert
    assertEquals(
        "SurveyQuestionModel{externalId=42, questionText=Question Text, fieldType=APPLICATION, position=1,"
            + " isMandatory=true, allowComment=true, dropdownEntries=[], qualifierEntity=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, helpText=Help Text, label=Label, parentExternalId=42,"
            + " inclusionPredicate=Inclusion Predicate}",
        positionResult
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
            .sectionName(null)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withAllowComment(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withAllowComment(boolean)}
   */
  @Test
  @DisplayName("Test withAllowComment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withAllowComment(boolean)"
  })
  void testWithAllowComment() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithAllowCommentResult =
        immutableSurveyQuestionModel.withAllowComment(true);

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithAllowCommentResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withAllowComment(boolean)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withAllowComment(boolean)}
   */
  @Test
  @DisplayName(
      "Test withAllowComment(boolean); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withAllowComment(boolean)"
  })
  void testWithAllowComment_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(false)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithAllowCommentResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withAllowComment(true);

    // Assert
    assertTrue(actualWithAllowCommentResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithAllowCommentResult.parentExternalId());
    assertEquals("Help Text", actualWithAllowCommentResult.helpText());
    assertEquals("Inclusion Predicate", actualWithAllowCommentResult.inclusionPredicate());
    assertEquals("Label", actualWithAllowCommentResult.label());
    assertEquals("Question Text", actualWithAllowCommentResult.questionText());
    assertEquals("Section Name", actualWithAllowCommentResult.sectionName());
    assertEquals(1, actualWithAllowCommentResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithAllowCommentResult.fieldType());
    assertTrue(actualWithAllowCommentResult.dropdownEntries().isEmpty());
    assertTrue(actualWithAllowCommentResult.allowComment());
    assertTrue(actualWithAllowCommentResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withDropdownEntries(SurveyDropdownEntryModel[])} with
   * {@code SurveyDropdownEntryModel[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionModel#withDropdownEntries(SurveyDropdownEntryModel[])}
   */
  @Test
  @DisplayName(
      "Test withDropdownEntries(SurveyDropdownEntryModel[]) with 'SurveyDropdownEntryModel[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withDropdownEntries(SurveyDropdownEntryModel[])"
  })
  void testWithDropdownEntriesWithSurveyDropdownEntryModel() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithDropdownEntriesResult =
        immutableSurveyQuestionModel.withDropdownEntries(
            ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());

    // Assert
    assertTrue(
        actualWithDropdownEntriesResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDropdownEntriesResult.parentExternalId());
    assertEquals("Help Text", actualWithDropdownEntriesResult.helpText());
    assertEquals("Inclusion Predicate", actualWithDropdownEntriesResult.inclusionPredicate());
    assertEquals("Label", actualWithDropdownEntriesResult.label());
    assertEquals("Question Text", actualWithDropdownEntriesResult.questionText());
    assertEquals("Section Name", actualWithDropdownEntriesResult.sectionName());
    assertEquals(1, actualWithDropdownEntriesResult.dropdownEntries().size());
    assertEquals(1, actualWithDropdownEntriesResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithDropdownEntriesResult.fieldType());
    assertTrue(actualWithDropdownEntriesResult.allowComment());
    assertTrue(actualWithDropdownEntriesResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestionModel actualWithExternalIdResult =
        immutableSurveyQuestionModel.withExternalId(optional);

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSurveyQuestionModel actualWithExternalIdResult =
        immutableSurveyQuestionModel.withExternalId(optional);

    // Assert
    assertTrue(actualWithExternalIdResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithExternalIdResult.parentExternalId());
    assertEquals("Help Text", actualWithExternalIdResult.helpText());
    assertEquals("Inclusion Predicate", actualWithExternalIdResult.inclusionPredicate());
    assertEquals("Label", actualWithExternalIdResult.label());
    assertEquals("Question Text", actualWithExternalIdResult.questionText());
    assertEquals("Section Name", actualWithExternalIdResult.sectionName());
    assertEquals(1, actualWithExternalIdResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithExternalIdResult.fieldType());
    assertTrue(actualWithExternalIdResult.dropdownEntries().isEmpty());
    assertTrue(actualWithExternalIdResult.allowComment());
    assertTrue(actualWithExternalIdResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithExternalIdResult =
        immutableSurveyQuestionModel.withExternalId("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithExternalIdResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertTrue(actualWithExternalIdResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithExternalIdResult.parentExternalId());
    assertEquals("Help Text", actualWithExternalIdResult.helpText());
    assertEquals("Inclusion Predicate", actualWithExternalIdResult.inclusionPredicate());
    assertEquals("Label", actualWithExternalIdResult.label());
    assertEquals("Question Text", actualWithExternalIdResult.questionText());
    assertEquals("Section Name", actualWithExternalIdResult.sectionName());
    assertEquals(1, actualWithExternalIdResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithExternalIdResult.fieldType());
    assertTrue(actualWithExternalIdResult.dropdownEntries().isEmpty());
    assertTrue(actualWithExternalIdResult.allowComment());
    assertTrue(actualWithExternalIdResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withFieldType(SurveyQuestionFieldType)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionModel#withFieldType(SurveyQuestionFieldType)}
   */
  @Test
  @DisplayName("Test withFieldType(SurveyQuestionFieldType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withFieldType(SurveyQuestionFieldType)"
  })
  void testWithFieldType() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithFieldTypeResult =
        immutableSurveyQuestionModel.withFieldType(SurveyQuestionFieldType.APPLICATION);

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithFieldTypeResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withFieldType(SurveyQuestionFieldType)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionModel#withFieldType(SurveyQuestionFieldType)}
   */
  @Test
  @DisplayName(
      "Test withFieldType(SurveyQuestionFieldType); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withFieldType(SurveyQuestionFieldType)"
  })
  void testWithFieldType_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.BOOLEAN)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithFieldTypeResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withFieldType(SurveyQuestionFieldType.APPLICATION);

    // Assert
    assertTrue(actualWithFieldTypeResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithFieldTypeResult.parentExternalId());
    assertEquals("Help Text", actualWithFieldTypeResult.helpText());
    assertEquals("Inclusion Predicate", actualWithFieldTypeResult.inclusionPredicate());
    assertEquals("Label", actualWithFieldTypeResult.label());
    assertEquals("Question Text", actualWithFieldTypeResult.questionText());
    assertEquals("Section Name", actualWithFieldTypeResult.sectionName());
    assertEquals(1, actualWithFieldTypeResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithFieldTypeResult.fieldType());
    assertTrue(actualWithFieldTypeResult.dropdownEntries().isEmpty());
    assertTrue(actualWithFieldTypeResult.allowComment());
    assertTrue(actualWithFieldTypeResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withHelpText(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withHelpText(String)}
   */
  @Test
  @DisplayName("Test withHelpText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withHelpText(String)"
  })
  void testWithHelpText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("42")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithHelpTextResult =
        immutableSurveyQuestionModel.withHelpText("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithHelpTextResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withHelpText(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withHelpText(String)}
   */
  @Test
  @DisplayName("Test withHelpText(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withHelpText(String)"
  })
  void testWithHelpText_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithHelpTextResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withHelpText("42");

    // Assert
    assertTrue(actualWithHelpTextResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithHelpTextResult.helpText());
    assertEquals("42", actualWithHelpTextResult.parentExternalId());
    assertEquals("Inclusion Predicate", actualWithHelpTextResult.inclusionPredicate());
    assertEquals("Label", actualWithHelpTextResult.label());
    assertEquals("Question Text", actualWithHelpTextResult.questionText());
    assertEquals("Section Name", actualWithHelpTextResult.sectionName());
    assertEquals(1, actualWithHelpTextResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithHelpTextResult.fieldType());
    assertTrue(actualWithHelpTextResult.dropdownEntries().isEmpty());
    assertTrue(actualWithHelpTextResult.allowComment());
    assertTrue(actualWithHelpTextResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withInclusionPredicate(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withInclusionPredicate(String)}
   */
  @Test
  @DisplayName("Test withInclusionPredicate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withInclusionPredicate(String)"
  })
  void testWithInclusionPredicate() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("42")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithInclusionPredicateResult =
        immutableSurveyQuestionModel.withInclusionPredicate("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithInclusionPredicateResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withInclusionPredicate(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withInclusionPredicate(String)}
   */
  @Test
  @DisplayName(
      "Test withInclusionPredicate(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withInclusionPredicate(String)"
  })
  void testWithInclusionPredicate_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithInclusionPredicateResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withInclusionPredicate("42");

    // Assert
    assertTrue(
        actualWithInclusionPredicateResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithInclusionPredicateResult.inclusionPredicate());
    assertEquals("42", actualWithInclusionPredicateResult.parentExternalId());
    assertEquals("Help Text", actualWithInclusionPredicateResult.helpText());
    assertEquals("Label", actualWithInclusionPredicateResult.label());
    assertEquals("Question Text", actualWithInclusionPredicateResult.questionText());
    assertEquals("Section Name", actualWithInclusionPredicateResult.sectionName());
    assertEquals(1, actualWithInclusionPredicateResult.position());
    assertEquals(
        SurveyQuestionFieldType.APPLICATION, actualWithInclusionPredicateResult.fieldType());
    assertTrue(actualWithInclusionPredicateResult.dropdownEntries().isEmpty());
    assertTrue(actualWithInclusionPredicateResult.allowComment());
    assertTrue(actualWithInclusionPredicateResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withIsMandatory(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withIsMandatory(boolean)}
   */
  @Test
  @DisplayName("Test withIsMandatory(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withIsMandatory(boolean)"
  })
  void testWithIsMandatory() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithIsMandatoryResult =
        immutableSurveyQuestionModel.withIsMandatory(true);

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithIsMandatoryResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withIsMandatory(boolean)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withIsMandatory(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsMandatory(boolean); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withIsMandatory(boolean)"
  })
  void testWithIsMandatory_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(false)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithIsMandatoryResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withIsMandatory(true);

    // Assert
    assertTrue(actualWithIsMandatoryResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIsMandatoryResult.parentExternalId());
    assertEquals("Help Text", actualWithIsMandatoryResult.helpText());
    assertEquals("Inclusion Predicate", actualWithIsMandatoryResult.inclusionPredicate());
    assertEquals("Label", actualWithIsMandatoryResult.label());
    assertEquals("Question Text", actualWithIsMandatoryResult.questionText());
    assertEquals("Section Name", actualWithIsMandatoryResult.sectionName());
    assertEquals(1, actualWithIsMandatoryResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithIsMandatoryResult.fieldType());
    assertTrue(actualWithIsMandatoryResult.dropdownEntries().isEmpty());
    assertTrue(actualWithIsMandatoryResult.allowComment());
    assertTrue(actualWithIsMandatoryResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withLabel(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withLabel(String)}
   */
  @Test
  @DisplayName("Test withLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withLabel(String)"})
  void testWithLabel() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("42")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithLabelResult =
        immutableSurveyQuestionModel.withLabel("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithLabelResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withLabel(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withLabel(String)}
   */
  @Test
  @DisplayName("Test withLabel(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withLabel(String)"})
  void testWithLabel_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithLabelResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withLabel("42");

    // Assert
    assertTrue(actualWithLabelResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLabelResult.label());
    assertEquals("42", actualWithLabelResult.parentExternalId());
    assertEquals("Help Text", actualWithLabelResult.helpText());
    assertEquals("Inclusion Predicate", actualWithLabelResult.inclusionPredicate());
    assertEquals("Question Text", actualWithLabelResult.questionText());
    assertEquals("Section Name", actualWithLabelResult.sectionName());
    assertEquals(1, actualWithLabelResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithLabelResult.fieldType());
    assertTrue(actualWithLabelResult.dropdownEntries().isEmpty());
    assertTrue(actualWithLabelResult.allowComment());
    assertTrue(actualWithLabelResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withParentExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withParentExternalId(String)}
   */
  @Test
  @DisplayName("Test withParentExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withParentExternalId(String)"
  })
  void testWithParentExternalId() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithParentExternalIdResult =
        immutableSurveyQuestionModel.withParentExternalId("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithParentExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withParentExternalId(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withParentExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withParentExternalId(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withParentExternalId(String)"
  })
  void testWithParentExternalId_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("Parent External Id")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithParentExternalIdResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withParentExternalId("42");

    // Assert
    assertTrue(
        actualWithParentExternalIdResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithParentExternalIdResult.parentExternalId());
    assertEquals("Help Text", actualWithParentExternalIdResult.helpText());
    assertEquals("Inclusion Predicate", actualWithParentExternalIdResult.inclusionPredicate());
    assertEquals("Label", actualWithParentExternalIdResult.label());
    assertEquals("Question Text", actualWithParentExternalIdResult.questionText());
    assertEquals("Section Name", actualWithParentExternalIdResult.sectionName());
    assertEquals(1, actualWithParentExternalIdResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithParentExternalIdResult.fieldType());
    assertTrue(actualWithParentExternalIdResult.dropdownEntries().isEmpty());
    assertTrue(actualWithParentExternalIdResult.allowComment());
    assertTrue(actualWithParentExternalIdResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(42);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithPositionResult =
        immutableSurveyQuestionModel.withPosition(42);

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withPosition(int)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withPosition(int)"})
  void testWithPosition_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithPositionResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withPosition(42);

    // Assert
    assertTrue(actualWithPositionResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithPositionResult.parentExternalId());
    assertEquals("Help Text", actualWithPositionResult.helpText());
    assertEquals("Inclusion Predicate", actualWithPositionResult.inclusionPredicate());
    assertEquals("Label", actualWithPositionResult.label());
    assertEquals("Question Text", actualWithPositionResult.questionText());
    assertEquals("Section Name", actualWithPositionResult.sectionName());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithPositionResult.fieldType());
    assertTrue(actualWithPositionResult.dropdownEntries().isEmpty());
    assertTrue(actualWithPositionResult.allowComment());
    assertTrue(actualWithPositionResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withQualifierEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withQualifierEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withQualifierEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withQualifierEntity(EntityReference)"
  })
  void testWithQualifierEntity() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithQualifierEntityResult =
        immutableSurveyQuestionModel.withQualifierEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyQuestionModel, actualWithQualifierEntityResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withQuestionText(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withQuestionText(String)}
   */
  @Test
  @DisplayName("Test withQuestionText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withQuestionText(String)"
  })
  void testWithQuestionText() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("42")
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithQuestionTextResult =
        immutableSurveyQuestionModel.withQuestionText("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithQuestionTextResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withQuestionText(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withQuestionText(String)}
   */
  @Test
  @DisplayName(
      "Test withQuestionText(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withQuestionText(String)"
  })
  void testWithQuestionText_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithQuestionTextResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withQuestionText("42");

    // Assert
    assertTrue(actualWithQuestionTextResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithQuestionTextResult.parentExternalId());
    assertEquals("42", actualWithQuestionTextResult.questionText());
    assertEquals("Help Text", actualWithQuestionTextResult.helpText());
    assertEquals("Inclusion Predicate", actualWithQuestionTextResult.inclusionPredicate());
    assertEquals("Label", actualWithQuestionTextResult.label());
    assertEquals("Section Name", actualWithQuestionTextResult.sectionName());
    assertEquals(1, actualWithQuestionTextResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithQuestionTextResult.fieldType());
    assertTrue(actualWithQuestionTextResult.dropdownEntries().isEmpty());
    assertTrue(actualWithQuestionTextResult.allowComment());
    assertTrue(actualWithQuestionTextResult.isMandatory());
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withSectionName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withSectionName(String)"
  })
  void testWithSectionName() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
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
            .sectionName("42")
            .build();

    // Act
    ImmutableSurveyQuestionModel actualWithSectionNameResult =
        immutableSurveyQuestionModel.withSectionName("42");

    // Assert
    assertSame(immutableSurveyQuestionModel, actualWithSectionNameResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionModel#withSectionName(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionModel#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionModel ImmutableSurveyQuestionModel.withSectionName(String)"
  })
  void testWithSectionName_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyQuestionModel actualWithSectionNameResult =
        positionResult
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
            .sectionName("Section Name")
            .build()
            .withSectionName("42");

    // Assert
    assertTrue(actualWithSectionNameResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSectionNameResult.parentExternalId());
    assertEquals("42", actualWithSectionNameResult.sectionName());
    assertEquals("Help Text", actualWithSectionNameResult.helpText());
    assertEquals("Inclusion Predicate", actualWithSectionNameResult.inclusionPredicate());
    assertEquals("Label", actualWithSectionNameResult.label());
    assertEquals("Question Text", actualWithSectionNameResult.questionText());
    assertEquals(1, actualWithSectionNameResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, actualWithSectionNameResult.fieldType());
    assertTrue(actualWithSectionNameResult.dropdownEntries().isEmpty());
    assertTrue(actualWithSectionNameResult.allowComment());
    assertTrue(actualWithSectionNameResult.isMandatory());
  }
}
