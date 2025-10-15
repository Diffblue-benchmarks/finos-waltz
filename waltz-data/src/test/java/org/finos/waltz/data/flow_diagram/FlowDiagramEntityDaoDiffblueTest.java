package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.finos.waltz.schema.tables.records.FlowDiagramEntityRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
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
class FlowDiagramEntityDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private FlowDiagramEntityDao flowDiagramEntityDao;

  /**
   * Test {@link FlowDiagramEntityDao#findForDiagram(long)}.
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#findForDiagram(long)}
   */
  @Test
  @DisplayName("Test findForDiagram(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityDao.findForDiagram(long)"})
  void testFindForDiagram() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<FlowDiagramEntity> actualFindForDiagramResult = flowDiagramEntityDao.findForDiagram(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForDiagramResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityDao.findForEntity(EntityReference)"})
  void testFindForEntity() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<FlowDiagramEntity> actualFindForEntityResult =
        flowDiagramEntityDao.findForEntity(
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
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramEntityDao.findForEntity(EntityReference)"})
  void testFindForEntity2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<FlowDiagramEntity> actualFindForEntityResult =
        flowDiagramEntityDao.findForEntity(
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
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramEntityDao#createEntities(List)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#createEntities(List)}
   */
  @Test
  @DisplayName("Test createEntities(List); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] FlowDiagramEntityDao.createEntities(List)"})
  void testCreateEntities_thenReturnEmptyArrayOfInt() {
    // Arrange
    FlowDiagramEntityDao flowDiagramEntityDao =
        new FlowDiagramEntityDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, flowDiagramEntityDao.createEntities(new ArrayList<>()));
  }

  /**
   * Test {@link FlowDiagramEntityDao#deleteForDiagram(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#deleteForDiagram(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForDiagram(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramEntityDao.deleteForDiagram(long)"})
  void testDeleteForDiagram_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualDeleteForDiagramResult = new FlowDiagramEntityDao(dsl).deleteForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_entity\" where (\"flow_diagram_entity\".\"diagram_id\" = ? and \"flow_diagram_entity\".\"entity_kind\" not in (?, ?, ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramEntityDao#deleteForDiagram(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#deleteForDiagram(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForDiagram(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramEntityDao.deleteForDiagram(long)"})
  void testDeleteForDiagram_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    int actualDeleteForDiagramResult = new FlowDiagramEntityDao(dsl).deleteForDiagram(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_diagram_entity\" where (\"flow_diagram_entity\".\"diagram_id\" = ? and \"flow_diagram_entity\".\"entity_kind\" not in (?, ?, ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramEntityDao#deleteForDiagram(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#deleteForDiagram(long)}
   */
  @Test
  @DisplayName(
      "Test deleteForDiagram(long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowDiagramEntityDao.deleteForDiagram(long)"})
  void testDeleteForDiagram_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<FlowDiagramEntityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<FlowDiagramEntityRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualDeleteForDiagramResult = flowDiagramEntityDao.deleteForDiagram(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramEntityDao#deleteEntityForDiagram(long, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#deleteEntityForDiagram(long,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityForDiagram(long, EntityReference); given DeleteConditionStep execute() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityDao.deleteEntityForDiagram(long, EntityReference)"})
  void testDeleteEntityForDiagram_givenDeleteConditionStepExecuteReturnZero()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<FlowDiagramEntityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<FlowDiagramEntityRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteEntityForDiagramResult =
        flowDiagramEntityDao.deleteEntityForDiagram(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualDeleteEntityForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramEntityDao#deleteEntityForDiagram(long, EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#deleteEntityForDiagram(long,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test deleteEntityForDiagram(long, EntityReference); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityDao.deleteEntityForDiagram(long, EntityReference)"})
  void testDeleteEntityForDiagram_thenCallsPrepareStatement() throws SQLException {
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
    FlowDiagramEntityDao flowDiagramEntityDao = new FlowDiagramEntityDao(dsl);

    // Act
    boolean actualDeleteEntityForDiagramResult =
        flowDiagramEntityDao.deleteEntityForDiagram(
            1L,
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
            "delete from \"flow_diagram_entity\" where (\"flow_diagram_entity\".\"diagram_id\" = ? and \"flow_diagram_entity\".\"entity_kind\" = ? and \"flow_diagram_entity\".\"entity_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteEntityForDiagramResult);
  }

  /**
   * Test {@link FlowDiagramEntityDao#deleteEntityForDiagram(long, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramEntityDao#deleteEntityForDiagram(long,
   * EntityReference)}
   */
  @Test
  @DisplayName("Test deleteEntityForDiagram(long, EntityReference); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntityDao.deleteEntityForDiagram(long, EntityReference)"})
  void testDeleteEntityForDiagram_thenReturnTrue() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<FlowDiagramEntityRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<FlowDiagramEntityRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<FlowDiagramEntityRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteEntityForDiagramResult =
        flowDiagramEntityDao.deleteEntityForDiagram(
            1L,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteEntityForDiagramResult);
  }
}
