package org.finos.waltz.model.change_unit;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit.Builder;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeUnitDiffblueTest {
  /**
   * Test Builder {@link Builder#action(ChangeAction)}.
   *
   * <p>Method under test: {@link Builder#action(ChangeAction)}
   */
  @Test
  @DisplayName("Test Builder action(ChangeAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.action(ChangeAction)"})
  void testBuilderAction() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualActionResult = builderResult.action(ChangeAction.ACTIVATE);

    // Assert
    assertSame(builderResult, actualActionResult);
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
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeUnit Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualChangeSetIdResult =
        ImmutableChangeUnit.builder().action(ChangeAction.ACTIVATE).changeSetId(1L);
    Optional<Long> changeSetId = Optional.of(42L);
    Builder actualExternalIdResult =
        actualChangeSetIdResult
            .changeSetId(changeSetId)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualProvenanceResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableEntityReference subjectEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableChangeUnit actualImmutableChangeUnit =
        actualProvenanceResult
            .subjectEntity(subjectEntity)
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableChangeUnit.lastUpdatedBy());
    assertEquals("Name", actualImmutableChangeUnit.name());
    assertEquals("Provenance", actualImmutableChangeUnit.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableChangeUnit.description());
    assertEquals(EntityKind.ALL, actualImmutableChangeUnit.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableChangeUnit.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualImmutableChangeUnit.action());
    assertEquals(ExecutionStatus.PENDING, actualImmutableChangeUnit.executionStatus());
    assertSame(lastUpdatedAt, actualImmutableChangeUnit.lastUpdatedAt());
    assertSame(subjectEntity, actualImmutableChangeUnit.subjectEntity());
  }

  /**
   * Test Builder {@link Builder#changeSetId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#changeSetId(long)}
   */
  @Test
  @DisplayName("Test Builder changeSetId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeSetId(long)"})
  void testBuilderChangeSetIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualChangeSetIdResult = builderResult.changeSetId(1L);

    // Assert
    assertSame(builderResult, actualChangeSetIdResult);
  }

  /**
   * Test Builder {@link Builder#changeSetId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#changeSetId(Optional)}
   */
  @Test
  @DisplayName("Test Builder changeSetId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeSetId(Optional)"})
  void testBuilderChangeSetIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();
    Optional<Long> changeSetId = Optional.of(42L);

    // Act
    Builder actualChangeSetIdResult = builderResult.changeSetId(changeSetId);

    // Assert
    assertSame(builderResult, actualChangeSetIdResult);
  }

  /**
   * Test Builder {@link Builder#executionStatus(ExecutionStatus)}.
   *
   * <p>Method under test: {@link Builder#executionStatus(ExecutionStatus)}
   */
  @Test
  @DisplayName("Test Builder executionStatus(ExecutionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.executionStatus(ExecutionStatus)"})
  void testBuilderExecutionStatus() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualExecutionStatusResult = builderResult.executionStatus(ExecutionStatus.PENDING);

    // Assert
    assertSame(builderResult, actualExecutionStatusResult);
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
    Builder builderResult = ImmutableChangeUnit.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   *
   * <p>Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeUnit actualImmutableChangeUnit = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeUnit)} with {@code ChangeUnit}.
   *
   * <p>Method under test: {@link Builder#from(ChangeUnit)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeUnit) with 'ChangeUnit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeUnit)"})
  void testBuilderFromWithChangeUnit2() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description(null)
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeUnit actualImmutableChangeUnit = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit);
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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    ImmutableChangeUnit actualImmutableChangeUnit =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableChangeUnit);
    ImmutableChangeUnit actualImmutableChangeUnit2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeUnit2);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
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
    Builder builderResult = ImmutableChangeUnit.builder();

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
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#subjectEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subjectEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder subjectEntity(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectEntity(EntityReference)"})
  void testBuilderSubjectEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualSubjectEntityResult =
        builderResult.subjectEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualSubjectEntityResult);
  }

  /**
   * Test Builder {@link Builder#subjectInitialStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#subjectInitialStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder subjectInitialStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectInitialStatus(EntityLifecycleStatus)"})
  void testBuilderSubjectInitialStatus() {
    // Arrange
    Builder builderResult = ImmutableChangeUnit.builder();

    // Act
    Builder actualSubjectInitialStatusResult =
        builderResult.subjectInitialStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualSubjectInitialStatusResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#changeSetId()}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#changeSetId()}
   */
  @Test
  @DisplayName("Test changeSetId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeUnit.changeSetId()"})
  void testChangeSetId() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    Optional<Long> actualChangeSetIdResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .changeSetId();

    // Assert
    assertEquals(1L, actualChangeSetIdResult.get().longValue());
    assertTrue(actualChangeSetIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableChangeUnit#copyOf(ChangeUnit)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#copyOf(ChangeUnit)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeUnit); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.copyOf(ChangeUnit)"})
  void testCopyOf_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit instance =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualCopyOfResult = ImmutableChangeUnit.copyOf(instance);

    // Assert
    EntityReference subjectEntityResult = actualCopyOfResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualCopyOfResult.action());
    assertEquals(ExecutionStatus.PENDING, actualCopyOfResult.executionStatus());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}, and {@link ImmutableChangeUnit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeUnit#equals(Object)}
   *   <li>{@link ImmutableChangeUnit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit2 =
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertEquals(immutableChangeUnit, immutableChangeUnit2);
    assertEquals(immutableChangeUnit.hashCode(), immutableChangeUnit2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}, and {@link ImmutableChangeUnit#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeUnit#equals(Object)}
   *   <li>{@link ImmutableChangeUnit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act and Assert
    assertEquals(immutableChangeUnit, immutableChangeUnit);
    int expectedHashCodeResult = immutableChangeUnit.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeUnit.hashCode());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.RETIRE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(2L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.COMPLETE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Name");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.PENDING)
            .build();

    Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableChangeUnit,
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableChangeUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeUnit.equals(Object)",
    "int ImmutableChangeUnit.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build(),
        "Different type to ImmutableChangeUnit");
  }

  /**
   * Test {@link ImmutableChangeUnit#externalId()}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeUnit.externalId()"})
  void testExternalId() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    Optional<String> actualExternalIdResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableChangeUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setKind(EntityKind.ALL);
    Optional<Long> changeSetId = Optional.of(42L);
    json.setChangeSetId(changeSetId);
    json.setSubjectEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);
    json.setAction(ChangeAction.ACTIVATE);
    json.setExecutionStatus(ExecutionStatus.PENDING);

    // Act
    ImmutableChangeUnit actualFromJsonResult = ImmutableChangeUnit.fromJson(json);

    // Assert
    EntityReference subjectEntityResult = actualFromJsonResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualFromJsonResult.action());
    assertEquals(ExecutionStatus.PENDING, actualFromJsonResult.executionStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    assertSame(json.subjectEntity, subjectEntityResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ChangeSetId is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ChangeSetId is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.fromJson(Json)"})
  void testFromJson_whenJsonChangeSetIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setKind(EntityKind.ALL);
    json.setChangeSetId(null);
    json.setSubjectEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);
    json.setAction(ChangeAction.ACTIVATE);
    json.setExecutionStatus(ExecutionStatus.PENDING);

    // Act
    ImmutableChangeUnit actualFromJsonResult = ImmutableChangeUnit.fromJson(json);

    // Assert
    EntityReference subjectEntityResult = actualFromJsonResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualFromJsonResult.action());
    assertEquals(ExecutionStatus.PENDING, actualFromJsonResult.executionStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    assertSame(json.subjectEntity, subjectEntityResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.fromJson(Json)"})
  void testFromJson_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setKind(EntityKind.ALL);
    Optional<Long> changeSetId = Optional.of(42L);
    json.setChangeSetId(changeSetId);
    json.setSubjectEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);
    json.setAction(ChangeAction.ACTIVATE);
    json.setExecutionStatus(ExecutionStatus.PENDING);

    // Act
    ImmutableChangeUnit actualFromJsonResult = ImmutableChangeUnit.fromJson(json);

    // Assert
    EntityReference subjectEntityResult = actualFromJsonResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualFromJsonResult.action());
    assertEquals(ExecutionStatus.PENDING, actualFromJsonResult.executionStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    assertSame(json.subjectEntity, subjectEntityResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExternalId is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.fromJson(Json)"})
  void testFromJson_whenJsonExternalIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance("Json");
    json.setKind(EntityKind.ALL);
    Optional<Long> changeSetId = Optional.of(42L);
    json.setChangeSetId(changeSetId);
    json.setSubjectEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);
    json.setAction(ChangeAction.ACTIVATE);
    json.setExecutionStatus(ExecutionStatus.PENDING);

    // Act
    ImmutableChangeUnit actualFromJsonResult = ImmutableChangeUnit.fromJson(json);

    // Assert
    EntityReference subjectEntityResult = actualFromJsonResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualFromJsonResult.action());
    assertEquals(ExecutionStatus.PENDING, actualFromJsonResult.executionStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    assertSame(json.subjectEntity, subjectEntityResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Id is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.fromJson(Json)"})
  void testFromJson_whenJsonIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance("Json");
    json.setKind(EntityKind.ALL);
    Optional<Long> changeSetId = Optional.of(42L);
    json.setChangeSetId(changeSetId);
    json.setSubjectEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);
    json.setAction(ChangeAction.ACTIVATE);
    json.setExecutionStatus(ExecutionStatus.PENDING);

    // Act
    ImmutableChangeUnit actualFromJsonResult = ImmutableChangeUnit.fromJson(json);

    // Assert
    EntityReference subjectEntityResult = actualFromJsonResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualFromJsonResult.action());
    assertEquals(ExecutionStatus.PENDING, actualFromJsonResult.executionStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    assertSame(json.subjectEntity, subjectEntityResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.fromJson(Json)"})
  void testFromJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setName("Json");
    json.setDescription("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setProvenance(null);
    json.setKind(EntityKind.ALL);
    Optional<Long> changeSetId = Optional.of(42L);
    json.setChangeSetId(changeSetId);
    json.setSubjectEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);
    json.setAction(ChangeAction.ACTIVATE);
    json.setExecutionStatus(ExecutionStatus.PENDING);

    // Act
    ImmutableChangeUnit actualFromJsonResult = ImmutableChangeUnit.fromJson(json);

    // Assert
    EntityReference subjectEntityResult = actualFromJsonResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualFromJsonResult.action());
    assertEquals(ExecutionStatus.PENDING, actualFromJsonResult.executionStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    assertSame(json.subjectEntity, subjectEntityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeUnit#action()}
   *   <li>{@link ImmutableChangeUnit#description()}
   *   <li>{@link ImmutableChangeUnit#executionStatus()}
   *   <li>{@link ImmutableChangeUnit#kind()}
   *   <li>{@link ImmutableChangeUnit#lastUpdatedBy()}
   *   <li>{@link ImmutableChangeUnit#name()}
   *   <li>{@link ImmutableChangeUnit#subjectEntity()}
   *   <li>{@link ImmutableChangeUnit#subjectInitialStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeAction ImmutableChangeUnit.action()",
    "String ImmutableChangeUnit.description()",
    "ExecutionStatus ImmutableChangeUnit.executionStatus()",
    "EntityKind ImmutableChangeUnit.kind()",
    "String ImmutableChangeUnit.lastUpdatedBy()",
    "String ImmutableChangeUnit.name()",
    "EntityReference ImmutableChangeUnit.subjectEntity()",
    "EntityLifecycleStatus ImmutableChangeUnit.subjectInitialStatus()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ChangeAction actualActionResult = immutableChangeUnit.action();
    String actualDescriptionResult = immutableChangeUnit.description();
    ExecutionStatus actualExecutionStatusResult = immutableChangeUnit.executionStatus();
    EntityKind actualKindResult = immutableChangeUnit.kind();
    String actualLastUpdatedByResult = immutableChangeUnit.lastUpdatedBy();
    String actualNameResult = immutableChangeUnit.name();
    EntityReference actualSubjectEntityResult = immutableChangeUnit.subjectEntity();

    // Assert
    assertTrue(actualSubjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualKindResult);
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableChangeUnit.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualActionResult);
    assertEquals(ExecutionStatus.PENDING, actualExecutionStatusResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#id()}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeUnit.id()"})
  void testId() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    Optional<Long> actualIdResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#action()}.
   *
   * <p>Method under test: {@link Json#action()}
   */
  @Test
  @DisplayName("Test Json action()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeAction Json.action()"})
  void testJsonAction() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().action());
  }

  /**
   * Test Json {@link Json#changeSetId()}.
   *
   * <p>Method under test: {@link Json#changeSetId()}
   */
  @Test
  @DisplayName("Test Json changeSetId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.changeSetId()"})
  void testJsonChangeSetId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeSetId());
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
   * Test Json {@link Json#executionStatus()}.
   *
   * <p>Method under test: {@link Json#executionStatus()}
   */
  @Test
  @DisplayName("Test Json executionStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionStatus Json.executionStatus()"})
  void testJsonExecutionStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().executionStatus());
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
    assertNull(actualJson.subjectInitialStatus);
    assertNull(actualJson.subjectEntity);
    assertNull(actualJson.action);
    assertNull(actualJson.executionStatus);
    assertFalse(actualJson.changeSetId.isPresent());
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
   * Test Json {@link Json#subjectEntity()}.
   *
   * <p>Method under test: {@link Json#subjectEntity()}
   */
  @Test
  @DisplayName("Test Json subjectEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.subjectEntity()"})
  void testJsonSubjectEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectEntity());
  }

  /**
   * Test Json {@link Json#subjectInitialStatus()}.
   *
   * <p>Method under test: {@link Json#subjectInitialStatus()}
   */
  @Test
  @DisplayName("Test Json subjectInitialStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus Json.subjectInitialStatus()"})
  void testJsonSubjectInitialStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectInitialStatus());
  }

  /**
   * Test {@link ImmutableChangeUnit#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableChangeUnit.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#provenance()}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeUnit.provenance()"})
  void testProvenance() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        "Provenance",
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableChangeUnit#toString()}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeUnit.toString()"})
  void testToString() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        "ChangeUnit{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, externalId=42,"
            + " provenance=Provenance, kind=ALL, changeSetId=1, subjectEntity=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, subjectInitialStatus=ACTIVE, action=ACTIVATE, executionStatus=PENDING"
            + "}",
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableChangeUnit#withAction(ChangeAction)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withAction(ChangeAction)}
   */
  @Test
  @DisplayName("Test withAction(ChangeAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withAction(ChangeAction)"})
  void testWithAction() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithActionResult =
        immutableChangeUnit.withAction(ChangeAction.ACTIVATE);

    // Assert
    assertSame(immutableChangeUnit, actualWithActionResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withAction(ChangeAction)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withAction(ChangeAction)}
   */
  @Test
  @DisplayName("Test withAction(ChangeAction); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withAction(ChangeAction)"})
  void testWithAction_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.RETIRE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithActionResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withAction(ChangeAction.ACTIVATE);

    // Assert
    EntityReference subjectEntityResult = actualWithActionResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithActionResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withChangeSetId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withChangeSetId(Optional)}
   */
  @Test
  @DisplayName("Test withChangeSetId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withChangeSetId(Optional)"})
  void testWithChangeSetIdWithOptional() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeUnit actualWithChangeSetIdResult = immutableChangeUnit.withChangeSetId(optional);

    // Assert
    assertSame(immutableChangeUnit, actualWithChangeSetIdResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withChangeSetId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withChangeSetId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withChangeSetId(Optional) with 'optional'; then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withChangeSetId(Optional)"})
  void testWithChangeSetIdWithOptional_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableChangeUnit actualWithChangeSetIdResult = immutableChangeUnit.withChangeSetId(optional);

    // Assert
    EntityReference subjectEntityResult = actualWithChangeSetIdResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithChangeSetIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withChangeSetId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withChangeSetId(long)}
   */
  @Test
  @DisplayName("Test withChangeSetId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withChangeSetId(long)"})
  void testWithChangeSetIdWithValue() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithChangeSetIdResult = immutableChangeUnit.withChangeSetId(1L);

    // Assert
    assertSame(immutableChangeUnit, actualWithChangeSetIdResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withChangeSetId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withChangeSetId(long)}
   */
  @Test
  @DisplayName(
      "Test withChangeSetId(long) with 'value'; then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withChangeSetId(long)"})
  void testWithChangeSetIdWithValue_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithChangeSetIdResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withChangeSetId(42L);

    // Assert
    EntityReference subjectEntityResult = actualWithChangeSetIdResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithChangeSetIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithDescriptionResult = immutableChangeUnit.withDescription("42");

    // Assert
    assertEquals(immutableChangeUnit, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("42")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithDescriptionResult = immutableChangeUnit.withDescription("42");

    // Assert
    assertSame(immutableChangeUnit, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withExecutionStatus(ExecutionStatus)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withExecutionStatus(ExecutionStatus)}
   */
  @Test
  @DisplayName("Test withExecutionStatus(ExecutionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeUnit ImmutableChangeUnit.withExecutionStatus(ExecutionStatus)"
  })
  void testWithExecutionStatus() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithExecutionStatusResult =
        immutableChangeUnit.withExecutionStatus(ExecutionStatus.PENDING);

    // Assert
    assertSame(immutableChangeUnit, actualWithExecutionStatusResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withExecutionStatus(ExecutionStatus)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withExecutionStatus(ExecutionStatus)}
   */
  @Test
  @DisplayName(
      "Test withExecutionStatus(ExecutionStatus); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeUnit ImmutableChangeUnit.withExecutionStatus(ExecutionStatus)"
  })
  void testWithExecutionStatus_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.COMPLETE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithExecutionStatusResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withExecutionStatus(ExecutionStatus.PENDING);

    // Assert
    EntityReference subjectEntityResult = actualWithExecutionStatusResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithExecutionStatusResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableChangeUnit actualWithExternalIdResult = immutableChangeUnit.withExternalId(optional);

    // Assert
    assertSame(immutableChangeUnit, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("External Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableChangeUnit actualWithExternalIdResult = immutableChangeUnit.withExternalId(optional);

    // Assert
    EntityReference subjectEntityResult = actualWithExternalIdResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithExternalIdResult = immutableChangeUnit.withExternalId("42");

    // Assert
    assertSame(immutableChangeUnit, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withExternalId(String)"})
  void testWithExternalIdWithValue_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithExternalIdResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference subjectEntityResult = actualWithExternalIdResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeUnit actualWithIdResult = immutableChangeUnit.withId(optional);

    // Assert
    assertSame(immutableChangeUnit, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withId(Optional)"})
  void testWithIdWithOptional_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableChangeUnit actualWithIdResult = immutableChangeUnit.withId(optional);

    // Assert
    EntityReference subjectEntityResult = actualWithIdResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithIdResult = immutableChangeUnit.withId(1L);

    // Assert
    assertSame(immutableChangeUnit, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithIdResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withId(42L);

    // Assert
    EntityReference subjectEntityResult = actualWithIdResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithKindResult = immutableChangeUnit.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableChangeUnit, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withKind(EntityKind)"})
  void testWithKind_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithKindResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    EntityReference subjectEntityResult = actualWithKindResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithLastUpdatedAtResult =
        immutableChangeUnit.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableChangeUnit, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithLastUpdatedByResult = immutableChangeUnit.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableChangeUnit, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithLastUpdatedByResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference subjectEntityResult = actualWithLastUpdatedByResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withName(String)"})
  void testWithName() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithNameResult = immutableChangeUnit.withName("42");

    // Assert
    assertSame(immutableChangeUnit, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withName(String)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withName(String)"})
  void testWithName_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithNameResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withName("42");

    // Assert
    EntityReference subjectEntityResult = actualWithNameResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithNameResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("42");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithProvenanceResult = immutableChangeUnit.withProvenance("42");

    // Assert
    assertSame(immutableChangeUnit, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withProvenance(String)"})
  void testWithProvenance_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithProvenanceResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build()
            .withProvenance("42");

    // Assert
    EntityReference subjectEntityResult = actualWithProvenanceResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableChangeUnit#withSubjectEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableChangeUnit#withSubjectEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withSubjectEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeUnit ImmutableChangeUnit.withSubjectEntity(EntityReference)"})
  void testWithSubjectEntity() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithSubjectEntityResult =
        immutableChangeUnit.withSubjectEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableChangeUnit, actualWithSubjectEntityResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withSubjectInitialStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableChangeUnit#withSubjectInitialStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withSubjectInitialStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeUnit ImmutableChangeUnit.withSubjectInitialStatus(EntityLifecycleStatus)"
  })
  void testWithSubjectInitialStatus() {
    // Arrange
    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    ImmutableChangeUnit immutableChangeUnit =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build();

    // Act
    ImmutableChangeUnit actualWithSubjectInitialStatusResult =
        immutableChangeUnit.withSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableChangeUnit, actualWithSubjectInitialStatusResult);
  }

  /**
   * Test {@link ImmutableChangeUnit#withSubjectInitialStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then subjectEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableChangeUnit#withSubjectInitialStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withSubjectInitialStatus(EntityLifecycleStatus); then subjectEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeUnit ImmutableChangeUnit.withSubjectInitialStatus(EntityLifecycleStatus)"
  })
  void testWithSubjectInitialStatus_thenSubjectEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act
    ImmutableChangeUnit actualWithSubjectInitialStatusResult =
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.PENDING)
            .build()
            .withSubjectInitialStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    EntityReference subjectEntityResult = actualWithSubjectInitialStatusResult.subjectEntity();
    assertTrue(subjectEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", subjectEntityResult.description());
    assertEquals(1L, subjectEntityResult.id());
    assertEquals(EntityKind.ALL, subjectEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectEntityResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithSubjectInitialStatusResult.lastUpdatedAt().toLocalDate());
  }
}
