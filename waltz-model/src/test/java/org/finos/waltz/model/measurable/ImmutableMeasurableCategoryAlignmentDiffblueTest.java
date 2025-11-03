package org.finos.waltz.model.measurable;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.measurable.ImmutableMeasurableCategoryAlignment.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableCategoryAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#addAlignments(MeasurableAlignment)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableAlignment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAlignments(MeasurableAlignment)}
   */
  @Test
  @DisplayName("Test Builder addAlignments(MeasurableAlignment) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAlignments(MeasurableAlignment)"})
  void testBuilderAddAlignmentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAlignments(new ImmutableMeasurableAlignment.Json()));
  }

  /**
   * Test Builder {@link Builder#addAlignments(MeasurableAlignment[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableAlignment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAlignments(MeasurableAlignment[])}
   */
  @Test
  @DisplayName("Test Builder addAlignments(MeasurableAlignment[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAlignments(MeasurableAlignment[])"})
  void testBuilderAddAlignmentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAlignments(new ImmutableMeasurableAlignment.Json()));
  }

  /**
   * Test Builder {@link Builder#addAllAlignments(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAlignments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAlignments(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAlignments(Iterable)"})
  void testBuilderAddAllAlignments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAlignments(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#alignments(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#alignments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder alignments(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.alignments(Iterable)"})
  void testBuilderAlignments_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.alignments(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#categoryReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#categoryReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder categoryReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.categoryReference(EntityReference)"})
  void testBuilderCategoryReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    EntityReference categoryReference = mock(EntityReference.class);

    // Act and Assert
    assertSame(builderResult, builderResult.categoryReference(categoryReference));
    assertSame(categoryReference, builderResult.build().categoryReference());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryAlignment)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableMeasurableAlignment.Json} (default constructor).</li>
   *   <li>Then return build alignments size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryAlignment); given HashSet() add Json (default constructor); then return build alignments size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryAlignment)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildAlignmentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    HashSet<MeasurableAlignment> measurableAlignmentSet = new HashSet<>();
    measurableAlignmentSet.add(new ImmutableMeasurableAlignment.Json());
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(measurableAlignmentSet);
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertEquals(1, actualFromResult.build().alignments().size());
    assertEquals(1, builderResult.build().alignments().size());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryAlignment)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build alignments Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryAlignment); given HashSet(); then return build alignments Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryAlignment)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildAlignmentsEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenReturn(new HashSet<>());
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).alignments();
    verify(instance).categoryReference();
    assertTrue(actualFromResult.build().alignments().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryAlignment)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryAlignment); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryAlignment)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    MeasurableCategoryAlignment instance = mock(MeasurableCategoryAlignment.class);
    when(instance.alignments()).thenThrow(new IllegalStateException("instance"));
    when(instance.categoryReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).alignments();
    verify(instance).categoryReference();
  }

  /**
   * Test Json {@link Json#alignments()}.
   * <p>
   * Method under test: {@link Json#alignments()}
   */
  @Test
  @DisplayName("Test Json alignments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.alignments()"})
  void testJsonAlignments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).alignments());
  }

  /**
   * Test Json {@link Json#categoryReference()}.
   * <p>
   * Method under test: {@link Json#categoryReference()}
   */
  @Test
  @DisplayName("Test Json categoryReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.categoryReference()"})
  void testJsonCategoryReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).categoryReference());
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
    assertNull(actualJson.categoryReference);
    assertTrue(actualJson.alignments.isEmpty());
  }
}
