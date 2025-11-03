package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.cost.ImmutableEntityCostsSummary.Builder;
import org.finos.waltz.model.cost.ImmutableEntityCostsSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityCostsSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTopCosts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllTopCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTopCosts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTopCosts(Iterable)"})
  void testBuilderAddAllTopCosts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTopCosts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addTopCosts(EntityCost)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableEntityCost.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTopCosts(EntityCost)}
   */
  @Test
  @DisplayName("Test Builder addTopCosts(EntityCost) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTopCosts(EntityCost)"})
  void testBuilderAddTopCostsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopCosts(new ImmutableEntityCost.Json()));
  }

  /**
   * Test Builder {@link Builder#addTopCosts(EntityCost[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableEntityCost.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTopCosts(EntityCost[])}
   */
  @Test
  @DisplayName("Test Builder addTopCosts(EntityCost[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTopCosts(EntityCost[])"})
  void testBuilderAddTopCostsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopCosts(new ImmutableEntityCost.Json()));
  }

  /**
   * Test Builder {@link Builder#costKind(EntityCostKind)}.
   * <ul>
   *   <li>When {@link ImmutableEntityCostKind.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#costKind(EntityCostKind)}
   */
  @Test
  @DisplayName("Test Builder costKind(EntityCostKind); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.costKind(EntityCostKind)"})
  void testBuilderCostKind_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKind(new ImmutableEntityCostKind.Json()));
  }

  /**
   * Test Builder {@link Builder#from(EntityCostsSummary)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableEntityCost.Json} (default constructor).</li>
   *   <li>Then build costKind return {@link ImmutableEntityCostKind.Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityCostsSummary)}
   */
  @Test
  @DisplayName("Test Builder from(EntityCostsSummary); given ArrayList() add Json (default constructor); then build costKind return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityCostsSummary)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuildCostKindReturnJson() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    ArrayList<EntityCost> entityCostList = new ArrayList<>();
    ImmutableEntityCost.Json json = new ImmutableEntityCost.Json();
    entityCostList.add(json);
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(entityCostList);
    when(instance.costKind()).thenReturn(new ImmutableEntityCostKind.Json());
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    when(instance.total()).thenReturn(new BigDecimal("2.3"));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    ImmutableEntityCostsSummary buildResult = actualFromResult.build();
    EntityCostKind costKindResult = buildResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind.Json);
    List<EntityCost> topCostsResult = builderResult.build().topCosts();
    assertEquals(1, topCostsResult.size());
    assertEquals(entityCostList, buildResult.topCosts());
    assertSame(json, topCostsResult.get(0));
    assertSame(json.id, ((ImmutableEntityCostKind.Json) costKindResult).id);
  }

  /**
   * Test Builder {@link Builder#from(EntityCostsSummary)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build year is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityCostsSummary)}
   */
  @Test
  @DisplayName("Test Builder from(EntityCostsSummary); given ArrayList(); then builder build year is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityCostsSummary)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildYearIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(new ArrayList<>());
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    ImmutableEntityCostsSummary buildResult = builderResult.build();
    assertEquals(1, buildResult.year());
    assertEquals(3, buildResult.mappedCount());
    assertEquals(3, buildResult.missingCount());
    assertSame(bigDecimal, buildResult.total());
    assertSame(json, buildResult.costKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityCostsSummary)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityCostsSummary)}
   */
  @Test
  @DisplayName("Test Builder from(EntityCostsSummary); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityCostsSummary)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenThrow(new IllegalStateException("instance"));
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    when(instance.total()).thenReturn(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
  }

  /**
   * Test Builder {@link Builder#mappedCount(int)}.
   * <p>
   * Method under test: {@link Builder#mappedCount(int)}
   */
  @Test
  @DisplayName("Test Builder mappedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.mappedCount(int)"})
  void testBuilderMappedCount() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mappedCount(3));
  }

  /**
   * Test Builder {@link Builder#missingCount(int)}.
   * <p>
   * Method under test: {@link Builder#missingCount(int)}
   */
  @Test
  @DisplayName("Test Builder missingCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.missingCount(int)"})
  void testBuilderMissingCount() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.missingCount(3));
  }

  /**
   * Test Builder {@link Builder#topCosts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#topCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder topCosts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.topCosts(Iterable)"})
  void testBuilderTopCosts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.topCosts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#total(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#total(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder total(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.total(BigDecimal)"})
  void testBuilderTotal_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#year(int)}.
   * <p>
   * Method under test: {@link Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.year(int)"})
  void testBuilderYear() {
    // Arrange
    Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
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
   * Test Json {@link Json#mappedCount()}.
   * <p>
   * Method under test: {@link Json#mappedCount()}
   */
  @Test
  @DisplayName("Test Json mappedCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.mappedCount()"})
  void testJsonMappedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).mappedCount());
  }

  /**
   * Test Json {@link Json#missingCount()}.
   * <p>
   * Method under test: {@link Json#missingCount()}
   */
  @Test
  @DisplayName("Test Json missingCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.missingCount()"})
  void testJsonMissingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).missingCount());
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
    assertNull(actualJson.total);
    assertNull(actualJson.costKind);
    assertEquals(0, actualJson.mappedCount);
    assertEquals(0, actualJson.missingCount);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.mappedCountIsSet);
    assertFalse(actualJson.missingCountIsSet);
    assertFalse(actualJson.yearIsSet);
    assertTrue(actualJson.topCosts.isEmpty());
  }

  /**
   * Test Json {@link Json#setMappedCount(int)}.
   * <p>
   * Method under test: {@link Json#setMappedCount(int)}
   */
  @Test
  @DisplayName("Test Json setMappedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMappedCount(int)"})
  void testJsonSetMappedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMappedCount(3);

    // Assert
    assertEquals(3, json.mappedCount);
    assertTrue(json.mappedCountIsSet);
  }

  /**
   * Test Json {@link Json#setMissingCount(int)}.
   * <p>
   * Method under test: {@link Json#setMissingCount(int)}
   */
  @Test
  @DisplayName("Test Json setMissingCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMissingCount(int)"})
  void testJsonSetMissingCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMissingCount(3);

    // Assert
    assertEquals(3, json.missingCount);
    assertTrue(json.missingCountIsSet);
  }

  /**
   * Test Json {@link Json#setYear(int)}.
   * <p>
   * Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setYear(int)"})
  void testJsonSetYear() {
    // Arrange
    Json json = new Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Test Json {@link Json#topCosts()}.
   * <p>
   * Method under test: {@link Json#topCosts()}
   */
  @Test
  @DisplayName("Test Json topCosts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.topCosts()"})
  void testJsonTopCosts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).topCosts());
  }

  /**
   * Test Json {@link Json#total()}.
   * <p>
   * Method under test: {@link Json#total()}
   */
  @Test
  @DisplayName("Test Json total()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.total()"})
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).total());
  }

  /**
   * Test Json {@link Json#year()}.
   * <p>
   * Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).year());
  }
}
