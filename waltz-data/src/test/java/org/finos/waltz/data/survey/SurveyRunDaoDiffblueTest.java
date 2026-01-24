package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyRun;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyRun;
import org.finos.waltz.model.survey.SurveyRunChangeCommand;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.finos.waltz.schema.tables.records.SurveyRunRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyRunDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyRunDao surveyRunDao;

  /**
   * Test {@link SurveyRunDao#getById(long)}.
   *
   * <p>Method under test: {@link SurveyRunDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyRun SurveyRunDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(approvalDueDate)
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(dueDate)
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    SurveyRun actualById = surveyRunDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).where(isA(Condition.class));
    assertTrue(actualById.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertTrue(actualById instanceof ImmutableSurveyRun);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals("jane.doe@example.org", actualById.contactEmail());
    assertEquals(1L, actualById.ownerId().longValue());
    assertEquals(1L, actualById.surveyTemplateId().longValue());
    assertEquals(SurveyIssuanceKind.GROUP, actualById.issuanceKind());
    assertEquals(SurveyRunStatus.DRAFT, actualById.status());
    assertFalse(actualById.isDefault());
    Set<Long> involvementKindIdsResult = actualById.involvementKindIds();
    assertTrue(involvementKindIdsResult.isEmpty());
    assertSame(involvementKindIdsResult, actualById.ownerInvKindIds());
    assertSame(approvalDueDate, actualById.approvalDueDate());
    assertSame(dueDate, actualById.dueDate());
  }

  /**
   * Test {@link SurveyRunDao#findForRecipient(long)}.
   *
   * <p>Method under test: {@link SurveyRunDao#findForRecipient(long)}
   */
  @Test
  @DisplayName("Test findForRecipient(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunDao.findForRecipient(long)"})
  void testFindForRecipient() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<SurveyRun> actualFindForRecipientResult = surveyRunDao.findForRecipient(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
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
    int actualDeleteResult = new SurveyRunDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"survey_run\" where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link SurveyRunDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
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

    // Act
    int actualDeleteResult = new SurveyRunDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"survey_run\" where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link SurveyRunDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.delete(long)"})
  void testDelete_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<SurveyRunRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<SurveyRunRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteResult = new SurveyRunDao(dsl).delete(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link SurveyRunDao#update(long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#update(long, SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, SurveyRunChangeCommand); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.update(long, SurveyRunChangeCommand)"})
  void testUpdate_givenPreparedStatementExecuteReturnTrue_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    SurveyRunDao surveyRunDao = new SurveyRunDao(dsl);

    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.contactEmail()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.approvalDueDate()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.dueDate()).thenReturn(ofResult3);
    when(command.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(command.selectionOptions())
        .thenReturn(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act
    int actualUpdateResult = surveyRunDao.update(1L, command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"name\" = ?, \"survey_run\".\"description\" = ?, \"survey_run\".\"selector_entity_kind\" = ?, \"survey_run\".\"selector_entity_id\" = ?, \"survey_run\".\"selector_hierarchy_scope\" = ?, \"survey_run\".\"due_date\" = ?, \"survey_run\".\"approval_due_date\" = ?, \"survey_run\".\"issuance_kind\" = ?, \"survey_run\".\"contact_email\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setDate(anyInt(), isA(Date.class));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).name();
    verify(command).approvalDueDate();
    verify(command).contactEmail();
    verify(command).dueDate();
    verify(command).issuanceKind();
    verify(command, atLeast(1)).selectionOptions();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link SurveyRunDao#update(long, SurveyRunChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#update(long, SurveyRunChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(long, SurveyRunChangeCommand); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.update(long, SurveyRunChangeCommand)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep7 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep8 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep7);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep9 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep8);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep9);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);
    SurveyRunDao surveyRunDao = new SurveyRunDao(dsl);

    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.contactEmail()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.approvalDueDate()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.dueDate()).thenReturn(ofResult3);
    when(command.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(command.selectionOptions())
        .thenReturn(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Act
    int actualUpdateResult = surveyRunDao.update(1L, command);

    // Assert
    verify(command).description();
    verify(command).name();
    verify(command).approvalDueDate();
    verify(command).contactEmail();
    verify(command).dueDate();
    verify(command).issuanceKind();
    verify(command, atLeast(1)).selectionOptions();
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyRunDao#updateStatus(long, SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateStatus(long, SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, SurveyRunStatus); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateStatus(long, SurveyRunStatus)"})
  void testUpdateStatus_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
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
    int actualUpdateStatusResult = new SurveyRunDao(dsl).updateStatus(1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"status\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyRunDao#updateStatus(long, SurveyRunStatus)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateStatus(long, SurveyRunStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, SurveyRunStatus); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateStatus(long, SurveyRunStatus)"})
  void testUpdateStatus_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusResult = new SurveyRunDao(dsl).updateStatus(1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyRunDao#updateDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateDueDate(long, LocalDate); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateDueDate(long, LocalDate)"})
  void testUpdateDueDate_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateDueDateResult =
        new SurveyRunDao(dsl).updateDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"due_date\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDueDateResult);
  }

  /**
   * Test {@link SurveyRunDao#updateDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateDueDate(long, LocalDate); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateDueDate(long, LocalDate)"})
  void testUpdateDueDate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDueDateResult =
        new SurveyRunDao(dsl).updateDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDueDateResult);
  }

  /**
   * Test {@link SurveyRunDao#updateDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateDueDate(long, LocalDate); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateDueDate(long, LocalDate)"})
  void testUpdateDueDate_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDueDateResult = new SurveyRunDao(dsl).updateDueDate(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDueDateResult);
  }

  /**
   * Test {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDate(long, LocalDate); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_givenPreparedStatementExecuteReturnTrue_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateApprovalDueDateResult =
        new SurveyRunDao(dsl).updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"approval_due_date\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(1), isA(Date.class));
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName(
      "Test updateApprovalDueDate(long, LocalDate); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateResult =
        new SurveyRunDao(dsl).updateApprovalDueDate(1L, LocalDate.of(1970, 1, 1));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateApprovalDueDate(long, LocalDate)}
   */
  @Test
  @DisplayName("Test updateApprovalDueDate(long, LocalDate); when 'null'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateApprovalDueDate(long, LocalDate)"})
  void testUpdateApprovalDueDate_whenNull_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateApprovalDueDateResult = new SurveyRunDao(dsl).updateApprovalDueDate(1L, null);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), (Object) isNull());
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateApprovalDueDateResult);
  }

  /**
   * Test {@link SurveyRunDao#issue(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#issue(long)}
   */
  @Test
  @DisplayName(
      "Test issue(long); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.issue(long)"})
  void testIssue_givenPreparedStatementExecuteReturnTrue_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setDate(anyInt(), Mockito.<Date>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualIssueResult = new SurveyRunDao(dsl).issue(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"status\" = ?, \"survey_run\".\"issued_on\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setDate(eq(2), isA(Date.class));
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement).setString(1, "ISSUED");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualIssueResult);
  }

  /**
   * Test {@link SurveyRunDao#issue(long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#issue(long)}
   */
  @Test
  @DisplayName("Test issue(long); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.issue(long)"})
  void testIssue_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualIssueResult = new SurveyRunDao(dsl).issue(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualIssueResult);
  }

  /**
   * Test {@link SurveyRunDao#findByTemplateId(long)}.
   *
   * <p>Method under test: {@link SurveyRunDao#findByTemplateId(long)}
   */
  @Test
  @DisplayName("Test findByTemplateId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyRunDao.findByTemplateId(long)"})
  void testFindByTemplateId() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<SurveyRun> actualFindByTemplateIdResult = surveyRunDao.findByTemplateId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).where(isA(Condition.class));
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Test {@link SurveyRunDao#getOwnerInvolvementGroupId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#getOwnerInvolvementGroupId(long)}
   */
  @Test
  @DisplayName("Test getOwnerInvolvementGroupId(long); then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyRunDao.getOwnerInvolvementGroupId(long)"})
  void testGetOwnerInvolvementGroupId_thenReturnLongValueIsMinusOne() throws SQLException {
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
    Long actualOwnerInvolvementGroupId = new SurveyRunDao(dsl).getOwnerInvolvementGroupId(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"survey_run\".\"owner_involvement_group_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1L, actualOwnerInvolvementGroupId.longValue());
  }

  /**
   * Test {@link SurveyRunDao#getOwnerInvolvementGroupId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#getOwnerInvolvementGroupId(long)}
   */
  @Test
  @DisplayName("Test getOwnerInvolvementGroupId(long); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyRunDao.getOwnerInvolvementGroupId(long)"})
  void testGetOwnerInvolvementGroupId_thenReturnLongValueIsOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(1L);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Long actualOwnerInvolvementGroupId = new SurveyRunDao(dsl).getOwnerInvolvementGroupId(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
    assertEquals(1L, actualOwnerInvolvementGroupId.longValue());
  }

  /**
   * Test {@link SurveyRunDao#getRecipientInvolvementGroupId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#getRecipientInvolvementGroupId(long)}
   */
  @Test
  @DisplayName("Test getRecipientInvolvementGroupId(long); then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyRunDao.getRecipientInvolvementGroupId(long)"})
  void testGetRecipientInvolvementGroupId_thenReturnLongValueIsMinusOne() throws SQLException {
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
    Long actualRecipientInvolvementGroupId =
        new SurveyRunDao(dsl).getRecipientInvolvementGroupId(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select \"survey_run\".\"recipient_involvement_group_id\" from \"survey_run\" where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1L, actualRecipientInvolvementGroupId.longValue());
  }

  /**
   * Test {@link SurveyRunDao#getRecipientInvolvementGroupId(long)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#getRecipientInvolvementGroupId(long)}
   */
  @Test
  @DisplayName("Test getRecipientInvolvementGroupId(long); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SurveyRunDao.getRecipientInvolvementGroupId(long)"})
  void testGetRecipientInvolvementGroupId_thenReturnLongValueIsOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(1L);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Long actualRecipientInvolvementGroupId =
        new SurveyRunDao(dsl).getRecipientInvolvementGroupId(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
    assertEquals(1L, actualRecipientInvolvementGroupId.longValue());
  }

  /**
   * Test {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateOwnerInvolvementGroupId(long, Long); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateOwnerInvolvementGroupId(long, Long)"})
  void testUpdateOwnerInvolvementGroupId_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateOwnerInvolvementGroupId(1L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateOwnerInvolvementGroupId(long, Long); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateOwnerInvolvementGroupId(long, Long)"})
  void testUpdateOwnerInvolvementGroupId_thenReturnZero() throws SQLException {
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
    int actualUpdateOwnerInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateOwnerInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"owner_involvement_group_id\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateOwnerInvolvementGroupId(long, Long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateOwnerInvolvementGroupId(long, Long)"})
  void testUpdateOwnerInvolvementGroupId_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateOwnerInvolvementGroupId(4L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateOwnerInvolvementGroupId(long, Long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateOwnerInvolvementGroupId(long, Long)"})
  void testUpdateOwnerInvolvementGroupId_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateOwnerInvolvementGroupId(3L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateOwnerInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateOwnerInvolvementGroupId(long, Long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateOwnerInvolvementGroupId(long, Long)"})
  void testUpdateOwnerInvolvementGroupId_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateOwnerInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateOwnerInvolvementGroupId(2L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateOwnerInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_thenReturnZero() throws SQLException {
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
    int actualUpdateRecipientInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"survey_run\" set \"survey_run\".\"recipient_involvement_group_id\" = ? where \"survey_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateRecipientInvolvementGroupId(4L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_whenThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateRecipientInvolvementGroupId(3L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<SurveyRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<SurveyRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<SurveyRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<SurveyRunRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        new SurveyRunDao(dsl).updateRecipientInvolvementGroupId(2L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }
}
