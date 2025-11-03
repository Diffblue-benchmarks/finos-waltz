package org.finos.waltz.data.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.sql.Timestamp;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrganisationalUnitDaoDiffblueTest {
  /**
   * Test {@link OrganisationalUnitDao#findRelatedByEntityRef(EntityReference)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitDao#findRelatedByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityRef(EntityReference); given ResultSet getLong(int) return one; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OrganisationalUnitDao.findRelatedByEntityRef(EntityReference)"})
  void testFindRelatedByEntityRef_givenResultSetGetLongReturnOne_thenReturnSizeIsTwo() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<OrganisationalUnit> actualFindRelatedByEntityRefResult = organisationalUnitDao.findRelatedByEntityRef(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"ou\".\"id\", \"ou\".\"name\", \"ou\".\"description\", \"ou\".\"parent_id\", \"ou\".\"created_at\", \"ou\".\"last_updated_at\", \"ou\".\"external_id\", \"ou\".\"created_by\", \"ou\".\"last_updated_by\", \"ou\".\"provenance\" from \"organisational_unit\" \"ou\" where \"ou\".\"id\" in (select distinct \"ou\".\"id\" from \"organisational_unit\" \"ou\" join \"entity_relationship\" on ((\"ou\".\"id\" = \"entity_relationship\".\"id_a\" and \"entity_relationship\".\"kind_a\" = ?) or (\"ou\".\"id\" = \"entity_relationship\".\"id_b\" and \"entity_relationship\".\"kind_b\" = ?)) where ((\"entity_relationship\".\"id_a\" = ? and \"entity_relationship\".\"kind_a\" = ?) or (\"entity_relationship\".\"id_b\" = ? and \"entity_relationship\".\"kind_b\" = ?)))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    assertEquals(2, actualFindRelatedByEntityRefResult.size());
    OrganisationalUnit getResult = actualFindRelatedByEntityRefResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    OrganisationalUnit getResult2 = actualFindRelatedByEntityRefResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrganisationalUnit);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals(EntityKind.ORG_UNIT, getResult.kind());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link OrganisationalUnitDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getLong(int)} return one.</li>
   *   <li>Then return {@link ImmutableOrganisationalUnit}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrganisationalUnitDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet getLong(int) return one; then return ImmutableOrganisationalUnit")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OrganisationalUnit OrganisationalUnitDao.getById(long)"})
  void testGetById_givenResultSetGetLongReturnOne_thenReturnImmutableOrganisationalUnit() throws SQLException {
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
    OrganisationalUnitDao organisationalUnitDao = new OrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    OrganisationalUnit actualById = organisationalUnitDao.getById(1L);

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
    assertTrue(organisationalUnitDao.findAll().isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitDao#toString()}.
   * <p>
   * Method under test: {@link OrganisationalUnitDao#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OrganisationalUnitDao.toString()"})
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
