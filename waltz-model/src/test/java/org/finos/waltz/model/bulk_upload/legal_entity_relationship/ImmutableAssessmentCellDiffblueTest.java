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
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentCellDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act
    Builder actualAddAllRatingsResult = builderResult.addAllRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentCellRating)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentCellRating.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatings(AssessmentCellRating)}
   */
  @Test
  @DisplayName(
      "Test Builder addRatings(AssessmentCellRating) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentCellRating)"})
  void testBuilderAddRatingsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act
    Builder actualAddRatingsResult =
        builderResult.addRatings(new ImmutableAssessmentCellRating.Json());

    // Assert
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(AssessmentCellRating[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentCellRating.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatings(AssessmentCellRating[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRatings(AssessmentCellRating[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(AssessmentCellRating[])"})
  void testBuilderAddRatingsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act
    Builder actualAddRatingsResult =
        builderResult.addRatings(new ImmutableAssessmentCellRating.Json());

    // Assert
    assertSame(builderResult, actualAddRatingsResult);
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
  @MethodsUnderTest({"ImmutableAssessmentCell Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentCell actualImmutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    // Assert
    assertEquals("Input String", actualImmutableAssessmentCell.inputString());
    assertEquals(1, actualImmutableAssessmentCell.columnId());
    assertTrue(actualImmutableAssessmentCell.ratings().isEmpty());
    assertTrue(actualImmutableAssessmentCell.statuses().isEmpty());
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
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act
    Builder actualColumnIdResult = builderResult.columnId(1);

    // Assert
    assertSame(builderResult, actualColumnIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCell)}.
   *
   * <ul>
   *   <li>Then builder build is builder columnId one inputString {@code Input String} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentCell); then builder build is builder columnId one inputString 'Input String' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentCell)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderColumnIdOneInputStringInputStringBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    Builder builderResult2 = ImmutableAssessmentCell.builder();

    ImmutableAssessmentCellRating.Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
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
    builderResult2.addRatings(
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build());
    ImmutableAssessmentCell instance =
        builderResult2.columnId(1).inputString("Input String").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentCell actualImmutableAssessmentCell = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentCell);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentCell)}.
   *
   * <ul>
   *   <li>Then return build is builder columnId one inputString {@code Input String} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentCell); then return build is builder columnId one inputString 'Input String' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentCell)"})
  void testBuilderFrom_thenReturnBuildIsBuilderColumnIdOneInputStringInputStringBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();
    ImmutableAssessmentCell instance =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    // Act and Assert
    ImmutableAssessmentCell actualImmutableAssessmentCell = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAssessmentCell);
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
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act
    Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    // Act
    Builder actualRatingsResult = builderResult.ratings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingsResult);
  }

  /**
   * Test {@link ImmutableAssessmentCell#copyOf(AssessmentCell)}.
   *
   * <ul>
   *   <li>Then return {@code Input String}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#copyOf(AssessmentCell)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentCell); then return 'Input String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.copyOf(AssessmentCell)"})
  void testCopyOf_thenReturnInputString() {
    // Arrange
    ImmutableAssessmentCell instance =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    // Act
    ImmutableAssessmentCell actualCopyOfResult = ImmutableAssessmentCell.copyOf(instance);

    // Assert
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertTrue(actualCopyOfResult.ratings().isEmpty());
    assertTrue(actualCopyOfResult.statuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}, and {@link
   * ImmutableAssessmentCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentCell#equals(Object)}
   *   <li>{@link ImmutableAssessmentCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();
    ImmutableAssessmentCell immutableAssessmentCell2 =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    // Act and Assert
    assertEquals(immutableAssessmentCell, immutableAssessmentCell2);
    assertEquals(immutableAssessmentCell.hashCode(), immutableAssessmentCell2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}, and {@link
   * ImmutableAssessmentCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentCell#equals(Object)}
   *   <li>{@link ImmutableAssessmentCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    // Act and Assert
    assertEquals(immutableAssessmentCell, immutableAssessmentCell);
    int expectedHashCodeResult = immutableAssessmentCell.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentCell.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    ImmutableAssessmentCellRating.Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
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
    builderResult.addRatings(
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build());
    ImmutableAssessmentCell immutableAssessmentCell =
        builderResult.columnId(1).inputString("Input String").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCell,
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build());
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(2).inputString("Input String").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCell,
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build());
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("columnId").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentCell,
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build());
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentCell.equals(Object)",
    "int ImmutableAssessmentCell.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build(),
        "Different type to ImmutableAssessmentCell");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentCell#toString()}
   *   <li>{@link ImmutableAssessmentCell#columnId()}
   *   <li>{@link ImmutableAssessmentCell#inputString()}
   *   <li>{@link ImmutableAssessmentCell#ratings()}
   *   <li>{@link ImmutableAssessmentCell#statuses()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableAssessmentCell.columnId()",
    "String ImmutableAssessmentCell.inputString()",
    "Set ImmutableAssessmentCell.ratings()",
    "Set ImmutableAssessmentCell.statuses()",
    "String ImmutableAssessmentCell.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    // Act
    String actualToStringResult = immutableAssessmentCell.toString();
    int actualColumnIdResult = immutableAssessmentCell.columnId();
    String actualInputStringResult = immutableAssessmentCell.inputString();
    Set<AssessmentCellRating> actualRatingsResult = immutableAssessmentCell.ratings();
    Set<ResolutionStatus> actualStatusesResult = immutableAssessmentCell.statuses();

    // Assert
    assertEquals(
        "AssessmentCell{inputString=Input String, columnId=1, ratings=[], statuses=[]}",
        actualToStringResult);
    assertEquals("Input String", actualInputStringResult);
    assertEquals(1, actualColumnIdResult);
    assertTrue(actualRatingsResult.isEmpty());
    assertTrue(actualStatusesResult.isEmpty());
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
    assertEquals(0, actualJson.columnId);
    assertFalse(actualJson.columnIdIsSet);
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Test Json {@link Json#ratings()}.
   *
   * <p>Method under test: {@link Json#ratings()}
   */
  @Test
  @DisplayName("Test Json ratings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratings()"})
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratings());
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
   * Test Json {@link Json#statuses()}.
   *
   * <p>Method under test: {@link Json#statuses()}
   */
  @Test
  @DisplayName("Test Json statuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.statuses()"})
  void testJsonStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().statuses());
  }

  /**
   * Test {@link ImmutableAssessmentCell#withColumnId(int)}.
   *
   * <ul>
   *   <li>Then return builder columnId forty-two inputString {@code Input String} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withColumnId(int)}
   */
  @Test
  @DisplayName(
      "Test withColumnId(int); then return builder columnId forty-two inputString 'Input String' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.withColumnId(int)"})
  void testWithColumnId_thenReturnBuilderColumnIdFortyTwoInputStringInputStringBuild() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(42).inputString("Input String").build();

    // Act
    ImmutableAssessmentCell actualWithColumnIdResult = immutableAssessmentCell.withColumnId(42);

    // Assert
    assertSame(immutableAssessmentCell, actualWithColumnIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentCell#withColumnId(int)}.
   *
   * <ul>
   *   <li>Then return ratings Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withColumnId(int)}
   */
  @Test
  @DisplayName("Test withColumnId(int); then return ratings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.withColumnId(int)"})
  void testWithColumnId_thenReturnRatingsEmpty() {
    // Arrange and Act
    ImmutableAssessmentCell actualWithColumnIdResult =
        ImmutableAssessmentCell.builder()
            .columnId(1)
            .inputString("Input String")
            .build()
            .withColumnId(42);

    // Assert
    assertEquals("Input String", actualWithColumnIdResult.inputString());
    assertEquals(42, actualWithColumnIdResult.columnId());
    assertTrue(actualWithColumnIdResult.ratings().isEmpty());
    assertTrue(actualWithColumnIdResult.statuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCell#withColumnId(int)}.
   *
   * <ul>
   *   <li>Then return ratings size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withColumnId(int)}
   */
  @Test
  @DisplayName("Test withColumnId(int); then return ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.withColumnId(int)"})
  void testWithColumnId_thenReturnRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    ImmutableAssessmentCellRating.Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
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
    builderResult.addRatings(
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build());

    // Act
    ImmutableAssessmentCell actualWithColumnIdResult =
        builderResult.columnId(1).inputString("Input String").build().withColumnId(42);

    // Assert
    assertEquals("Input String", actualWithColumnIdResult.inputString());
    assertEquals(1, actualWithColumnIdResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualWithColumnIdResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(42, actualWithColumnIdResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link ImmutableAssessmentCell#withInputString(String)}.
   *
   * <ul>
   *   <li>Then return builder columnId one inputString {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withInputString(String)}
   */
  @Test
  @DisplayName(
      "Test withInputString(String); then return builder columnId one inputString '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.withInputString(String)"})
  void testWithInputString_thenReturnBuilderColumnIdOneInputString42Build() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("42").build();

    // Act
    ImmutableAssessmentCell actualWithInputStringResult =
        immutableAssessmentCell.withInputString("42");

    // Assert
    assertSame(immutableAssessmentCell, actualWithInputStringResult);
  }

  /**
   * Test {@link ImmutableAssessmentCell#withInputString(String)}.
   *
   * <ul>
   *   <li>Then return ratings Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then return ratings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.withInputString(String)"})
  void testWithInputString_thenReturnRatingsEmpty() {
    // Arrange and Act
    ImmutableAssessmentCell actualWithInputStringResult =
        ImmutableAssessmentCell.builder()
            .columnId(1)
            .inputString("Input String")
            .build()
            .withInputString("42");

    // Assert
    assertEquals("42", actualWithInputStringResult.inputString());
    assertEquals(1, actualWithInputStringResult.columnId());
    assertTrue(actualWithInputStringResult.ratings().isEmpty());
    assertTrue(actualWithInputStringResult.statuses().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentCell#withInputString(String)}.
   *
   * <ul>
   *   <li>Then return ratings size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then return ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentCell ImmutableAssessmentCell.withInputString(String)"})
  void testWithInputString_thenReturnRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentCell.builder();

    ImmutableAssessmentCellRating.Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
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
    builderResult.addRatings(
        commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build());

    // Act
    ImmutableAssessmentCell actualWithInputStringResult =
        builderResult.columnId(1).inputString("Input String").build().withInputString("42");

    // Assert
    assertEquals("42", actualWithInputStringResult.inputString());
    assertEquals(1, actualWithInputStringResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualWithInputStringResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualWithInputStringResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Test {@link ImmutableAssessmentCell#withRatings(AssessmentCellRating[])} with {@code
   * AssessmentCellRating[]}.
   *
   * <p>Method under test: {@link ImmutableAssessmentCell#withRatings(AssessmentCellRating[])}
   */
  @Test
  @DisplayName("Test withRatings(AssessmentCellRating[]) with 'AssessmentCellRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentCell ImmutableAssessmentCell.withRatings(AssessmentCellRating[])"
  })
  void testWithRatingsWithAssessmentCellRating() {
    // Arrange
    ImmutableAssessmentCell immutableAssessmentCell =
        ImmutableAssessmentCell.builder().columnId(1).inputString("Input String").build();

    ImmutableAssessmentCellRating.Builder commentResult =
        ImmutableAssessmentCellRating.builder().comment(LegalEntityBulkUploadFixedColumns.COMMENT);
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
    ImmutableAssessmentCell actualWithRatingsResult =
        immutableAssessmentCell.withRatings(
            commentResult.resolvedRating(resolvedRating).status(ResolutionStatus.NEW).build());

    // Assert
    assertEquals("Input String", actualWithRatingsResult.inputString());
    assertEquals(1, actualWithRatingsResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualWithRatingsResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualWithRatingsResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }
}
