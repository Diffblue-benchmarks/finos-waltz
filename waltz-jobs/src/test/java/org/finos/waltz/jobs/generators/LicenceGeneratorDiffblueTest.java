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
import java.util.ArrayList;
import java.util.Map;
import org.finos.waltz.data.licence.LicenceDao;
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
   *   <li>Given {@link LicenceDao} {@link LicenceDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); given LicenceDao findAll() return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenLicenceDaoFindAllReturnArrayList() throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.findAll()).thenReturn(new ArrayList<>());

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));
    when(ctx.getBean(LicenceDao.class)).thenReturn(licenceDao);

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(licenceDao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LicenceGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link LicenceDao} {@link LicenceDao#findAll()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given LicenceDao findAll() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenLicenceDaoFindAllThrowRuntimeException() throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.findAll()).thenThrow(new RuntimeException());

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));
    when(ctx.getBean(LicenceDao.class)).thenReturn(licenceDao);

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(licenceDao).findAll();
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
   *   <li>Then calls {@link LicenceDao#findAll()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given 'null'; when ApplicationContext getBean(Class) return 'null'; then calls findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenNull_whenApplicationContextGetBeanReturnNull_thenCallsFindAll()
      throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    LicenceDao licenceDao = mock(LicenceDao.class);
    when(licenceDao.findAll()).thenReturn(new ArrayList<>());

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class)).thenReturn(null);
    when(ctx.getBean(LicenceDao.class)).thenReturn(licenceDao);

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(licenceDao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link LicenceGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LicenceGenerator.create(ApplicationContext)"})
  void testCreate_givenRuntimeException() throws BeansException {
    // Arrange
    LicenceGenerator licenceGenerator = new LicenceGenerator();

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class)).thenThrow(new RuntimeException());
    when(ctx.getBean(LicenceDao.class)).thenThrow(new RuntimeException());

    // Act
    Map<String, Integer> actualCreateResult = licenceGenerator.create(ctx);

    // Assert
    verify(ctx).getBean(isA(Class.class));
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
    when(ctx.getBean(DSLContext.class))
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
