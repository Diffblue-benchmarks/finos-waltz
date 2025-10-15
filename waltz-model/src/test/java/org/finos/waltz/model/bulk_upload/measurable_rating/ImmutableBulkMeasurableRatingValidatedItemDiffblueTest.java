package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingValidatedItem.Json;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingValidatedItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code RATING}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code RATING}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllChangedFields(Iterable); given 'RATING'; when LinkedHashSet() add 'RATING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_givenRating_whenLinkedHashSetAddRating() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act
    Builder actualAddAllChangedFieldsResult = builderResult.addAllChangedFields(elements);

    // Assert
    assertSame(builderResult, actualAddAllChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addAllChangedFields(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangedFields(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangedFields(Iterable)"})
  void testBuilderAddAllChangedFields_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualAddAllChangedFieldsResult = builderResult.addAllChangedFields(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code MEASURABLE_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); given 'MEASURABLE_NOT_FOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_givenMeasurableNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act
    Builder actualAddAllErrorsResult = builderResult.addAllErrors(elements);

    // Assert
    assertSame(builderResult, actualAddAllErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addAllErrors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllErrors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllErrors(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllErrors(Iterable)"})
  void testBuilderAddAllErrors_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualAddAllErrorsResult = builderResult.addAllErrors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addChangedFields(ChangedFieldType)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addChangedFields(ChangedFieldType)}
   */
  @Test
  @DisplayName("Test Builder addChangedFields(ChangedFieldType) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangedFields(ChangedFieldType)"})
  void testBuilderAddChangedFieldsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualAddChangedFieldsResult = builderResult.addChangedFields(ChangedFieldType.RATING);

    // Assert
    assertSame(builderResult, actualAddChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addChangedFields(ChangedFieldType[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addChangedFields(ChangedFieldType[])}
   */
  @Test
  @DisplayName("Test Builder addChangedFields(ChangedFieldType[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangedFields(ChangedFieldType[])"})
  void testBuilderAddChangedFieldsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualAddChangedFieldsResult = builderResult.addChangedFields(ChangedFieldType.RATING);

    // Assert
    assertSame(builderResult, actualAddChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(ValidationError)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addErrors(ValidationError)}
   */
  @Test
  @DisplayName("Test Builder addErrors(ValidationError) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(ValidationError)"})
  void testBuilderAddErrorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualAddErrorsResult = builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND);

    // Assert
    assertSame(builderResult, actualAddErrorsResult);
  }

  /**
   * Test Builder {@link Builder#addErrors(ValidationError[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addErrors(ValidationError[])}
   */
  @Test
  @DisplayName("Test Builder addErrors(ValidationError[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addErrors(ValidationError[])"})
  void testBuilderAddErrorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualAddErrorsResult = builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND);

    // Assert
    assertSame(builderResult, actualAddErrorsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#allocationScheme(AllocationScheme)}
   *   <li>{@link Builder#application(Application)}
   *   <li>{@link Builder#measurable(Measurable)}
   *   <li>{@link Builder#ratingSchemeItem(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.allocationScheme(AllocationScheme)",
    "Builder Builder.application(Application)",
    "ImmutableBulkMeasurableRatingValidatedItem Builder.build()",
    "Builder Builder.measurable(Measurable)",
    "Builder Builder.ratingSchemeItem(RatingSchemeItem)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    ImmutableAllocationScheme allocationScheme =
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build();
    Builder actualAllocationSchemeResult = actualBuilderResult.allocationScheme(allocationScheme);
    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication application =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Builder actualChangeOperationResult =
        actualAllocationSchemeResult.application(application).changeOperation(ChangeOperation.ADD);
    ImmutableMeasurable measurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Builder actualMeasurableResult = actualChangeOperationResult.measurable(measurable);
    ImmutableBulkMeasurableRatingItem parsedItem =
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build();
    Builder actualParsedItemResult = actualMeasurableResult.parsedItem(parsedItem);
    ImmutableRatingSchemeItem ratingSchemeItem =
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
    ImmutableBulkMeasurableRatingValidatedItem actualImmutableBulkMeasurableRatingValidatedItem =
        actualParsedItemResult.ratingSchemeItem(ratingSchemeItem).build();

    // Assert
    assertEquals(
        ChangeOperation.ADD, actualImmutableBulkMeasurableRatingValidatedItem.changeOperation());
    assertTrue(actualImmutableBulkMeasurableRatingValidatedItem.changedFields().isEmpty());
    assertTrue(actualImmutableBulkMeasurableRatingValidatedItem.errors().isEmpty());
    assertSame(
        allocationScheme, actualImmutableBulkMeasurableRatingValidatedItem.allocationScheme());
    assertSame(application, actualImmutableBulkMeasurableRatingValidatedItem.application());
    assertSame(parsedItem, actualImmutableBulkMeasurableRatingValidatedItem.parsedItem());
    assertSame(measurable, actualImmutableBulkMeasurableRatingValidatedItem.measurable());
    assertSame(
        ratingSchemeItem, actualImmutableBulkMeasurableRatingValidatedItem.ratingSchemeItem());
  }

  /**
   * Test Builder {@link Builder#changeOperation(ChangeOperation)}.
   *
   * <p>Method under test: {@link Builder#changeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName("Test Builder changeOperation(ChangeOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeOperation(ChangeOperation)"})
  void testBuilderChangeOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualChangeOperationResult = builderResult.changeOperation(ChangeOperation.ADD);

    // Assert
    assertSame(builderResult, actualChangeOperationResult);
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code RATING}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code RATING}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder changedFields(Iterable); given 'RATING'; when LinkedHashSet() add 'RATING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_givenRating_whenLinkedHashSetAddRating() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act
    Builder actualChangedFieldsResult = builderResult.changedFields(elements);

    // Assert
    assertSame(builderResult, actualChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#changedFields(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changedFields(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changedFields(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changedFields(Iterable)"})
  void testBuilderChangedFields_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualChangedFieldsResult = builderResult.changedFields(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangedFieldsResult);
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code MEASURABLE_NOT_FOUND}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code MEASURABLE_NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder errors(Iterable); given 'MEASURABLE_NOT_FOUND'; when LinkedHashSet() add 'MEASURABLE_NOT_FOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_givenMeasurableNotFound_whenLinkedHashSetAddMeasurableNotFound() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act
    Builder actualErrorsResult = builderResult.errors(elements);

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#errors(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#errors(Iterable)}
   */
  @Test
  @DisplayName("Test Builder errors(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errors(Iterable)"})
  void testBuilderErrors_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualErrorsResult = builderResult.errors(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualErrorsResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem instance =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingValidatedItem actualImmutableBulkMeasurableRatingValidatedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingValidatedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingValidatedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();
    builderResult2.addChangedFields(ChangedFieldType.RATING);

    Builder allocationSchemeResult =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem instance =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingValidatedItem actualImmutableBulkMeasurableRatingValidatedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingValidatedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingValidatedItem)}.
   *
   * <ul>
   *   <li>Given {@code APPLICATION_NOT_FOUND}.
   *   <li>Then return build changedFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkMeasurableRatingValidatedItem); given 'APPLICATION_NOT_FOUND'; then return build changedFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingValidatedItem)"})
  void testBuilderFrom_givenApplicationNotFound_thenReturnBuildChangedFieldsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();
    builderResult2.addErrors(ValidationError.APPLICATION_NOT_FOUND);
    builderResult2.addChangedFields(ChangedFieldType.RATING);

    Builder allocationSchemeResult =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        builderResult
            .from(
                parsedItemResult
                    .ratingSchemeItem(
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
                    .build())
            .build();
    Set<ChangedFieldType> changedFieldsResult =
        immutableBulkMeasurableRatingValidatedItem.changedFields();
    assertEquals(1, changedFieldsResult.size());
    Set<ValidationError> errorsResult = immutableBulkMeasurableRatingValidatedItem.errors();
    assertEquals(1, errorsResult.size());
    assertTrue(changedFieldsResult.contains(ChangedFieldType.RATING));
    assertTrue(errorsResult.contains(ValidationError.APPLICATION_NOT_FOUND));
  }

  /**
   * Test Builder {@link Builder#parsedItem(BulkMeasurableRatingItem)}.
   *
   * <ul>
   *   <li>When {@link ImmutableBulkMeasurableRatingItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parsedItem(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName(
      "Test Builder parsedItem(BulkMeasurableRatingItem); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parsedItem(BulkMeasurableRatingItem)"})
  void testBuilderParsedItem_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    // Act
    Builder actualParsedItemResult =
        builderResult.parsedItem(new ImmutableBulkMeasurableRatingItem.Json());

    // Assert
    assertSame(builderResult, actualParsedItemResult);
  }

  /**
   * Test {@link
   * ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}.
   *
   * <ul>
   *   <li>Then allocationScheme return {@link ImmutableAllocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#copyOf(BulkMeasurableRatingValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkMeasurableRatingValidatedItem); then allocationScheme return ImmutableAllocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.copyOf(BulkMeasurableRatingValidatedItem)"
  })
  void testCopyOf_thenAllocationSchemeReturnImmutableAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem instance =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualCopyOfResult =
        ImmutableBulkMeasurableRatingValidatedItem.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(actualCopyOfResult.application() instanceof ImmutableApplication);
    assertTrue(actualCopyOfResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualCopyOfResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualCopyOfResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualCopyOfResult.changeOperation());
    assertTrue(actualCopyOfResult.changedFields().isEmpty());
    assertTrue(actualCopyOfResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem2 =
        parsedItemResult2
            .ratingSchemeItem(
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
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingValidatedItem, immutableBulkMeasurableRatingValidatedItem2);
    assertEquals(
        immutableBulkMeasurableRatingValidatedItem.hashCode(),
        immutableBulkMeasurableRatingValidatedItem2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingValidatedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingValidatedItem, immutableBulkMeasurableRatingValidatedItem);
    int expectedHashCodeResult = immutableBulkMeasurableRatingValidatedItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkMeasurableRatingValidatedItem.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    builderResult.addChangedFields(ChangedFieldType.RATING);

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();
    builderResult.addErrors(ValidationError.MEASURABLE_NOT_FOUND);

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("Asset Code")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.now().atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.REMOVE);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(2L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(65)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
                ImmutableRatingSchemeItem.builder()
                    .color("Asset Code")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult2 =
        builderResult2.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult2 =
        allocationSchemeResult2
            .application(
                overallRatingResult2
                    .parentAssetCode(parentAssetCode2)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult2 =
        changeOperationResult2.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult2 =
        measurableResult2.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingValidatedItem,
        parsedItemResult2
            .ratingSchemeItem(
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
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        parsedItemResult
            .ratingSchemeItem(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingValidatedItem.equals(Object)",
    "int ImmutableBulkMeasurableRatingValidatedItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act and Assert
    assertNotEquals(
        parsedItemResult
            .ratingSchemeItem(
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
            .build(),
        "Different type to ImmutableBulkMeasurableRatingValidatedItem");
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then return allocationScheme is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'ADD'; then return allocationScheme is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_givenAdd_thenReturnAllocationSchemeIsNull() {
    // Arrange
    Json json = new Json();
    json.setChangeOperation(ChangeOperation.ADD);
    json.setParsedItem(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidatedItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.allocationScheme());
    assertNull(actualFromJsonResult.application());
    assertNull(actualFromJsonResult.measurable());
    assertNull(actualFromJsonResult.ratingSchemeItem());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocationScheme is {@link Json} (default constructor) {@link
   *       Json#allocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return allocationScheme is Json (default constructor) allocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnAllocationSchemeIsJsonAllocationScheme() {
    // Arrange
    Json json = new Json();
    json.setAllocationScheme(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setParsedItem(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidatedItem.fromJson(json);

    // Assert
    AllocationScheme expectedAllocationSchemeResult = json.allocationScheme;
    assertSame(expectedAllocationSchemeResult, actualFromJsonResult.allocationScheme());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return application is {@link Json} (default constructor) {@link Json#application}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return application is Json (default constructor) application")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationIsJsonApplication() {
    // Arrange
    Json json = new Json();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    json.setApplication(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setParsedItem(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidatedItem.fromJson(json);

    // Assert
    Application expectedApplicationResult = json.application;
    assertSame(expectedApplicationResult, actualFromJsonResult.application());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurable is {@link Json} (default constructor) {@link Json#measurable}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return measurable is Json (default constructor) measurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnMeasurableIsJsonMeasurable() {
    // Arrange
    Json json = new Json();
    json.setMeasurable(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setParsedItem(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidatedItem.fromJson(json);

    // Assert
    Measurable expectedMeasurableResult = json.measurable;
    assertSame(expectedMeasurableResult, actualFromJsonResult.measurable());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItem is {@link Json} (default constructor) {@link
   *       Json#ratingSchemeItem}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return ratingSchemeItem is Json (default constructor) ratingSchemeItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_thenReturnRatingSchemeItemIsJsonRatingSchemeItem() {
    // Arrange
    Json json = new Json();
    json.setRatingSchemeItem(
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
    json.setChangeOperation(ChangeOperation.ADD);
    json.setParsedItem(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidatedItem.fromJson(json);

    // Assert
    RatingSchemeItem expectedRatingSchemeItemResult = json.ratingSchemeItem;
    assertSame(expectedRatingSchemeItemResult, actualFromJsonResult.ratingSchemeItem());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Errors is {@code null}.
   *   <li>Then return allocationScheme is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Errors is 'null'; then return allocationScheme is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.fromJson(Json)"
  })
  void testFromJson_whenJsonErrorsIsNull_thenReturnAllocationSchemeIsNull() {
    // Arrange
    Json json = new Json();
    json.setParsedItem(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build());
    json.setChangeOperation(ChangeOperation.ADD);
    json.setChangedFields(null);
    json.setErrors(null);
    json.setApplication(null);
    json.setMeasurable(null);
    json.setRatingSchemeItem(null);
    json.setAllocationScheme(null);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualFromJsonResult =
        ImmutableBulkMeasurableRatingValidatedItem.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.allocationScheme());
    assertNull(actualFromJsonResult.application());
    assertNull(actualFromJsonResult.measurable());
    assertNull(actualFromJsonResult.ratingSchemeItem());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#toString()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#allocationScheme()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#application()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#changeOperation()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#changedFields()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#errors()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#measurable()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#parsedItem()}
   *   <li>{@link ImmutableBulkMeasurableRatingValidatedItem#ratingSchemeItem()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AllocationScheme ImmutableBulkMeasurableRatingValidatedItem.allocationScheme()",
    "Application ImmutableBulkMeasurableRatingValidatedItem.application()",
    "ChangeOperation ImmutableBulkMeasurableRatingValidatedItem.changeOperation()",
    "Set ImmutableBulkMeasurableRatingValidatedItem.changedFields()",
    "Set ImmutableBulkMeasurableRatingValidatedItem.errors()",
    "Measurable ImmutableBulkMeasurableRatingValidatedItem.measurable()",
    "BulkMeasurableRatingItem ImmutableBulkMeasurableRatingValidatedItem.parsedItem()",
    "RatingSchemeItem ImmutableBulkMeasurableRatingValidatedItem.ratingSchemeItem()",
    "String ImmutableBulkMeasurableRatingValidatedItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    String actualToStringResult = immutableBulkMeasurableRatingValidatedItem.toString();
    AllocationScheme actualAllocationSchemeResult =
        immutableBulkMeasurableRatingValidatedItem.allocationScheme();
    Application actualApplicationResult = immutableBulkMeasurableRatingValidatedItem.application();
    ChangeOperation actualChangeOperationResult =
        immutableBulkMeasurableRatingValidatedItem.changeOperation();
    Set<ChangedFieldType> actualChangedFieldsResult =
        immutableBulkMeasurableRatingValidatedItem.changedFields();
    Set<ValidationError> actualErrorsResult = immutableBulkMeasurableRatingValidatedItem.errors();
    Measurable actualMeasurableResult = immutableBulkMeasurableRatingValidatedItem.measurable();
    BulkMeasurableRatingItem actualParsedItemResult =
        immutableBulkMeasurableRatingValidatedItem.parsedItem();

    // Assert
    assertTrue(actualAllocationSchemeResult instanceof ImmutableAllocationScheme);
    assertTrue(actualApplicationResult instanceof ImmutableApplication);
    assertTrue(actualParsedItemResult instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualMeasurableResult instanceof ImmutableMeasurable);
    assertTrue(
        immutableBulkMeasurableRatingValidatedItem.ratingSchemeItem()
            instanceof ImmutableRatingSchemeItem);
    assertEquals(
        "BulkMeasurableRatingValidatedItem{parsedItem=BulkMeasurableRatingItem{assetCode=Asset Code,"
            + " taxonomyExternalId=42, ratingCode=A, isPrimary=false, comment=Comment, allocation=1, scheme=Scheme},"
            + " changeOperation=ADD, changedFields=[], errors=[], application=Application{id=1, isRemoved=false,"
            + " name=Name, entityLifecycleStatus=ACTIVE, organisationalUnitId=1, assetCode=42, parentAssetCode=42,"
            + " applicationKind=IN_HOUSE, lifecyclePhase=PRODUCTION, overallRating=R, plannedRetirementDate=1970-01"
            + "-01T00:00, actualRetirementDate=1970-01-01T00:00, commissionDate=1970-01-01T00:00, kind=ALL,"
            + " provenance=Provenance, externalId=Optional[42], businessCriticality=LOW}, measurable=Measurable{id=1,"
            + " name=Name, parentId=1, externalId=42, entityLifecycleStatus=ACTIVE, externalParentId=42, lastUpdatedAt"
            + "=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, position=0, categoryId=1,"
            + " concrete=true, organisationalUnitId=1, kind=ALL}, ratingSchemeItem=RatingSchemeItem{id=1, name=Name,"
            + " position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1, userSelectable=true,"
            + " isRestricted=false, ratingGroup=Rating Group, requiresComment=false}, allocationScheme=AllocationScheme"
            + "{id=1, name=Name, externalId=42, measurableCategoryId=1}}",
        actualToStringResult);
    assertEquals(ChangeOperation.ADD, actualChangeOperationResult);
    assertTrue(actualChangedFieldsResult.isEmpty());
    assertTrue(actualErrorsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#allocationScheme()}.
   *
   * <p>Method under test: {@link Json#allocationScheme()}
   */
  @Test
  @DisplayName("Test Json allocationScheme()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllocationScheme Json.allocationScheme()"})
  void testJsonAllocationScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationScheme());
  }

  /**
   * Test Json {@link Json#application()}.
   *
   * <p>Method under test: {@link Json#application()}
   */
  @Test
  @DisplayName("Test Json application()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application Json.application()"})
  void testJsonApplication() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().application());
  }

  /**
   * Test Json {@link Json#changeOperation()}.
   *
   * <p>Method under test: {@link Json#changeOperation()}
   */
  @Test
  @DisplayName("Test Json changeOperation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeOperation Json.changeOperation()"})
  void testJsonChangeOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeOperation());
  }

  /**
   * Test Json {@link Json#changedFields()}.
   *
   * <p>Method under test: {@link Json#changedFields()}
   */
  @Test
  @DisplayName("Test Json changedFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.changedFields()"})
  void testJsonChangedFields() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changedFields());
  }

  /**
   * Test Json {@link Json#errors()}.
   *
   * <p>Method under test: {@link Json#errors()}
   */
  @Test
  @DisplayName("Test Json errors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.errors()"})
  void testJsonErrors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errors());
  }

  /**
   * Test Json {@link Json#measurable()}.
   *
   * <p>Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurable());
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
    assertNull(actualJson.allocationScheme);
    assertNull(actualJson.application);
    assertNull(actualJson.parsedItem);
    assertNull(actualJson.changeOperation);
    assertNull(actualJson.measurable);
    assertNull(actualJson.ratingSchemeItem);
    assertTrue(actualJson.changedFields.isEmpty());
    assertTrue(actualJson.errors.isEmpty());
  }

  /**
   * Test Json {@link Json#parsedItem()}.
   *
   * <p>Method under test: {@link Json#parsedItem()}
   */
  @Test
  @DisplayName("Test Json parsedItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkMeasurableRatingItem Json.parsedItem()"})
  void testJsonParsedItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parsedItem());
  }

  /**
   * Test Json {@link Json#ratingSchemeItem()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeItem()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem Json.ratingSchemeItem()"})
  void testJsonRatingSchemeItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeItem());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withAllocationScheme(AllocationScheme)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withAllocationScheme(AllocationScheme)}
   */
  @Test
  @DisplayName("Test withAllocationScheme(AllocationScheme)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withAllocationScheme(AllocationScheme)"
  })
  void testWithAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithAllocationSchemeResult =
        immutableBulkMeasurableRatingValidatedItem.withAllocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkMeasurableRatingValidatedItem, actualWithAllocationSchemeResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withApplication(Application)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withApplication(Application)}
   */
  @Test
  @DisplayName("Test withApplication(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withApplication(Application)"
  })
  void testWithApplication() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithApplicationResult =
        immutableBulkMeasurableRatingValidatedItem.withApplication(
            overallRatingResult2
                .parentAssetCode(parentAssetCode2)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableBulkMeasurableRatingValidatedItem, actualWithApplicationResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withChangeOperation(ChangeOperation)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withChangeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName("Test withChangeOperation(ChangeOperation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withChangeOperation(ChangeOperation)"
  })
  void testWithChangeOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithChangeOperationResult =
        immutableBulkMeasurableRatingValidatedItem.withChangeOperation(ChangeOperation.ADD);

    // Assert
    assertSame(immutableBulkMeasurableRatingValidatedItem, actualWithChangeOperationResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withChangeOperation(ChangeOperation)}.
   *
   * <ul>
   *   <li>Then allocationScheme return {@link ImmutableAllocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withChangeOperation(ChangeOperation)}
   */
  @Test
  @DisplayName(
      "Test withChangeOperation(ChangeOperation); then allocationScheme return ImmutableAllocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withChangeOperation(ChangeOperation)"
  })
  void testWithChangeOperation_thenAllocationSchemeReturnImmutableAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.REMOVE);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithChangeOperationResult =
        parsedItemResult
            .ratingSchemeItem(
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
            .build()
            .withChangeOperation(ChangeOperation.ADD);

    // Assert
    assertTrue(
        actualWithChangeOperationResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(actualWithChangeOperationResult.application() instanceof ImmutableApplication);
    assertTrue(
        actualWithChangeOperationResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualWithChangeOperationResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(
        actualWithChangeOperationResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualWithChangeOperationResult.changeOperation());
    assertTrue(actualWithChangeOperationResult.changedFields().isEmpty());
    assertTrue(actualWithChangeOperationResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withChangedFields(ChangedFieldType[])}
   * with {@code ChangedFieldType[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withChangedFields(ChangedFieldType[])}
   */
  @Test
  @DisplayName("Test withChangedFields(ChangedFieldType[]) with 'ChangedFieldType[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withChangedFields(ChangedFieldType[])"
  })
  void testWithChangedFieldsWithChangedFieldType() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithChangedFieldsResult =
        parsedItemResult
            .ratingSchemeItem(
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
            .build()
            .withChangedFields(ChangedFieldType.RATING);

    // Assert
    assertTrue(
        actualWithChangedFieldsResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(actualWithChangedFieldsResult.application() instanceof ImmutableApplication);
    assertTrue(
        actualWithChangedFieldsResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualWithChangedFieldsResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(
        actualWithChangedFieldsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithChangedFieldsResult.changedFields().size());
    assertEquals(ChangeOperation.ADD, actualWithChangedFieldsResult.changeOperation());
    assertTrue(actualWithChangedFieldsResult.errors().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withChangedFields(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withChangedFields(Iterable)}
   */
  @Test
  @DisplayName("Test withChangedFields(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withChangedFields(Iterable)"
  })
  void testWithChangedFieldsWithIterable() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    LinkedHashSet<ChangedFieldType> elements = new LinkedHashSet<>();
    elements.add(ChangedFieldType.RATING);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithChangedFieldsResult =
        immutableBulkMeasurableRatingValidatedItem.withChangedFields(elements);

    // Assert
    assertTrue(
        actualWithChangedFieldsResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(actualWithChangedFieldsResult.application() instanceof ImmutableApplication);
    assertTrue(
        actualWithChangedFieldsResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualWithChangedFieldsResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(
        actualWithChangedFieldsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualWithChangedFieldsResult.changeOperation());
    assertTrue(actualWithChangedFieldsResult.errors().isEmpty());
    assertEquals(elements, actualWithChangedFieldsResult.changedFields());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withErrors(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then allocationScheme return {@link ImmutableAllocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingValidatedItem#withErrors(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withErrors(Iterable) with 'Iterable'; then allocationScheme return ImmutableAllocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withErrors(Iterable)"
  })
  void testWithErrorsWithIterable_thenAllocationSchemeReturnImmutableAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    LinkedHashSet<ValidationError> elements = new LinkedHashSet<>();
    elements.add(ValidationError.MEASURABLE_NOT_FOUND);

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithErrorsResult =
        immutableBulkMeasurableRatingValidatedItem.withErrors(elements);

    // Assert
    assertTrue(actualWithErrorsResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(actualWithErrorsResult.application() instanceof ImmutableApplication);
    assertTrue(actualWithErrorsResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualWithErrorsResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualWithErrorsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(ChangeOperation.ADD, actualWithErrorsResult.changeOperation());
    assertTrue(actualWithErrorsResult.changedFields().isEmpty());
    assertEquals(elements, actualWithErrorsResult.errors());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withErrors(ValidationError[])} with
   * {@code ValidationError[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withErrors(ValidationError[])}
   */
  @Test
  @DisplayName("Test withErrors(ValidationError[]) with 'ValidationError[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withErrors(ValidationError[])"
  })
  void testWithErrorsWithValidationError() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithErrorsResult =
        parsedItemResult
            .ratingSchemeItem(
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
            .build()
            .withErrors(ValidationError.MEASURABLE_NOT_FOUND);

    // Assert
    assertTrue(actualWithErrorsResult.allocationScheme() instanceof ImmutableAllocationScheme);
    assertTrue(actualWithErrorsResult.application() instanceof ImmutableApplication);
    assertTrue(actualWithErrorsResult.parsedItem() instanceof ImmutableBulkMeasurableRatingItem);
    assertTrue(actualWithErrorsResult.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualWithErrorsResult.ratingSchemeItem() instanceof ImmutableRatingSchemeItem);
    assertEquals(1, actualWithErrorsResult.errors().size());
    assertEquals(ChangeOperation.ADD, actualWithErrorsResult.changeOperation());
    assertTrue(actualWithErrorsResult.changedFields().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withMeasurable(Measurable)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withMeasurable(Measurable)}
   */
  @Test
  @DisplayName("Test withMeasurable(Measurable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withMeasurable(Measurable)"
  })
  void testWithMeasurable() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithMeasurableResult =
        immutableBulkMeasurableRatingValidatedItem.withMeasurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableBulkMeasurableRatingValidatedItem, actualWithMeasurableResult);
  }

  /**
   * Test {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withParsedItem(BulkMeasurableRatingItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withParsedItem(BulkMeasurableRatingItem)}
   */
  @Test
  @DisplayName("Test withParsedItem(BulkMeasurableRatingItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withParsedItem(BulkMeasurableRatingItem)"
  })
  void testWithParsedItem() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithParsedItemResult =
        immutableBulkMeasurableRatingValidatedItem.withParsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());

    // Assert
    assertEquals(immutableBulkMeasurableRatingValidatedItem, actualWithParsedItemResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingValidatedItem#withRatingSchemeItem(RatingSchemeItem)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingValidatedItem#withRatingSchemeItem(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withRatingSchemeItem(RatingSchemeItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingValidatedItem ImmutableBulkMeasurableRatingValidatedItem.withRatingSchemeItem(RatingSchemeItem)"
  })
  void testWithRatingSchemeItem() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingValidatedItem.builder();

    Builder allocationSchemeResult =
        builderResult.allocationScheme(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    Builder changeOperationResult =
        allocationSchemeResult
            .application(
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build())
            .changeOperation(ChangeOperation.ADD);

    Builder measurableResult =
        changeOperationResult.measurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    Builder parsedItemResult =
        measurableResult.parsedItem(
            ImmutableBulkMeasurableRatingItem.builder()
                .allocation(1)
                .assetCode("Asset Code")
                .comment("Comment")
                .ratingCode('A')
                .scheme("Scheme")
                .taxonomyExternalId("42")
                .build());
    ImmutableBulkMeasurableRatingValidatedItem immutableBulkMeasurableRatingValidatedItem =
        parsedItemResult
            .ratingSchemeItem(
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
            .build();

    // Act
    ImmutableBulkMeasurableRatingValidatedItem actualWithRatingSchemeItemResult =
        immutableBulkMeasurableRatingValidatedItem.withRatingSchemeItem(
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
    assertEquals(immutableBulkMeasurableRatingValidatedItem, actualWithRatingSchemeItemResult);
  }
}
