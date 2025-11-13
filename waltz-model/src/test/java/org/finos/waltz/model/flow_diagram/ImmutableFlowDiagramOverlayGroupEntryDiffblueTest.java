package org.finos.waltz.model.flow_diagram;

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
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroupEntry.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroupEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramOverlayGroupEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagramOverlayGroupEntry Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIdResult =
        actualBuilderResult.entityReference(entityReference).fill("Fill").id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableFlowDiagramOverlayGroupEntry actualImmutableFlowDiagramOverlayGroupEntry =
        actualIdResult.id(id).overlayGroupId(1L).stroke("Stroke").symbol("Symbol").build();

    // Assert
    assertEquals("Fill", actualImmutableFlowDiagramOverlayGroupEntry.fill());
    assertEquals("Stroke", actualImmutableFlowDiagramOverlayGroupEntry.stroke());
    assertEquals("Symbol", actualImmutableFlowDiagramOverlayGroupEntry.symbol());
    assertEquals(1L, actualImmutableFlowDiagramOverlayGroupEntry.overlayGroupId().longValue());
    assertSame(entityReference, actualImmutableFlowDiagramOverlayGroupEntry.entityReference());
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
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

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
   * Test Builder {@link Builder#fill(String)}.
   *
   * <ul>
   *   <li>When {@code Fill}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fill(String)}
   */
  @Test
  @DisplayName("Test Builder fill(String); when 'Fill'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fill(String)"})
  void testBuilderFill_whenFill_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    Builder actualFillResult = builderResult.fill("Fill");

    // Assert
    assertSame(builderResult, actualFillResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramOverlayGroupEntry)} with {@code
   * FlowDiagramOverlayGroupEntry}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowDiagramOverlayGroupEntry) with 'FlowDiagramOverlayGroupEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramOverlayGroupEntry)"})
  void testBuilderFromWithFlowDiagramOverlayGroupEntry() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry instance =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowDiagramOverlayGroupEntry actualImmutableFlowDiagramOverlayGroupEntry =
        builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroupEntry);
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
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry instance =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act and Assert
    ImmutableFlowDiagramOverlayGroupEntry actualImmutableFlowDiagramOverlayGroupEntry =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroupEntry);
    ImmutableFlowDiagramOverlayGroupEntry actualImmutableFlowDiagramOverlayGroupEntry2 =
        builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroupEntry2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

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
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

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
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#overlayGroupId(Long)}.
   *
   * <p>Method under test: {@link Builder#overlayGroupId(Long)}
   */
  @Test
  @DisplayName("Test Builder overlayGroupId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.overlayGroupId(Long)"})
  void testBuilderOverlayGroupId() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    Builder actualOverlayGroupIdResult = builderResult.overlayGroupId(1L);

    // Assert
    assertSame(builderResult, actualOverlayGroupIdResult);
  }

  /**
   * Test Builder {@link Builder#stroke(String)}.
   *
   * <ul>
   *   <li>When {@code Stroke}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#stroke(String)}
   */
  @Test
  @DisplayName("Test Builder stroke(String); when 'Stroke'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.stroke(String)"})
  void testBuilderStroke_whenStroke_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    Builder actualStrokeResult = builderResult.stroke("Stroke");

    // Assert
    assertSame(builderResult, actualStrokeResult);
  }

  /**
   * Test Builder {@link Builder#symbol(String)}.
   *
   * <ul>
   *   <li>When {@code Symbol}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#symbol(String)}
   */
  @Test
  @DisplayName("Test Builder symbol(String); when 'Symbol'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.symbol(String)"})
  void testBuilderSymbol_whenSymbol_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    Builder actualSymbolResult = builderResult.symbol("Symbol");

    // Assert
    assertSame(builderResult, actualSymbolResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#copyOf(FlowDiagramOverlayGroupEntry)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowDiagramOverlayGroupEntry#copyOf(FlowDiagramOverlayGroupEntry)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowDiagramOverlayGroupEntry); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.copyOf(FlowDiagramOverlayGroupEntry)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry instance =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualCopyOfResult =
        ImmutableFlowDiagramOverlayGroupEntry.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Fill", actualCopyOfResult.fill());
    assertEquals("Stroke", actualCopyOfResult.stroke());
    assertEquals("Symbol", actualCopyOfResult.symbol());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualCopyOfResult.overlayGroupId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}, and {@link
   * ImmutableFlowDiagramOverlayGroupEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry2 =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagramOverlayGroupEntry, immutableFlowDiagramOverlayGroupEntry2);
    assertEquals(
        immutableFlowDiagramOverlayGroupEntry.hashCode(),
        immutableFlowDiagramOverlayGroupEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}, and {@link
   * ImmutableFlowDiagramOverlayGroupEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagramOverlayGroupEntry, immutableFlowDiagramOverlayGroupEntry);
    int expectedHashCodeResult = immutableFlowDiagramOverlayGroupEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowDiagramOverlayGroupEntry.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroupEntry,
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Symbol")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroupEntry,
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(2L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroupEntry,
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(2L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroupEntry,
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Symbol")
            .symbol("Symbol")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroupEntry,
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Fill")
            .build();

    Builder builderResult2 = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroupEntry,
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroupEntry.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build(),
        "Different type to ImmutableFlowDiagramOverlayGroupEntry");
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return fill is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return fill is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnFillIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setOverlayGroupId(1L);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSymbol("Json");
    json.setFill("Json");
    json.setStroke("Json");

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualFromJsonResult =
        ImmutableFlowDiagramOverlayGroupEntry.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fill());
    assertEquals("Json", actualFromJsonResult.stroke());
    assertEquals("Json", actualFromJsonResult.symbol());
    assertEquals(1L, actualFromJsonResult.overlayGroupId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return fill is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Id is 'null'; then return fill is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.fromJson(Json)"
  })
  void testFromJson_whenJsonIdIsNull_thenReturnFillIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setOverlayGroupId(1L);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSymbol("Json");
    json.setFill("Json");
    json.setStroke("Json");

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualFromJsonResult =
        ImmutableFlowDiagramOverlayGroupEntry.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fill());
    assertEquals("Json", actualFromJsonResult.stroke());
    assertEquals("Json", actualFromJsonResult.symbol());
    assertEquals(1L, actualFromJsonResult.overlayGroupId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#entityReference()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#fill()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#overlayGroupId()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#stroke()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroupEntry#symbol()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableFlowDiagramOverlayGroupEntry.entityReference()",
    "String ImmutableFlowDiagramOverlayGroupEntry.fill()",
    "Long ImmutableFlowDiagramOverlayGroupEntry.overlayGroupId()",
    "String ImmutableFlowDiagramOverlayGroupEntry.stroke()",
    "String ImmutableFlowDiagramOverlayGroupEntry.symbol()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    EntityReference actualEntityReferenceResult =
        immutableFlowDiagramOverlayGroupEntry.entityReference();
    String actualFillResult = immutableFlowDiagramOverlayGroupEntry.fill();
    Long actualOverlayGroupIdResult = immutableFlowDiagramOverlayGroupEntry.overlayGroupId();
    String actualStrokeResult = immutableFlowDiagramOverlayGroupEntry.stroke();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Fill", actualFillResult);
    assertEquals("Stroke", actualStrokeResult);
    assertEquals("Symbol", immutableFlowDiagramOverlayGroupEntry.symbol());
    assertEquals(1L, actualOverlayGroupIdResult.longValue());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#id()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowDiagramOverlayGroupEntry.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    Optional<Long> actualIdResult =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#fill()}.
   *
   * <p>Method under test: {@link Json#fill()}
   */
  @Test
  @DisplayName("Test Json fill()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.fill()"})
  void testJsonFill() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fill());
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
    assertNull(actualJson.overlayGroupId);
    assertNull(actualJson.fill);
    assertNull(actualJson.stroke);
    assertNull(actualJson.symbol);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#overlayGroupId()}.
   *
   * <p>Method under test: {@link Json#overlayGroupId()}
   */
  @Test
  @DisplayName("Test Json overlayGroupId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.overlayGroupId()"})
  void testJsonOverlayGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overlayGroupId());
  }

  /**
   * Test Json {@link Json#stroke()}.
   *
   * <p>Method under test: {@link Json#stroke()}
   */
  @Test
  @DisplayName("Test Json stroke()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.stroke()"})
  void testJsonStroke() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().stroke());
  }

  /**
   * Test Json {@link Json#symbol()}.
   *
   * <p>Method under test: {@link Json#symbol()}
   */
  @Test
  @DisplayName("Test Json symbol()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.symbol()"})
  void testJsonSymbol() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().symbol());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowDiagramOverlayGroupEntry.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act and Assert
    assertEquals(
        "FlowDiagramOverlayGroupEntry{id=1, overlayGroupId=1, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, symbol=Symbol, fill=Fill, stroke=Stroke}",
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowDiagramOverlayGroupEntry#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithEntityReferenceResult =
        immutableFlowDiagramOverlayGroupEntry.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowDiagramOverlayGroupEntry, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withFill(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withFill(String)}
   */
  @Test
  @DisplayName("Test withFill(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withFill(String)"
  })
  void testWithFill() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("42")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithFillResult =
        immutableFlowDiagramOverlayGroupEntry.withFill("42");

    // Assert
    assertSame(immutableFlowDiagramOverlayGroupEntry, actualWithFillResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withFill(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withFill(String)}
   */
  @Test
  @DisplayName("Test withFill(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withFill(String)"
  })
  void testWithFill_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithFillResult =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .withFill("42");

    // Assert
    EntityReference entityReferenceResult = actualWithFillResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithFillResult.fill());
    assertEquals("Stroke", actualWithFillResult.stroke());
    assertEquals("Symbol", actualWithFillResult.symbol());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithFillResult.overlayGroupId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithIdResult =
        immutableFlowDiagramOverlayGroupEntry.withId(optional);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroupEntry, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withId(Optional)"
  })
  void testWithIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithIdResult =
        immutableFlowDiagramOverlayGroupEntry.withId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Fill", actualWithIdResult.fill());
    assertEquals("Stroke", actualWithIdResult.stroke());
    assertEquals("Symbol", actualWithIdResult.symbol());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithIdResult.overlayGroupId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithIdResult =
        immutableFlowDiagramOverlayGroupEntry.withId(1L);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroupEntry, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withId(long)"
  })
  void testWithIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithIdResult =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .withId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Fill", actualWithIdResult.fill());
    assertEquals("Stroke", actualWithIdResult.stroke());
    assertEquals("Symbol", actualWithIdResult.symbol());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithIdResult.overlayGroupId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withOverlayGroupId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withOverlayGroupId(Long)}
   */
  @Test
  @DisplayName("Test withOverlayGroupId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withOverlayGroupId(Long)"
  })
  void testWithOverlayGroupId() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithOverlayGroupIdResult =
        immutableFlowDiagramOverlayGroupEntry.withOverlayGroupId(1L);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroupEntry, actualWithOverlayGroupIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withOverlayGroupId(Long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withOverlayGroupId(Long)}
   */
  @Test
  @DisplayName(
      "Test withOverlayGroupId(Long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withOverlayGroupId(Long)"
  })
  void testWithOverlayGroupId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithOverlayGroupIdResult =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .withOverlayGroupId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithOverlayGroupIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Fill", actualWithOverlayGroupIdResult.fill());
    assertEquals("Stroke", actualWithOverlayGroupIdResult.stroke());
    assertEquals("Symbol", actualWithOverlayGroupIdResult.symbol());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithOverlayGroupIdResult.overlayGroupId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withStroke(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withStroke(String)}
   */
  @Test
  @DisplayName("Test withStroke(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withStroke(String)"
  })
  void testWithStroke() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("42")
            .symbol("Symbol")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithStrokeResult =
        immutableFlowDiagramOverlayGroupEntry.withStroke("42");

    // Assert
    assertSame(immutableFlowDiagramOverlayGroupEntry, actualWithStrokeResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withStroke(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withStroke(String)}
   */
  @Test
  @DisplayName("Test withStroke(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withStroke(String)"
  })
  void testWithStroke_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithStrokeResult =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .withStroke("42");

    // Assert
    EntityReference entityReferenceResult = actualWithStrokeResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithStrokeResult.stroke());
    assertEquals("Fill", actualWithStrokeResult.fill());
    assertEquals("Symbol", actualWithStrokeResult.symbol());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithStrokeResult.overlayGroupId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withSymbol(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withSymbol(String)}
   */
  @Test
  @DisplayName("Test withSymbol(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withSymbol(String)"
  })
  void testWithSymbol() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();
    ImmutableFlowDiagramOverlayGroupEntry immutableFlowDiagramOverlayGroupEntry =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("42")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithSymbolResult =
        immutableFlowDiagramOverlayGroupEntry.withSymbol("42");

    // Assert
    assertSame(immutableFlowDiagramOverlayGroupEntry, actualWithSymbolResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroupEntry#withSymbol(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroupEntry#withSymbol(String)}
   */
  @Test
  @DisplayName("Test withSymbol(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroupEntry ImmutableFlowDiagramOverlayGroupEntry.withSymbol(String)"
  })
  void testWithSymbol_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroupEntry.builder();

    // Act
    ImmutableFlowDiagramOverlayGroupEntry actualWithSymbolResult =
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
            .fill("Fill")
            .id(1L)
            .overlayGroupId(1L)
            .stroke("Stroke")
            .symbol("Symbol")
            .build()
            .withSymbol("42");

    // Assert
    EntityReference entityReferenceResult = actualWithSymbolResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSymbolResult.symbol());
    assertEquals("Fill", actualWithSymbolResult.fill());
    assertEquals("Stroke", actualWithSymbolResult.stroke());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithSymbolResult.overlayGroupId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }
}
