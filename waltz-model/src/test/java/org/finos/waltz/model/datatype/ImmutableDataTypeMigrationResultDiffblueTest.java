package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeMigrationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#classificationRuleCount(long)}.
   * <p>
   * Method under test: {@link Builder#classificationRuleCount(long)}
   */
  @Test
  @DisplayName("Test Builder classificationRuleCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.classificationRuleCount(long)"})
  void testBuilderClassificationRuleCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationRuleCount(3L));
  }

  /**
   * Test Builder {@link Builder#dataTypeRemoved(boolean)}.
   * <p>
   * Method under test: {@link Builder#dataTypeRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeRemoved(boolean)"})
  void testBuilderDataTypeRemoved() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRemoved(true));
  }

  /**
   * Test Builder {@link Builder#from(DataTypeMigrationResult)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build classificationRuleCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeMigrationResult)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeMigrationResult); given 'true'; then builder build classificationRuleCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeMigrationResult)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildClassificationRuleCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();
    DataTypeMigrationResult instance = mock(DataTypeMigrationResult.class);
    when(instance.dataTypeRemoved()).thenReturn(true);
    when(instance.classificationRuleCount()).thenReturn(3L);
    when(instance.logicalFlowDataTypeCount()).thenReturn(3L);
    when(instance.physicalSpecDataTypeCount()).thenReturn(3L);
    when(instance.usageCount()).thenReturn(3L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classificationRuleCount();
    verify(instance).dataTypeRemoved();
    verify(instance).logicalFlowDataTypeCount();
    verify(instance).physicalSpecDataTypeCount();
    verify(instance).usageCount();
    ImmutableDataTypeMigrationResult buildResult = builderResult.build();
    assertEquals(3L, buildResult.classificationRuleCount());
    assertEquals(3L, buildResult.logicalFlowDataTypeCount());
    assertEquals(3L, buildResult.physicalSpecDataTypeCount());
    assertEquals(3L, buildResult.usageCount());
    assertTrue(buildResult.dataTypeRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlowDataTypeCount(long)}.
   * <p>
   * Method under test: {@link Builder#logicalFlowDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowDataTypeCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.logicalFlowDataTypeCount(long)"})
  void testBuilderLogicalFlowDataTypeCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowDataTypeCount(3L));
  }

  /**
   * Test Builder {@link Builder#physicalSpecDataTypeCount(long)}.
   * <p>
   * Method under test: {@link Builder#physicalSpecDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Builder physicalSpecDataTypeCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.physicalSpecDataTypeCount(long)"})
  void testBuilderPhysicalSpecDataTypeCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecDataTypeCount(3L));
  }

  /**
   * Test Builder {@link Builder#usageCount(long)}.
   * <p>
   * Method under test: {@link Builder#usageCount(long)}
   */
  @Test
  @DisplayName("Test Builder usageCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.usageCount(long)"})
  void testBuilderUsageCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usageCount(3L));
  }

  /**
   * Test Json {@link Json#classificationRuleCount()}.
   * <p>
   * Method under test: {@link Json#classificationRuleCount()}
   */
  @Test
  @DisplayName("Test Json classificationRuleCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.classificationRuleCount()"})
  void testJsonClassificationRuleCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).classificationRuleCount());
  }

  /**
   * Test Json {@link Json#dataTypeRemoved()}.
   * <p>
   * Method under test: {@link Json#dataTypeRemoved()}
   */
  @Test
  @DisplayName("Test Json dataTypeRemoved()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.dataTypeRemoved()"})
  void testJsonDataTypeRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeRemoved());
  }

  /**
   * Test Json {@link Json#logicalFlowDataTypeCount()}.
   * <p>
   * Method under test: {@link Json#logicalFlowDataTypeCount()}
   */
  @Test
  @DisplayName("Test Json logicalFlowDataTypeCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.logicalFlowDataTypeCount()"})
  void testJsonLogicalFlowDataTypeCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).logicalFlowDataTypeCount());
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
    assertEquals(0L, actualJson.classificationRuleCount);
    assertEquals(0L, actualJson.logicalFlowDataTypeCount);
    assertEquals(0L, actualJson.physicalSpecDataTypeCount);
    assertEquals(0L, actualJson.usageCount);
    assertFalse(actualJson.classificationRuleCountIsSet);
    assertFalse(actualJson.dataTypeRemoved);
    assertFalse(actualJson.dataTypeRemovedIsSet);
    assertFalse(actualJson.logicalFlowDataTypeCountIsSet);
    assertFalse(actualJson.physicalSpecDataTypeCountIsSet);
    assertFalse(actualJson.usageCountIsSet);
  }

  /**
   * Test Json {@link Json#physicalSpecDataTypeCount()}.
   * <p>
   * Method under test: {@link Json#physicalSpecDataTypeCount()}
   */
  @Test
  @DisplayName("Test Json physicalSpecDataTypeCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.physicalSpecDataTypeCount()"})
  void testJsonPhysicalSpecDataTypeCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).physicalSpecDataTypeCount());
  }

  /**
   * Test Json {@link Json#setClassificationRuleCount(long)}.
   * <p>
   * Method under test: {@link Json#setClassificationRuleCount(long)}
   */
  @Test
  @DisplayName("Test Json setClassificationRuleCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setClassificationRuleCount(long)"})
  void testJsonSetClassificationRuleCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setClassificationRuleCount(3L);

    // Assert
    assertEquals(3L, json.classificationRuleCount);
    assertTrue(json.classificationRuleCountIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeRemoved(boolean)}.
   * <p>
   * Method under test: {@link Json#setDataTypeRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setDataTypeRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeRemoved(boolean)"})
  void testJsonSetDataTypeRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeRemoved(true);

    // Assert
    assertTrue(json.dataTypeRemoved);
    assertTrue(json.dataTypeRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setLogicalFlowDataTypeCount(long)}.
   * <p>
   * Method under test: {@link Json#setLogicalFlowDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Json setLogicalFlowDataTypeCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setLogicalFlowDataTypeCount(long)"})
  void testJsonSetLogicalFlowDataTypeCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLogicalFlowDataTypeCount(3L);

    // Assert
    assertEquals(3L, json.logicalFlowDataTypeCount);
    assertTrue(json.logicalFlowDataTypeCountIsSet);
  }

  /**
   * Test Json {@link Json#setPhysicalSpecDataTypeCount(long)}.
   * <p>
   * Method under test: {@link Json#setPhysicalSpecDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalSpecDataTypeCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPhysicalSpecDataTypeCount(long)"})
  void testJsonSetPhysicalSpecDataTypeCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPhysicalSpecDataTypeCount(3L);

    // Assert
    assertEquals(3L, json.physicalSpecDataTypeCount);
    assertTrue(json.physicalSpecDataTypeCountIsSet);
  }

  /**
   * Test Json {@link Json#setUsageCount(long)}.
   * <p>
   * Method under test: {@link Json#setUsageCount(long)}
   */
  @Test
  @DisplayName("Test Json setUsageCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setUsageCount(long)"})
  void testJsonSetUsageCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUsageCount(3L);

    // Assert
    assertEquals(3L, json.usageCount);
    assertTrue(json.usageCountIsSet);
  }

  /**
   * Test Json {@link Json#usageCount()}.
   * <p>
   * Method under test: {@link Json#usageCount()}
   */
  @Test
  @DisplayName("Test Json usageCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.usageCount()"})
  void testJsonUsageCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).usageCount());
  }
}
