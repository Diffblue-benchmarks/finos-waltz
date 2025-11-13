package org.finos.waltz.model.datatype;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#rating(AuthoritativenessRatingValue)}
   *   <li>{@link Builder#targetInboundRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)",
    "Builder Builder.rating(AuthoritativenessRatingValue)",
    "Builder Builder.targetInboundRating(AuthoritativenessRatingValue)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableDataTypeDecorator.builder();
    ImmutableEntityReference decoratorEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualDecoratorEntityResult = actualBuilderResult.decoratorEntity(decoratorEntity);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualFlowClassificationRuleIdResult =
        actualDecoratorEntityResult.entityReference(entityReference).flowClassificationRuleId(1L);
    Optional<Long> flowClassificationRuleId = Optional.of(42L);
    Builder actualIdResult =
        actualFlowClassificationRuleIdResult
            .flowClassificationRuleId(flowClassificationRuleId)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualInboundFlowClassificationRuleIdResult =
        actualIdResult.id(id).inboundFlowClassificationRuleId(1L);
    Optional<Long> inboundFlowClassificationRuleId = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualProvenanceResult =
        actualInboundFlowClassificationRuleIdResult
            .inboundFlowClassificationRuleId(inboundFlowClassificationRuleId)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    Builder actualRatingResult = actualProvenanceResult.rating(rating);
    Builder actualRatingResult2 = actualRatingResult.rating(AuthoritativenessRatingValue.of("42"));
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    Builder actualTargetInboundRatingResult =
        actualRatingResult2.targetInboundRating(targetInboundRating);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        actualTargetInboundRatingResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableDataTypeDecorator.lastUpdatedBy());
    assertEquals("Provenance", actualImmutableDataTypeDecorator.provenance());
    assertEquals(1L, actualImmutableDataTypeDecorator.dataFlowId());
    assertEquals(1L, actualImmutableDataTypeDecorator.dataTypeId());
    assertFalse(actualImmutableDataTypeDecorator.isReadonly());
    assertSame(lastUpdatedAt, actualImmutableDataTypeDecorator.lastUpdatedAt());
    assertSame(decoratorEntity, actualImmutableDataTypeDecorator.decoratorEntity());
    assertSame(entityReference, actualImmutableDataTypeDecorator.entityReference());
  }

  /**
   * Test Builder {@link Builder#decoratorEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#decoratorEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder decoratorEntity(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.decoratorEntity(EntityReference)"})
  void testBuilderDecoratorEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualDecoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualDecoratorEntityResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#flowClassificationRuleId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#flowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRuleId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowClassificationRuleId(long)"})
  void testBuilderFlowClassificationRuleIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualFlowClassificationRuleIdResult = builderResult.flowClassificationRuleId(1L);

    // Assert
    assertSame(builderResult, actualFlowClassificationRuleIdResult);
  }

  /**
   * Test Builder {@link Builder#flowClassificationRuleId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#flowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRuleId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowClassificationRuleId(Optional)"})
  void testBuilderFlowClassificationRuleIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> flowClassificationRuleId = Optional.of(42L);

    // Act
    Builder actualFlowClassificationRuleIdResult =
        builderResult.flowClassificationRuleId(flowClassificationRuleId);

    // Assert
    assertSame(builderResult, actualFlowClassificationRuleIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecorator)} with {@code DataTypeDecorator}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecorator) with 'DataTypeDecorator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecorator)"})
  void testBuilderFromWithDataTypeDecorator() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecorator)} with {@code DataTypeDecorator}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecorator) with 'DataTypeDecorator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecorator)"})
  void testBuilderFromWithDataTypeDecorator2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.empty();

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecorator)} with {@code DataTypeDecorator}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecorator) with 'DataTypeDecorator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecorator)"})
  void testBuilderFromWithDataTypeDecorator3() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating = Optional.empty();
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator2);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator2);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator2);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.empty();

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator2);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating = Optional.empty();
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator2);
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
  void testBuilderFromWithProvenanceProvider6() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator =
        builderResult.from((WaltzEntity) instance).build();
    assertEquals(instance, actualImmutableDataTypeDecorator);
    ImmutableDataTypeDecorator actualImmutableDataTypeDecorator2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecorator2);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder from(WaltzEntity) with 'WaltzEntity'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

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
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#inboundFlowClassificationRuleId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#inboundFlowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test Builder inboundFlowClassificationRuleId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inboundFlowClassificationRuleId(long)"})
  void testBuilderInboundFlowClassificationRuleIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualInboundFlowClassificationRuleIdResult =
        builderResult.inboundFlowClassificationRuleId(1L);

    // Assert
    assertSame(builderResult, actualInboundFlowClassificationRuleIdResult);
  }

  /**
   * Test Builder {@link Builder#inboundFlowClassificationRuleId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#inboundFlowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test Builder inboundFlowClassificationRuleId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inboundFlowClassificationRuleId(Optional)"})
  void testBuilderInboundFlowClassificationRuleIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<Long> inboundFlowClassificationRuleId = Optional.of(42L);

    // Act
    Builder actualInboundFlowClassificationRuleIdResult =
        builderResult.inboundFlowClassificationRuleId(inboundFlowClassificationRuleId);

    // Assert
    assertSame(builderResult, actualInboundFlowClassificationRuleIdResult);
  }

  /**
   * Test Builder {@link Builder#isReadonly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadonly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadonly(boolean)"})
  void testBuilderIsReadonly() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualIsReadonlyResult = builderResult.isReadonly(true);

    // Assert
    assertSame(builderResult, actualIsReadonlyResult);
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
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#rating(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#rating(Optional)}
   */
  @Test
  @DisplayName("Test Builder rating(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(Optional)"})
  void testBuilderRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Builder actualRatingResult = builderResult.rating(rating);

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test Builder {@link Builder#targetInboundRating(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#targetInboundRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder targetInboundRating(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetInboundRating(Optional)"})
  void testBuilderTargetInboundRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Builder actualTargetInboundRatingResult =
        builderResult.targetInboundRating(targetInboundRating);

    // Assert
    assertSame(builderResult, actualTargetInboundRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#copyOf(DataTypeDecorator)}.
   *
   * <ul>
   *   <li>Then decoratorEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#copyOf(DataTypeDecorator)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DataTypeDecorator); then decoratorEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.copyOf(DataTypeDecorator)"
  })
  void testCopyOf_thenDecoratorEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator instance =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualCopyOfResult = ImmutableDataTypeDecorator.copyOf(instance);

    // Assert
    EntityReference decoratorEntityResult2 = actualCopyOfResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualCopyOfResult.dataFlowId());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#dataFlowId()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#dataFlowId()}
   */
  @Test
  @DisplayName("Test dataFlowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ImmutableDataTypeDecorator.dataFlowId()"})
  void testDataFlowId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(1L, ratingResult.targetInboundRating(targetInboundRating).build().dataFlowId());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#dataTypeId()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#dataTypeId()}
   */
  @Test
  @DisplayName("Test dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ImmutableDataTypeDecorator.dataTypeId()"})
  void testDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(1L, ratingResult.targetInboundRating(targetInboundRating).build().dataTypeId());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}, and {@link
   * ImmutableDataTypeDecorator#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecorator#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecorator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator2 =
        ratingResult2.targetInboundRating(targetInboundRating2).build();

    // Act and Assert
    assertEquals(immutableDataTypeDecorator, immutableDataTypeDecorator2);
    assertEquals(immutableDataTypeDecorator.hashCode(), immutableDataTypeDecorator2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}, and {@link
   * ImmutableDataTypeDecorator#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecorator#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecorator#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act and Assert
    assertEquals(immutableDataTypeDecorator, immutableDataTypeDecorator);
    int expectedHashCodeResult = immutableDataTypeDecorator.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataTypeDecorator.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(2L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(2L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("2020-03-01");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("2020-03-01"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("2020-03-01"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecorator,
        ratingResult2.targetInboundRating(targetInboundRating2).build());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(ratingResult.targetInboundRating(targetInboundRating).build(), null);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecorator.equals(Object)",
    "int ImmutableDataTypeDecorator.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertNotEquals(
        ratingResult.targetInboundRating(targetInboundRating).build(),
        "Different type to ImmutableDataTypeDecorator");
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#flowClassificationRuleId()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#flowClassificationRuleId()}
   */
  @Test
  @DisplayName("Test flowClassificationRuleId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataTypeDecorator.flowClassificationRuleId()"})
  void testFlowClassificationRuleId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Optional<Long> actualFlowClassificationRuleIdResult =
        ratingResult.targetInboundRating(targetInboundRating).build().flowClassificationRuleId();

    // Assert
    assertEquals(1L, actualFlowClassificationRuleIdResult.get().longValue());
    assertTrue(actualFlowClassificationRuleIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecorator#decoratorEntity()}
   *   <li>{@link ImmutableDataTypeDecorator#entityReference()}
   *   <li>{@link ImmutableDataTypeDecorator#lastUpdatedBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableDataTypeDecorator.decoratorEntity()",
    "EntityReference ImmutableDataTypeDecorator.entityReference()",
    "String ImmutableDataTypeDecorator.lastUpdatedBy()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    EntityReference actualDecoratorEntityResult = immutableDataTypeDecorator.decoratorEntity();
    EntityReference actualEntityReferenceResult = immutableDataTypeDecorator.entityReference();

    // Assert
    assertTrue(actualDecoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", immutableDataTypeDecorator.lastUpdatedBy());
    assertEquals(actualDecoratorEntityResult, actualEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#id()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataTypeDecorator.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Optional<Long> actualIdResult =
        ratingResult.targetInboundRating(targetInboundRating).build().id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#inboundFlowClassificationRuleId()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#inboundFlowClassificationRuleId()}
   */
  @Test
  @DisplayName("Test inboundFlowClassificationRuleId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataTypeDecorator.inboundFlowClassificationRuleId()"})
  void testInboundFlowClassificationRuleId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Optional<Long> actualInboundFlowClassificationRuleIdResult =
        ratingResult
            .targetInboundRating(targetInboundRating)
            .build()
            .inboundFlowClassificationRuleId();

    // Assert
    assertEquals(1L, actualInboundFlowClassificationRuleIdResult.get().longValue());
    assertTrue(actualInboundFlowClassificationRuleIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#isReadonly()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#isReadonly()}
   */
  @Test
  @DisplayName("Test isReadonly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableDataTypeDecorator.isReadonly()"})
  void testIsReadonly() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertFalse(ratingResult.targetInboundRating(targetInboundRating).build().isReadonly());
  }

  /**
   * Test Json {@link Json#dataFlowId()}.
   *
   * <p>Method under test: {@link Json#dataFlowId()}
   */
  @Test
  @DisplayName("Test Json dataFlowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.dataFlowId()"})
  void testJsonDataFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataFlowId());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   *
   * <p>Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json {@link Json#decoratorEntity()}.
   *
   * <p>Method under test: {@link Json#decoratorEntity()}
   */
  @Test
  @DisplayName("Test Json decoratorEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.decoratorEntity()"})
  void testJsonDecoratorEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().decoratorEntity());
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
   * Test Json {@link Json#flowClassificationRuleId()}.
   *
   * <p>Method under test: {@link Json#flowClassificationRuleId()}
   */
  @Test
  @DisplayName("Test Json flowClassificationRuleId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.flowClassificationRuleId()"})
  void testJsonFlowClassificationRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowClassificationRuleId());
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
   * Test Json {@link Json#inboundFlowClassificationRuleId()}.
   *
   * <p>Method under test: {@link Json#inboundFlowClassificationRuleId()}
   */
  @Test
  @DisplayName("Test Json inboundFlowClassificationRuleId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.inboundFlowClassificationRuleId()"})
  void testJsonInboundFlowClassificationRuleId() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().inboundFlowClassificationRuleId());
  }

  /**
   * Test Json {@link Json#isReadonly()}.
   *
   * <p>Method under test: {@link Json#isReadonly()}
   */
  @Test
  @DisplayName("Test Json isReadonly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadonly()"})
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadonly());
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.decoratorEntity);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.flowClassificationRuleId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.inboundFlowClassificationRuleId.isPresent());
    assertFalse(actualJson.rating.isPresent());
    assertFalse(actualJson.targetInboundRating.isPresent());
    assertFalse(actualJson.isReadonly);
    assertFalse(actualJson.isReadonlyIsSet);
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
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#setIsReadonly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadonly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadonly(boolean)"})
  void testJsonSetIsReadonly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Test Json {@link Json#targetInboundRating()}.
   *
   * <p>Method under test: {@link Json#targetInboundRating()}
   */
  @Test
  @DisplayName("Test Json targetInboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.targetInboundRating()"})
  void testJsonTargetInboundRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetInboundRating());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableDataTypeDecorator.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ratingResult.targetInboundRating(targetInboundRating).build().lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#provenance()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDataTypeDecorator.provenance()"})
  void testProvenance() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(
        "Provenance", ratingResult.targetInboundRating(targetInboundRating).build().provenance());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#rating()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#rating()}
   */
  @Test
  @DisplayName("Test rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataTypeDecorator.rating()"})
  void testRating() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(rating, ratingResult.targetInboundRating(targetInboundRating).build().rating());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#targetInboundRating()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#targetInboundRating()}
   */
  @Test
  @DisplayName("Test targetInboundRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableDataTypeDecorator.targetInboundRating()"})
  void testTargetInboundRating() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(
        rating,
        ratingResult.targetInboundRating(targetInboundRating).build().targetInboundRating());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#toString()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDataTypeDecorator.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(
        "DataTypeDecorator{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, id=1, decoratorEntity"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, rating=42, targetInboundRating=42,"
            + " flowClassificationRuleId=1, inboundFlowClassificationRuleId=1, dataTypeId=1, dataFlowId=1,"
            + " isReadonly=false}",
        ratingResult.targetInboundRating(targetInboundRating).build().toString());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#toString()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDataTypeDecorator.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.empty();

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act and Assert
    assertEquals(
        "DataTypeDecorator{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, id=1, decoratorEntity"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, targetInboundRating=42, flowClassifi"
            + "cationRuleId=1, inboundFlowClassificationRuleId=1, dataTypeId=1, dataFlowId=1, isReadonly=false}",
        ratingResult.targetInboundRating(targetInboundRating).build().toString());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#toString()}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableDataTypeDecorator.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating = Optional.empty();

    // Act and Assert
    assertEquals(
        "DataTypeDecorator{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, id=1, decoratorEntity"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, rating=42, flowClassificationRuleId=1,"
            + " inboundFlowClassificationRuleId=1, dataTypeId=1, dataFlowId=1, isReadonly=false}",
        ratingResult.targetInboundRating(targetInboundRating).build().toString());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withDecoratorEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withDecoratorEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withDecoratorEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withDecoratorEntity(EntityReference)"
  })
  void testWithDecoratorEntity() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithDecoratorEntityResult =
        immutableDataTypeDecorator.withDecoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithDecoratorEntityResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithEntityReferenceResult =
        immutableDataTypeDecorator.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test withFlowClassificationRuleId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withFlowClassificationRuleId(Optional)"
  })
  void testWithFlowClassificationRuleIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableDataTypeDecorator actualWithFlowClassificationRuleIdResult =
        immutableDataTypeDecorator.withFlowClassificationRuleId(optional);

    // Assert
    EntityReference decoratorEntityResult2 =
        actualWithFlowClassificationRuleIdResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult =
        actualWithFlowClassificationRuleIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithFlowClassificationRuleIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithFlowClassificationRuleIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithFlowClassificationRuleIdResult.dataFlowId());
    assertEquals(1L, actualWithFlowClassificationRuleIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithFlowClassificationRuleIdResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithFlowClassificationRuleIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test withFlowClassificationRuleId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withFlowClassificationRuleId(Optional)"
  })
  void testWithFlowClassificationRuleIdWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataTypeDecorator actualWithFlowClassificationRuleIdResult =
        immutableDataTypeDecorator.withFlowClassificationRuleId(optional);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithFlowClassificationRuleIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test withFlowClassificationRuleId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withFlowClassificationRuleId(long)"
  })
  void testWithFlowClassificationRuleIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithFlowClassificationRuleIdResult =
        ratingResult
            .targetInboundRating(targetInboundRating)
            .build()
            .withFlowClassificationRuleId(42L);

    // Assert
    EntityReference decoratorEntityResult2 =
        actualWithFlowClassificationRuleIdResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult =
        actualWithFlowClassificationRuleIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithFlowClassificationRuleIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithFlowClassificationRuleIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithFlowClassificationRuleIdResult.dataFlowId());
    assertEquals(1L, actualWithFlowClassificationRuleIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithFlowClassificationRuleIdResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithFlowClassificationRuleIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withFlowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test withFlowClassificationRuleId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withFlowClassificationRuleId(long)"
  })
  void testWithFlowClassificationRuleIdWithValue2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithFlowClassificationRuleIdResult =
        immutableDataTypeDecorator.withFlowClassificationRuleId(1L);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithFlowClassificationRuleIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataTypeDecorator actualWithIdResult = immutableDataTypeDecorator.withId(optional);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then decoratorEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then decoratorEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withId(Optional)"})
  void testWithIdWithOptional_thenDecoratorEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableDataTypeDecorator actualWithIdResult = immutableDataTypeDecorator.withId(optional);

    // Assert
    EntityReference decoratorEntityResult2 = actualWithIdResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithIdResult.dataFlowId());
    assertEquals(1L, actualWithIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithIdResult = immutableDataTypeDecorator.withId(1L);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then decoratorEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then decoratorEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withId(long)"})
  void testWithIdWithValue_thenDecoratorEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithIdResult =
        ratingResult.targetInboundRating(targetInboundRating).build().withId(42L);

    // Assert
    EntityReference decoratorEntityResult2 = actualWithIdResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithIdResult.dataFlowId());
    assertEquals(1L, actualWithIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test withInboundFlowClassificationRuleId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withInboundFlowClassificationRuleId(Optional)"
  })
  void testWithInboundFlowClassificationRuleIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableDataTypeDecorator actualWithInboundFlowClassificationRuleIdResult =
        immutableDataTypeDecorator.withInboundFlowClassificationRuleId(optional);

    // Assert
    EntityReference decoratorEntityResult2 =
        actualWithInboundFlowClassificationRuleIdResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult =
        actualWithInboundFlowClassificationRuleIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithInboundFlowClassificationRuleIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithInboundFlowClassificationRuleIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithInboundFlowClassificationRuleIdResult.dataFlowId());
    assertEquals(1L, actualWithInboundFlowClassificationRuleIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithInboundFlowClassificationRuleIdResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(
        ofResult, actualWithInboundFlowClassificationRuleIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(Optional)}
   */
  @Test
  @DisplayName("Test withInboundFlowClassificationRuleId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withInboundFlowClassificationRuleId(Optional)"
  })
  void testWithInboundFlowClassificationRuleIdWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableDataTypeDecorator actualWithInboundFlowClassificationRuleIdResult =
        immutableDataTypeDecorator.withInboundFlowClassificationRuleId(optional);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithInboundFlowClassificationRuleIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test withInboundFlowClassificationRuleId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withInboundFlowClassificationRuleId(long)"
  })
  void testWithInboundFlowClassificationRuleIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithInboundFlowClassificationRuleIdResult =
        ratingResult
            .targetInboundRating(targetInboundRating)
            .build()
            .withInboundFlowClassificationRuleId(42L);

    // Assert
    EntityReference decoratorEntityResult2 =
        actualWithInboundFlowClassificationRuleIdResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult =
        actualWithInboundFlowClassificationRuleIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithInboundFlowClassificationRuleIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithInboundFlowClassificationRuleIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithInboundFlowClassificationRuleIdResult.dataFlowId());
    assertEquals(1L, actualWithInboundFlowClassificationRuleIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithInboundFlowClassificationRuleIdResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(
        ofResult, actualWithInboundFlowClassificationRuleIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(long)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecorator#withInboundFlowClassificationRuleId(long)}
   */
  @Test
  @DisplayName("Test withInboundFlowClassificationRuleId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withInboundFlowClassificationRuleId(long)"
  })
  void testWithInboundFlowClassificationRuleIdWithValue2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithInboundFlowClassificationRuleIdResult =
        immutableDataTypeDecorator.withInboundFlowClassificationRuleId(1L);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithInboundFlowClassificationRuleIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withIsReadonly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withIsReadonly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadonly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withIsReadonly(boolean)"
  })
  void testWithIsReadonly() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithIsReadonlyResult =
        immutableDataTypeDecorator.withIsReadonly(false);

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithIsReadonlyResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withIsReadonly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then decoratorEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withIsReadonly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsReadonly(boolean); when 'true'; then decoratorEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withIsReadonly(boolean)"
  })
  void testWithIsReadonly_whenTrue_thenDecoratorEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithIsReadonlyResult =
        ratingResult.targetInboundRating(targetInboundRating).build().withIsReadonly(true);

    // Assert
    EntityReference decoratorEntityResult2 = actualWithIsReadonlyResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult = actualWithIsReadonlyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIsReadonlyResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIsReadonlyResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithIsReadonlyResult.dataFlowId());
    assertEquals(1L, actualWithIsReadonlyResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertTrue(actualWithIsReadonlyResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithIsReadonlyResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithLastUpdatedAtResult =
        immutableDataTypeDecorator.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithLastUpdatedByResult =
        immutableDataTypeDecorator.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then decoratorEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then decoratorEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenDecoratorEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithLastUpdatedByResult =
        ratingResult.targetInboundRating(targetInboundRating).build().withLastUpdatedBy("42");

    // Assert
    EntityReference decoratorEntityResult2 = actualWithLastUpdatedByResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult = actualWithLastUpdatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithLastUpdatedByResult.dataFlowId());
    assertEquals(1L, actualWithLastUpdatedByResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithLastUpdatedByResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("42");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithProvenanceResult =
        immutableDataTypeDecorator.withProvenance("42");

    // Assert
    assertSame(immutableDataTypeDecorator, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then decoratorEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then decoratorEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withProvenance(String)"
  })
  void testWithProvenance_thenDecoratorEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithProvenanceResult =
        ratingResult.targetInboundRating(targetInboundRating).build().withProvenance("42");

    // Assert
    EntityReference decoratorEntityResult2 = actualWithProvenanceResult.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualWithProvenanceResult.dataFlowId());
    assertEquals(1L, actualWithProvenanceResult.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualWithProvenanceResult.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withRating(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withRating(Optional)}
   */
  @Test
  @DisplayName("Test withRating(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withRating(Optional)"})
  void testWithRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<? extends AuthoritativenessRatingValue> optional =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithRatingResult =
        immutableDataTypeDecorator.withRating(optional);

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withRating(AuthoritativenessRatingValue)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecorator#withRating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test withRating(AuthoritativenessRatingValue) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withRating(AuthoritativenessRatingValue)"
  })
  void testWithRatingWithValue() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithRatingResult =
        immutableDataTypeDecorator.withRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withTargetInboundRating(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecorator#withTargetInboundRating(Optional)}
   */
  @Test
  @DisplayName("Test withTargetInboundRating(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withTargetInboundRating(Optional)"
  })
  void testWithTargetInboundRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();
    Optional<? extends AuthoritativenessRatingValue> optional =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableDataTypeDecorator actualWithTargetInboundRatingResult =
        immutableDataTypeDecorator.withTargetInboundRating(optional);

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithTargetInboundRatingResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecorator#withTargetInboundRating(AuthoritativenessRatingValue)}
   * with {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecorator#withTargetInboundRating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test withTargetInboundRating(AuthoritativenessRatingValue) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecorator ImmutableDataTypeDecorator.withTargetInboundRating(AuthoritativenessRatingValue)"
  })
  void testWithTargetInboundRatingWithValue() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    ImmutableDataTypeDecorator immutableDataTypeDecorator =
        ratingResult.targetInboundRating(targetInboundRating).build();

    // Act
    ImmutableDataTypeDecorator actualWithTargetInboundRatingResult =
        immutableDataTypeDecorator.withTargetInboundRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals(immutableDataTypeDecorator, actualWithTargetInboundRatingResult);
  }
}
