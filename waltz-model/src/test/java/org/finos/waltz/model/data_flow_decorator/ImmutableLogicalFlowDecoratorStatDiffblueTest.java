package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.data_flow_decorator.ImmutableLogicalFlowDecoratorStat.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableLogicalFlowDecoratorStat.Json;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowMeasures;
import org.finos.waltz.model.logical_flow.LogicalFlowMeasures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowDecoratorStatDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowDecoratorStat Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowMeasures logicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();
    ImmutableLogicalFlowDecoratorStat actualImmutableLogicalFlowDecoratorStat =
        actualDataTypeIdResult.logicalFlowMeasures(logicalFlowMeasures).totalCount(3).build();

    // Assert
    assertEquals(1L, actualImmutableLogicalFlowDecoratorStat.dataTypeId());
    assertEquals(3, actualImmutableLogicalFlowDecoratorStat.totalCount());
    assertSame(logicalFlowMeasures, actualImmutableLogicalFlowDecoratorStat.logicalFlowMeasures());
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   *
   * <p>Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act
    Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowDecoratorStat)}.
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowDecoratorStat)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowDecoratorStat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowDecoratorStat)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat instance =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowDecoratorStat actualImmutableLogicalFlowDecoratorStat =
        builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowDecoratorStat);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlowMeasures(LogicalFlowMeasures)}.
   *
   * <ul>
   *   <li>When {@link LogicalFlowMeasures}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#logicalFlowMeasures(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName(
      "Test Builder logicalFlowMeasures(LogicalFlowMeasures); when LogicalFlowMeasures; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlowMeasures(LogicalFlowMeasures)"})
  void testBuilderLogicalFlowMeasures_whenLogicalFlowMeasures_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act
    Builder actualLogicalFlowMeasuresResult =
        builderResult.logicalFlowMeasures(mock(LogicalFlowMeasures.class));

    // Assert
    assertSame(builderResult, actualLogicalFlowMeasuresResult);
  }

  /**
   * Test Builder {@link Builder#totalCount(int)}.
   *
   * <p>Method under test: {@link Builder#totalCount(int)}
   */
  @Test
  @DisplayName("Test Builder totalCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.totalCount(int)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act
    Builder actualTotalCountResult = builderResult.totalCount(3);

    // Assert
    assertSame(builderResult, actualTotalCountResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#copyOf(LogicalFlowDecoratorStat)}.
   *
   * <ul>
   *   <li>Then logicalFlowMeasures return {@link ImmutableLogicalFlowMeasures}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowDecoratorStat#copyOf(LogicalFlowDecoratorStat)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LogicalFlowDecoratorStat); then logicalFlowMeasures return ImmutableLogicalFlowMeasures")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowDecoratorStat ImmutableLogicalFlowDecoratorStat.copyOf(LogicalFlowDecoratorStat)"
  })
  void testCopyOf_thenLogicalFlowMeasuresReturnImmutableLogicalFlowMeasures() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat instance =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act
    ImmutableLogicalFlowDecoratorStat actualCopyOfResult =
        ImmutableLogicalFlowDecoratorStat.copyOf(instance);

    // Assert
    LogicalFlowMeasures logicalFlowMeasuresResult = actualCopyOfResult.logicalFlowMeasures();
    assertTrue(logicalFlowMeasuresResult instanceof ImmutableLogicalFlowMeasures);
    assertEquals(10.0d, logicalFlowMeasuresResult.inbound());
    assertEquals(10.0d, logicalFlowMeasuresResult.intra());
    assertEquals(10.0d, logicalFlowMeasuresResult.outbound());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(3, actualCopyOfResult.totalCount());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}, and {@link
   * ImmutableLogicalFlowDecoratorStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    Builder dataTypeIdResult2 = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat2 =
        dataTypeIdResult2
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowDecoratorStat, immutableLogicalFlowDecoratorStat2);
    assertEquals(
        immutableLogicalFlowDecoratorStat.hashCode(),
        immutableLogicalFlowDecoratorStat2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}, and {@link
   * ImmutableLogicalFlowDecoratorStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowDecoratorStat, immutableLogicalFlowDecoratorStat);
    int expectedHashCodeResult = immutableLogicalFlowDecoratorStat.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowDecoratorStat.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(2L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    Builder dataTypeIdResult2 = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowDecoratorStat,
        dataTypeIdResult2
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(0.5d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    Builder dataTypeIdResult2 = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowDecoratorStat,
        dataTypeIdResult2
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(1)
            .build();

    Builder dataTypeIdResult2 = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowDecoratorStat,
        dataTypeIdResult2
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowDecoratorStat.equals(Object)",
    "int ImmutableLogicalFlowDecoratorStat.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build(),
        "Different type to ImmutableLogicalFlowDecoratorStat");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#toString()}
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#dataTypeId()}
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#logicalFlowMeasures()}
   *   <li>{@link ImmutableLogicalFlowDecoratorStat#totalCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableLogicalFlowDecoratorStat.dataTypeId()",
    "LogicalFlowMeasures ImmutableLogicalFlowDecoratorStat.logicalFlowMeasures()",
    "String ImmutableLogicalFlowDecoratorStat.toString()",
    "int ImmutableLogicalFlowDecoratorStat.totalCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act
    String actualToStringResult = immutableLogicalFlowDecoratorStat.toString();
    long actualDataTypeIdResult = immutableLogicalFlowDecoratorStat.dataTypeId();
    LogicalFlowMeasures actualLogicalFlowMeasuresResult =
        immutableLogicalFlowDecoratorStat.logicalFlowMeasures();

    // Assert
    assertTrue(actualLogicalFlowMeasuresResult instanceof ImmutableLogicalFlowMeasures);
    assertEquals(
        "LogicalFlowDecoratorStat{dataTypeId=1, logicalFlowMeasures=LogicalFlowMeasures{inbound=10.0, outbound=10.0,"
            + " intra=10.0}, totalCount=3}",
        actualToStringResult);
    assertEquals(1L, actualDataTypeIdResult);
    assertEquals(3, immutableLogicalFlowDecoratorStat.totalCount());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   *
   * <p>Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLogicalFlowMeasures(LogicalFlowMeasures)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLogicalFlowMeasures(LogicalFlowMeasures)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLogicalFlowMeasures(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());

    // Assert
    LogicalFlowMeasures logicalFlowMeasures = actualJson.logicalFlowMeasures;
    assertTrue(logicalFlowMeasures instanceof ImmutableLogicalFlowMeasures);
    assertEquals(0, actualJson.totalCount);
    assertEquals(0L, actualJson.dataTypeId);
    assertEquals(10.0d, logicalFlowMeasures.inbound());
    assertEquals(10.0d, logicalFlowMeasures.intra());
    assertEquals(10.0d, logicalFlowMeasures.outbound());
    assertFalse(actualJson.dataTypeIdIsSet);
    assertFalse(actualJson.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#logicalFlowMeasures()}.
   *
   * <p>Method under test: {@link Json#logicalFlowMeasures()}
   */
  @Test
  @DisplayName("Test Json logicalFlowMeasures()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalFlowMeasures Json.logicalFlowMeasures()"})
  void testJsonLogicalFlowMeasures() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlowMeasures());
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   *
   * <p>Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setTotalCount(int)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalCount());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#withDataTypeId(long)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowDecoratorStat ImmutableLogicalFlowDecoratorStat.withDataTypeId(long)"
  })
  void testWithDataTypeId() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(42L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act
    ImmutableLogicalFlowDecoratorStat actualWithDataTypeIdResult =
        immutableLogicalFlowDecoratorStat.withDataTypeId(42L);

    // Assert
    assertSame(immutableLogicalFlowDecoratorStat, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#withDataTypeId(long)}.
   *
   * <ul>
   *   <li>Then logicalFlowMeasures return {@link ImmutableLogicalFlowMeasures}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#withDataTypeId(long)}
   */
  @Test
  @DisplayName(
      "Test withDataTypeId(long); then logicalFlowMeasures return ImmutableLogicalFlowMeasures")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowDecoratorStat ImmutableLogicalFlowDecoratorStat.withDataTypeId(long)"
  })
  void testWithDataTypeId_thenLogicalFlowMeasuresReturnImmutableLogicalFlowMeasures() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act
    ImmutableLogicalFlowDecoratorStat actualWithDataTypeIdResult =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build()
            .withDataTypeId(42L);

    // Assert
    LogicalFlowMeasures logicalFlowMeasuresResult =
        actualWithDataTypeIdResult.logicalFlowMeasures();
    assertTrue(logicalFlowMeasuresResult instanceof ImmutableLogicalFlowMeasures);
    assertEquals(10.0d, logicalFlowMeasuresResult.inbound());
    assertEquals(10.0d, logicalFlowMeasuresResult.intra());
    assertEquals(10.0d, logicalFlowMeasuresResult.outbound());
    assertEquals(3, actualWithDataTypeIdResult.totalCount());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId());
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#withLogicalFlowMeasures(LogicalFlowMeasures)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowDecoratorStat#withLogicalFlowMeasures(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test withLogicalFlowMeasures(LogicalFlowMeasures)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowDecoratorStat ImmutableLogicalFlowDecoratorStat.withLogicalFlowMeasures(LogicalFlowMeasures)"
  })
  void testWithLogicalFlowMeasures() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build();

    // Act
    ImmutableLogicalFlowDecoratorStat actualWithLogicalFlowMeasuresResult =
        immutableLogicalFlowDecoratorStat.withLogicalFlowMeasures(
            ImmutableLogicalFlowMeasures.builder()
                .inbound(10.0d)
                .intra(10.0d)
                .outbound(10.0d)
                .build());

    // Assert
    assertEquals(immutableLogicalFlowDecoratorStat, actualWithLogicalFlowMeasuresResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#withTotalCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#withTotalCount(int)}
   */
  @Test
  @DisplayName("Test withTotalCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowDecoratorStat ImmutableLogicalFlowDecoratorStat.withTotalCount(int)"
  })
  void testWithTotalCount() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);
    ImmutableLogicalFlowDecoratorStat immutableLogicalFlowDecoratorStat =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(42)
            .build();

    // Act
    ImmutableLogicalFlowDecoratorStat actualWithTotalCountResult =
        immutableLogicalFlowDecoratorStat.withTotalCount(42);

    // Assert
    assertSame(immutableLogicalFlowDecoratorStat, actualWithTotalCountResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowDecoratorStat#withTotalCount(int)}.
   *
   * <ul>
   *   <li>Then logicalFlowMeasures return {@link ImmutableLogicalFlowMeasures}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowDecoratorStat#withTotalCount(int)}
   */
  @Test
  @DisplayName(
      "Test withTotalCount(int); then logicalFlowMeasures return ImmutableLogicalFlowMeasures")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowDecoratorStat ImmutableLogicalFlowDecoratorStat.withTotalCount(int)"
  })
  void testWithTotalCount_thenLogicalFlowMeasuresReturnImmutableLogicalFlowMeasures() {
    // Arrange
    Builder dataTypeIdResult = ImmutableLogicalFlowDecoratorStat.builder().dataTypeId(1L);

    // Act
    ImmutableLogicalFlowDecoratorStat actualWithTotalCountResult =
        dataTypeIdResult
            .logicalFlowMeasures(
                ImmutableLogicalFlowMeasures.builder()
                    .inbound(10.0d)
                    .intra(10.0d)
                    .outbound(10.0d)
                    .build())
            .totalCount(3)
            .build()
            .withTotalCount(42);

    // Assert
    LogicalFlowMeasures logicalFlowMeasuresResult =
        actualWithTotalCountResult.logicalFlowMeasures();
    assertTrue(logicalFlowMeasuresResult instanceof ImmutableLogicalFlowMeasures);
    assertEquals(10.0d, logicalFlowMeasuresResult.inbound());
    assertEquals(10.0d, logicalFlowMeasuresResult.intra());
    assertEquals(10.0d, logicalFlowMeasuresResult.outbound());
    assertEquals(1L, actualWithTotalCountResult.dataTypeId());
    assertEquals(42, actualWithTotalCountResult.totalCount());
  }
}
