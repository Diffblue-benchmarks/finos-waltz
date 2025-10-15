package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class BookmarkGeneratorDiffblueTest {
  /**
   * Test {@link BookmarkGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BookmarkGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BookmarkGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnFalse()
      throws SQLException, BeansException {
    // Arrange
    BookmarkGenerator bookmarkGenerator = new BookmarkGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = bookmarkGenerator.remove(ctx);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"bookmark\" where \"bookmark\".\"provenance\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "waltz-sample");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test new {@link BookmarkGenerator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BookmarkGenerator}
   */
  @Test
  @DisplayName("Test new BookmarkGenerator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BookmarkGenerator.<init>()"})
  void testNewBookmarkGenerator() {
    // Arrange and Act
    BookmarkGenerator actualBookmarkGenerator = new BookmarkGenerator();

    // Assert
    assertEquals(10, actualBookmarkGenerator.bookmarkKinds.length);
    assertEquals(3, actualBookmarkGenerator.urls.length);
    assertEquals(5, actualBookmarkGenerator.text.length);
  }
}
