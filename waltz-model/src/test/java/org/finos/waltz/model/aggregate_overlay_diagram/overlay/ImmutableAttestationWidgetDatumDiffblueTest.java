package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

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
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#addAllAttestations(Iterable)}
   */
  @Test
  void testBuilderAddAllAttestations() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAttestations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#addAttestations(AttestationEntry)}
   */
  @Test
  void testBuilderAddAttestations() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestations(new ImmutableAttestationEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#addAttestations(AttestationEntry[])}
   */
  @Test
  void testBuilderAddAttestations2() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestations(new ImmutableAttestationEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#attestations(Iterable)}
   */
  @Test
  void testBuilderAttestations() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act
    ImmutableAttestationWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#from(AttestationWidgetDatum)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAttestationWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#from(AttestationWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestations();
    verify(instance).cellExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#from(AttestationWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    HashSet<AttestationEntry> attestationEntrySet = new HashSet<>();
    attestationEntrySet.add(new ImmutableAttestationEntry.Json());
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(attestationEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAttestationWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    ImmutableAttestationWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.attestations().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttestationWidgetDatum.Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAttestationWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum#copyOf(AttestationWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAttestationWidgetDatum actualCopyOfResult = ImmutableAttestationWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.attestations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum#copyOf(AttestationWidgetDatum)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AttestationEntry> attestationEntrySet = new HashSet<>();
    attestationEntrySet.add(new ImmutableAttestationEntry.Json());
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(attestationEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAttestationWidgetDatum actualCopyOfResult = ImmutableAttestationWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(1, actualCopyOfResult.attestations().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum#copyOf(AttestationWidgetDatum)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AttestationEntry> attestationEntrySet = new HashSet<>();
    attestationEntrySet.add(new ImmutableAttestationEntry.Json());
    attestationEntrySet.add(new ImmutableAttestationEntry.Json());
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(attestationEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableAttestationWidgetDatum actualCopyOfResult = ImmutableAttestationWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(attestationEntrySet, actualCopyOfResult.attestations());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum#fromJson(ImmutableAttestationWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setAttestations(null);

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult = ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.attestations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum#fromJson(ImmutableAttestationWidgetDatum.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AttestationEntry> attestations = new LinkedHashSet<>();
    attestations.add(new ImmutableAttestationEntry.Json());

    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setAttestations(attestations);

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult = ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.attestations().size());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum#fromJson(ImmutableAttestationWidgetDatum.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AttestationEntry> attestations = new LinkedHashSet<>();
    attestations.add(new ImmutableAttestationEntry.Json());
    attestations.add(new ImmutableAttestationEntry.Json());

    ImmutableAttestationWidgetDatum.Json json = new ImmutableAttestationWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setAttestations(attestations);

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult = ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(attestations, actualFromJsonResult.attestations());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Json#attestations()}
   */
  @Test
  void testJsonAttestations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationWidgetDatum.Json()).attestations());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationWidgetDatum.Json actualJson = new ImmutableAttestationWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.attestations.isEmpty());
  }
}
