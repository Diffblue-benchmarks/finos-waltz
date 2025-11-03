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
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationChangeWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplicationChanges(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationChanges(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationChanges(Iterable)"})
  void testBuilderAddAllApplicationChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationChanges(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllCurrentApplications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCurrentApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCurrentApplications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCurrentApplications(Iterable)"})
  void testBuilderAddAllCurrentApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCurrentApplications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplicationChanges(AppChangeEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplicationChanges(AppChangeEntry)}
   */
  @Test
  @DisplayName("Test Builder addApplicationChanges(AppChangeEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplicationChanges(AppChangeEntry)"})
  void testBuilderAddApplicationChangesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addApplicationChanges(AppChangeEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplicationChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName("Test Builder addApplicationChanges(AppChangeEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplicationChanges(AppChangeEntry[])"})
  void testBuilderAddApplicationChangesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addCurrentApplications(EntityReference)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCurrentApplications(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addCurrentApplications(EntityReference) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCurrentApplications(EntityReference)"})
  void testBuilderAddCurrentApplicationsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCurrentApplications(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addCurrentApplications(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addCurrentApplications(EntityReference[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCurrentApplications(EntityReference[])"})
  void testBuilderAddCurrentApplicationsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCurrentApplications(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#applicationChanges(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationChanges(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationChanges(Iterable)"})
  void testBuilderApplicationChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationChanges(new ArrayList<>()));
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
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableApplicationChangeWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0, buildResult.currentAppCount());
    assertEquals(0, buildResult.totalInboundCount());
    assertEquals(0, buildResult.totalOutboundCount());
    assertTrue(buildResult.inboundCounts().isEmpty());
    assertTrue(buildResult.outboundCounts().isEmpty());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#currentApplications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#currentApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder currentApplications(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.currentApplications(Iterable)"})
  void testBuilderCurrentApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.currentApplications(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code ApplicationChangeWidgetDatum}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(new HashSet<>());
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    ImmutableApplicationChangeWidgetDatum buildResult = actualFromResult.build();
    assertEquals("42", buildResult.cellExternalId());
    ImmutableApplicationChangeWidgetDatum buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.cellExternalId());
    assertEquals(0, buildResult.currentAppCount());
    assertEquals(0, buildResult2.currentAppCount());
    assertEquals(0, buildResult.totalInboundCount());
    assertEquals(0, buildResult2.totalInboundCount());
    assertEquals(0, buildResult.totalOutboundCount());
    assertEquals(0, buildResult2.totalOutboundCount());
    Set<AppChangeEntry> applicationChangesResult = buildResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(buildResult.inboundCounts().isEmpty());
    assertTrue(buildResult2.inboundCounts().isEmpty());
    assertTrue(buildResult.outboundCounts().isEmpty());
    assertTrue(buildResult2.outboundCounts().isEmpty());
    assertSame(applicationChangesResult, buildResult.currentApplications());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code ApplicationChangeWidgetDatum}.
   * <p>
   * Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(new HashSet<>());
    when(instance.currentApplications()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    ImmutableApplicationChangeWidgetDatum buildResult = actualFromResult.build();
    assertEquals(1, buildResult.currentApplications().size());
    ImmutableApplicationChangeWidgetDatum buildResult2 = builderResult.build();
    assertEquals(1, buildResult2.currentApplications().size());
    assertEquals(1, buildResult.currentAppCount());
    assertEquals(1, buildResult2.currentAppCount());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code ApplicationChangeWidgetDatum}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(appChangeEntrySet);
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code ApplicationChangeWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationChanges();
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
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    ImmutableApplicationChangeWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0, buildResult.currentAppCount());
    assertEquals(0, buildResult.totalInboundCount());
    assertEquals(0, buildResult.totalOutboundCount());
    assertTrue(buildResult.inboundCounts().isEmpty());
    assertTrue(buildResult.outboundCounts().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#applicationChanges()}.
   * <p>
   * Method under test: {@link Json#applicationChanges()}
   */
  @Test
  @DisplayName("Test Json applicationChanges()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.applicationChanges()"})
  void testJsonApplicationChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationChanges());
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
   * Test Json {@link Json#currentAppCount()}.
   * <p>
   * Method under test: {@link Json#currentAppCount()}
   */
  @Test
  @DisplayName("Test Json currentAppCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.currentAppCount()"})
  void testJsonCurrentAppCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).currentAppCount());
  }

  /**
   * Test Json {@link Json#currentApplications()}.
   * <p>
   * Method under test: {@link Json#currentApplications()}
   */
  @Test
  @DisplayName("Test Json currentApplications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.currentApplications()"})
  void testJsonCurrentApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).currentApplications());
  }

  /**
   * Test Json {@link Json#inboundCounts()}.
   * <p>
   * Method under test: {@link Json#inboundCounts()}
   */
  @Test
  @DisplayName("Test Json inboundCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.inboundCounts()"})
  void testJsonInboundCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inboundCounts());
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
    assertTrue(actualJson.applicationChanges.isEmpty());
    assertTrue(actualJson.currentApplications.isEmpty());
  }

  /**
   * Test Json {@link Json#outboundCounts()}.
   * <p>
   * Method under test: {@link Json#outboundCounts()}
   */
  @Test
  @DisplayName("Test Json outboundCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.outboundCounts()"})
  void testJsonOutboundCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).outboundCounts());
  }

  /**
   * Test Json {@link Json#totalInboundCount()}.
   * <p>
   * Method under test: {@link Json#totalInboundCount()}
   */
  @Test
  @DisplayName("Test Json totalInboundCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.totalInboundCount()"})
  void testJsonTotalInboundCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalInboundCount());
  }

  /**
   * Test Json {@link Json#totalOutboundCount()}.
   * <p>
   * Method under test: {@link Json#totalOutboundCount()}
   */
  @Test
  @DisplayName("Test Json totalOutboundCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.totalOutboundCount()"})
  void testJsonTotalOutboundCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalOutboundCount());
  }
}
