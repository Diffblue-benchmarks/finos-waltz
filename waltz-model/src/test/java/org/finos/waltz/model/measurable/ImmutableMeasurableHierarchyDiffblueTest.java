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
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchy.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchy.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableHierarchyDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllParents(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllParents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParents(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllParents(Iterable)"})
  void testBuilderAddAllParents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParents(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addParents(MeasurableHierarchyAlignment)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableHierarchyAlignment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParents(MeasurableHierarchyAlignment)}
   */
  @Test
  @DisplayName("Test Builder addParents(MeasurableHierarchyAlignment) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParents(MeasurableHierarchyAlignment)"})
  void testBuilderAddParentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new ImmutableMeasurableHierarchyAlignment.Json()));
  }

  /**
   * Test Builder {@link Builder#addParents(MeasurableHierarchyAlignment[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableHierarchyAlignment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addParents(MeasurableHierarchyAlignment[])}
   */
  @Test
  @DisplayName("Test Builder addParents(MeasurableHierarchyAlignment[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addParents(MeasurableHierarchyAlignment[])"})
  void testBuilderAddParentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new ImmutableMeasurableHierarchyAlignment.Json()));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableHierarchy)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableMeasurableHierarchyAlignment.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableHierarchy); given HashSet() add Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchy)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    HashSet<MeasurableHierarchyAlignment> measurableHierarchyAlignmentSet = new HashSet<>();
    measurableHierarchyAlignmentSet.add(new ImmutableMeasurableHierarchyAlignment.Json());
    MeasurableHierarchy instance = mock(MeasurableHierarchy.class);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.parents()).thenReturn(measurableHierarchyAlignmentSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableId();
    verify(instance).parents();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableHierarchy)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build maxDepth intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableHierarchy); given HashSet(); then return build maxDepth intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchy)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildMaxDepthIntValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();
    MeasurableHierarchy instance = mock(MeasurableHierarchy.class);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.parents()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableId();
    verify(instance).parents();
    ImmutableMeasurableHierarchy buildResult = actualFromResult.build();
    assertEquals(1, buildResult.maxDepth().intValue());
    ImmutableMeasurableHierarchy buildResult2 = builderResult.build();
    assertEquals(1, buildResult2.maxDepth().intValue());
    assertEquals(1L, buildResult.measurableId().longValue());
    assertEquals(1L, buildResult2.measurableId().longValue());
    assertTrue(buildResult.parents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#measurableId(Long)}.
   * <p>
   * Method under test: {@link Builder#measurableId(Long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableId(Long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    Builder actualMeasurableIdResult = builderResult.measurableId(1L);

    // Assert
    ImmutableMeasurableHierarchy buildResult = builderResult.build();
    assertEquals(1, buildResult.maxDepth().intValue());
    assertEquals(1L, buildResult.measurableId().longValue());
    assertSame(builderResult, actualMeasurableIdResult);
  }

  /**
   * Test Builder {@link Builder#parents(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parents(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parents(Iterable)"})
  void testBuilderParents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parents(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#maxDepth()}.
   * <p>
   * Method under test: {@link Json#maxDepth()}
   */
  @Test
  @DisplayName("Test Json maxDepth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Integer Json.maxDepth()"})
  void testJsonMaxDepth() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).maxDepth());
  }

  /**
   * Test Json {@link Json#measurableId()}.
   * <p>
   * Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableId());
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
    assertNull(actualJson.measurableId);
    assertTrue(actualJson.parents.isEmpty());
  }

  /**
   * Test Json {@link Json#parents()}.
   * <p>
   * Method under test: {@link Json#parents()}
   */
  @Test
  @DisplayName("Test Json parents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.parents()"})
  void testJsonParents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parents());
  }
}
