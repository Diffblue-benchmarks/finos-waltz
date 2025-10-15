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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowState.Builder;
import org.finos.waltz.model.entity_workflow.ImmutableEntityWorkflowState.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityWorkflowStateDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableEntityWorkflowState.builder()
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
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState =
        actualDescriptionResult
            .entityReference(entityReference)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableEntityWorkflowState.lastUpdatedBy());
    assertEquals("MD", actualImmutableEntityWorkflowState.state());
    assertEquals("Provenance", actualImmutableEntityWorkflowState.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityWorkflowState.description());
    assertEquals(1L, actualImmutableEntityWorkflowState.workflowId());
    assertSame(lastUpdatedAt, actualImmutableEntityWorkflowState.lastUpdatedAt());
    assertSame(entityReference, actualImmutableEntityWorkflowState.entityReference());
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState instance =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowState);
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowState2);
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowState)} with {@code EntityWorkflowState}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowState)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowState) with 'EntityWorkflowState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowState)"})
  void testBuilderFromWithEntityWorkflowState() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState instance =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState = builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowState);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWorkflowState)} with {@code EntityWorkflowState}.
   *
   * <p>Method under test: {@link Builder#from(EntityWorkflowState)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWorkflowState) with 'EntityWorkflowState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWorkflowState)"})
  void testBuilderFromWithEntityWorkflowState2() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    Builder descriptionResult = ImmutableEntityWorkflowState.builder().description(null);
    ImmutableEntityWorkflowState instance =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState = builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowState);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState instance =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowState);
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowState2);
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState instance =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act and Assert
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableEntityWorkflowState);
    ImmutableEntityWorkflowState actualImmutableEntityWorkflowState2 = builderResult.build();
    assertEquals(instance, actualImmutableEntityWorkflowState2);
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    ImmutableEntityWorkflowTransition.Builder builderResult2 =
        ImmutableEntityWorkflowTransition.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#state(String)}.
   *
   * <ul>
   *   <li>When {@code MD}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#state(String)}
   */
  @Test
  @DisplayName("Test Builder state(String); when 'MD'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.state(String)"})
  void testBuilderState_whenMd_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act
    Builder actualStateResult = builderResult.state("MD");

    // Assert
    assertSame(builderResult, actualStateResult);
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
    Builder builderResult = ImmutableEntityWorkflowState.builder();

    // Act
    Builder actualWorkflowIdResult = builderResult.workflowId(1L);

    // Assert
    assertSame(builderResult, actualWorkflowIdResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#copyOf(EntityWorkflowState)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#copyOf(EntityWorkflowState)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityWorkflowState); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.copyOf(EntityWorkflowState)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableEntityWorkflowState instance =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualCopyOfResult = ImmutableEntityWorkflowState.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("MD", actualCopyOfResult.state());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}, and {@link
   * ImmutableEntityWorkflowState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowState#equals(Object)}
   *   <li>{@link ImmutableEntityWorkflowState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState2 =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableEntityWorkflowState, immutableEntityWorkflowState2);
    assertEquals(immutableEntityWorkflowState.hashCode(), immutableEntityWorkflowState2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}, and {@link
   * ImmutableEntityWorkflowState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowState#equals(Object)}
   *   <li>{@link ImmutableEntityWorkflowState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableEntityWorkflowState, immutableEntityWorkflowState);
    int expectedHashCodeResult = immutableEntityWorkflowState.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityWorkflowState.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowState,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowState,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowState,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("2020-03-01")
            .state("MD")
            .workflowId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowState,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("2020-03-01")
            .workflowId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowState,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(2L)
            .build();

    Builder descriptionResult2 =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableEntityWorkflowState,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWorkflowState.equals(Object)",
    "int ImmutableEntityWorkflowState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build(),
        "Different type to ImmutableEntityWorkflowState");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWorkflowState#toString()}
   *   <li>{@link ImmutableEntityWorkflowState#description()}
   *   <li>{@link ImmutableEntityWorkflowState#entityReference()}
   *   <li>{@link ImmutableEntityWorkflowState#lastUpdatedBy()}
   *   <li>{@link ImmutableEntityWorkflowState#state()}
   *   <li>{@link ImmutableEntityWorkflowState#workflowId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntityWorkflowState.description()",
    "EntityReference ImmutableEntityWorkflowState.entityReference()",
    "String ImmutableEntityWorkflowState.lastUpdatedBy()",
    "String ImmutableEntityWorkflowState.state()",
    "String ImmutableEntityWorkflowState.toString()",
    "long ImmutableEntityWorkflowState.workflowId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    String actualToStringResult = immutableEntityWorkflowState.toString();
    String actualDescriptionResult = immutableEntityWorkflowState.description();
    EntityReference actualEntityReferenceResult = immutableEntityWorkflowState.entityReference();
    String actualLastUpdatedByResult = immutableEntityWorkflowState.lastUpdatedBy();
    String actualStateResult = immutableEntityWorkflowState.state();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "EntityWorkflowState{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " workflowId=1, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " state=MD}",
        actualToStringResult);
    assertEquals("MD", actualStateResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutableEntityWorkflowState.workflowId());
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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setState(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setProvenance(String)",
    "void Json.setState(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");
    actualJson.setState("MD");

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
   * Test Json {@link Json#state()}.
   *
   * <p>Method under test: {@link Json#state()}
   */
  @Test
  @DisplayName("Test Json state()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.state()"})
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().state());
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
   * Test {@link ImmutableEntityWorkflowState#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableEntityWorkflowState.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
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
   * Test {@link ImmutableEntityWorkflowState#provenance()}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityWorkflowState.provenance()"})
  void testProvenance() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertEquals(
        "Provenance",
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithDescriptionResult =
        immutableEntityWorkflowState.withDescription("42");

    // Assert
    assertEquals(immutableEntityWorkflowState, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder descriptionResult = ImmutableEntityWorkflowState.builder().description("42");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithDescriptionResult =
        immutableEntityWorkflowState.withDescription("42");

    // Assert
    assertSame(immutableEntityWorkflowState, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithEntityReferenceResult =
        immutableEntityWorkflowState.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityWorkflowState, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithLastUpdatedAtResult =
        immutableEntityWorkflowState.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableEntityWorkflowState, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithLastUpdatedByResult =
        immutableEntityWorkflowState.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableEntityWorkflowState, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowState actualWithLastUpdatedByResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithLastUpdatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("MD", actualWithLastUpdatedByResult.state());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithLastUpdatedByResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("42")
            .state("MD")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithProvenanceResult =
        immutableEntityWorkflowState.withProvenance("42");

    // Assert
    assertSame(immutableEntityWorkflowState, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withProvenance(String)"
  })
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowState actualWithProvenanceResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("MD", actualWithProvenanceResult.state());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithProvenanceResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withState(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withState(String)}
   */
  @Test
  @DisplayName("Test withState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withState(String)"})
  void testWithState() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("42")
            .workflowId(1L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithStateResult =
        immutableEntityWorkflowState.withState("42");

    // Assert
    assertSame(immutableEntityWorkflowState, actualWithStateResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withState(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withState(String)}
   */
  @Test
  @DisplayName("Test withState(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withState(String)"})
  void testWithState_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowState actualWithStateResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build()
            .withState("42");

    // Assert
    EntityReference entityReferenceResult = actualWithStateResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithStateResult.lastUpdatedBy());
    assertEquals("42", actualWithStateResult.state());
    assertEquals("Provenance", actualWithStateResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithStateResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithStateResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithStateResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withWorkflowId(long)}.
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withWorkflowId(long)}
   */
  @Test
  @DisplayName("Test withWorkflowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withWorkflowId(long)"
  })
  void testWithWorkflowId() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityWorkflowState immutableEntityWorkflowState =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(42L)
            .build();

    // Act
    ImmutableEntityWorkflowState actualWithWorkflowIdResult =
        immutableEntityWorkflowState.withWorkflowId(42L);

    // Assert
    assertSame(immutableEntityWorkflowState, actualWithWorkflowIdResult);
  }

  /**
   * Test {@link ImmutableEntityWorkflowState#withWorkflowId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWorkflowState#withWorkflowId(long)}
   */
  @Test
  @DisplayName("Test withWorkflowId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWorkflowState ImmutableEntityWorkflowState.withWorkflowId(long)"
  })
  void testWithWorkflowId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableEntityWorkflowState.builder()
            .description("The characteristics of someone or something");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableEntityWorkflowState actualWithWorkflowIdResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .state("MD")
            .workflowId(1L)
            .build()
            .withWorkflowId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithWorkflowIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithWorkflowIdResult.lastUpdatedBy());
    assertEquals("MD", actualWithWorkflowIdResult.state());
    assertEquals("Provenance", actualWithWorkflowIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithWorkflowIdResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithWorkflowIdResult.workflowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithWorkflowIdResult.lastUpdatedAt().toLocalDate());
  }
}
