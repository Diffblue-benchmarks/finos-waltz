package org.finos.waltz.model.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowTransition.Builder;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowTransition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowTransitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#fromState(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#reason(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition Builder.build()",
    "Builder Builder.fromState(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)",
    "Builder Builder.reason(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        actualBuilderResult
            .entityReference(entityReference)
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableEntityWorkflowTransition.lastUpdatedBy());
    assertEquals("Just cause", actualImmutableEntityWorkflowTransition.reason());
    assertEquals("Provenance", actualImmutableEntityWorkflowTransition.provenance());
    assertEquals("To State", actualImmutableEntityWorkflowTransition.toState());
    assertEquals("jane.doe@example.org", actualImmutableEntityWorkflowTransition.fromState());
    assertEquals(1L, actualImmutableEntityWorkflowTransition.workflowId());
    assertSame(lastUpdatedAt, actualImmutableEntityWorkflowTransition.lastUpdatedAt());
    assertSame(entityReference, actualImmutableEntityWorkflowTransition.entityReference());
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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

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
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code
   * EntityWorkflowTransition}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code
   * EntityWorkflowTransition}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition2() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState(null)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowTransition)} with {@code
   * EntityWorkflowTransition}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowTransition) with 'EntityWorkflowTransition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowTransition)"})
  void testBuilderFromWithEntityWorkflowTransition3() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason(null)
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState(null)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason(null)
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition);
    ImmutableEntityWorkflowTransition actualImmutableEntityWorkflowTransition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowTransition2);
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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

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
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#toState(String)}.
   *
   * <ul>
   *   <li>When {@code To State}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#toState(String)}
   */
  @Test
  @DisplayName("Test Builder toState(String); when 'To State'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.toState(String)"})
  void testBuilderToState_whenToState_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act
    Builder actualToStateResult = builderResult.toState("To State");

    // Assert
    assertSame(builderResult, actualToStateResult);
  }

  /**
   * Test Builder {@link Builder#workflowId(long)}.
   *
   * <p>Method under test: {@link Builder#workflowId(long)}
   */
  @Test
  @DisplayName("Test Builder workflowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.workflowId(long)"})
  void testBuilderWorkflowId() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act
    Builder actualWorkflowIdResult = builderResult.workflowId(1L);

    // Assert
    assertSame(builderResult, actualWorkflowIdResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#copyOf(EntityWorkflowTransition)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityWorkflowTransition#copyOf(EntityWorkflowTransition)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityWorkflowTransition); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.copyOf(EntityWorkflowTransition)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableEntityWorkflowTransition instance =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualCopyOfResult =
        ImmutableEntityWorkflowTransition.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Just cause", actualCopyOfResult.reason());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("To State", actualCopyOfResult.toState());
    assertEquals("jane.doe@example.org", actualCopyOfResult.fromState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}, and {@link
   * ImmutableEntityWorkflowTransition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowTransition#equals(Object)}
   *   <li>{@link ImmutableEntityWorkflowTransition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableEntityWorkflowTransition, immutableEntityWorkflowTransition2);
    assertEquals(
        immutableEntityWorkflowTransition.hashCode(),
        immutableEntityWorkflowTransition2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}, and {@link
   * ImmutableEntityWorkflowTransition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowTransition#equals(Object)}
   *   <li>{@link ImmutableEntityWorkflowTransition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableEntityWorkflowTransition, immutableEntityWorkflowTransition);
    int expectedHashCodeResult = immutableEntityWorkflowTransition.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityWorkflowTransition.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("2020-03-01")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("2020-03-01")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("2020-03-01")
            .toState("To State")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("2020-03-01")
            .workflowId(1L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(2L)
            .build();

    Builder builderResult2 = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowTransition,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowTransition.equals(Object)",
    "int ImmutableEntityWorkflowTransition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build(),
        "Different type to ImmutableEntityWorkflowTransition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowTransition#toString()}
   *   <li>{@link ImmutableEntityWorkflowTransition#entityReference()}
   *   <li>{@link ImmutableEntityWorkflowTransition#fromState()}
   *   <li>{@link ImmutableEntityWorkflowTransition#lastUpdatedBy()}
   *   <li>{@link ImmutableEntityWorkflowTransition#reason()}
   *   <li>{@link ImmutableEntityWorkflowTransition#toState()}
   *   <li>{@link ImmutableEntityWorkflowTransition#workflowId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableEntityWorkflowTransition.entityReference()",
    "String ImmutableEntityWorkflowTransition.fromState()",
    "String ImmutableEntityWorkflowTransition.lastUpdatedBy()",
    "String ImmutableEntityWorkflowTransition.reason()",
    "String ImmutableEntityWorkflowTransition.toState()",
    "String ImmutableEntityWorkflowTransition.toString()",
    "long ImmutableEntityWorkflowTransition.workflowId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    String actualToStringResult = immutableEntityWorkflowTransition.toString();
    EntityReference actualEntityReferenceResult =
        immutableEntityWorkflowTransition.entityReference();
    String actualFromStateResult = immutableEntityWorkflowTransition.fromState();
    String actualLastUpdatedByResult = immutableEntityWorkflowTransition.lastUpdatedBy();
    String actualReasonResult = immutableEntityWorkflowTransition.reason();
    String actualToStateResult = immutableEntityWorkflowTransition.toState();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "EntityWorkflowTransition{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " workflowId=1, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " fromState=jane.doe@example.org, toState=To State, reason=Just cause}",
        actualToStringResult);
    assertEquals("Just cause", actualReasonResult);
    assertEquals("To State", actualToStateResult);
    assertEquals("jane.doe@example.org", actualFromStateResult);
    assertEquals(1L, immutableEntityWorkflowTransition.workflowId());
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
   * Test Json {@link Json#fromState()}.
   *
   * <p>Method under test: {@link Json#fromState()}
   */
  @Test
  @DisplayName("Test Json fromState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.fromState()"})
  void testJsonFromState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fromState());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setFromState(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setReason(String)}
   *   <li>{@link Json#setToState(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setFromState(String)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setProvenance(String)",
    "void Json.setReason(String)",
    "void Json.setToState(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setFromState("jane.doe@example.org");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setReason("Just cause");
    actualJson.setToState("To State");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
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
   * Test Json {@link Json#setWorkflowId(long)}.
   *
   * <p>Method under test: {@link Json#setWorkflowId(long)}
   */
  @Test
  @DisplayName("Test Json setWorkflowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setWorkflowId(long)"})
  void testJsonSetWorkflowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setWorkflowId(1L);

    // Assert
    assertEquals(1L, json.workflowId);
    assertTrue(json.workflowIdIsSet);
  }

  /**
   * Test Json {@link Json#toState()}.
   *
   * <p>Method under test: {@link Json#toState()}
   */
  @Test
  @DisplayName("Test Json toState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.toState()"})
  void testJsonToState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().toState());
  }

  /**
   * Test Json {@link Json#workflowId()}.
   *
   * <p>Method under test: {@link Json#workflowId()}
   */
  @Test
  @DisplayName("Test Json workflowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.workflowId()"})
  void testJsonWorkflowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().workflowId());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableEntityWorkflowTransition.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#provenance()}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityWorkflowTransition.provenance()"})
  void testProvenance() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    // Act and Assert
    assertEquals(
        "Provenance",
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityWorkflowTransition#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithEntityReferenceResult =
        immutableEntityWorkflowTransition.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityWorkflowTransition, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withFromState(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withFromState(String)}
   */
  @Test
  @DisplayName("Test withFromState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withFromState(String)"
  })
  void testWithFromState() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithFromStateResult =
        immutableEntityWorkflowTransition.withFromState("42");

    // Assert
    assertSame(immutableEntityWorkflowTransition, actualWithFromStateResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withFromState(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withFromState(String)}
   */
  @Test
  @DisplayName("Test withFromState(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withFromState(String)"
  })
  void testWithFromState_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowTransition actualWithFromStateResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .withFromState("42");

    // Assert
    EntityReference entityReferenceResult = actualWithFromStateResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithFromStateResult.lastUpdatedBy());
    assertEquals("42", actualWithFromStateResult.fromState());
    assertEquals("Just cause", actualWithFromStateResult.reason());
    assertEquals("Provenance", actualWithFromStateResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("To State", actualWithFromStateResult.toState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithFromStateResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithFromStateResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityWorkflowTransition#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithLastUpdatedAtResult =
        immutableEntityWorkflowTransition.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableEntityWorkflowTransition, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithLastUpdatedByResult =
        immutableEntityWorkflowTransition.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableEntityWorkflowTransition, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowTransition actualWithLastUpdatedByResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithLastUpdatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Just cause", actualWithLastUpdatedByResult.reason());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("To State", actualWithLastUpdatedByResult.toState());
    assertEquals("jane.doe@example.org", actualWithLastUpdatedByResult.fromState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithLastUpdatedByResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("42")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithProvenanceResult =
        immutableEntityWorkflowTransition.withProvenance("42");

    // Assert
    assertSame(immutableEntityWorkflowTransition, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withProvenance(String)"
  })
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowTransition actualWithProvenanceResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Just cause", actualWithProvenanceResult.reason());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("To State", actualWithProvenanceResult.toState());
    assertEquals("jane.doe@example.org", actualWithProvenanceResult.fromState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithProvenanceResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withReason(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withReason(String)"
  })
  void testWithReason() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("42")
            .toState("To State")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithReasonResult =
        immutableEntityWorkflowTransition.withReason("42");

    // Assert
    assertSame(immutableEntityWorkflowTransition, actualWithReasonResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withReason(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withReason(String)"
  })
  void testWithReason_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowTransition actualWithReasonResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .withReason("42");

    // Assert
    EntityReference entityReferenceResult = actualWithReasonResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithReasonResult.lastUpdatedBy());
    assertEquals("42", actualWithReasonResult.reason());
    assertEquals("Provenance", actualWithReasonResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("To State", actualWithReasonResult.toState());
    assertEquals("jane.doe@example.org", actualWithReasonResult.fromState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithReasonResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithReasonResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withToState(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withToState(String)}
   */
  @Test
  @DisplayName("Test withToState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withToState(String)"
  })
  void testWithToState() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("42")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithToStateResult =
        immutableEntityWorkflowTransition.withToState("42");

    // Assert
    assertSame(immutableEntityWorkflowTransition, actualWithToStateResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withToState(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withToState(String)}
   */
  @Test
  @DisplayName("Test withToState(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withToState(String)"
  })
  void testWithToState_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowTransition actualWithToStateResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .withToState("42");

    // Assert
    EntityReference entityReferenceResult = actualWithToStateResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithToStateResult.lastUpdatedBy());
    assertEquals("42", actualWithToStateResult.toState());
    assertEquals("Just cause", actualWithToStateResult.reason());
    assertEquals("Provenance", actualWithToStateResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("jane.doe@example.org", actualWithToStateResult.fromState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithToStateResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithToStateResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withWorkflowId(long)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withWorkflowId(long)}
   */
  @Test
  @DisplayName("Test withWorkflowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withWorkflowId(long)"
  })
  void testWithWorkflowId() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();
    ImmutableEntityWorkflowTransition immutableEntityWorkflowTransition =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(42L)
            .build();

    // Act
    ImmutableEntityWorkflowTransition actualWithWorkflowIdResult =
        immutableEntityWorkflowTransition.withWorkflowId(42L);

    // Assert
    assertSame(immutableEntityWorkflowTransition, actualWithWorkflowIdResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowTransition#withWorkflowId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowTransition#withWorkflowId(long)}
   */
  @Test
  @DisplayName("Test withWorkflowId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowTransition ImmutableEntityWorkflowTransition.withWorkflowId(long)"
  })
  void testWithWorkflowId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowTransition.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowTransition actualWithWorkflowIdResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .fromState("jane.doe@example.org")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .reason("Just cause")
            .toState("To State")
            .workflowId(1L)
            .build()
            .withWorkflowId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithWorkflowIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithWorkflowIdResult.lastUpdatedBy());
    assertEquals("Just cause", actualWithWorkflowIdResult.reason());
    assertEquals("Provenance", actualWithWorkflowIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("To State", actualWithWorkflowIdResult.toState());
    assertEquals("jane.doe@example.org", actualWithWorkflowIdResult.fromState());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithWorkflowIdResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithWorkflowIdResult.lastUpdatedAt().toLocalDate());
  }
}
