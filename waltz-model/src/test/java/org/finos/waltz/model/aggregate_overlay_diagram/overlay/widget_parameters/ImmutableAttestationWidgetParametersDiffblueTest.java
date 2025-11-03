package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAttestationWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAttestationWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetParametersDiffblueTest {
  /**
   * Test {@link ImmutableAttestationWidgetParameters#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetParameters#builder()}
   *   <li>{@link ImmutableAttestationWidgetParameters#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityId(Long)", "ImmutableAttestationWidgetParameters Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAttestationWidgetParameters.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.attestedEntityId(1L));
  }

  /**
   * Test Builder {@link Builder#attestedEntityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityKind(EntityKind)"})
  void testBuilderAttestedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetParameters.builder();

    // Act
    Builder actualAttestedEntityKindResult = builderResult.attestedEntityKind(EntityKind.ALL);

    // Assert
    ImmutableAttestationWidgetParameters buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualAttestedEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetParameters)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build attestedEntityId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetParameters); given one; then builder build attestedEntityId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetParameters)"})
  void testBuilderFrom_givenOne_thenBuilderBuildAttestedEntityIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetParameters.builder();
    AttestationWidgetParameters instance = mock(AttestationWidgetParameters.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    ImmutableAttestationWidgetParameters buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetParameters)}.
   * <ul>
   *   <li>Then builder build attestedEntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetParameters); then builder build attestedEntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetParameters)"})
  void testBuilderFrom_thenBuilderBuildAttestedEntityIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetParameters.builder();
    AttestationWidgetParameters instance = mock(AttestationWidgetParameters.class);
    when(instance.attestedEntityId()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    ImmutableAttestationWidgetParameters buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#attestedEntityId()}.
   * <p>
   * Method under test: {@link Json#attestedEntityId()}
   */
  @Test
  @DisplayName("Test Json attestedEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.attestedEntityId()"})
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedEntityId());
  }

  /**
   * Test Json {@link Json#attestedEntityKind()}.
   * <p>
   * Method under test: {@link Json#attestedEntityKind()}
   */
  @Test
  @DisplayName("Test Json attestedEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.attestedEntityKind()"})
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestedEntityKind());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestedEntityId(Long)}
   *   <li>{@link Json#setAttestedEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAttestedEntityId(Long)",
      "void Json.setAttestedEntityKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAttestedEntityId(1L);
    actualJson.setAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(1L, actualJson.attestedEntityId.longValue());
  }
}
