package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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

class LicenceGeneratorDiffblueTest {
  /**
   * Test {@link LicenceGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@code Bean}.
   *   <li>When {@link ApplicationContext} {@link ApplicationContext#getBean(Class)} return {@code
   *       Bean}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given 'Bean'; when ApplicationContext getBean(Class) return 'Bean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenBean_whenApplicationContextGetBeanReturnBean() throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<Object>>any())).thenReturn("Bean");

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(ctx).getBean(isA(Class.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LicenceGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenDefaultDSLContextWithDialectIsSql99() throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<Object>>any()))
        .thenReturn(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LicenceGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ApplicationContext} {@link ApplicationContext#getBean(Class)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given 'null'; when ApplicationContext getBean(Class) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenNull_whenApplicationContextGetBeanReturnNull() throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<Object>>any())).thenReturn(null);

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LicenceGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = licenceGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement("delete from \"licence\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
