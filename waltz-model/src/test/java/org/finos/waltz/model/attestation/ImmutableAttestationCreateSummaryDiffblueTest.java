package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAttestationCreateSummaryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Builder#entityCount(int)}
   */
  @Test
  void testBuilderEntityCount() {
    // Arrange
    ImmutableAttestationCreateSummary.Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Builder#from(AttestationCreateSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationCreateSummary.Builder builderResult = ImmutableAttestationCreateSummary.builder();
    AttestationCreateSummary instance = mock(AttestationCreateSummary.class);
    when(instance.entityCount()).thenReturn(3);
    when(instance.instanceCount()).thenReturn(3);
    when(instance.recipientCount()).thenReturn(3L);

    // Act
    ImmutableAttestationCreateSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityCount();
    verify(instance).instanceCount();
    verify(instance).recipientCount();
    ImmutableAttestationCreateSummary buildResult = builderResult.build();
    assertEquals(3, buildResult.entityCount());
    assertEquals(3, buildResult.instanceCount());
    assertEquals(3L, buildResult.recipientCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Builder#instanceCount(int)}
   */
  @Test
  void testBuilderInstanceCount() {
    // Arrange
    ImmutableAttestationCreateSummary.Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Builder#recipientCount(long)}
   */
  @Test
  void testBuilderRecipientCount() {
    // Arrange
    ImmutableAttestationCreateSummary.Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary#copyOf(AttestationCreateSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationCreateSummary instance = mock(AttestationCreateSummary.class);
    when(instance.entityCount()).thenReturn(3);
    when(instance.instanceCount()).thenReturn(3);
    when(instance.recipientCount()).thenReturn(3L);

    // Act
    ImmutableAttestationCreateSummary actualCopyOfResult = ImmutableAttestationCreateSummary.copyOf(instance);

    // Assert
    verify(instance).entityCount();
    verify(instance).instanceCount();
    verify(instance).recipientCount();
    assertEquals(3, actualCopyOfResult.entityCount());
    assertEquals(3, actualCopyOfResult.instanceCount());
    assertEquals(3L, actualCopyOfResult.recipientCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Json#entityCount()}
   */
  @Test
  void testJsonEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationCreateSummary.Json()).entityCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Json#instanceCount()}
   */
  @Test
  void testJsonInstanceCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationCreateSummary.Json()).instanceCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationCreateSummary.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationCreateSummary.Json actualJson = new ImmutableAttestationCreateSummary.Json();

    // Assert
    assertEquals(0, actualJson.entityCount);
    assertEquals(0, actualJson.instanceCount);
    assertEquals(0L, actualJson.recipientCount);
    assertFalse(actualJson.entityCountIsSet);
    assertFalse(actualJson.instanceCountIsSet);
    assertFalse(actualJson.recipientCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Json#recipientCount()}
   */
  @Test
  void testJsonRecipientCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationCreateSummary.Json()).recipientCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Json#setEntityCount(int)}
   */
  @Test
  void testJsonSetEntityCount() {
    // Arrange
    ImmutableAttestationCreateSummary.Json json = new ImmutableAttestationCreateSummary.Json();

    // Act
    json.setEntityCount(3);

    // Assert
    assertEquals(3, json.entityCount);
    assertTrue(json.entityCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Json#setInstanceCount(int)}
   */
  @Test
  void testJsonSetInstanceCount() {
    // Arrange
    ImmutableAttestationCreateSummary.Json json = new ImmutableAttestationCreateSummary.Json();

    // Act
    json.setInstanceCount(3);

    // Assert
    assertEquals(3, json.instanceCount);
    assertTrue(json.instanceCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCreateSummary.Json#setRecipientCount(long)}
   */
  @Test
  void testJsonSetRecipientCount() {
    // Arrange
    ImmutableAttestationCreateSummary.Json json = new ImmutableAttestationCreateSummary.Json();

    // Act
    json.setRecipientCount(3L);

    // Assert
    assertEquals(3L, json.recipientCount);
    assertTrue(json.recipientCountIsSet);
  }
}
