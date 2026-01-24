package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.ArrayList;
import java.util.Map;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class EndUserAppGeneratorDiffblueTest {
  /**
   * Test {@link EndUserAppGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EndUserAppGenerator.create(ApplicationContext)"})
  void testCreate_givenDefaultDSLContextWithDialectIsSql99() throws BeansException {
    // Arrange
    EndUserAppGenerator endUserAppGenerator = new EndUserAppGenerator();

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.findAll()).thenReturn(new ArrayList<>());

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(OrganisationalUnitDao.class)).thenReturn(organisationalUnitDao);
    when(ctx.getBean(DSLContext.class)).thenReturn(new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    Map<String, Integer> actualCreateResult = endUserAppGenerator.create(ctx);

    // Assert
    verify(organisationalUnitDao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link EndUserAppGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given PreparedStatement getResultSet() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EndUserAppGenerator.create(ApplicationContext)"})
  void testCreate_givenPreparedStatementGetResultSetReturnNull()
      throws SQLException, BeansException {
    // Arrange
    EndUserAppGenerator endUserAppGenerator = new EndUserAppGenerator();

    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    organisationalUnitList.add(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    organisationalUnitList.add(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    organisationalUnitList.add(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.findAll()).thenReturn(organisationalUnitList);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(OrganisationalUnitDao.class)).thenReturn(organisationalUnitDao);
    when(ctx.getBean(DSLContext.class)).thenReturn(defaultDSLContext);

    // Act
    Map<String, Integer> actualCreateResult = endUserAppGenerator.create(ctx);

    // Assert
    verify(organisationalUnitDao).findAll();
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link EndUserAppGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserAppGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EndUserAppGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    EndUserAppGenerator endUserAppGenerator = new EndUserAppGenerator();

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
    boolean actualRemoveResult = endUserAppGenerator.remove(ctx);

    // Assert
    verify(connection).prepareStatement("delete from \"end_user_application\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
