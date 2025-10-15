package org.finos.waltz.data.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.AttestationRun;
import org.finos.waltz.model.attestation.AttestationRunRecipient;
import org.finos.waltz.model.attestation.AttestationRunResponseSummary;
import org.finos.waltz.model.attestation.AttestationStatus;
import org.finos.waltz.schema.tables.records.AttestationRunRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
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
import org.jooq.impl.TableImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AttestationRunDaoDiffblueTest {
  @InjectMocks private AttestationRunDao attestationRunDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AttestationRunDao#findAll()}.
   *
   * <p>Method under test: {@link AttestationRunDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<AttestationRun> actualFindAllResult = attestationRunDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep2).fetch(isA(RecordMapper.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunDao#findByRecipient(String)}.
   *
   * <p>Method under test: {@link AttestationRunDao#findByRecipient(String)}
   */
  @Test
  @DisplayName("Test findByRecipient(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunDao.findByRecipient(String)"})
  void testFindByRecipient() throws DataAccessException {
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

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<AttestationRun> actualFindByRecipientResult = attestationRunDao.findByRecipient("42");

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByRecipientResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() throws DataAccessException {
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

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<AttestationRun> actualFindByEntityReferenceResult =
        attestationRunDao.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunDao#findResponseSummaries()}.
   *
   * <p>Method under test: {@link AttestationRunDao#findResponseSummaries()}
   */
  @Test
  @DisplayName("Test findResponseSummaries()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunDao.findResponseSummaries()"})
  void testFindResponseSummaries() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<AttestationRunResponseSummary> actualFindResponseSummariesResult =
        attestationRunDao.findResponseSummaries();

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    assertTrue(actualFindResponseSummariesResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunDao#getEntityCount(Select)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetchOne(RecordMapper)} return one.
   *   <li>When {@link Select}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#getEntityCount(Select)}
   */
  @Test
  @DisplayName(
      "Test getEntityCount(Select); given SelectJoinStep fetchOne(RecordMapper) return one; when Select; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.getEntityCount(Select)"})
  void testGetEntityCount_givenSelectJoinStepFetchOneReturnOne_whenSelect_thenReturnOne()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(1);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    int actualEntityCount = attestationRunDao.getEntityCount(mock(Select.class));

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectJoinStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertEquals(1, actualEntityCount);
  }

  /**
   * Test {@link AttestationRunDao#getEntityCount(Select)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#getEntityCount(Select)}
   */
  @Test
  @DisplayName("Test getEntityCount(Select); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.getEntityCount(Select)"})
  void testGetEntityCount_thenReturnMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    Select<Record1<Long>> idSelector = mock(Select.class);
    when(idSelector.asTable()).thenReturn(new TableImpl<>("Name"));

    // Act
    int actualEntityCount = attestationRunDao.getEntityCount(idSelector);

    // Assert
    verify(connection).prepareStatement("select count(*) \"entity_count\" from \"Name\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(idSelector).asTable();
    assertEquals(-1, actualEntityCount);
  }

  /**
   * Test {@link AttestationRunDao#findPendingRuns()}.
   *
   * <p>Method under test: {@link AttestationRunDao#findPendingRuns()}
   */
  @Test
  @DisplayName("Test findPendingRuns()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AttestationRunDao.findPendingRuns()"})
  void testFindPendingRuns() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<AttestationRun> actualFindPendingRunsResult = attestationRunDao.findPendingRuns();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep2).where(isA(Condition.class));
    assertTrue(actualFindPendingRunsResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatusForRunIds(Set, AttestationStatus); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(new HashSet<>(), AttestationStatus.DRAFT);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"attestation_run\" set \"attestation_run\".\"status\" = cast(? as varchar) where 1 = 0");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatusForRunIds(Set, AttestationStatus); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AttestationRunDao attestationRunDao = new AttestationRunDao(dsl);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(new HashSet<>(), AttestationStatus.DRAFT);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"attestation_run\" set \"attestation_run\".\"status\" = ? where \"attestation_run\".\"id\" in ()");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "DRAFT");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   *   <li>Then calls {@link UpdateSetMoreStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatusForRunIds(Set, AttestationStatus); given minus one; when HashSet() add minus one; then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_givenMinusOne_whenHashSetAddMinusOne_thenCallsSet()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<Long> runIds = new HashSet<>();
    runIds.add(-1L);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(runIds, AttestationStatus.ISSUED);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatusForRunIds(Set, AttestationStatus); given one; when HashSet() add one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_givenOne_whenHashSetAddOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<Long> runIds = new HashSet<>();
    runIds.add(1L);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(runIds, AttestationStatus.DRAFT);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatusForRunIds(Set, AttestationStatus); given zero; when HashSet() add zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_givenZero_whenHashSetAddZero_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    HashSet<Long> runIds = new HashSet<>();
    runIds.add(0L);
    runIds.add(1L);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(runIds, AttestationStatus.DRAFT);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>Then calls {@link UpdateSetMoreStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName("Test updateStatusForRunIds(Set, AttestationStatus); then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_thenCallsSet() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(new HashSet<>(), AttestationStatus.ISSUED);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateStatusForRunIds(Set, AttestationStatus)}
   */
  @Test
  @DisplayName(
      "Test updateStatusForRunIds(Set, AttestationStatus); when HashSet(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateStatusForRunIds(Set, AttestationStatus)"})
  void testUpdateStatusForRunIds_whenHashSet_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateStatusForRunIdsResult =
        attestationRunDao.updateStatusForRunIds(new HashSet<>(), AttestationStatus.DRAFT);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateStatusForRunIdsResult);
  }

  /**
   * Test {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <p>Method under test: {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId() throws SQLException {
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
        new AttestationRunDao(dsl).updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"attestation_run\" set \"attestation_run\".\"recipient_involvement_group_id\" = ? where \"attestation_run\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <p>Method under test: {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId2() throws SQLException {
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
    int actualUpdateRecipientInvolvementGroupIdResult =
        new AttestationRunDao(dsl).updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"attestation_run\" set \"attestation_run\".\"recipient_involvement_group_id\" = cast(? as bigint) where \"attestation_run\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        attestationRunDao.updateRecipientInvolvementGroupId(1L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        attestationRunDao.updateRecipientInvolvementGroupId(4L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_whenThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        attestationRunDao.updateRecipientInvolvementGroupId(3L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunDao#updateRecipientInvolvementGroupId(long, Long)}
   */
  @Test
  @DisplayName("Test updateRecipientInvolvementGroupId(long, Long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunDao.updateRecipientInvolvementGroupId(long, Long)"})
  void testUpdateRecipientInvolvementGroupId_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<AttestationRunRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<AttestationRunRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<AttestationRunRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<AttestationRunRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateRecipientInvolvementGroupIdResult =
        attestationRunDao.updateRecipientInvolvementGroupId(2L, 1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(3, actualUpdateRecipientInvolvementGroupIdResult);
  }

  /**
   * Test {@link AttestationRunDao#findRunRecipients(long)}.
   *
   * <p>Method under test: {@link AttestationRunDao#findRunRecipients(long)}
   */
  @Test
  @DisplayName("Test findRunRecipients(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AttestationRunDao.findRunRecipients(long)"})
  void testFindRunRecipients() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<AttestationRunRecipient> actualFindRunRecipientsResult =
        attestationRunDao.findRunRecipients(1L);

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRunRecipientsResult.isEmpty());
  }
}
