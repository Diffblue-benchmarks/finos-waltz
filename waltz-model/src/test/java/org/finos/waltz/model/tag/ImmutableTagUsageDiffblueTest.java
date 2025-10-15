package org.finos.waltz.model.tag;

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
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.tag.ImmutableTagUsage.Builder;
import org.finos.waltz.model.tag.ImmutableTagUsage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTagUsageDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTagUsage Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualCreatedByResult =
        ImmutableTagUsage.builder().createdAt(createdAt).createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableTagUsage actualImmutableTagUsage =
        actualCreatedByResult
            .entityReference(entityReference)
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Assert
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualImmutableTagUsage.createdBy());
    assertEquals("Provenance", actualImmutableTagUsage.provenance());
    assertEquals(1L, actualImmutableTagUsage.tagId());
    assertSame(createdAt, actualImmutableTagUsage.createdAt());
    assertSame(entityReference, actualImmutableTagUsage.entityReference());
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   *
   * <ul>
   *   <li>When {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName(
      "Test Builder createdBy(String); when 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy_whenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
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
    Builder builderResult = ImmutableTagUsage.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage instance =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act and Assert
    ImmutableTagUsage actualImmutableTagUsage =
        builderResult.from((CreatedProvider) instance).build();
    assertEquals(instance, actualImmutableTagUsage);
    ImmutableTagUsage actualImmutableTagUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableTagUsage2);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException());
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
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
    Builder builderResult = ImmutableTagUsage.builder();

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
    Builder builderResult = ImmutableTagUsage.builder();

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage instance =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act and Assert
    ImmutableTagUsage actualImmutableTagUsage =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableTagUsage);
    ImmutableTagUsage actualImmutableTagUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableTagUsage2);
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
    Builder builderResult = ImmutableTagUsage.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
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
   * Test Builder {@link Builder#from(TagUsage)} with {@code TagUsage}.
   *
   * <p>Method under test: {@link Builder#from(TagUsage)}
   */
  @Test
  @DisplayName("Test Builder from(TagUsage) with 'TagUsage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TagUsage)"})
  void testBuilderFromWithTagUsage() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage instance =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTagUsage actualImmutableTagUsage = builderResult.build();
    assertEquals(instance, actualImmutableTagUsage);
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
    Builder builderResult = ImmutableTagUsage.builder();

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage instance =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act and Assert
    ImmutableTagUsage actualImmutableTagUsage = builderResult.from((WaltzEntity) instance).build();
    assertEquals(instance, actualImmutableTagUsage);
    ImmutableTagUsage actualImmutableTagUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableTagUsage2);
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
    Builder builderResult = ImmutableTagUsage.builder();

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
    Builder builderResult = ImmutableTagUsage.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Test Builder {@link Builder#tagId(long)}.
   *
   * <p>Method under test: {@link Builder#tagId(long)}
   */
  @Test
  @DisplayName("Test Builder tagId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tagId(long)"})
  void testBuilderTagId() {
    // Arrange
    Builder builderResult = ImmutableTagUsage.builder();

    // Act
    Builder actualTagIdResult = builderResult.tagId(1L);

    // Assert
    assertSame(builderResult, actualTagIdResult);
  }

  /**
   * Test {@link ImmutableTagUsage#copyOf(TagUsage)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#copyOf(TagUsage)}
   */
  @Test
  @DisplayName("Test copyOf(TagUsage); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.copyOf(TagUsage)"})
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage instance =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act
    ImmutableTagUsage actualCopyOfResult = ImmutableTagUsage.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.tagId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTagUsage#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableTagUsage.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act
    LocalDateTime actualCreatedAtResult =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}, and {@link ImmutableTagUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTagUsage#equals(Object)}
   *   <li>{@link ImmutableTagUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage2 =
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableTagUsage, immutableTagUsage2);
    assertEquals(immutableTagUsage.hashCode(), immutableTagUsage2.hashCode());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}, and {@link ImmutableTagUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTagUsage#equals(Object)}
   *   <li>{@link ImmutableTagUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableTagUsage, immutableTagUsage);
    int expectedHashCodeResult = immutableTagUsage.hashCode();
    assertEquals(expectedHashCodeResult, immutableTagUsage.hashCode());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        immutableTagUsage,
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Provenance");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        immutableTagUsage,
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        immutableTagUsage,
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Jan 1, 2020 8:00am GMT+0100")
            .tagId(1L)
            .build();

    Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        immutableTagUsage,
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(2L)
            .build();

    Builder createdByResult2 =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        immutableTagUsage,
        createdByResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTagUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTagUsage.equals(Object)",
    "int ImmutableTagUsage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertNotEquals(
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build(),
        "Different type to ImmutableTagUsage");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTagUsage#toString()}
   *   <li>{@link ImmutableTagUsage#createdBy()}
   *   <li>{@link ImmutableTagUsage#entityReference()}
   *   <li>{@link ImmutableTagUsage#tagId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableTagUsage.createdBy()",
    "EntityReference ImmutableTagUsage.entityReference()",
    "long ImmutableTagUsage.tagId()",
    "String ImmutableTagUsage.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act
    String actualToStringResult = immutableTagUsage.toString();
    String actualCreatedByResult = immutableTagUsage.createdBy();
    EntityReference actualEntityReferenceResult = immutableTagUsage.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(
        "TagUsage{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, createdAt=1970"
            + "-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100, provenance=Provenance, tagId=1}",
        actualToStringResult);
    assertEquals(1L, immutableTagUsage.tagId());
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
   * Test Json {@link Json#createdBy()}.
   *
   * <p>Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdBy());
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
   *   <li>{@link Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link Json#setCreatedBy(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCreatedAt(LocalDateTime)",
    "void Json.setCreatedBy(String)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setProvenance(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
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
   * Test Json {@link Json#setTagId(long)}.
   *
   * <p>Method under test: {@link Json#setTagId(long)}
   */
  @Test
  @DisplayName("Test Json setTagId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setTagId(long)"})
  void testJsonSetTagId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTagId(1L);

    // Assert
    assertEquals(1L, json.tagId);
    assertTrue(json.tagIdIsSet);
  }

  /**
   * Test Json {@link Json#tagId()}.
   *
   * <p>Method under test: {@link Json#tagId()}
   */
  @Test
  @DisplayName("Test Json tagId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.tagId()"})
  void testJsonTagId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().tagId());
  }

  /**
   * Test {@link ImmutableTagUsage#provenance()}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableTagUsage.provenance()"})
  void testProvenance() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act and Assert
    assertEquals(
        "Provenance",
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableTagUsage#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withCreatedAt(LocalDateTime)"})
  void testWithCreatedAt() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act
    ImmutableTagUsage actualWithCreatedAtResult =
        immutableTagUsage.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableTagUsage, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withCreatedBy(String)"})
  void testWithCreatedBy() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act
    ImmutableTagUsage actualWithCreatedByResult = immutableTagUsage.withCreatedBy("42");

    // Assert
    assertSame(immutableTagUsage, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withCreatedBy(String)"})
  void testWithCreatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act
    ImmutableTagUsage actualWithCreatedByResult =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build()
            .withCreatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithCreatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithCreatedByResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithCreatedByResult.createdBy());
    assertEquals("Provenance", actualWithCreatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithCreatedByResult.tagId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withEntityReference(EntityReference)"})
  void testWithEntityReference() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build();

    // Act
    ImmutableTagUsage actualWithEntityReferenceResult =
        immutableTagUsage.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableTagUsage, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("42")
            .tagId(1L)
            .build();

    // Act
    ImmutableTagUsage actualWithProvenanceResult = immutableTagUsage.withProvenance("42");

    // Assert
    assertSame(immutableTagUsage, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withProvenance(String)"})
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act
    ImmutableTagUsage actualWithProvenanceResult =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithProvenanceResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithProvenanceResult.createdBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithProvenanceResult.tagId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withTagId(long)}.
   *
   * <p>Method under test: {@link ImmutableTagUsage#withTagId(long)}
   */
  @Test
  @DisplayName("Test withTagId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withTagId(long)"})
  void testWithTagId() {
    // Arrange
    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");
    ImmutableTagUsage immutableTagUsage =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(42L)
            .build();

    // Act
    ImmutableTagUsage actualWithTagIdResult = immutableTagUsage.withTagId(42L);

    // Assert
    assertSame(immutableTagUsage, actualWithTagIdResult);
  }

  /**
   * Test {@link ImmutableTagUsage#withTagId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTagUsage#withTagId(long)}
   */
  @Test
  @DisplayName("Test withTagId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTagUsage ImmutableTagUsage.withTagId(long)"})
  void testWithTagId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder createdByResult =
        ImmutableTagUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Act
    ImmutableTagUsage actualWithTagIdResult =
        createdByResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .tagId(1L)
            .build()
            .withTagId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithTagIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithTagIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithTagIdResult.createdBy());
    assertEquals("Provenance", actualWithTagIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithTagIdResult.tagId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
