package org.finos.waltz.data.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.finos.waltz.model.bookmark.ImmutableBookmark;
import org.finos.waltz.model.bookmark.ImmutableBookmark.Builder;
import org.finos.waltz.schema.tables.records.BookmarkRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSeekStep2;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookmarkDaoDiffblueTest {
  /**
   * Test {@link BookmarkDao#findByReference(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectSeekStep2} {@link SelectSeekStep2#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#findByReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByReference(EntityReference); given SelectSeekStep2 fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List BookmarkDao.findByReference(EntityReference)"})
  void testFindByReference_givenSelectSeekStep2FetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

    // Act
    List<Bookmark> actualFindByReferenceResult =
        bookmarkDao.findByReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByReferenceResult.isEmpty());
  }

  /**
   * Test {@link BookmarkDao#getById(long)}.
   *
   * <p>Method under test: {@link BookmarkDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

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
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
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

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Bookmark actualById = new BookmarkDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
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
   * Test {@link BookmarkDao#deleteById(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkDao.deleteById(long)"})
  void testDeleteById_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualDeleteByIdResult = new BookmarkDao(dsl).deleteById(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"bookmark\" where \"bookmark\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Test {@link BookmarkDao#deleteById(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkDao.deleteById(long)"})
  void testDeleteById_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteByIdResult = new BookmarkDao(dsl).deleteById(1L);

    // Assert
    verify(connection).prepareStatement("delete from \"bookmark\" where \"bookmark\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Test {@link BookmarkDao#deleteById(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long); given DeleteConditionStep execute() return one; when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkDao.deleteById(long)"})
  void testDeleteById_givenDeleteConditionStepExecuteReturnOne_whenOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<BookmarkRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<BookmarkRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<BookmarkRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteByIdResult = new BookmarkDao(dsl).deleteById(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Test {@link BookmarkDao#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link BookmarkDao#BookmarkDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>Then return {@link Bookmark}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given BookmarkDao(DSLContext) with dsl is DSLContext; then return Bookmark")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkDao.update(Bookmark, String)"})
  void testUpdate_givenBookmarkDaoWithDslIsDSLContext_thenReturnBookmark()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<BookmarkRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep7);

    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep9 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep8);

    UpdateSetFirstStep<BookmarkRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep9);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<BookmarkRecord>>any())).thenReturn(updateSetFirstStep);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

    Bookmark bookmark = mock(Bookmark.class);
    when(bookmark.isRestricted()).thenReturn(true);
    when(bookmark.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("42");
    when(bookmark.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(bookmark.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("42");
    when(bookmark.url()).thenReturn(ofResult3);
    when(bookmark.isPrimary()).thenReturn(true);
    when(bookmark.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    Optional<Long> ofResult4 = Optional.of(42L);
    when(bookmark.id()).thenReturn(ofResult4);

    // Act
    Bookmark actualUpdateResult = bookmarkDao.update(bookmark, "janedoe");

    // Assert
    verify(bookmark).lastUpdatedAt();
    verify(bookmark).bookmarkKind();
    verify(bookmark).description();
    verify(bookmark, atLeast(1)).id();
    verify(bookmark).isPrimary();
    verify(bookmark).isRestricted();
    verify(bookmark).provenance();
    verify(bookmark).title();
    verify(bookmark).url();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertSame(bookmark, actualUpdateResult);
  }

  /**
   * Test {@link BookmarkDao#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkDao.update(Bookmark, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

    Bookmark bookmark = mock(Bookmark.class);
    when(bookmark.isRestricted()).thenReturn(true);
    when(bookmark.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("42");
    when(bookmark.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(bookmark.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("42");
    when(bookmark.url()).thenReturn(ofResult3);
    when(bookmark.isPrimary()).thenReturn(true);
    when(bookmark.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    Optional<Long> ofResult4 = Optional.of(42L);
    when(bookmark.id()).thenReturn(ofResult4);

    // Act
    Bookmark actualUpdateResult = bookmarkDao.update(bookmark, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"bookmark\" set \"bookmark\".\"kind\" = cast(? as varchar), \"bookmark\".\"description\" = cast(? as varchar), \"bookmark\".\"url\" = cast(? as varchar), \"bookmark\".\"title\" = cast(? as varchar), \"bookmark\".\"is_primary\" = cast(? as bit(1)), \"bookmark\".\"updated_at\" = cast(? as datetime), \"bookmark\".\"last_updated_by\" = cast(? as varchar), \"bookmark\".\"provenance\" = cast(? as varchar), \"bookmark\".\"is_restricted\" = cast(? as bit(1)) where \"bookmark\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setLong(10, 42L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(bookmark).lastUpdatedAt();
    verify(bookmark).bookmarkKind();
    verify(bookmark).description();
    verify(bookmark, atLeast(1)).id();
    verify(bookmark).isPrimary();
    verify(bookmark).isRestricted();
    verify(bookmark).provenance();
    verify(bookmark).title();
    verify(bookmark).url();
    assertNull(actualUpdateResult);
  }

  /**
   * Test {@link BookmarkDao#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkDao.update(Bookmark, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

    Bookmark bookmark = mock(Bookmark.class);
    when(bookmark.isRestricted()).thenReturn(true);
    when(bookmark.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("42");
    when(bookmark.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(bookmark.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("42");
    when(bookmark.url()).thenReturn(ofResult3);
    when(bookmark.isPrimary()).thenReturn(true);
    when(bookmark.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    Optional<Long> ofResult4 = Optional.of(42L);
    when(bookmark.id()).thenReturn(ofResult4);

    // Act
    Bookmark actualUpdateResult = bookmarkDao.update(bookmark, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"bookmark\" set \"bookmark\".\"kind\" = cast(? as varchar(2)), \"bookmark\".\"description\" = cast(? as varchar(2)), \"bookmark\".\"url\" = cast(? as varchar(2)), \"bookmark\".\"title\" = cast(? as varchar(2)), \"bookmark\".\"is_primary\" = cast(? as boolean), \"bookmark\".\"updated_at\" = cast(? as timestamp), \"bookmark\".\"last_updated_by\" = cast(? as varchar(7)), \"bookmark\".\"provenance\" = cast(? as varchar(10)), \"bookmark\".\"is_restricted\" = cast(? as boolean) where \"bookmark\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setLong(10, 42L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(bookmark).lastUpdatedAt();
    verify(bookmark).bookmarkKind();
    verify(bookmark).description();
    verify(bookmark, atLeast(1)).id();
    verify(bookmark).isPrimary();
    verify(bookmark).isRestricted();
    verify(bookmark).provenance();
    verify(bookmark).title();
    verify(bookmark).url();
    assertNull(actualUpdateResult);
  }

  /**
   * Test {@link BookmarkDao#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkDao.update(Bookmark, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

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
    Bookmark actualUpdateResult =
        bookmarkDao.update(
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
    verify(connection)
        .prepareStatement(
            "update \"bookmark\" set \"bookmark\".\"kind\" = ?, \"bookmark\".\"description\" = ?, \"bookmark\".\"url\" = ?, \"bookmark\".\"title\" = ?, \"bookmark\".\"is_primary\" = ?, \"bookmark\".\"updated_at\" = ?, \"bookmark\".\"last_updated_by\" = ?, \"bookmark\".\"provenance\" = ?, \"bookmark\".\"is_restricted\" = ? where \"bookmark\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(false));
    verify(preparedStatement).setLong(10, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertNull(actualUpdateResult);
  }

  /**
   * Test {@link BookmarkDao#update(Bookmark, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  @DisplayName(
      "Test update(Bookmark, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Bookmark BookmarkDao.update(Bookmark, String)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);

    Bookmark bookmark = mock(Bookmark.class);
    when(bookmark.isRestricted()).thenReturn(true);
    when(bookmark.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("42");
    when(bookmark.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(bookmark.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("42");
    when(bookmark.url()).thenReturn(ofResult3);
    when(bookmark.isPrimary()).thenReturn(true);
    when(bookmark.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    Optional<Long> ofResult4 = Optional.of(42L);
    when(bookmark.id()).thenReturn(ofResult4);

    // Act
    Bookmark actualUpdateResult = bookmarkDao.update(bookmark, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"bookmark\" set \"bookmark\".\"kind\" = ?, \"bookmark\".\"description\" = ?, \"bookmark\".\"url\" = ?, \"bookmark\".\"title\" = ?, \"bookmark\".\"is_primary\" = ?, \"bookmark\".\"updated_at\" = ?, \"bookmark\".\"last_updated_by\" = ?, \"bookmark\".\"provenance\" = ?, \"bookmark\".\"is_restricted\" = ? where \"bookmark\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setLong(10, 42L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(bookmark).lastUpdatedAt();
    verify(bookmark).bookmarkKind();
    verify(bookmark).description();
    verify(bookmark, atLeast(1)).id();
    verify(bookmark).isPrimary();
    verify(bookmark).isRestricted();
    verify(bookmark).provenance();
    verify(bookmark).title();
    verify(bookmark).url();
    assertNull(actualUpdateResult);
  }

  /**
   * Test {@link BookmarkDao#toString()}.
   *
   * <p>Method under test: {@link BookmarkDao#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BookmarkDao.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "BookmarkDao{}", new BookmarkDao(new DefaultDSLContext(SQLDialect.SQL99)).toString());
  }
}
