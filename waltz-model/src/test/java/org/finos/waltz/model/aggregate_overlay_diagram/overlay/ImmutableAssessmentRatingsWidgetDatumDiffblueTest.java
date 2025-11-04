package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingsWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#addAllCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllCounts() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#addCounts(AssessmentRatingCount)}
   */
  @Test
  void testBuilderAddCounts() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCounts(new ImmutableAssessmentRatingCount.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#addCounts(AssessmentRatingCount)}
   */
  @Test
  void testBuilderAddCounts2() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    ImmutableAssessmentRatingCount.Json element = new ImmutableAssessmentRatingCount.Json();
    element.setRating(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addCounts(element));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#addCounts(AssessmentRatingCount[])}
   */
  @Test
  void testBuilderAddCounts3() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCounts(new ImmutableAssessmentRatingCount.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#addCounts(AssessmentRatingCount[])}
   */
  @Test
  void testBuilderAddCounts4() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    ImmutableAssessmentRatingCount.Json json = new ImmutableAssessmentRatingCount.Json();
    json.setRating(mock(RatingSchemeItem.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addCounts(json));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act
    ImmutableAssessmentRatingsWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId2() {
    // Arrange
    ImmutableAssessmentRatingCount.Json element = new ImmutableAssessmentRatingCount.Json();
    element.setRating(mock(RatingSchemeItem.class));
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    builderResult.addCounts(element);

    // Act
    ImmutableAssessmentRatingsWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableAssessmentRatingsWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.counts().size());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#counts(Iterable)}
   */
  @Test
  void testBuilderCounts() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.counts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingsWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).counts();
    verify(instance).cellExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#from(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();

    HashSet<AssessmentRatingCount> assessmentRatingCountSet = new HashSet<>();
    assessmentRatingCountSet.add(new ImmutableAssessmentRatingCount.Json());
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(assessmentRatingCountSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingsWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    ImmutableAssessmentRatingsWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.counts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Builder builderResult = ImmutableAssessmentRatingsWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingsWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum#copyOf(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualCopyOfResult = ImmutableAssessmentRatingsWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.counts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum#copyOf(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AssessmentRatingCount> assessmentRatingCountSet = new HashSet<>();
    assessmentRatingCountSet.add(new ImmutableAssessmentRatingCount.Json());
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(assessmentRatingCountSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualCopyOfResult = ImmutableAssessmentRatingsWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(1, actualCopyOfResult.counts().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum#copyOf(AssessmentRatingsWidgetDatum)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AssessmentRatingCount> assessmentRatingCountSet = new HashSet<>();
    assessmentRatingCountSet.add(new ImmutableAssessmentRatingCount.Json());
    assessmentRatingCountSet.add(new ImmutableAssessmentRatingCount.Json());
    AssessmentRatingsWidgetDatum instance = mock(AssessmentRatingsWidgetDatum.class);
    when(instance.counts()).thenReturn(assessmentRatingCountSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualCopyOfResult = ImmutableAssessmentRatingsWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).counts();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(assessmentRatingCountSet, actualCopyOfResult.counts());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(ImmutableAssessmentRatingsWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingsWidgetDatum.Json json = new ImmutableAssessmentRatingsWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setCounts(null);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult = ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.counts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(ImmutableAssessmentRatingsWidgetDatum.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AssessmentRatingCount> counts = new LinkedHashSet<>();
    counts.add(new ImmutableAssessmentRatingCount.Json());

    ImmutableAssessmentRatingsWidgetDatum.Json json = new ImmutableAssessmentRatingsWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setCounts(counts);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult = ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.counts().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum#fromJson(ImmutableAssessmentRatingsWidgetDatum.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AssessmentRatingCount> counts = new LinkedHashSet<>();
    counts.add(new ImmutableAssessmentRatingCount.Json());
    counts.add(new ImmutableAssessmentRatingCount.Json());

    ImmutableAssessmentRatingsWidgetDatum.Json json = new ImmutableAssessmentRatingsWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setCounts(counts);

    // Act
    ImmutableAssessmentRatingsWidgetDatum actualFromJsonResult = ImmutableAssessmentRatingsWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(counts, actualFromJsonResult.counts());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingsWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingsWidgetDatum.Json#counts()}
   */
  @Test
  void testJsonCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingsWidgetDatum.Json()).counts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingsWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingsWidgetDatum.Json actualJson = new ImmutableAssessmentRatingsWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.counts.isEmpty());
  }
}
