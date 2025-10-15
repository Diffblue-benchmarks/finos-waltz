package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class AssessmentGeneratorDiffblueTest {
  /**
   * Test {@link AssessmentGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SelectJoinStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given SelectJoinStep where(Condition) throw RuntimeException(); then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AssessmentGenerator.create(ApplicationContext)"})
  void testCreate_givenSelectJoinStepWhereThrowRuntimeException_thenCallsWhere()
      throws BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new RuntimeException());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assessmentGenerator.create(ctx));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(defaultDSLContext).select(isA(SelectField.class));
    verify(ctx).getBean(isA(Class.class));
  }

  /**
   * Test {@link AssessmentGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given SelectSelectStep from(TableLike) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map AssessmentGenerator.create(ApplicationContext)"})
  void testCreate_givenSelectSelectStepFromThrowRuntimeException() throws BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new RuntimeException());

    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> assessmentGenerator.create(ctx));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(defaultDSLContext).select(isA(SelectField.class));
    verify(ctx).getBean(isA(Class.class));
  }

  /**
   * Test {@link AssessmentGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentGenerator.remove(ApplicationContext)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException, BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    boolean actualRemoveResult = assessmentGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(1, "waltz-sample");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentGenerator.remove(ApplicationContext)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException, BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.FIREBIRD));

    // Act
    boolean actualRemoveResult = assessmentGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(1, "waltz-sample");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentGenerator.remove(ApplicationContext)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException, BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.MARIADB));

    // Act
    boolean actualRemoveResult = assessmentGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(1, "waltz-sample");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentGenerator.remove(ApplicationContext)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException, BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.POSTGRES));

    // Act
    boolean actualRemoveResult = assessmentGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(1, "waltz-sample");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentGenerator.remove(ApplicationContext)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException, BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

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
    boolean actualRemoveResult = assessmentGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(1, "waltz-sample");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentGenerator.remove(ApplicationContext)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException, BeansException {
    // Arrange
    AssessmentGenerator assessmentGenerator = new AssessmentGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any()))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQLITE));

    // Act
    boolean actualRemoveResult = assessmentGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(1, "waltz-sample");
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
