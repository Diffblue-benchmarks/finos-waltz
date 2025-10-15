package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipValidationResultDiffblueTest {
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
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act
    Builder actualAddAllValidatedItemsResult =
        builderResult.addAllValidatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem)} with {@code
   * element}.
   *
   * <ul>
   *   <li>Then builder build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(BulkUploadRelationshipValidatedItem) with 'element'; then builder build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkUploadRelationshipValidatedItem)"})
  void testBuilderAddValidatedItemsWithElement_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json element =
        new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(element);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult =
        builderResult.build().validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(element, validatedItemsResult.get(0));
    assertSame(builderResult, actualAddValidatedItemsResult);
  }

  /**
   * Test Builder {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem[])} with
   * {@code elements}.
   *
   * <ul>
   *   <li>Then builder build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValidatedItems(BulkUploadRelationshipValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addValidatedItems(BulkUploadRelationshipValidatedItem[]) with 'elements'; then builder build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValidatedItems(BulkUploadRelationshipValidatedItem[])"})
  void testBuilderAddValidatedItemsWithElements_thenBuilderBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidatedItem.Json json =
        new ImmutableBulkUploadRelationshipValidatedItem.Json();

    // Act
    Builder actualAddValidatedItemsResult = builderResult.addValidatedItems(json);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult =
        builderResult.build().validatedItems();
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
   *   <li>{@link Builder#parseError(BulkUploadRelationshipParseError)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult Builder.build()",
    "Builder Builder.parseError(BulkUploadRelationshipParseError)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipParseError parseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkUploadRelationshipValidationResult
        actualImmutableBulkUploadRelationshipValidationResult =
            actualBuilderResult.parseError(parseError).build();

    // Assert
    assertTrue(actualImmutableBulkUploadRelationshipValidationResult.validatedItems().isEmpty());
    assertSame(parseError, actualImmutableBulkUploadRelationshipValidationResult.parseError());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidationResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipValidationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidationResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult instance =
        builderResult2
            .parseError(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipValidationResult
        actualImmutableBulkUploadRelationshipValidationResult = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipValidationResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipValidationResult)}.
   *
   * <ul>
   *   <li>Then return build validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(BulkUploadRelationshipValidationResult); then return build validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipValidationResult)"})
  void testBuilderFrom_thenReturnBuildValidatedItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();

    ImmutableBulkUploadRelationshipValidatedItem.Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    ImmutableBulkUploadRelationshipValidatedItem.Builder addAllErrorResult =
        descriptionResult.addAllError(new ArrayList<>());

    ImmutableBulkUploadRelationshipValidatedItem.Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    ImmutableBulkUploadRelationshipValidatedItem.Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    builderResult2.addValidatedItems(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());

    // Act and Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult =
        builderResult
            .from(
                builderResult2
                    .parseError(
                        ImmutableBulkUploadRelationshipParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build())
            .build()
            .validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkUploadRelationshipValidatedItem getResult = validatedItemsResult.get(0);
    EntityReference sourceEntityRefResult2 = getResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = getResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    BulkUploadRelationshipItem parsedItemResult2 = getResult.parsedItem();
    assertTrue(parsedItemResult2 instanceof ImmutableBulkUploadRelationshipItem);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipValidatedItem);
    assertEquals("42", parsedItemResult2.sourceExternalId());
    assertEquals("42", parsedItemResult2.targetExternalId());
    assertEquals(
        "The characteristics of someone or something", sourceEntityRefResult2.description());
    assertEquals("The characteristics of someone or something", parsedItemResult2.description());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, sourceEntityRefResult2.id());
    assertEquals(EntityKind.ALL, sourceEntityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceEntityRefResult2.entityLifecycleStatus());
    assertEquals(UploadOperation.ADD, getResult.uploadOperation());
    assertTrue(getResult.error().isEmpty());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
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
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act
    Builder actualValidatedItemsResult = builderResult.validatedItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualValidatedItemsResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}.
   *
   * <ul>
   *   <li>Then parseError return {@link ImmutableBulkUploadRelationshipParseError}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidationResult#copyOf(BulkUploadRelationshipValidationResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkUploadRelationshipValidationResult); then parseError return ImmutableBulkUploadRelationshipParseError")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.copyOf(BulkUploadRelationshipValidationResult)"
  })
  void testCopyOf_thenParseErrorReturnImmutableBulkUploadRelationshipParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult instance =
        builderResult
            .parseError(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualCopyOfResult =
        ImmutableBulkUploadRelationshipValidationResult.copyOf(instance);

    // Assert
    BulkUploadRelationshipParseError parseErrorResult = actualCopyOfResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertEquals("Not all who wander are lost", parseErrorResult.message());
    assertEquals(1, parseErrorResult.column().intValue());
    assertEquals(2, parseErrorResult.line().intValue());
    assertTrue(actualCopyOfResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult =
            builderResult
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult2 =
            builderResult2
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipValidationResult,
        immutableBulkUploadRelationshipValidationResult2);
    assertEquals(
        immutableBulkUploadRelationshipValidationResult.hashCode(),
        immutableBulkUploadRelationshipValidationResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipValidationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult =
            builderResult
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipValidationResult,
        immutableBulkUploadRelationshipValidationResult);
    int expectedHashCodeResult = immutableBulkUploadRelationshipValidationResult.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableBulkUploadRelationshipValidationResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    ImmutableBulkUploadRelationshipValidatedItem.Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    ImmutableBulkUploadRelationshipValidatedItem.Builder addAllErrorResult =
        descriptionResult.addAllError(new ArrayList<>());

    ImmutableBulkUploadRelationshipValidatedItem.Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    ImmutableBulkUploadRelationshipValidatedItem.Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    builderResult.addValidatedItems(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult =
            builderResult
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    Builder builderResult2 = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipValidationResult,
        builderResult2
            .parseError(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .parseError(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipValidationResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipValidationResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .parseError(
                ImmutableBulkUploadRelationshipParseError.builder()
                    .column(1)
                    .line(2)
                    .message("Not all who wander are lost")
                    .build())
            .build(),
        "Different type to ImmutableBulkUploadRelationshipValidationResult");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       ImmutableBulkUploadRelationshipValidatedItem.Json} (default constructor).
   *   <li>Then return validatedItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return validatedItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnValidatedItemsSizeIsOne() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> validatedItems = new ArrayList<>();
    ImmutableBulkUploadRelationshipValidatedItem.Json json =
        new ImmutableBulkUploadRelationshipValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidationResult.fromJson(json2);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    assertSame(json, validatedItemsResult.get(0));
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableBulkUploadRelationshipParseError.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) ParseError is {@link
   *       ImmutableBulkUploadRelationshipParseError.Json} (default constructor).
   *   <li>Then return parseError is {@link ImmutableBulkUploadRelationshipParseError.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) ParseError is Json (default constructor); then return parseError is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonParseErrorIsJson_thenReturnParseErrorIsJson() {
    // Arrange
    Json json = new Json();
    json.setValidatedItems(null);
    ImmutableBulkUploadRelationshipParseError.Json parseError =
        new ImmutableBulkUploadRelationshipParseError.Json();
    json.setParseError(parseError);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidationResult.fromJson(json);

    // Assert
    assertSame(parseError, actualFromJsonResult.parseError());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ValidatedItems is {@code null}.
   *   <li>Then return parseError is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ValidatedItems is 'null'; then return parseError is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonValidatedItemsIsNull_thenReturnParseErrorIsNull() {
    // Arrange
    Json json = new Json();
    json.setValidatedItems(null);
    json.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidationResult.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parseError());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return validatedItems size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return validatedItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(Json)"
  })
  void testFromJson_thenReturnValidatedItemsSizeIsTwo() {
    // Arrange
    ArrayList<BulkUploadRelationshipValidatedItem> validatedItems = new ArrayList<>();

    ImmutableBulkUploadRelationshipValidatedItem.Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    ImmutableBulkUploadRelationshipValidatedItem.Builder addAllErrorResult =
        descriptionResult.addAllError(new ArrayList<>());

    ImmutableBulkUploadRelationshipValidatedItem.Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    ImmutableBulkUploadRelationshipValidatedItem.Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    validatedItems.add(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());
    ImmutableBulkUploadRelationshipValidatedItem.Json json =
        new ImmutableBulkUploadRelationshipValidatedItem.Json();
    validatedItems.add(json);

    Json json2 = new Json();
    json2.setValidatedItems(validatedItems);
    json2.setParseError(null);

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidationResult.fromJson(json2);

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult =
        actualFromJsonResult.validatedItems();
    assertEquals(2, validatedItemsResult.size());
    BulkUploadRelationshipValidatedItem getResult = validatedItemsResult.get(0);
    EntityReference sourceEntityRefResult2 = getResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = getResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    assertTrue(getResult.parsedItem() instanceof ImmutableBulkUploadRelationshipItem);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipValidatedItem);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(UploadOperation.ADD, getResult.uploadOperation());
    assertTrue(getResult.error().isEmpty());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
    assertSame(json, validatedItemsResult.get(1));
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return parseError is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipValidationResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return parseError is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnParseErrorIsNull() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipValidationResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipValidationResult.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.parseError());
    assertTrue(actualFromJsonResult.validatedItems().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#parseError()}
   *   <li>{@link ImmutableBulkUploadRelationshipValidationResult#validatedItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipParseError ImmutableBulkUploadRelationshipValidationResult.parseError()",
    "String ImmutableBulkUploadRelationshipValidationResult.toString()",
    "List ImmutableBulkUploadRelationshipValidationResult.validatedItems()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult =
            builderResult
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    // Act
    String actualToStringResult = immutableBulkUploadRelationshipValidationResult.toString();
    BulkUploadRelationshipParseError actualParseErrorResult =
        immutableBulkUploadRelationshipValidationResult.parseError();

    // Assert
    assertTrue(actualParseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertEquals(
        "BulkUploadRelationshipValidationResult{validatedItems=[], parseError=BulkUploadRelationshipParseError"
            + "{message=Not all who wander are lost, line=2, column=1}}",
        actualToStringResult);
    assertTrue(immutableBulkUploadRelationshipValidationResult.validatedItems().isEmpty());
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
    assertNull(actualJson.parseError);
    assertTrue(actualJson.validatedItems.isEmpty());
  }

  /**
   * Test Json {@link Json#parseError()}.
   *
   * <p>Method under test: {@link Json#parseError()}
   */
  @Test
  @DisplayName("Test Json parseError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkUploadRelationshipParseError Json.parseError()"})
  void testJsonParseError() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parseError());
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
   * Test {@link
   * ImmutableBulkUploadRelationshipValidationResult#withParseError(BulkUploadRelationshipParseError)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidationResult#withParseError(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName("Test withParseError(BulkUploadRelationshipParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.withParseError(BulkUploadRelationshipParseError)"
  })
  void testWithParseError() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult =
            builderResult
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualWithParseErrorResult =
        immutableBulkUploadRelationshipValidationResult.withParseError(
            ImmutableBulkUploadRelationshipParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Assert
    assertEquals(immutableBulkUploadRelationshipValidationResult, actualWithParseErrorResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipValidationResult#withValidatedItems(BulkUploadRelationshipValidatedItem[])}
   * with {@code BulkUploadRelationshipValidatedItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipValidationResult#withValidatedItems(BulkUploadRelationshipValidatedItem[])}
   */
  @Test
  @DisplayName(
      "Test withValidatedItems(BulkUploadRelationshipValidatedItem[]) with 'BulkUploadRelationshipValidatedItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipValidationResult ImmutableBulkUploadRelationshipValidationResult.withValidatedItems(BulkUploadRelationshipValidatedItem[])"
  })
  void testWithValidatedItemsWithBulkUploadRelationshipValidatedItem() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();
    ImmutableBulkUploadRelationshipValidationResult
        immutableBulkUploadRelationshipValidationResult =
            builderResult
                .parseError(
                    ImmutableBulkUploadRelationshipParseError.builder()
                        .column(1)
                        .line(2)
                        .message("Not all who wander are lost")
                        .build())
                .build();

    ImmutableBulkUploadRelationshipValidatedItem.Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    ImmutableBulkUploadRelationshipValidatedItem.Builder addAllErrorResult =
        descriptionResult.addAllError(new ArrayList<>());

    ImmutableBulkUploadRelationshipValidatedItem.Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    ImmutableBulkUploadRelationshipValidatedItem.Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableBulkUploadRelationshipValidationResult actualWithValidatedItemsResult =
        immutableBulkUploadRelationshipValidationResult.withValidatedItems(
            sourceEntityRefResult
                .targetEntityRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .uploadOperation(UploadOperation.ADD)
                .build());

    // Assert
    List<BulkUploadRelationshipValidatedItem> validatedItemsResult =
        actualWithValidatedItemsResult.validatedItems();
    assertEquals(1, validatedItemsResult.size());
    BulkUploadRelationshipValidatedItem getResult = validatedItemsResult.get(0);
    EntityReference sourceEntityRefResult2 = getResult.sourceEntityRef();
    assertTrue(sourceEntityRefResult2 instanceof ImmutableEntityReference);
    EntityReference targetEntityRefResult = getResult.targetEntityRef();
    assertTrue(targetEntityRefResult instanceof ImmutableEntityReference);
    assertTrue(getResult.parsedItem() instanceof ImmutableBulkUploadRelationshipItem);
    BulkUploadRelationshipParseError parseErrorResult = actualWithValidatedItemsResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(getResult instanceof ImmutableBulkUploadRelationshipValidatedItem);
    assertEquals("Not all who wander are lost", parseErrorResult.message());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, parseErrorResult.column().intValue());
    assertEquals(2, parseErrorResult.line().intValue());
    assertEquals(UploadOperation.ADD, getResult.uploadOperation());
    assertTrue(getResult.error().isEmpty());
    assertEquals(sourceEntityRefResult2, targetEntityRefResult);
  }
}
