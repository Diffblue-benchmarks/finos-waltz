package org.finos.waltz.model.bookmark;

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
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Builder;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBookmarkDiffblueTest {
  /**
   * Test Builder {@link Builder#bookmarkKind(BookmarkKindValue)}.
   *
   * <ul>
   *   <li>When {@link BookmarkKindValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#bookmarkKind(BookmarkKindValue)}
   */
  @Test
  @DisplayName(
      "Test Builder bookmarkKind(BookmarkKindValue); when BookmarkKindValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.bookmarkKind(BookmarkKindValue)"})
  void testBuilderBookmarkKind_whenBookmarkKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act
    Builder actualBookmarkKindResult = builderResult.bookmarkKind(BookmarkKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualBookmarkKindResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#title(String)}
   *   <li>{@link Builder#url(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBookmark Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)",
    "Builder Builder.title(String)",
    "Builder Builder.url(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");
    Builder actualDescriptionResult =
        actualBuilderResult
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something");
    Optional<String> description = Optional.of("foo");
    Builder actualIdResult = actualDescriptionResult.description(description).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualLastUpdatedByResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01");
    ImmutableEntityReference parent =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualTitleResult =
        actualLastUpdatedByResult.parent(parent).provenance("Provenance").title("Dr");
    Optional<String> title = Optional.of("foo");
    Builder actualUrlResult = actualTitleResult.title(title).url("https://example.org/example");
    Optional<String> url = Optional.of("foo");
    ImmutableBookmark actualImmutableBookmark = actualUrlResult.url(url).build();

    // Assert
    assertEquals("2020-03-01", actualImmutableBookmark.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualImmutableBookmark.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualImmutableBookmark.provenance());
    assertEquals(EntityKind.ALL, actualImmutableBookmark.kind());
    assertFalse(actualImmutableBookmark.isPrimary());
    assertFalse(actualImmutableBookmark.isRequired());
    assertFalse(actualImmutableBookmark.isRestricted());
    assertSame(lastUpdatedAt, actualImmutableBookmark.lastUpdatedAt());
    assertSame(parent, actualImmutableBookmark.parent());
    assertSame(bookmarkKind, bookmarkKindResult);
  }

  /**
   * Test Builder {@link Builder#description(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#description(Optional)}
   */
  @Test
  @DisplayName("Test Builder description(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(Optional)"})
  void testBuilderDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<String> description = Optional.of("foo");

    // Act
    Builder actualDescriptionResult = builderResult.description(description);

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   *
   * <p>Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark instance =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBookmark actualImmutableBookmark = builderResult.build();
    assertEquals(instance, actualImmutableBookmark);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableBookmark.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark instance =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act and Assert
    ImmutableBookmark actualImmutableBookmark =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableBookmark);
    ImmutableBookmark actualImmutableBookmark2 = builderResult.build();
    assertEquals(instance, actualImmutableBookmark2);
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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableBookmark.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark instance =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act and Assert
    ImmutableBookmark actualImmutableBookmark = builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableBookmark);
    ImmutableBookmark actualImmutableBookmark2 = builderResult.build();
    assertEquals(instance, actualImmutableBookmark2);
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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark instance =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act and Assert
    ImmutableBookmark actualImmutableBookmark =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableBookmark);
    ImmutableBookmark actualImmutableBookmark2 = builderResult.build();
    assertEquals(instance, actualImmutableBookmark2);
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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark instance =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act and Assert
    ImmutableBookmark actualImmutableBookmark =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableBookmark);
    ImmutableBookmark actualImmutableBookmark2 = builderResult.build();
    assertEquals(instance, actualImmutableBookmark2);
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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();

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
    Builder builderResult = ImmutableBookmark.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isPrimary(boolean)}.
   *
   * <p>Method under test: {@link Builder#isPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Builder isPrimary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isPrimary(boolean)"})
  void testBuilderIsPrimary() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act
    Builder actualIsPrimaryResult = builderResult.isPrimary(true);

    // Assert
    assertSame(builderResult, actualIsPrimaryResult);
  }

  /**
   * Test Builder {@link Builder#isRequired(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRequired(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRequired(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRequired(boolean)"})
  void testBuilderIsRequired() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act
    Builder actualIsRequiredResult = builderResult.isRequired(true);

    // Assert
    assertSame(builderResult, actualIsRequiredResult);
  }

  /**
   * Test Builder {@link Builder#isRestricted(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRestricted(boolean)"})
  void testBuilderIsRestricted() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act
    Builder actualIsRestrictedResult = builderResult.isRestricted(true);

    // Assert
    assertSame(builderResult, actualIsRestrictedResult);
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
    Builder builderResult = ImmutableBookmark.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#parent(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parent(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parent(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parent(EntityReference)"})
  void testBuilderParent_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act
    Builder actualParentResult = builderResult.parent(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualParentResult);
  }

  /**
   * Test Builder {@link Builder#title(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#title(Optional)}
   */
  @Test
  @DisplayName("Test Builder title(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(Optional)"})
  void testBuilderTitleWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<String> title = Optional.of("foo");

    // Act
    Builder actualTitleResult = builderResult.title(title);

    // Assert
    assertSame(builderResult, actualTitleResult);
  }

  /**
   * Test Builder {@link Builder#url(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#url(Optional)}
   */
  @Test
  @DisplayName("Test Builder url(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.url(Optional)"})
  void testBuilderUrlWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<String> url = Optional.of("foo");

    // Act
    Builder actualUrlResult = builderResult.url(url);

    // Assert
    assertSame(builderResult, actualUrlResult);
  }

  /**
   * Test {@link ImmutableBookmark#copyOf(Bookmark)}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  @DisplayName("Test copyOf(Bookmark); then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.copyOf(Bookmark)"})
  void testCopyOf_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark instance =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

    // Assert
    EntityReference parentResult = actualCopyOfResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isPrimary());
    assertFalse(actualCopyOfResult.isRequired());
    assertFalse(actualCopyOfResult.isRestricted());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
    assertSame(bookmarkKind, bookmarkKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#description()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#description()}
   */
  @Test
  @DisplayName("Test description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableBookmark.description()"})
  void testDescription() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    Optional<String> actualDescriptionResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .description();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescriptionResult.get());
    assertTrue(actualDescriptionResult.isPresent());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}, and {@link ImmutableBookmark#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBookmark#equals(Object)}
   *   <li>{@link ImmutableBookmark#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark2 =
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(immutableBookmark, immutableBookmark2);
    assertEquals(immutableBookmark.hashCode(), immutableBookmark2.hashCode());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}, and {@link ImmutableBookmark#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBookmark#equals(Object)}
   *   <li>{@link ImmutableBookmark#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(immutableBookmark, immutableBookmark);
    int expectedHashCodeResult = immutableBookmark.hashCode();
    assertEquals(expectedHashCodeResult, immutableBookmark.hashCode());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("2020-03-01"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("2020-03-01")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("2020-03-01")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Mr")
            .url("https://example.org/example")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("2020-03-01")
            .build();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableBookmark,
        lastUpdatedByResult2
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build());
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBookmark#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBookmark.equals(Object)",
    "int ImmutableBookmark.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build(),
        "Different type to ImmutableBookmark");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBookmark#bookmarkKind()}
   *   <li>{@link ImmutableBookmark#lastUpdatedBy()}
   *   <li>{@link ImmutableBookmark#parent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BookmarkKindValue ImmutableBookmark.bookmarkKind()",
    "String ImmutableBookmark.lastUpdatedBy()",
    "EntityReference ImmutableBookmark.parent()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    BookmarkKindValue actualBookmarkKindResult = immutableBookmark.bookmarkKind();
    String actualLastUpdatedByResult = immutableBookmark.lastUpdatedBy();

    // Assert
    assertTrue(immutableBookmark.parent() instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("42", actualBookmarkKindResult.value());
    assertSame(bookmarkKind, actualBookmarkKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#id()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableBookmark.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    Optional<Long> actualIdResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableBookmark#isPrimary()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#isPrimary()}
   */
  @Test
  @DisplayName("Test isPrimary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableBookmark.isPrimary()"})
  void testIsPrimary() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertFalse(
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .isPrimary());
  }

  /**
   * Test {@link ImmutableBookmark#isRequired()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#isRequired()}
   */
  @Test
  @DisplayName("Test isRequired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableBookmark.isRequired()"})
  void testIsRequired() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertFalse(
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .isRequired());
  }

  /**
   * Test {@link ImmutableBookmark#isRestricted()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#isRestricted()}
   */
  @Test
  @DisplayName("Test isRestricted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableBookmark.isRestricted()"})
  void testIsRestricted() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertFalse(
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .isRestricted());
  }

  /**
   * Test Json {@link Json#bookmarkKind()}.
   *
   * <p>Method under test: {@link Json#bookmarkKind()}
   */
  @Test
  @DisplayName("Test Json bookmarkKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BookmarkKindValue Json.bookmarkKind()"})
  void testJsonBookmarkKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().bookmarkKind());
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
  @MethodsUnderTest({"Optional Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
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
   * Test Json {@link Json#isPrimary()}.
   *
   * <p>Method under test: {@link Json#isPrimary()}
   */
  @Test
  @DisplayName("Test Json isPrimary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isPrimary()"})
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isPrimary());
  }

  /**
   * Test Json {@link Json#isRequired()}.
   *
   * <p>Method under test: {@link Json#isRequired()}
   */
  @Test
  @DisplayName("Test Json isRequired()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRequired()"})
  void testJsonIsRequired() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRequired());
  }

  /**
   * Test Json {@link Json#isRestricted()}.
   *
   * <p>Method under test: {@link Json#isRestricted()}
   */
  @Test
  @DisplayName("Test Json isRestricted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRestricted()"})
  void testJsonIsRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRestricted());
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
    assertNull(actualJson.kind);
    assertNull(actualJson.parent);
    assertNull(actualJson.bookmarkKind);
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.title.isPresent());
    assertFalse(actualJson.url.isPresent());
    assertFalse(actualJson.isPrimary);
    assertFalse(actualJson.isPrimaryIsSet);
    assertFalse(actualJson.isRequired);
    assertFalse(actualJson.isRequiredIsSet);
    assertFalse(actualJson.isRestricted);
    assertFalse(actualJson.isRestrictedIsSet);
  }

  /**
   * Test Json {@link Json#parent()}.
   *
   * <p>Method under test: {@link Json#parent()}
   */
  @Test
  @DisplayName("Test Json parent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parent()"})
  void testJsonParent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parent());
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
   * Test Json {@link Json#setIsPrimary(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsPrimary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsPrimary(boolean)"})
  void testJsonSetIsPrimary() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Test Json {@link Json#setIsRequired(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRequired(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRequired(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRequired(boolean)"})
  void testJsonSetIsRequired() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRequired(true);

    // Assert
    assertTrue(json.isRequired);
    assertTrue(json.isRequiredIsSet);
  }

  /**
   * Test Json {@link Json#setIsRestricted(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRestricted(boolean)"})
  void testJsonSetIsRestricted() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRestricted(true);

    // Assert
    assertTrue(json.isRestricted);
    assertTrue(json.isRestrictedIsSet);
  }

  /**
   * Test Json {@link Json#title()}.
   *
   * <p>Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().title());
  }

  /**
   * Test Json {@link Json#url()}.
   *
   * <p>Method under test: {@link Json#url()}
   */
  @Test
  @DisplayName("Test Json url()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.url()"})
  void testJsonUrl() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().url());
  }

  /**
   * Test {@link ImmutableBookmark#kind()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableBookmark.kind()"})
  void testKind() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableBookmark#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableBookmark.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableBookmark#provenance()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableBookmark.provenance()"})
  void testProvenance() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(
        "Provenance",
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableBookmark#title()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#title()}
   */
  @Test
  @DisplayName("Test title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableBookmark.title()"})
  void testTitle() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    Optional<String> actualTitleResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .title();

    // Assert
    assertEquals("Dr", actualTitleResult.get());
    assertTrue(actualTitleResult.isPresent());
  }

  /**
   * Test {@link ImmutableBookmark#toString()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableBookmark.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(
        "Bookmark{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, id=1, parent=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, bookmarkKind=42, title=Dr, url=https://example.org/example,"
            + " description=The characteristics of someone or something, kind=ALL, provenance=Provenance, isPrimary=false,"
            + " isRequired=false, isRestricted=false}",
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableBookmark#url()}.
   *
   * <p>Method under test: {@link ImmutableBookmark#url()}
   */
  @Test
  @DisplayName("Test url()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableBookmark.url()"})
  void testUrl() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    Optional<String> actualUrlResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .url();

    // Assert
    assertEquals("https://example.org/example", actualUrlResult.get());
    assertTrue(actualUrlResult.isPresent());
  }

  /**
   * Test {@link ImmutableBookmark#withBookmarkKind(BookmarkKindValue)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withBookmarkKind(BookmarkKindValue)}
   */
  @Test
  @DisplayName("Test withBookmarkKind(BookmarkKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withBookmarkKind(BookmarkKindValue)"})
  void testWithBookmarkKind() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithBookmarkKindResult =
        immutableBookmark.withBookmarkKind(BookmarkKindValue.of("42"));

    // Assert
    assertEquals(immutableBookmark, actualWithBookmarkKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#withDescription(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withDescription(Optional)}
   */
  @Test
  @DisplayName("Test withDescription(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withDescription(Optional)"})
  void testWithDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableBookmark actualWithDescriptionResult = immutableBookmark.withDescription(optional);

    // Assert
    EntityReference parentResult = actualWithDescriptionResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithDescriptionResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualWithDescriptionResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualWithDescriptionResult.provenance());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityKind.ALL, actualWithDescriptionResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertFalse(actualWithDescriptionResult.isPrimary());
    assertFalse(actualWithDescriptionResult.isRequired());
    assertFalse(actualWithDescriptionResult.isRestricted());
    assertSame(ofResult, actualWithDescriptionResult.lastUpdatedAt().toLocalDate());
    assertSame(bookmarkKind, bookmarkKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#withDescription(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withDescription(String)"})
  void testWithDescriptionWithValue() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithDescriptionResult = immutableBookmark.withDescription("42");

    // Assert
    assertSame(immutableBookmark, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableBookmark#withDescription(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String) with 'value'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withDescription(String)"})
  void testWithDescriptionWithValue_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithDescriptionResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withDescription("42");

    // Assert
    EntityReference parentResult = actualWithDescriptionResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDescriptionResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithDescriptionResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableBookmark actualWithIdResult = immutableBookmark.withId(optional);

    // Assert
    assertSame(immutableBookmark, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableBookmark#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withId(Optional)"})
  void testWithIdWithOptional_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableBookmark actualWithIdResult = immutableBookmark.withId(optional);

    // Assert
    EntityReference parentResult = actualWithIdResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIdResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithIdResult = immutableBookmark.withId(1L);

    // Assert
    assertSame(immutableBookmark, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableBookmark#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithIdResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withId(42L);

    // Assert
    EntityReference parentResult = actualWithIdResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIdResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withIsPrimary(boolean)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test withIsPrimary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withIsPrimary(boolean)"})
  void testWithIsPrimary() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithIsPrimaryResult = immutableBookmark.withIsPrimary(false);

    // Assert
    assertSame(immutableBookmark, actualWithIsPrimaryResult);
  }

  /**
   * Test {@link ImmutableBookmark#withIsPrimary(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withIsPrimary(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsPrimary(boolean); when 'true'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withIsPrimary(boolean)"})
  void testWithIsPrimary_whenTrue_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithIsPrimaryResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withIsPrimary(true);

    // Assert
    EntityReference parentResult = actualWithIsPrimaryResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIsPrimaryResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertTrue(actualWithIsPrimaryResult.isPrimary());
    assertSame(ofResult, actualWithIsPrimaryResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withIsRequired(boolean)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withIsRequired(boolean)}
   */
  @Test
  @DisplayName("Test withIsRequired(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withIsRequired(boolean)"})
  void testWithIsRequired() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithIsRequiredResult = immutableBookmark.withIsRequired(false);

    // Assert
    assertSame(immutableBookmark, actualWithIsRequiredResult);
  }

  /**
   * Test {@link ImmutableBookmark#withIsRequired(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withIsRequired(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsRequired(boolean); when 'true'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withIsRequired(boolean)"})
  void testWithIsRequired_whenTrue_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithIsRequiredResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withIsRequired(true);

    // Assert
    EntityReference parentResult = actualWithIsRequiredResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIsRequiredResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertTrue(actualWithIsRequiredResult.isRequired());
    assertSame(ofResult, actualWithIsRequiredResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withIsRestricted(boolean)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test withIsRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withIsRestricted(boolean)"})
  void testWithIsRestricted() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithIsRestrictedResult = immutableBookmark.withIsRestricted(false);

    // Assert
    assertSame(immutableBookmark, actualWithIsRestrictedResult);
  }

  /**
   * Test {@link ImmutableBookmark#withIsRestricted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withIsRestricted(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsRestricted(boolean); when 'true'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withIsRestricted(boolean)"})
  void testWithIsRestricted_whenTrue_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithIsRestrictedResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withIsRestricted(true);

    // Assert
    EntityReference parentResult = actualWithIsRestrictedResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIsRestrictedResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertTrue(actualWithIsRestrictedResult.isRestricted());
    assertSame(ofResult, actualWithIsRestrictedResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithKindResult = immutableBookmark.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableBookmark, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withKind(EntityKind)"})
  void testWithKind_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithKindResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    EntityReference parentResult = actualWithKindResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithKindResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithLastUpdatedAtResult =
        immutableBookmark.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableBookmark, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableBookmark#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithLastUpdatedByResult = immutableBookmark.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableBookmark, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableBookmark#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithLastUpdatedByResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference parentResult = actualWithLastUpdatedByResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withParent(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withParent(EntityReference)}
   */
  @Test
  @DisplayName("Test withParent(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withParent(EntityReference)"})
  void testWithParent() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithParentResult =
        immutableBookmark.withParent(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBookmark, actualWithParentResult);
  }

  /**
   * Test {@link ImmutableBookmark#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("42")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithProvenanceResult = immutableBookmark.withProvenance("42");

    // Assert
    assertSame(immutableBookmark, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableBookmark#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withProvenance(String)"})
  void testWithProvenance_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithProvenanceResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference parentResult = actualWithProvenanceResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithProvenanceResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withTitle(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withTitle(Optional)}
   */
  @Test
  @DisplayName("Test withTitle(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withTitle(Optional)"})
  void testWithTitleWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableBookmark actualWithTitleResult = immutableBookmark.withTitle(optional);

    // Assert
    EntityReference parentResult = actualWithTitleResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithTitleResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualWithTitleResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualWithTitleResult.provenance());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityKind.ALL, actualWithTitleResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertFalse(actualWithTitleResult.isPrimary());
    assertFalse(actualWithTitleResult.isRequired());
    assertFalse(actualWithTitleResult.isRestricted());
    assertSame(ofResult, actualWithTitleResult.lastUpdatedAt().toLocalDate());
    assertSame(bookmarkKind, bookmarkKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#withTitle(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withTitle(String)"})
  void testWithTitleWithValue() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("42")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithTitleResult = immutableBookmark.withTitle("42");

    // Assert
    assertSame(immutableBookmark, actualWithTitleResult);
  }

  /**
   * Test {@link ImmutableBookmark#withTitle(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String) with 'value'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withTitle(String)"})
  void testWithTitleWithValue_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithTitleResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build()
            .withTitle("42");

    // Assert
    EntityReference parentResult = actualWithTitleResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithTitleResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithTitleResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableBookmark#withUrl(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withUrl(Optional)}
   */
  @Test
  @DisplayName("Test withUrl(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withUrl(Optional)"})
  void testWithUrlWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableBookmark actualWithUrlResult = immutableBookmark.withUrl(optional);

    // Assert
    EntityReference parentResult = actualWithUrlResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithUrlResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualWithUrlResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualWithUrlResult.provenance());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityKind.ALL, actualWithUrlResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertFalse(actualWithUrlResult.isPrimary());
    assertFalse(actualWithUrlResult.isRequired());
    assertFalse(actualWithUrlResult.isRestricted());
    assertSame(ofResult, actualWithUrlResult.lastUpdatedAt().toLocalDate());
    assertSame(bookmarkKind, bookmarkKindResult);
  }

  /**
   * Test {@link ImmutableBookmark#withUrl(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableBookmark#withUrl(String)}
   */
  @Test
  @DisplayName("Test withUrl(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withUrl(String)"})
  void testWithUrlWithValue() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark immutableBookmark =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("https://example.org/example")
            .build();

    // Act
    ImmutableBookmark actualWithUrlResult =
        immutableBookmark.withUrl("https://example.org/example");

    // Assert
    assertSame(immutableBookmark, actualWithUrlResult);
  }

  /**
   * Test {@link ImmutableBookmark#withUrl(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBookmark#withUrl(String)}
   */
  @Test
  @DisplayName("Test withUrl(String) with 'value'; then parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBookmark ImmutableBookmark.withUrl(String)"})
  void testWithUrlWithValue_thenParentReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableBookmark actualWithUrlResult =
        lastUpdatedByResult
            .parent(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .title("Dr")
            .url("url")
            .build()
            .withUrl("https://example.org/example");

    // Assert
    EntityReference parentResult = actualWithUrlResult.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithUrlResult.bookmarkKind().value());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertSame(ofResult, actualWithUrlResult.lastUpdatedAt().toLocalDate());
  }
}
