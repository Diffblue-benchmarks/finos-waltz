package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.finos.waltz.model.bookmark.ImmutableBookmark;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Builder;
import org.finos.waltz.web.action.ImmutableCreateBookmarkAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCreateBookmarkActionDiffblueTest {
  /**
   * Test Builder {@link ImmutableCreateBookmarkAction.Builder#bookmark(Bookmark)}.
   *
   * <ul>
   *   <li>When {@link Bookmark}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction.Builder#bookmark(Bookmark)}
   */
  @Test
  @DisplayName("Test Builder bookmark(Bookmark); when Bookmark; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCreateBookmarkAction.Builder ImmutableCreateBookmarkAction.Builder.bookmark(Bookmark)"
  })
  void testBuilderBookmark_whenBookmark_thenReturnBuilder() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();
    Bookmark bookmark = mock(Bookmark.class);

    // Act
    ImmutableCreateBookmarkAction.Builder actualBookmarkResult = builderResult.bookmark(bookmark);

    // Assert
    assertSame(builderResult, actualBookmarkResult);
    assertSame(bookmark, builderResult.build().bookmark());
  }

  /**
   * Test Builder {@link ImmutableCreateBookmarkAction.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCreateBookmarkAction ImmutableCreateBookmarkAction.Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCreateBookmarkAction.Builder actualBuilderResult =
        ImmutableCreateBookmarkAction.builder();
    Builder builderResult = ImmutableBookmark.builder();
    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark bookmark =
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

    // Assert
    assertSame(bookmark, actualBuilderResult.bookmark(bookmark).build().bookmark());
  }

  /**
   * Test Builder {@link ImmutableCreateBookmarkAction.Builder#from(CreateBookmarkAction)}.
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction.Builder#from(CreateBookmarkAction)}
   */
  @Test
  @DisplayName("Test Builder from(CreateBookmarkAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCreateBookmarkAction.Builder ImmutableCreateBookmarkAction.Builder.from(CreateBookmarkAction)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    ImmutableCreateBookmarkAction.Builder builderResult2 = ImmutableCreateBookmarkAction.builder();

    Builder builderResult3 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult3
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction instance =
        builderResult2
            .bookmark(
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
                    .build())
            .build();

    // Act
    ImmutableCreateBookmarkAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCreateBookmarkAction actualImmutableCreateBookmarkAction = builderResult.build();
    assertEquals(instance, actualImmutableCreateBookmarkAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#copyOf(CreateBookmarkAction)}.
   *
   * <ul>
   *   <li>Then bookmark parent return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction#copyOf(CreateBookmarkAction)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CreateBookmarkAction); then bookmark parent return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCreateBookmarkAction ImmutableCreateBookmarkAction.copyOf(CreateBookmarkAction)"
  })
  void testCopyOf_thenBookmarkParentReturnImmutableEntityReference() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();
    BookmarkKindValue bookmarkKind = BookmarkKindValue.of("42");

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(bookmarkKind)
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction instance =
        builderResult
            .bookmark(
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
                    .build())
            .build();

    // Act and Assert
    Bookmark bookmarkResult = ImmutableCreateBookmarkAction.copyOf(instance).bookmark();
    assertTrue(bookmarkResult.parent() instanceof ImmutableEntityReference);
    assertTrue(bookmarkResult instanceof ImmutableBookmark);
    assertEquals("2020-03-01", bookmarkResult.lastUpdatedBy());
    assertEquals("Provenance", bookmarkResult.provenance());
    assertEquals(EntityKind.ALL, bookmarkResult.kind());
    assertFalse(bookmarkResult.isPrimary());
    assertFalse(bookmarkResult.isRequired());
    assertFalse(bookmarkResult.isRestricted());
    assertSame(bookmarkKind, bookmarkResult.bookmarkKind());
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#equals(Object)}, and {@link
   * ImmutableCreateBookmarkAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCreateBookmarkAction#equals(Object)}
   *   <li>{@link ImmutableCreateBookmarkAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCreateBookmarkAction.equals(Object)",
    "int ImmutableCreateBookmarkAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction immutableCreateBookmarkAction =
        builderResult
            .bookmark(
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
                    .build())
            .build();

    ImmutableCreateBookmarkAction.Builder builderResult3 = ImmutableCreateBookmarkAction.builder();

    Builder builderResult4 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult4
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction immutableCreateBookmarkAction2 =
        builderResult3
            .bookmark(
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
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableCreateBookmarkAction, immutableCreateBookmarkAction2);
    assertEquals(
        immutableCreateBookmarkAction.hashCode(), immutableCreateBookmarkAction2.hashCode());
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#equals(Object)}, and {@link
   * ImmutableCreateBookmarkAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCreateBookmarkAction#equals(Object)}
   *   <li>{@link ImmutableCreateBookmarkAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCreateBookmarkAction.equals(Object)",
    "int ImmutableCreateBookmarkAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction immutableCreateBookmarkAction =
        builderResult
            .bookmark(
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
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableCreateBookmarkAction, immutableCreateBookmarkAction);
    int expectedHashCodeResult = immutableCreateBookmarkAction.hashCode();
    assertEquals(expectedHashCodeResult, immutableCreateBookmarkAction.hashCode());
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCreateBookmarkAction.equals(Object)",
    "int ImmutableCreateBookmarkAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("2020-03-01"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction immutableCreateBookmarkAction =
        builderResult
            .bookmark(
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
                    .build())
            .build();

    ImmutableCreateBookmarkAction.Builder builderResult3 = ImmutableCreateBookmarkAction.builder();

    Builder builderResult4 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult4
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutableCreateBookmarkAction,
        builderResult3
            .bookmark(
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
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCreateBookmarkAction.equals(Object)",
    "int ImmutableCreateBookmarkAction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        builderResult
            .bookmark(
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
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCreateBookmarkAction.equals(Object)",
    "int ImmutableCreateBookmarkAction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        builderResult
            .bookmark(
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
                    .build())
            .build(),
        "Different type to ImmutableCreateBookmarkAction");
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return bookmark is {@link Json} (default constructor) {@link Json#bookmark}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return bookmark is Json (default constructor) bookmark")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCreateBookmarkAction ImmutableCreateBookmarkAction.fromJson(Json)"})
  void testFromJson_thenReturnBookmarkIsJsonBookmark() {
    // Arrange
    Json json = new Json();

    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    json.setBookmark(
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
            .build());

    // Act
    ImmutableCreateBookmarkAction actualFromJsonResult =
        ImmutableCreateBookmarkAction.fromJson(json);

    // Assert
    Bookmark expectedBookmarkResult = json.bookmark;
    assertSame(expectedBookmarkResult, actualFromJsonResult.bookmark());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCreateBookmarkAction#toString()}
   *   <li>{@link ImmutableCreateBookmarkAction#bookmark()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Bookmark ImmutableCreateBookmarkAction.bookmark()",
    "String ImmutableCreateBookmarkAction.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction immutableCreateBookmarkAction =
        builderResult
            .bookmark(
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
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableCreateBookmarkAction.toString();

    // Assert
    assertTrue(immutableCreateBookmarkAction.bookmark() instanceof ImmutableBookmark);
    assertEquals(
        "CreateBookmarkAction{bookmark=Bookmark{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, id=1,"
            + " parent=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, bookmarkKind=42, title=Dr,"
            + " url=https://example.org/example, description=The characteristics of someone or something, kind=ALL,"
            + " provenance=Provenance, isPrimary=false, isRequired=false, isRestricted=false}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#bookmark()}.
   *
   * <p>Method under test: {@link Json#bookmark()}
   */
  @Test
  @DisplayName("Test Json bookmark()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark Json.bookmark()"})
  void testJsonBookmark() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().bookmark());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setBookmark(Bookmark)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setBookmark(Bookmark)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
    actualJson.setBookmark(
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
            .build());

    // Assert
    Bookmark bookmark = actualJson.bookmark;
    EntityReference parentResult = bookmark.parent();
    assertTrue(parentResult instanceof ImmutableEntityReference);
    assertTrue(bookmark instanceof ImmutableBookmark);
    LocalDateTime lastUpdatedAtResult = bookmark.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", bookmark.lastUpdatedBy());
    BookmarkKindValue bookmarkKindResult = bookmark.bookmarkKind();
    assertEquals("42", bookmarkKindResult.value());
    assertEquals("Provenance", bookmark.provenance());
    assertEquals("The characteristics of someone or something", parentResult.description());
    assertEquals(1L, parentResult.id());
    assertEquals(EntityKind.ALL, parentResult.kind());
    assertEquals(EntityKind.ALL, bookmark.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentResult.entityLifecycleStatus());
    assertFalse(bookmark.isPrimary());
    assertFalse(bookmark.isRequired());
    assertFalse(bookmark.isRestricted());
    assertSame(ofResult, toLocalDateResult);
    assertSame(bookmarkKind, bookmarkKindResult);
  }

  /**
   * Test {@link ImmutableCreateBookmarkAction#withBookmark(Bookmark)}.
   *
   * <p>Method under test: {@link ImmutableCreateBookmarkAction#withBookmark(Bookmark)}
   */
  @Test
  @DisplayName("Test withBookmark(Bookmark)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCreateBookmarkAction ImmutableCreateBookmarkAction.withBookmark(Bookmark)"
  })
  void testWithBookmark() {
    // Arrange
    ImmutableCreateBookmarkAction.Builder builderResult = ImmutableCreateBookmarkAction.builder();

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableCreateBookmarkAction immutableCreateBookmarkAction =
        builderResult
            .bookmark(
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
                    .build())
            .build();

    Builder builderResult3 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult3
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableCreateBookmarkAction actualWithBookmarkResult =
        immutableCreateBookmarkAction.withBookmark(
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

    // Assert
    assertEquals(immutableCreateBookmarkAction, actualWithBookmarkResult);
  }
}
