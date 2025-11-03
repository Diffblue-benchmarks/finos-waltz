package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingsWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCounts(Iterable)"})
  void testBuilderAddAllCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addCounts(AssessmentRatingCount)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingCount.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCounts(AssessmentRatingCount)}
   */
  @Test
  @DisplayName("Test Builder addCounts(AssessmentRatingCount) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCounts(AssessmentRatingCount)"})
  void testBuilderAddCountsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCounts(new ImmutableAssessmentRatingCount.Json()));
  }

  /**
   * Test Builder {@link Builder#addCounts(AssessmentRatingCount[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRatingCount.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCounts(AssessmentRatingCount[])}
   */
  @Test
  @DisplayName("Test Builder addCounts(AssessmentRatingCount[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCounts(AssessmentRatingCount[])"})
  void testBuilderAddCountsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCounts(new ImmutableAssessmentRatingCount.Json()));
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId() {
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#counts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder counts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.counts(Iterable)"})
  void testBuilderCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.counts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetDatum)} with {@code AssessmentRatingsWidgetDatum}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingsWidgetDatum) with 'AssessmentRatingsWidgetDatum'; given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetDatum)"})
  void testBuilderFromWithAssessmentRatingsWidgetDatum_givenHashSet() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetDatum)} with {@code AssessmentRatingsWidgetDatum}.
   * <ul>
   *   <li>Then builder build counts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingsWidgetDatum) with 'AssessmentRatingsWidgetDatum'; then builder build counts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetDatum)"})
  void testBuilderFromWithAssessmentRatingsWidgetDatum_thenBuilderBuildCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    HashSet<AssessmentRatingCount> assessmentRatingCountSet = new HashSet<>();
    assessmentRatingCountSet.add(new ImmutableAssessmentRatingCount.Json());
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(assessmentRatingCountSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    ImmutableAssessmentRatingsWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.counts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingsWidgetDatum)} with {@code AssessmentRatingsWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingsWidgetDatum) with 'AssessmentRatingsWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingsWidgetDatum)"})
  void testBuilderFromWithAssessmentRatingsWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).counts();
    verify(instance).cellExternalId();
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
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
   * Test Json {@link Json#cellExternalId()}.
   * <p>
   * Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellExternalId());
  }

  /**
   * Test Json {@link Json#counts()}.
   * <p>
   * Method under test: {@link Json#counts()}
   */
  @Test
  @DisplayName("Test Json counts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.counts()"})
  void testJsonCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).counts());
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
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.counts.isEmpty());
  }
}
