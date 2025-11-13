package org.finos.waltz.model.thumbnail;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail.Builder;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableThumbnailDiffblueTest {
  /**
   * Test {@link ImmutableThumbnail#blob()}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#blob()}
   */
  @Test
  @DisplayName("Test blob()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ImmutableThumbnail.blob()"})
  void testBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .blob());
  }

  /**
   * Test Builder {@link Builder#blob(byte[])}.
   *
   * <p>Method under test: {@link Builder#blob(byte[])}
   */
  @Test
  @DisplayName("Test Builder blob(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.blob(byte[])"})
  void testBuilderBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    // Act
    Builder actualBlobResult = builderResult.blob("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertSame(builderResult, actualBlobResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
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
    "ImmutableThumbnail Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() throws UnsupportedEncodingException {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableThumbnail.builder().blob("AXAXAXAX".getBytes("UTF-8")).externalId("42");
    Optional<String> externalId = Optional.of("42");
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualMimeTypeResult =
        actualExternalIdResult
            .externalId(externalId)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableEntityReference parentEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableThumbnail actualImmutableThumbnail =
        actualMimeTypeResult
            .parentEntityReference(parentEntityReference)
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableThumbnail.lastUpdatedBy());
    assertEquals("Provenance", actualImmutableThumbnail.provenance());
    assertEquals("text/plain", actualImmutableThumbnail.mimeType());
    assertSame(lastUpdatedAt, actualImmutableThumbnail.lastUpdatedAt());
    assertSame(parentEntityReference, actualImmutableThumbnail.parentEntityReference());
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
    Builder builderResult = ImmutableThumbnail.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
  void testBuilderFromWithExternalIdProvider() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableThumbnail actualImmutableThumbnail =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableThumbnail);
    ImmutableThumbnail actualImmutableThumbnail2 = builderResult.build();
    assertEquals(instance, actualImmutableThumbnail2);
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
    Builder builderResult = ImmutableThumbnail.builder();

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
    Builder builderResult = ImmutableThumbnail.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
  void testBuilderFromWithLastUpdatedProvider() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableThumbnail actualImmutableThumbnail =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableThumbnail);
    ImmutableThumbnail actualImmutableThumbnail2 = builderResult.build();
    assertEquals(instance, actualImmutableThumbnail2);
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
    Builder builderResult = ImmutableThumbnail.builder();

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
    Builder builderResult = ImmutableThumbnail.builder();

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
    Builder builderResult = ImmutableThumbnail.builder();

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
    Builder builderResult = ImmutableThumbnail.builder();

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
  void testBuilderFromWithProvenanceProvider2() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableThumbnail actualImmutableThumbnail =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableThumbnail);
    ImmutableThumbnail actualImmutableThumbnail2 = builderResult.build();
    assertEquals(instance, actualImmutableThumbnail2);
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
    Builder builderResult = ImmutableThumbnail.builder();

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
   * Test Builder {@link Builder#from(Thumbnail)} with {@code Thumbnail}.
   *
   * <p>Method under test: {@link Builder#from(Thumbnail)}
   */
  @Test
  @DisplayName("Test Builder from(Thumbnail) with 'Thumbnail'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Thumbnail)"})
  void testBuilderFromWithThumbnail() throws UnsupportedEncodingException {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableThumbnail actualImmutableThumbnail = builderResult.build();
    assertEquals(instance, actualImmutableThumbnail);
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
    Builder builderResult = ImmutableThumbnail.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#mimeType(String)}.
   *
   * <ul>
   *   <li>When {@code text/plain}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#mimeType(String)}
   */
  @Test
  @DisplayName("Test Builder mimeType(String); when 'text/plain'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.mimeType(String)"})
  void testBuilderMimeType_whenTextPlain_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    // Act
    Builder actualMimeTypeResult = builderResult.mimeType("text/plain");

    // Assert
    assertSame(builderResult, actualMimeTypeResult);
  }

  /**
   * Test Builder {@link Builder#parentEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntityReference(EntityReference)"})
  void testBuilderParentEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableThumbnail.builder();

    // Act
    Builder actualParentEntityReferenceResult =
        builderResult.parentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualParentEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableThumbnail#copyOf(Thumbnail)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#copyOf(Thumbnail)}
   */
  @Test
  @DisplayName("Test copyOf(Thumbnail); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.copyOf(Thumbnail)"})
  void testCopyOf_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail instance =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualCopyOfResult = ImmutableThumbnail.copyOf(instance);

    // Assert
    EntityReference parentEntityReferenceResult = actualCopyOfResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualCopyOfResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}, and {@link ImmutableThumbnail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableThumbnail#equals(Object)}
   *   <li>{@link ImmutableThumbnail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail2 =
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableThumbnail, immutableThumbnail2);
    assertEquals(immutableThumbnail.hashCode(), immutableThumbnail2.hashCode());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}, and {@link ImmutableThumbnail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableThumbnail#equals(Object)}
   *   <li>{@link ImmutableThumbnail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableThumbnail, immutableThumbnail);
    int expectedHashCodeResult = immutableThumbnail.hashCode();
    assertEquals(expectedHashCodeResult, immutableThumbnail.hashCode());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob(
                (byte) 1,
                (byte) 'X',
                (byte) 'A',
                (byte) 'X',
                (byte) 'A',
                (byte) 'X',
                (byte) 'A',
                (byte) 'X')
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("2020-03-01")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/html");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("2020-03-01")
            .build();

    Builder mimeTypeResult2 =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        immutableThumbnail,
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableThumbnail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableThumbnail.equals(Object)",
    "int ImmutableThumbnail.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertNotEquals(
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableThumbnail");
  }

  /**
   * Test {@link ImmutableThumbnail#externalId()}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableThumbnail.externalId()"})
  void testExternalId() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    Optional<String> actualExternalIdResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableThumbnail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code 42}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) ExternalId is of '42'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.fromJson(Json)"})
  void testFromJson_givenOf42_whenJsonExternalIdIsOf42_thenReturnProvenanceIsJson()
      throws UnsupportedEncodingException {
    // Arrange
    Json json = new Json();
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("Json", actualFromJsonResult.provenance());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableThumbnail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) LastUpdatedAt is {@code null}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) LastUpdatedAt is 'null'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.fromJson(Json)"})
  void testFromJson_givenOf42_whenJsonLastUpdatedAtIsNull_thenReturnProvenanceIsJson()
      throws UnsupportedEncodingException {
    // Arrange
    Json json = new Json();
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("Json", actualFromJsonResult.provenance());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableThumbnail#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.fromJson(Json)"})
  void testFromJson_givenOf42_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz()
      throws UnsupportedEncodingException {
    // Arrange
    Json json = new Json();
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance(null);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("waltz", actualFromJsonResult.provenance());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableThumbnail#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExternalId is 'null'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.fromJson(Json)"})
  void testFromJson_whenJsonExternalIdIsNull_thenReturnProvenanceIsJson()
      throws UnsupportedEncodingException {
    // Arrange
    Json json = new Json();
    json.setExternalId(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setProvenance("Json");
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setMimeType("Json");
    json.setBlob("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImmutableThumbnail actualFromJsonResult = ImmutableThumbnail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("Json", actualFromJsonResult.mimeType());
    assertEquals("Json", actualFromJsonResult.provenance());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableThumbnail#lastUpdatedBy()}
   *   <li>{@link ImmutableThumbnail#mimeType()}
   *   <li>{@link ImmutableThumbnail#parentEntityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableThumbnail.lastUpdatedBy()",
    "String ImmutableThumbnail.mimeType()",
    "EntityReference ImmutableThumbnail.parentEntityReference()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    String actualLastUpdatedByResult = immutableThumbnail.lastUpdatedBy();
    String actualMimeTypeResult = immutableThumbnail.mimeType();

    // Assert
    assertTrue(immutableThumbnail.parentEntityReference() instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("text/plain", actualMimeTypeResult);
  }

  /**
   * Test Json {@link Json#blob()}.
   *
   * <p>Method under test: {@link Json#blob()}
   */
  @Test
  @DisplayName("Test Json blob()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Json.blob()"})
  void testJsonBlob() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().blob());
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
   * Test Json {@link Json#mimeType()}.
   *
   * <p>Method under test: {@link Json#mimeType()}
   */
  @Test
  @DisplayName("Test Json mimeType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.mimeType()"})
  void testJsonMimeType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().mimeType());
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
    assertNull(actualJson.blob);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.mimeType);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.parentEntityReference);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Test Json {@link Json#parentEntityReference()}.
   *
   * <p>Method under test: {@link Json#parentEntityReference()}
   */
  @Test
  @DisplayName("Test Json parentEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parentEntityReference()"})
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentEntityReference());
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
   * Test {@link ImmutableThumbnail#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableThumbnail.lastUpdatedAt()"})
  void testLastUpdatedAt() throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnail#provenance()}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableThumbnail.provenance()"})
  void testProvenance() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertEquals(
        "Provenance",
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableThumbnail#toString()}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableThumbnail.toString()"})
  void testToString() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act and Assert
    assertEquals(
        "Thumbnail{externalId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " parentEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, mimeType=text/plain,"
            + " blob=[65, 88, 65, 88, 65, 88, 65, 88]}",
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableThumbnail#withBlob(byte[])}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withBlob(byte[])}
   */
  @Test
  @DisplayName("Test withBlob(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withBlob(byte[])"})
  void testWithBlob() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualWithBlobResult =
        immutableThumbnail.withBlob(
            (byte) 'A',
            (byte) 'X',
            (byte) 'A',
            (byte) 'X',
            (byte) 'A',
            (byte) 'X',
            (byte) 'A',
            (byte) 'X');

    // Assert
    assertEquals(immutableThumbnail, actualWithBlobResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableThumbnail actualWithExternalIdResult = immutableThumbnail.withExternalId(optional);

    // Assert
    assertSame(immutableThumbnail, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withExternalId(Optional)"})
  void testWithExternalIdWithOptional2() throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("External Id")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableThumbnail actualWithExternalIdResult = immutableThumbnail.withExternalId(optional);

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithExternalIdResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualWithExternalIdResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withExternalId(String)"})
  void testWithExternalIdWithValue() throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    ImmutableThumbnail actualWithExternalIdResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithExternalIdResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualWithExternalIdResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withExternalId(String)"})
  void testWithExternalIdWithValue2() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualWithExternalIdResult = immutableThumbnail.withExternalId("42");

    // Assert
    assertSame(immutableThumbnail, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualWithLastUpdatedAtResult =
        immutableThumbnail.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableThumbnail, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualWithLastUpdatedByResult = immutableThumbnail.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableThumbnail, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    ImmutableThumbnail actualWithLastUpdatedByResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithLastUpdatedByResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualWithLastUpdatedByResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withMimeType(String)}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withMimeType(String)}
   */
  @Test
  @DisplayName("Test withMimeType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withMimeType(String)"})
  void testWithMimeType() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("42");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualWithMimeTypeResult = immutableThumbnail.withMimeType("42");

    // Assert
    assertSame(immutableThumbnail, actualWithMimeTypeResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withMimeType(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#withMimeType(String)}
   */
  @Test
  @DisplayName(
      "Test withMimeType(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withMimeType(String)"})
  void testWithMimeType_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    ImmutableThumbnail actualWithMimeTypeResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .withMimeType("42");

    // Assert
    EntityReference parentEntityReferenceResult = actualWithMimeTypeResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithMimeTypeResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithMimeTypeResult.lastUpdatedBy());
    assertEquals("42", actualWithMimeTypeResult.mimeType());
    assertEquals("Provenance", actualWithMimeTypeResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withParentEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withParentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableThumbnail ImmutableThumbnail.withParentEntityReference(EntityReference)"
  })
  void testWithParentEntityReference() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableThumbnail actualWithParentEntityReferenceResult =
        immutableThumbnail.withParentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableThumbnail, actualWithParentEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableThumbnail#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withProvenance(String)"})
  void testWithProvenance() throws UnsupportedEncodingException {
    // Arrange
    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    ImmutableThumbnail immutableThumbnail =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("42")
            .build();

    // Act
    ImmutableThumbnail actualWithProvenanceResult = immutableThumbnail.withProvenance("42");

    // Assert
    assertSame(immutableThumbnail, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableThumbnail#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableThumbnail#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableThumbnail ImmutableThumbnail.withProvenance(String)"})
  void testWithProvenance_thenParentEntityReferenceReturnImmutableEntityReference()
      throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    ImmutableThumbnail actualWithProvenanceResult =
        mimeTypeResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference parentEntityReferenceResult =
        actualWithProvenanceResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualWithProvenanceResult.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
