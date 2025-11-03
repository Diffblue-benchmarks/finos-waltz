package org.finos.waltz.model.complexity;

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
import org.finos.waltz.model.complexity.ImmutableComplexitySummary.Builder;
import org.finos.waltz.model.complexity.ImmutableComplexitySummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexitySummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTopComplexityScores(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllTopComplexityScores(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTopComplexityScores(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTopComplexityScores(Iterable)"})
  void testBuilderAddAllTopComplexityScores_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTopComplexityScores(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addTopComplexityScores(Complexity)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableComplexity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTopComplexityScores(Complexity)}
   */
  @Test
  @DisplayName("Test Builder addTopComplexityScores(Complexity) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTopComplexityScores(Complexity)"})
  void testBuilderAddTopComplexityScoresWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopComplexityScores(new ImmutableComplexity.Json()));
  }

  /**
   * Test Builder {@link Builder#addTopComplexityScores(Complexity[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableComplexity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTopComplexityScores(Complexity[])}
   */
  @Test
  @DisplayName("Test Builder addTopComplexityScores(Complexity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTopComplexityScores(Complexity[])"})
  void testBuilderAddTopComplexityScoresWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopComplexityScores(new ImmutableComplexity.Json()));
  }

  /**
   * Test Builder {@link Builder#average(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#average(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder average(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.average(BigDecimal)"})
  void testBuilderAverage_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.average(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#complexityKind(ComplexityKind)}.
   * <ul>
   *   <li>When {@link ImmutableComplexityKind.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#complexityKind(ComplexityKind)}
   */
  @Test
  @DisplayName("Test Builder complexityKind(ComplexityKind); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.complexityKind(ComplexityKind)"})
  void testBuilderComplexityKind_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind(new ImmutableComplexityKind.Json()));
  }

  /**
   * Test Builder {@link Builder#from(ComplexitySummary)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableComplexity.Json} (default constructor).</li>
   *   <li>Then build complexityKind return {@link ImmutableComplexityKind.Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexitySummary)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexitySummary); given ArrayList() add Json (default constructor); then build complexityKind return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexitySummary)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuildComplexityKindReturnJson() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    ArrayList<Complexity> complexityList = new ArrayList<>();
    ImmutableComplexity.Json json = new ImmutableComplexity.Json();
    complexityList.add(json);
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(complexityList);
    when(instance.complexityKind()).thenReturn(new ImmutableComplexityKind.Json());
    when(instance.total()).thenReturn(new BigDecimal("2.3"));
    when(instance.standardDeviation()).thenReturn(new BigDecimal("2.3"));
    when(instance.variance()).thenReturn(new BigDecimal("2.3"));
    when(instance.median()).thenReturn(new BigDecimal("2.3"));
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.average()).thenReturn(new BigDecimal("2.3"));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    ImmutableComplexitySummary buildResult = actualFromResult.build();
    ComplexityKind complexityKindResult = buildResult.complexityKind();
    assertTrue(complexityKindResult instanceof ImmutableComplexityKind.Json);
    List<Complexity> topComplexityScoresResult = builderResult.build().topComplexityScores();
    assertEquals(1, topComplexityScoresResult.size());
    assertEquals(complexityList, buildResult.topComplexityScores());
    assertSame(json, topComplexityScoresResult.get(0));
    assertSame(json.id, ((ImmutableComplexityKind.Json) complexityKindResult).id);
  }

  /**
   * Test Builder {@link Builder#from(ComplexitySummary)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build mappedCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexitySummary)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexitySummary); given ArrayList(); then builder build mappedCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexitySummary)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildMappedCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenReturn(new ArrayList<>());
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.variance()).thenReturn(bigDecimal3);
    BigDecimal bigDecimal4 = new BigDecimal("2.3");
    when(instance.median()).thenReturn(bigDecimal4);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    BigDecimal bigDecimal5 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal5);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
    ImmutableComplexitySummary buildResult = builderResult.build();
    assertEquals(3, buildResult.mappedCount());
    assertEquals(3, buildResult.missingCount());
    assertSame(bigDecimal5, buildResult.average());
    assertSame(bigDecimal4, buildResult.median());
    assertSame(bigDecimal2, buildResult.standardDeviation());
    assertSame(bigDecimal, buildResult.total());
    assertSame(bigDecimal3, buildResult.variance());
    assertSame(json, buildResult.complexityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexitySummary)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexitySummary)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexitySummary); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexitySummary)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();
    ComplexitySummary instance = mock(ComplexitySummary.class);
    when(instance.topComplexityScores()).thenThrow(new IllegalStateException("instance"));
    when(instance.total()).thenReturn(new BigDecimal("2.3"));
    when(instance.standardDeviation()).thenReturn(new BigDecimal("2.3"));
    when(instance.variance()).thenReturn(new BigDecimal("2.3"));
    when(instance.median()).thenReturn(new BigDecimal("2.3"));
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.average()).thenReturn(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).average();
    verify(instance).mappedCount();
    verify(instance).median();
    verify(instance).missingCount();
    verify(instance).standardDeviation();
    verify(instance).topComplexityScores();
    verify(instance).total();
    verify(instance).variance();
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
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mappedCount(3));
  }

  /**
   * Test Builder {@link Builder#median(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#median(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder median(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.median(BigDecimal)"})
  void testBuilderMedian_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.median(new BigDecimal("2.3")));
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
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.missingCount(3));
  }

  /**
   * Test Builder {@link Builder#standardDeviation(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#standardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder standardDeviation(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.standardDeviation(BigDecimal)"})
  void testBuilderStandardDeviation_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.standardDeviation(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#topComplexityScores(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#topComplexityScores(Iterable)}
   */
  @Test
  @DisplayName("Test Builder topComplexityScores(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.topComplexityScores(Iterable)"})
  void testBuilderTopComplexityScores_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.topComplexityScores(new ArrayList<>()));
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
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#variance(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#variance(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder variance(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.variance(BigDecimal)"})
  void testBuilderVariance_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexitySummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.variance(new BigDecimal("2.3")));
  }

  /**
   * Test Json {@link Json#average()}.
   * <p>
   * Method under test: {@link Json#average()}
   */
  @Test
  @DisplayName("Test Json average()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.average()"})
  void testJsonAverage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).average());
  }

  /**
   * Test Json {@link Json#complexityKind()}.
   * <p>
   * Method under test: {@link Json#complexityKind()}
   */
  @Test
  @DisplayName("Test Json complexityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComplexityKind Json.complexityKind()"})
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complexityKind());
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
   * Test Json {@link Json#median()}.
   * <p>
   * Method under test: {@link Json#median()}
   */
  @Test
  @DisplayName("Test Json median()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.median()"})
  void testJsonMedian() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).median());
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
    assertNull(actualJson.average);
    assertNull(actualJson.median);
    assertNull(actualJson.standardDeviation);
    assertNull(actualJson.total);
    assertNull(actualJson.variance);
    assertNull(actualJson.complexityKind);
    assertEquals(0, actualJson.mappedCount);
    assertEquals(0, actualJson.missingCount);
    assertFalse(actualJson.mappedCountIsSet);
    assertFalse(actualJson.missingCountIsSet);
    assertTrue(actualJson.topComplexityScores.isEmpty());
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
   * Test Json {@link Json#standardDeviation()}.
   * <p>
   * Method under test: {@link Json#standardDeviation()}
   */
  @Test
  @DisplayName("Test Json standardDeviation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.standardDeviation()"})
  void testJsonStandardDeviation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).standardDeviation());
  }

  /**
   * Test Json {@link Json#topComplexityScores()}.
   * <p>
   * Method under test: {@link Json#topComplexityScores()}
   */
  @Test
  @DisplayName("Test Json topComplexityScores()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.topComplexityScores()"})
  void testJsonTopComplexityScores() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).topComplexityScores());
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
   * Test Json {@link Json#variance()}.
   * <p>
   * Method under test: {@link Json#variance()}
   */
  @Test
  @DisplayName("Test Json variance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.variance()"})
  void testJsonVariance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).variance());
  }
}
