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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.measurable.ImmutableMeasurableAlignment.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplicationIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addApplicationIds(long)}
   */
  @Test
  @DisplayName("Test Builder addApplicationIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplicationIds(long)"})
  void testBuilderAddApplicationIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationIds(1L));
  }

  /**
   * Test Builder {@link Builder#addApplicationIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addApplicationIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addApplicationIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplicationIds(long[])"})
  void testBuilderAddApplicationIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.applicationIds(elements));
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableAlignment)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then return build applicationIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableAlignment); given HashSet() add minus two; then return build applicationIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableAlignment)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenReturnBuildApplicationIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(resultLongSet);
    when(instance.measurable()).thenReturn(new ImmutableMeasurable.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    Set<Long> applicationIdsResult = actualFromResult.build().applicationIds();
    assertEquals(1, applicationIdsResult.size());
    Set<Long> applicationIdsResult2 = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult2.size());
    assertTrue(applicationIdsResult.contains(-2L));
    assertTrue(applicationIdsResult2.contains(-2L));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableAlignment)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build measurable is {@link ImmutableMeasurable.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableAlignment); given HashSet(); then builder build measurable is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableAlignment)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildMeasurableIsJson() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(new HashSet<>());
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();
    when(instance.measurable()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    assertSame(json, builderResult.build().measurable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableAlignment)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableAlignment); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableAlignment)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurable()).thenReturn(new ImmutableMeasurable.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationIds();
    verify(instance).measurable();
  }

  /**
   * Test Builder {@link Builder#measurable(Measurable)}.
   * <ul>
   *   <li>When {@link ImmutableMeasurable.Json} (default constructor).</li>
   *   <li>Then builder build measurable is {@link ImmutableMeasurable.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurable(Measurable)}
   */
  @Test
  @DisplayName("Test Builder measurable(Measurable); when Json (default constructor); then builder build measurable is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurable(Measurable)"})
  void testBuilderMeasurable_whenJson_thenBuilderBuildMeasurableIsJson() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();

    // Act
    Builder actualMeasurableResult = builderResult.measurable(measurable);

    // Assert
    assertSame(measurable, builderResult.build().measurable());
    assertSame(builderResult, actualMeasurableResult);
  }

  /**
   * Test Json {@link Json#applicationIds()}.
   * <p>
   * Method under test: {@link Json#applicationIds()}
   */
  @Test
  @DisplayName("Test Json applicationIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.applicationIds()"})
  void testJsonApplicationIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationIds());
  }

  /**
   * Test Json {@link Json#measurable()}.
   * <p>
   * Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Measurable Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurable());
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
    assertNull(actualJson.measurable);
    assertTrue(actualJson.applicationIds.isEmpty());
  }
}
