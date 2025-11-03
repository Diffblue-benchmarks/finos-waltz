package org.finos.waltz.model.data_flow_decorator;

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
import org.finos.waltz.model.data_flow_decorator.ImmutableLogicalFlowDecoratorStat.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableLogicalFlowDecoratorStat.Json;
import org.finos.waltz.model.logical_flow.LogicalFlowMeasures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowDecoratorStatDiffblueTest {
  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   * <p>
   * Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowDecoratorStat)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build dataTypeId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowDecoratorStat)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowDecoratorStat); given three; then builder build dataTypeId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowDecoratorStat)"})
  void testBuilderFrom_givenThree_thenBuilderBuildDataTypeIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();
    LogicalFlowDecoratorStat instance = mock(LogicalFlowDecoratorStat.class);
    when(instance.totalCount()).thenReturn(3);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.logicalFlowMeasures()).thenReturn(mock(LogicalFlowMeasures.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).logicalFlowMeasures();
    verify(instance).totalCount();
    ImmutableLogicalFlowDecoratorStat buildResult = builderResult.build();
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(3, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowDecoratorStat)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowDecoratorStat)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowDecoratorStat); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowDecoratorStat)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();
    LogicalFlowDecoratorStat instance = mock(LogicalFlowDecoratorStat.class);
    when(instance.totalCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.logicalFlowMeasures()).thenReturn(mock(LogicalFlowMeasures.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).logicalFlowMeasures();
    verify(instance).totalCount();
  }

  /**
   * Test Builder {@link Builder#logicalFlowMeasures(LogicalFlowMeasures)}.
   * <ul>
   *   <li>When {@link LogicalFlowMeasures}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#logicalFlowMeasures(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowMeasures(LogicalFlowMeasures); when LogicalFlowMeasures; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlowMeasures(LogicalFlowMeasures)"})
  void testBuilderLogicalFlowMeasures_whenLogicalFlowMeasures_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowMeasures(mock(LogicalFlowMeasures.class)));
  }

  /**
   * Test Builder {@link Builder#totalCount(int)}.
   * <p>
   * Method under test: {@link Builder#totalCount(int)}
   */
  @Test
  @DisplayName("Test Builder totalCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.totalCount(int)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3));
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLogicalFlowMeasures(LogicalFlowMeasures)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLogicalFlowMeasures(LogicalFlowMeasures)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLogicalFlowMeasures(null);

    // Assert
    assertNull(actualJson.logicalFlowMeasures);
    assertEquals(0, actualJson.totalCount);
    assertEquals(0L, actualJson.dataTypeId);
    assertFalse(actualJson.dataTypeIdIsSet);
    assertFalse(actualJson.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#logicalFlowMeasures()}.
   * <p>
   * Method under test: {@link Json#logicalFlowMeasures()}
   */
  @Test
  @DisplayName("Test Json logicalFlowMeasures()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlowMeasures Json.logicalFlowMeasures()"})
  void testJsonLogicalFlowMeasures() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowMeasures());
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   * <p>
   * Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeId(long)"})
  void testJsonSetDataTypeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#setTotalCount(int)}.
   * <p>
   * Method under test: {@link Json#setTotalCount(int)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setTotalCount(int)"})
  void testJsonSetTotalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTotalCount(3);

    // Assert
    assertEquals(3, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#totalCount()}.
   * <p>
   * Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalCount());
  }
}
