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
import org.finos.waltz.model.ChangeDirection;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationChangeWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplicationChanges(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationChanges(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllApplicationChanges(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationChanges(Iterable)"})
  void testBuilderAddAllApplicationChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualAddAllApplicationChangesResult =
        builderResult.addAllApplicationChanges(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationChangesResult);
  }

  /**
   * Test Builder {@link Builder#addAllCurrentApplications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCurrentApplications(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllCurrentApplications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCurrentApplications(Iterable)"})
  void testBuilderAddAllCurrentApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualAddAllCurrentApplicationsResult =
        builderResult.addAllCurrentApplications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCurrentApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addApplicationChanges(AppChangeEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplicationChanges(AppChangeEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addApplicationChanges(AppChangeEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicationChanges(AppChangeEntry)"})
  void testBuilderAddApplicationChangesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualAddApplicationChangesResult =
        builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json());

    // Assert
    assertSame(builderResult, actualAddApplicationChangesResult);
  }

  /**
   * Test Builder {@link Builder#addApplicationChanges(AppChangeEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addApplicationChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addApplicationChanges(AppChangeEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicationChanges(AppChangeEntry[])"})
  void testBuilderAddApplicationChangesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualAddApplicationChangesResult =
        builderResult.addApplicationChanges(new ImmutableAppChangeEntry.Json());

    // Assert
    assertSame(builderResult, actualAddApplicationChangesResult);
  }

  /**
   * Test Builder {@link Builder#addCurrentApplications(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCurrentApplications(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addCurrentApplications(EntityReference) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCurrentApplications(EntityReference)"})
  void testBuilderAddCurrentApplicationsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualAddCurrentApplicationsResult =
        builderResult.addCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAddCurrentApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addCurrentApplications(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCurrentApplications(EntityReference[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCurrentApplications(EntityReference[])"})
  void testBuilderAddCurrentApplicationsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualAddCurrentApplicationsResult =
        builderResult.addCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualAddCurrentApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#applicationChanges(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationChanges(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationChanges(Iterable)"})
  void testBuilderApplicationChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualApplicationChangesResult = builderResult.applicationChanges(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicationChangesResult);
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
  @MethodsUnderTest({"ImmutableApplicationChangeWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableApplicationChangeWidgetDatum actualImmutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableApplicationChangeWidgetDatum.cellExternalId());
    assertEquals(0, actualImmutableApplicationChangeWidgetDatum.currentAppCount());
    assertEquals(0, actualImmutableApplicationChangeWidgetDatum.totalInboundCount());
    assertEquals(0, actualImmutableApplicationChangeWidgetDatum.totalOutboundCount());
    assertTrue(actualImmutableApplicationChangeWidgetDatum.applicationChanges().isEmpty());
    assertTrue(actualImmutableApplicationChangeWidgetDatum.inboundCounts().isEmpty());
    assertTrue(actualImmutableApplicationChangeWidgetDatum.outboundCounts().isEmpty());
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
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.build();
    assertEquals("42", immutableApplicationChangeWidgetDatum.cellExternalId());
    assertEquals(0, immutableApplicationChangeWidgetDatum.currentAppCount());
    assertEquals(0, immutableApplicationChangeWidgetDatum.totalInboundCount());
    assertEquals(0, immutableApplicationChangeWidgetDatum.totalOutboundCount());
    assertTrue(immutableApplicationChangeWidgetDatum.inboundCounts().isEmpty());
    assertTrue(immutableApplicationChangeWidgetDatum.outboundCounts().isEmpty());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#currentApplications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#currentApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder currentApplications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.currentApplications(Iterable)"})
  void testBuilderCurrentApplications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act
    Builder actualCurrentApplicationsResult = builderResult.currentApplications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCurrentApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code
   * ApplicationChangeWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    // Act and Assert
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult
            .from(ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build())
            .build();
    assertEquals(0, immutableApplicationChangeWidgetDatum.totalInboundCount());
    Set<AppChangeEntry> applicationChangesResult =
        immutableApplicationChangeWidgetDatum.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(immutableApplicationChangeWidgetDatum.inboundCounts().isEmpty());
    assertSame(
        applicationChangesResult, immutableApplicationChangeWidgetDatum.currentApplications());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code
   * ApplicationChangeWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    Builder builderResult2 = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult3 = ImmutableAppChangeEntry.builder();
    builderResult2.addApplicationChanges(
        builderResult3
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    // Act and Assert
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.from(builderResult2.cellExternalId("42").build()).build();
    assertEquals(1, immutableApplicationChangeWidgetDatum.applicationChanges().size());
    assertEquals(1, immutableApplicationChangeWidgetDatum.inboundCounts().size());
    assertEquals(1, immutableApplicationChangeWidgetDatum.totalInboundCount());
    assertTrue(immutableApplicationChangeWidgetDatum.currentApplications().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ApplicationChangeWidgetDatum)} with {@code
   * ApplicationChangeWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationChangeWidgetDatum) with 'ApplicationChangeWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationChangeWidgetDatum)"})
  void testBuilderFromWithApplicationChangeWidgetDatum3() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    Builder builderResult2 = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult2.addCurrentApplications(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    ImmutableAppChangeEntry.Builder builderResult3 = ImmutableAppChangeEntry.builder();
    builderResult2.addApplicationChanges(
        builderResult3
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableApplicationChangeWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationChangeWidgetDatum actualImmutableApplicationChangeWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationChangeWidgetDatum);
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
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    ImmutableApplicationChangeWidgetDatum instance =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableApplicationChangeWidgetDatum actualImmutableApplicationChangeWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationChangeWidgetDatum);
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
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.build();
    assertEquals("42", immutableApplicationChangeWidgetDatum.cellExternalId());
    assertEquals(0, immutableApplicationChangeWidgetDatum.currentAppCount());
    assertEquals(0, immutableApplicationChangeWidgetDatum.totalInboundCount());
    assertEquals(0, immutableApplicationChangeWidgetDatum.totalOutboundCount());
    assertTrue(immutableApplicationChangeWidgetDatum.inboundCounts().isEmpty());
    assertTrue(immutableApplicationChangeWidgetDatum.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#copyOf(ApplicationChangeWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationChangeWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.copyOf(ApplicationChangeWidgetDatum)"
  })
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum instance =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualCopyOfResult =
        ImmutableApplicationChangeWidgetDatum.copyOf(instance);

    // Assert
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
   * Test {@link ImmutableApplicationChangeWidgetDatum#currentAppCount()}.
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#currentAppCount()}
   */
  @Test
  @DisplayName("Test currentAppCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableApplicationChangeWidgetDatum.currentAppCount()"})
  void testCurrentAppCount() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("42")
            .build()
            .currentAppCount());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}, and {@link
   * ImmutableApplicationChangeWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum2 =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableApplicationChangeWidgetDatum, immutableApplicationChangeWidgetDatum2);
    assertEquals(
        immutableApplicationChangeWidgetDatum.hashCode(),
        immutableApplicationChangeWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}, and {@link
   * ImmutableApplicationChangeWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableApplicationChangeWidgetDatum, immutableApplicationChangeWidgetDatum);
    int expectedHashCodeResult = immutableApplicationChangeWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationChangeWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationChangeWidgetDatum,
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();
    builderResult.addCurrentApplications(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationChangeWidgetDatum,
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableApplicationChangeWidgetDatum,
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationChangeWidgetDatum.equals(Object)",
    "int ImmutableApplicationChangeWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableApplicationChangeWidgetDatum");
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applicationChanges is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applicationChanges is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationChangesIsHashSet() {
    // Arrange
    HashSet<AppChangeEntry> applicationChanges = new HashSet<>();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    applicationChanges.add(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    applicationChanges.add(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(applicationChanges);
    json.setCurrentApplications(new HashSet<>());

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.outboundCounts().size());
    assertEquals(1, actualFromJsonResult.totalInboundCount());
    assertEquals(1, actualFromJsonResult.totalOutboundCount());
    assertTrue(actualFromJsonResult.currentApplications().isEmpty());
    assertEquals(applicationChanges, actualFromJsonResult.applicationChanges());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applicationChanges size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applicationChanges size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationChangesSizeIsOne() {
    // Arrange
    LinkedHashSet<AppChangeEntry> applicationChanges = new LinkedHashSet<>();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    applicationChanges.add(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    LinkedHashSet<EntityReference> currentApplications = new LinkedHashSet<>();
    currentApplications.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(applicationChanges);
    json.setCurrentApplications(currentApplications);

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applicationChanges().size());
    assertEquals(1, actualFromJsonResult.currentApplications().size());
    assertEquals(1, actualFromJsonResult.currentAppCount());
    assertEquals(1, actualFromJsonResult.totalInboundCount());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applicationChanges size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applicationChanges size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationChangesSizeIsOne2() {
    // Arrange
    HashSet<AppChangeEntry> applicationChanges = new HashSet<>();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    applicationChanges.add(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(applicationChanges);
    json.setCurrentApplications(new HashSet<>());

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applicationChanges().size());
    assertEquals(1, actualFromJsonResult.outboundCounts().size());
    assertEquals(1, actualFromJsonResult.totalOutboundCount());
    assertTrue(actualFromJsonResult.currentApplications().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return totalInboundCount is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return totalInboundCount is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnTotalInboundCountIsTwo() {
    // Arrange
    LinkedHashSet<AppChangeEntry> applicationChanges = new LinkedHashSet<>();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    applicationChanges.add(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    applicationChanges.add(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    LinkedHashSet<EntityReference> currentApplications = new LinkedHashSet<>();
    currentApplications.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(applicationChanges);
    json.setCurrentApplications(currentApplications);

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.currentApplications().size());
    assertEquals(1, actualFromJsonResult.currentAppCount());
    assertEquals(2, actualFromJsonResult.totalInboundCount());
    assertEquals(applicationChanges, actualFromJsonResult.applicationChanges());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return totalInboundCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return totalInboundCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnTotalInboundCountIsZero() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(new HashSet<>());
    json.setCurrentApplications(new HashSet<>());

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.totalInboundCount());
    Set<AppChangeEntry> applicationChangesResult = actualFromJsonResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(actualFromJsonResult.inboundCounts().isEmpty());
    assertSame(applicationChangesResult, actualFromJsonResult.currentApplications());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ApplicationChanges is {@code null}.
   *   <li>Then return totalInboundCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ApplicationChanges is 'null'; then return totalInboundCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_whenJsonApplicationChangesIsNull_thenReturnTotalInboundCountIsZero() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(null);
    json.setCurrentApplications(new HashSet<>());

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.totalInboundCount());
    Set<AppChangeEntry> applicationChangesResult = actualFromJsonResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(actualFromJsonResult.inboundCounts().isEmpty());
    assertSame(applicationChangesResult, actualFromJsonResult.currentApplications());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) CurrentApplications is {@code null}.
   *   <li>Then return totalInboundCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) CurrentApplications is 'null'; then return totalInboundCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.fromJson(Json)"
  })
  void testFromJson_whenJsonCurrentApplicationsIsNull_thenReturnTotalInboundCountIsZero() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setApplicationChanges(new HashSet<>());
    json.setCurrentApplications(null);

    // Act
    ImmutableApplicationChangeWidgetDatum actualFromJsonResult =
        ImmutableApplicationChangeWidgetDatum.fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.totalInboundCount());
    Set<AppChangeEntry> applicationChangesResult = actualFromJsonResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(actualFromJsonResult.inboundCounts().isEmpty());
    assertSame(applicationChangesResult, actualFromJsonResult.currentApplications());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#toString()}
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#applicationChanges()}
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#cellExternalId()}
   *   <li>{@link ImmutableApplicationChangeWidgetDatum#currentApplications()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableApplicationChangeWidgetDatum.applicationChanges()",
    "String ImmutableApplicationChangeWidgetDatum.cellExternalId()",
    "Set ImmutableApplicationChangeWidgetDatum.currentApplications()",
    "String ImmutableApplicationChangeWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableApplicationChangeWidgetDatum.toString();
    Set<AppChangeEntry> actualApplicationChangesResult =
        immutableApplicationChangeWidgetDatum.applicationChanges();
    String actualCellExternalIdResult = immutableApplicationChangeWidgetDatum.cellExternalId();
    Set<EntityReference> actualCurrentApplicationsResult =
        immutableApplicationChangeWidgetDatum.currentApplications();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "ApplicationChangeWidgetDatum{cellExternalId=42, inboundCounts=[], outboundCounts=[], totalOutboundCount=0,"
            + " totalInboundCount=0, currentAppCount=0, applicationChanges=[], currentApplications=[]}",
        actualToStringResult);
    assertTrue(actualApplicationChangesResult.isEmpty());
    assertSame(actualApplicationChangesResult, actualCurrentApplicationsResult);
  }

  /**
   * Test Json {@link Json#applicationChanges()}.
   *
   * <p>Method under test: {@link Json#applicationChanges()}
   */
  @Test
  @DisplayName("Test Json applicationChanges()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.applicationChanges()"})
  void testJsonApplicationChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationChanges());
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
   * Test Json {@link Json#currentAppCount()}.
   *
   * <p>Method under test: {@link Json#currentAppCount()}
   */
  @Test
  @DisplayName("Test Json currentAppCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.currentAppCount()"})
  void testJsonCurrentAppCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().currentAppCount());
  }

  /**
   * Test Json {@link Json#currentApplications()}.
   *
   * <p>Method under test: {@link Json#currentApplications()}
   */
  @Test
  @DisplayName("Test Json currentApplications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.currentApplications()"})
  void testJsonCurrentApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().currentApplications());
  }

  /**
   * Test Json {@link Json#inboundCounts()}.
   *
   * <p>Method under test: {@link Json#inboundCounts()}
   */
  @Test
  @DisplayName("Test Json inboundCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.inboundCounts()"})
  void testJsonInboundCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inboundCounts());
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
    assertTrue(actualJson.applicationChanges.isEmpty());
    assertTrue(actualJson.currentApplications.isEmpty());
  }

  /**
   * Test Json {@link Json#outboundCounts()}.
   *
   * <p>Method under test: {@link Json#outboundCounts()}
   */
  @Test
  @DisplayName("Test Json outboundCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.outboundCounts()"})
  void testJsonOutboundCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().outboundCounts());
  }

  /**
   * Test Json {@link Json#totalInboundCount()}.
   *
   * <p>Method under test: {@link Json#totalInboundCount()}
   */
  @Test
  @DisplayName("Test Json totalInboundCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.totalInboundCount()"})
  void testJsonTotalInboundCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalInboundCount());
  }

  /**
   * Test Json {@link Json#totalOutboundCount()}.
   *
   * <p>Method under test: {@link Json#totalOutboundCount()}
   */
  @Test
  @DisplayName("Test Json totalOutboundCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.totalOutboundCount()"})
  void testJsonTotalOutboundCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalOutboundCount());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withApplicationChanges(AppChangeEntry[])}
   * with {@code AppChangeEntry[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withApplicationChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName("Test withApplicationChanges(AppChangeEntry[]) with 'AppChangeEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withApplicationChanges(AppChangeEntry[])"
  })
  void testWithApplicationChangesWithAppChangeEntry() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithApplicationChangesResult =
        immutableApplicationChangeWidgetDatum.withApplicationChanges(
            builderResult
                .appRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .changeDirection(ChangeDirection.INBOUND)
                .date(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(0, actualWithApplicationChangesResult.totalOutboundCount());
    assertEquals(1, actualWithApplicationChangesResult.inboundCounts().size());
    assertEquals(1, actualWithApplicationChangesResult.totalInboundCount());
    assertTrue(actualWithApplicationChangesResult.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withApplicationChanges(AppChangeEntry[])}
   * with {@code AppChangeEntry[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withApplicationChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName("Test withApplicationChanges(AppChangeEntry[]) with 'AppChangeEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withApplicationChanges(AppChangeEntry[])"
  })
  void testWithApplicationChangesWithAppChangeEntry2() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithApplicationChangesResult =
        immutableApplicationChangeWidgetDatum.withApplicationChanges(
            builderResult
                .appRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .changeDirection(ChangeDirection.INBOUND)
                .date(LocalDate.now())
                .build());

    // Assert
    assertEquals(0, actualWithApplicationChangesResult.totalOutboundCount());
    assertEquals(1, actualWithApplicationChangesResult.inboundCounts().size());
    assertEquals(1, actualWithApplicationChangesResult.totalInboundCount());
    assertTrue(actualWithApplicationChangesResult.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withApplicationChanges(AppChangeEntry[])}
   * with {@code AppChangeEntry[]}.
   *
   * <ul>
   *   <li>Then return totalInboundCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withApplicationChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName(
      "Test withApplicationChanges(AppChangeEntry[]) with 'AppChangeEntry[]'; then return totalInboundCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withApplicationChanges(AppChangeEntry[])"
  })
  void testWithApplicationChangesWithAppChangeEntry_thenReturnTotalInboundCountIsZero() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithApplicationChangesResult =
        immutableApplicationChangeWidgetDatum.withApplicationChanges(
            builderResult
                .appRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .changeDirection(ChangeDirection.OUTBOUND)
                .date(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(0, actualWithApplicationChangesResult.totalInboundCount());
    assertEquals(1, actualWithApplicationChangesResult.outboundCounts().size());
    assertEquals(1, actualWithApplicationChangesResult.totalOutboundCount());
    assertTrue(actualWithApplicationChangesResult.inboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.now())
            .build());

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCellExternalIdResult =
        builderResult.cellExternalId("cellExternalId").build().withCellExternalId("42");

    // Assert
    assertEquals(1, actualWithCellExternalIdResult.applicationChanges().size());
    assertEquals(1, actualWithCellExternalIdResult.inboundCounts().size());
    assertEquals(1, actualWithCellExternalIdResult.totalInboundCount());
    assertTrue(actualWithCellExternalIdResult.currentApplications().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return applicationChanges Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return applicationChanges Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnApplicationChangesEmpty() {
    // Arrange and Act
    ImmutableApplicationChangeWidgetDatum actualWithCellExternalIdResult =
        ImmutableApplicationChangeWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals(0, actualWithCellExternalIdResult.totalInboundCount());
    Set<AppChangeEntry> applicationChangesResult =
        actualWithCellExternalIdResult.applicationChanges();
    assertTrue(applicationChangesResult.isEmpty());
    assertTrue(actualWithCellExternalIdResult.inboundCounts().isEmpty());
    assertSame(applicationChangesResult, actualWithCellExternalIdResult.currentApplications());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return applicationChanges size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return applicationChanges size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnApplicationChangesSizeIsTwo() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    ImmutableAppChangeEntry.Builder builderResult3 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult3
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCellExternalIdResult =
        builderResult.cellExternalId("cellExternalId").build().withCellExternalId("42");

    // Assert
    assertEquals(1, actualWithCellExternalIdResult.inboundCounts().size());
    assertEquals(2, actualWithCellExternalIdResult.applicationChanges().size());
    assertEquals(2, actualWithCellExternalIdResult.totalInboundCount());
    assertTrue(actualWithCellExternalIdResult.currentApplications().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCellExternalIdResult =
        immutableApplicationChangeWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableApplicationChangeWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return outboundCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return outboundCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnOutboundCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCellExternalIdResult =
        builderResult.cellExternalId("cellExternalId").build().withCellExternalId("42");

    // Assert
    assertEquals(0, actualWithCellExternalIdResult.totalInboundCount());
    assertEquals(1, actualWithCellExternalIdResult.applicationChanges().size());
    assertEquals(1, actualWithCellExternalIdResult.outboundCounts().size());
    assertEquals(1, actualWithCellExternalIdResult.totalOutboundCount());
    assertTrue(actualWithCellExternalIdResult.inboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return totalInboundCount is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationChangeWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return totalInboundCount is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnTotalInboundCountIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCellExternalIdResult =
        builderResult.cellExternalId("cellExternalId").build().withCellExternalId("42");

    // Assert
    assertEquals(1, actualWithCellExternalIdResult.applicationChanges().size());
    assertEquals(1, actualWithCellExternalIdResult.inboundCounts().size());
    assertEquals(1, actualWithCellExternalIdResult.totalInboundCount());
    assertTrue(actualWithCellExternalIdResult.currentApplications().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName("Test withCurrentApplications(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCurrentApplications(EntityReference[])"
  })
  void testWithCurrentApplicationsWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCurrentApplicationsResult =
        immutableApplicationChangeWidgetDatum.withCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(0, actualWithCurrentApplicationsResult.totalOutboundCount());
    assertEquals(1, actualWithCurrentApplicationsResult.applicationChanges().size());
    assertEquals(1, actualWithCurrentApplicationsResult.inboundCounts().size());
    assertEquals(1, actualWithCurrentApplicationsResult.totalInboundCount());
    assertTrue(actualWithCurrentApplicationsResult.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName("Test withCurrentApplications(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCurrentApplications(EntityReference[])"
  })
  void testWithCurrentApplicationsWithEntityReference2() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    ImmutableAppChangeEntry.Builder builderResult3 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult3
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCurrentApplicationsResult =
        immutableApplicationChangeWidgetDatum.withCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(0, actualWithCurrentApplicationsResult.totalOutboundCount());
    assertEquals(1, actualWithCurrentApplicationsResult.inboundCounts().size());
    assertEquals(2, actualWithCurrentApplicationsResult.applicationChanges().size());
    assertEquals(2, actualWithCurrentApplicationsResult.totalInboundCount());
    assertTrue(actualWithCurrentApplicationsResult.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName("Test withCurrentApplications(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCurrentApplications(EntityReference[])"
  })
  void testWithCurrentApplicationsWithEntityReference3() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.now())
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCurrentApplicationsResult =
        immutableApplicationChangeWidgetDatum.withCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(0, actualWithCurrentApplicationsResult.totalOutboundCount());
    assertEquals(1, actualWithCurrentApplicationsResult.applicationChanges().size());
    assertEquals(1, actualWithCurrentApplicationsResult.inboundCounts().size());
    assertEquals(1, actualWithCurrentApplicationsResult.totalInboundCount());
    assertTrue(actualWithCurrentApplicationsResult.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <ul>
   *   <li>Then return applicationChanges Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test withCurrentApplications(EntityReference[]) with 'EntityReference[]'; then return applicationChanges Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCurrentApplications(EntityReference[])"
  })
  void testWithCurrentApplicationsWithEntityReference_thenReturnApplicationChangesEmpty() {
    // Arrange
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCurrentApplicationsResult =
        immutableApplicationChangeWidgetDatum.withCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(0, actualWithCurrentApplicationsResult.totalInboundCount());
    assertEquals(0, actualWithCurrentApplicationsResult.totalOutboundCount());
    assertTrue(actualWithCurrentApplicationsResult.applicationChanges().isEmpty());
    assertTrue(actualWithCurrentApplicationsResult.inboundCounts().isEmpty());
    assertTrue(actualWithCurrentApplicationsResult.outboundCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <ul>
   *   <li>Then return outboundCounts size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationChangeWidgetDatum#withCurrentApplications(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test withCurrentApplications(EntityReference[]) with 'EntityReference[]'; then return outboundCounts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationChangeWidgetDatum ImmutableApplicationChangeWidgetDatum.withCurrentApplications(EntityReference[])"
  })
  void testWithCurrentApplicationsWithEntityReference_thenReturnOutboundCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableApplicationChangeWidgetDatum.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addApplicationChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.OUTBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableApplicationChangeWidgetDatum immutableApplicationChangeWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act
    ImmutableApplicationChangeWidgetDatum actualWithCurrentApplicationsResult =
        immutableApplicationChangeWidgetDatum.withCurrentApplications(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(0, actualWithCurrentApplicationsResult.totalInboundCount());
    assertEquals(1, actualWithCurrentApplicationsResult.outboundCounts().size());
    assertEquals(1, actualWithCurrentApplicationsResult.totalOutboundCount());
    assertTrue(actualWithCurrentApplicationsResult.inboundCounts().isEmpty());
  }
}
