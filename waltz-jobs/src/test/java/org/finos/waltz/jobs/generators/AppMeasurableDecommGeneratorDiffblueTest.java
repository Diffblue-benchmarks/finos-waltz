package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertTrue;
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

class AppMeasurableDecommGeneratorDiffblueTest {
  /**
   * Test {@link AppMeasurableDecommGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppMeasurableDecommGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppMeasurableDecommGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    AppMeasurableDecommGenerator appMeasurableDecommGenerator = new AppMeasurableDecommGenerator();

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
    boolean actualRemoveResult = appMeasurableDecommGenerator.remove(ctx);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"measurable_rating_planned_decommission\" where \"measurable_rating_planned_decommission\".\"created_by\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "test");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
