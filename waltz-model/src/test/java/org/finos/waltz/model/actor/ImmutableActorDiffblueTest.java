package org.finos.waltz.model.actor;

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
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor.Builder;
import org.finos.waltz.model.actor.ImmutableActor.Json;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableActorDiffblueTest {
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
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActor Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableActor actualImmutableActor =
        actualIdResult
            .id(id)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableActor.lastUpdatedBy());
    assertEquals("Name", actualImmutableActor.name());
    assertEquals("Provenance", actualImmutableActor.provenance());
    assertEquals("The characteristics of someone or something", actualImmutableActor.description());
    assertEquals(EntityKind.ALL, actualImmutableActor.kind());
    assertTrue(actualImmutableActor.isExternal());
    assertSame(lastUpdatedAt, actualImmutableActor.lastUpdatedAt());
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
    Builder builderResult = ImmutableActor.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(Actor)} with {@code Actor}.
   *
   * <p>Method under test: {@link Builder#from(Actor)}
   */
  @Test
  @DisplayName("Test Builder from(Actor) with 'Actor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Actor)"})
  void testBuilderFromWithActor() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
  }

  /**
   * Test Builder {@link Builder#from(Actor)} with {@code Actor}.
   *
   * <p>Method under test: {@link Builder#from(Actor)}
   */
  @Test
  @DisplayName("Test Builder from(Actor) with 'Actor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Actor)"})
  void testBuilderFromWithActor2() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
  }

  /**
   * Test Builder {@link Builder#from(Actor)} with {@code Actor}.
   *
   * <p>Method under test: {@link Builder#from(Actor)}
   */
  @Test
  @DisplayName("Test Builder from(Actor) with 'Actor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Actor)"})
  void testBuilderFromWithActor3() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(false)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
  void testBuilderFromWithEntityKindProvider2() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
  void testBuilderFromWithEntityKindProvider3() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(false)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(false)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
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
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();

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
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();
    ImmutableActor instance =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(false)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableActor actualImmutableActor = builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableActor);
    ImmutableActor actualImmutableActor2 = builderResult.build();
    assertEquals(instance, actualImmutableActor2);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isExternal(boolean)}.
   *
   * <p>Method under test: {@link Builder#isExternal(boolean)}
   */
  @Test
  @DisplayName("Test Builder isExternal(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isExternal(boolean)"})
  void testBuilderIsExternal() {
    // Arrange
    Builder builderResult = ImmutableActor.builder();

    // Act
    Builder actualIsExternalResult = builderResult.isExternal(true);

    // Assert
    assertSame(builderResult, actualIsExternalResult);
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
    Builder builderResult = ImmutableActor.builder();

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
    Builder builderResult = ImmutableActor.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableActor#copyOf(Actor)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#copyOf(Actor)}
   */
  @Test
  @DisplayName("Test copyOf(Actor); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.copyOf(Actor)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableActor instance =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableActor actualCopyOfResult = ImmutableActor.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}, and {@link ImmutableActor#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableActor#equals(Object)}
   *   <li>{@link ImmutableActor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();
    ImmutableActor immutableActor2 =
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
            .build();

    // Act and Assert
    assertEquals(immutableActor, immutableActor2);
    assertEquals(immutableActor.hashCode(), immutableActor2.hashCode());
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}, and {@link ImmutableActor#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableActor#equals(Object)}
   *   <li>{@link ImmutableActor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act and Assert
    assertEquals(immutableActor, immutableActor);
    int expectedHashCodeResult = immutableActor.hashCode();
    assertEquals(expectedHashCodeResult, immutableActor.hashCode());
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(false)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActor,
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
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableActor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableActor.equals(Object)", "int ImmutableActor.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableActor");
  }

  /**
   * Test {@link ImmutableActor#externalId()}.
   *
   * <p>Method under test: {@link ImmutableActor#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableActor.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
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
   *   <li>{@link ImmutableActor#description()}
   *   <li>{@link ImmutableActor#isExternal()}
   *   <li>{@link ImmutableActor#lastUpdatedBy()}
   *   <li>{@link ImmutableActor#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableActor.description()",
    "boolean ImmutableActor.isExternal()",
    "String ImmutableActor.lastUpdatedBy()",
    "String ImmutableActor.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    String actualDescriptionResult = immutableActor.description();
    boolean actualIsExternalResult = immutableActor.isExternal();
    String actualLastUpdatedByResult = immutableActor.lastUpdatedBy();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", immutableActor.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(actualIsExternalResult);
  }

  /**
   * Test {@link ImmutableActor#id()}.
   *
   * <p>Method under test: {@link ImmutableActor#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableActor.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
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
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#isExternal()}.
   *
   * <p>Method under test: {@link Json#isExternal()}
   */
  @Test
  @DisplayName("Test Json isExternal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isExternal()"})
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isExternal());
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
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isExternal);
    assertFalse(actualJson.isExternalIsSet);
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
   * Test Json {@link Json#setIsExternal(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsExternal(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsExternal(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsExternal(boolean)"})
  void testJsonSetIsExternal() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsExternal(true);

    // Assert
    assertTrue(json.isExternal);
    assertTrue(json.isExternalIsSet);
  }

  /**
   * Test {@link ImmutableActor#kind()}.
   *
   * <p>Method under test: {@link ImmutableActor#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableActor.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
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
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableActor#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableActor#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableActor.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#provenance()}.
   *
   * <p>Method under test: {@link ImmutableActor#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableActor.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
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
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableActor#toString()}.
   *
   * <p>Method under test: {@link ImmutableActor#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableActor.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Actor{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " externalId=42, isExternal=true, kind=ALL}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableActor#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableActor#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    ImmutableActor actualWithDescriptionResult = immutableActor.withDescription("42");

    // Assert
    assertEquals(immutableActor, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableActor#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableActor#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableActor actualWithDescriptionResult = immutableActor.withDescription("42");

    // Assert
    assertSame(immutableActor, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableActor#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableActor#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableActor actualWithExternalIdResult = immutableActor.withExternalId(optional);

    // Assert
    assertSame(immutableActor, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableActor#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableActor actualWithExternalIdResult = immutableActor.withExternalId(optional);

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
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertTrue(actualWithExternalIdResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableActor#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    ImmutableActor actualWithExternalIdResult = immutableActor.withExternalId("42");

    // Assert
    assertSame(immutableActor, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableActor#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithExternalIdResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
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
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertTrue(actualWithExternalIdResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableActor#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableActor actualWithIdResult = immutableActor.withId(optional);

    // Assert
    assertSame(immutableActor, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableActor#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableActor actualWithIdResult = immutableActor.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableActor#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    ImmutableActor actualWithIdResult = immutableActor.withId(1L);

    // Assert
    assertSame(immutableActor, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableActor#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withId(long)"})
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithIdResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withIsExternal(boolean)}.
   *
   * <p>Method under test: {@link ImmutableActor#withIsExternal(boolean)}
   */
  @Test
  @DisplayName("Test withIsExternal(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withIsExternal(boolean)"})
  void testWithIsExternal() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    ImmutableActor actualWithIsExternalResult = immutableActor.withIsExternal(true);

    // Assert
    assertSame(immutableActor, actualWithIsExternalResult);
  }

  /**
   * Test {@link ImmutableActor#withIsExternal(boolean)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withIsExternal(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsExternal(boolean); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withIsExternal(boolean)"})
  void testWithIsExternal_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithIsExternalResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(false)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withIsExternal(true);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIsExternalResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIsExternalResult.lastUpdatedBy());
    assertEquals("Name", actualWithIsExternalResult.name());
    assertEquals("Provenance", actualWithIsExternalResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsExternalResult.description());
    assertEquals(EntityKind.ALL, actualWithIsExternalResult.kind());
    assertTrue(actualWithIsExternalResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableActor#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    ImmutableActor actualWithKindResult = immutableActor.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableActor, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableActor#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withKind(EntityKind)"})
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithKindResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertTrue(actualWithKindResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableActor#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableActor immutableActor =
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
            .build();

    // Act
    ImmutableActor actualWithLastUpdatedAtResult =
        immutableActor.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableActor, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableActor#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableActor#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableActor actualWithLastUpdatedByResult = immutableActor.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableActor, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableActor#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithLastUpdatedByResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
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
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertTrue(actualWithLastUpdatedByResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableActor#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableActor actualWithNameResult = immutableActor.withName("42");

    // Assert
    assertSame(immutableActor, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableActor#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withName(String)"})
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithNameResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
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
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertTrue(actualWithNameResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableActor#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableActor#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableActor immutableActor =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("42")
            .build();

    // Act
    ImmutableActor actualWithProvenanceResult = immutableActor.withProvenance("42");

    // Assert
    assertSame(immutableActor, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableActor#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActor#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActor ImmutableActor.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableActor actualWithProvenanceResult =
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
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
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertTrue(actualWithProvenanceResult.isExternal());
    assertSame(ofResult, toLocalDateResult);
  }
}
