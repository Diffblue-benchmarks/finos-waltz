package org.finos.waltz.service.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.bookmark.BookmarkDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.finos.waltz.model.bookmark.ImmutableBookmark;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Builder;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookmarkServiceDiffblueTest {
  /**
   * Test {@link BookmarkService#findByReference(EntityReference)}.
   *
   * <p>Method under test: {@link BookmarkService#findByReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BookmarkService.findByReference(EntityReference)"})
  void testFindByReference() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.findByReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    // Act
    List<Bookmark> actualFindByReferenceResult = bookmarkService.findByReference(null);

    // Assert
    verify(bookmarkDao).findByReference(isNull());
    assertTrue(actualFindByReferenceResult.isEmpty());
  }

  /**
   * Test {@link BookmarkService#create(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#create(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test create(Bookmark, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.create(Bookmark, String)"})
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    when(bookmarkDao.create(Mockito.<Bookmark>any(), Mockito.<String>any()))
        .thenReturn(
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark bookmark =
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

    // Act
    Bookmark actualCreateResult = bookmarkService.create(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).create(isA(Bookmark.class), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualCreateResult instanceof ImmutableBookmark);
    assertEquals(bookmark, actualCreateResult);
  }

  /**
   * Test {@link BookmarkService#create(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#create(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test create(Bookmark, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.create(Bookmark, String)"})
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    when(bookmarkDao.create(Mockito.<Bookmark>any(), Mockito.<String>any()))
        .thenReturn(
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

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark bookmark =
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

    // Act
    Bookmark actualCreateResult = bookmarkService.create(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).create(isA(Bookmark.class), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualCreateResult instanceof ImmutableBookmark);
    assertEquals(bookmark, actualCreateResult);
  }

  /**
   * Test {@link BookmarkService#update(Bookmark, String)}.
   *
   * <p>Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  @DisplayName("Test update(Bookmark, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.update(Bookmark, String)"})
  void testUpdate() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any()))
        .thenReturn(
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark bookmark =
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

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).update(isA(Bookmark.class), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualUpdateResult instanceof ImmutableBookmark);
    assertEquals(bookmark, actualUpdateResult);
  }

  /**
   * Test {@link BookmarkService#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link BookmarkKindValue} with value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  @DisplayName("Test update(Bookmark, String); given BookmarkKindValue with value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.update(Bookmark, String)"})
  void testUpdate_givenBookmarkKindValueWithValueIs42() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

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
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any()))
        .thenReturn(
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult);
    when(bookmark.parent())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "");

    // Assert
    verify(bookmarkDao).update(isA(Bookmark.class), eq(""));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    assertTrue(actualUpdateResult.parent() instanceof ImmutableEntityReference);
    assertTrue(actualUpdateResult instanceof ImmutableBookmark);
    assertEquals("2020-03-01", actualUpdateResult.lastUpdatedBy());
    assertEquals("Provenance", actualUpdateResult.provenance());
    assertEquals(EntityKind.ALL, actualUpdateResult.kind());
    assertFalse(actualUpdateResult.isPrimary());
    assertFalse(actualUpdateResult.isRequired());
    assertFalse(actualUpdateResult.isRestricted());
    assertSame(bookmarkKind, actualUpdateResult.bookmarkKind());
  }

  /**
   * Test {@link BookmarkService#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.update(Bookmark, String)"})
  void testUpdate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

    Builder builderResult = ImmutableBookmark.builder();

    Builder lastUpdatedByResult =
        builderResult
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any()))
        .thenReturn(
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

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    Builder builderResult2 = ImmutableBookmark.builder();

    Builder lastUpdatedByResult2 =
        builderResult2
            .bookmarkKind(BookmarkKindValue.of("42"))
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutableBookmark bookmark =
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

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).update(isA(Bookmark.class), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateResult instanceof ImmutableBookmark);
    assertEquals(bookmark, actualUpdateResult);
  }

  /**
   * Test {@link BookmarkService#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Bookmark} {@link Bookmark#bookmarkKind()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given 'null'; when Bookmark bookmarkKind() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.update(Bookmark, String)"})
  void testUpdate_givenNull_whenBookmarkBookmarkKindReturnNull() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

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
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any()))
        .thenReturn(
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult);
    when(bookmark.parent())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(bookmark.bookmarkKind()).thenReturn(null);

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "");

    // Assert
    verify(bookmarkDao).update(isA(Bookmark.class), eq(""));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    assertTrue(actualUpdateResult.parent() instanceof ImmutableEntityReference);
    assertTrue(actualUpdateResult instanceof ImmutableBookmark);
    assertEquals("2020-03-01", actualUpdateResult.lastUpdatedBy());
    assertEquals("Provenance", actualUpdateResult.provenance());
    assertEquals(EntityKind.ALL, actualUpdateResult.kind());
    assertFalse(actualUpdateResult.isPrimary());
    assertFalse(actualUpdateResult.isRequired());
    assertFalse(actualUpdateResult.isRestricted());
    assertSame(bookmarkKind, actualUpdateResult.bookmarkKind());
  }

  /**
   * Test {@link BookmarkService#deleteById(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link BookmarkDao} {@link BookmarkDao#deleteById(long)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(Bookmark, String); given BookmarkDao deleteById(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkService.deleteById(Bookmark, String)"})
  void testDeleteById_givenBookmarkDaoDeleteByIdReturnFalse_thenReturnFalse() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

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
    boolean actualDeleteByIdResult =
        bookmarkService.deleteById(
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
            "janedoe");

    // Assert
    verify(bookmarkDao).deleteById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Test {@link BookmarkService#deleteById(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link BookmarkDao} {@link BookmarkDao#deleteById(long)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(Bookmark, String); given BookmarkDao deleteById(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkService.deleteById(Bookmark, String)"})
  void testDeleteById_givenBookmarkDaoDeleteByIdReturnTrue_thenReturnTrue() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

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
    boolean actualDeleteByIdResult =
        bookmarkService.deleteById(
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
            "janedoe");

    // Assert
    verify(bookmarkDao).deleteById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Test {@link BookmarkService#deleteById(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(Bookmark, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkService.deleteById(Bookmark, String)"})
  void testDeleteById_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(true);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

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
    boolean actualDeleteByIdResult =
        bookmarkService.deleteById(
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
            "janedoe");

    // Assert
    verify(bookmarkDao).deleteById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Test {@link BookmarkService#getById(long)}.
   *
   * <p>Method under test: {@link BookmarkService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkService.getById(long)"})
  void testGetById() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);

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
    when(bookmarkDao.getById(anyLong()))
        .thenReturn(
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
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    // Act
    Bookmark actualById = bookmarkService.getById(1L);

    // Assert
    verify(bookmarkDao).getById(1L);
    assertTrue(actualById.parent() instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableBookmark);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Provenance", actualById.provenance());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertFalse(actualById.isPrimary());
    assertFalse(actualById.isRequired());
    assertFalse(actualById.isRestricted());
    assertSame(bookmarkKind, actualById.bookmarkKind());
  }

  /**
   * Test {@link BookmarkService#findByBookmarkIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#findByBookmarkIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByBookmarkIdSelector(IdSelectionOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set BookmarkService.findByBookmarkIdSelector(IdSelectionOptions)"})
  void testFindByBookmarkIdSelector_thenReturnEmpty() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.findByBookmarkIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<Bookmark> actualFindByBookmarkIdSelectorResult =
        bookmarkService.findByBookmarkIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(bookmarkDao).findByBookmarkIdSelector(isA(Select.class));
    assertTrue(actualFindByBookmarkIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link BookmarkService#deleteByBookmarkIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkService#deleteByBookmarkIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByBookmarkIdSelector(IdSelectionOptions); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BookmarkService.deleteByBookmarkIdSelector(IdSelectionOptions)"})
  void testDeleteByBookmarkIdSelector_thenReturnOne() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteByParentSelector(Mockito.<GenericSelector>any())).thenReturn(1);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    BookmarkService bookmarkService =
        new BookmarkService(bookmarkDao, changeLogService, mock(EntityReferenceNameResolver.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByBookmarkIdSelectorResult =
        bookmarkService.deleteByBookmarkIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(bookmarkDao).deleteByParentSelector(isA(GenericSelector.class));
    assertEquals(1, actualDeleteByBookmarkIdSelectorResult);
  }
}
