package org.finos.waltz.service.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookmarkServiceDiffblueTest {
  /**
   * Method under test: {@link BookmarkService#findByReference(EntityReference)}
   */
  @Test
  void testFindByReference() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    ArrayList<Bookmark> bookmarkList = new ArrayList<>();
    when(bookmarkDao.findByReference(Mockito.<EntityReference>any())).thenReturn(bookmarkList);

    // Act
    List<Bookmark> actualFindByReferenceResult = (new BookmarkService(bookmarkDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class))).findByReference(null);

    // Assert
    verify(bookmarkDao).findByReference(isNull());
    assertTrue(actualFindByReferenceResult.isEmpty());
    assertSame(bookmarkList, actualFindByReferenceResult);
  }

  /**
   * Method under test: {@link BookmarkService#create(Bookmark, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.create(Mockito.<Bookmark>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult2);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualCreateResult = bookmarkService.create(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).create(isA(Bookmark.class), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    assertNull(actualCreateResult);
  }

  /**
   * Method under test: {@link BookmarkService#create(Bookmark, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.create(Mockito.<Bookmark>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao, changeLogService,
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult2);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualCreateResult = bookmarkService.create(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).create(isA(Bookmark.class), eq("janedoe"));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test: {@link BookmarkService#create(Bookmark, String)}
   */
  @Test
  void testCreate3() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.create(Mockito.<Bookmark>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao, changeLogService, entityReferenceNameResolver);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(entityReference2.name()).thenReturn(emptyResult);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult3);
    when(bookmark.parent()).thenReturn(entityReference2);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualCreateResult = bookmarkService.create(bookmark, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(bookmarkDao).create(isA(Bookmark.class), eq("janedoe"));
    verify(entityReference2).kind();
    verify(entityReference).name();
    verify(entityReference2).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  void testUpdate() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult2);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).update(isA(Bookmark.class), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    assertNull(actualUpdateResult);
  }

  /**
   * Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao, changeLogService,
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult2);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).update(isA(Bookmark.class), eq("janedoe"));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualUpdateResult);
  }

  /**
   * Method under test: {@link BookmarkService#update(Bookmark, String)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.update(Mockito.<Bookmark>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao, changeLogService, entityReferenceNameResolver);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(entityReference2.name()).thenReturn(emptyResult);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult3);
    when(bookmark.parent()).thenReturn(entityReference2);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    Bookmark actualUpdateResult = bookmarkService.update(bookmark, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(bookmarkDao).update(isA(Bookmark.class), eq("janedoe"));
    verify(entityReference2).kind();
    verify(entityReference).name();
    verify(entityReference2).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualUpdateResult);
  }

  /**
   * Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  void testDeleteById() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(bookmark.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult3);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    boolean actualDeleteByIdResult = bookmarkService.deleteById(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).deleteById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark).id();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  void testDeleteById2() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(bookmark.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult3);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    boolean actualDeleteByIdResult = bookmarkService.deleteById(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).deleteById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark).id();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  void testDeleteById3() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao, changeLogService,
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(bookmark.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult3);
    when(bookmark.parent()).thenReturn(entityReference);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    boolean actualDeleteByIdResult = bookmarkService.deleteById(bookmark, "janedoe");

    // Assert
    verify(bookmarkDao).deleteById(eq(1L));
    verify(entityReference).kind();
    verify(entityReference, atLeast(1)).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark).id();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkService#deleteById(Bookmark, String)}
   */
  @Test
  void testDeleteById4() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteById(anyLong())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao, changeLogService, entityReferenceNameResolver);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(entityReference2.name()).thenReturn(emptyResult);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Bookmark bookmark = mock(Bookmark.class);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(bookmark.id()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult4);
    when(bookmark.parent()).thenReturn(entityReference2);
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));

    // Act
    boolean actualDeleteByIdResult = bookmarkService.deleteById(bookmark, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(bookmarkDao).deleteById(eq(1L));
    verify(entityReference2).kind();
    verify(entityReference).name();
    verify(entityReference2).name();
    verify(bookmark).bookmarkKind();
    verify(bookmark).id();
    verify(bookmark, atLeast(1)).parent();
    verify(bookmark).title();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.getById(anyLong())).thenReturn(null);

    // Act
    Bookmark actualById = (new BookmarkService(bookmarkDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class))).getById(1L);

    // Assert
    verify(bookmarkDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link BookmarkService#findByBookmarkIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByBookmarkIdSelector() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    HashSet<Bookmark> bookmarkSet = new HashSet<>();
    when(bookmarkDao.findByBookmarkIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(bookmarkSet);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<Bookmark> actualFindByBookmarkIdSelectorResult = bookmarkService.findByBookmarkIdSelector(selectionOptions);

    // Assert
    verify(bookmarkDao).findByBookmarkIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByBookmarkIdSelectorResult.isEmpty());
    assertSame(bookmarkSet, actualFindByBookmarkIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link BookmarkService#deleteByBookmarkIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByBookmarkIdSelector() {
    // Arrange
    BookmarkDao bookmarkDao = mock(BookmarkDao.class);
    when(bookmarkDao.deleteByParentSelector(Mockito.<GenericSelector>any())).thenReturn(1);
    BookmarkService bookmarkService = new BookmarkService(bookmarkDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityReferenceNameResolver.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByBookmarkIdSelectorResult = bookmarkService.deleteByBookmarkIdSelector(selectionOptions);

    // Assert
    verify(bookmarkDao).deleteByParentSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByBookmarkIdSelectorResult);
  }
}
