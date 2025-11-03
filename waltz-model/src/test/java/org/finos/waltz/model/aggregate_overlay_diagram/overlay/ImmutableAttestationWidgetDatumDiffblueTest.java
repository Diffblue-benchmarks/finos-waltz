package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAttestations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAttestations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAttestations(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAttestations(Iterable)"})
  void testBuilderAddAllAttestations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAttestations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAttestations(AttestationEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAttestationEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAttestations(AttestationEntry)}
   */
  @Test
  @DisplayName("Test Builder addAttestations(AttestationEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAttestations(AttestationEntry)"})
  void testBuilderAddAttestationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestations(new ImmutableAttestationEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addAttestations(AttestationEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAttestationEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAttestations(AttestationEntry[])}
   */
  @Test
  @DisplayName("Test Builder addAttestations(AttestationEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAttestations(AttestationEntry[])"})
  void testBuilderAddAttestationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAttestations(new ImmutableAttestationEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#attestations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#attestations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder attestations(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.attestations(Iterable)"})
  void testBuilderAttestations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetDatum)} with {@code AttestationWidgetDatum}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetDatum) with 'AttestationWidgetDatum'; given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetDatum)"})
  void testBuilderFromWithAttestationWidgetDatum_givenHashSet() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetDatum)} with {@code AttestationWidgetDatum}.
   * <ul>
   *   <li>Then builder build attestations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetDatum) with 'AttestationWidgetDatum'; then builder build attestations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetDatum)"})
  void testBuilderFromWithAttestationWidgetDatum_thenBuilderBuildAttestationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    HashSet<AttestationEntry> attestationEntrySet = new HashSet<>();
    attestationEntrySet.add(new ImmutableAttestationEntry.Json());
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenReturn(attestationEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).attestations();
    verify(instance).cellExternalId();
    ImmutableAttestationWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(1, buildResult.attestations().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetDatum)} with {@code AttestationWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetDatum) with 'AttestationWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetDatum)"})
  void testBuilderFromWithAttestationWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    AttestationWidgetDatum instance = mock(AttestationWidgetDatum.class);
    when(instance.attestations()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).attestations();
    verify(instance).cellExternalId();
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#attestations()}.
   * <p>
   * Method under test: {@link Json#attestations()}
   */
  @Test
  @DisplayName("Test Json attestations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.attestations()"})
  void testJsonAttestations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).attestations());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   * <p>
   * Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellExternalId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.attestations.isEmpty());
  }
}
