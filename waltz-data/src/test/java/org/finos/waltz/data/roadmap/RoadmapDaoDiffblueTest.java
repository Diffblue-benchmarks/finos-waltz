package org.finos.waltz.data.roadmap;

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
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.model.roadmap.RoadmapAndScenarioOverview;
import org.finos.waltz.schema.tables.records.RoadmapRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectSeekStep1;
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
class RoadmapDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private RoadmapDao roadmapDao;

  /**
   * Test {@link RoadmapDao#findAll()}.
   *
   * <p>Method under test: {@link RoadmapDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RoadmapDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    Collection<Roadmap> actualFindAllResult = roadmapDao.findAll();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(objectList, actualFindAllResult);
  }

  /**
   * Test {@link RoadmapDao#findAllActive()}.
   *
   * <p>Method under test: {@link RoadmapDao#findAllActive()}
   */
  @Test
  @DisplayName("Test findAllActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RoadmapDao.findAllActive()"})
  void testFindAllActive() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    Collection<Roadmap> actualFindAllActiveResult = roadmapDao.findAllActive();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllActiveResult instanceof List);
    assertTrue(actualFindAllActiveResult.isEmpty());
    assertSame(objectList, actualFindAllActiveResult);
  }

  /**
   * Test {@link RoadmapDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    Boolean actualUpdateDescriptionResult = new RoadmapDao(dsl).updateDescription(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"roadmap\" set \"roadmap\".\"description\" = cast(? as varchar), \"roadmap\".\"last_updated_at\" = cast(? as datetime), \"roadmap\".\"last_updated_by\" = cast(? as varchar) where \"roadmap\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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

    // Act
    Boolean actualUpdateDescriptionResult = new RoadmapDao(dsl).updateDescription(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"roadmap\" set \"roadmap\".\"description\" = ?, \"roadmap\".\"last_updated_at\" = ?, \"roadmap\".\"last_updated_by\" = ? where \"roadmap\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateDescriptionResult = roadmapDao.updateDescription(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateConditionStep execute() return zero; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnZero_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateDescriptionResult = roadmapDao.updateDescription(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateName(long, String, String)"})
  void testUpdateName_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    Boolean actualUpdateNameResult = new RoadmapDao(dsl).updateName(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"roadmap\" set \"roadmap\".\"name\" = cast(? as varchar), \"roadmap\".\"last_updated_at\" = cast(? as datetime), \"roadmap\".\"last_updated_by\" = cast(? as varchar) where \"roadmap\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateName(long, String, String)"})
  void testUpdateName_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    Boolean actualUpdateNameResult = new RoadmapDao(dsl).updateName(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"roadmap\" set \"roadmap\".\"name\" = ?, \"roadmap\".\"last_updated_at\" = ?, \"roadmap\".\"last_updated_by\" = ? where \"roadmap\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateNameResult = roadmapDao.updateName(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateConditionStep execute() return zero; then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateConditionStepExecuteReturnZero_thenCallsUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateNameResult = roadmapDao.updateName(1L, "42", "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapDao.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        new RoadmapDao(dsl).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"roadmap\" set \"roadmap\".\"entity_lifecycle_status\" = cast(? as varchar), \"roadmap\".\"last_updated_at\" = cast(? as datetime), \"roadmap\".\"last_updated_by\" = cast(? as varchar) where \"roadmap\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapDao.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        new RoadmapDao(dsl).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"roadmap\" set \"roadmap\".\"entity_lifecycle_status\" = ?, \"roadmap\".\"last_updated_at\" = ?, \"roadmap\".\"last_updated_by\" = ? where \"roadmap\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); given UpdateConditionStep execute() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapDao.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_givenUpdateConditionStepExecuteReturnZero()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        roadmapDao.updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapDao#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapDao.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_thenReturnTrue() throws DataAccessException {
    // Arrange
    UpdateConditionStep<RoadmapRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<RoadmapRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<RoadmapRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<RoadmapRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        roadmapDao.updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapDao#findAllRoadmapsAndScenarios()}.
   *
   * <p>Method under test: {@link RoadmapDao#findAllRoadmapsAndScenarios()}
   */
  @Test
  @DisplayName("Test findAllRoadmapsAndScenarios()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RoadmapDao.findAllRoadmapsAndScenarios()"})
  void testFindAllRoadmapsAndScenarios() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindAllRoadmapsAndScenariosResult =
        roadmapDao.findAllRoadmapsAndScenarios();

    // Assert
    verify(dSLContext).selectDistinct(isA(Collection.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllRoadmapsAndScenariosResult instanceof List);
    assertTrue(actualFindAllRoadmapsAndScenariosResult.isEmpty());
  }

  /**
   * Test {@link RoadmapDao#findRoadmapsAndScenariosByRatedEntity(EntityReference)}.
   *
   * <p>Method under test: {@link RoadmapDao#findRoadmapsAndScenariosByRatedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findRoadmapsAndScenariosByRatedEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection RoadmapDao.findRoadmapsAndScenariosByRatedEntity(EntityReference)"
  })
  void testFindRoadmapsAndScenariosByRatedEntity() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindRoadmapsAndScenariosByRatedEntityResult =
        roadmapDao.findRoadmapsAndScenariosByRatedEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).selectDistinct(isA(Collection.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult.isEmpty());
  }

  /**
   * Test {@link RoadmapDao#findRoadmapsAndScenariosByRatedEntity(EntityReference)}.
   *
   * <p>Method under test: {@link RoadmapDao#findRoadmapsAndScenariosByRatedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findRoadmapsAndScenariosByRatedEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection RoadmapDao.findRoadmapsAndScenariosByRatedEntity(EntityReference)"
  })
  void testFindRoadmapsAndScenariosByRatedEntity2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindRoadmapsAndScenariosByRatedEntityResult =
        roadmapDao.findRoadmapsAndScenariosByRatedEntity(
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
    verify(dSLContext).selectDistinct(isA(Collection.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult.isEmpty());
  }

  /**
   * Test {@link RoadmapDao#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}.
   *
   * <p>Method under test: {@link
   * RoadmapDao#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}
   */
  @Test
  @DisplayName("Test findRoadmapsAndScenariosByFormalRelationship(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection RoadmapDao.findRoadmapsAndScenariosByFormalRelationship(EntityReference)"
  })
  void testFindRoadmapsAndScenariosByFormalRelationship() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Collection<RoadmapAndScenarioOverview>
        actualFindRoadmapsAndScenariosByFormalRelationshipResult =
            roadmapDao.findRoadmapsAndScenariosByFormalRelationship(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    verify(dSLContext).selectDistinct(isA(Collection.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult.isEmpty());
  }

  /**
   * Test {@link RoadmapDao#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}.
   *
   * <p>Method under test: {@link
   * RoadmapDao#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}
   */
  @Test
  @DisplayName("Test findRoadmapsAndScenariosByFormalRelationship(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection RoadmapDao.findRoadmapsAndScenariosByFormalRelationship(EntityReference)"
  })
  void testFindRoadmapsAndScenariosByFormalRelationship2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(Mockito.<Collection<SelectFieldOrAsterisk>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Collection<RoadmapAndScenarioOverview>
        actualFindRoadmapsAndScenariosByFormalRelationshipResult =
            roadmapDao.findRoadmapsAndScenariosByFormalRelationship(
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
    verify(dSLContext).selectDistinct(isA(Collection.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult.isEmpty());
  }
}
