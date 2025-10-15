package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAttestationWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAttestationWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#attestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedEntityKind(EntityKind)"})
  void testBuilderAttestedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetParameters.builder();

    // Act
    Builder actualAttestedEntityKindResult = builderResult.attestedEntityKind(EntityKind.ALL);

    // Assert
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        builderResult.build();
    assertNull(immutableAttestationWidgetParameters.attestedEntityId());
    assertEquals(EntityKind.ALL, immutableAttestationWidgetParameters.attestedEntityKind());
    assertSame(builderResult, actualAttestedEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.attestedEntityId(Long)",
    "ImmutableAttestationWidgetParameters Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAttestationWidgetParameters actualImmutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals(1L, actualImmutableAttestationWidgetParameters.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableAttestationWidgetParameters.attestedEntityKind());
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetParameters)}.
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetParameters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetParameters.builder();
    ImmutableAttestationWidgetParameters instance =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationWidgetParameters actualImmutableAttestationWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetParameters)}.
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetParameters)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetParameters.builder();
    ImmutableAttestationWidgetParameters instance =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(null)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationWidgetParameters actualImmutableAttestationWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#copyOf(AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationWidgetParameters#copyOf(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationWidgetParameters); then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.copyOf(AttestationWidgetParameters)"
  })
  void testCopyOf_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    ImmutableAttestationWidgetParameters instance =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationWidgetParameters actualCopyOfResult =
        ImmutableAttestationWidgetParameters.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#equals(Object)}, and {@link
   * ImmutableAttestationWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetParameters.equals(Object)",
    "int ImmutableAttestationWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters2 =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationWidgetParameters, immutableAttestationWidgetParameters2);
    assertEquals(
        immutableAttestationWidgetParameters.hashCode(),
        immutableAttestationWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#equals(Object)}, and {@link
   * ImmutableAttestationWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetParameters.equals(Object)",
    "int ImmutableAttestationWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationWidgetParameters, immutableAttestationWidgetParameters);
    int expectedHashCodeResult = immutableAttestationWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetParameters.equals(Object)",
    "int ImmutableAttestationWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(2L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationWidgetParameters,
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetParameters.equals(Object)",
    "int ImmutableAttestationWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationWidgetParameters,
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetParameters.equals(Object)",
    "int ImmutableAttestationWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetParameters.equals(Object)",
    "int ImmutableAttestationWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableAttestationWidgetParameters");
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given one; then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenOne_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setAttestedEntityId(1L);
    json.setAttestedEntityKind(EntityKind.ALL);

    // Act
    ImmutableAttestationWidgetParameters actualFromJsonResult =
        ImmutableAttestationWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestedEntityId is {@code null}.
   *   <li>Then return attestedEntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AttestedEntityId is 'null'; then return attestedEntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.fromJson(Json)"
  })
  void testFromJson_whenJsonAttestedEntityIdIsNull_thenReturnAttestedEntityIdIsNull() {
    // Arrange
    Json json = new Json();
    json.setAttestedEntityId(null);
    json.setAttestedEntityKind(EntityKind.ALL);

    // Act
    ImmutableAttestationWidgetParameters actualFromJsonResult =
        ImmutableAttestationWidgetParameters.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedEntityId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetParameters#toString()}
   *   <li>{@link ImmutableAttestationWidgetParameters#attestedEntityId()}
   *   <li>{@link ImmutableAttestationWidgetParameters#attestedEntityKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableAttestationWidgetParameters.attestedEntityId()",
    "EntityKind ImmutableAttestationWidgetParameters.attestedEntityKind()",
    "String ImmutableAttestationWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act
    String actualToStringResult = immutableAttestationWidgetParameters.toString();
    Long actualAttestedEntityIdResult = immutableAttestationWidgetParameters.attestedEntityId();
    EntityKind actualAttestedEntityKindResult =
        immutableAttestationWidgetParameters.attestedEntityKind();

    // Assert
    assertEquals(
        "AttestationWidgetParameters{attestedEntityId=1, attestedEntityKind=ALL}",
        actualToStringResult);
    assertEquals(1L, actualAttestedEntityIdResult.longValue());
    assertEquals(EntityKind.ALL, actualAttestedEntityKindResult);
  }

  /**
   * Test Json {@link Json#attestedEntityId()}.
   *
   * <p>Method under test: {@link Json#attestedEntityId()}
   */
  @Test
  @DisplayName("Test Json attestedEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.attestedEntityId()"})
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityId());
  }

  /**
   * Test Json {@link Json#attestedEntityKind()}.
   *
   * <p>Method under test: {@link Json#attestedEntityKind()}
   */
  @Test
  @DisplayName("Test Json attestedEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.attestedEntityKind()"})
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityKind());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestedEntityId(Long)}
   *   <li>{@link Json#setAttestedEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAttestedEntityId(Long)",
    "void Json.setAttestedEntityKind(EntityKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAttestedEntityId(1L);
    actualJson.setAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(1L, actualJson.attestedEntityId.longValue());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#withAttestedEntityId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#withAttestedEntityId(Long)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.withAttestedEntityId(Long)"
  })
  void testWithAttestedEntityId() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationWidgetParameters actualWithAttestedEntityIdResult =
        immutableAttestationWidgetParameters.withAttestedEntityId(1L);

    // Assert
    assertSame(immutableAttestationWidgetParameters, actualWithAttestedEntityIdResult);
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#withAttestedEntityId(Long)}.
   *
   * <ul>
   *   <li>Then return attestedEntityId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetParameters#withAttestedEntityId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAttestedEntityId(Long); then return attestedEntityId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.withAttestedEntityId(Long)"
  })
  void testWithAttestedEntityId_thenReturnAttestedEntityIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableAttestationWidgetParameters actualWithAttestedEntityIdResult =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build()
            .withAttestedEntityId(42L);

    // Assert
    assertEquals(42L, actualWithAttestedEntityIdResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityIdResult.attestedEntityKind());
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#withAttestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationWidgetParameters#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind() {
    // Arrange
    ImmutableAttestationWidgetParameters immutableAttestationWidgetParameters =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableAttestationWidgetParameters actualWithAttestedEntityKindResult =
        immutableAttestationWidgetParameters.withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestationWidgetParameters, actualWithAttestedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationWidgetParameters#withAttestedEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationWidgetParameters#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withAttestedEntityKind(EntityKind); then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetParameters ImmutableAttestationWidgetParameters.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange and Act
    ImmutableAttestationWidgetParameters actualWithAttestedEntityKindResult =
        ImmutableAttestationWidgetParameters.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR)
            .build()
            .withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(1L, actualWithAttestedEntityKindResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityKindResult.attestedEntityKind());
  }
}
