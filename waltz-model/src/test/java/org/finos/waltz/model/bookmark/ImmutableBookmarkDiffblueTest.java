package org.finos.waltz.model.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableBookmarkDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableBookmark.Builder actualDescriptionResult = ImmutableBookmark.builder()
        .description("The characteristics of someone or something");
    Optional<String> description = Optional.of("foo");
    ImmutableBookmark.Builder actualIdResult = actualDescriptionResult.description(description).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableBookmark.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableBookmark.Builder actualTitleResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance")
        .title("Dr");
    Optional<String> title = Optional.of("foo");
    ImmutableBookmark.Builder actualUrlResult = actualTitleResult.title(title).url("https://example.org/example");
    Optional<String> url = Optional.of("https://example.org/example");

    // Assert
    assertSame(actualUrlResult, actualUrlResult.url(url));
  }

  /**
   * Method under test:
   * {@link ImmutableBookmark.Builder#bookmarkKind(BookmarkKindValue)}
   */
  @Test
  void testBuilderBookmarkKind() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.bookmarkKind(BookmarkKindValue.of("42")));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#description(Optional)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    Optional<String> description = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.description(description));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableBookmark.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBookmark.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(Bookmark)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    Bookmark instance = mock(Bookmark.class);
    when(instance.parent()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
    verify(instance).parent();
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(Bookmark)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
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
    BookmarkKindValue ofResult5 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult5);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRequired());
    assertTrue(buildResult.isRestricted());
    assertSame(ofResult5, buildResult.bookmarkKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(Bookmark)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
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
    BookmarkKindValue ofResult4 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult4);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRequired());
    assertTrue(buildResult.isRestricted());
    assertSame(ofResult4, buildResult.bookmarkKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(Bookmark)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
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
    BookmarkKindValue ofResult4 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult4);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRequired());
    assertTrue(buildResult.isRestricted());
    assertSame(ofResult4, buildResult.bookmarkKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(Bookmark)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
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
    BookmarkKindValue ofResult4 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult4);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRequired());
    assertTrue(buildResult.isRestricted());
    assertSame(ofResult4, buildResult.bookmarkKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#from(Bookmark)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
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
    BookmarkKindValue ofResult4 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult4);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark.Builder actualFromResult = builderResult.from(instance);

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
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isPrimary());
    assertTrue(buildResult.isRequired());
    assertTrue(buildResult.isRestricted());
    assertSame(ofResult4, buildResult.bookmarkKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#isPrimary(boolean)}
   */
  @Test
  void testBuilderIsPrimary() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isPrimary(true));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#isRequired(boolean)}
   */
  @Test
  void testBuilderIsRequired() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRequired(true));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#isRestricted(boolean)}
   */
  @Test
  void testBuilderIsRestricted() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRestricted(true));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#parent(EntityReference)}
   */
  @Test
  void testBuilderParent() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parent(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#title(Optional)}
   */
  @Test
  void testBuilderTitle() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    Optional<String> title = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.title(title));
  }

  /**
   * Method under test: {@link ImmutableBookmark.Builder#url(Optional)}
   */
  @Test
  void testBuilderUrl() {
    // Arrange
    ImmutableBookmark.Builder builderResult = ImmutableBookmark.builder();
    Optional<String> url = Optional.of("https://example.org/example");

    // Act and Assert
    assertSame(builderResult, builderResult.url(url));
  }

  /**
   * Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    BookmarkKindValue ofResult6 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult6);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isRequired());
    assertTrue(actualCopyOfResult.isRestricted());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult6, bookmarkKindResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    BookmarkKindValue ofResult5 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult5);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isRequired());
    assertTrue(actualCopyOfResult.isRestricted());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult5, bookmarkKindResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Bookmark instance = mock(Bookmark.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isPrimary()).thenReturn(false);
    when(instance.isRestricted()).thenReturn(true);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.title()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("https://example.org/example");
    when(instance.url()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    BookmarkKindValue ofResult6 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult6);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isRequired());
    assertTrue(actualCopyOfResult.isRestricted());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult6, bookmarkKindResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    BookmarkKindValue ofResult5 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult5);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isRequired());
    assertTrue(actualCopyOfResult.isRestricted());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult5, bookmarkKindResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
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
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    BookmarkKindValue ofResult5 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult5);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isRequired());
    assertTrue(actualCopyOfResult.isRestricted());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult5, bookmarkKindResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark#copyOf(Bookmark)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
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
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    BookmarkKindValue ofResult5 = BookmarkKindValue.of("42");
    when(instance.bookmarkKind()).thenReturn(ofResult5);
    when(instance.isRequired()).thenReturn(true);
    when(instance.parent()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableBookmark actualCopyOfResult = ImmutableBookmark.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = actualCopyOfResult.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isPrimary());
    assertTrue(actualCopyOfResult.isRequired());
    assertTrue(actualCopyOfResult.isRestricted());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult5, bookmarkKindResult);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#bookmarkKind()}
   */
  @Test
  void testJsonBookmarkKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).bookmarkKind());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#isPrimary()}
   */
  @Test
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).isPrimary());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#isRequired()}
   */
  @Test
  void testJsonIsRequired() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).isRequired());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#isRestricted()}
   */
  @Test
  void testJsonIsRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).isRestricted());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBookmark.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBookmark.Json actualJson = new ImmutableBookmark.Json();

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
   * Method under test: {@link ImmutableBookmark.Json#parent()}
   */
  @Test
  void testJsonParent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).parent());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#setIsPrimary(boolean)}
   */
  @Test
  void testJsonSetIsPrimary() {
    // Arrange
    ImmutableBookmark.Json json = new ImmutableBookmark.Json();

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#setIsPrimary(boolean)}
   */
  @Test
  void testJsonSetIsPrimary2() {
    // Arrange
    ImmutableBookmark.Json json = new ImmutableBookmark.Json();
    json.setParent(mock(EntityReference.class));

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#setIsRequired(boolean)}
   */
  @Test
  void testJsonSetIsRequired() {
    // Arrange
    ImmutableBookmark.Json json = new ImmutableBookmark.Json();

    // Act
    json.setIsRequired(true);

    // Assert
    assertTrue(json.isRequired);
    assertTrue(json.isRequiredIsSet);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#setIsRequired(boolean)}
   */
  @Test
  void testJsonSetIsRequired2() {
    // Arrange
    ImmutableBookmark.Json json = new ImmutableBookmark.Json();
    json.setParent(mock(EntityReference.class));

    // Act
    json.setIsRequired(true);

    // Assert
    assertTrue(json.isRequired);
    assertTrue(json.isRequiredIsSet);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#setIsRestricted(boolean)}
   */
  @Test
  void testJsonSetIsRestricted() {
    // Arrange
    ImmutableBookmark.Json json = new ImmutableBookmark.Json();

    // Act
    json.setIsRestricted(true);

    // Assert
    assertTrue(json.isRestricted);
    assertTrue(json.isRestrictedIsSet);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#setIsRestricted(boolean)}
   */
  @Test
  void testJsonSetIsRestricted2() {
    // Arrange
    ImmutableBookmark.Json json = new ImmutableBookmark.Json();
    json.setParent(mock(EntityReference.class));

    // Act
    json.setIsRestricted(true);

    // Assert
    assertTrue(json.isRestricted);
    assertTrue(json.isRestrictedIsSet);
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#title()}
   */
  @Test
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).title());
  }

  /**
   * Method under test: {@link ImmutableBookmark.Json#url()}
   */
  @Test
  void testJsonUrl() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBookmark.Json()).url());
  }
}
