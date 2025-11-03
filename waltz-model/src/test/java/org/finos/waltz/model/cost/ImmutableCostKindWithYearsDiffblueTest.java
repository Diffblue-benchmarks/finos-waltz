package org.finos.waltz.model.cost;

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
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.cost.ImmutableCostKindWithYears.Builder;
import org.finos.waltz.model.cost.ImmutableCostKindWithYears.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostKindWithYearsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllYears(Iterable)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllYears(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllYears(Iterable); given two; when LinkedHashSet() add two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllYears(Iterable)"})
  void testBuilderAddAllYears_givenTwo_whenLinkedHashSetAddTwo() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(2);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllYears(elements));
  }

  /**
   * Test Builder {@link Builder#addAllYears(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllYears(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllYears(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllYears(Iterable)"})
  void testBuilderAddAllYears_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllYears(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addYears(int)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addYears(int)}
   */
  @Test
  @DisplayName("Test Builder addYears(int) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addYears(int)"})
  void testBuilderAddYearsWithElement() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addYears(2));
  }

  /**
   * Test Builder {@link Builder#addYears(int[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addYears(int[])}
   */
  @Test
  @DisplayName("Test Builder addYears(int[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addYears(int[])"})
  void testBuilderAddYearsWithElements() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addYears(2, 1, 2, 1));
  }

  /**
   * Test Builder {@link Builder#costKind(EntityCostKind)}.
   * <ul>
   *   <li>When {@link ImmutableEntityCostKind.Json} (default constructor).</li>
   *   <li>Then builder build costKind is {@link ImmutableEntityCostKind.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#costKind(EntityCostKind)}
   */
  @Test
  @DisplayName("Test Builder costKind(EntityCostKind); when Json (default constructor); then builder build costKind is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.costKind(EntityCostKind)"})
  void testBuilderCostKind_whenJson_thenBuilderBuildCostKindIsJson() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();

    // Act
    Builder actualCostKindResult = builderResult.costKind(costKind);

    // Assert
    assertSame(costKind, builderResult.build().costKind());
    assertSame(builderResult, actualCostKindResult);
  }

  /**
   * Test Builder {@link Builder#from(CostKindWithYears)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return build years size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostKindWithYears)}
   */
  @Test
  @DisplayName("Test Builder from(CostKindWithYears); given ArrayList() add two; then return build years size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostKindWithYears)"})
  void testBuilderFrom_givenArrayListAddTwo_thenReturnBuildYearsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(integerList);
    when(instance.costKind()).thenReturn(new ImmutableEntityCostKind.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    List<Integer> yearsResult = actualFromResult.build().years();
    assertEquals(1, yearsResult.size());
    List<Integer> yearsResult2 = builderResult.build().years();
    assertEquals(1, yearsResult2.size());
    assertEquals(2, yearsResult.get(0).intValue());
    assertEquals(2, yearsResult2.get(0).intValue());
  }

  /**
   * Test Builder {@link Builder#from(CostKindWithYears)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build costKind is {@link ImmutableEntityCostKind.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostKindWithYears)}
   */
  @Test
  @DisplayName("Test Builder from(CostKindWithYears); given ArrayList(); then builder build costKind is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostKindWithYears)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildCostKindIsJson() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(new ArrayList<>());
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    assertSame(json, builderResult.build().costKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CostKindWithYears)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostKindWithYears)}
   */
  @Test
  @DisplayName("Test Builder from(CostKindWithYears); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostKindWithYears)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenThrow(new IllegalStateException("instance"));
    when(instance.costKind()).thenReturn(new ImmutableEntityCostKind.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).costKind();
    verify(instance).years();
  }

  /**
   * Test Builder {@link Builder#years(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#years(Iterable)}
   */
  @Test
  @DisplayName("Test Builder years(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.years(Iterable)"})
  void testBuilderYears_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(1);

    // Act and Assert
    assertSame(builderResult, builderResult.years(elements));
  }

  /**
   * Test Builder {@link Builder#years(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#years(Iterable)}
   */
  @Test
  @DisplayName("Test Builder years(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.years(Iterable)"})
  void testBuilderYears_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.years(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#costKind()}.
   * <p>
   * Method under test: {@link Json#costKind()}
   */
  @Test
  @DisplayName("Test Json costKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityCostKind Json.costKind()"})
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).costKind());
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
    assertNull(actualJson.costKind);
    assertTrue(actualJson.years.isEmpty());
  }

  /**
   * Test Json {@link Json#years()}.
   * <p>
   * Method under test: {@link Json#years()}
   */
  @Test
  @DisplayName("Test Json years()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.years()"})
  void testJsonYears() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).years());
  }
}
