package org.finos.waltz.model.measurable;

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
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryAlignmentDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#addAlignments(MeasurableAlignment)}
   */
  @Test
  void testBuilderAddAlignments() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAlignments(new ImmutableMeasurableAlignment.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#addAlignments(MeasurableAlignment[])}
   */
  @Test
  void testBuilderAddAlignments2() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAlignments(new ImmutableMeasurableAlignment.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#addAllAlignments(Iterable)}
   */
  @Test
  void testBuilderAddAllAlignments() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAlignments(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#alignments(Iterable)}
   */
  @Test
  void testBuilderAlignments() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.alignments(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#categoryReference(EntityReference)}
   */
  @Test
  void testBuilderCategoryReference() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    EntityReference categoryReference = mock(EntityReference.class);

    // Act and Assert
    assertSame(builderResult, builderResult.categoryReference(categoryReference));
    assertSame(categoryReference, builderResult.build().categoryReference());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(new HashSet<>());
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableCategoryAlignment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    HashSet<MeasurableAlignment> measurableAlignmentSet = new HashSet<>();
    measurableAlignmentSet.add(new ImmutableMeasurableAlignment.Json());
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(measurableAlignmentSet);
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableCategoryAlignment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertEquals(1, builderResult.build().alignments().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenThrow(new IllegalStateException("instance"));
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).alignments();
    verify(instance).categoryReference();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment#copyOf(MeasurableCategoryAlignment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(new HashSet<>());
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableCategoryAlignment actualCopyOfResult = ImmutableMeasurableCategoryAlignment.copyOf(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertTrue(actualCopyOfResult.alignments().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment#copyOf(MeasurableCategoryAlignment)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<MeasurableAlignment> measurableAlignmentSet = new HashSet<>();
    measurableAlignmentSet.add(new ImmutableMeasurableAlignment.Json());
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(measurableAlignmentSet);
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableCategoryAlignment actualCopyOfResult = ImmutableMeasurableCategoryAlignment.copyOf(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertEquals(1, actualCopyOfResult.alignments().size());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment#copyOf(MeasurableCategoryAlignment)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<MeasurableAlignment> measurableAlignmentSet = new HashSet<>();
    measurableAlignmentSet.add(new ImmutableMeasurableAlignment.Json());
    measurableAlignmentSet.add(new ImmutableMeasurableAlignment.Json());
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(measurableAlignmentSet);
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableCategoryAlignment actualCopyOfResult = ImmutableMeasurableCategoryAlignment.copyOf(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertEquals(measurableAlignmentSet, actualCopyOfResult.alignments());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment#fromJson(ImmutableMeasurableCategoryAlignment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableCategoryAlignment.Json json = new ImmutableMeasurableCategoryAlignment.Json();
    json.setCategoryReference(mock(EntityReference.class));

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult = ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    Set<MeasurableAlignment> alignmentsResult = actualFromJsonResult.alignments();
    assertTrue(alignmentsResult.isEmpty());
    assertSame(json.alignments, alignmentsResult);
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment#fromJson(ImmutableMeasurableCategoryAlignment.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<MeasurableAlignment> alignments = new LinkedHashSet<>();
    alignments.add(new ImmutableMeasurableAlignment.Json());

    ImmutableMeasurableCategoryAlignment.Json json = new ImmutableMeasurableCategoryAlignment.Json();
    json.setCategoryReference(mock(EntityReference.class));
    json.setAlignments(alignments);

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult = ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.alignments().size());
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment#fromJson(ImmutableMeasurableCategoryAlignment.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<MeasurableAlignment> alignments = new LinkedHashSet<>();
    alignments.add(new ImmutableMeasurableAlignment.Json());
    alignments.add(new ImmutableMeasurableAlignment.Json());

    ImmutableMeasurableCategoryAlignment.Json json = new ImmutableMeasurableCategoryAlignment.Json();
    json.setCategoryReference(mock(EntityReference.class));
    json.setAlignments(alignments);

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult = ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    assertEquals(alignments, actualFromJsonResult.alignments());
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Json#alignments()}
   */
  @Test
  void testJsonAlignments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCategoryAlignment.Json()).alignments());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryAlignment.Json#categoryReference()}
   */
  @Test
  void testJsonCategoryReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCategoryAlignment.Json()).categoryReference());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableCategoryAlignment.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableCategoryAlignment.Json actualJson = new ImmutableMeasurableCategoryAlignment.Json();

    // Assert
    assertNull(actualJson.categoryReference);
    assertTrue(actualJson.alignments.isEmpty());
  }
}
