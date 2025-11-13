package org.finos.waltz.model.entity_statistic;

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
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticValue.Builder;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatisticValue.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticValueDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#reason(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue Builder.build()",
    "Builder Builder.provenance(String)",
    "Builder Builder.reason(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualCurrentResult =
        ImmutableEntityStatisticValue.builder().createdAt(createdAt).current(true);
    ImmutableEntityReference entity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIdResult = actualCurrentResult.entity(entity).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        actualIdResult
            .id(id)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableEntityStatisticValue.value());
    assertEquals("Just cause", actualImmutableEntityStatisticValue.reason());
    assertEquals("Outcome", actualImmutableEntityStatisticValue.outcome());
    assertEquals("Provenance", actualImmutableEntityStatisticValue.provenance());
    assertEquals(1L, actualImmutableEntityStatisticValue.statisticId());
    assertEquals(StatisticValueState.EXEMPT, actualImmutableEntityStatisticValue.state());
    assertTrue(actualImmutableEntityStatisticValue.current());
    assertSame(createdAt, actualImmutableEntityStatisticValue.createdAt());
    assertSame(entity, actualImmutableEntityStatisticValue.entity());
  }

  /**
   * Test Builder {@link Builder#createdAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link Builder#createdAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder createdAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdAt(LocalDateTime)"})
  void testBuilderCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualCreatedAtResult =
        builderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(builderResult, actualCreatedAtResult);
  }

  /**
   * Test Builder {@link Builder#current(boolean)}.
   *
   * <p>Method under test: {@link Builder#current(boolean)}
   */
  @Test
  @DisplayName("Test Builder current(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.current(boolean)"})
  void testBuilderCurrent() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualCurrentResult = builderResult.current(true);

    // Assert
    assertSame(builderResult, actualCurrentResult);
  }

  /**
   * Test Builder {@link Builder#entity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entity(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(EntityReference)"})
  void testBuilderEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualEntityResult =
        builderResult.entity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue2() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(false);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticValue)} with {@code EntityStatisticValue}.
   *
   * <p>Method under test: {@link Builder#from(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticValue) with 'EntityStatisticValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticValue)"})
  void testBuilderFromWithEntityStatisticValue3() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason(null)
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(false);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason(null)
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityStatisticValue);
    ImmutableEntityStatisticValue actualImmutableEntityStatisticValue2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticValue2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

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
    Builder builderResult = ImmutableEntityStatisticValue.builder();

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
    Builder builderResult = ImmutableEntityStatisticValue.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#outcome(String)}.
   *
   * <ul>
   *   <li>When {@code Outcome}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#outcome(String)}
   */
  @Test
  @DisplayName("Test Builder outcome(String); when 'Outcome'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.outcome(String)"})
  void testBuilderOutcome_whenOutcome_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualOutcomeResult = builderResult.outcome("Outcome");

    // Assert
    assertSame(builderResult, actualOutcomeResult);
  }

  /**
   * Test Builder {@link Builder#state(StatisticValueState)}.
   *
   * <p>Method under test: {@link Builder#state(StatisticValueState)}
   */
  @Test
  @DisplayName("Test Builder state(StatisticValueState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.state(StatisticValueState)"})
  void testBuilderState() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualStateResult = builderResult.state(StatisticValueState.EXEMPT);

    // Assert
    assertSame(builderResult, actualStateResult);
  }

  /**
   * Test Builder {@link Builder#statisticId(long)}.
   *
   * <p>Method under test: {@link Builder#statisticId(long)}
   */
  @Test
  @DisplayName("Test Builder statisticId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.statisticId(long)"})
  void testBuilderStatisticId() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualStatisticIdResult = builderResult.statisticId(1L);

    // Assert
    assertSame(builderResult, actualStatisticIdResult);
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticValue.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#copyOf(EntityStatisticValue)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#copyOf(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test copyOf(EntityStatisticValue); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.copyOf(EntityStatisticValue)"
  })
  void testCopyOf_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);
    ImmutableEntityStatisticValue instance =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualCopyOfResult =
        ImmutableEntityStatisticValue.copyOf(instance);

    // Assert
    EntityReference entityResult = actualCopyOfResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Just cause", actualCopyOfResult.reason());
    assertEquals("Outcome", actualCopyOfResult.outcome());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualCopyOfResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualCopyOfResult.state());
    assertTrue(actualCopyOfResult.current());
    assertSame(ofResult, actualCopyOfResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}, and {@link
   * ImmutableEntityStatisticValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticValue#equals(Object)}
   *   <li>{@link ImmutableEntityStatisticValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue2 =
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatisticValue, immutableEntityStatisticValue2);
    assertEquals(
        immutableEntityStatisticValue.hashCode(), immutableEntityStatisticValue2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}, and {@link
   * ImmutableEntityStatisticValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticValue#equals(Object)}
   *   <li>{@link ImmutableEntityStatisticValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatisticValue, immutableEntityStatisticValue);
    int expectedHashCodeResult = immutableEntityStatisticValue.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityStatisticValue.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(false);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Provenance")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("42")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Provenance")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.PROVIDED)
            .statisticId(1L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(2L)
            .value("42")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("Provenance")
            .build();

    Builder currentResult2 =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticValue,
        currentResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticValue.equals(Object)",
    "int ImmutableEntityStatisticValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertNotEquals(
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build(),
        "Different type to ImmutableEntityStatisticValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticValue#createdAt()}
   *   <li>{@link ImmutableEntityStatisticValue#current()}
   *   <li>{@link ImmutableEntityStatisticValue#entity()}
   *   <li>{@link ImmutableEntityStatisticValue#outcome()}
   *   <li>{@link ImmutableEntityStatisticValue#provenance()}
   *   <li>{@link ImmutableEntityStatisticValue#reason()}
   *   <li>{@link ImmutableEntityStatisticValue#state()}
   *   <li>{@link ImmutableEntityStatisticValue#statisticId()}
   *   <li>{@link ImmutableEntityStatisticValue#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDateTime ImmutableEntityStatisticValue.createdAt()",
    "boolean ImmutableEntityStatisticValue.current()",
    "EntityReference ImmutableEntityStatisticValue.entity()",
    "String ImmutableEntityStatisticValue.outcome()",
    "String ImmutableEntityStatisticValue.provenance()",
    "String ImmutableEntityStatisticValue.reason()",
    "StatisticValueState ImmutableEntityStatisticValue.state()",
    "long ImmutableEntityStatisticValue.statisticId()",
    "String ImmutableEntityStatisticValue.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    LocalDateTime actualCreatedAtResult = immutableEntityStatisticValue.createdAt();
    boolean actualCurrentResult = immutableEntityStatisticValue.current();
    EntityReference actualEntityResult = immutableEntityStatisticValue.entity();
    String actualOutcomeResult = immutableEntityStatisticValue.outcome();
    String actualProvenanceResult = immutableEntityStatisticValue.provenance();
    String actualReasonResult = immutableEntityStatisticValue.reason();
    StatisticValueState actualStateResult = immutableEntityStatisticValue.state();
    long actualStatisticIdResult = immutableEntityStatisticValue.statisticId();

    // Assert
    assertTrue(actualEntityResult instanceof ImmutableEntityReference);
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", immutableEntityStatisticValue.value());
    assertEquals("Just cause", actualReasonResult);
    assertEquals("Outcome", actualOutcomeResult);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals(1L, actualStatisticIdResult);
    assertEquals(StatisticValueState.EXEMPT, actualStateResult);
    assertTrue(actualCurrentResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityStatisticValue.id()"})
  void testId() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act
    Optional<Long> actualIdResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json {@link Json#current()}.
   *
   * <p>Method under test: {@link Json#current()}
   */
  @Test
  @DisplayName("Test Json current()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.current()"})
  void testJsonCurrent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().current());
  }

  /**
   * Test Json {@link Json#entity()}.
   *
   * <p>Method under test: {@link Json#entity()}
   */
  @Test
  @DisplayName("Test Json entity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entity()"})
  void testJsonEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entity());
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
    assertNull(actualJson.outcome);
    assertNull(actualJson.provenance);
    assertNull(actualJson.reason);
    assertNull(actualJson.value);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.entity);
    assertNull(actualJson.state);
    assertEquals(0L, actualJson.statisticId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.current);
    assertFalse(actualJson.currentIsSet);
    assertFalse(actualJson.statisticIdIsSet);
  }

  /**
   * Test Json {@link Json#outcome()}.
   *
   * <p>Method under test: {@link Json#outcome()}
   */
  @Test
  @DisplayName("Test Json outcome()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.outcome()"})
  void testJsonOutcome() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().outcome());
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
   * Test Json {@link Json#reason()}.
   *
   * <p>Method under test: {@link Json#reason()}
   */
  @Test
  @DisplayName("Test Json reason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.reason()"})
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().reason());
  }

  /**
   * Test Json {@link Json#setCurrent(boolean)}.
   *
   * <p>Method under test: {@link Json#setCurrent(boolean)}
   */
  @Test
  @DisplayName("Test Json setCurrent(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCurrent(boolean)"})
  void testJsonSetCurrent() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCurrent(true);

    // Assert
    assertTrue(json.current);
    assertTrue(json.currentIsSet);
  }

  /**
   * Test Json {@link Json#setStatisticId(long)}.
   *
   * <p>Method under test: {@link Json#setStatisticId(long)}
   */
  @Test
  @DisplayName("Test Json setStatisticId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setStatisticId(long)"})
  void testJsonSetStatisticId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setStatisticId(1L);

    // Assert
    assertEquals(1L, json.statisticId);
    assertTrue(json.statisticIdIsSet);
  }

  /**
   * Test Json {@link Json#state()}.
   *
   * <p>Method under test: {@link Json#state()}
   */
  @Test
  @DisplayName("Test Json state()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StatisticValueState Json.state()"})
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().state());
  }

  /**
   * Test Json {@link Json#statisticId()}.
   *
   * <p>Method under test: {@link Json#statisticId()}
   */
  @Test
  @DisplayName("Test Json statisticId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.statisticId()"})
  void testJsonStatisticId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().statisticId());
  }

  /**
   * Test Json {@link Json#value()}.
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityStatisticValue.toString()"})
  void testToString() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertEquals(
        "EntityStatisticValue{id=1, provenance=Provenance, statisticId=1, entity=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, value=42, outcome=Outcome, state=EXEMPT, reason=Just cause,"
            + " createdAt=1970-01-01T00:00, current=true}",
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityStatisticValue.toString()"})
  void testToString2() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);

    // Act and Assert
    assertEquals(
        "EntityStatisticValue{id=1, provenance=Provenance, statisticId=1, entity=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, value=42, outcome=Outcome, state=EXEMPT, createdAt=1970-01-01T00:00,"
            + " current=true}",
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason(null)
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithCreatedAtResult =
        immutableEntityStatisticValue.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableEntityStatisticValue, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withCurrent(boolean)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withCurrent(boolean)}
   */
  @Test
  @DisplayName("Test withCurrent(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withCurrent(boolean)"
  })
  void testWithCurrent() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithCurrentResult =
        immutableEntityStatisticValue.withCurrent(true);

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithCurrentResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withCurrent(boolean)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withCurrent(boolean)}
   */
  @Test
  @DisplayName("Test withCurrent(boolean); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withCurrent(boolean)"
  })
  void testWithCurrent_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(false);

    // Act
    ImmutableEntityStatisticValue actualWithCurrentResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .withCurrent(true);

    // Assert
    EntityReference entityResult = actualWithCurrentResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithCurrentResult.value());
    assertEquals("Just cause", actualWithCurrentResult.reason());
    assertEquals("Outcome", actualWithCurrentResult.outcome());
    assertEquals("Provenance", actualWithCurrentResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithCurrentResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithCurrentResult.state());
    assertTrue(actualWithCurrentResult.current());
    assertSame(ofResult, actualWithCurrentResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withEntity(EntityReference)"
  })
  void testWithEntity() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithEntityResult =
        immutableEntityStatisticValue.withEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityStatisticValue, actualWithEntityResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityStatisticValue actualWithIdResult =
        immutableEntityStatisticValue.withId(optional);

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableEntityStatisticValue actualWithIdResult =
        immutableEntityStatisticValue.withId(optional);

    // Assert
    EntityReference entityResult = actualWithIdResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIdResult.value());
    assertEquals("Just cause", actualWithIdResult.reason());
    assertEquals("Outcome", actualWithIdResult.outcome());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithIdResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithIdResult.state());
    assertTrue(actualWithIdResult.current());
    assertSame(ofResult, actualWithIdResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithIdResult = immutableEntityStatisticValue.withId(1L);

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithIdResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .withId(42L);

    // Assert
    EntityReference entityResult = actualWithIdResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIdResult.value());
    assertEquals("Just cause", actualWithIdResult.reason());
    assertEquals("Outcome", actualWithIdResult.outcome());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithIdResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithIdResult.state());
    assertTrue(actualWithIdResult.current());
    assertSame(ofResult, actualWithIdResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withOutcome(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withOutcome(String)}
   */
  @Test
  @DisplayName("Test withOutcome(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withOutcome(String)"
  })
  void testWithOutcome() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("42")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithOutcomeResult =
        immutableEntityStatisticValue.withOutcome("42");

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithOutcomeResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withOutcome(String)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withOutcome(String)}
   */
  @Test
  @DisplayName("Test withOutcome(String); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withOutcome(String)"
  })
  void testWithOutcome_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithOutcomeResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .withOutcome("42");

    // Assert
    EntityReference entityResult = actualWithOutcomeResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithOutcomeResult.outcome());
    assertEquals("42", actualWithOutcomeResult.value());
    assertEquals("Just cause", actualWithOutcomeResult.reason());
    assertEquals("Provenance", actualWithOutcomeResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithOutcomeResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithOutcomeResult.state());
    assertTrue(actualWithOutcomeResult.current());
    assertSame(ofResult, actualWithOutcomeResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("42")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithProvenanceResult =
        immutableEntityStatisticValue.withProvenance("42");

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withProvenance(String)"
  })
  void testWithProvenance_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithProvenanceResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityResult = actualWithProvenanceResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("42", actualWithProvenanceResult.value());
    assertEquals("Just cause", actualWithProvenanceResult.reason());
    assertEquals("Outcome", actualWithProvenanceResult.outcome());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithProvenanceResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithProvenanceResult.state());
    assertTrue(actualWithProvenanceResult.current());
    assertSame(ofResult, actualWithProvenanceResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withReason(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withReason(String)"
  })
  void testWithReason() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("42")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithReasonResult =
        immutableEntityStatisticValue.withReason("42");

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithReasonResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withReason(String)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withReason(String)"
  })
  void testWithReason_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithReasonResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .withReason("42");

    // Assert
    EntityReference entityResult = actualWithReasonResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithReasonResult.reason());
    assertEquals("42", actualWithReasonResult.value());
    assertEquals("Outcome", actualWithReasonResult.outcome());
    assertEquals("Provenance", actualWithReasonResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithReasonResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithReasonResult.state());
    assertTrue(actualWithReasonResult.current());
    assertSame(ofResult, actualWithReasonResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withState(StatisticValueState)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withState(StatisticValueState)}
   */
  @Test
  @DisplayName("Test withState(StatisticValueState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withState(StatisticValueState)"
  })
  void testWithState() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithStateResult =
        immutableEntityStatisticValue.withState(StatisticValueState.EXEMPT);

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithStateResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withState(StatisticValueState)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withState(StatisticValueState)}
   */
  @Test
  @DisplayName("Test withState(StatisticValueState); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withState(StatisticValueState)"
  })
  void testWithState_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithStateResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.PROVIDED)
            .statisticId(1L)
            .value("42")
            .build()
            .withState(StatisticValueState.EXEMPT);

    // Assert
    EntityReference entityResult = actualWithStateResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithStateResult.value());
    assertEquals("Just cause", actualWithStateResult.reason());
    assertEquals("Outcome", actualWithStateResult.outcome());
    assertEquals("Provenance", actualWithStateResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithStateResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithStateResult.state());
    assertTrue(actualWithStateResult.current());
    assertSame(ofResult, actualWithStateResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withStatisticId(long)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withStatisticId(long)}
   */
  @Test
  @DisplayName("Test withStatisticId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withStatisticId(long)"
  })
  void testWithStatisticId() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(42L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithStatisticIdResult =
        immutableEntityStatisticValue.withStatisticId(42L);

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithStatisticIdResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withStatisticId(long)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withStatisticId(long)}
   */
  @Test
  @DisplayName("Test withStatisticId(long); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withStatisticId(long)"
  })
  void testWithStatisticId_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithStatisticIdResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build()
            .withStatisticId(42L);

    // Assert
    EntityReference entityResult = actualWithStatisticIdResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithStatisticIdResult.value());
    assertEquals("Just cause", actualWithStatisticIdResult.reason());
    assertEquals("Outcome", actualWithStatisticIdResult.outcome());
    assertEquals("Provenance", actualWithStatisticIdResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(42L, actualWithStatisticIdResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithStatisticIdResult.state());
    assertTrue(actualWithStatisticIdResult.current());
    assertSame(ofResult, actualWithStatisticIdResult.createdAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withValue(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withValue(String)"
  })
  void testWithValue() {
    // Arrange
    Builder currentResult =
        ImmutableEntityStatisticValue.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .current(true);
    ImmutableEntityStatisticValue immutableEntityStatisticValue =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("42")
            .build();

    // Act
    ImmutableEntityStatisticValue actualWithValueResult =
        immutableEntityStatisticValue.withValue("42");

    // Assert
    assertSame(immutableEntityStatisticValue, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticValue#withValue(String)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticValue#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticValue ImmutableEntityStatisticValue.withValue(String)"
  })
  void testWithValue_thenEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder currentResult =
        ImmutableEntityStatisticValue.builder().createdAt(ofResult.atStartOfDay()).current(true);

    // Act
    ImmutableEntityStatisticValue actualWithValueResult =
        currentResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .outcome("Outcome")
            .provenance("Provenance")
            .reason("Just cause")
            .state(StatisticValueState.EXEMPT)
            .statisticId(1L)
            .value("value")
            .build()
            .withValue("42");

    // Assert
    EntityReference entityResult = actualWithValueResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithValueResult.value());
    assertEquals("Just cause", actualWithValueResult.reason());
    assertEquals("Outcome", actualWithValueResult.outcome());
    assertEquals("Provenance", actualWithValueResult.provenance());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(1L, actualWithValueResult.statisticId());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
    assertEquals(StatisticValueState.EXEMPT, actualWithValueResult.state());
    assertTrue(actualWithValueResult.current());
    assertSame(ofResult, actualWithValueResult.createdAt().toLocalDate());
  }
}
