package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAttestations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAttestations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAttestations(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAttestations(Iterable)"})
  void testBuilderAddAllAttestations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act
    Builder actualAddAllAttestationsResult = builderResult.addAllAttestations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAttestationsResult);
  }

  /**
   * Test Builder {@link Builder#addAttestations(AttestationEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAttestations(AttestationEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addAttestations(AttestationEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAttestations(AttestationEntry)"})
  void testBuilderAddAttestationsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act
    Builder actualAddAttestationsResult =
        builderResult.addAttestations(new ImmutableAttestationEntry.Json());

    // Assert
    assertSame(builderResult, actualAddAttestationsResult);
  }

  /**
   * Test Builder {@link Builder#addAttestations(AttestationEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAttestations(AttestationEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAttestations(AttestationEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAttestations(AttestationEntry[])"})
  void testBuilderAddAttestationsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act
    Builder actualAddAttestationsResult =
        builderResult.addAttestations(new ImmutableAttestationEntry.Json());

    // Assert
    assertSame(builderResult, actualAddAttestationsResult);
  }

  /**
   * Test Builder {@link Builder#attestations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#attestations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder attestations(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestations(Iterable)"})
  void testBuilderAttestations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    // Act
    Builder actualAttestationsResult = builderResult.attestations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAttestationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAttestationWidgetDatum actualImmutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableAttestationWidgetDatum.cellExternalId());
    assertTrue(actualImmutableAttestationWidgetDatum.attestations().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder cellExternalId(String); when '42'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenBuilderBuildCellExternalIdIs42() {
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
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetDatum) with 'AttestationWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetDatum)"})
  void testBuilderFromWithAttestationWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    ImmutableAttestationWidgetDatum instance =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationWidgetDatum actualImmutableAttestationWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationWidgetDatum)} with {@code AttestationWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationWidgetDatum) with 'AttestationWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationWidgetDatum)"})
  void testBuilderFromWithAttestationWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    Builder builderResult2 = ImmutableAttestationWidgetDatum.builder();
    builderResult2.addAttestations(
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
    ImmutableAttestationWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationWidgetDatum actualImmutableAttestationWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    ImmutableAttestationWidgetDatum instance =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    ImmutableAttestationWidgetDatum actualImmutableAttestationWidgetDatum =
        builderResult.from((CellExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationWidgetDatum);
    ImmutableAttestationWidgetDatum actualImmutableAttestationWidgetDatum2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetDatum2);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();

    Builder builderResult2 = ImmutableAttestationWidgetDatum.builder();
    builderResult2.addAttestations(
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
    ImmutableAttestationWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableAttestationWidgetDatum actualImmutableAttestationWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableAttestationWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ImmutableAttestationWidgetDatum#copyOf(AttestationWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#copyOf(AttestationWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.copyOf(AttestationWidgetDatum)"
  })
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableAttestationWidgetDatum instance =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAttestationWidgetDatum actualCopyOfResult =
        ImmutableAttestationWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.attestations().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#equals(Object)}, and {@link
   * ImmutableAttestationWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetDatum.equals(Object)",
    "int ImmutableAttestationWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum2 =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableAttestationWidgetDatum, immutableAttestationWidgetDatum2);
    assertEquals(
        immutableAttestationWidgetDatum.hashCode(), immutableAttestationWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#equals(Object)}, and {@link
   * ImmutableAttestationWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableAttestationWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetDatum.equals(Object)",
    "int ImmutableAttestationWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableAttestationWidgetDatum, immutableAttestationWidgetDatum);
    int expectedHashCodeResult = immutableAttestationWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetDatum.equals(Object)",
    "int ImmutableAttestationWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationWidgetDatum.builder();
    builderResult.addAttestations(
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationWidgetDatum,
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetDatum.equals(Object)",
    "int ImmutableAttestationWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("Cell External Id").build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationWidgetDatum,
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetDatum.equals(Object)",
    "int ImmutableAttestationWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationWidgetDatum.equals(Object)",
    "int ImmutableAttestationWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableAttestationWidgetDatum");
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Attestations is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Attestations is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAttestationsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAttestations(new HashSet<>());

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult =
        ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.attestations().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableAttestationEntry.Json}
   *       (default constructor).
   *   <li>Then return attestations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return attestations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnAttestationsSizeIsOne() {
    // Arrange
    LinkedHashSet<AttestationEntry> attestations = new LinkedHashSet<>();
    attestations.add(new ImmutableAttestationEntry.Json());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAttestations(attestations);

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult =
        ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.attestations().size());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Attestations is {@code null}.
   *   <li>Then return attestations Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Attestations is 'null'; then return attestations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonAttestationsIsNull_thenReturnAttestationsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAttestations(null);

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult =
        ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.attestations().isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return attestations is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return attestations is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnAttestationsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AttestationEntry> attestations = new LinkedHashSet<>();
    attestations.add(
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
    attestations.add(new ImmutableAttestationEntry.Json());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setAttestations(attestations);

    // Act
    ImmutableAttestationWidgetDatum actualFromJsonResult =
        ImmutableAttestationWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(attestations, actualFromJsonResult.attestations());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationWidgetDatum#toString()}
   *   <li>{@link ImmutableAttestationWidgetDatum#attestations()}
   *   <li>{@link ImmutableAttestationWidgetDatum#cellExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAttestationWidgetDatum.attestations()",
    "String ImmutableAttestationWidgetDatum.cellExternalId()",
    "String ImmutableAttestationWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableAttestationWidgetDatum.toString();
    Set<AttestationEntry> actualAttestationsResult = immutableAttestationWidgetDatum.attestations();

    // Assert
    assertEquals("42", immutableAttestationWidgetDatum.cellExternalId());
    assertEquals(
        "AttestationWidgetDatum{cellExternalId=42, attestations=[]}", actualToStringResult);
    assertTrue(actualAttestationsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#attestations()}.
   *
   * <p>Method under test: {@link Json#attestations()}
   */
  @Test
  @DisplayName("Test Json attestations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.attestations()"})
  void testJsonAttestations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestations());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.attestations.isEmpty());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#withAttestations(AttestationEntry[])} with {@code
   * AttestationEntry[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationWidgetDatum#withAttestations(AttestationEntry[])}
   */
  @Test
  @DisplayName("Test withAttestations(AttestationEntry[]) with 'AttestationEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.withAttestations(AttestationEntry[])"
  })
  void testWithAttestationsWithAttestationEntry() {
    // Arrange
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAttestationWidgetDatum actualWithAttestationsResult =
        immutableAttestationWidgetDatum.withAttestations(
            ImmutableAttestationEntry.builder()
                .appId(1L)
                .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .attestedBy("Attested By")
                .build());

    // Assert
    assertEquals("42", actualWithAttestationsResult.cellExternalId());
    assertEquals(1, actualWithAttestationsResult.attestations().size());
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableAttestationWidgetDatum immutableAttestationWidgetDatum =
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableAttestationWidgetDatum actualWithCellExternalIdResult =
        immutableAttestationWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableAttestationWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableAttestationWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationWidgetDatum ImmutableAttestationWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAttestationWidgetDatum actualWithCellExternalIdResult =
        ImmutableAttestationWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertTrue(actualWithCellExternalIdResult.attestations().isEmpty());
  }
}
