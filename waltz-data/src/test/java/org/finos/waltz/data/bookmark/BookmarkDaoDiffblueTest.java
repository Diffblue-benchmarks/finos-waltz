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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.bookmark.Bookmark;
import org.finos.waltz.model.bookmark.BookmarkKindValue;
import org.finos.waltz.schema.tables.records.BookmarkRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookmarkDaoDiffblueTest {
  /**
   * Method under test: {@link BookmarkDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Bookmark actualById = (new BookmarkDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"bookmark\".\"id\", \"bookmark\".\"title\", \"bookmark\".\"description\", \"bookmark\".\"kind\", \"bookmark\".\"url\", \"bookmark\".\"parent_kind\", \"bookmark\".\"parent_id\", \"bookmark\".\"created_at\", \"bookmark\".\"updated_at\", \"bookmark\".\"is_primary\", \"bookmark\".\"provenance\", \"bookmark\".\"last_updated_by\", \"bookmark\".\"is_required\", \"bookmark\".\"is_restricted\" from \"bookmark\" where \"bookmark\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  void testDeleteById() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteByIdResult = (new BookmarkDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .deleteById(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"bookmark\" where \"bookmark\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  void testDeleteById2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<BookmarkRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<BookmarkRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<BookmarkRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteByIdResult = (new BookmarkDao(dsl)).deleteById(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  void testDeleteById3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteByIdResult = (new BookmarkDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .deleteById(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"bookmark\" where \"bookmark\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkDao#deleteById(long)}
   */
  @Test
  void testDeleteById4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualDeleteByIdResult = (new BookmarkDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .deleteById(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from bookmark where bookmark.id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  void testUpdate() throws SQLException {
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
    BookmarkDao bookmarkDao = new BookmarkDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Bookmark bookmark = mock(Bookmark.class);
    when(bookmark.isRestricted()).thenReturn(true);
    when(bookmark.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("foo");
    when(bookmark.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("https://example.org/example");
    when(bookmark.url()).thenReturn(ofResult3);
    when(bookmark.isPrimary()).thenReturn(true);
    when(bookmark.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(bookmark.id()).thenReturn(ofResult4);

    // Act
    Bookmark actualUpdateResult = bookmarkDao.update(bookmark, "janedoe");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"bookmark\" set \"bookmark\".\"kind\" = ?, \"bookmark\".\"description\" = ?, \"bookmark\".\"url\" = ?, \"bookmark\".\"title\" = ?, \"bookmark\".\"is_primary\" = ?, \"bookmark\".\"updated_at\" = ?, \"bookmark\".\"last_updated_by\" = ?, \"bookmark\".\"provenance\" = ?, \"bookmark\".\"is_restricted\" = ? where \"bookmark\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement).setLong(eq(10), eq(1L));
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
   * Method under test: {@link BookmarkDao#update(Bookmark, String)}
   */
  @Test
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<BookmarkRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep4);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep5);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep6);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep7);
    UpdateSetMoreStep<BookmarkRecord> updateSetMoreStep9 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep8);
    UpdateSetFirstStep<BookmarkRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep9);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<BookmarkRecord>>any())).thenReturn(updateSetFirstStep);
    BookmarkDao bookmarkDao = new BookmarkDao(dsl);
    Bookmark bookmark = mock(Bookmark.class);
    when(bookmark.isRestricted()).thenReturn(true);
    when(bookmark.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("foo");
    when(bookmark.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(bookmark.title()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("https://example.org/example");
    when(bookmark.url()).thenReturn(ofResult3);
    when(bookmark.isPrimary()).thenReturn(true);
    when(bookmark.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(bookmark.bookmarkKind()).thenReturn(BookmarkKindValue.of("42"));
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
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
   * Method under test: {@link BookmarkDao#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("BookmarkDao{}", (new BookmarkDao(new DefaultDSLContext(SQLDialect.SQL99))).toString());
  }
}
