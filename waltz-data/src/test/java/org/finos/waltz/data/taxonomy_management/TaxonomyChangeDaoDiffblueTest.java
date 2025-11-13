package org.finos.waltz.data.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeLifecycleStatus;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.schema.tables.records.TaxonomyChangeRecord;
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

class TaxonomyChangeDaoDiffblueTest {
  /**
   * Test {@link TaxonomyChangeDao#removeById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#removeById(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeDao.removeById(long, String)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualRemoveByIdResult = new TaxonomyChangeDao(dsl).removeById(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"status\" = cast(? as varchar), \"taxonomy_change\".\"last_updated_at\" = cast(? as datetime), \"taxonomy_change\".\"last_updated_by\" = cast(? as varchar) where \"taxonomy_change\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#removeById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#removeById(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeDao.removeById(long, String)"})
  void testRemoveById_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualRemoveByIdResult = new TaxonomyChangeDao(dsl).removeById(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"status\" = ?, \"taxonomy_change\".\"last_updated_at\" = ?, \"taxonomy_change\".\"last_updated_by\" = ? where \"taxonomy_change\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#removeById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#removeById(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeDao.removeById(long, String)"})
  void testRemoveById_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<TaxonomyChangeRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<TaxonomyChangeRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<TaxonomyChangeRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<TaxonomyChangeRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<TaxonomyChangeRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<TaxonomyChangeRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualRemoveByIdResult = new TaxonomyChangeDao(dsl).removeById(1L, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#getDraftCommandById(long)}.
   *
   * <p>Method under test: {@link TaxonomyChangeDao#getDraftCommandById(long)}
   */
  @Test
  @DisplayName("Test getDraftCommandById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.getDraftCommandById(long)"})
  void testGetDraftCommandById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    TaxonomyChangeCommand actualDraftCommandById =
        new TaxonomyChangeDao(dsl).getDraftCommandById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    EntityReference changeDomainResult = actualDraftCommandById.changeDomain();
    assertTrue(changeDomainResult instanceof ImmutableEntityReference);
    EntityReference primaryReferenceResult = actualDraftCommandById.primaryReference();
    assertTrue(primaryReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualDraftCommandById instanceof ImmutableTaxonomyChangeCommand);
    assertEquals("2020-03-01", actualDraftCommandById.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualDraftCommandById.createdBy());
    assertEquals("The characteristics of someone or something", changeDomainResult.description());
    assertEquals(1L, changeDomainResult.id());
    assertEquals(EntityKind.ALL, changeDomainResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, changeDomainResult.entityLifecycleStatus());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, actualDraftCommandById.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, actualDraftCommandById.changeType());
    assertTrue(actualDraftCommandById.params().isEmpty());
    assertEquals(changeDomainResult, primaryReferenceResult);
    assertSame(ofResult, actualDraftCommandById.createdAt().toLocalDate());
    assertSame(ofResult2, actualDraftCommandById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link TaxonomyChangeDao#findChangesByDomain(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#findChangesByDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test findChangesByDomain(EntityReference); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection TaxonomyChangeDao.findChangesByDomain(EntityReference)"})
  void testFindChangesByDomain_thenReturnList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    // Act
    Collection<TaxonomyChangeCommand> actualFindChangesByDomainResult =
        taxonomyChangeDao.findChangesByDomain(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindChangesByDomainResult instanceof List);
    assertTrue(actualFindChangesByDomainResult.isEmpty());
    assertSame(objectList, actualFindChangesByDomainResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#findChangesByDomainAndStatus(EntityReference,
   * TaxonomyChangeLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#findChangesByDomainAndStatus(EntityReference,
   * TaxonomyChangeLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test findChangesByDomainAndStatus(EntityReference, TaxonomyChangeLifecycleStatus); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection TaxonomyChangeDao.findChangesByDomainAndStatus(EntityReference, TaxonomyChangeLifecycleStatus)"
  })
  void testFindChangesByDomainAndStatus_thenReturnList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    // Act
    Collection<TaxonomyChangeCommand> actualFindChangesByDomainAndStatusResult =
        taxonomyChangeDao.findChangesByDomainAndStatus(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            TaxonomyChangeLifecycleStatus.DRAFT);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindChangesByDomainAndStatusResult instanceof List);
    assertTrue(actualFindChangesByDomainAndStatusResult.isEmpty());
    assertSame(objectList, actualFindChangesByDomainAndStatusResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(TaxonomyChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.update(TaxonomyChangeCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    TaxonomyChangeCommand actualUpdateResult = taxonomyChangeDao.update(cmd);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"change_type\" = cast(? as varchar), \"taxonomy_change\".\"description\" = cast(? as varchar), \"taxonomy_change\".\"domain_kind\" = cast(? as varchar), \"taxonomy_change\".\"domain_id\" = cast(? as bigint), \"taxonomy_change\".\"primary_reference_kind\" = cast(? as varchar), \"taxonomy_change\".\"primary_reference_id\" = cast(? as bigint), \"taxonomy_change\".\"status\" = cast(? as varchar), \"taxonomy_change\".\"params\" = cast(? as varchar), \"taxonomy_change\".\"created_at\" = cast(? as datetime), \"taxonomy_change\".\"created_by\" = cast(? as varchar), \"taxonomy_change\".\"last_updated_at\" = cast(? as datetime), \"taxonomy_change\".\"last_updated_by\" = cast(? as varchar) where \"taxonomy_change\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertSame(cmd, actualUpdateResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(TaxonomyChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.update(TaxonomyChangeCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    TaxonomyChangeCommand actualUpdateResult = taxonomyChangeDao.update(cmd);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"change_type\" = cast(? as varchar(8)), \"taxonomy_change\".\"description\" = cast(? as varchar(1)), \"taxonomy_change\".\"domain_kind\" = cast(? as varchar(3)), \"taxonomy_change\".\"domain_id\" = cast(? as bigint), \"taxonomy_change\".\"primary_reference_kind\" = cast(? as varchar(3)), \"taxonomy_change\".\"primary_reference_id\" = cast(? as bigint), \"taxonomy_change\".\"status\" = cast(? as varchar(5)), \"taxonomy_change\".\"params\" = cast(? as varchar(2)), \"taxonomy_change\".\"created_at\" = cast(? as timestamp), \"taxonomy_change\".\"created_by\" = cast(? as varchar(27)), \"taxonomy_change\".\"last_updated_at\" = cast(? as timestamp), \"taxonomy_change\".\"last_updated_by\" = cast(? as varchar(10)) where \"taxonomy_change\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertSame(cmd, actualUpdateResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(TaxonomyChangeCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.update(TaxonomyChangeCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    TaxonomyChangeCommand actualUpdateResult = taxonomyChangeDao.update(cmd);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"change_type\" = ?, \"taxonomy_change\".\"description\" = ?, \"taxonomy_change\".\"domain_kind\" = ?, \"taxonomy_change\".\"domain_id\" = ?, \"taxonomy_change\".\"primary_reference_kind\" = ?, \"taxonomy_change\".\"primary_reference_id\" = ?, \"taxonomy_change\".\"status\" = ?, \"taxonomy_change\".\"params\" = ?, \"taxonomy_change\".\"created_at\" = ?, \"taxonomy_change\".\"created_by\" = ?, \"taxonomy_change\".\"last_updated_at\" = ?, \"taxonomy_change\".\"last_updated_by\" = ? where \"taxonomy_change\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertSame(cmd, actualUpdateResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>Then primaryReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(TaxonomyChangeCommand); given 'Key'; then primaryReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.update(TaxonomyChangeCommand)"})
  void testUpdate_givenKey_thenPrimaryReferenceReturnImmutableEntityReference()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    HashMap<String, String> entries = new HashMap<>();
    entries.put("Key", "42");

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder paramsResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .params(entries);

    // Act
    TaxonomyChangeCommand actualUpdateResult =
        taxonomyChangeDao.update(
            paramsResult
                .primaryReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .status(TaxonomyChangeLifecycleStatus.DRAFT)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"change_type\" = ?, \"taxonomy_change\".\"description\" = ?, \"taxonomy_change\".\"domain_kind\" = ?, \"taxonomy_change\".\"domain_id\" = ?, \"taxonomy_change\".\"primary_reference_kind\" = ?, \"taxonomy_change\".\"primary_reference_id\" = ?, \"taxonomy_change\".\"status\" = ?, \"taxonomy_change\".\"params\" = ?, \"taxonomy_change\".\"created_at\" = ?, \"taxonomy_change\".\"created_by\" = ?, \"taxonomy_change\".\"last_updated_at\" = ?, \"taxonomy_change\".\"last_updated_by\" = ? where \"taxonomy_change\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertTrue(actualUpdateResult.primaryReference() instanceof ImmutableEntityReference);
    assertTrue(actualUpdateResult instanceof ImmutableTaxonomyChangeCommand);
    Map<String, String> paramsResult2 = actualUpdateResult.params();
    assertEquals(1, paramsResult2.size());
    assertEquals("42", paramsResult2.get("Key"));
  }

  /**
   * Test {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(TaxonomyChangeCommand); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.update(TaxonomyChangeCommand)"})
  void testUpdate_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    TaxonomyChangeCommand actualUpdateResult = taxonomyChangeDao.update(cmd);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"change_type\" = ?, \"taxonomy_change\".\"description\" = ?, \"taxonomy_change\".\"domain_kind\" = ?, \"taxonomy_change\".\"domain_id\" = ?, \"taxonomy_change\".\"primary_reference_kind\" = ?, \"taxonomy_change\".\"primary_reference_id\" = ?, \"taxonomy_change\".\"status\" = ?, \"taxonomy_change\".\"params\" = ?, \"taxonomy_change\".\"created_at\" = ?, \"taxonomy_change\".\"created_by\" = ?, \"taxonomy_change\".\"last_updated_at\" = ?, \"taxonomy_change\".\"last_updated_by\" = ? where \"taxonomy_change\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertSame(cmd, actualUpdateResult);
  }

  /**
   * Test {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeDao#update(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(TaxonomyChangeCommand); given PreparedStatement getWarnings() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TaxonomyChangeCommand TaxonomyChangeDao.update(TaxonomyChangeCommand)"})
  void testUpdate_givenPreparedStatementGetWarningsReturnNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    TaxonomyChangeDao taxonomyChangeDao = new TaxonomyChangeDao(dsl);

    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());
    ImmutableTaxonomyChangeCommand cmd =
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build();

    // Act
    TaxonomyChangeCommand actualUpdateResult = taxonomyChangeDao.update(cmd);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"taxonomy_change\" set \"taxonomy_change\".\"change_type\" = ?, \"taxonomy_change\".\"description\" = ?, \"taxonomy_change\".\"domain_kind\" = ?, \"taxonomy_change\".\"domain_id\" = ?, \"taxonomy_change\".\"primary_reference_kind\" = ?, \"taxonomy_change\".\"primary_reference_id\" = ?, \"taxonomy_change\".\"status\" = ?, \"taxonomy_change\".\"params\" = ?, \"taxonomy_change\".\"created_at\" = ?, \"taxonomy_change\".\"created_by\" = ?, \"taxonomy_change\".\"last_updated_at\" = ?, \"taxonomy_change\".\"last_updated_by\" = ? where \"taxonomy_change\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertSame(cmd, actualUpdateResult);
  }
}
