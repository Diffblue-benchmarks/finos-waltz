package org.finos.waltz.model.change_initiative;

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
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.OrganisationalUnitIdProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative.Builder;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeInitiativeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdate(Date)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdate(Date)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Builder actualExternalIdResult = actualDescriptionResult.endDate(endDate).externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    Builder actualLastUpdateResult =
        actualKindResult.lastUpdate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<? extends Date> lastUpdate =
        Optional.of(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Builder actualParentIdResult =
        actualLastUpdateResult
            .lastUpdate(lastUpdate)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L);
    Optional<Long> parentId = Optional.of(1L);
    Builder actualProvenanceResult =
        actualParentIdResult.parentId(parentId).provenance("Provenance");
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        actualProvenanceResult.startDate(startDate).build();

    // Assert
    assertEquals("Name", actualImmutableChangeInitiative.name());
    assertEquals("Provenance", actualImmutableChangeInitiative.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableChangeInitiative.description());
    assertEquals(1L, actualImmutableChangeInitiative.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableChangeInitiative.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableChangeInitiative.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE, actualImmutableChangeInitiative.changeInitiativeKind());
    assertSame(endDate, actualImmutableChangeInitiative.endDate());
    assertSame(startDate, actualImmutableChangeInitiative.startDate());
  }

  /**
   * Test Builder {@link Builder#changeInitiativeKind(ChangeInitiativeKind)}.
   *
   * <p>Method under test: {@link Builder#changeInitiativeKind(ChangeInitiativeKind)}
   */
  @Test
  @DisplayName("Test Builder changeInitiativeKind(ChangeInitiativeKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeInitiativeKind(ChangeInitiativeKind)"})
  void testBuilderChangeInitiativeKind() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualChangeInitiativeKindResult =
        builderResult.changeInitiativeKind(ChangeInitiativeKind.INITIATIVE);

    // Assert
    assertSame(builderResult, actualChangeInitiativeKindResult);
  }

  /**
   * Test Builder {@link Builder#endDate(Date)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#endDate(Date)}
   */
  @Test
  @DisplayName("Test Builder endDate(Date); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.endDate(Date)"})
  void testBuilderEndDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualEndDateResult =
        builderResult.endDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(builderResult, actualEndDateResult);
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
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   *
   * <p>Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   *
   * <p>Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative2() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description(null);

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
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
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

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
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

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
    Builder builderResult = ImmutableChangeInitiative.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

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
   *   <li>Given of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOfFoo() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

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
    Builder builderResult = ImmutableChangeInitiative.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
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
    Builder builderResult = ImmutableChangeInitiative.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code
   * OrganisationalUnitIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((OrganisationalUnitIdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code
   * OrganisationalUnitIdProvider}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; given one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_givenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).organisationalUnitId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code
   * OrganisationalUnitIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).organisationalUnitId();
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((ParentIdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOfOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
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
    Builder builderResult = ImmutableChangeInitiative.builder();

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
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
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
    Builder builderResult = ImmutableChangeInitiative.builder();

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
    Builder builderResult = ImmutableChangeInitiative.builder();

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
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description(null);

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableChangeInitiative actualImmutableChangeInitiative =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableChangeInitiative);
    ImmutableChangeInitiative actualImmutableChangeInitiative2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeInitiative2);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#lastUpdate(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdate(Optional)"})
  void testBuilderLastUpdateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<? extends Date> lastUpdate =
        Optional.of(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Builder actualLastUpdateResult = builderResult.lastUpdate(lastUpdate);

    // Assert
    assertSame(builderResult, actualLastUpdateResult);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualLifecyclePhaseResult = builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualLifecyclePhaseResult);
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
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(Long)}.
   *
   * <p>Method under test: {@link Builder#organisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(Long)"})
  void testBuilderOrganisationalUnitId() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualOrganisationalUnitIdResult = builderResult.organisationalUnitId(1L);

    // Assert
    assertSame(builderResult, actualOrganisationalUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualParentIdResult = builderResult.parentId(1L);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<Long> parentId = Optional.of(1L);

    // Act
    Builder actualParentIdResult = builderResult.parentId(parentId);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#startDate(Date)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#startDate(Date)}
   */
  @Test
  @DisplayName("Test Builder startDate(Date); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.startDate(Date)"})
  void testBuilderStartDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act
    Builder actualStartDateResult =
        builderResult.startDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(builderResult, actualStartDateResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeInitiative); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.copyOf(ChangeInitiative)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative instance =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}, and {@link
   * ImmutableChangeInitiative#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeInitiative#equals(Object)}
   *   <li>{@link ImmutableChangeInitiative#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative2 =
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableChangeInitiative, immutableChangeInitiative2);
    assertEquals(immutableChangeInitiative.hashCode(), immutableChangeInitiative2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}, and {@link
   * ImmutableChangeInitiative#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeInitiative#equals(Object)}
   *   <li>{@link ImmutableChangeInitiative#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableChangeInitiative, immutableChangeInitiative);
    int expectedHashCodeResult = immutableChangeInitiative.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeInitiative.hashCode());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.PROGRAMME)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Provenance")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(2L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(2L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Name");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeInitiative,
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableChangeInitiative#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeInitiative.equals(Object)",
    "int ImmutableChangeInitiative.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "Different type to ImmutableChangeInitiative");
  }

  /**
   * Test {@link ImmutableChangeInitiative#externalId()}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeInitiative.externalId()"})
  void testExternalId() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    Optional<String> actualExternalIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
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
   *   <li>{@link ImmutableChangeInitiative#changeInitiativeKind()}
   *   <li>{@link ImmutableChangeInitiative#description()}
   *   <li>{@link ImmutableChangeInitiative#endDate()}
   *   <li>{@link ImmutableChangeInitiative#lifecyclePhase()}
   *   <li>{@link ImmutableChangeInitiative#name()}
   *   <li>{@link ImmutableChangeInitiative#organisationalUnitId()}
   *   <li>{@link ImmutableChangeInitiative#startDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeKind ImmutableChangeInitiative.changeInitiativeKind()",
    "String ImmutableChangeInitiative.description()",
    "Date ImmutableChangeInitiative.endDate()",
    "LifecyclePhase ImmutableChangeInitiative.lifecyclePhase()",
    "String ImmutableChangeInitiative.name()",
    "Long ImmutableChangeInitiative.organisationalUnitId()",
    "Date ImmutableChangeInitiative.startDate()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    Builder kindResult =
        descriptionResult.endDate(endDate).externalId("42").id(1L).kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult.startDate(startDate).build();

    // Act
    ChangeInitiativeKind actualChangeInitiativeKindResult =
        immutableChangeInitiative.changeInitiativeKind();
    String actualDescriptionResult = immutableChangeInitiative.description();
    Date actualEndDateResult = immutableChangeInitiative.endDate();
    LifecyclePhase actualLifecyclePhaseResult = immutableChangeInitiative.lifecyclePhase();
    String actualNameResult = immutableChangeInitiative.name();
    Long actualOrganisationalUnitIdResult = immutableChangeInitiative.organisationalUnitId();
    Date actualStartDateResult = immutableChangeInitiative.startDate();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualOrganisationalUnitIdResult.longValue());
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualChangeInitiativeKindResult);
    assertSame(endDate, actualEndDateResult);
    assertSame(startDate, actualStartDateResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#id()}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeInitiative.id()"})
  void testId() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    Optional<Long> actualIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#changeInitiativeKind()}.
   *
   * <p>Method under test: {@link Json#changeInitiativeKind()}
   */
  @Test
  @DisplayName("Test Json changeInitiativeKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeInitiativeKind Json.changeInitiativeKind()"})
  void testJsonChangeInitiativeKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeInitiativeKind());
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
   * Test Json {@link Json#endDate()}.
   *
   * <p>Method under test: {@link Json#endDate()}
   */
  @Test
  @DisplayName("Test Json endDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.endDate()"})
  void testJsonEndDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().endDate());
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
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   *
   * <p>Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdate());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   *
   * <p>Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lifecyclePhase());
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
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.endDate);
    assertNull(actualJson.startDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.changeInitiativeKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.parentId.isPresent());
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   *
   * <p>Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().organisationalUnitId());
  }

  /**
   * Test Json {@link Json#parentId()}.
   *
   * <p>Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentId());
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
   * Test Json {@link Json#startDate()}.
   *
   * <p>Method under test: {@link Json#startDate()}
   */
  @Test
  @DisplayName("Test Json startDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.startDate()"})
  void testJsonStartDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().startDate());
  }

  /**
   * Test {@link ImmutableChangeInitiative#kind()}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableChangeInitiative.kind()"})
  void testKind() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#lastUpdate()}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#lastUpdate()}
   */
  @Test
  @DisplayName("Test lastUpdate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeInitiative.lastUpdate()"})
  void testLastUpdate() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertTrue(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .lastUpdate()
            .isPresent());
  }

  /**
   * Test {@link ImmutableChangeInitiative#parentId()}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#parentId()}
   */
  @Test
  @DisplayName("Test parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeInitiative.parentId()"})
  void testParentId() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    Optional<Long> actualParentIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .parentId();

    // Assert
    assertEquals(1L, actualParentIdResult.get().longValue());
    assertTrue(actualParentIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableChangeInitiative#provenance()}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeInitiative.provenance()"})
  void testProvenance() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        "Provenance",
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withChangeInitiativeKind(ChangeInitiativeKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableChangeInitiative#withChangeInitiativeKind(ChangeInitiativeKind)}
   */
  @Test
  @DisplayName("Test withChangeInitiativeKind(ChangeInitiativeKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withChangeInitiativeKind(ChangeInitiativeKind)"
  })
  void testWithChangeInitiativeKind() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithChangeInitiativeKindResult =
        immutableChangeInitiative.withChangeInitiativeKind(ChangeInitiativeKind.INITIATIVE);

    // Assert
    assertSame(immutableChangeInitiative, actualWithChangeInitiativeKindResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withChangeInitiativeKind(ChangeInitiativeKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableChangeInitiative#withChangeInitiativeKind(ChangeInitiativeKind)}
   */
  @Test
  @DisplayName("Test withChangeInitiativeKind(ChangeInitiativeKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withChangeInitiativeKind(ChangeInitiativeKind)"
  })
  void testWithChangeInitiativeKind_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.PROGRAMME)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithChangeInitiativeKindResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withChangeInitiativeKind(ChangeInitiativeKind.INITIATIVE);

    // Assert
    assertEquals("Name", actualWithChangeInitiativeKindResult.name());
    assertEquals("Provenance", actualWithChangeInitiativeKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithChangeInitiativeKindResult.description());
    assertEquals(1L, actualWithChangeInitiativeKindResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithChangeInitiativeKindResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithChangeInitiativeKindResult.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE,
        actualWithChangeInitiativeKindResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithDescriptionResult =
        immutableChangeInitiative.withDescription("42");

    // Assert
    assertEquals(immutableChangeInitiative, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("42");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithDescriptionResult =
        immutableChangeInitiative.withDescription("42");

    // Assert
    assertSame(immutableChangeInitiative, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withEndDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withEndDate(Date)}
   */
  @Test
  @DisplayName("Test withEndDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withEndDate(Date)"})
  void testWithEndDate() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithEndDateResult =
        immutableChangeInitiative.withEndDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableChangeInitiative, actualWithEndDateResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableChangeInitiative actualWithExternalIdResult =
        immutableChangeInitiative.withExternalId(optional);

    // Assert
    assertSame(immutableChangeInitiative, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableChangeInitiative actualWithExternalIdResult =
        immutableChangeInitiative.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE, actualWithExternalIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithExternalIdResult =
        immutableChangeInitiative.withExternalId("42");

    // Assert
    assertSame(immutableChangeInitiative, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithExternalIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE, actualWithExternalIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeInitiative actualWithIdResult = immutableChangeInitiative.withId(optional);

    // Assert
    assertSame(immutableChangeInitiative, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeInitiative actualWithIdResult = immutableChangeInitiative.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIdResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualWithIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithIdResult = immutableChangeInitiative.withId(1L);

    // Assert
    assertSame(immutableChangeInitiative, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIdResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualWithIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithKindResult =
        immutableChangeInitiative.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableChangeInitiative, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withKind(EntityKind)"})
  void testWithKind_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithKindResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithKindResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualWithKindResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withLastUpdate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withLastUpdate(Optional)}
   */
  @Test
  @DisplayName("Test withLastUpdate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withLastUpdate(Optional)"
  })
  void testWithLastUpdateWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<? extends Date> optional =
        Optional.of(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    ImmutableChangeInitiative actualWithLastUpdateResult =
        immutableChangeInitiative.withLastUpdate(optional);

    // Assert
    assertEquals(immutableChangeInitiative, actualWithLastUpdateResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withLastUpdate(Date)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withLastUpdate(Date)}
   */
  @Test
  @DisplayName("Test withLastUpdate(Date) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withLastUpdate(Date)"})
  void testWithLastUpdateWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithLastUpdateResult =
        immutableChangeInitiative.withLastUpdate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableChangeInitiative, actualWithLastUpdateResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithLifecyclePhaseResult =
        immutableChangeInitiative.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableChangeInitiative, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithLifecyclePhaseResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertEquals("Name", actualWithLifecyclePhaseResult.name());
    assertEquals("Provenance", actualWithLifecyclePhaseResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLifecyclePhaseResult.description());
    assertEquals(1L, actualWithLifecyclePhaseResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithLifecyclePhaseResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE, actualWithLifecyclePhaseResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withName(String)"})
  void testWithName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithNameResult = immutableChangeInitiative.withName("42");

    // Assert
    assertSame(immutableChangeInitiative, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithNameResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualWithNameResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withOrganisationalUnitId(Long)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withOrganisationalUnitId(Long)"
  })
  void testWithOrganisationalUnitId() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithOrganisationalUnitIdResult =
        immutableChangeInitiative.withOrganisationalUnitId(1L);

    // Assert
    assertSame(immutableChangeInitiative, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withOrganisationalUnitId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Long); when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeInitiative ImmutableChangeInitiative.withOrganisationalUnitId(Long)"
  })
  void testWithOrganisationalUnitId_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithOrganisationalUnitIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withOrganisationalUnitId(42L);

    // Assert
    assertEquals("Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("Provenance", actualWithOrganisationalUnitIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOrganisationalUnitIdResult.description());
    assertEquals(42L, actualWithOrganisationalUnitIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithOrganisationalUnitIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithOrganisationalUnitIdResult.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE,
        actualWithOrganisationalUnitIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withParentId(Optional)"})
  void testWithParentIdWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeInitiative actualWithParentIdResult =
        immutableChangeInitiative.withParentId(optional);

    // Assert
    assertSame(immutableChangeInitiative, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withParentId(Optional)"})
  void testWithParentIdWithOptional_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(2L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeInitiative actualWithParentIdResult =
        immutableChangeInitiative.withParentId(optional);

    // Assert
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals("Provenance", actualWithParentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(1L, actualWithParentIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithParentIdResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualWithParentIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withParentId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withParentId(long)"})
  void testWithParentIdWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithParentIdResult = immutableChangeInitiative.withParentId(1L);

    // Assert
    assertSame(immutableChangeInitiative, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withParentId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withParentId(long)"})
  void testWithParentIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithParentIdResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withParentId(42L);

    // Assert
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals("Provenance", actualWithParentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(1L, actualWithParentIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithParentIdResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualWithParentIdResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("42");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithProvenanceResult =
        immutableChangeInitiative.withProvenance("42");

    // Assert
    assertSame(immutableChangeInitiative, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableChangeInitiative#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withProvenance(String)"})
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");

    // Act
    ImmutableChangeInitiative actualWithProvenanceResult =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithProvenanceResult.lifecyclePhase());
    assertEquals(
        ChangeInitiativeKind.INITIATIVE, actualWithProvenanceResult.changeInitiativeKind());
  }

  /**
   * Test {@link ImmutableChangeInitiative#withStartDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableChangeInitiative#withStartDate(Date)}
   */
  @Test
  @DisplayName("Test withStartDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeInitiative ImmutableChangeInitiative.withStartDate(Date)"})
  void testWithStartDate() {
    // Arrange
    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    ImmutableChangeInitiative immutableChangeInitiative =
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableChangeInitiative actualWithStartDateResult =
        immutableChangeInitiative.withStartDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableChangeInitiative, actualWithStartDateResult);
  }
}
