package org.finos.waltz.model.bookmark;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Builder;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBookmarkDiffblueTest {
  /**
   * Test {@link ImmutableBookmark#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBookmark#builder()}
   *   <li>{@link ImmutableBookmark#description(String)}
   *   <li>{@link ImmutableBookmark#kind(EntityKind)}
   *   <li>{@link ImmutableBookmark#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableBookmark#provenance(String)}
   *   <li>{@link ImmutableBookmark#title(String)}
   *   <li>{@link ImmutableBookmark#url(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBookmark Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.kind(EntityKind)", "Builder Builder.lastUpdatedAt(LocalDateTime)",
      "Builder Builder.provenance(String)", "Builder Builder.title(String)", "Builder Builder.url(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDescriptionResult = ImmutableBookmark.builder()
        .description("The characteristics of someone or something");
    Optional<String> description = Optional.of("foo");
    Builder actualIdResult = actualDescriptionResult.description(description).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    Builder actualTitleResult = actualKindResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance")
        .title("Dr");
    Optional<String> title = Optional.of("foo");
    Builder actualUrlResult = actualTitleResult.title(title).url("https://example.org/example");
    Optional<String> url = Optional.of("https://example.org/example");

    // Assert
    assertSame(actualUrlResult, actualUrlResult.url(url));
  }

  /**
   * Test Builder {@link Builder#bookmarkKind(BookmarkKindValue)}.
   * <ul>
   *   <li>When {@link BookmarkKindValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#bookmarkKind(BookmarkKindValue)}
   */
  @Test
  @DisplayName("Test Builder bookmarkKind(BookmarkKindValue); when BookmarkKindValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.bookmarkKind(BookmarkKindValue)"})
  void testBuilderBookmarkKind_whenBookmarkKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.bookmarkKind(BookmarkKindValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#description(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#description(Optional)}
   */
  @Test
  @DisplayName("Test Builder description(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(Optional)"})
  void testBuilderDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<String> description = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.description(description));
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Bookmark} {@link Bookmark#description()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'; given empty; when Bookmark description() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark_givenEmpty_whenBookmarkDescriptionReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.isRestricted()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.description()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("https://example.org/example");
    when(instance.url()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).bookmarkKind();
    verify(instance).description();
    verify(instance).id();
    verify(instance).isPrimary();
    verify(instance).isRequired();
    verify(instance).isRestricted();
    verify(instance).kind();
    verify(instance).parent();
    verify(instance).provenance();
    verify(instance).title();
    verify(instance).url();
    ImmutableBookmark buildResult = builderResult.build();
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRestricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Bookmark} {@link Bookmark#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'; given empty; when Bookmark id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark_givenEmpty_whenBookmarkIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.isRestricted()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("https://example.org/example");
    when(instance.url()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).bookmarkKind();
    verify(instance).description();
    verify(instance).id();
    verify(instance).isPrimary();
    verify(instance).isRequired();
    verify(instance).isRestricted();
    verify(instance).kind();
    verify(instance).parent();
    verify(instance).provenance();
    verify(instance).title();
    verify(instance).url();
    ImmutableBookmark buildResult = builderResult.build();
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRestricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Bookmark} {@link Bookmark#title()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'; given empty; when Bookmark title() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark_givenEmpty_whenBookmarkTitleReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.isRestricted()).thenReturn(true);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.title()).thenReturn(emptyResult);
    Optional<String> ofResult3 = Optional.of("https://example.org/example");
    when(instance.url()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).bookmarkKind();
    verify(instance).description();
    verify(instance).id();
    verify(instance).isPrimary();
    verify(instance).isRequired();
    verify(instance).isRestricted();
    verify(instance).kind();
    verify(instance).parent();
    verify(instance).provenance();
    verify(instance).title();
    verify(instance).url();
    ImmutableBookmark buildResult = builderResult.build();
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRestricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Bookmark} {@link Bookmark#url()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'; given empty; when Bookmark url() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark_givenEmpty_whenBookmarkUrlReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.isRestricted()).thenReturn(true);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult3);
    Optional<String> emptyResult = Optional.empty();
    when(instance.url()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).bookmarkKind();
    verify(instance).description();
    verify(instance).id();
    verify(instance).isPrimary();
    verify(instance).isRequired();
    verify(instance).isRestricted();
    verify(instance).kind();
    verify(instance).parent();
    verify(instance).provenance();
    verify(instance).title();
    verify(instance).url();
    ImmutableBookmark buildResult = builderResult.build();
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRestricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then builder build Primary.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'; given Optional with one; then builder build Primary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark_givenOptionalWithOne_thenBuilderBuildPrimary() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(true);
    when(instance.isRestricted()).thenReturn(true);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("https://example.org/example");
    when(instance.url()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).bookmarkKind();
    verify(instance).description();
    verify(instance).id();
    verify(instance).isPrimary();
    verify(instance).isRequired();
    verify(instance).isRestricted();
    verify(instance).kind();
    verify(instance).parent();
    verify(instance).provenance();
    verify(instance).title();
    verify(instance).url();
    ImmutableBookmark buildResult = builderResult.build();
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRestricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Bookmark)} with {@code Bookmark}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder from(Bookmark) with 'Bookmark'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Bookmark)"})
  void testBuilderFromWithBookmark_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    when(instance.parent()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
    verify(instance).parent();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isPrimary(boolean)}.
   * <p>
   * Method under test: {@link Builder#isPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Builder isPrimary(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isPrimary(boolean)"})
  void testBuilderIsPrimary() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isPrimary(true));
  }

  /**
   * Test Builder {@link Builder#isRequired(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRequired(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRequired(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRequired(boolean)"})
  void testBuilderIsRequired() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRequired(true));
  }

  /**
   * Test Builder {@link Builder#isRestricted(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRestricted(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRestricted(boolean)"})
  void testBuilderIsRestricted() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRestricted(true));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#parent(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#parent(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parent(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parent(EntityReference)"})
  void testBuilderParent_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parent(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#title(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#title(Optional)}
   */
  @Test
  @DisplayName("Test Builder title(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.title(Optional)"})
  void testBuilderTitleWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<String> title = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.title(title));
  }

  /**
   * Test Builder {@link Builder#url(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#url(Optional)}
   */
  @Test
  @DisplayName("Test Builder url(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.url(Optional)"})
  void testBuilderUrlWithOptional() {
    // Arrange
    Builder builderResult = ImmutableBookmark.builder();
    Optional<String> url = Optional.of("https://example.org/example");

    // Act and Assert
    assertSame(builderResult, builderResult.url(url));
  }

  /**
   * Test Json {@link Json#bookmarkKind()}.
   * <p>
   * Method under test: {@link Json#bookmarkKind()}
   */
  @Test
  @DisplayName("Test Json bookmarkKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BookmarkKindValue Json.bookmarkKind()"})
  void testJsonBookmarkKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).bookmarkKind());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isPrimary()}.
   * <p>
   * Method under test: {@link Json#isPrimary()}
   */
  @Test
  @DisplayName("Test Json isPrimary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isPrimary()"})
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isPrimary());
  }

  /**
   * Test Json {@link Json#isRequired()}.
   * <p>
   * Method under test: {@link Json#isRequired()}
   */
  @Test
  @DisplayName("Test Json isRequired()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRequired()"})
  void testJsonIsRequired() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRequired());
  }

  /**
   * Test Json {@link Json#isRestricted()}.
   * <p>
   * Method under test: {@link Json#isRestricted()}
   */
  @Test
  @DisplayName("Test Json isRestricted()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRestricted()"})
  void testJsonIsRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRestricted());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#parent()}
   */
  @Test
  @DisplayName("Test Json parent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.parent()"})
  void testJsonParent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parent());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#setIsPrimary(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsPrimary(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsPrimary(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setIsRequired(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRequired(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRestricted(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).title());
  }

  /**
   * Test Json {@link Json#url()}.
   * <p>
   * Method under test: {@link Json#url()}
   */
  @Test
  @DisplayName("Test Json url()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.url()"})
  void testJsonUrl() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).url());
  }
}
