package org.finos.waltz.data.bookmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.model.bookmark.Bookmark;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookmarkDaoDiffblueTest {
  /**
   * Test {@link BookmarkDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BookmarkDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Bookmark BookmarkDao.getById(long)"})
  void testGetById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
   * Test {@link BookmarkDao#toString()}.
   * <p>
   * Method under test: {@link BookmarkDao#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BookmarkDao.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("BookmarkDao{}", (new BookmarkDao(new DefaultDSLContext(SQLDialect.SQL99))).toString());
  }
}
