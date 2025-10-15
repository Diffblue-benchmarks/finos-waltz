package org.finos.waltz.data.data_type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.datatype.DataTypeMigrationResult;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeUtilitiesDiffblueTest {
  /**
   * Test {@link DataTypeUtilities#changeParent(DSLContext, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#changeParent(DSLContext, String, String)}
   */
  @Test
  @DisplayName(
      "Test changeParent(DSLContext, String, String); given PreparedStatement getResultSet() return 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.changeParent(DSLContext, String, String)"})
  void testChangeParent_givenPreparedStatementGetResultSetReturnNull_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeParentResult =
        DataTypeUtilities.changeParent(
            new DefaultDSLContext(connection, SQLDialect.SQL99), "Child Code", "New Parent Code");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(-1L));
    verify(preparedStatement, atLeast(1)).setString(eq(1), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualChangeParentResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeParent(DSLContext, String, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#changeParent(DSLContext, String, String)}
   */
  @Test
  @DisplayName(
      "Test changeParent(DSLContext, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.changeParent(DSLContext, String, String)"})
  void testChangeParent_whenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeParentResult =
        DataTypeUtilities.changeParent(
            new DefaultDSLContext(connection, SQLDialect.CUBRID), "Child Code", "New Parent Code");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(-1L));
    verify(preparedStatement, atLeast(1)).setString(eq(1), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualChangeParentResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeParent(DSLContext, String, String)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#changeParent(DSLContext, String, String)}
   */
  @Test
  @DisplayName(
      "Test changeParent(DSLContext, String, String); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.changeParent(DSLContext, String, String)"})
  void testChangeParent_whenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeParentResult =
        DataTypeUtilities.changeParent(
            new DefaultDSLContext(connection, SQLDialect.FIREBIRD),
            "Child Code",
            "New Parent Code");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(-1L));
    verify(preparedStatement, atLeast(1)).setString(eq(1), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualChangeParentResult);
  }

  /**
   * Test {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)} with {@code dsl},
   * {@code fromCode}, {@code toCode}, {@code deleteOldDataType}.
   *
   * <p>Method under test: {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test migrate(DSLContext, String, String, boolean) with 'dsl', 'fromCode', 'toCode', 'deleteOldDataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeUtilities.migrate(DSLContext, String, String, boolean)"})
  void testMigrateWithDslFromCodeToCodeDeleteOldDataType() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeUtilities.migrate(
        new DefaultDSLContext(connection, SQLDialect.CUBRID),
        "jane.doe@example.org",
        "To Code",
        false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(-1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)} with {@code dsl},
   * {@code fromCode}, {@code toCode}, {@code deleteOldDataType}.
   *
   * <p>Method under test: {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test migrate(DSLContext, String, String, boolean) with 'dsl', 'fromCode', 'toCode', 'deleteOldDataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeUtilities.migrate(DSLContext, String, String, boolean)"})
  void testMigrateWithDslFromCodeToCodeDeleteOldDataType2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeUtilities.migrate(
        new DefaultDSLContext(connection, SQLDialect.FIREBIRD),
        "jane.doe@example.org",
        "To Code",
        false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(-1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)} with {@code dsl},
   * {@code fromCode}, {@code toCode}, {@code deleteOldDataType}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#migrate(DSLContext, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test migrate(DSLContext, String, String, boolean) with 'dsl', 'fromCode', 'toCode', 'deleteOldDataType'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeUtilities.migrate(DSLContext, String, String, boolean)"})
  void testMigrateWithDslFromCodeToCodeDeleteOldDataType_thenCallsPrepareStatement()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeUtilities.migrate(
        new DefaultDSLContext(connection, SQLDialect.SQL99),
        "jane.doe@example.org",
        "To Code",
        false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(-1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)} with {@code dsl},
   * {@code fromId}, {@code toId}, {@code deleteOldDataType}.
   *
   * <p>Method under test: {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)}
   */
  @Test
  @DisplayName(
      "Test migrate(DSLContext, Long, Long, boolean) with 'dsl', 'fromId', 'toId', 'deleteOldDataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeMigrationResult DataTypeUtilities.migrate(DSLContext, Long, Long, boolean)"
  })
  void testMigrateWithDslFromIdToIdDeleteOldDataType() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeMigrationResult actualMigrateResult =
        DataTypeUtilities.migrate(
            new DefaultDSLContext(connection, SQLDialect.SQL99), 1L, 1L, false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(0L, actualMigrateResult.classificationRuleCount());
    assertEquals(0L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(0L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(0L, actualMigrateResult.usageCount());
    assertFalse(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Test {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)} with {@code dsl},
   * {@code fromId}, {@code toId}, {@code deleteOldDataType}.
   *
   * <p>Method under test: {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)}
   */
  @Test
  @DisplayName(
      "Test migrate(DSLContext, Long, Long, boolean) with 'dsl', 'fromId', 'toId', 'deleteOldDataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeMigrationResult DataTypeUtilities.migrate(DSLContext, Long, Long, boolean)"
  })
  void testMigrateWithDslFromIdToIdDeleteOldDataType2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeMigrationResult actualMigrateResult =
        DataTypeUtilities.migrate(
            new DefaultDSLContext(connection, SQLDialect.CUBRID), 1L, 1L, false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(0L, actualMigrateResult.classificationRuleCount());
    assertEquals(0L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(0L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(0L, actualMigrateResult.usageCount());
    assertFalse(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Test {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)} with {@code dsl},
   * {@code fromId}, {@code toId}, {@code deleteOldDataType}.
   *
   * <p>Method under test: {@link DataTypeUtilities#migrate(DSLContext, Long, Long, boolean)}
   */
  @Test
  @DisplayName(
      "Test migrate(DSLContext, Long, Long, boolean) with 'dsl', 'fromId', 'toId', 'deleteOldDataType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeMigrationResult DataTypeUtilities.migrate(DSLContext, Long, Long, boolean)"
  })
  void testMigrateWithDslFromIdToIdDeleteOldDataType3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    DataTypeMigrationResult actualMigrateResult =
        DataTypeUtilities.migrate(
            new DefaultDSLContext(connection, SQLDialect.FIREBIRD), 1L, 1L, false);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(0L, actualMigrateResult.classificationRuleCount());
    assertEquals(0L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(0L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(0L, actualMigrateResult.usageCount());
    assertFalse(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Test {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test findLogicalFlowIdsForDataType(DSLContext, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUtilities.findLogicalFlowIdsForDataType(DSLContext, Long, Set)"})
  void testFindLogicalFlowIdsForDataType() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult =
        DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertEquals(-1L, actualFindLogicalFlowIdsForDataTypeResult.get(0).longValue());
  }

  /**
   * Test {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test findLogicalFlowIdsForDataType(DSLContext, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUtilities.findLogicalFlowIdsForDataType(DSLContext, Long, Set)"})
  void testFindLogicalFlowIdsForDataType2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult =
        DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar(9)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertEquals(-1L, actualFindLogicalFlowIdsForDataTypeResult.get(0).longValue());
  }

  /**
   * Test {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test findLogicalFlowIdsForDataType(DSLContext, Long, Set); given minus one; when HashSet() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUtilities.findLogicalFlowIdsForDataType(DSLContext, Long, Set)"})
  void testFindLogicalFlowIdsForDataType_givenMinusOne_whenHashSetAddMinusOne()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> logicalFlowIds = new HashSet<>();
    logicalFlowIds.add(-1L);
    logicalFlowIds.add(0L);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult =
        DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L, logicalFlowIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (?, ?) and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(4, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertEquals(-1L, actualFindLogicalFlowIdsForDataTypeResult.get(0).longValue());
  }

  /**
   * Test {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test findLogicalFlowIdsForDataType(DSLContext, Long, Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUtilities.findLogicalFlowIdsForDataType(DSLContext, Long, Set)"})
  void testFindLogicalFlowIdsForDataType_givenZero_whenHashSetAddZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> logicalFlowIds = new HashSet<>();
    logicalFlowIds.add(0L);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult =
        DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L, logicalFlowIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (?) and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(3, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertEquals(-1L, actualFindLogicalFlowIdsForDataTypeResult.get(0).longValue());
  }

  /**
   * Test {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long, Set)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#findLogicalFlowIdsForDataType(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test findLogicalFlowIdsForDataType(DSLContext, Long, Set); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUtilities.findLogicalFlowIdsForDataType(DSLContext, Long, Set)"})
  void testFindLogicalFlowIdsForDataType_thenReturnSizeIsOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    List<Long> actualFindLogicalFlowIdsForDataTypeResult =
        DataTypeUtilities.findLogicalFlowIdsForDataType(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"logical_flow_decorator\".\"logical_flow_id\" from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in () and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindLogicalFlowIdsForDataTypeResult.size());
    assertEquals(-1L, actualFindLogicalFlowIdsForDataTypeResult.get(0).longValue());
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName("Test deleteLogicalFlowDecorators(DSLContext, Long, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in () and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName("Test deleteLogicalFlowDecorators(DSLContext, Long, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName("Test deleteLogicalFlowDecorators(DSLContext, Long, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar(9)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName("Test deleteLogicalFlowDecorators(DSLContext, Long, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (1 = 0 and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName("Test deleteLogicalFlowDecorators(DSLContext, Long, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from logical_flow_decorator where (logical_flow_decorator.logical_flow_id in () and logical_flow_decorator.decorator_entity_id = ? and logical_flow_decorator.decorator_entity_kind = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test deleteLogicalFlowDecorators(DSLContext, Long, Collection); given one; when ArrayList() add one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators_givenOne_whenArrayListAddOne_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ArrayList<Long> logicalFlowIds = new ArrayList<>();
    logicalFlowIds.add(1L);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, logicalFlowIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (?) and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(3, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long, Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#deleteLogicalFlowDecorators(DSLContext, Long,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test deleteLogicalFlowDecorators(DSLContext, Long, Collection); given zero; when ArrayList() add zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.deleteLogicalFlowDecorators(DSLContext, Long, Collection)"
  })
  void testDeleteLogicalFlowDecorators_givenZero_whenArrayListAddZero_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    ArrayList<Long> logicalFlowIds = new ArrayList<>();
    logicalFlowIds.add(0L);
    logicalFlowIds.add(1L);

    // Act
    long actualDeleteLogicalFlowDecoratorsResult =
        DataTypeUtilities.deleteLogicalFlowDecorators(dsl, 1L, logicalFlowIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (?, ?) and \"logical_flow_decorator\".\"decorator_entity_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setString(4, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeleteLogicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long,
   * Long, Set)}
   */
  @Test
  @DisplayName("Test updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)"
  })
  void testUpdatePhysicalFlowDecorators() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualUpdatePhysicalFlowDecoratorsResult =
        DataTypeUtilities.updatePhysicalFlowDecorators(dsl, 1L, 1L, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualUpdatePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long,
   * Long, Set)}
   */
  @Test
  @DisplayName(
      "Test updatePhysicalFlowDecorators(DSLContext, Long, Long, Set); given minus one; when HashSet() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)"
  })
  void testUpdatePhysicalFlowDecorators_givenMinusOne_whenHashSetAddMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> specIds = new HashSet<>();
    specIds.add(-1L);
    specIds.add(0L);

    // Act
    long actualUpdatePhysicalFlowDecoratorsResult =
        DataTypeUtilities.updatePhysicalFlowDecorators(dsl, 1L, 1L, specIds);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualUpdatePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long,
   * Long, Set)}
   */
  @Test
  @DisplayName(
      "Test updatePhysicalFlowDecorators(DSLContext, Long, Long, Set); given zero; when HashSet() add zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)"
  })
  void testUpdatePhysicalFlowDecorators_givenZero_whenHashSetAddZero_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> specIds = new HashSet<>();
    specIds.add(0L);

    // Act
    long actualUpdatePhysicalFlowDecoratorsResult =
        DataTypeUtilities.updatePhysicalFlowDecorators(dsl, 1L, 1L, specIds);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualUpdatePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#updatePhysicalFlowDecorators(DSLContext, Long,
   * Long, Set)}
   */
  @Test
  @DisplayName("Test updatePhysicalFlowDecorators(DSLContext, Long, Long, Set); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.updatePhysicalFlowDecorators(DSLContext, Long, Long, Set)"
  })
  void testUpdatePhysicalFlowDecorators_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualUpdatePhysicalFlowDecoratorsResult =
        DataTypeUtilities.updatePhysicalFlowDecorators(dsl, 1L, 1L, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualUpdatePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test deletePhysicalFlowDecorators(DSLContext, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.deletePhysicalFlowDecorators(DSLContext, Long, Set)"})
  void testDeletePhysicalFlowDecorators() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult =
        DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_data_type\" where (\"physical_spec_data_type\".\"specification_id\" in () and \"physical_spec_data_type\".\"data_type_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test deletePhysicalFlowDecorators(DSLContext, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.deletePhysicalFlowDecorators(DSLContext, Long, Set)"})
  void testDeletePhysicalFlowDecorators2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult =
        DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_data_type\" where (1 = 0 and \"physical_spec_data_type\".\"data_type_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test deletePhysicalFlowDecorators(DSLContext, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.deletePhysicalFlowDecorators(DSLContext, Long, Set)"})
  void testDeletePhysicalFlowDecorators3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult =
        DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_data_type\" where (1 = 0 and \"physical_spec_data_type\".\"data_type_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName("Test deletePhysicalFlowDecorators(DSLContext, Long, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.deletePhysicalFlowDecorators(DSLContext, Long, Set)"})
  void testDeletePhysicalFlowDecorators4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult =
        DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from physical_spec_data_type where (physical_spec_data_type.specification_id in () and physical_spec_data_type.data_type_id = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test deletePhysicalFlowDecorators(DSLContext, Long, Set); given one; when HashSet() add one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.deletePhysicalFlowDecorators(DSLContext, Long, Set)"})
  void testDeletePhysicalFlowDecorators_givenOne_whenHashSetAddOne_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> specIds = new HashSet<>();
    specIds.add(1L);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult =
        DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, specIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_data_type\" where (\"physical_spec_data_type\".\"specification_id\" in (?) and \"physical_spec_data_type\".\"data_type_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#deletePhysicalFlowDecorators(DSLContext, Long,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test deletePhysicalFlowDecorators(DSLContext, Long, Set); given zero; when HashSet() add zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.deletePhysicalFlowDecorators(DSLContext, Long, Set)"})
  void testDeletePhysicalFlowDecorators_givenZero_whenHashSetAddZero_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Long> specIds = new HashSet<>();
    specIds.add(0L);
    specIds.add(1L);

    // Act
    long actualDeletePhysicalFlowDecoratorsResult =
        DataTypeUtilities.deletePhysicalFlowDecorators(dsl, 1L, specIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_spec_data_type\" where (\"physical_spec_data_type\".\"specification_id\" in (?, ?) and \"physical_spec_data_type\".\"data_type_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualDeletePhysicalFlowDecoratorsResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test changeTitleAndDescription(DSLContext, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.changeTitleAndDescription(DSLContext, String, String, String)"
  })
  void testChangeTitleAndDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult =
        DataTypeUtilities.changeTitleAndDescription(
            new DefaultDSLContext(connection, SQLDialect.SQL99),
            "Dr",
            "The characteristics of someone or something",
            "Code");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"name\" = ?, \"data_type\".\"description\" = ? where \"data_type\".\"code\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test changeTitleAndDescription(DSLContext, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.changeTitleAndDescription(DSLContext, String, String, String)"
  })
  void testChangeTitleAndDescription2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult =
        DataTypeUtilities.changeTitleAndDescription(
            new DefaultDSLContext(connection, SQLDialect.CUBRID),
            "Dr",
            "The characteristics of someone or something",
            "Code");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"name\" = cast(? as varchar), \"data_type\".\"description\" = cast(? as varchar) where \"data_type\".\"code\" = cast(? as varchar)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test changeTitleAndDescription(DSLContext, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.changeTitleAndDescription(DSLContext, String, String, String)"
  })
  void testChangeTitleAndDescription3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult =
        DataTypeUtilities.changeTitleAndDescription(
            new DefaultDSLContext(connection, SQLDialect.FIREBIRD),
            "Dr",
            "The characteristics of someone or something",
            "Code");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"name\" = cast(? as varchar(2)), \"data_type\".\"description\" = cast(? as varchar(43)) where \"data_type\".\"code\" = cast(? as varchar(4))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test changeTitleAndDescription(DSLContext, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.changeTitleAndDescription(DSLContext, String, String, String)"
  })
  void testChangeTitleAndDescription4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult =
        DataTypeUtilities.changeTitleAndDescription(
            new DefaultDSLContext(connection, SQLDialect.POSTGRES),
            "Dr",
            "The characteristics of someone or something",
            "Code");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"name\" = ?, \"description\" = ? where \"data_type\".\"code\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Test {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String, String, String)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#changeTitleAndDescription(DSLContext, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test changeTitleAndDescription(DSLContext, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DataTypeUtilities.changeTitleAndDescription(DSLContext, String, String, String)"
  })
  void testChangeTitleAndDescription5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    long actualChangeTitleAndDescriptionResult =
        DataTypeUtilities.changeTitleAndDescription(
            new DefaultDSLContext(connection, SQLDialect.SQLITE),
            "Dr",
            "The characteristics of someone or something",
            "Code");

    // Assert
    verify(connection)
        .prepareStatement(
            "update data_type set name = ?, description = ? where data_type.code = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualChangeTitleAndDescriptionResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@code DEPRECATED -}.
   *   <li>When {@link HashSet#HashSet()} add {@code DEPRECATED -}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsDeprecated(DSLContext, Set); given 'DEPRECATED -'; when HashSet() add 'DEPRECATED -'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated_givenDeprecated_whenHashSetAddDeprecated() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> codeListToBeDeprecated = new HashSet<>();
    codeListToBeDeprecated.add("DEPRECATED - ");

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, codeListToBeDeprecated);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DEPRECATED - "));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsDeprecated(DSLContext, Set); given 'foo'; when HashSet() add 'foo'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsDeprecated(DSLContext, Set)"})
  void testMarkDataTypeAsDeprecated_givenFoo_whenHashSetAddFoo_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> codeListToBeDeprecated = new HashSet<>();
    codeListToBeDeprecated.add("foo");
    codeListToBeDeprecated.add("DEPRECATED - ");

    // Act
    long actualMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.markDataTypeAsDeprecated(dsl, codeListToBeDeprecated);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test unMarkDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"deprecated\" = ? where \"data_type\".\"code\" in ()");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test unMarkDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"deprecated\" = cast(? as bit(1)) where 1 = 0");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test unMarkDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"deprecated\" = ? where \"data_type\".\"code\" in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test unMarkDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"deprecated\" = cast(? as boolean) where \"data_type\".\"code\" in (cast(? as varchar(3)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test unMarkDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated5() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"deprecated\" = ? where \"data_type\".\"code\" in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test unMarkDataTypeAsDeprecated(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated6() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement("update data_type set deprecated = ? where data_type.code in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#unMarkDataTypeAsDeprecated(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test unMarkDataTypeAsDeprecated(DSLContext, Set); given '42'; when HashSet() add '42'; then calls setString(int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.unMarkDataTypeAsDeprecated(DSLContext, Set)"})
  void testUnMarkDataTypeAsDeprecated_given42_whenHashSetAdd42_thenCallsSetString()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("42");
    dataTypeCodes.add("foo");

    // Act
    long actualUnMarkDataTypeAsDeprecatedResult =
        DataTypeUtilities.unMarkDataTypeAsDeprecated(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"deprecated\" = ? where \"data_type\".\"code\" in (?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUnMarkDataTypeAsDeprecatedResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsConcrete(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"concrete\" = cast(? as boolean) where \"data_type\".\"code\" in (cast(? as varchar(3)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test markDataTypeAsConcrete(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"concrete\" = ? where \"data_type\".\"code\" in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsConcrete(DSLContext, Set); given '42'; when HashSet() add '42'; then calls setString(int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete_given42_whenHashSetAdd42_thenCallsSetString()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("42");
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"concrete\" = ? where \"data_type\".\"code\" in (?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsConcrete(DSLContext, Set); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete_whenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"concrete\" = cast(? as bit(1)) where 1 = 0");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsConcrete(DSLContext, Set); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete_whenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"concrete\" = ? where \"data_type\".\"code\" in ()");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsConcrete(DSLContext, Set); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete_whenDefaultDSLContextWithConnectionAndDialectIsSql992()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"data_type\" set \"data_type\".\"concrete\" = ? where \"data_type\".\"code\" in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }

  /**
   * Test {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}.
   *
   * <ul>
   *   <li>When {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUtilities#markDataTypeAsConcrete(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test markDataTypeAsConcrete(DSLContext, Set); when DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeUtilities.markDataTypeAsConcrete(DSLContext, Set)"})
  void testMarkDataTypeAsConcrete_whenDefaultDSLContextWithConnectionAndDialectIsSqlite()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    HashSet<String> dataTypeCodes = new HashSet<>();
    dataTypeCodes.add("foo");

    // Act
    long actualMarkDataTypeAsConcreteResult =
        DataTypeUtilities.markDataTypeAsConcrete(dsl, dataTypeCodes);

    // Assert
    verify(connection)
        .prepareStatement("update data_type set concrete = ? where data_type.code in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setString(2, "foo");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualMarkDataTypeAsConcreteResult);
  }
}
