package org.finos.waltz.model.bulk_upload.taxonomy;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.ChangeOperation;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult.BulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidationResult.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyValidationResult.Json;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyValidationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllPlannedRemovals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllPlannedRemovals(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllPlannedRemovals(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllPlannedRemovals(Iterable)"})
  void testBuilderAddAllPlannedRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualAddAllPlannedRemovalsResult =
        builderResult.addAllPlannedRemovals(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllPlannedRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addAllValidatedItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllValidatedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValidatedItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllValidatedItems(Iterable)"})
  void testBuilderAddAllValidatedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualAddAllValidatedItemsResult =
        builderResult.addAllValidatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedRemovals(Measurable)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addPlannedRemovals(Measurable)}
   */
  @Test
  @DisplayName("Test Builder addPlannedRemovals(Measurable) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPlannedRemovals(Measurable)"})
  void testBuilderAddPlannedRemovalsWithElement() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualAddPlannedRemovalsResult =
        builderResult.addPlannedRemovals(
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
    assertEquals(1, builderResult.build().plannedRemovals().size());
    assertSame(builderResult, actualAddPlannedRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedRemovals(Measurable[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addPlannedRemovals(Measurable[])}
   */
  @Test
  @DisplayName("Test Builder addPlannedRemovals(Measurable[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPlannedRemovals(Measurable[])"})
  void testBuilderAddPlannedRemovalsWithElements() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualAddPlannedRemovalsResult =
        builderResult.addPlannedRemovals(
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
    assertEquals(1, builderResult.build().plannedRemovals().size());
    assertSame(builderResult, actualAddPlannedRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(BulkTaxonomyValidatedItem) with 'element'; then builder build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkTaxonomyValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json element = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then builder build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValidatedItems(BulkTaxonomyValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(BulkTaxonomyValidatedItem[]) with 'elements'; then builder build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkTaxonomyValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#error(BulkTaxonomyParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult Builder.build()",
    "Builder Builder.error(BulkTaxonomyParseError)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyParseError error =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkTaxonomyValidationResult actualImmutableBulkTaxonomyValidationResult =
        actualBuilderResult.error(error).build();

    // Assert
    assertTrue(actualImmutableBulkTaxonomyValidationResult.validatedItems().isEmpty());
    assertTrue(actualImmutableBulkTaxonomyValidationResult.plannedRemovals().isEmpty());
    assertSame(error, actualImmutableBulkTaxonomyValidationResult.error());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult instance =
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyValidationResult actualImmutableBulkTaxonomyValidationResult =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyValidationResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   *
   * <ul>
   *   <li>Then return build plannedRemovals Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkTaxonomyValidationResult); then return build plannedRemovals Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom_thenReturnBuildPlannedRemovalsEmpty() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    builderResult2.addValidatedItems(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableBulkTaxonomyParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build())
            .build();
    List<BulkTaxonomyValidatedItem> validatedItemsResult =
        immutableBulkTaxonomyValidationResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkTaxonomyValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult.existingItemReference() instanceof ImmutableEntityReference);
    assertTrue(getResult.parsedItem() instanceof ImmutableBulkTaxonomyItem);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyValidatedItem);
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
    assertTrue(immutableBulkTaxonomyValidationResult.plannedRemovals().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyValidationResult)}.
   *
   * <ul>
   *   <li>Then return build plannedRemovals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkTaxonomyValidationResult); then return build plannedRemovals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyValidationResult)"})
  void testBuilderFrom_thenReturnBuildPlannedRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult2.addPlannedRemovals(
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

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    builderResult2.addValidatedItems(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    // Act and Assert
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .from(
                builderResult2
                    .error(
                        ImmutableBulkTaxonomyParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build())
            .build();
    List<BulkTaxonomyValidatedItem> validatedItemsResult =
        immutableBulkTaxonomyValidationResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkTaxonomyValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult.existingItemReference() instanceof ImmutableEntityReference);
    assertTrue(getResult.parsedItem() instanceof ImmutableBulkTaxonomyItem);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyValidatedItem);
    assertEquals(1, immutableBulkTaxonomyValidationResult.plannedRemovals().size());
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
  }

  /**
   * Test Builder {@link Builder#plannedRemovals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plannedRemovals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder plannedRemovals(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedRemovals(Iterable)"})
  void testBuilderPlannedRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualPlannedRemovalsResult = builderResult.plannedRemovals(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualPlannedRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#validatedItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#validatedItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder validatedItems(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validatedItems(Iterable)"})
  void testBuilderValidatedItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act
    Builder actualValidatedItemsResult = builderResult.validatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualValidatedItemsResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}.
   *
   * <ul>
   *   <li>Then error return {@link ImmutableBulkTaxonomyParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidationResult#copyOf(BulkTaxonomyValidationResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkTaxonomyValidationResult); then error return ImmutableBulkTaxonomyParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.copyOf(BulkTaxonomyValidationResult)"
  })
  void testCopyOf_thenErrorReturnImmutableBulkTaxonomyParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult instance =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidationResult actualCopyOfResult =
        ImmutableBulkTaxonomyValidationResult.copyOf(instance);

    // Assert
    BulkTaxonomyParseError errorResult = actualCopyOfResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
    assertTrue(actualCopyOfResult.plannedRemovals().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
    "int ImmutableBulkTaxonomyValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult2 =
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyValidationResult, immutableBulkTaxonomyValidationResult2);
    assertEquals(
        immutableBulkTaxonomyValidationResult.hashCode(),
        immutableBulkTaxonomyValidationResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
    "int ImmutableBulkTaxonomyValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyValidationResult, immutableBulkTaxonomyValidationResult);
    int expectedHashCodeResult = immutableBulkTaxonomyValidationResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkTaxonomyValidationResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
    "int ImmutableBulkTaxonomyValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    builderResult.addValidatedItems(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidationResult,
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
    "int ImmutableBulkTaxonomyValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    builderResult.addPlannedRemovals(
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
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    Builder builderResult2 = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyValidationResult,
        builderResult2
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
    "int ImmutableBulkTaxonomyValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyValidationResult.equals(Object)",
    "int ImmutableBulkTaxonomyValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        "Different type to ImmutableBulkTaxonomyValidationResult");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableBulkTaxonomyValidatedItem.Json}
   *       (default constructor).
   *   <li>Then return validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setPlannedRemovals(new HashSet<>());
    json2.setError(new ImmutableBulkTaxonomyParseError.Json());

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(json2);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ValidatedItems is {@code null}.
   *   <li>Then return error is {@link ImmutableBulkTaxonomyParseError.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return error is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonValidatedItemsIsNull_thenReturnErrorIsJson() {
    // Arrange
    Json json = new Json();
    json.setValidatedItems(null);
    json.setPlannedRemovals(new HashSet<>());
    ImmutableBulkTaxonomyParseError.Json error = new ImmutableBulkTaxonomyParseError.Json();
    json.setError(error);

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    assertSame(error, actualFromJsonResult.error());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return plannedRemovals is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedRemovals is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnPlannedRemovalsIsLinkedHashSet() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    validatedItems.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    LinkedHashSet<Measurable> plannedRemovals = new LinkedHashSet<>();
    plannedRemovals.add(
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
    plannedRemovals.add(
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

    Json json = new Json();
    json.setValidatedItems(validatedItems);
    json.setPlannedRemovals(plannedRemovals);
    json.setError(
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    BulkTaxonomyParseError errorResult = actualFromJsonResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertEquals(plannedRemovals, actualFromJsonResult.plannedRemovals());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return plannedRemovals size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedRemovals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnPlannedRemovalsSizeIsOne() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    validatedItems.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());

    LinkedHashSet<Measurable> plannedRemovals = new LinkedHashSet<>();
    plannedRemovals.add(
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

    Json json = new Json();
    json.setValidatedItems(validatedItems);
    json.setPlannedRemovals(plannedRemovals);
    json.setError(
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(json);

    // Assert
    BulkTaxonomyParseError errorResult = actualFromJsonResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(1, actualFromJsonResult.plannedRemovals().size());
    assertEquals(2, errorResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return validatedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return validatedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    validatedItems.add(
        existingItemReferenceResult
            .parsedItem(
                ImmutableBulkTaxonomyItem.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .name("Name")
                    .parentExternalId("42")
                    .build())
            .build());
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setPlannedRemovals(new HashSet<>());
    json2.setError(new ImmutableBulkTaxonomyParseError.Json());

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(json2);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertEquals(2, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) PlannedRemovals is {@code null}.
   *   <li>Then return validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) PlannedRemovals is 'null'; then return validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJsonPlannedRemovalsIsNull_thenReturnValidatedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkTaxonomyValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkTaxonomyValidatedItem.Json json = new ImmutableBulkTaxonomyValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setPlannedRemovals(null);
    json2.setError(new ImmutableBulkTaxonomyParseError.Json());

    // Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(json2);

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult = actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnErrorIsNull() {
    // Arrange and Act
    ImmutableBulkTaxonomyValidationResult actualFromJsonResult =
        ImmutableBulkTaxonomyValidationResult.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.error());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
    assertTrue(actualFromJsonResult.plannedRemovals().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#toString()}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#error()}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#plannedRemovals()}
   *   <li>{@link ImmutableBulkTaxonomyValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkTaxonomyParseError ImmutableBulkTaxonomyValidationResult.error()",
    "Set ImmutableBulkTaxonomyValidationResult.plannedRemovals()",
    "String ImmutableBulkTaxonomyValidationResult.toString()",
    "List ImmutableBulkTaxonomyValidationResult.validatedItems()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableBulkTaxonomyValidationResult.toString();
    BulkTaxonomyParseError actualErrorResult = immutableBulkTaxonomyValidationResult.error();
    Set<Measurable> actualPlannedRemovalsResult =
        immutableBulkTaxonomyValidationResult.plannedRemovals();

    // Assert
    assertTrue(actualErrorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals(
        "BulkTaxonomyValidationResult{validatedItems=[], plannedRemovals=[], error=BulkTaxonomyParseError{message=Not"
            + " all who wander are lost, line=2, column=1}}",
        actualToStringResult);
    assertTrue(immutableBulkTaxonomyValidationResult.validatedItems().isEmpty());
    assertTrue(actualPlannedRemovalsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#error()}.
   *
   * <p>Method under test: {@link Json#error()}
   */
  @Test
  @DisplayName("Test Json error()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkTaxonomyParseError Json.error()"})
  void testJsonError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().error());
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
    assertNull(actualJson.error);
    assertTrue(actualJson.validatedItems.isEmpty());
    assertTrue(actualJson.plannedRemovals.isEmpty());
  }

  /**
   * Test Json {@link Json#plannedRemovals()}.
   *
   * <p>Method under test: {@link Json#plannedRemovals()}
   */
  @Test
  @DisplayName("Test Json plannedRemovals()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.plannedRemovals()"})
  void testJsonPlannedRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedRemovals());
  }

  /**
   * Test Json {@link Json#validatedItems()}.
   *
   * <p>Method under test: {@link Json#validatedItems()}
   */
  @Test
  @DisplayName("Test Json validatedItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.validatedItems()"})
  void testJsonValidatedItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().validatedItems());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#withError(BulkTaxonomyParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidationResult#withError(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test withError(BulkTaxonomyParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.withError(BulkTaxonomyParseError)"
  })
  void testWithError() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidationResult actualWithErrorResult =
        immutableBulkTaxonomyValidationResult.withError(
            ImmutableBulkTaxonomyParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableBulkTaxonomyValidationResult, actualWithErrorResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyValidationResult#withPlannedRemovals(Measurable[])} with
   * {@code Measurable[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidationResult#withPlannedRemovals(Measurable[])}
   */
  @Test
  @DisplayName("Test withPlannedRemovals(Measurable[]) with 'Measurable[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.withPlannedRemovals(Measurable[])"
  })
  void testWithPlannedRemovalsWithMeasurable() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableBulkTaxonomyValidationResult actualWithPlannedRemovalsResult =
        immutableBulkTaxonomyValidationResult.withPlannedRemovals(
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
    BulkTaxonomyParseError errorResult = actualWithPlannedRemovalsResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(1, actualWithPlannedRemovalsResult.plannedRemovals().size());
    assertEquals(2, errorResult.line().intValue());
    assertTrue(actualWithPlannedRemovalsResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link
   * ImmutableBulkTaxonomyValidationResult#withValidatedItems(BulkTaxonomyValidatedItem[])} with
   * {@code BulkTaxonomyValidatedItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkTaxonomyValidationResult#withValidatedItems(BulkTaxonomyValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test withValidatedItems(BulkTaxonomyValidatedItem[]) with 'BulkTaxonomyValidatedItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyValidationResult ImmutableBulkTaxonomyValidationResult.withValidatedItems(BulkTaxonomyValidatedItem[])"
  })
  void testWithValidatedItemsWithBulkTaxonomyValidatedItem() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyValidationResult.builder();
    ImmutableBulkTaxonomyValidationResult immutableBulkTaxonomyValidationResult =
        builderResult
            .error(
                ImmutableBulkTaxonomyParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    ImmutableBulkTaxonomyValidatedItem.Builder changeOperationResult =
        ImmutableBulkTaxonomyValidatedItem.builder().changeOperation(ChangeOperation.ADD);

    ImmutableBulkTaxonomyValidatedItem.Builder existingItemReferenceResult =
        changeOperationResult.existingItemReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkTaxonomyValidationResult actualWithValidatedItemsResult =
        immutableBulkTaxonomyValidationResult.withValidatedItems(
            existingItemReferenceResult
                .parsedItem(
                    ImmutableBulkTaxonomyItem.builder()
                        .description("The characteristics of someone or something")
                        .externalId("42")
                        .name("Name")
                        .parentExternalId("42")
                        .build())
                .build());

    // Assert
    List<BulkTaxonomyValidatedItem> validatedItemsResult =
        actualWithValidatedItemsResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkTaxonomyValidatedItem getResult = validatedItemsResult.get(0);
    assertTrue(getResult.existingItemReference() instanceof ImmutableEntityReference);
    assertTrue(getResult.parsedItem() instanceof ImmutableBulkTaxonomyItem);
    BulkTaxonomyParseError errorResult = actualWithValidatedItemsResult.error();
    assertTrue(errorResult instanceof ImmutableBulkTaxonomyParseError);
    assertTrue(getResult instanceof ImmutableBulkTaxonomyValidatedItem);
    assertEquals("Not all who wander are lost", errorResult.message());
    assertEquals(1, errorResult.column().intValue());
    assertEquals(2, errorResult.line().intValue());
    assertEquals(ChangeOperation.ADD, getResult.changeOperation());
    assertTrue(getResult.changedFields().isEmpty());
    assertTrue(getResult.errors().isEmpty());
    assertTrue(actualWithValidatedItemsResult.plannedRemovals().isEmpty());
  }
}
