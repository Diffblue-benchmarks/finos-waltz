package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityEntryDiffblueTest {
  /**
   * Test {@link ImmutableComplexityEntry#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableComplexityEntry#builder()}
   *   <li>{@link ImmutableComplexityEntry#complexityScore(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableComplexityEntry Builder.build()", "Builder Builder.complexityScore(BigDecimal)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableComplexityEntry.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.complexityScore(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#appId(long)}.
   * <p>
   * Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appId(1L));
  }

  /**
   * Test Builder {@link Builder#complexityKindId(long)}.
   * <p>
   * Method under test: {@link Builder#complexityKindId(long)}
   */
  @Test
  @DisplayName("Test Builder complexityKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.complexityKindId(long)"})
  void testBuilderComplexityKindId() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKindId(1L));
  }

  /**
   * Test Builder {@link Builder#from(ComplexityEntry)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return build appId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityEntry)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityEntry); given BigDecimal(String) with '2.3'; then return build appId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityEntry)"})
  void testBuilderFrom_givenBigDecimalWith23_thenReturnBuildAppIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();
    ComplexityEntry instance = mock(ComplexityEntry.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.complexityScore()).thenReturn(bigDecimal);
    when(instance.appId()).thenReturn(1L);
    when(instance.complexityKindId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).complexityKindId();
    verify(instance).complexityScore();
    ImmutableComplexityEntry buildResult = actualFromResult.build();
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.complexityKindId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    assertEquals(expectedComplexityScoreResult, buildResult.complexityScore());
    assertSame(bigDecimal, builderResult.build().complexityScore());
  }

  /**
   * Test Builder {@link Builder#from(ComplexityEntry)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then builder build complexityScore is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComplexityEntry)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityEntry); given 'null'; then builder build complexityScore is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComplexityEntry)"})
  void testBuilderFrom_givenNull_thenBuilderBuildComplexityScoreIsNull() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();
    ComplexityEntry instance = mock(ComplexityEntry.class);
    when(instance.complexityScore()).thenReturn(null);
    when(instance.appId()).thenReturn(1L);
    when(instance.complexityKindId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).complexityKindId();
    verify(instance).complexityScore();
    ImmutableComplexityEntry buildResult = builderResult.build();
    assertNull(buildResult.complexityScore());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.complexityKindId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#appId()}.
   * <p>
   * Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appId());
  }

  /**
   * Test Json {@link Json#complexityKindId()}.
   * <p>
   * Method under test: {@link Json#complexityKindId()}
   */
  @Test
  @DisplayName("Test Json complexityKindId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.complexityKindId()"})
  void testJsonComplexityKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complexityKindId());
  }

  /**
   * Test Json {@link Json#complexityScore()}.
   * <p>
   * Method under test: {@link Json#complexityScore()}
   */
  @Test
  @DisplayName("Test Json complexityScore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.complexityScore()"})
  void testJsonComplexityScore() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complexityScore());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComplexityScore(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComplexityScore(BigDecimal)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComplexityScore(new BigDecimal("2.3"));

    // Assert
    assertEquals(0L, actualJson.appId);
    assertEquals(0L, actualJson.complexityKindId);
    assertFalse(actualJson.appIdIsSet);
    assertFalse(actualJson.complexityKindIdIsSet);
    assertEquals(new BigDecimal("2.3"), actualJson.complexityScore);
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   * <p>
   * Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAppId(long)"})
  void testJsonSetAppId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Test Json {@link Json#setComplexityKindId(long)}.
   * <p>
   * Method under test: {@link Json#setComplexityKindId(long)}
   */
  @Test
  @DisplayName("Test Json setComplexityKindId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setComplexityKindId(long)"})
  void testJsonSetComplexityKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setComplexityKindId(1L);

    // Assert
    assertEquals(1L, json.complexityKindId);
    assertTrue(json.complexityKindIdIsSet);
  }
}
