package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAttestationCountDiffblueTest {
  /**
   * Method under test: {@link ImmutableAttestationCount.Builder#count(Integer)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableAttestationCount.Builder builderResult = ImmutableAttestationCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCount.Builder#from(AttestationCount)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationCount.Builder builderResult = ImmutableAttestationCount.builder();
    AttestationCount instance = mock(AttestationCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableAttestationCount.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).key();
    ImmutableAttestationCount buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals(3, buildResult.count().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCount.Builder#from(AttestationCount)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationCount.Builder builderResult = ImmutableAttestationCount.builder();
    AttestationCount instance = mock(AttestationCount.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).key();
  }

  /**
   * Method under test: {@link ImmutableAttestationCount.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableAttestationCount.Builder builderResult = ImmutableAttestationCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableAttestationCount#copyOf(AttestationCount)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationCount instance = mock(AttestationCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.key()).thenReturn("Key");

    // Act
    ImmutableAttestationCount actualCopyOfResult = ImmutableAttestationCount.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).key();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals(3, actualCopyOfResult.count().intValue());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationCount#fromJson(ImmutableAttestationCount.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAttestationCount.Json json = new ImmutableAttestationCount.Json();
    json.setKey("Json");
    json.setCount(1);

    // Act
    ImmutableAttestationCount actualFromJsonResult = ImmutableAttestationCount.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.key());
    assertEquals(1, actualFromJsonResult.count().intValue());
  }

  /**
   * Method under test: {@link ImmutableAttestationCount.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationCount.Json()).count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAttestationCount.Json}
   *   <li>{@link ImmutableAttestationCount.Json#setCount(Integer)}
   *   <li>{@link ImmutableAttestationCount.Json#setKey(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAttestationCount.Json actualJson = new ImmutableAttestationCount.Json();
    actualJson.setCount(3);
    actualJson.setKey("Key");

    // Assert
    assertEquals(3, actualJson.count.intValue());
  }

  /**
   * Method under test: {@link ImmutableAttestationCount.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationCount.Json()).key());
  }
}
