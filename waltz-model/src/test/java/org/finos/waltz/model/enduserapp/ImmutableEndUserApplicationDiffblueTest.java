package org.finos.waltz.model.enduserapp;

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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.enduserapp.ImmutableEndUserApplication.Builder;
import org.finos.waltz.model.enduserapp.ImmutableEndUserApplication.Json;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEndUserApplicationDiffblueTest {
  /**
   * Test Builder {@link Builder#applicationKind(String)}.
   *
   * <ul>
   *   <li>When {@code Application Kind}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationKind(String)}
   */
  @Test
  @DisplayName("Test Builder applicationKind(String); when 'Application Kind'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationKind(String)"})
  void testBuilderApplicationKind_whenApplicationKind_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEndUserApplication.builder();

    // Act
    Builder actualApplicationKindResult = builderResult.applicationKind("Application Kind");

    // Assert
    assertSame(builderResult, actualApplicationKindResult);
  }

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
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualProvenanceResult =
        actualIdResult
            .id(id)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        actualProvenanceResult.riskRating(riskRating).build();

    // Assert
    CriticalityValue riskRatingResult = actualImmutableEndUserApplication.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualImmutableEndUserApplication.applicationKind());
    assertEquals("Name", actualImmutableEndUserApplication.name());
    assertEquals("Provenance", actualImmutableEndUserApplication.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEndUserApplication.description());
    assertEquals(1L, actualImmutableEndUserApplication.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableEndUserApplication.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableEndUserApplication.lifecyclePhase());
    assertTrue(actualImmutableEndUserApplication.isPromoted());
    assertSame(riskRating, riskRatingResult);
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
    Builder builderResult = ImmutableEndUserApplication.builder();
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
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableEndUserApplication);
    ImmutableEndUserApplication actualImmutableEndUserApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication2);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EndUserApplication)} with {@code EndUserApplication}.
   *
   * <p>Method under test: {@link Builder#from(EndUserApplication)}
   */
  @Test
  @DisplayName("Test Builder from(EndUserApplication) with 'EndUserApplication'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EndUserApplication)"})
  void testBuilderFromWithEndUserApplication() {
    // Arrange
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EndUserApplication)} with {@code EndUserApplication}.
   *
   * <p>Method under test: {@link Builder#from(EndUserApplication)}
   */
  @Test
  @DisplayName("Test Builder from(EndUserApplication) with 'EndUserApplication'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EndUserApplication)"})
  void testBuilderFromWithEndUserApplication2() {
    // Arrange
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description(null)
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableEndUserApplication);
    ImmutableEndUserApplication actualImmutableEndUserApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication2);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableEndUserApplication);
    ImmutableEndUserApplication actualImmutableEndUserApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication2);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableEndUserApplication);
    ImmutableEndUserApplication actualImmutableEndUserApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication2);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableEndUserApplication);
    ImmutableEndUserApplication actualImmutableEndUserApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication2);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication instance =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    ImmutableEndUserApplication actualImmutableEndUserApplication =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEndUserApplication);
    ImmutableEndUserApplication actualImmutableEndUserApplication2 = builderResult.build();
    assertEquals(instance, actualImmutableEndUserApplication2);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isPromoted(Boolean)}.
   *
   * <p>Method under test: {@link Builder#isPromoted(Boolean)}
   */
  @Test
  @DisplayName("Test Builder isPromoted(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPromoted(Boolean)"})
  void testBuilderIsPromoted() {
    // Arrange
    Builder builderResult = ImmutableEndUserApplication.builder();

    // Act
    Builder actualIsPromotedResult = builderResult.isPromoted(true);

    // Assert
    assertSame(builderResult, actualIsPromotedResult);
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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

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
    Builder builderResult = ImmutableEndUserApplication.builder();

    // Act
    Builder actualOrganisationalUnitIdResult = builderResult.organisationalUnitId(1L);

    // Assert
    assertSame(builderResult, actualOrganisationalUnitIdResult);
  }

  /**
   * Test Builder {@link Builder#riskRating(CriticalityValue)}.
   *
   * <ul>
   *   <li>When {@link CriticalityValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#riskRating(CriticalityValue)}
   */
  @Test
  @DisplayName(
      "Test Builder riskRating(CriticalityValue); when CriticalityValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.riskRating(CriticalityValue)"})
  void testBuilderRiskRating_whenCriticalityValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEndUserApplication.builder();

    // Act
    Builder actualRiskRatingResult = builderResult.riskRating(CriticalityValue.of("42"));

    // Assert
    assertSame(builderResult, actualRiskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#copyOf(EndUserApplication)}.
   *
   * <ul>
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#copyOf(EndUserApplication)}
   */
  @Test
  @DisplayName("Test copyOf(EndUserApplication); then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.copyOf(EndUserApplication)"
  })
  void testCopyOf_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");
    ImmutableEndUserApplication instance = provenanceResult.riskRating(riskRating).build();

    // Act
    ImmutableEndUserApplication actualCopyOfResult = ImmutableEndUserApplication.copyOf(instance);

    // Assert
    CriticalityValue riskRatingResult = actualCopyOfResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualCopyOfResult.applicationKind());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}, and {@link
   * ImmutableEndUserApplication#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEndUserApplication#equals(Object)}
   *   <li>{@link ImmutableEndUserApplication#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication2 =
        provenanceResult2.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    assertEquals(immutableEndUserApplication, immutableEndUserApplication2);
    assertEquals(immutableEndUserApplication.hashCode(), immutableEndUserApplication2.hashCode());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}, and {@link
   * ImmutableEndUserApplication#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEndUserApplication#equals(Object)}
   *   <li>{@link ImmutableEndUserApplication#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act and Assert
    assertEquals(immutableEndUserApplication, immutableEndUserApplication);
    int expectedHashCodeResult = immutableEndUserApplication.hashCode();
    assertEquals(expectedHashCodeResult, immutableEndUserApplication.hashCode());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Name")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(false)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ACTOR)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Provenance")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(2L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Name");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("Name")).build();

    Builder provenanceResult2 =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableEndUserApplication,
        provenanceResult2.riskRating(CriticalityValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(provenanceResult.riskRating(CriticalityValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutableEndUserApplication#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEndUserApplication.equals(Object)",
    "int ImmutableEndUserApplication.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult.riskRating(CriticalityValue.of("42")).build(),
        "Different type to ImmutableEndUserApplication");
  }

  /**
   * Test {@link ImmutableEndUserApplication#externalId()}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEndUserApplication.externalId()"})
  void testExternalId() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act
    Optional<String> actualExternalIdResult =
        provenanceResult.riskRating(CriticalityValue.of("42")).build().externalId();

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
   *   <li>{@link ImmutableEndUserApplication#applicationKind()}
   *   <li>{@link ImmutableEndUserApplication#description()}
   *   <li>{@link ImmutableEndUserApplication#isPromoted()}
   *   <li>{@link ImmutableEndUserApplication#lifecyclePhase()}
   *   <li>{@link ImmutableEndUserApplication#name()}
   *   <li>{@link ImmutableEndUserApplication#organisationalUnitId()}
   *   <li>{@link ImmutableEndUserApplication#riskRating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEndUserApplication.applicationKind()",
    "String ImmutableEndUserApplication.description()",
    "Boolean ImmutableEndUserApplication.isPromoted()",
    "LifecyclePhase ImmutableEndUserApplication.lifecyclePhase()",
    "String ImmutableEndUserApplication.name()",
    "Long ImmutableEndUserApplication.organisationalUnitId()",
    "CriticalityValue ImmutableEndUserApplication.riskRating()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(riskRating).build();

    // Act
    String actualApplicationKindResult = immutableEndUserApplication.applicationKind();
    String actualDescriptionResult = immutableEndUserApplication.description();
    Boolean actualIsPromotedResult = immutableEndUserApplication.isPromoted();
    LifecyclePhase actualLifecyclePhaseResult = immutableEndUserApplication.lifecyclePhase();
    String actualNameResult = immutableEndUserApplication.name();
    Long actualOrganisationalUnitIdResult = immutableEndUserApplication.organisationalUnitId();
    CriticalityValue actualRiskRatingResult = immutableEndUserApplication.riskRating();

    // Assert
    assertEquals("42", actualRiskRatingResult.value());
    assertEquals("Application Kind", actualApplicationKindResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualOrganisationalUnitIdResult.longValue());
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
    assertTrue(actualIsPromotedResult);
    assertSame(riskRating, actualRiskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#id()}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEndUserApplication.id()"})
  void testId() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act
    Optional<Long> actualIdResult =
        provenanceResult.riskRating(CriticalityValue.of("42")).build().id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#applicationKind()}.
   *
   * <p>Method under test: {@link Json#applicationKind()}
   */
  @Test
  @DisplayName("Test Json applicationKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.applicationKind()"})
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationKind());
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
   * Test Json {@link Json#isPromoted()}.
   *
   * <p>Method under test: {@link Json#isPromoted()}
   */
  @Test
  @DisplayName("Test Json isPromoted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Json.isPromoted()"})
  void testJsonIsPromoted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isPromoted());
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
    assertNull(actualJson.isPromoted);
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.applicationKind);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.riskRating);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
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
   * Test Json {@link Json#riskRating()}.
   *
   * <p>Method under test: {@link Json#riskRating()}
   */
  @Test
  @DisplayName("Test Json riskRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CriticalityValue Json.riskRating()"})
  void testJsonRiskRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().riskRating());
  }

  /**
   * Test {@link ImmutableEndUserApplication#kind()}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableEndUserApplication.kind()"})
  void testKind() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        EntityKind.ALL, provenanceResult.riskRating(CriticalityValue.of("42")).build().kind());
  }

  /**
   * Test {@link ImmutableEndUserApplication#provenance()}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEndUserApplication.provenance()"})
  void testProvenance() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        "Provenance", provenanceResult.riskRating(CriticalityValue.of("42")).build().provenance());
  }

  /**
   * Test {@link ImmutableEndUserApplication#toString()}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEndUserApplication.toString()"})
  void testToString() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        "EndUserApplication{id=1, externalId=42, name=Name, provenance=Provenance, organisationalUnitId=1,"
            + " applicationKind=Application Kind, lifecyclePhase=PRODUCTION, riskRating=42, isPromoted=true,"
            + " kind=ALL}",
        provenanceResult.riskRating(CriticalityValue.of("42")).build().toString());
  }

  /**
   * Test {@link ImmutableEndUserApplication#withApplicationKind(String)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withApplicationKind(String)}
   */
  @Test
  @DisplayName("Test withApplicationKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withApplicationKind(String)"
  })
  void testWithApplicationKind() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("42")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithApplicationKindResult =
        immutableEndUserApplication.withApplicationKind("42");

    // Assert
    assertSame(immutableEndUserApplication, actualWithApplicationKindResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withApplicationKind(String)}.
   *
   * <ul>
   *   <li>Then return applicationKind is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withApplicationKind(String)}
   */
  @Test
  @DisplayName("Test withApplicationKind(String); then return applicationKind is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withApplicationKind(String)"
  })
  void testWithApplicationKind_thenReturnApplicationKindIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithApplicationKindResult =
        provenanceResult.riskRating(riskRating).build().withApplicationKind("42");

    // Assert
    assertEquals("42", actualWithApplicationKindResult.applicationKind());
    CriticalityValue riskRatingResult = actualWithApplicationKindResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Name", actualWithApplicationKindResult.name());
    assertEquals("Provenance", actualWithApplicationKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithApplicationKindResult.description());
    assertEquals(1L, actualWithApplicationKindResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithApplicationKindResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithApplicationKindResult.lifecyclePhase());
    assertTrue(actualWithApplicationKindResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithDescriptionResult =
        immutableEndUserApplication.withDescription("42");

    // Assert
    assertEquals(immutableEndUserApplication, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("42")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithDescriptionResult =
        immutableEndUserApplication.withDescription("42");

    // Assert
    assertSame(immutableEndUserApplication, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEndUserApplication actualWithExternalIdResult =
        immutableEndUserApplication.withExternalId(optional);

    // Assert
    assertSame(immutableEndUserApplication, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(riskRating).build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableEndUserApplication actualWithExternalIdResult =
        immutableEndUserApplication.withExternalId(optional);

    // Assert
    CriticalityValue riskRatingResult = actualWithExternalIdResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithExternalIdResult.applicationKind());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
    assertTrue(actualWithExternalIdResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithExternalIdResult =
        immutableEndUserApplication.withExternalId("42");

    // Assert
    assertSame(immutableEndUserApplication, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithExternalIdResult =
        provenanceResult.riskRating(riskRating).build().withExternalId("0123456789ABCDEF");

    // Assert
    CriticalityValue riskRatingResult = actualWithExternalIdResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithExternalIdResult.applicationKind());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithExternalIdResult.lifecyclePhase());
    assertTrue(actualWithExternalIdResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEndUserApplication ImmutableEndUserApplication.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEndUserApplication actualWithIdResult = immutableEndUserApplication.withId(optional);

    // Assert
    assertSame(immutableEndUserApplication, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEndUserApplication ImmutableEndUserApplication.withId(Optional)"})
  void testWithIdWithOptional_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(riskRating).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEndUserApplication actualWithIdResult = immutableEndUserApplication.withId(optional);

    // Assert
    CriticalityValue riskRatingResult = actualWithIdResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithIdResult.applicationKind());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIdResult.lifecyclePhase());
    assertTrue(actualWithIdResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEndUserApplication ImmutableEndUserApplication.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithIdResult = immutableEndUserApplication.withId(1L);

    // Assert
    assertSame(immutableEndUserApplication, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEndUserApplication ImmutableEndUserApplication.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithIdResult =
        provenanceResult.riskRating(riskRating).build().withId(42L);

    // Assert
    CriticalityValue riskRatingResult = actualWithIdResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithIdResult.applicationKind());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIdResult.lifecyclePhase());
    assertTrue(actualWithIdResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withIsPromoted(Boolean)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withIsPromoted(Boolean)}
   */
  @Test
  @DisplayName("Test withIsPromoted(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withIsPromoted(Boolean)"
  })
  void testWithIsPromoted() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithIsPromotedResult =
        immutableEndUserApplication.withIsPromoted(true);

    // Assert
    assertSame(immutableEndUserApplication, actualWithIsPromotedResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withIsPromoted(Boolean)}.
   *
   * <ul>
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withIsPromoted(Boolean)}
   */
  @Test
  @DisplayName("Test withIsPromoted(Boolean); then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withIsPromoted(Boolean)"
  })
  void testWithIsPromoted_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(false)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithIsPromotedResult =
        provenanceResult.riskRating(riskRating).build().withIsPromoted(true);

    // Assert
    CriticalityValue riskRatingResult = actualWithIsPromotedResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithIsPromotedResult.applicationKind());
    assertEquals("Name", actualWithIsPromotedResult.name());
    assertEquals("Provenance", actualWithIsPromotedResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsPromotedResult.description());
    assertEquals(1L, actualWithIsPromotedResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithIsPromotedResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithIsPromotedResult.lifecyclePhase());
    assertTrue(actualWithIsPromotedResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithKindResult =
        immutableEndUserApplication.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEndUserApplication, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withKind(EntityKind)"
  })
  void testWithKind_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ACTOR)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithKindResult =
        provenanceResult.riskRating(riskRating).build().withKind(EntityKind.ALL);

    // Assert
    CriticalityValue riskRatingResult = actualWithKindResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithKindResult.applicationKind());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithKindResult.lifecyclePhase());
    assertTrue(actualWithKindResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithLifecyclePhaseResult =
        immutableEndUserApplication.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableEndUserApplication, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withLifecyclePhase(LifecyclePhase)"
  })
  void testWithLifecyclePhase_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithLifecyclePhaseResult =
        provenanceResult
            .riskRating(riskRating)
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    CriticalityValue riskRatingResult = actualWithLifecyclePhaseResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithLifecyclePhaseResult.applicationKind());
    assertEquals("Name", actualWithLifecyclePhaseResult.name());
    assertEquals("Provenance", actualWithLifecyclePhaseResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLifecyclePhaseResult.description());
    assertEquals(1L, actualWithLifecyclePhaseResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithLifecyclePhaseResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
    assertTrue(actualWithLifecyclePhaseResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEndUserApplication ImmutableEndUserApplication.withName(String)"})
  void testWithName() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("42")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithNameResult = immutableEndUserApplication.withName("42");

    // Assert
    assertSame(immutableEndUserApplication, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEndUserApplication ImmutableEndUserApplication.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithNameResult =
        provenanceResult.riskRating(riskRating).build().withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    CriticalityValue riskRatingResult = actualWithNameResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithNameResult.applicationKind());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithNameResult.lifecyclePhase());
    assertTrue(actualWithNameResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withOrganisationalUnitId(Long)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withOrganisationalUnitId(Long)"
  })
  void testWithOrganisationalUnitId() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithOrganisationalUnitIdResult =
        immutableEndUserApplication.withOrganisationalUnitId(1L);

    // Assert
    assertSame(immutableEndUserApplication, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withOrganisationalUnitId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return riskRating value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test withOrganisationalUnitId(Long); when forty-two; then return riskRating value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withOrganisationalUnitId(Long)"
  })
  void testWithOrganisationalUnitId_whenFortyTwo_thenReturnRiskRatingValueIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithOrganisationalUnitIdResult =
        provenanceResult.riskRating(riskRating).build().withOrganisationalUnitId(42L);

    // Assert
    CriticalityValue riskRatingResult = actualWithOrganisationalUnitIdResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithOrganisationalUnitIdResult.applicationKind());
    assertEquals("Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("Provenance", actualWithOrganisationalUnitIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOrganisationalUnitIdResult.description());
    assertEquals(42L, actualWithOrganisationalUnitIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithOrganisationalUnitIdResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithOrganisationalUnitIdResult.lifecyclePhase());
    assertTrue(actualWithOrganisationalUnitIdResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("42");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithProvenanceResult =
        immutableEndUserApplication.withProvenance("42");

    // Assert
    assertSame(immutableEndUserApplication, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withProvenance(String)"
  })
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    CriticalityValue riskRating = CriticalityValue.of("42");

    // Act
    ImmutableEndUserApplication actualWithProvenanceResult =
        provenanceResult.riskRating(riskRating).build().withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    CriticalityValue riskRatingResult = actualWithProvenanceResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualWithProvenanceResult.applicationKind());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithProvenanceResult.lifecyclePhase());
    assertTrue(actualWithProvenanceResult.isPromoted());
    assertSame(riskRating, riskRatingResult);
  }

  /**
   * Test {@link ImmutableEndUserApplication#withRiskRating(CriticalityValue)}.
   *
   * <p>Method under test: {@link ImmutableEndUserApplication#withRiskRating(CriticalityValue)}
   */
  @Test
  @DisplayName("Test withRiskRating(CriticalityValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEndUserApplication ImmutableEndUserApplication.withRiskRating(CriticalityValue)"
  })
  void testWithRiskRating() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");
    ImmutableEndUserApplication immutableEndUserApplication =
        provenanceResult.riskRating(CriticalityValue.of("42")).build();

    // Act
    ImmutableEndUserApplication actualWithRiskRatingResult =
        immutableEndUserApplication.withRiskRating(CriticalityValue.of("42"));

    // Assert
    assertEquals(immutableEndUserApplication, actualWithRiskRatingResult);
  }
}
