package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.bulk_upload.ResolvedAssessmentHeaderStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentHeaderCell.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentHeaderCellDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#resolvedAssessmentDefinition(AssessmentDefinition)}
   *   <li>{@link Builder#resolvedRating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell Builder.build()",
    "Builder Builder.resolvedAssessmentDefinition(AssessmentDefinition)",
    "Builder Builder.resolvedRating(RatingSchemeItem)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualInputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");
    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);
    Builder actualResolvedAssessmentDefinitionResult =
        actualInputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    Builder actualResolvedAssessmentDefinitionResult2 =
        actualResolvedAssessmentDefinitionResult.resolvedAssessmentDefinition(
            provenanceResult2
                .qualifierReference(qualifierReference2)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    Builder actualResolvedRatingResult =
        actualResolvedAssessmentDefinitionResult2.resolvedRating(resolvedRating);
    ImmutableAssessmentHeaderCell actualImmutableAssessmentHeaderCell =
        actualResolvedRatingResult
            .resolvedRating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Assert
    assertEquals("Input String", actualImmutableAssessmentHeaderCell.inputString());
    assertEquals(1, actualImmutableAssessmentHeaderCell.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        actualImmutableAssessmentHeaderCell.status());
    assertTrue(actualImmutableAssessmentHeaderCell.ratingLookupMap().isEmpty());
    assertTrue(actualImmutableAssessmentHeaderCell.isSingleValued());
  }

  /**
   * Test Builder {@link Builder#columnId(int)}.
   *
   * <p>Method under test: {@link Builder#columnId(int)}
   */
  @Test
  @DisplayName("Test Builder columnId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columnId(int)"})
  void testBuilderColumnId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualColumnIdResult = builderResult.columnId(1);

    // Assert
    assertSame(builderResult, actualColumnIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell instance =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act and Assert
    ImmutableAssessmentHeaderCell actualImmutableAssessmentHeaderCell =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentHeaderCell);
    ImmutableAssessmentHeaderCell actualImmutableAssessmentHeaderCell2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentHeaderCell2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentHeaderCell)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition = Optional.empty();

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell instance =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act and Assert
    ImmutableAssessmentHeaderCell actualImmutableAssessmentHeaderCell =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentHeaderCell);
    ImmutableAssessmentHeaderCell actualImmutableAssessmentHeaderCell2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentHeaderCell2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentHeaderCell)}.
   *
   * <ul>
   *   <li>Given {@code instance}.
   *   <li>Then return build ratingLookupMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentHeaderCell); given 'instance'; then return build ratingLookupMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentHeaderCell)"})
  void testBuilderFrom_givenInstance_thenReturnBuildRatingLookupMapSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    Builder builderResult2 = ImmutableAssessmentHeaderCell.builder();
    builderResult2.putRatingLookupMap(
        "instance",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder inputStringResult = builderResult2.columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    Map<String, RatingSchemeItem> ratingLookupMapResult =
        builderResult
            .from(
                resolvedAssessmentDefinitionResult
                    .resolvedRating(resolvedRating)
                    .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
                    .build())
            .build()
            .ratingLookupMap();
    assertEquals(1, ratingLookupMapResult.size());
    RatingSchemeItem getResult = ratingLookupMapResult.get("instance");
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   *
   * <ul>
   *   <li>When {@code Input String}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName("Test Builder inputString(String); when 'Input String'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString_whenInputString_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Test Builder {@link Builder#isSingleValued(boolean)}.
   *
   * <p>Method under test: {@link Builder#isSingleValued(boolean)}
   */
  @Test
  @DisplayName("Test Builder isSingleValued(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isSingleValued(boolean)"})
  void testBuilderIsSingleValued() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualIsSingleValuedResult = builderResult.isSingleValued(true);

    // Assert
    assertSame(builderResult, actualIsSingleValuedResult);
  }

  /**
   * Test Builder {@link Builder#putAllRatingLookupMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllRatingLookupMap(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllRatingLookupMap(Map); given 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllRatingLookupMap(Map)"})
  void testBuilderPutAllRatingLookupMap_givenKey() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    HashMap<String, RatingSchemeItem> entries = new HashMap<>();
    entries.put(
        "Key",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Act
    Builder actualPutAllRatingLookupMapResult = builderResult.putAllRatingLookupMap(entries);

    // Assert
    assertSame(builderResult, actualPutAllRatingLookupMapResult);
  }

  /**
   * Test Builder {@link Builder#putAllRatingLookupMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllRatingLookupMap(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllRatingLookupMap(Map); when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllRatingLookupMap(Map)"})
  void testBuilderPutAllRatingLookupMap_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualPutAllRatingLookupMapResult =
        builderResult.putAllRatingLookupMap(new HashMap<>());

    // Assert
    assertSame(builderResult, actualPutAllRatingLookupMapResult);
  }

  /**
   * Test Builder {@link Builder#putRatingLookupMap(Entry)} with {@code entry}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putRatingLookupMap(Entry)}
   */
  @Test
  @DisplayName("Test Builder putRatingLookupMap(Entry) with 'entry'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putRatingLookupMap(Entry)"})
  void testBuilderPutRatingLookupMapWithEntry_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    SimpleEntry<String, RatingSchemeItem> entry =
        new SimpleEntry<>("Key", immutableRatingSchemeItem);

    // Act
    Builder actualPutRatingLookupMapResult = builderResult.putRatingLookupMap(entry);

    // Assert
    assertSame(builderResult, actualPutRatingLookupMapResult);
  }

  /**
   * Test Builder {@link Builder#putRatingLookupMap(String, RatingSchemeItem)} with {@code key},
   * {@code value}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putRatingLookupMap(String, RatingSchemeItem)}
   */
  @Test
  @DisplayName(
      "Test Builder putRatingLookupMap(String, RatingSchemeItem) with 'key', 'value'; when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putRatingLookupMap(String, RatingSchemeItem)"})
  void testBuilderPutRatingLookupMapWithKeyValue_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualPutRatingLookupMapResult =
        builderResult.putRatingLookupMap(
            "Key",
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertSame(builderResult, actualPutRatingLookupMapResult);
  }

  /**
   * Test Builder {@link Builder#ratingLookupMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingLookupMap(Map)}
   */
  @Test
  @DisplayName("Test Builder ratingLookupMap(Map); given 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingLookupMap(Map)"})
  void testBuilderRatingLookupMap_givenKey() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    HashMap<String, RatingSchemeItem> entries = new HashMap<>();
    entries.put(
        "Key",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Act
    Builder actualRatingLookupMapResult = builderResult.ratingLookupMap(entries);

    // Assert
    assertSame(builderResult, actualRatingLookupMapResult);
  }

  /**
   * Test Builder {@link Builder#ratingLookupMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingLookupMap(Map)}
   */
  @Test
  @DisplayName("Test Builder ratingLookupMap(Map); when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingLookupMap(Map)"})
  void testBuilderRatingLookupMap_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualRatingLookupMapResult = builderResult.ratingLookupMap(new HashMap<>());

    // Assert
    assertSame(builderResult, actualRatingLookupMapResult);
  }

  /**
   * Test Builder {@link Builder#resolvedAssessmentDefinition(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#resolvedAssessmentDefinition(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedAssessmentDefinition(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resolvedAssessmentDefinition(Optional)"})
  void testBuilderResolvedAssessmentDefinitionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    // Act
    Builder actualResolvedAssessmentDefinitionResult =
        builderResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);

    // Assert
    assertSame(builderResult, actualResolvedAssessmentDefinitionResult);
  }

  /**
   * Test Builder {@link Builder#resolvedRating(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#resolvedRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder resolvedRating(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resolvedRating(Optional)"})
  void testBuilderResolvedRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    Builder actualResolvedRatingResult = builderResult.resolvedRating(resolvedRating);

    // Assert
    assertSame(builderResult, actualResolvedRatingResult);
  }

  /**
   * Test Builder {@link Builder#status(ResolvedAssessmentHeaderStatus)}.
   *
   * <p>Method under test: {@link Builder#status(ResolvedAssessmentHeaderStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ResolvedAssessmentHeaderStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(ResolvedAssessmentHeaderStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();

    // Act
    Builder actualStatusResult =
        builderResult.status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#copyOf(AssessmentHeaderCell)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentHeaderCell); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.copyOf(AssessmentHeaderCell)"
  })
  void testCopyOf_thenReturnInputString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell instance =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    ImmutableAssessmentHeaderCell actualCopyOfResult =
        ImmutableAssessmentHeaderCell.copyOf(instance);

    // Assert
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.ratingLookupMap().isEmpty());
    assertTrue(actualCopyOfResult.isSingleValued());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}, and {@link
   * ImmutableAssessmentHeaderCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentHeaderCell#equals(Object)}
   *   <li>{@link ImmutableAssessmentHeaderCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell2 =
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentHeaderCell, immutableAssessmentHeaderCell2);
    assertEquals(
        immutableAssessmentHeaderCell.hashCode(), immutableAssessmentHeaderCell2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}, and {@link
   * ImmutableAssessmentHeaderCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentHeaderCell#equals(Object)}
   *   <li>{@link ImmutableAssessmentHeaderCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentHeaderCell, immutableAssessmentHeaderCell);
    int expectedHashCodeResult = immutableAssessmentHeaderCell.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentHeaderCell.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentHeaderCell.builder();
    builderResult.putRatingLookupMap(
        "Input String",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder inputStringResult = builderResult.columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentHeaderCell,
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(2).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentHeaderCell,
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Name");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentHeaderCell,
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_MANY)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentHeaderCell,
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Input String")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentHeaderCell,
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_RATING_NOT_FOUND)
            .build();

    Builder inputStringResult2 =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 =
        Optional.of(immutableEntityReference2);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition2 =
        Optional.of(immutableAssessmentDefinition2);

    Builder resolvedAssessmentDefinitionResult2 =
        inputStringResult2.resolvedAssessmentDefinition(resolvedAssessmentDefinition2);
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating2 = Optional.of(immutableRatingSchemeItem2);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentHeaderCell,
        resolvedAssessmentDefinitionResult2
            .resolvedRating(resolvedRating2)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertNotEquals(
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentHeaderCell.equals(Object)",
    "int ImmutableAssessmentHeaderCell.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertNotEquals(
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build(),
        "Different type to ImmutableAssessmentHeaderCell");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentHeaderCell#columnId()}
   *   <li>{@link ImmutableAssessmentHeaderCell#inputString()}
   *   <li>{@link ImmutableAssessmentHeaderCell#isSingleValued()}
   *   <li>{@link ImmutableAssessmentHeaderCell#ratingLookupMap()}
   *   <li>{@link ImmutableAssessmentHeaderCell#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableAssessmentHeaderCell.columnId()",
    "String ImmutableAssessmentHeaderCell.inputString()",
    "boolean ImmutableAssessmentHeaderCell.isSingleValued()",
    "Map ImmutableAssessmentHeaderCell.ratingLookupMap()",
    "ResolvedAssessmentHeaderStatus ImmutableAssessmentHeaderCell.status()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    int actualColumnIdResult = immutableAssessmentHeaderCell.columnId();
    String actualInputStringResult = immutableAssessmentHeaderCell.inputString();
    boolean actualIsSingleValuedResult = immutableAssessmentHeaderCell.isSingleValued();
    Map<String, RatingSchemeItem> actualRatingLookupMapResult =
        immutableAssessmentHeaderCell.ratingLookupMap();

    // Assert
    assertEquals("Input String", actualInputStringResult);
    assertEquals(1, actualColumnIdResult);
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        immutableAssessmentHeaderCell.status());
    assertTrue(actualRatingLookupMapResult.isEmpty());
    assertTrue(actualIsSingleValuedResult);
  }

  /**
   * Test Json {@link Json#columnId()}.
   *
   * <p>Method under test: {@link Json#columnId()}
   */
  @Test
  @DisplayName("Test Json columnId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.columnId()"})
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnId());
  }

  /**
   * Test Json {@link Json#inputString()}.
   *
   * <p>Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inputString());
  }

  /**
   * Test Json {@link Json#isSingleValued()}.
   *
   * <p>Method under test: {@link Json#isSingleValued()}
   */
  @Test
  @DisplayName("Test Json isSingleValued()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isSingleValued()"})
  void testJsonIsSingleValued() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isSingleValued());
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
    assertNull(actualJson.inputString);
    assertNull(actualJson.status);
    assertEquals(0, actualJson.columnId);
    assertFalse(actualJson.resolvedAssessmentDefinition.isPresent());
    assertFalse(actualJson.resolvedRating.isPresent());
    assertFalse(actualJson.columnIdIsSet);
    assertFalse(actualJson.isSingleValued);
    assertFalse(actualJson.isSingleValuedIsSet);
    assertTrue(actualJson.ratingLookupMap.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingLookupMap()}.
   *
   * <p>Method under test: {@link Json#ratingLookupMap()}
   */
  @Test
  @DisplayName("Test Json ratingLookupMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Json.ratingLookupMap()"})
  void testJsonRatingLookupMap() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingLookupMap());
  }

  /**
   * Test Json {@link Json#resolvedAssessmentDefinition()}.
   *
   * <p>Method under test: {@link Json#resolvedAssessmentDefinition()}
   */
  @Test
  @DisplayName("Test Json resolvedAssessmentDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.resolvedAssessmentDefinition()"})
  void testJsonResolvedAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().resolvedAssessmentDefinition());
  }

  /**
   * Test Json {@link Json#resolvedRating()}.
   *
   * <p>Method under test: {@link Json#resolvedRating()}
   */
  @Test
  @DisplayName("Test Json resolvedRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.resolvedRating()"})
  void testJsonResolvedRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolvedRating());
  }

  /**
   * Test Json {@link Json#setColumnId(int)}.
   *
   * <p>Method under test: {@link Json#setColumnId(int)}
   */
  @Test
  @DisplayName("Test Json setColumnId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setColumnId(int)"})
  void testJsonSetColumnId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setColumnId(1);

    // Assert
    assertEquals(1, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Test Json {@link Json#setIsSingleValued(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsSingleValued(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsSingleValued(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsSingleValued(boolean)"})
  void testJsonSetIsSingleValued() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsSingleValued(true);

    // Assert
    assertTrue(json.isSingleValued);
    assertTrue(json.isSingleValuedIsSet);
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvedAssessmentHeaderStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#resolvedAssessmentDefinition()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#resolvedAssessmentDefinition()}
   */
  @Test
  @DisplayName("Test resolvedAssessmentDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentHeaderCell.resolvedAssessmentDefinition()"})
  void testResolvedAssessmentDefinition() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertEquals(
        resolvedAssessmentDefinition,
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .resolvedAssessmentDefinition());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#resolvedRating()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#resolvedRating()}
   */
  @Test
  @DisplayName("Test resolvedRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentHeaderCell.resolvedRating()"})
  void testResolvedRating() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertEquals(
        resolvedRating,
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .resolvedRating());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#toString()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentHeaderCell.toString()"})
  void testToString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertEquals(
        "AssessmentHeaderCell{inputString=Input String, columnId=1, resolvedAssessmentDefinition=AssessmentDefinition"
            + "{id=1, externalId=42, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance"
            + "=Provenance, entityKind=ALL, ratingSchemeId=1, permittedRole=Permitted Role, isReadOnly=true,"
            + " visibility=PRIMARY, definitionGroup=Definition Group, kind=ALL, cardinality=ZERO_ONE}, resolvedRating"
            + "=RatingSchemeItem{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1,"
            + " userSelectable=true, isRestricted=false, ratingGroup=Rating Group, requiresComment=false},"
            + " status=HEADER_DEFINITION_NOT_FOUND, ratingLookupMap={}, isSingleValued=true}",
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#toString()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentHeaderCell.toString()"})
  void testToString2() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition = Optional.empty();

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act and Assert
    assertEquals(
        "AssessmentHeaderCell{inputString=Input String, columnId=1, resolvedRating=RatingSchemeItem{id=1,"
            + " name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1, userSelectable=true,"
            + " isRestricted=false, ratingGroup=Rating Group, requiresComment=false}, status=HEADER_DEFINITION_NOT_FOUND,"
            + " ratingLookupMap={}, isSingleValued=false}",
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withColumnId(int)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withColumnId(int)}
   */
  @Test
  @DisplayName("Test withColumnId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withColumnId(int)"
  })
  void testWithColumnId() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(42).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    ImmutableAssessmentHeaderCell actualWithColumnIdResult =
        immutableAssessmentHeaderCell.withColumnId(42);

    // Assert
    assertSame(immutableAssessmentHeaderCell, actualWithColumnIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withColumnId(int)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withColumnId(int)}
   */
  @Test
  @DisplayName("Test withColumnId(int); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withColumnId(int)"
  })
  void testWithColumnId_thenReturnInputString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    ImmutableAssessmentHeaderCell actualWithColumnIdResult =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .withColumnId(42);

    // Assert
    assertEquals("Input String", actualWithColumnIdResult.inputString());
    assertEquals(42, actualWithColumnIdResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        actualWithColumnIdResult.status());
    assertTrue(actualWithColumnIdResult.ratingLookupMap().isEmpty());
    assertTrue(actualWithColumnIdResult.isSingleValued());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withInputString(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withInputString(String)"
  })
  void testWithInputString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("42");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    ImmutableAssessmentHeaderCell actualWithInputStringResult =
        immutableAssessmentHeaderCell.withInputString("42");

    // Assert
    assertSame(immutableAssessmentHeaderCell, actualWithInputStringResult);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withInputString(String)}.
   *
   * <ul>
   *   <li>Then return inputString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then return inputString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withInputString(String)"
  })
  void testWithInputString_thenReturnInputStringIs42() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    ImmutableAssessmentHeaderCell actualWithInputStringResult =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .withInputString("42");

    // Assert
    assertEquals("42", actualWithInputStringResult.inputString());
    assertEquals(1, actualWithInputStringResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        actualWithInputStringResult.status());
    assertTrue(actualWithInputStringResult.ratingLookupMap().isEmpty());
    assertTrue(actualWithInputStringResult.isSingleValued());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withIsSingleValued(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withIsSingleValued(boolean)}
   */
  @Test
  @DisplayName("Test withIsSingleValued(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withIsSingleValued(boolean)"
  })
  void testWithIsSingleValued() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    ImmutableAssessmentHeaderCell actualWithIsSingleValuedResult =
        immutableAssessmentHeaderCell.withIsSingleValued(true);

    // Assert
    assertSame(immutableAssessmentHeaderCell, actualWithIsSingleValuedResult);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withIsSingleValued(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withIsSingleValued(boolean)}
   */
  @Test
  @DisplayName("Test withIsSingleValued(boolean); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withIsSingleValued(boolean)"
  })
  void testWithIsSingleValued_thenReturnInputString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition = Optional.empty();

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);

    // Act
    ImmutableAssessmentHeaderCell actualWithIsSingleValuedResult =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build()
            .withIsSingleValued(true);

    // Assert
    assertEquals("Input String", actualWithIsSingleValuedResult.inputString());
    assertEquals(1, actualWithIsSingleValuedResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        actualWithIsSingleValuedResult.status());
    assertTrue(actualWithIsSingleValuedResult.ratingLookupMap().isEmpty());
    assertTrue(actualWithIsSingleValuedResult.isSingleValued());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withResolvedAssessmentDefinition(Optional)} with
   * {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentHeaderCell#withResolvedAssessmentDefinition(Optional)}
   */
  @Test
  @DisplayName(
      "Test withResolvedAssessmentDefinition(Optional) with 'optional'; then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withResolvedAssessmentDefinition(Optional)"
  })
  void testWithResolvedAssessmentDefinitionWithOptional_thenReturnInputString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition immutableAssessmentDefinition2 =
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> optional = Optional.of(immutableAssessmentDefinition2);

    // Act
    ImmutableAssessmentHeaderCell actualWithResolvedAssessmentDefinitionResult =
        immutableAssessmentHeaderCell.withResolvedAssessmentDefinition(optional);

    // Assert
    assertEquals("Input String", actualWithResolvedAssessmentDefinitionResult.inputString());
    assertEquals(1, actualWithResolvedAssessmentDefinitionResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        actualWithResolvedAssessmentDefinitionResult.status());
    assertTrue(actualWithResolvedAssessmentDefinitionResult.ratingLookupMap().isEmpty());
    assertTrue(actualWithResolvedAssessmentDefinitionResult.isSingleValued());
  }

  /**
   * Test {@link
   * ImmutableAssessmentHeaderCell#withResolvedAssessmentDefinition(AssessmentDefinition)} with
   * {@code value}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentHeaderCell#withResolvedAssessmentDefinition(AssessmentDefinition)}
   */
  @Test
  @DisplayName(
      "Test withResolvedAssessmentDefinition(AssessmentDefinition) with 'value'; then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withResolvedAssessmentDefinition(AssessmentDefinition)"
  })
  void testWithResolvedAssessmentDefinitionWithValue_thenReturnInputString() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference2 = Optional.of(immutableEntityReference);

    // Act
    ImmutableAssessmentHeaderCell actualWithResolvedAssessmentDefinitionResult =
        immutableAssessmentHeaderCell.withResolvedAssessmentDefinition(
            provenanceResult2
                .qualifierReference(qualifierReference2)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals("Input String", actualWithResolvedAssessmentDefinitionResult.inputString());
    assertEquals(1, actualWithResolvedAssessmentDefinitionResult.columnId());
    assertEquals(
        ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND,
        actualWithResolvedAssessmentDefinitionResult.status());
    assertTrue(actualWithResolvedAssessmentDefinitionResult.ratingLookupMap().isEmpty());
    assertTrue(actualWithResolvedAssessmentDefinitionResult.isSingleValued());
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withResolvedRating(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAssessmentHeaderCell#withResolvedRating(Optional)}
   */
  @Test
  @DisplayName("Test withResolvedRating(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withResolvedRating(Optional)"
  })
  void testWithResolvedRatingWithOptional() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> optional = Optional.of(immutableRatingSchemeItem2);

    // Act
    ImmutableAssessmentHeaderCell actualWithResolvedRatingResult =
        immutableAssessmentHeaderCell.withResolvedRating(optional);

    // Assert
    assertEquals(immutableAssessmentHeaderCell, actualWithResolvedRatingResult);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withResolvedRating(RatingSchemeItem)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentHeaderCell#withResolvedRating(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withResolvedRating(RatingSchemeItem) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withResolvedRating(RatingSchemeItem)"
  })
  void testWithResolvedRatingWithValue() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    ImmutableAssessmentHeaderCell actualWithResolvedRatingResult =
        immutableAssessmentHeaderCell.withResolvedRating(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertEquals(immutableAssessmentHeaderCell, actualWithResolvedRatingResult);
  }

  /**
   * Test {@link ImmutableAssessmentHeaderCell#withStatus(ResolvedAssessmentHeaderStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentHeaderCell#withStatus(ResolvedAssessmentHeaderStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ResolvedAssessmentHeaderStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentHeaderCell ImmutableAssessmentHeaderCell.withStatus(ResolvedAssessmentHeaderStatus)"
  })
  void testWithStatus() {
    // Arrange
    Builder inputStringResult =
        ImmutableAssessmentHeaderCell.builder().columnId(1).inputString("Input String");

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    ImmutableAssessmentDefinition immutableAssessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    Optional<? extends AssessmentDefinition> resolvedAssessmentDefinition =
        Optional.of(immutableAssessmentDefinition);

    Builder resolvedAssessmentDefinitionResult =
        inputStringResult.resolvedAssessmentDefinition(resolvedAssessmentDefinition);
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<? extends RatingSchemeItem> resolvedRating = Optional.of(immutableRatingSchemeItem);
    ImmutableAssessmentHeaderCell immutableAssessmentHeaderCell =
        resolvedAssessmentDefinitionResult
            .resolvedRating(resolvedRating)
            .status(ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND)
            .build();

    // Act
    ImmutableAssessmentHeaderCell actualWithStatusResult =
        immutableAssessmentHeaderCell.withStatus(
            ResolvedAssessmentHeaderStatus.HEADER_DEFINITION_NOT_FOUND);

    // Assert
    assertSame(immutableAssessmentHeaderCell, actualWithStatusResult);
  }
}
