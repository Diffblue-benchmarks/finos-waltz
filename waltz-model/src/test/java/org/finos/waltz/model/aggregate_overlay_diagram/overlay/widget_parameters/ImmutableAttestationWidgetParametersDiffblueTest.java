package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetParametersDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetParameters#builder()}
   *   <li>{@link ImmutableAttestationWidgetParameters#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAttestationWidgetParameters.Builder actualBuilderResult = ImmutableAttestationWidgetParameters.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.attestedEntityId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedEntityKind() {
    // Arrange
    ImmutableAttestationWidgetParameters.Builder builderResult = ImmutableAttestationWidgetParameters.builder();

    // Act
    ImmutableAttestationWidgetParameters.Builder actualAttestedEntityKindResult = builderResult
        .attestedEntityKind(EntityKind.ALL);

    // Assert
    ImmutableAttestationWidgetParameters buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualAttestedEntityKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters.Builder#from(AttestationWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationWidgetParameters.Builder builderResult = ImmutableAttestationWidgetParameters.builder();
    AttestationWidgetParameters instance = mock(AttestationWidgetParameters.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    ImmutableAttestationWidgetParameters buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters.Builder#from(AttestationWidgetParameters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationWidgetParameters.Builder builderResult = ImmutableAttestationWidgetParameters.builder();
    AttestationWidgetParameters instance = mock(AttestationWidgetParameters.class);
    when(instance.attestedEntityId()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    ImmutableAttestationWidgetParameters buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters#copyOf(AttestationWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationWidgetParameters instance = mock(AttestationWidgetParameters.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableAttestationWidgetParameters actualCopyOfResult = ImmutableAttestationWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters#fromJson(ImmutableAttestationWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAttestationWidgetParameters.Json json = new ImmutableAttestationWidgetParameters.Json();
    json.setAttestedEntityId(null);
    json.setAttestedEntityKind(EntityKind.ALL);

    // Act
    ImmutableAttestationWidgetParameters actualFromJsonResult = ImmutableAttestationWidgetParameters.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedEntityId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters.Json#attestedEntityId()}
   */
  @Test
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationWidgetParameters.Json()).attestedEntityId());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetParameters.Json#attestedEntityKind()}
   */
  @Test
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationWidgetParameters.Json()).attestedEntityKind());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAttestationWidgetParameters.Json}
   *   <li>
   * {@link ImmutableAttestationWidgetParameters.Json#setAttestedEntityId(Long)}
   *   <li>
   * {@link ImmutableAttestationWidgetParameters.Json#setAttestedEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAttestationWidgetParameters.Json actualJson = new ImmutableAttestationWidgetParameters.Json();
    actualJson.setAttestedEntityId(1L);
    actualJson.setAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(1L, actualJson.attestedEntityId.longValue());
  }
}
