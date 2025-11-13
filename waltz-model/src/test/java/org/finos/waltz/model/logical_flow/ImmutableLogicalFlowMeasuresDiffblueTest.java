package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowMeasures.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowMeasures.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowMeasuresDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowMeasures Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLogicalFlowMeasures actualImmutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Assert
    assertEquals(10.0d, actualImmutableLogicalFlowMeasures.inbound());
    assertEquals(10.0d, actualImmutableLogicalFlowMeasures.intra());
    assertEquals(10.0d, actualImmutableLogicalFlowMeasures.outbound());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowMeasures)}.
   *
   * <ul>
   *   <li>Then builder build is builder inbound ten intra ten outbound ten build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LogicalFlowMeasures); then builder build is builder inbound ten intra ten outbound ten build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowMeasures)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderInboundTenIntraTenOutboundTenBuild() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();
    ImmutableLogicalFlowMeasures instance =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowMeasures actualImmutableLogicalFlowMeasures = builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowMeasures);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#inbound(double)}.
   *
   * <p>Method under test: {@link Builder#inbound(double)}
   */
  @Test
  @DisplayName("Test Builder inbound(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inbound(double)"})
  void testBuilderInbound() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act
    Builder actualInboundResult = builderResult.inbound(10.0d);

    // Assert
    assertSame(builderResult, actualInboundResult);
  }

  /**
   * Test Builder {@link Builder#intra(double)}.
   *
   * <p>Method under test: {@link Builder#intra(double)}
   */
  @Test
  @DisplayName("Test Builder intra(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.intra(double)"})
  void testBuilderIntra() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act
    Builder actualIntraResult = builderResult.intra(10.0d);

    // Assert
    assertSame(builderResult, actualIntraResult);
  }

  /**
   * Test Builder {@link Builder#outbound(double)}.
   *
   * <p>Method under test: {@link Builder#outbound(double)}
   */
  @Test
  @DisplayName("Test Builder outbound(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.outbound(double)"})
  void testBuilderOutbound() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowMeasures.builder();

    // Act
    Builder actualOutboundResult = builderResult.outbound(10.0d);

    // Assert
    assertSame(builderResult, actualOutboundResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#copyOf(LogicalFlowMeasures)}.
   *
   * <ul>
   *   <li>When builder inbound ten intra ten outbound ten build.
   *   <li>Then return inbound is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#copyOf(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LogicalFlowMeasures); when builder inbound ten intra ten outbound ten build; then return inbound is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.copyOf(LogicalFlowMeasures)"
  })
  void testCopyOf_whenBuilderInboundTenIntraTenOutboundTenBuild_thenReturnInboundIsTen() {
    // Arrange
    ImmutableLogicalFlowMeasures instance =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act
    ImmutableLogicalFlowMeasures actualCopyOfResult = ImmutableLogicalFlowMeasures.copyOf(instance);

    // Assert
    assertEquals(10.0d, actualCopyOfResult.inbound());
    assertEquals(10.0d, actualCopyOfResult.intra());
    assertEquals(10.0d, actualCopyOfResult.outbound());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}, and {@link
   * ImmutableLogicalFlowMeasures#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowMeasures#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowMeasures#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures2 =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act and Assert
    assertEquals(immutableLogicalFlowMeasures, immutableLogicalFlowMeasures2);
    assertEquals(immutableLogicalFlowMeasures.hashCode(), immutableLogicalFlowMeasures2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}, and {@link
   * ImmutableLogicalFlowMeasures#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowMeasures#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowMeasures#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act and Assert
    assertEquals(immutableLogicalFlowMeasures, immutableLogicalFlowMeasures);
    int expectedHashCodeResult = immutableLogicalFlowMeasures.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowMeasures.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(0.5d).intra(10.0d).outbound(10.0d).build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowMeasures,
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(0.5d).outbound(10.0d).build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowMeasures,
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(0.5d).build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowMeasures,
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowMeasures.equals(Object)",
    "int ImmutableLogicalFlowMeasures.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build(),
        "Different type to ImmutableLogicalFlowMeasures");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowMeasures#toString()}
   *   <li>{@link ImmutableLogicalFlowMeasures#inbound()}
   *   <li>{@link ImmutableLogicalFlowMeasures#intra()}
   *   <li>{@link ImmutableLogicalFlowMeasures#outbound()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double ImmutableLogicalFlowMeasures.inbound()",
    "double ImmutableLogicalFlowMeasures.intra()",
    "double ImmutableLogicalFlowMeasures.outbound()",
    "String ImmutableLogicalFlowMeasures.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act
    String actualToStringResult = immutableLogicalFlowMeasures.toString();
    double actualInboundResult = immutableLogicalFlowMeasures.inbound();
    double actualIntraResult = immutableLogicalFlowMeasures.intra();

    // Assert
    assertEquals(
        "LogicalFlowMeasures{inbound=10.0, outbound=10.0, intra=10.0}", actualToStringResult);
    assertEquals(10.0d, actualInboundResult);
    assertEquals(10.0d, actualIntraResult);
    assertEquals(10.0d, immutableLogicalFlowMeasures.outbound());
  }

  /**
   * Test Json {@link Json#inbound()}.
   *
   * <p>Method under test: {@link Json#inbound()}
   */
  @Test
  @DisplayName("Test Json inbound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Json.inbound()"})
  void testJsonInbound() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inbound());
  }

  /**
   * Test Json {@link Json#intra()}.
   *
   * <p>Method under test: {@link Json#intra()}
   */
  @Test
  @DisplayName("Test Json intra()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Json.intra()"})
  void testJsonIntra() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().intra());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0.0d, actualJson.inbound);
    assertEquals(0.0d, actualJson.intra);
    assertEquals(0.0d, actualJson.outbound);
    assertFalse(actualJson.inboundIsSet);
    assertFalse(actualJson.intraIsSet);
    assertFalse(actualJson.outboundIsSet);
  }

  /**
   * Test Json {@link Json#outbound()}.
   *
   * <p>Method under test: {@link Json#outbound()}
   */
  @Test
  @DisplayName("Test Json outbound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Json.outbound()"})
  void testJsonOutbound() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().outbound());
  }

  /**
   * Test Json {@link Json#setInbound(double)}.
   *
   * <p>Method under test: {@link Json#setInbound(double)}
   */
  @Test
  @DisplayName("Test Json setInbound(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setInbound(double)"})
  void testJsonSetInbound() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInbound(10.0d);

    // Assert
    assertEquals(10.0d, json.inbound);
    assertTrue(json.inboundIsSet);
  }

  /**
   * Test Json {@link Json#setIntra(double)}.
   *
   * <p>Method under test: {@link Json#setIntra(double)}
   */
  @Test
  @DisplayName("Test Json setIntra(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIntra(double)"})
  void testJsonSetIntra() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIntra(10.0d);

    // Assert
    assertEquals(10.0d, json.intra);
    assertTrue(json.intraIsSet);
  }

  /**
   * Test Json {@link Json#setOutbound(double)}.
   *
   * <p>Method under test: {@link Json#setOutbound(double)}
   */
  @Test
  @DisplayName("Test Json setOutbound(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setOutbound(double)"})
  void testJsonSetOutbound() {
    // Arrange
    Json json = new Json();

    // Act
    json.setOutbound(10.0d);

    // Assert
    assertEquals(10.0d, json.outbound);
    assertTrue(json.outboundIsSet);
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#withInbound(double)}.
   *
   * <ul>
   *   <li>Then return builder inbound ten intra ten outbound ten build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#withInbound(double)}
   */
  @Test
  @DisplayName(
      "Test withInbound(double); then return builder inbound ten intra ten outbound ten build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.withInbound(double)"
  })
  void testWithInbound_thenReturnBuilderInboundTenIntraTenOutboundTenBuild() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act
    ImmutableLogicalFlowMeasures actualWithInboundResult =
        immutableLogicalFlowMeasures.withInbound(10.0d);

    // Assert
    assertSame(immutableLogicalFlowMeasures, actualWithInboundResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#withInbound(double)}.
   *
   * <ul>
   *   <li>Then return inbound is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#withInbound(double)}
   */
  @Test
  @DisplayName("Test withInbound(double); then return inbound is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.withInbound(double)"
  })
  void testWithInbound_thenReturnInboundIsTen() {
    // Arrange and Act
    ImmutableLogicalFlowMeasures actualWithInboundResult =
        ImmutableLogicalFlowMeasures.builder()
            .inbound(0.5d)
            .intra(10.0d)
            .outbound(10.0d)
            .build()
            .withInbound(10.0d);

    // Assert
    assertEquals(10.0d, actualWithInboundResult.inbound());
    assertEquals(10.0d, actualWithInboundResult.intra());
    assertEquals(10.0d, actualWithInboundResult.outbound());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#withIntra(double)}.
   *
   * <ul>
   *   <li>Then return builder inbound ten intra ten outbound ten build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#withIntra(double)}
   */
  @Test
  @DisplayName(
      "Test withIntra(double); then return builder inbound ten intra ten outbound ten build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.withIntra(double)"})
  void testWithIntra_thenReturnBuilderInboundTenIntraTenOutboundTenBuild() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act
    ImmutableLogicalFlowMeasures actualWithIntraResult =
        immutableLogicalFlowMeasures.withIntra(10.0d);

    // Assert
    assertSame(immutableLogicalFlowMeasures, actualWithIntraResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#withIntra(double)}.
   *
   * <ul>
   *   <li>Then return inbound is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#withIntra(double)}
   */
  @Test
  @DisplayName("Test withIntra(double); then return inbound is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.withIntra(double)"})
  void testWithIntra_thenReturnInboundIsTen() {
    // Arrange and Act
    ImmutableLogicalFlowMeasures actualWithIntraResult =
        ImmutableLogicalFlowMeasures.builder()
            .inbound(10.0d)
            .intra(0.5d)
            .outbound(10.0d)
            .build()
            .withIntra(10.0d);

    // Assert
    assertEquals(10.0d, actualWithIntraResult.inbound());
    assertEquals(10.0d, actualWithIntraResult.intra());
    assertEquals(10.0d, actualWithIntraResult.outbound());
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#withOutbound(double)}.
   *
   * <ul>
   *   <li>Then return builder inbound ten intra ten outbound ten build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#withOutbound(double)}
   */
  @Test
  @DisplayName(
      "Test withOutbound(double); then return builder inbound ten intra ten outbound ten build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.withOutbound(double)"
  })
  void testWithOutbound_thenReturnBuilderInboundTenIntraTenOutboundTenBuild() {
    // Arrange
    ImmutableLogicalFlowMeasures immutableLogicalFlowMeasures =
        ImmutableLogicalFlowMeasures.builder().inbound(10.0d).intra(10.0d).outbound(10.0d).build();

    // Act
    ImmutableLogicalFlowMeasures actualWithOutboundResult =
        immutableLogicalFlowMeasures.withOutbound(10.0d);

    // Assert
    assertSame(immutableLogicalFlowMeasures, actualWithOutboundResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowMeasures#withOutbound(double)}.
   *
   * <ul>
   *   <li>Then return inbound is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowMeasures#withOutbound(double)}
   */
  @Test
  @DisplayName("Test withOutbound(double); then return inbound is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowMeasures ImmutableLogicalFlowMeasures.withOutbound(double)"
  })
  void testWithOutbound_thenReturnInboundIsTen() {
    // Arrange and Act
    ImmutableLogicalFlowMeasures actualWithOutboundResult =
        ImmutableLogicalFlowMeasures.builder()
            .inbound(10.0d)
            .intra(10.0d)
            .outbound(0.5d)
            .build()
            .withOutbound(10.0d);

    // Assert
    assertEquals(10.0d, actualWithOutboundResult.inbound());
    assertEquals(10.0d, actualWithOutboundResult.intra());
    assertEquals(10.0d, actualWithOutboundResult.outbound());
  }
}
