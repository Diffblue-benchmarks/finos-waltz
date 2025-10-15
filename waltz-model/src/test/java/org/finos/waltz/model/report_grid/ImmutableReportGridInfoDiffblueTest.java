package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridInfo.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#visibilityKind(ReportGridKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInfo Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)",
    "Builder Builder.visibilityKind(ReportGridKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        actualExternalIdResult
            .externalId(externalId)
            .gridId(1L)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableReportGridInfo.lastUpdatedBy());
    assertEquals("Name", actualImmutableReportGridInfo.name());
    assertEquals("Provenance", actualImmutableReportGridInfo.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableReportGridInfo.description());
    assertEquals(1L, actualImmutableReportGridInfo.gridId());
    assertEquals(EntityKind.ALL, actualImmutableReportGridInfo.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualImmutableReportGridInfo.visibilityKind());
    assertSame(lastUpdatedAt, actualImmutableReportGridInfo.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description(null)
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description(null)
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridInfo);
    ImmutableReportGridInfo actualImmutableReportGridInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description(null)
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInfo)} with {@code ReportGridInfo}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInfo) with 'ReportGridInfo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridInfo)"})
  void testBuilderFromWithReportGridInfo() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridInfo)} with {@code ReportGridInfo}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridInfo) with 'ReportGridInfo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridInfo)"})
  void testBuilderFromWithReportGridInfo2() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description(null)
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridInfo actualImmutableReportGridInfo = builderResult.build();
    assertEquals(instance, actualImmutableReportGridInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#gridId(long)}.
   *
   * <p>Method under test: {@link Builder#gridId(long)}
   */
  @Test
  @DisplayName("Test Builder gridId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.gridId(long)"})
  void testBuilderGridId() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualGridIdResult = builderResult.gridId(1L);

    // Assert
    assertSame(builderResult, actualGridIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridInfo.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#copyOf(ReportGridInfo)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#copyOf(ReportGridInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridInfo); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.copyOf(ReportGridInfo)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridInfo instance =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualCopyOfResult = ImmutableReportGridInfo.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.gridId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}, and {@link
   * ImmutableReportGridInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridInfo#equals(Object)}
   *   <li>{@link ImmutableReportGridInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();
    ImmutableReportGridInfo immutableReportGridInfo2 =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridInfo, immutableReportGridInfo2);
    assertEquals(immutableReportGridInfo.hashCode(), immutableReportGridInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}, and {@link
   * ImmutableReportGridInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridInfo#equals(Object)}
   *   <li>{@link ImmutableReportGridInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridInfo, immutableReportGridInfo);
    int expectedHashCodeResult = immutableReportGridInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridInfo.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("2020-03-01")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("2020-03-01")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ACTOR)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PRIVATE)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridInfo,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridInfo.equals(Object)",
    "int ImmutableReportGridInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build(),
        "Different type to ImmutableReportGridInfo");
  }

  /**
   * Test {@link ImmutableReportGridInfo#externalId()}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridInfo.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridInfo#description()}
   *   <li>{@link ImmutableReportGridInfo#gridId()}
   *   <li>{@link ImmutableReportGridInfo#lastUpdatedBy()}
   *   <li>{@link ImmutableReportGridInfo#name()}
   *   <li>{@link ImmutableReportGridInfo#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableReportGridInfo.description()",
    "long ImmutableReportGridInfo.gridId()",
    "String ImmutableReportGridInfo.lastUpdatedBy()",
    "String ImmutableReportGridInfo.name()",
    "EntityKind ImmutableReportGridInfo.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    String actualDescriptionResult = immutableReportGridInfo.description();
    long actualGridIdResult = immutableReportGridInfo.gridId();
    String actualLastUpdatedByResult = immutableReportGridInfo.lastUpdatedBy();
    String actualNameResult = immutableReportGridInfo.name();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualGridIdResult);
    assertEquals(EntityKind.ALL, immutableReportGridInfo.subjectKind());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#gridId()}.
   *
   * <p>Method under test: {@link Json#gridId()}
   */
  @Test
  @DisplayName("Test Json gridId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.gridId()"})
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridId());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.subjectKind);
    assertNull(actualJson.visibilityKind);
    assertEquals(0L, actualJson.gridId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.gridIdIsSet);
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setGridId(long)}.
   *
   * <p>Method under test: {@link Json#setGridId(long)}
   */
  @Test
  @DisplayName("Test Json setGridId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setGridId(long)"})
  void testJsonSetGridId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setGridId(1L);

    // Assert
    assertEquals(1L, json.gridId);
    assertTrue(json.gridIdIsSet);
  }

  /**
   * Test Json {@link Json#subjectKind()}.
   *
   * <p>Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectKind());
  }

  /**
   * Test Json {@link Json#visibilityKind()}.
   *
   * <p>Method under test: {@link Json#visibilityKind()}
   */
  @Test
  @DisplayName("Test Json visibilityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind Json.visibilityKind()"})
  void testJsonVisibilityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().visibilityKind());
  }

  /**
   * Test {@link ImmutableReportGridInfo#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableReportGridInfo.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#provenance()}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridInfo.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableReportGridInfo#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridInfo.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridInfo{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " name=Name, externalId=42, gridId=1, subjectKind=ALL, visibilityKind=PUBLIC}",
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridInfo#visibilityKind()}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#visibilityKind()}
   */
  @Test
  @DisplayName("Test visibilityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind ImmutableReportGridInfo.visibilityKind()"})
  void testVisibilityKind() {
    // Arrange, Act and Assert
    assertEquals(
        ReportGridKind.PUBLIC,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .visibilityKind());
  }

  /**
   * Test {@link ImmutableReportGridInfo#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithDescriptionResult =
        immutableReportGridInfo.withDescription("42");

    // Assert
    assertEquals(immutableReportGridInfo, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("42")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithDescriptionResult =
        immutableReportGridInfo.withDescription("42");

    // Assert
    assertSame(immutableReportGridInfo, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableReportGridInfo actualWithExternalIdResult =
        immutableReportGridInfo.withExternalId(optional);

    // Assert
    assertSame(immutableReportGridInfo, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableReportGridInfo actualWithExternalIdResult =
        immutableReportGridInfo.withExternalId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.gridId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithExternalIdResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithExternalIdResult =
        immutableReportGridInfo.withExternalId("42");

    // Assert
    assertSame(immutableReportGridInfo, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithExternalIdResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.gridId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithExternalIdResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withGridId(long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withGridId(long)}
   */
  @Test
  @DisplayName("Test withGridId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withGridId(long)"})
  void testWithGridId() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(42L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithGridIdResult = immutableReportGridInfo.withGridId(42L);

    // Assert
    assertSame(immutableReportGridInfo, actualWithGridIdResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withGridId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withGridId(long)}
   */
  @Test
  @DisplayName("Test withGridId(long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withGridId(long)"})
  void testWithGridId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithGridIdResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .withGridId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithGridIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithGridIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithGridIdResult.name());
    assertEquals("Provenance", actualWithGridIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithGridIdResult.description());
    assertEquals(42L, actualWithGridIdResult.gridId());
    assertEquals(EntityKind.ALL, actualWithGridIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithGridIdResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInfo ImmutableReportGridInfo.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithLastUpdatedAtResult =
        immutableReportGridInfo.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableReportGridInfo, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithLastUpdatedByResult =
        immutableReportGridInfo.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableReportGridInfo, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithLastUpdatedByResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, actualWithLastUpdatedByResult.gridId());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithLastUpdatedByResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithNameResult = immutableReportGridInfo.withName("42");

    // Assert
    assertSame(immutableReportGridInfo, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withName(String)"})
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithNameResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.gridId());
    assertEquals(EntityKind.ALL, actualWithNameResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithNameResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("42")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithProvenanceResult =
        immutableReportGridInfo.withProvenance("42");

    // Assert
    assertSame(immutableReportGridInfo, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithProvenanceResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.gridId());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithProvenanceResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withSubjectKind(EntityKind)"})
  void testWithSubjectKind() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithSubjectKindResult =
        immutableReportGridInfo.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableReportGridInfo, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withSubjectKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridInfo ImmutableReportGridInfo.withSubjectKind(EntityKind)"})
  void testWithSubjectKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithSubjectKindResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ACTOR)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithSubjectKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithSubjectKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithSubjectKindResult.name());
    assertEquals("Provenance", actualWithSubjectKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithSubjectKindResult.description());
    assertEquals(1L, actualWithSubjectKindResult.gridId());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithSubjectKindResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withVisibilityKind(ReportGridKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withVisibilityKind(ReportGridKind)}
   */
  @Test
  @DisplayName("Test withVisibilityKind(ReportGridKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInfo ImmutableReportGridInfo.withVisibilityKind(ReportGridKind)"
  })
  void testWithVisibilityKind() {
    // Arrange
    ImmutableReportGridInfo immutableReportGridInfo =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build();

    // Act
    ImmutableReportGridInfo actualWithVisibilityKindResult =
        immutableReportGridInfo.withVisibilityKind(ReportGridKind.PUBLIC);

    // Assert
    assertSame(immutableReportGridInfo, actualWithVisibilityKindResult);
  }

  /**
   * Test {@link ImmutableReportGridInfo#withVisibilityKind(ReportGridKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridInfo#withVisibilityKind(ReportGridKind)}
   */
  @Test
  @DisplayName(
      "Test withVisibilityKind(ReportGridKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridInfo ImmutableReportGridInfo.withVisibilityKind(ReportGridKind)"
  })
  void testWithVisibilityKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridInfo actualWithVisibilityKindResult =
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PRIVATE)
            .build()
            .withVisibilityKind(ReportGridKind.PUBLIC);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithVisibilityKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithVisibilityKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithVisibilityKindResult.name());
    assertEquals("Provenance", actualWithVisibilityKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithVisibilityKindResult.description());
    assertEquals(1L, actualWithVisibilityKindResult.gridId());
    assertEquals(EntityKind.ALL, actualWithVisibilityKindResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithVisibilityKindResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }
}
