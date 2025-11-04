package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.ChangeDirection;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableApplicationChangeWidgetDatumDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addAllApplicationChanges(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationChanges() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationChanges(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addAllApplicationChanges(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationChanges2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult.addCurrentApplications(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationChanges(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addAllCurrentApplications(Iterable)}
   */
  @Test
  void testBuilderAddAllCurrentApplications() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCurrentApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addApplicationChanges(AppChangeEntry)}
   */
  @Test
  void testBuilderAddApplicationChanges() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addApplicationChanges(AppChangeEntry)}
   */
  @Test
  void testBuilderAddApplicationChanges2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult.addCurrentApplications(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addApplicationChanges(AppChangeEntry[])}
   */
  @Test
  void testBuilderAddApplicationChanges3() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addApplicationChanges(AppChangeEntry[])}
   */
  @Test
  void testBuilderAddApplicationChanges4() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult.addCurrentApplications(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addCurrentApplications(EntityReference)}
   */
  @Test
  void testBuilderAddCurrentApplications() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCurrentApplications(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#addCurrentApplications(EntityReference[])}
   */
  @Test
  void testBuilderAddCurrentApplications2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCurrentApplications(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#applicationChanges(Iterable)}
   */
  @Test
  void testBuilderApplicationChanges() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationChanges(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#applicationChanges(Iterable)}
   */
  @Test
  void testBuilderApplicationChanges2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult.addCurrentApplications(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.applicationChanges(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    ImmutableApplicationChangeWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

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
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#cellExternalId(String)}
   */
  @Test
  void testBuilderCellExternalId2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult.addCurrentApplications(mock(EntityReference.class));

    // Act
    ImmutableApplicationChangeWidgetDatum.Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableApplicationChangeWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0, buildResult.totalInboundCount());
    assertEquals(0, buildResult.totalOutboundCount());
    assertEquals(1, buildResult.currentApplications().size());
    assertEquals(1, buildResult.currentAppCount());
    assertTrue(buildResult.inboundCounts().isEmpty());
    assertTrue(buildResult.outboundCounts().isEmpty());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#currentApplications(Iterable)}
   */
  @Test
  void testBuilderCurrentApplications() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.currentApplications(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(new HashSet<>());
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
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
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationChanges();
    verify(instance).cellExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(appChangeEntrySet);
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(new HashSet<>());
    when(instance.currentApplications()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    ImmutableApplicationChangeWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0, buildResult.totalInboundCount());
    assertEquals(0, buildResult.totalOutboundCount());
    assertEquals(1, buildResult.currentApplications().size());
    assertEquals(1, buildResult.currentAppCount());
    assertTrue(buildResult.inboundCounts().isEmpty());
    assertTrue(buildResult.outboundCounts().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Builder#from(CellExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(new HashSet<>());
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum actualCopyOfResult = ImmutableApplicationChangeWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0, actualCopyOfResult.currentAppCount());
    assertEquals(0, actualCopyOfResult.totalInboundCount());
    assertEquals(0, actualCopyOfResult.totalOutboundCount());
    Set<AppChangeEntry> applicationChangesResult = actualCopyOfResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(actualCopyOfResult.inboundCounts().isEmpty());
    assertTrue(actualCopyOfResult.outboundCounts().isEmpty());
    assertSame(applicationChangesResult, actualCopyOfResult.currentApplications());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(new HashSet<>());
    when(instance.currentApplications()).thenReturn(entityReferenceSet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum actualCopyOfResult = ImmutableApplicationChangeWidgetDatum.copyOf(instance);

    // Assert
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0, actualCopyOfResult.totalInboundCount());
    assertEquals(0, actualCopyOfResult.totalOutboundCount());
    assertEquals(1, actualCopyOfResult.currentApplications().size());
    assertEquals(1, actualCopyOfResult.currentAppCount());
    assertTrue(actualCopyOfResult.applicationChanges().isEmpty());
    assertTrue(actualCopyOfResult.inboundCounts().isEmpty());
    assertTrue(actualCopyOfResult.outboundCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AppChangeEntry appChangeEntry = mock(AppChangeEntry.class);
    when(appChangeEntry.date()).thenReturn(LocalDate.of(1970, 1, 1));
    when(appChangeEntry.changeDirection()).thenReturn(ChangeDirection.INBOUND);

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(appChangeEntry);
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(appChangeEntrySet);
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum actualCopyOfResult = ImmutableApplicationChangeWidgetDatum.copyOf(instance);

    // Assert
    verify(appChangeEntry, atLeast(1)).changeDirection();
    verify(appChangeEntry).date();
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0, actualCopyOfResult.currentAppCount());
    assertEquals(0, actualCopyOfResult.totalOutboundCount());
    assertEquals(1, actualCopyOfResult.applicationChanges().size());
    assertEquals(1, actualCopyOfResult.inboundCounts().size());
    assertEquals(1, actualCopyOfResult.totalInboundCount());
    assertTrue(actualCopyOfResult.currentApplications().isEmpty());
    assertTrue(actualCopyOfResult.outboundCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AppChangeEntry appChangeEntry = mock(AppChangeEntry.class);
    when(appChangeEntry.date()).thenReturn(LocalDate.now());
    when(appChangeEntry.changeDirection()).thenReturn(ChangeDirection.INBOUND);

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(appChangeEntry);
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(appChangeEntrySet);
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum actualCopyOfResult = ImmutableApplicationChangeWidgetDatum.copyOf(instance);

    // Assert
    verify(appChangeEntry, atLeast(1)).changeDirection();
    verify(appChangeEntry).date();
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0, actualCopyOfResult.currentAppCount());
    assertEquals(0, actualCopyOfResult.totalOutboundCount());
    assertEquals(1, actualCopyOfResult.applicationChanges().size());
    assertEquals(1, actualCopyOfResult.inboundCounts().size());
    assertEquals(1, actualCopyOfResult.totalInboundCount());
    assertTrue(actualCopyOfResult.currentApplications().isEmpty());
    assertTrue(actualCopyOfResult.outboundCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AppChangeEntry appChangeEntry = mock(AppChangeEntry.class);
    when(appChangeEntry.date()).thenReturn(LocalDate.of(1970, 1, 1));
    when(appChangeEntry.changeDirection()).thenReturn(ChangeDirection.OUTBOUND);

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(appChangeEntry);
    ApplicationChangeWidgetDatum instance = mock(ApplicationChangeWidgetDatum.class);
    when(instance.applicationChanges()).thenReturn(appChangeEntrySet);
    when(instance.currentApplications()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    ImmutableApplicationChangeWidgetDatum actualCopyOfResult = ImmutableApplicationChangeWidgetDatum.copyOf(instance);

    // Assert
    verify(appChangeEntry, atLeast(1)).changeDirection();
    verify(appChangeEntry).date();
    verify(instance).applicationChanges();
    verify(instance).currentApplications();
    verify(instance).cellExternalId();
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0, actualCopyOfResult.currentAppCount());
    assertEquals(0, actualCopyOfResult.totalInboundCount());
    assertEquals(1, actualCopyOfResult.applicationChanges().size());
    assertEquals(1, actualCopyOfResult.outboundCounts().size());
    assertEquals(1, actualCopyOfResult.totalOutboundCount());
    assertTrue(actualCopyOfResult.currentApplications().isEmpty());
    assertTrue(actualCopyOfResult.inboundCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#fromJson(ImmutableApplicationChangeWidgetDatum.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum.Json json = new ImmutableApplicationChangeWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(null);
    json.setCurrentApplications(null);

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult = ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(0, actualFromJsonResult.currentAppCount());
    assertEquals(0, actualFromJsonResult.totalInboundCount());
    assertEquals(0, actualFromJsonResult.totalOutboundCount());
    Set<AppChangeEntry> applicationChangesResult = actualFromJsonResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(actualFromJsonResult.inboundCounts().isEmpty());
    assertTrue(actualFromJsonResult.outboundCounts().isEmpty());
    assertSame(applicationChangesResult, actualFromJsonResult.currentApplications());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum#fromJson(ImmutableApplicationChangeWidgetDatum.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<EntityReference> currentApplications = new LinkedHashSet<>();
    currentApplications.add(mock(EntityReference.class));

    ImmutableApplicationChangeWidgetDatum.Json json = new ImmutableApplicationChangeWidgetDatum.Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(null);
    json.setCurrentApplications(currentApplications);

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult = ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(0, actualFromJsonResult.totalInboundCount());
    assertEquals(0, actualFromJsonResult.totalOutboundCount());
    assertEquals(1, actualFromJsonResult.currentApplications().size());
    assertEquals(1, actualFromJsonResult.currentAppCount());
    assertTrue(actualFromJsonResult.applicationChanges().isEmpty());
    assertTrue(actualFromJsonResult.inboundCounts().isEmpty());
    assertTrue(actualFromJsonResult.outboundCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#applicationChanges()}
   */
  @Test
  void testJsonApplicationChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).applicationChanges());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#cellExternalId()}
   */
  @Test
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).cellExternalId());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#currentAppCount()}
   */
  @Test
  void testJsonCurrentAppCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).currentAppCount());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#currentApplications()}
   */
  @Test
  void testJsonCurrentApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).currentApplications());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#inboundCounts()}
   */
  @Test
  void testJsonInboundCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).inboundCounts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableApplicationChangeWidgetDatum.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableApplicationChangeWidgetDatum.Json actualJson = new ImmutableApplicationChangeWidgetDatum.Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.applicationChanges.isEmpty());
    assertTrue(actualJson.currentApplications.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#outboundCounts()}
   */
  @Test
  void testJsonOutboundCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).outboundCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#totalInboundCount()}
   */
  @Test
  void testJsonTotalInboundCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).totalInboundCount());
  }

  /**
   * Method under test:
   * {@link ImmutableApplicationChangeWidgetDatum.Json#totalOutboundCount()}
   */
  @Test
  void testJsonTotalOutboundCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableApplicationChangeWidgetDatum.Json()).totalOutboundCount());
  }
}
