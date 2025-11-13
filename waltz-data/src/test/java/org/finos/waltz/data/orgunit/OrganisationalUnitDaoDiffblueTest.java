package org.finos.waltz.data.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.finos.waltz.schema.tables.records.OrganisationalUnitRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrganisationalUnitDaoDiffblueTest {
  /**
   * Test {@link OrganisationalUnitDao#findAll()}.
   *
   * <p>Method under test: {@link OrganisationalUnitDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<OrganisationalUnit> actualFindAllResult = new OrganisationalUnitDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitDao#getById(long)}.
   *
   * <p>Method under test: {@link OrganisationalUnitDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrganisationalUnit OrganisationalUnitDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    OrganisationalUnit actualById = new OrganisationalUnitDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableOrganisationalUnit);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
  }

  /**
   * Test {@link OrganisationalUnitDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link OrganisationalUnitDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrganisationalUnitDao.updateDescription(long, String)"})
  void testUpdateDescription_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    Integer actualUpdateDescriptionResult =
        new OrganisationalUnitDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"organisational_unit\" \"ou\" set \"ou\".\"description\" = cast(? as varchar) where \"ou\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Test {@link OrganisationalUnitDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link OrganisationalUnitDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrganisationalUnitDao.updateDescription(long, String)"})
  void testUpdateDescription_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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

    // Act
    Integer actualUpdateDescriptionResult =
        new OrganisationalUnitDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"organisational_unit\" \"ou\" set \"ou\".\"description\" = ? where \"ou\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Test {@link OrganisationalUnitDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link OrganisationalUnitDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String); then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrganisationalUnitDao.updateDescription(long, String)"})
  void testUpdateDescription_thenReturnIntValueIsOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<OrganisationalUnitRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<OrganisationalUnitRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<OrganisationalUnitRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<OrganisationalUnitRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Integer actualUpdateDescriptionResult =
        new OrganisationalUnitDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Test {@link OrganisationalUnitDao#findByIds(Long[])}.
   *
   * <p>Method under test: {@link OrganisationalUnitDao#findByIds(Long[])}
   */
  @Test
  @DisplayName("Test findByIds(Long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitDao.findByIds(Long[])"})
  void testFindByIds() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<OrganisationalUnit> actualFindByIdsResult = new OrganisationalUnitDao(dsl).findByIds(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitDao#toString()}.
   *
   * <p>Method under test: {@link OrganisationalUnitDao#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrganisationalUnitDao.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "OrganisationalUnitDao{dsl=DefaultConfiguration [\n"
            + "\tconnected=false,\n"
            + "\ttransactional=false,\n"
            + "\tdialect=SQL99,\n"
            + "\tdata={},\n"
            + "\tsettings=\n"
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
            + "><applyWorkaroundFor7962>true</applyWorkaroundFor7962>\n"
            + "]}",
        new OrganisationalUnitDao(new DefaultDSLContext(SQLDialect.SQL99)).toString());
  }
}
