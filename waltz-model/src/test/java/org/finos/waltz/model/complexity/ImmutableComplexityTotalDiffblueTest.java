package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.complexity.ImmutableComplexityTotal.Builder;
import org.finos.waltz.model.complexity.ImmutableComplexityTotal.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityTotalDiffblueTest {
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
    Builder builderResult = ImmutableComplexityTotal.builder();

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
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind(new ImmutableComplexityKind.Json()));
  }

  /**
   * Test Builder {@link Builder#from(ComplexityTotal)}.
   * <ul>
   *   <li>Then builder build average is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityTotal)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityTotal); then builder build average is BigDecimal(String) with '2.3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityTotal)"})
  void testBuilderFrom_thenBuilderBuildAverageIsBigDecimalWith23() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();
    ComplexityTotal instance = mock(ComplexityTotal.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.standardDeviation()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.average()).thenReturn(bigDecimal2);
    BigDecimal bigDecimal3 = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal3);
    ImmutableComplexityKind.Json json = new ImmutableComplexityKind.Json();
    when(instance.complexityKind()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).standardDeviation();
    verify(instance).total();
    ImmutableComplexityTotal buildResult = builderResult.build();
    assertSame(bigDecimal2, buildResult.average());
    assertSame(bigDecimal, buildResult.standardDeviation());
    assertSame(bigDecimal3, buildResult.total());
    assertSame(json, buildResult.complexityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityTotal)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityTotal)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityTotal); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityTotal)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();
    ComplexityTotal instance = mock(ComplexityTotal.class);
    when(instance.standardDeviation()).thenThrow(new IllegalStateException("instance"));
    when(instance.average()).thenReturn(new BigDecimal("2.3"));
    when(instance.total()).thenReturn(new BigDecimal("2.3"));
    when(instance.complexityKind()).thenReturn(new ImmutableComplexityKind.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).average();
    verify(instance).complexityKind();
    verify(instance).standardDeviation();
    verify(instance).total();
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
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.standardDeviation(new BigDecimal("2.3")));
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
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAverage(BigDecimal)}
   *   <li>{@link Json#setComplexityKind(ComplexityKind)}
   *   <li>{@link Json#setStandardDeviation(BigDecimal)}
   *   <li>{@link Json#setTotal(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAverage(BigDecimal)",
      "void Json.setComplexityKind(ComplexityKind)", "void Json.setStandardDeviation(BigDecimal)",
      "void Json.setTotal(BigDecimal)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAverage(new BigDecimal("2.3"));
    actualJson.setComplexityKind(new ImmutableComplexityKind.Json());
    actualJson.setStandardDeviation(new BigDecimal("2.3"));
    actualJson.setTotal(new BigDecimal("2.3"));

    // Assert
    assertFalse(((ImmutableComplexityKind.Json) actualJson.complexityKind).externalId.isPresent());
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
}
