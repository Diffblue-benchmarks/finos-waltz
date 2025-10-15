package org.finos.waltz.model.entity_svg_diagram;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.entity_svg_diagram.ImmutableEntitySvgDiagram.Builder;
import org.finos.waltz.model.entity_svg_diagram.ImmutableEntitySvgDiagram.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntitySvgDiagramDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySvgDiagram Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualExternalIdResult =
        actualDescriptionResult.entityReference(entityReference).externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        actualIdResult.id(id).name("Name").provenance("Provenance").svg("Svg").build();

    // Assert
    assertEquals("Name", actualImmutableEntitySvgDiagram.name());
    assertEquals("Provenance", actualImmutableEntitySvgDiagram.provenance());
    assertEquals("Svg", actualImmutableEntitySvgDiagram.svg());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntitySvgDiagram.description());
    assertSame(entityReference, actualImmutableEntitySvgDiagram.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram2);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntitySvgDiagram)} with {@code EntitySvgDiagram}.
   *
   * <p>Method under test: {@link Builder#from(EntitySvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySvgDiagram) with 'EntitySvgDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntitySvgDiagram)"})
  void testBuilderFromWithEntitySvgDiagram() {
    // Arrange
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntitySvgDiagram)} with {@code EntitySvgDiagram}.
   *
   * <p>Method under test: {@link Builder#from(EntitySvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySvgDiagram) with 'EntitySvgDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntitySvgDiagram)"})
  void testBuilderFromWithEntitySvgDiagram2() {
    // Arrange
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult = ImmutableEntitySvgDiagram.builder().description(null);
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram2);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram2);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram2);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult = ImmutableEntitySvgDiagram.builder().description(null);
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram2);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntitySvgDiagram);
    ImmutableEntitySvgDiagram actualImmutableEntitySvgDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableEntitySvgDiagram2);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#svg(String)}.
   *
   * <ul>
   *   <li>When {@code Svg}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#svg(String)}
   */
  @Test
  @DisplayName("Test Builder svg(String); when 'Svg'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.svg(String)"})
  void testBuilderSvg_whenSvg_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntitySvgDiagram.builder();

    // Act
    Builder actualSvgResult = builderResult.svg("Svg");

    // Assert
    assertSame(builderResult, actualSvgResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#copyOf(EntitySvgDiagram)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#copyOf(EntitySvgDiagram)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntitySvgDiagram); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.copyOf(EntitySvgDiagram)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram instance =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualCopyOfResult = ImmutableEntitySvgDiagram.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}, and {@link
   * ImmutableEntitySvgDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntitySvgDiagram#equals(Object)}
   *   <li>{@link ImmutableEntitySvgDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram2 =
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(immutableEntitySvgDiagram, immutableEntitySvgDiagram2);
    assertEquals(immutableEntitySvgDiagram.hashCode(), immutableEntitySvgDiagram2.hashCode());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}, and {@link
   * ImmutableEntitySvgDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntitySvgDiagram#equals(Object)}
   *   <li>{@link ImmutableEntitySvgDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(immutableEntitySvgDiagram, immutableEntitySvgDiagram);
    int expectedHashCodeResult = immutableEntitySvgDiagram.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntitySvgDiagram.hashCode());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntitySvgDiagram,
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("Name")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntitySvgDiagram,
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(2L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntitySvgDiagram,
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Provenance")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntitySvgDiagram,
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Name")
            .svg("Svg")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntitySvgDiagram,
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Name")
            .build();

    Builder descriptionResult2 =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntitySvgDiagram,
        descriptionResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySvgDiagram.equals(Object)",
    "int ImmutableEntitySvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build(),
        "Different type to ImmutableEntitySvgDiagram");
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#externalId()}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntitySvgDiagram.externalId()"})
  void testExternalId() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    Optional<String> actualExternalIdResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setProvenance(null);
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setSvg("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of seven.
   *   <li>When {@link Json} (default constructor) Id is of seven.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of seven; when Json (default constructor) Id is of seven; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.fromJson(Json)"})
  void testFromJson_givenOfSeven_whenJsonIdIsOfSeven_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(7L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);
    json.setProvenance(null);
    json.setExternalId(null);
    json.setSvg("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("The characteristics of someone or something");
    json.setProvenance(null);
    json.setExternalId(null);
    json.setSvg("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("waltz", actualFromJsonResult.provenance());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.fromJson(Json)"})
  void testFromJson_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setProvenance(null);
    json.setExternalId(null);
    json.setSvg("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code Json}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'Json'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.fromJson(Json)"})
  void testFromJson_whenJsonProvenanceIsJson_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setProvenance("Json");
    json.setExternalId(null);
    json.setSvg("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableEntitySvgDiagram actualFromJsonResult = ImmutableEntitySvgDiagram.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals("Json", actualFromJsonResult.svg());
    assertNull(actualFromJsonResult.description());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntitySvgDiagram#description()}
   *   <li>{@link ImmutableEntitySvgDiagram#entityReference()}
   *   <li>{@link ImmutableEntitySvgDiagram#name()}
   *   <li>{@link ImmutableEntitySvgDiagram#provenance()}
   *   <li>{@link ImmutableEntitySvgDiagram#svg()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntitySvgDiagram.description()",
    "EntityReference ImmutableEntitySvgDiagram.entityReference()",
    "String ImmutableEntitySvgDiagram.name()",
    "String ImmutableEntitySvgDiagram.provenance()",
    "String ImmutableEntitySvgDiagram.svg()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    String actualDescriptionResult = immutableEntitySvgDiagram.description();
    EntityReference actualEntityReferenceResult = immutableEntitySvgDiagram.entityReference();
    String actualNameResult = immutableEntitySvgDiagram.name();
    String actualProvenanceResult = immutableEntitySvgDiagram.provenance();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualNameResult);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals("Svg", immutableEntitySvgDiagram.svg());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#id()}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntitySvgDiagram.id()"})
  void testId() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    Optional<Long> actualIdResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
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
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
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
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.svg);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
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
   * Test Json {@link Json#svg()}.
   *
   * <p>Method under test: {@link Json#svg()}
   */
  @Test
  @DisplayName("Test Json svg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.svg()"})
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().svg());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntitySvgDiagram.toString()"})
  void testToString() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertEquals(
        "EntitySvgDiagram{id=1, name=Name, provenance=Provenance, externalId=42, svg=Svg, entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithDescriptionResult =
        immutableEntitySvgDiagram.withDescription("42");

    // Assert
    assertEquals(immutableEntitySvgDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder descriptionResult = ImmutableEntitySvgDiagram.builder().description("42");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithDescriptionResult =
        immutableEntitySvgDiagram.withDescription("42");

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithEntityReferenceResult =
        immutableEntitySvgDiagram.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntitySvgDiagram, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntitySvgDiagram actualWithExternalIdResult =
        immutableEntitySvgDiagram.withExternalId(optional);

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableEntitySvgDiagram actualWithExternalIdResult =
        immutableEntitySvgDiagram.withExternalId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithExternalIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("Svg", actualWithExternalIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithExternalIdResult =
        immutableEntitySvgDiagram.withExternalId("42");

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withExternalId(String)"})
  void testWithExternalIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableEntitySvgDiagram actualWithExternalIdResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference entityReferenceResult = actualWithExternalIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("Svg", actualWithExternalIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntitySvgDiagram actualWithIdResult = immutableEntitySvgDiagram.withId(optional);

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withId(Optional)"})
  void testWithIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(2L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntitySvgDiagram actualWithIdResult = immutableEntitySvgDiagram.withId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Svg", actualWithIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithIdResult = immutableEntitySvgDiagram.withId(1L);

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withId(long)"})
  void testWithIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableEntitySvgDiagram actualWithIdResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Svg", actualWithIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withName(String)"})
  void testWithName() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("42")
            .provenance("Provenance")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithNameResult = immutableEntitySvgDiagram.withName("42");

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withName(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withName(String)"})
  void testWithName_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableEntitySvgDiagram actualWithNameResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withName("42");

    // Assert
    EntityReference entityReferenceResult = actualWithNameResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("Svg", actualWithNameResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("42")
            .svg("Svg")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithProvenanceResult =
        immutableEntitySvgDiagram.withProvenance("42");

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withProvenance(String)"})
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableEntitySvgDiagram actualWithProvenanceResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals("Svg", actualWithProvenanceResult.svg());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withSvg(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withSvg(String)"})
  void testWithSvg() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");
    ImmutableEntitySvgDiagram immutableEntitySvgDiagram =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("42")
            .build();

    // Act
    ImmutableEntitySvgDiagram actualWithSvgResult = immutableEntitySvgDiagram.withSvg("42");

    // Assert
    assertSame(immutableEntitySvgDiagram, actualWithSvgResult);
  }

  /**
   * Test {@link ImmutableEntitySvgDiagram#withSvg(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySvgDiagram#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySvgDiagram ImmutableEntitySvgDiagram.withSvg(String)"})
  void testWithSvg_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntitySvgDiagram.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableEntitySvgDiagram actualWithSvgResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .svg("Svg")
            .build()
            .withSvg("42");

    // Assert
    EntityReference entityReferenceResult = actualWithSvgResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSvgResult.svg());
    assertEquals("Name", actualWithSvgResult.name());
    assertEquals("Provenance", actualWithSvgResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithSvgResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }
}
