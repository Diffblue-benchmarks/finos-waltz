package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramAnnotation.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramAnnotation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramAnnotationDiffblueTest {
  /**
   * Test Builder {@link Builder#annotationId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#annotationId(String)}
   */
  @Test
  @DisplayName("Test Builder annotationId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.annotationId(String)"})
  void testBuilderAnnotationId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act
    Builder actualAnnotationIdResult = builderResult.annotationId("42");

    // Assert
    assertSame(builderResult, actualAnnotationIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagramAnnotation Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDiagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    Optional<Long> diagramId = Optional.of(42L);
    Builder actualDiagramIdResult2 = actualDiagramIdResult.diagramId(diagramId);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowDiagramAnnotation actualImmutableFlowDiagramAnnotation =
        actualDiagramIdResult2.entityReference(entityReference).note("Note").build();

    // Assert
    assertEquals("42", actualImmutableFlowDiagramAnnotation.annotationId());
    assertEquals("Note", actualImmutableFlowDiagramAnnotation.note());
    assertSame(entityReference, actualImmutableFlowDiagramAnnotation.entityReference());
  }

  /**
   * Test Builder {@link Builder#diagramId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#diagramId(long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(long)"})
  void testBuilderDiagramIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#diagramId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#diagramId(Optional)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Optional)"})
  void testBuilderDiagramIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    Optional<Long> diagramId = Optional.of(42L);

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(diagramId);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
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
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

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
   * Test Builder {@link Builder#from(FlowDiagramAnnotation)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramAnnotation)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation instance =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowDiagramAnnotation actualImmutableFlowDiagramAnnotation = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramAnnotation);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#note(String)}.
   *
   * <ul>
   *   <li>When {@code Note}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#note(String)}
   */
  @Test
  @DisplayName("Test Builder note(String); when 'Note'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.note(String)"})
  void testBuilderNote_whenNote_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act
    Builder actualNoteResult = builderResult.note("Note");

    // Assert
    assertSame(builderResult, actualNoteResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#copyOf(FlowDiagramAnnotation)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#copyOf(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowDiagramAnnotation); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.copyOf(FlowDiagramAnnotation)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation instance =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act
    ImmutableFlowDiagramAnnotation actualCopyOfResult =
        ImmutableFlowDiagramAnnotation.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.annotationId());
    assertEquals("Note", actualCopyOfResult.note());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#diagramId()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#diagramId()}
   */
  @Test
  @DisplayName("Test diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowDiagramAnnotation.diagramId()"})
  void testDiagramId() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act
    Optional<Long> actualDiagramIdResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build()
            .diagramId();

    // Assert
    assertEquals(1L, actualDiagramIdResult.get().longValue());
    assertTrue(actualDiagramIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}, and {@link
   * ImmutableFlowDiagramAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramAnnotation#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    Builder diagramIdResult2 =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation2 =
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagramAnnotation, immutableFlowDiagramAnnotation2);
    assertEquals(
        immutableFlowDiagramAnnotation.hashCode(), immutableFlowDiagramAnnotation2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}, and {@link
   * ImmutableFlowDiagramAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramAnnotation#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagramAnnotation, immutableFlowDiagramAnnotation);
    int expectedHashCodeResult = immutableFlowDiagramAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowDiagramAnnotation.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("Note").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    Builder diagramIdResult2 =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramAnnotation,
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(2L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    Builder diagramIdResult2 =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramAnnotation,
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    Builder diagramIdResult2 =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramAnnotation,
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("42")
            .build();

    Builder diagramIdResult2 =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramAnnotation,
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertNotEquals(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramAnnotation.equals(Object)",
    "int ImmutableFlowDiagramAnnotation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertNotEquals(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build(),
        "Different type to ImmutableFlowDiagramAnnotation");
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>Then return annotationId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of forty-two; then return annotationId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_thenReturnAnnotationIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setAnnotationId("Json");
    Optional<Long> diagramId = Optional.of(42L);
    json.setDiagramId(diagramId);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setNote("Json");

    // Act
    ImmutableFlowDiagramAnnotation actualFromJsonResult =
        ImmutableFlowDiagramAnnotation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.annotationId());
    assertEquals("Json", actualFromJsonResult.note());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DiagramId is {@code null}.
   *   <li>Then return annotationId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DiagramId is 'null'; then return annotationId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.fromJson(Json)"
  })
  void testFromJson_whenJsonDiagramIdIsNull_thenReturnAnnotationIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setAnnotationId("Json");
    json.setDiagramId(null);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setNote("Json");

    // Act
    ImmutableFlowDiagramAnnotation actualFromJsonResult =
        ImmutableFlowDiagramAnnotation.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.annotationId());
    assertEquals("Json", actualFromJsonResult.note());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramAnnotation#annotationId()}
   *   <li>{@link ImmutableFlowDiagramAnnotation#entityReference()}
   *   <li>{@link ImmutableFlowDiagramAnnotation#note()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFlowDiagramAnnotation.annotationId()",
    "EntityReference ImmutableFlowDiagramAnnotation.entityReference()",
    "String ImmutableFlowDiagramAnnotation.note()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act
    String actualAnnotationIdResult = immutableFlowDiagramAnnotation.annotationId();
    EntityReference actualEntityReferenceResult = immutableFlowDiagramAnnotation.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualAnnotationIdResult);
    assertEquals("Note", immutableFlowDiagramAnnotation.note());
  }

  /**
   * Test Json {@link Json#annotationId()}.
   *
   * <p>Method under test: {@link Json#annotationId()}
   */
  @Test
  @DisplayName("Test Json annotationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.annotationId()"})
  void testJsonAnnotationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().annotationId());
  }

  /**
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
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
    assertNull(actualJson.annotationId);
    assertNull(actualJson.note);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.diagramId.isPresent());
  }

  /**
   * Test Json {@link Json#note()}.
   *
   * <p>Method under test: {@link Json#note()}
   */
  @Test
  @DisplayName("Test Json note()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.note()"})
  void testJsonNote() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().note());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowDiagramAnnotation.toString()"})
  void testToString() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act and Assert
    assertEquals(
        "FlowDiagramAnnotation{annotationId=42, diagramId=1, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, note=Note}",
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withAnnotationId(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withAnnotationId(String)}
   */
  @Test
  @DisplayName("Test withAnnotationId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withAnnotationId(String)"
  })
  void testWithAnnotationId() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act
    ImmutableFlowDiagramAnnotation actualWithAnnotationIdResult =
        immutableFlowDiagramAnnotation.withAnnotationId("42");

    // Assert
    assertSame(immutableFlowDiagramAnnotation, actualWithAnnotationIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withAnnotationId(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withAnnotationId(String)}
   */
  @Test
  @DisplayName(
      "Test withAnnotationId(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withAnnotationId(String)"
  })
  void testWithAnnotationId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("annotationId").diagramId(1L);

    // Act
    ImmutableFlowDiagramAnnotation actualWithAnnotationIdResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build()
            .withAnnotationId("42");

    // Assert
    EntityReference entityReferenceResult = actualWithAnnotationIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithAnnotationIdResult.annotationId());
    assertEquals("Note", actualWithAnnotationIdResult.note());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withDiagramId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withDiagramId(Optional)}
   */
  @Test
  @DisplayName("Test withDiagramId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withDiagramId(Optional)"
  })
  void testWithDiagramIdWithOptional() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowDiagramAnnotation actualWithDiagramIdResult =
        immutableFlowDiagramAnnotation.withDiagramId(optional);

    // Assert
    assertSame(immutableFlowDiagramAnnotation, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withDiagramId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withDiagramId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withDiagramId(Optional)"
  })
  void testWithDiagramIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableFlowDiagramAnnotation actualWithDiagramIdResult =
        immutableFlowDiagramAnnotation.withDiagramId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithDiagramIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDiagramIdResult.annotationId());
    assertEquals("Note", actualWithDiagramIdResult.note());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withDiagramId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withDiagramId(long)}
   */
  @Test
  @DisplayName("Test withDiagramId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withDiagramId(long)"
  })
  void testWithDiagramIdWithValue() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act
    ImmutableFlowDiagramAnnotation actualWithDiagramIdResult =
        immutableFlowDiagramAnnotation.withDiagramId(1L);

    // Assert
    assertSame(immutableFlowDiagramAnnotation, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withDiagramId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withDiagramId(long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withDiagramId(long)"
  })
  void testWithDiagramIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act
    ImmutableFlowDiagramAnnotation actualWithDiagramIdResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build()
            .withDiagramId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithDiagramIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDiagramIdResult.annotationId());
    assertEquals("Note", actualWithDiagramIdResult.note());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowDiagramAnnotation#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build();

    // Act
    ImmutableFlowDiagramAnnotation actualWithEntityReferenceResult =
        immutableFlowDiagramAnnotation.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowDiagramAnnotation, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withNote(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withNote(String)}
   */
  @Test
  @DisplayName("Test withNote(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withNote(String)"
  })
  void testWithNote() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    ImmutableFlowDiagramAnnotation immutableFlowDiagramAnnotation =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("42")
            .build();

    // Act
    ImmutableFlowDiagramAnnotation actualWithNoteResult =
        immutableFlowDiagramAnnotation.withNote("42");

    // Assert
    assertSame(immutableFlowDiagramAnnotation, actualWithNoteResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramAnnotation#withNote(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramAnnotation#withNote(String)}
   */
  @Test
  @DisplayName("Test withNote(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramAnnotation ImmutableFlowDiagramAnnotation.withNote(String)"
  })
  void testWithNote_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);

    // Act
    ImmutableFlowDiagramAnnotation actualWithNoteResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build()
            .withNote("42");

    // Assert
    EntityReference entityReferenceResult = actualWithNoteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNoteResult.annotationId());
    assertEquals("42", actualWithNoteResult.note());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }
}
