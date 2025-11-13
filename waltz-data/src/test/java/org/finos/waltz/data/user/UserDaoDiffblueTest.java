package org.finos.waltz.data.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private UserDao userDao;

  /**
   * Test {@link UserDao#getPassword(String)}.
   *
   * <p>Method under test: {@link UserDao#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserDao.getPassword(String)"})
  void testGetPassword() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    String actualPassword = new UserDao(dsl).getPassword("janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"user\".\"password\" from \"user\" where lower(\"user\".\"user_name\") = lower(?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "janedoe");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualPassword);
  }

  /**
   * Test {@link UserDao#create(String, String)}.
   *
   * <p>Method under test: {@link UserDao#create(String, String)}
   */
  @Test
  @DisplayName("Test create(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserDao.create(String, String)"})
  void testCreate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCreateResult = new UserDao(dsl).create("janedoe", "Password Hash");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"user\" (\"user_name\", \"password\") select \"t\".\"user_name\", \"t\".\"password\" from (select ? \"user_name\", ? \"password\" where not exists (select 1 \"one\" from \"user\" where \"user\".\"user_name\" = ?)) \"t\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCreateResult);
  }

  /**
   * Test {@link UserDao#findAllUserNames()}.
   *
   * <p>Method under test: {@link UserDao#findAllUserNames()}
   */
  @Test
  @DisplayName("Test findAllUserNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserDao.findAllUserNames()"})
  void testFindAllUserNames() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    List<String> actualFindAllUserNamesResult = userDao.findAllUserNames();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllUserNamesResult.isEmpty());
  }

  /**
   * Test {@link UserDao#deleteUser(String)}.
   *
   * <p>Method under test: {@link UserDao#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserDao.deleteUser(String)"})
  void testDeleteUser() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteUserResult = new UserDao(dsl).deleteUser("janedoe");

    // Assert
    verify(connection)
        .prepareStatement("delete from \"user\" where lower(\"user\".\"user_name\") = lower(?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "janedoe");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteUserResult);
  }

  /**
   * Test {@link UserDao#resetPassword(String, String)}.
   *
   * <p>Method under test: {@link UserDao#resetPassword(String, String)}
   */
  @Test
  @DisplayName("Test resetPassword(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserDao.resetPassword(String, String)"})
  void testResetPassword() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualResetPasswordResult = new UserDao(dsl).resetPassword("janedoe", "Password Hash");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"user\" set \"user\".\"password\" = ? where \"user\".\"user_name\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualResetPasswordResult);
  }
}
