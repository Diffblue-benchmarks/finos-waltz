package org.finos.waltz.data.physical_flow_participant;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.physical_flow_participant.ParticipationKind;
import org.finos.waltz.model.physical_flow_participant.PhysicalFlowParticipant;
import org.finos.waltz.schema.tables.records.PhysicalFlowParticipantRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
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
class PhysicalFlowParticipantDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalFlowParticipantDao physicalFlowParticipantDao;

  /**
   * Test {@link PhysicalFlowParticipantDao#findByPhysicalFlowId(long)}.
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#findByPhysicalFlowId(long)}
   */
  @Test
  @DisplayName("Test findByPhysicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowParticipantDao.findByPhysicalFlowId(long)"})
  void testFindByPhysicalFlowId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByPhysicalFlowIdResult =
        new PhysicalFlowParticipantDao(dsl).findByPhysicalFlowId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByPhysicalFlowIdResult instanceof List);
    assertTrue(actualFindByPhysicalFlowIdResult.isEmpty());
    assertSame(objectList, actualFindByPhysicalFlowIdResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#findByParticipant(EntityReference)}.
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#findByParticipant(EntityReference)}
   */
  @Test
  @DisplayName("Test findByParticipant(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowParticipantDao.findByParticipant(EntityReference)"})
  void testFindByParticipant() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByParticipantResult =
        physicalFlowParticipantDao.findByParticipant(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParticipantResult instanceof List);
    assertTrue(actualFindByParticipantResult.isEmpty());
    assertSame(objectList, actualFindByParticipantResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#findByParticipant(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowParticipantDao#PhysicalFlowParticipantDao(DSLContext)} with dsl
   *       is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#findByParticipant(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByParticipant(EntityReference); given PhysicalFlowParticipantDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowParticipantDao.findByParticipant(EntityReference)"})
  void testFindByParticipant_givenPhysicalFlowParticipantDaoWithDslIsDSLContext()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByParticipantResult =
        physicalFlowParticipantDao.findByParticipant(
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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParticipantResult instanceof List);
    assertTrue(actualFindByParticipantResult.isEmpty());
    assertSame(objectList, actualFindByParticipantResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, ParticipationKind, EntityReference); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalFlowParticipantDao.remove(long, ParticipationKind, EntityReference)"
  })
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<PhysicalFlowParticipantRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalFlowParticipantRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    boolean actualRemoveResult =
        physicalFlowParticipantDao.remove(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, ParticipationKind, EntityReference); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalFlowParticipantDao.remove(long, ParticipationKind, EntityReference)"
  })
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<PhysicalFlowParticipantRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<PhysicalFlowParticipantRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<PhysicalFlowParticipantRecord>>any()))
        .thenReturn(deleteUsingStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    boolean actualRemoveResult =
        physicalFlowParticipantDao.remove(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#remove(long, ParticipationKind,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test remove(long, ParticipationKind, EntityReference); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalFlowParticipantDao.remove(long, ParticipationKind, EntityReference)"
  })
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
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
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    boolean actualRemoveResult =
        physicalFlowParticipantDao.remove(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"physical_flow_participant\" where (\"physical_flow_participant\".\"physical_flow_id\" = ? and \"physical_flow_participant\".\"kind\" = ? and \"physical_flow_participant\".\"participant_entity_id\" = ? and \"physical_flow_participant\".\"participant_entity_kind\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#add(long, ParticipationKind, EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#add(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test add(long, ParticipationKind, EntityReference, String); given InsertSetMoreStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalFlowParticipantDao.add(long, ParticipationKind, EntityReference, String)"
  })
  void testAdd_givenInsertSetMoreStepExecuteReturnOne_thenReturnTrue() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep3 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep4 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep5 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep6 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep7 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep8 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetStep<PhysicalFlowParticipantRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<PhysicalFlowParticipantRecord>>any()))
        .thenReturn(insertSetStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    boolean actualAddResult =
        physicalFlowParticipantDao.add(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#add(long, ParticipationKind, EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#add(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test add(long, ParticipationKind, EntityReference, String); given InsertSetMoreStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalFlowParticipantDao.add(long, ParticipationKind, EntityReference, String)"
  })
  void testAdd_givenInsertSetMoreStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(0);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep3 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep4 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep5 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep6 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep7 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<PhysicalFlowParticipantRecord> insertSetMoreStep8 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetStep<PhysicalFlowParticipantRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<PhysicalFlowParticipantRecord>>any()))
        .thenReturn(insertSetStep);
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    boolean actualAddResult =
        physicalFlowParticipantDao.add(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantDao#add(long, ParticipationKind, EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantDao#add(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test add(long, ParticipationKind, EntityReference, String); given PreparedStatement execute() return 'true'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalFlowParticipantDao.add(long, ParticipationKind, EntityReference, String)"
  })
  void testAdd_givenPreparedStatementExecuteReturnTrue_thenCallsPrepareStatement()
      throws SQLException {
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
    PhysicalFlowParticipantDao physicalFlowParticipantDao = new PhysicalFlowParticipantDao(dsl);

    // Act
    boolean actualAddResult =
        physicalFlowParticipantDao.add(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"physical_flow_participant\" (\"physical_flow_id\", \"kind\", \"participant_entity_kind\", \"participant_entity_id\", \"provenance\", \"description\", \"last_updated_at\", \"last_updated_by\") values (?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(7), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualAddResult);
  }
}
