package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetDatum.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingsWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCounts(Iterable)"})
  void testBuilderAddAllCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act
    Builder actualAddAllCountsResult = builderResult.addAllCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCountsResult);
  }

  /**
   * Test Builder {@link Builder#addCounts(AssessmentRatingCount)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingCount.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCounts(AssessmentRatingCount)}
   */
  @Test
  @DisplayName(
      "Test Builder addCounts(AssessmentRatingCount) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCounts(AssessmentRatingCount)"})
  void testBuilderAddCountsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act
    Builder actualAddCountsResult =
        builderResult.addCounts(new ImmutableAssessmentRatingCount.Json());

    // Assert
    assertSame(builderResult, actualAddCountsResult);
  }

  /**
   * Test Builder {@link Builder#addCounts(AssessmentRatingCount[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingCount.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCounts(AssessmentRatingCount[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCounts(AssessmentRatingCount[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCounts(AssessmentRatingCount[])"})
  void testBuilderAddCountsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act
    Builder actualAddCountsResult =
        builderResult.addCounts(new ImmutableAssessmentRatingCount.Json());

    // Assert
    assertSame(builderResult, actualAddCountsResult);
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
  @MethodsUnderTest({"ImmutableAssessmentRatingsWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingsWidgetDatum actualImmutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableAssessmentRatingsWidgetDatum.cellExternalId());
    assertTrue(actualImmutableAssessmentRatingsWidgetDatum.counts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder cellExternalId(String); when '42'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#counts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#counts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder counts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.counts(Iterable)"})
  void testBuilderCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act
    Builder actualCountsResult = builderResult.counts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCountsResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetDatum)} with {@code
   * AssessmentRatingsWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingsWidgetDatum) with 'AssessmentRatingsWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetDatum)"})
  void testBuilderFromWithAssessmentRatingsWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    ImmutableAssessmentRatingsWidgetDatum instance =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingsWidgetDatum actualImmutableAssessmentRatingsWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingsWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetDatum)} with {@code
   * AssessmentRatingsWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingsWidgetDatum) with 'AssessmentRatingsWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetDatum)"})
  void testBuilderFromWithAssessmentRatingsWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    Builder builderResult2 = ImmutableAssessmentRatingsWidgetDatum.builder();

    ImmutableAssessmentRatingCount.Builder countResult =
        ImmutableAssessmentRatingCount.builder().count(3);
    builderResult2.addCounts(
        countResult
            .rating(
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
    ImmutableAssessmentRatingsWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingsWidgetDatum actualImmutableAssessmentRatingsWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingsWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    ImmutableAssessmentRatingsWidgetDatum instance =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableAssessmentRatingsWidgetDatum actualImmutableAssessmentRatingsWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingsWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#copyOf(AssessmentRatingsWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingsWidgetDatum#copyOf(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingsWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.copyOf(AssessmentRatingsWidgetDatum)"
  })
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum instance =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualCopyOfResult =
        ImmutableAssessmentRatingsWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.counts().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}, and {@link
   * ImmutableAssessmentRatingsWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetDatum.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum2 =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingsWidgetDatum, immutableAssessmentRatingsWidgetDatum2);
    assertEquals(
        immutableAssessmentRatingsWidgetDatum.hashCode(),
        immutableAssessmentRatingsWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}, and {@link
   * ImmutableAssessmentRatingsWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetDatum.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingsWidgetDatum, immutableAssessmentRatingsWidgetDatum);
    int expectedHashCodeResult = immutableAssessmentRatingsWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingsWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetDatum.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    ImmutableAssessmentRatingCount.Builder countResult =
        ImmutableAssessmentRatingCount.builder().count(3);
    builderResult.addCounts(
        countResult
            .rating(
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
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingsWidgetDatum,
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetDatum.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("Cell External Id").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingsWidgetDatum,
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetDatum.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingsWidgetDatum.equals(Object)",
    "int ImmutableAssessmentRatingsWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableAssessmentRatingsWidgetDatum");
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Counts is {@link HashSet#HashSet()}.
   *   <li>Then return counts Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Counts is HashSet(); then return counts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonCountsIsHashSet_thenReturnCountsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setCounts(new HashSet<>());

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.counts().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Counts is {@code null}.
   *   <li>Then return counts Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Counts is 'null'; then return counts Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonCountsIsNull_thenReturnCountsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setCounts(null);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.counts().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableAssessmentRatingCount.Json} (default constructor).
   *   <li>Then return counts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return counts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnCountsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRatingCount> counts = new LinkedHashSet<>();
    counts.add(new ImmutableAssessmentRatingCount.Json());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setCounts(counts);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.counts().size());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return counts is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return counts is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnCountsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AssessmentRatingCount> counts = new LinkedHashSet<>();

    ImmutableAssessmentRatingCount.Builder countResult =
        ImmutableAssessmentRatingCount.builder().count(3);
    counts.add(
        countResult
            .rating(
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
    counts.add(new ImmutableAssessmentRatingCount.Json());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setCounts(counts);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult =
        ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(counts, actualFromJsonResult.counts());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#toString()}
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#cellExternalId()}
   *   <li>{@link ImmutableAssessmentRatingsWidgetDatum#counts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentRatingsWidgetDatum.cellExternalId()",
    "java.util.Set ImmutableAssessmentRatingsWidgetDatum.counts()",
    "String ImmutableAssessmentRatingsWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableAssessmentRatingsWidgetDatum.toString();
    String actualCellExternalIdResult = immutableAssessmentRatingsWidgetDatum.cellExternalId();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "AssessmentRatingsWidgetDatum{cellExternalId=42, counts=[]}", actualToStringResult);
    assertTrue(immutableAssessmentRatingsWidgetDatum.counts().isEmpty());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
  }

  /**
   * Test Json {@link Json#counts()}.
   *
   * <p>Method under test: {@link Json#counts()}
   */
  @Test
  @DisplayName("Test Json counts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.counts()"})
  void testJsonCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().counts());
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
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.counts.isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualWithCellExternalIdResult =
        immutableAssessmentRatingsWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableAssessmentRatingsWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingsWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAssessmentRatingsWidgetDatum actualWithCellExternalIdResult =
        ImmutableAssessmentRatingsWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertTrue(actualWithCellExternalIdResult.counts().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingsWidgetDatum#withCounts(AssessmentRatingCount[])} with
   * {@code AssessmentRatingCount[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingsWidgetDatum#withCounts(AssessmentRatingCount[])}
   */
  @Test
  @DisplayName("Test withCounts(AssessmentRatingCount[]) with 'AssessmentRatingCount[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingsWidgetDatum ImmutableAssessmentRatingsWidgetDatum.withCounts(AssessmentRatingCount[])"
  })
  void testWithCountsWithAssessmentRatingCount() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum immutableAssessmentRatingsWidgetDatum =
        ImmutableAssessmentRatingsWidgetDatum.builder().cellExternalId("42").build();

    ImmutableAssessmentRatingCount.Builder countResult =
        ImmutableAssessmentRatingCount.builder().count(3);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualWithCountsResult =
        immutableAssessmentRatingsWidgetDatum.withCounts(
            countResult
                .rating(
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

    // Assert
    assertEquals("42", actualWithCountsResult.cellExternalId());
    assertEquals(1, actualWithCountsResult.counts().size());
  }
}
