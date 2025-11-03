package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import java.util.Map;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AppGroupEntryGeneratorDiffblueTest {
  /**
   * Test {@link AppGroupEntryGenerator#create(ApplicationContext)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AppGroupEntryGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); given ResultSet next() return 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AppGroupEntryGenerator.create(ApplicationContext)"})
  void testCreate_givenResultSetNextReturnTrue_thenReturnNull() throws SQLException, BeansException {
    // Arrange
    AppGroupEntryGenerator appGroupEntryGenerator = new AppGroupEntryGenerator();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = appGroupEntryGenerator.create(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link AppGroupEntryGenerator#remove(ApplicationContext)}.
   * <p>
   * Method under test: {@link AppGroupEntryGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName("Test remove(ApplicationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AppGroupEntryGenerator.remove(ApplicationContext)"})
  void testRemove() {
    // Arrange
    AppGroupEntryGenerator appGroupEntryGenerator = new AppGroupEntryGenerator();

    // Act and Assert
    assertFalse(appGroupEntryGenerator.remove(new AnnotationConfigApplicationContext()));
  }
}
