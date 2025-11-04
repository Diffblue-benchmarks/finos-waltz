package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationSummaryCountsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#builder()}
   *   <li>{@link ImmutableApplicationAttestationSummaryCounts#attestedId(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableApplicationAttestationSummaryCounts.Builder actualBuilderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.attestedId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#addAllAttestationCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllAttestationCounts() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAttestationCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#addAttestationCounts(AttestationCount)}
   */
  @Test
  void testBuilderAddAttestationCounts() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestationCounts(new ImmutableAttestationCount.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#addAttestationCounts(AttestationCount[])}
   */
  @Test
  void testBuilderAddAttestationCounts2() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestationCounts(new ImmutableAttestationCount.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#attestationCounts(Iterable)}
   */
  @Test
  void testBuilderAttestationCounts() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestationCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#attestedKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedKind() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    // Act
    ImmutableApplicationAttestationSummaryCounts.Builder actualAttestedKindResult = builderResult
        .attestedKind(EntityKind.ALL);

    // Assert
    ImmutableApplicationAttestationSummaryCounts buildResult = builderResult.build();
    assertNull(buildResult.attestedId());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertSame(builderResult, actualAttestedKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(new HashSet<>());
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplicationAttestationSummaryCounts.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    ImmutableApplicationAttestationSummaryCounts buildResult = builderResult.build();
    assertEquals(1L, buildResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenThrow(new IllegalStateException("instance"));
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestedId();
    verify(instance).attestedKind();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(null);
    when(instance.attestationCounts()).thenReturn(new HashSet<>());
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplicationAttestationSummaryCounts.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    ImmutableApplicationAttestationSummaryCounts buildResult = builderResult.build();
    assertNull(buildResult.attestedId());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Builder#from(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Builder builderResult = ImmutableApplicationAttestationSummaryCounts
        .builder();

    HashSet<AttestationCount> attestationCountSet = new HashSet<>();
    attestationCountSet.add(new ImmutableAttestationCount.Json());
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(attestationCountSet);
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplicationAttestationSummaryCounts.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    ImmutableApplicationAttestationSummaryCounts buildResult = builderResult.build();
    assertEquals(1, buildResult.attestationCounts().size());
    assertEquals(1L, buildResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, buildResult.attestedKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts#copyOf(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(new HashSet<>());
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualCopyOfResult = ImmutableApplicationAttestationSummaryCounts
        .copyOf(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    assertEquals(1L, actualCopyOfResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedKind());
    assertTrue(actualCopyOfResult.attestationCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts#copyOf(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AttestationCount> attestationCountSet = new HashSet<>();
    attestationCountSet.add(new ImmutableAttestationCount.Json());
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(attestationCountSet);
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualCopyOfResult = ImmutableApplicationAttestationSummaryCounts
        .copyOf(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    assertEquals(1, actualCopyOfResult.attestationCounts().size());
    assertEquals(1L, actualCopyOfResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedKind());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts#copyOf(ApplicationAttestationSummaryCounts)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AttestationCount> attestationCountSet = new HashSet<>();
    attestationCountSet.add(new ImmutableAttestationCount.Json());
    attestationCountSet.add(new ImmutableAttestationCount.Json());
    ApplicationAttestationSummaryCounts instance = mock(ApplicationAttestationSummaryCounts.class);
    when(instance.attestedId()).thenReturn(1L);
    when(instance.attestationCounts()).thenReturn(attestationCountSet);
    when(instance.attestedKind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualCopyOfResult = ImmutableApplicationAttestationSummaryCounts
        .copyOf(instance);

    // Assert
    verify(instance).attestationCounts();
    verify(instance).attestedId();
    verify(instance).attestedKind();
    assertEquals(1L, actualCopyOfResult.attestedId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedKind());
    assertEquals(attestationCountSet, actualCopyOfResult.attestationCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts#fromJson(ImmutableApplicationAttestationSummaryCounts.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationAttestationSummaryCounts.Json json = new ImmutableApplicationAttestationSummaryCounts.Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(null);
    json.setAttestationCounts(null);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult = ImmutableApplicationAttestationSummaryCounts
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedKind());
    assertTrue(actualFromJsonResult.attestationCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts#fromJson(ImmutableApplicationAttestationSummaryCounts.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AttestationCount> attestationCounts = new LinkedHashSet<>();
    attestationCounts.add(new ImmutableAttestationCount.Json());

    ImmutableApplicationAttestationSummaryCounts.Json json = new ImmutableApplicationAttestationSummaryCounts.Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(null);
    json.setAttestationCounts(attestationCounts);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult = ImmutableApplicationAttestationSummaryCounts
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedId());
    assertEquals(1, actualFromJsonResult.attestationCounts().size());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedKind());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts#fromJson(ImmutableApplicationAttestationSummaryCounts.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AttestationCount> attestationCounts = new LinkedHashSet<>();
    attestationCounts.add(new ImmutableAttestationCount.Json());
    attestationCounts.add(new ImmutableAttestationCount.Json());

    ImmutableApplicationAttestationSummaryCounts.Json json = new ImmutableApplicationAttestationSummaryCounts.Json();
    json.setAttestedKind(EntityKind.ALL);
    json.setAttestedId(null);
    json.setAttestationCounts(attestationCounts);

    // Act
    ImmutableApplicationAttestationSummaryCounts actualFromJsonResult = ImmutableApplicationAttestationSummaryCounts
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedKind());
    assertEquals(attestationCounts, actualFromJsonResult.attestationCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Json#attestationCounts()}
   */
  @Test
  void testJsonAttestationCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryCounts.Json()).attestationCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Json#attestedId()}
   */
  @Test
  void testJsonAttestedId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryCounts.Json()).attestedId());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationAttestationSummaryCounts.Json#attestedKind()}
   */
  @Test
  void testJsonAttestedKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationAttestationSummaryCounts.Json()).attestedKind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationAttestationSummaryCounts.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationAttestationSummaryCounts.Json actualJson = new ImmutableApplicationAttestationSummaryCounts.Json();

    // Assert
    assertNull(actualJson.attestedId);
    assertNull(actualJson.attestedKind);
    assertTrue(actualJson.attestationCounts.isEmpty());
  }
}
