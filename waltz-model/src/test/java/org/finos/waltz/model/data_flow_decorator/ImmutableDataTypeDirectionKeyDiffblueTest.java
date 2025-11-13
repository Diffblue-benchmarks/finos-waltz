package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.data_flow_decorator.ImmutableDataTypeDirectionKey.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableDataTypeDirectionKey.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDirectionKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDirectionKey Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableDataTypeDirectionKey actualImmutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Assert
    assertEquals(1L, actualImmutableDataTypeDirectionKey.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualImmutableDataTypeDirectionKey.flowDirection());
  }

  /**
   * Test Builder {@link Builder#DatatypeId(Long)}.
   *
   * <p>Method under test: {@link Builder#DatatypeId(Long)}
   */
  @Test
  @DisplayName("Test Builder DatatypeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.DatatypeId(Long)"})
  void testBuilderDatatypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDirectionKey.builder();

    // Act
    Builder actualDatatypeIdResult = builderResult.DatatypeId(1L);

    // Assert
    assertSame(builderResult, actualDatatypeIdResult);
  }

  /**
   * Test Builder {@link Builder#flowDirection(FlowDirection)}.
   *
   * <p>Method under test: {@link Builder#flowDirection(FlowDirection)}
   */
  @Test
  @DisplayName("Test Builder flowDirection(FlowDirection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowDirection(FlowDirection)"})
  void testBuilderFlowDirection() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDirectionKey.builder();

    // Act
    Builder actualFlowDirectionResult = builderResult.flowDirection(FlowDirection.INBOUND);

    // Assert
    assertSame(builderResult, actualFlowDirectionResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDirectionKey)}.
   *
   * <ul>
   *   <li>Then builder build is builder DatatypeId one flowDirection {@code INBOUND} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DataTypeDirectionKey)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DataTypeDirectionKey); then builder build is builder DatatypeId one flowDirection 'INBOUND' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDirectionKey)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderDatatypeIdOneFlowDirectionInboundBuild() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDirectionKey.builder();
    ImmutableDataTypeDirectionKey instance =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeDirectionKey actualImmutableDataTypeDirectionKey = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDirectionKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#copyOf(DataTypeDirectionKey)}.
   *
   * <ul>
   *   <li>Then return DatatypeId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#copyOf(DataTypeDirectionKey)}
   */
  @Test
  @DisplayName("Test copyOf(DataTypeDirectionKey); then return DatatypeId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDirectionKey ImmutableDataTypeDirectionKey.copyOf(DataTypeDirectionKey)"
  })
  void testCopyOf_thenReturnDatatypeIdLongValueIsOne() {
    // Arrange
    ImmutableDataTypeDirectionKey instance =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act
    ImmutableDataTypeDirectionKey actualCopyOfResult =
        ImmutableDataTypeDirectionKey.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.flowDirection());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#equals(Object)}, and {@link
   * ImmutableDataTypeDirectionKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDirectionKey#equals(Object)}
   *   <li>{@link ImmutableDataTypeDirectionKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDirectionKey.equals(Object)",
    "int ImmutableDataTypeDirectionKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey2 =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeDirectionKey, immutableDataTypeDirectionKey2);
    assertEquals(
        immutableDataTypeDirectionKey.hashCode(), immutableDataTypeDirectionKey2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#equals(Object)}, and {@link
   * ImmutableDataTypeDirectionKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDirectionKey#equals(Object)}
   *   <li>{@link ImmutableDataTypeDirectionKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDirectionKey.equals(Object)",
    "int ImmutableDataTypeDirectionKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeDirectionKey, immutableDataTypeDirectionKey);
    int expectedHashCodeResult = immutableDataTypeDirectionKey.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataTypeDirectionKey.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDirectionKey.equals(Object)",
    "int ImmutableDataTypeDirectionKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(2L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDirectionKey,
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDirectionKey.equals(Object)",
    "int ImmutableDataTypeDirectionKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.OUTBOUND)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDirectionKey,
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDirectionKey.equals(Object)",
    "int ImmutableDataTypeDirectionKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDirectionKey.equals(Object)",
    "int ImmutableDataTypeDirectionKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build(),
        "Different type to ImmutableDataTypeDirectionKey");
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) DatatypeId is one.
   *   <li>Then return DatatypeId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) DatatypeId is one; then return DatatypeId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDirectionKey ImmutableDataTypeDirectionKey.fromJson(Json)"})
  void testFromJson_givenOne_whenJsonDatatypeIdIsOne_thenReturnDatatypeIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setDatatypeId(1L);
    json.setFlowDirection(FlowDirection.INBOUND);

    // Act
    ImmutableDataTypeDirectionKey actualFromJsonResult =
        ImmutableDataTypeDirectionKey.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualFromJsonResult.flowDirection());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDirectionKey#toString()}
   *   <li>{@link ImmutableDataTypeDirectionKey#DatatypeId()}
   *   <li>{@link ImmutableDataTypeDirectionKey#flowDirection()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableDataTypeDirectionKey.DatatypeId()",
    "FlowDirection ImmutableDataTypeDirectionKey.flowDirection()",
    "String ImmutableDataTypeDirectionKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act
    String actualToStringResult = immutableDataTypeDirectionKey.toString();
    Long actualDatatypeIdResult = immutableDataTypeDirectionKey.DatatypeId();
    FlowDirection actualFlowDirectionResult = immutableDataTypeDirectionKey.flowDirection();

    // Assert
    assertEquals("DataTypeDirectionKey{DatatypeId=1, flowDirection=INBOUND}", actualToStringResult);
    assertEquals(1L, actualDatatypeIdResult.longValue());
    assertEquals(FlowDirection.INBOUND, actualFlowDirectionResult);
  }

  /**
   * Test Json {@link Json#DatatypeId()}.
   *
   * <p>Method under test: {@link Json#DatatypeId()}
   */
  @Test
  @DisplayName("Test Json DatatypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.DatatypeId()"})
  void testJsonDatatypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().DatatypeId());
  }

  /**
   * Test Json {@link Json#flowDirection()}.
   *
   * <p>Method under test: {@link Json#flowDirection()}
   */
  @Test
  @DisplayName("Test Json flowDirection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDirection Json.flowDirection()"})
  void testJsonFlowDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowDirection());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDatatypeId(Long)}
   *   <li>{@link Json#setFlowDirection(FlowDirection)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDatatypeId(Long)",
    "void Json.setFlowDirection(FlowDirection)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDatatypeId(1L);
    actualJson.setFlowDirection(FlowDirection.INBOUND);

    // Assert
    assertEquals(1L, actualJson.DatatypeId.longValue());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#withDatatypeId(Long)}.
   *
   * <ul>
   *   <li>Then return builder DatatypeId one flowDirection {@code INBOUND} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#withDatatypeId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDatatypeId(Long); then return builder DatatypeId one flowDirection 'INBOUND' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDirectionKey ImmutableDataTypeDirectionKey.withDatatypeId(Long)"
  })
  void testWithDatatypeId_thenReturnBuilderDatatypeIdOneFlowDirectionInboundBuild() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act
    ImmutableDataTypeDirectionKey actualWithDatatypeIdResult =
        immutableDataTypeDirectionKey.withDatatypeId(1L);

    // Assert
    assertSame(immutableDataTypeDirectionKey, actualWithDatatypeIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#withDatatypeId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return DatatypeId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#withDatatypeId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDatatypeId(Long); when forty-two; then return DatatypeId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDirectionKey ImmutableDataTypeDirectionKey.withDatatypeId(Long)"
  })
  void testWithDatatypeId_whenFortyTwo_thenReturnDatatypeIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableDataTypeDirectionKey actualWithDatatypeIdResult =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build()
            .withDatatypeId(42L);

    // Assert
    assertEquals(42L, actualWithDatatypeIdResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualWithDatatypeIdResult.flowDirection());
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#withFlowDirection(FlowDirection)}.
   *
   * <ul>
   *   <li>Then return builder DatatypeId one flowDirection {@code INBOUND} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#withFlowDirection(FlowDirection)}
   */
  @Test
  @DisplayName(
      "Test withFlowDirection(FlowDirection); then return builder DatatypeId one flowDirection 'INBOUND' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDirectionKey ImmutableDataTypeDirectionKey.withFlowDirection(FlowDirection)"
  })
  void testWithFlowDirection_thenReturnBuilderDatatypeIdOneFlowDirectionInboundBuild() {
    // Arrange
    ImmutableDataTypeDirectionKey immutableDataTypeDirectionKey =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.INBOUND)
            .build();

    // Act
    ImmutableDataTypeDirectionKey actualWithFlowDirectionResult =
        immutableDataTypeDirectionKey.withFlowDirection(FlowDirection.INBOUND);

    // Assert
    assertSame(immutableDataTypeDirectionKey, actualWithFlowDirectionResult);
  }

  /**
   * Test {@link ImmutableDataTypeDirectionKey#withFlowDirection(FlowDirection)}.
   *
   * <ul>
   *   <li>Then return DatatypeId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDirectionKey#withFlowDirection(FlowDirection)}
   */
  @Test
  @DisplayName("Test withFlowDirection(FlowDirection); then return DatatypeId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDirectionKey ImmutableDataTypeDirectionKey.withFlowDirection(FlowDirection)"
  })
  void testWithFlowDirection_thenReturnDatatypeIdLongValueIsOne() {
    // Arrange and Act
    ImmutableDataTypeDirectionKey actualWithFlowDirectionResult =
        ImmutableDataTypeDirectionKey.builder()
            .DatatypeId(1L)
            .flowDirection(FlowDirection.OUTBOUND)
            .build()
            .withFlowDirection(FlowDirection.INBOUND);

    // Assert
    assertEquals(1L, actualWithFlowDirectionResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualWithFlowDirectionResult.flowDirection());
  }
}
