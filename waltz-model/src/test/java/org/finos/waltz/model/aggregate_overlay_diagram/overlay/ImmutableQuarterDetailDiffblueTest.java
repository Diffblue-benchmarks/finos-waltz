package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.Quarter;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableQuarterDetail.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableQuarterDetail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableQuarterDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#from(QuarterDetail)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build quarter is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(QuarterDetail)}
   */
  @Test
  @DisplayName("Test Builder from(QuarterDetail); given one; then builder build quarter is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(QuarterDetail)"})
  void testBuilderFrom_givenOne_thenBuilderBuildQuarterIsOne() {
    // Arrange
    Builder builderResult = ImmutableQuarterDetail.builder();
    QuarterDetail instance = mock(QuarterDetail.class);
    when(instance.quarter()).thenReturn(1);
    when(instance.year()).thenReturn(1);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).quarter();
    verify(instance).year();
    ImmutableQuarterDetail buildResult = builderResult.build();
    assertEquals(1, buildResult.quarter());
    assertEquals(1, buildResult.year());
    assertEquals(Quarter.Q1, buildResult.quarterName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#quarter(int)}.
   * <p>
   * Method under test: {@link Builder#quarter(int)}
   */
  @Test
  @DisplayName("Test Builder quarter(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.quarter(int)"})
  void testBuilderQuarter() {
    // Arrange
    Builder builderResult = ImmutableQuarterDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.quarter(1));
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
    Builder builderResult = ImmutableQuarterDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Test Json {@link Json#additionalQuarters()}.
   * <p>
   * Method under test: {@link Json#additionalQuarters()}
   */
  @Test
  @DisplayName("Test Json additionalQuarters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.additionalQuarters()"})
  void testJsonAdditionalQuarters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).additionalQuarters());
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
    assertEquals(0, actualJson.quarter);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.quarterIsSet);
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Test Json {@link Json#quarter()}.
   * <p>
   * Method under test: {@link Json#quarter()}
   */
  @Test
  @DisplayName("Test Json quarter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.quarter()"})
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).quarter());
  }

  /**
   * Test Json {@link Json#quarterName()}.
   * <p>
   * Method under test: {@link Json#quarterName()}
   */
  @Test
  @DisplayName("Test Json quarterName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Quarter Json.quarterName()"})
  void testJsonQuarterName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).quarterName());
  }

  /**
   * Test Json {@link Json#setQuarter(int)}.
   * <p>
   * Method under test: {@link Json#setQuarter(int)}
   */
  @Test
  @DisplayName("Test Json setQuarter(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setQuarter(int)"})
  void testJsonSetQuarter() {
    // Arrange
    Json json = new Json();

    // Act
    json.setQuarter(1);

    // Assert
    assertEquals(1, json.quarter);
    assertTrue(json.quarterIsSet);
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
