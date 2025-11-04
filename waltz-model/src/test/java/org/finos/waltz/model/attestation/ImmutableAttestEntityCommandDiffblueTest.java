package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableAttestEntityCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestEntityCommand#builder()}
   *   <li>{@link ImmutableAttestEntityCommand#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAttestEntityCommand.Builder actualBuilderResult = ImmutableAttestEntityCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.attestedEntityId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedEntityKind() {
    // Arrange
    ImmutableAttestEntityCommand.Builder builderResult = ImmutableAttestEntityCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableAttestEntityCommand.Builder builderResult = ImmutableAttestEntityCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Builder#from(AttestEntityCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestEntityCommand.Builder builderResult = ImmutableAttestEntityCommand.builder();
    AttestEntityCommand instance = mock(AttestEntityCommand.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAttestEntityCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Builder#from(AttestEntityCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestEntityCommand.Builder builderResult = ImmutableAttestEntityCommand.builder();
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
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Builder#from(AttestEntityCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestEntityCommand.Builder builderResult = ImmutableAttestEntityCommand.builder();
    AttestEntityCommand instance = mock(AttestEntityCommand.class);
    when(instance.attestedEntityId()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAttestEntityCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableAttestEntityCommand#copyOf(AttestEntityCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestEntityCommand instance = mock(AttestEntityCommand.class);
    when(instance.attestedEntityId()).thenReturn(1L);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAttestEntityCommand actualCopyOfResult = ImmutableAttestEntityCommand.copyOf(instance);

    // Assert
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).entityReference();
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand#fromJson(ImmutableAttestEntityCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAttestEntityCommand.Json json = new ImmutableAttestEntityCommand.Json();
    json.setEntityReference(mock(EntityReference.class));
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(null);

    // Act
    ImmutableAttestEntityCommand actualFromJsonResult = ImmutableAttestEntityCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedEntityId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Json#attestedEntityId()}
   */
  @Test
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestEntityCommand.Json()).attestedEntityId());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Json#attestedEntityKind()}
   */
  @Test
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestEntityCommand.Json()).attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestEntityCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestEntityCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAttestEntityCommand.Json}
   *   <li>{@link ImmutableAttestEntityCommand.Json#setAttestedEntityId(Long)}
   *   <li>
   * {@link ImmutableAttestEntityCommand.Json#setAttestedEntityKind(EntityKind)}
   *   <li>
   * {@link ImmutableAttestEntityCommand.Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAttestEntityCommand.Json actualJson = new ImmutableAttestEntityCommand.Json();
    actualJson.setAttestedEntityId(1L);
    actualJson.setAttestedEntityKind(EntityKind.ALL);
    actualJson.setEntityReference(null);

    // Assert
    assertEquals(1L, actualJson.attestedEntityId.longValue());
  }
}
