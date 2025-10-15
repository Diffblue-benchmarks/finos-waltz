package org.finos.waltz.model.custom_environment;

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
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsage.Builder;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentUsageDiffblueTest {
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
    "ImmutableCustomEnvironmentUsage Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualCustomEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(createdAt)
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
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
        actualCustomEnvironmentIdResult.entityReference(entityReference).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage =
        actualIdResult.id(id).provenance("Provenance").build();

    // Assert
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualImmutableCustomEnvironmentUsage.createdBy());
    assertEquals("Provenance", actualImmutableCustomEnvironmentUsage.provenance());
    assertEquals(1L, actualImmutableCustomEnvironmentUsage.customEnvironmentId().longValue());
    assertSame(createdAt, actualImmutableCustomEnvironmentUsage.createdAt());
    assertSame(entityReference, actualImmutableCustomEnvironmentUsage.entityReference());
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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#customEnvironmentId(Long)}.
   *
   * <p>Method under test: {@link Builder#customEnvironmentId(Long)}
   */
  @Test
  @DisplayName("Test Builder customEnvironmentId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.customEnvironmentId(Long)"})
  void testBuilderCustomEnvironmentId() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    // Act
    Builder actualCustomEnvironmentIdResult = builderResult.customEnvironmentId(1L);

    // Assert
    assertSame(builderResult, actualCustomEnvironmentIdResult);
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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage instance =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage =
        builderResult.from((CreatedProvider) instance).build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage);
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage2);
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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
   * Test Builder {@link Builder#from(CustomEnvironmentUsage)} with {@code CustomEnvironmentUsage}.
   *
   * <p>Method under test: {@link Builder#from(CustomEnvironmentUsage)}
   */
  @Test
  @DisplayName("Test Builder from(CustomEnvironmentUsage) with 'CustomEnvironmentUsage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CustomEnvironmentUsage)"})
  void testBuilderFromWithCustomEnvironmentUsage() {
    // Arrange
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage instance =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage);
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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage instance =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage);
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage2);
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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage instance =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage);
    ImmutableCustomEnvironmentUsage actualImmutableCustomEnvironmentUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableCustomEnvironmentUsage2);
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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();

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
    Builder builderResult = ImmutableCustomEnvironmentUsage.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#copyOf(CustomEnvironmentUsage)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#copyOf(CustomEnvironmentUsage)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CustomEnvironmentUsage); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.copyOf(CustomEnvironmentUsage)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage instance =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualCopyOfResult =
        ImmutableCustomEnvironmentUsage.copyOf(instance);

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
    assertEquals(1L, actualCopyOfResult.customEnvironmentId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableCustomEnvironmentUsage.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    LocalDateTime actualCreatedAtResult =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}, and {@link
   * ImmutableCustomEnvironmentUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironmentUsage#equals(Object)}
   *   <li>{@link ImmutableCustomEnvironmentUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage2 =
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableCustomEnvironmentUsage, immutableCustomEnvironmentUsage2);
    assertEquals(
        immutableCustomEnvironmentUsage.hashCode(), immutableCustomEnvironmentUsage2.hashCode());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}, and {@link
   * ImmutableCustomEnvironmentUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironmentUsage#equals(Object)}
   *   <li>{@link ImmutableCustomEnvironmentUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableCustomEnvironmentUsage, immutableCustomEnvironmentUsage);
    int expectedHashCodeResult = immutableCustomEnvironmentUsage.hashCode();
    assertEquals(expectedHashCodeResult, immutableCustomEnvironmentUsage.hashCode());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsage,
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Provenance")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsage,
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(2L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsage,
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsage,
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .provenance("Provenance")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsage,
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Jan 1, 2020 8:00am GMT+0100")
            .build();

    Builder customEnvironmentIdResult2 =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        immutableCustomEnvironmentUsage,
        customEnvironmentIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCustomEnvironmentUsage.equals(Object)",
    "int ImmutableCustomEnvironmentUsage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertNotEquals(
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableCustomEnvironmentUsage");
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) Id is of one.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) Id is of one; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.fromJson(Json)"
  })
  void testFromJson_givenOfOne_whenJsonIdIsOfOne_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(1L);
    json.setId(id);
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setProvenance(null);
    json.setCustomEnvironmentId(1L);
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
    ImmutableCustomEnvironmentUsage actualFromJsonResult =
        ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) CreatedBy is {@code Json}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) CreatedBy is 'Json'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.fromJson(Json)"
  })
  void testFromJson_givenOne_whenJsonCreatedByIsJson_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setProvenance(null);
    json.setCustomEnvironmentId(1L);
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
    ImmutableCustomEnvironmentUsage actualFromJsonResult =
        ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) Provenance is {@code Json}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) Provenance is 'Json'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.fromJson(Json)"
  })
  void testFromJson_givenOne_whenJsonProvenanceIsJson_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setProvenance("Json");
    json.setCustomEnvironmentId(1L);
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
    ImmutableCustomEnvironmentUsage actualFromJsonResult =
        ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return createdAt is {@link Json} (default constructor) {@link Json#createdAt}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return createdAt is Json (default constructor) createdAt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.fromJson(Json)"
  })
  void testFromJson_thenReturnCreatedAtIsJsonCreatedAt() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setCreatedBy("Json");
    json.setProvenance(null);
    json.setCustomEnvironmentId(1L);
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
    ImmutableCustomEnvironmentUsage actualFromJsonResult =
        ImmutableCustomEnvironmentUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.createdBy());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.customEnvironmentId().longValue());
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCustomEnvironmentUsage#createdBy()}
   *   <li>{@link ImmutableCustomEnvironmentUsage#customEnvironmentId()}
   *   <li>{@link ImmutableCustomEnvironmentUsage#entityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCustomEnvironmentUsage.createdBy()",
    "Long ImmutableCustomEnvironmentUsage.customEnvironmentId()",
    "EntityReference ImmutableCustomEnvironmentUsage.entityReference()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    String actualCreatedByResult = immutableCustomEnvironmentUsage.createdBy();
    Long actualCustomEnvironmentIdResult = immutableCustomEnvironmentUsage.customEnvironmentId();

    // Assert
    assertTrue(
        immutableCustomEnvironmentUsage.entityReference() instanceof ImmutableEntityReference);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(1L, actualCustomEnvironmentIdResult.longValue());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#id()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableCustomEnvironmentUsage.id()"})
  void testId() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    Optional<Long> actualIdResult =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
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
   * Test Json {@link Json#customEnvironmentId()}.
   *
   * <p>Method under test: {@link Json#customEnvironmentId()}
   */
  @Test
  @DisplayName("Test Json customEnvironmentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.customEnvironmentId()"})
  void testJsonCustomEnvironmentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().customEnvironmentId());
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
    assertNull(actualJson.customEnvironmentId);
    assertNull(actualJson.createdBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.entityReference);
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
   * Test {@link ImmutableCustomEnvironmentUsage#provenance()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCustomEnvironmentUsage.provenance()"})
  void testProvenance() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertEquals(
        "Provenance",
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#toString()}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCustomEnvironmentUsage.toString()"})
  void testToString() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act and Assert
    assertEquals(
        "CustomEnvironmentUsage{id=1, createdAt=1970-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100,"
            + " provenance=Provenance, customEnvironmentId=1, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}}",
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualWithCreatedAtResult =
        immutableCustomEnvironmentUsage.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableCustomEnvironmentUsage, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withCreatedBy(String)"
  })
  void testWithCreatedBy() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualWithCreatedByResult =
        immutableCustomEnvironmentUsage.withCreatedBy("42");

    // Assert
    assertSame(immutableCustomEnvironmentUsage, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withCreatedBy(String)"
  })
  void testWithCreatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    ImmutableCustomEnvironmentUsage actualWithCreatedByResult =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
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
    assertEquals(1L, actualWithCreatedByResult.customEnvironmentId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withCustomEnvironmentId(Long)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withCustomEnvironmentId(Long)}
   */
  @Test
  @DisplayName("Test withCustomEnvironmentId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withCustomEnvironmentId(Long)"
  })
  void testWithCustomEnvironmentId() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualWithCustomEnvironmentIdResult =
        immutableCustomEnvironmentUsage.withCustomEnvironmentId(1L);

    // Assert
    assertSame(immutableCustomEnvironmentUsage, actualWithCustomEnvironmentIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withCustomEnvironmentId(Long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withCustomEnvironmentId(Long)}
   */
  @Test
  @DisplayName(
      "Test withCustomEnvironmentId(Long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withCustomEnvironmentId(Long)"
  })
  void testWithCustomEnvironmentId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    ImmutableCustomEnvironmentUsage actualWithCustomEnvironmentIdResult =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build()
            .withCustomEnvironmentId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithCustomEnvironmentIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithCustomEnvironmentIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithCustomEnvironmentIdResult.createdBy());
    assertEquals("Provenance", actualWithCustomEnvironmentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithCustomEnvironmentIdResult.customEnvironmentId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableCustomEnvironmentUsage#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualWithEntityReferenceResult =
        immutableCustomEnvironmentUsage.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableCustomEnvironmentUsage, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableCustomEnvironmentUsage actualWithIdResult =
        immutableCustomEnvironmentUsage.withId(optional);

    // Assert
    assertSame(immutableCustomEnvironmentUsage, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withId(Optional)"
  })
  void testWithIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableCustomEnvironmentUsage actualWithIdResult =
        immutableCustomEnvironmentUsage.withId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithIdResult.createdBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithIdResult.customEnvironmentId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualWithIdResult = immutableCustomEnvironmentUsage.withId(1L);

    // Assert
    assertSame(immutableCustomEnvironmentUsage, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withId(long)"
  })
  void testWithIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    ImmutableCustomEnvironmentUsage actualWithIdResult =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithIdResult.createdBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithIdResult.customEnvironmentId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);
    ImmutableCustomEnvironmentUsage immutableCustomEnvironmentUsage =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("42")
            .build();

    // Act
    ImmutableCustomEnvironmentUsage actualWithProvenanceResult =
        immutableCustomEnvironmentUsage.withProvenance("42");

    // Assert
    assertSame(immutableCustomEnvironmentUsage, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableCustomEnvironmentUsage#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCustomEnvironmentUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCustomEnvironmentUsage ImmutableCustomEnvironmentUsage.withProvenance(String)"
  })
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    ImmutableCustomEnvironmentUsage actualWithProvenanceResult =
        customEnvironmentIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .provenance("Provenance")
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
    assertEquals(1L, actualWithProvenanceResult.customEnvironmentId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
