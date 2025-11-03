package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.attestation.ImmutableAttestEntityCommand.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestEntityCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestEntityCommandDiffblueTest {
  /**
   * Test {@link ImmutableAttestEntityCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestEntityCommand#builder()}
   *   <li>{@link ImmutableAttestEntityCommand#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestedEntityId(Long)", "ImmutableAttestEntityCommand Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAttestEntityCommand.builder();

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
    Builder builderResult = ImmutableAttestEntityCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(AttestEntityCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build attestedEntityId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestEntityCommand); given one; then builder build attestedEntityId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestEntityCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildAttestedEntityIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();
    AttestEntityCommand instance = mock(AttestEntityCommand.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).entityReference();
    ImmutableAttestEntityCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestEntityCommand)}.
   * <ul>
   *   <li>Then builder build attestedEntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestEntityCommand); then builder build attestedEntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestEntityCommand)"})
  void testBuilderFrom_thenBuilderBuildAttestedEntityIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();
    AttestEntityCommand instance = mock(AttestEntityCommand.class);
    when(instance.attestedEntityId()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).entityReference();
    ImmutableAttestEntityCommand buildResult = builderResult.build();
    assertNull(buildResult.attestedEntityId());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestEntityCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestEntityCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestEntityCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();
    AttestEntityCommand instance = mock(AttestEntityCommand.class);
    when(instance.attestedEntityId()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).entityReference();
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
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestedEntityId(Long)}
   *   <li>{@link Json#setAttestedEntityKind(EntityKind)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAttestedEntityId(Long)",
      "void Json.setAttestedEntityKind(EntityKind)", "void Json.setEntityReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAttestedEntityId(1L);
    actualJson.setAttestedEntityKind(EntityKind.ALL);
    actualJson.setEntityReference(null);

    // Assert
    assertEquals(1L, actualJson.attestedEntityId.longValue());
  }
}
