package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ImmutableAttestationEntryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationEntry#builder()}
   *   <li>{@link ImmutableAttestationEntry#attestedAt(LocalDateTime)}
   *   <li>{@link ImmutableAttestationEntry#attestedBy(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAttestationEntry.Builder actualBuilderResult = ImmutableAttestationEntry.builder();
    ImmutableAttestationEntry.Builder actualAttestedAtResult = actualBuilderResult
        .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualAttestedAtResult, actualAttestedAtResult.attestedBy("Attested By"));
  }

  /**
   * Method under test: {@link ImmutableAttestationEntry.Builder#appId(long)}
   */
  @Test
  void testBuilderAppId() {
    // Arrange
    ImmutableAttestationEntry.Builder builderResult = ImmutableAttestationEntry.builder();

    // Act
    ImmutableAttestationEntry.Builder actualAppIdResult = builderResult.appId(1L);

    // Assert
    ImmutableAttestationEntry buildResult = builderResult.build();
    assertNull(buildResult.attestedBy());
    assertNull(buildResult.attestedAt());
    assertEquals(1L, buildResult.appId());
    assertSame(builderResult, actualAppIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationEntry.Builder#from(AttestationEntry)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationEntry.Builder builderResult = ImmutableAttestationEntry.builder();
    AttestationEntry instance = mock(AttestationEntry.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    when(instance.attestedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.appId()).thenReturn(1L);

    // Act
    ImmutableAttestationEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    ImmutableAttestationEntry buildResult = builderResult.build();
    assertEquals("Attested By", buildResult.attestedBy());
    assertEquals(1L, buildResult.appId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationEntry.Builder#from(AttestationEntry)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationEntry.Builder builderResult = ImmutableAttestationEntry.builder();
    AttestationEntry instance = mock(AttestationEntry.class);
    when(instance.attestedBy()).thenReturn(null);
    when(instance.attestedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.appId()).thenReturn(1L);

    // Act
    ImmutableAttestationEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    ImmutableAttestationEntry buildResult = builderResult.build();
    assertNull(buildResult.attestedBy());
    assertEquals(1L, buildResult.appId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationEntry#copyOf(AttestationEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationEntry instance = mock(AttestationEntry.class);
    when(instance.attestedBy()).thenReturn("Attested By");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.attestedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.appId()).thenReturn(1L);

    // Act
    ImmutableAttestationEntry actualCopyOfResult = ImmutableAttestationEntry.copyOf(instance);

    // Assert
    verify(instance).appId();
    verify(instance).attestedAt();
    verify(instance).attestedBy();
    LocalDateTime attestedAtResult = actualCopyOfResult.attestedAt();
    assertEquals("00:00", attestedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = attestedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Attested By", actualCopyOfResult.attestedBy());
    assertEquals(1L, actualCopyOfResult.appId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationEntry.Json#appId()}
   */
  @Test
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationEntry.Json()).appId());
  }

  /**
   * Method under test: {@link ImmutableAttestationEntry.Json#attestedAt()}
   */
  @Test
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationEntry.Json()).attestedAt());
  }

  /**
   * Method under test: {@link ImmutableAttestationEntry.Json#attestedBy()}
   */
  @Test
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationEntry.Json()).attestedBy());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAttestationEntry.Json}
   *   <li>{@link ImmutableAttestationEntry.Json#setAttestedAt(LocalDateTime)}
   *   <li>{@link ImmutableAttestationEntry.Json#setAttestedBy(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAttestationEntry.Json actualJson = new ImmutableAttestationEntry.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setAttestedAt(ofResult.atStartOfDay());
    actualJson.setAttestedBy("Attested By");

    // Assert
    LocalDateTime localDateTime = actualJson.attestedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationEntry.Json#setAppId(long)}
   */
  @Test
  void testJsonSetAppId() {
    // Arrange
    ImmutableAttestationEntry.Json json = new ImmutableAttestationEntry.Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }
}
