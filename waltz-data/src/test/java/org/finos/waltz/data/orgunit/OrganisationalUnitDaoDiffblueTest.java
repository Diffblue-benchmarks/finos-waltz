package org.finos.waltz.data.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.finos.waltz.schema.tables.records.OrganisationalUnitRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrganisationalUnitDaoDiffblueTest {
  /**
   * Method under test: {@link OrganisationalUnitDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
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

    // Act
    List<OrganisationalUnit> actualFindAllResult = (new OrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"ou\".\"id\", \"ou\".\"name\", \"ou\".\"description\", \"ou\".\"parent_id\", \"ou\".\"created_at\", \"ou\".\"last_updated_at\", \"ou\".\"external_id\", \"ou\".\"created_by\", \"ou\".\"last_updated_by\", \"ou\".\"provenance\" from \"organisational_unit\" \"ou\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllResult.size());
    OrganisationalUnit getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    OrganisationalUnit getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrganisationalUnit);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.ORG_UNIT, getResult.kind());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrganisationalUnitDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
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
    OrganisationalUnit actualById = (new OrganisationalUnitDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"ou\".\"id\", \"ou\".\"name\", \"ou\".\"description\", \"ou\".\"parent_id\", \"ou\".\"created_at\", \"ou\".\"last_updated_at\", \"ou\".\"external_id\", \"ou\".\"created_by\", \"ou\".\"last_updated_by\", \"ou\".\"provenance\" from \"organisational_unit\" \"ou\" where \"ou\".\"id\" = ?"));
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
   * Method under test: {@link OrganisationalUnitDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    OrganisationalUnit actualById = (new OrganisationalUnitDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"ou\".\"id\", \"ou\".\"name\", \"ou\".\"description\", \"ou\".\"parent_id\", \"ou\".\"created_at\", \"ou\".\"last_updated_at\", \"ou\".\"external_id\", \"ou\".\"created_by\", \"ou\".\"last_updated_by\", \"ou\".\"provenance\" from \"organisational_unit\" \"ou\" where \"ou\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualById instanceof ImmutableOrganisationalUnit);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals(EntityKind.ORG_UNIT, actualById.kind());
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
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
    Integer actualUpdateDescriptionResult = (new OrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).updateDescription(1L,
            "The characteristics of someone or something");

    // Assert
    verify(connection).prepareStatement(
        eq("update \"organisational_unit\" \"ou\" set \"ou\".\"description\" = ? where \"ou\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("The characteristics of someone or something"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitDao#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<OrganisationalUnitRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<OrganisationalUnitRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<OrganisationalUnitRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<OrganisationalUnitRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Integer actualUpdateDescriptionResult = (new OrganisationalUnitDao(dsl)).updateDescription(1L,
        "The characteristics of someone or something");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Method under test: {@link OrganisationalUnitDao#findByIds(Long[])}
   */
  @Test
  void testFindByIds() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(mock(Timestamp.class));
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<OrganisationalUnit> actualFindByIdsResult = (new OrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByIds(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"ou\".\"id\", \"ou\".\"name\", \"ou\".\"description\", \"ou\".\"parent_id\", \"ou\".\"created_at\", \"ou\".\"last_updated_at\", \"ou\".\"external_id\", \"ou\".\"created_by\", \"ou\".\"last_updated_by\", \"ou\".\"provenance\" from \"organisational_unit\" \"ou\" where \"ou\".\"id\" in (?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByIdsResult.size());
    OrganisationalUnit getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    OrganisationalUnit getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrganisationalUnit);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.ORG_UNIT, getResult.kind());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrganisationalUnitDao#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("OrganisationalUnitDao{dsl=DefaultConfiguration [\n" + "\tconnected=false,\n"
        + "\ttransactional=false,\n" + "\tdialect=SQL99,\n" + "\tdata={},\n" + "\tsettings=\n"
        + "\t\t<renderCatalog>true</renderCatalog><renderSchema>true</renderSchema><renderQuotedNames>EXPLICIT"
        + "_DEFAULT_QUOTED</renderQuotedNames><renderNameCase>AS_IS</renderNameCase><renderNameStyle>QUOTED<"
        + "/renderNameStyle><renderNamedParamPrefix>:</renderNamedParamPrefix><renderKeywordCase>AS_IS<"
        + "/renderKeywordCase><renderKeywordStyle>AS_IS</renderKeywordStyle><renderFormatted>false</renderFormatted"
        + "><renderOptionalAsKeywordForTableAliases>DEFAULT</renderOptionalAsKeywordForTableAliases><renderOpti"
        + "onalAsKeywordForFieldAliases>DEFAULT</renderOptionalAsKeywordForFieldAliases><renderOptionalInnerKeyword"
        + ">DEFAULT</renderOptionalInnerKeyword><renderOptionalOuterKeyword>DEFAULT</renderOptionalOuterKeyword"
        + "><renderScalarSubqueriesForStoredFunctions>false</renderScalarSubqueriesForStoredFunctions>"
        + "<renderOrderByRownumberForEmulatedPagination>true</renderOrderByRownumberForEmulatedPagination>"
        + "<renderOutputForSQLServerReturningClause>true</renderOutputForSQLServerReturningClause><renderParent"
        + "hesisAroundSetOperationQueries>false</renderParenthesisAroundSetOperationQueries><fetchTriggerValues"
        + "AfterSQLServerOutput>true</fetchTriggerValuesAfterSQLServerOutput><transformAnsiJoinToTableLists>false"
        + "</transformAnsiJoinToTableLists><transformTableListsToAnsiJoin>false</transformTableListsToAnsiJoin>"
        + "<backslashEscaping>DEFAULT</backslashEscaping><paramType>INDEXED</paramType><paramCastMode>DEFAULT<"
        + "/paramCastMode><statementType>PREPARED_STATEMENT</statementType><inlineThreshold>0</inlineThreshold>"
        + "<transactionListenerStartInvocationOrder>DEFAULT</transactionListenerStartInvocationOrder><transacti"
        + "onListenerEndInvocationOrder>DEFAULT</transactionListenerEndInvocationOrder><migrationListenerStartI"
        + "nvocationOrder>DEFAULT</migrationListenerStartInvocationOrder><migrationListenerEndInvocationOrder"
        + ">DEFAULT</migrationListenerEndInvocationOrder><visitListenerStartInvocationOrder>DEFAULT</visitListe"
        + "nerStartInvocationOrder><visitListenerEndInvocationOrder>DEFAULT</visitListenerEndInvocationOrder>"
        + "<recordListenerStartInvocationOrder>DEFAULT</recordListenerStartInvocationOrder><recordListenerEndIn"
        + "vocationOrder>DEFAULT</recordListenerEndInvocationOrder><executeListenerStartInvocationOrder>DEFAULT"
        + "</executeListenerStartInvocationOrder><executeListenerEndInvocationOrder>DEFAULT</executeListenerEnd"
        + "InvocationOrder><executeLogging>true</executeLogging><updateRecordVersion>true</updateRecordVersion>"
        + "<updateRecordTimestamp>true</updateRecordTimestamp><executeWithOptimisticLocking>false</executeWithO"
        + "ptimisticLocking><executeWithOptimisticLockingExcludeUnversioned>false</executeWithOptimisticLocking"
        + "ExcludeUnversioned><attachRecords>true</attachRecords><updatablePrimaryKeys>false</updatablePrimaryKeys"
        + "><reflectionCaching>true</reflectionCaching><cacheRecordMappers>true</cacheRecordMappers><throwExceptions"
        + ">THROW_ALL</throwExceptions><fetchWarnings>true</fetchWarnings><fetchServerOutputSize>0</fetchServer"
        + "OutputSize><returnIdentityOnUpdatableRecord>true</returnIdentityOnUpdatableRecord><returnAllOnUpdatableRecord"
        + ">false</returnAllOnUpdatableRecord><returnRecordToPojo>true</returnRecordToPojo><mapJPAAnnotations"
        + ">true</mapJPAAnnotations><mapConstructorParameterNames>false</mapConstructorParameterNames>"
        + "<mapConstructorParameterNamesInKotlin>true</mapConstructorParameterNamesInKotlin><queryPoolable>DEFAULT"
        + "</queryPoolable><queryTimeout>0</queryTimeout><maxRows>0</maxRows><fetchSize>0</fetchSize><debugInfo"
        + "OnStackTrace>true</debugInfoOnStackTrace><inListPadding>false</inListPadding><inListPadBase>2<"
        + "/inListPadBase><delimiter>;</delimiter><emulateOnDuplicateKeyUpdateOnPrimaryKeyOnly>false</emulateOn"
        + "DuplicateKeyUpdateOnPrimaryKeyOnly><executeUpdateWithoutWhere>LOG_DEBUG</executeUpdateWithoutWhere>"
        + "<executeDeleteWithoutWhere>LOG_DEBUG</executeDeleteWithoutWhere><interpreterNameLookupCaseSensitivity"
        + ">DEFAULT</interpreterNameLookupCaseSensitivity><interpreterDelayForeignKeyDeclarations>false<"
        + "/interpreterDelayForeignKeyDeclarations><migrationAllowsUndo>false</migrationAllowsUndo><migrationRe"
        + "vertUntracked>false</migrationRevertUntracked><migrationAutoValidation>true</migrationAutoValidation"
        + "><parseNameCase>DEFAULT</parseNameCase><parseWithMetaLookups>OFF</parseWithMetaLookups><parseSetCommands"
        + ">false</parseSetCommands><parseUnsupportedSyntax>IGNORE</parseUnsupportedSyntax><parseUnknownFunctions"
        + ">FAIL</parseUnknownFunctions><parseIgnoreComments>false</parseIgnoreComments><parseIgnoreCommentStart>[jooq"
        + " ignore start]</parseIgnoreCommentStart><parseIgnoreCommentStop>[jooq ignore stop]</parseIgnoreCommentStop"
        + "><applyWorkaroundFor7962>true</applyWorkaroundFor7962>\n" + "]}",
        (new OrganisationalUnitDao(new DefaultDSLContext(SQLDialect.SQL99))).toString());
  }
}
