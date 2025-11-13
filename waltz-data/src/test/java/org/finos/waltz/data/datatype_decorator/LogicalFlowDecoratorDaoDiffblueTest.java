package org.finos.waltz.data.datatype_decorator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.DataTypeUsageCharacteristics;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator.Builder;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Query;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record13;
import org.jooq.Record5;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
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
class LogicalFlowDecoratorDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LogicalFlowDecoratorDao logicalFlowDecoratorDao;

  /**
   * Test {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#getByEntityIdAndDataTypeId(long, long)}
   */
  @Test
  @DisplayName("Test getByEntityIdAndDataTypeId(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator LogicalFlowDecoratorDao.getByEntityIdAndDataTypeId(long, long)"
  })
  void testGetByEntityIdAndDataTypeId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(ratingResult.targetInboundRating(targetInboundRating).build());

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

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    logicalFlowDecoratorDao.addDecorators(new ArrayList<>());

    // Act
    DataTypeDecorator actualByEntityIdAndDataTypeId =
        logicalFlowDecoratorDao.getByEntityIdAndDataTypeId(1L, 1L);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    EntityReference entityReferenceResult = actualByEntityIdAndDataTypeId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult2 = actualByEntityIdAndDataTypeId.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    assertTrue(actualByEntityIdAndDataTypeId instanceof ImmutableDataTypeDecorator);
    assertEquals("2020-03-01", actualByEntityIdAndDataTypeId.lastUpdatedBy());
    assertEquals("Provenance", actualByEntityIdAndDataTypeId.provenance());
    assertEquals(
        "The characteristics of someone or something", decoratorEntityResult2.description());
    assertEquals(1L, decoratorEntityResult2.id());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataFlowId());
    assertEquals(1L, actualByEntityIdAndDataTypeId.dataTypeId());
    assertEquals(EntityKind.ALL, decoratorEntityResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult2.entityLifecycleStatus());
    assertFalse(actualByEntityIdAndDataTypeId.isReadonly());
    assertEquals(decoratorEntityResult2, entityReferenceResult);
    assertSame(ofResult, actualByEntityIdAndDataTypeId.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link ArrayList#ArrayList()} add minus one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findByFlowIds(Collection); given minus one; when ArrayList() add minus one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDecoratorDao.findByFlowIds(Collection)"})
  void testFindByFlowIds_givenMinusOne_whenArrayListAddMinusOne_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    ArrayList<Long> flowIds = new ArrayList<>();
    flowIds.add(-1L);

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult =
        logicalFlowDecoratorDao.findByFlowIds(flowIds);

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findByFlowIds(Collection); given one; when ArrayList() add one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDecoratorDao.findByFlowIds(Collection)"})
  void testFindByFlowIds_givenOne_whenArrayListAddOne_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    ArrayList<Long> flowIds = new ArrayList<>();
    flowIds.add(1L);
    flowIds.add(-1L);

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult =
        logicalFlowDecoratorDao.findByFlowIds(flowIds);

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDecoratorDao.findByFlowIds(Collection)"})
  void testFindByFlowIds_whenArrayList_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult =
        logicalFlowDecoratorDao.findByFlowIds(new ArrayList<>());

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#findAll()}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDecoratorDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    List<DataTypeDecorator> actualFindAllResult = new LogicalFlowDecoratorDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#findByEntityId(long)}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#findByEntityId(long)}
   */
  @Test
  @DisplayName("Test findByEntityId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDecoratorDao.findByEntityId(long)"})
  void testFindByEntityId() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    List<DataTypeDecorator> actualFindByEntityIdResult =
        new LogicalFlowDecoratorDao(dsl).findByEntityId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar) and 1 = 0 and \"logical_flow_decorator\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar(9)) and 1 = 0 and \"logical_flow_decorator\".\"is_readonly\" = 0)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" in () and \"logical_flow_decorator\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link ArrayList#ArrayList()} add minus one.
   *   <li>Then calls {@link DefaultDSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given minus one; when ArrayList() add minus one; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenMinusOne_whenArrayListAddMinusOne_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(deleteUsingStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(-1L);

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link DefaultDSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypes(EntityReference, Collection); given one; when ArrayList() add one; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_givenOne_whenArrayListAddOne_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(deleteUsingStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<Long> dataTypeIds = new ArrayList<>();
    dataTypeIds.add(1L);
    dataTypeIds.add(-1L);

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, dataTypeIds);

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_thenCallsDeleteFrom() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(deleteUsingStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);
    ImmutableEntityReference associatedEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference,
   * Collection)}
   */
  @Test
  @DisplayName("Test removeDataTypes(EntityReference, Collection); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDecoratorDao.removeDataTypes(EntityReference, Collection)"})
  void testRemoveDataTypes_thenCallsDeleteFrom2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    when(dSLContext.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(deleteUsingStep);
    ImmutableAppGroupEntry associatedEntityRef =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int actualRemoveDataTypesResult =
        logicalFlowDecoratorDao.removeDataTypes(associatedEntityRef, new ArrayList<>());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveDataTypesResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  @DisplayName("Test addDecorators(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.addDecorators(Collection)"})
  void testAddDecorators() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertOnDuplicateSetStep<LogicalFlowDecoratorRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Record>any()))
        .thenReturn(mock(InsertOnDuplicateSetMoreStep.class));

    InsertSetMoreStep<LogicalFlowDecoratorRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(decorators);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    verify(dsl).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetStep).set(isA(Record.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  @DisplayName("Test addDecorators(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.addDecorators(Collection)"})
  void testAddDecorators2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertOnDuplicateSetStep<LogicalFlowDecoratorRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Record>any()))
        .thenReturn(mock(InsertOnDuplicateSetMoreStep.class));

    InsertSetMoreStep<LogicalFlowDecoratorRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(decorators);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    verify(dsl, atLeast(1)).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep, atLeast(1)).set(isA(Record.class));
    verify(insertSetMoreStep, atLeast(1)).onDuplicateKeyUpdate();
    verify(insertSetStep, atLeast(1)).set(isA(Record.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  @DisplayName("Test addDecorators(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.addDecorators(Collection)"})
  void testAddDecorators3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertOnDuplicateSetStep<LogicalFlowDecoratorRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Record>any()))
        .thenReturn(mock(InsertOnDuplicateSetMoreStep.class));

    InsertSetMoreStep<LogicalFlowDecoratorRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    ArrayList<DataTypeDecorator> decorators = new ArrayList<>();

    Builder builderResult = ImmutableDataTypeDecorator.builder();

    Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating = Optional.empty();

    Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    decorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(decorators);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    verify(dsl).insertInto(isA(Table.class));
    verify(insertOnDuplicateSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetStep).set(isA(Record.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  @DisplayName("Test addDecorators(Collection); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.addDecorators(Collection)"})
  void testAddDecorators_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#addDecorators(Collection)}
   */
  @Test
  @DisplayName("Test addDecorators(Collection); when ArrayList(); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.addDecorators(Collection)"})
  void testAddDecorators_whenArrayList_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int[] actualAddDecoratorsResult = logicalFlowDecoratorDao.addDecorators(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#updateDecorators(Set)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#updateDecorators(Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(Set); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.updateDecorators(Set)"})
  void testUpdateDecorators_thenReturnEmptyArrayOfInt() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao =
        new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, logicalFlowDecoratorDao.updateDecorators(new HashSet<>()));
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#updateDecorators(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#updateDecorators(Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(Set); when 'null'; then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] LogicalFlowDecoratorDao.updateDecorators(Set)"})
  void testUpdateDecorators_whenNull_thenReturnEmptyArrayOfInt() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new int[] {},
        new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99))
            .updateDecorators(null));
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List LogicalFlowDecoratorDao.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record5<Object, Object, Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(
            Mockito.<RecordMapper<Record5<Object, Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record5<Object, Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record5<Object, Object, Object, Object, Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record5<Object, Object, Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record5<Object, Object, Object, Object, Object>> selectOnStep =
        mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record5<Object, Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record5<Object, Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    List<DataTypeUsageCharacteristics> actualFindDatatypeUsageCharacteristicsResult =
        logicalFlowDecoratorDao.findDatatypeUsageCharacteristics(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    assertTrue(actualFindDatatypeUsageCharacteristicsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  @DisplayName("Test updateRatingsByCondition(AuthoritativenessRatingValue, Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorDao.updateRatingsByCondition(AuthoritativenessRatingValue, Condition)"
  })
  void testUpdateRatingsByCondition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult =
        logicalFlowDecoratorDao.updateRatingsByCondition(
            AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = ? where \"application\".\"entity_lifecycle_status\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRatingsByConditionResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  @DisplayName("Test updateRatingsByCondition(AuthoritativenessRatingValue, Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorDao.updateRatingsByCondition(AuthoritativenessRatingValue, Condition)"
  })
  void testUpdateRatingsByCondition2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult =
        logicalFlowDecoratorDao.updateRatingsByCondition(
            AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = cast(? as varchar) where \"application\".\"entity_lifecycle_status\" = cast(? as varchar)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateRatingsByConditionResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue,
   * Condition)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#updateRatingsByCondition(AuthoritativenessRatingValue, Condition)}
   */
  @Test
  @DisplayName(
      "Test updateRatingsByCondition(AuthoritativenessRatingValue, Condition); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorDao.updateRatingsByCondition(AuthoritativenessRatingValue, Condition)"
  })
  void testUpdateRatingsByCondition_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowDecoratorRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<LogicalFlowDecoratorRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(updateSetFirstStep);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = new LogicalFlowDecoratorDao(dsl);

    // Act
    int actualUpdateRatingsByConditionResult =
        logicalFlowDecoratorDao.updateRatingsByCondition(
            AuthoritativenessRatingValue.of("42"), ApplicationDao.IS_ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateRatingsByConditionResult);
  }

  /**
   * Test {@link
   * LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}
   */
  @Test
  @DisplayName("Test resetRatingsAndFlowClassificationRulesCondition(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorDao.resetRatingsAndFlowClassificationRulesCondition(Condition)"
  })
  void testResetRatingsAndFlowClassificationRulesCondition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualResetRatingsAndFlowClassificationRulesConditionResult =
        new LogicalFlowDecoratorDao(dsl)
            .resetRatingsAndFlowClassificationRulesCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = ?, \"logical_flow_decorator\".\"flow_classification_rule_id\" = ?, \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\" = ? where \"application\".\"entity_lifecycle_status\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualResetRatingsAndFlowClassificationRulesConditionResult);
  }

  /**
   * Test {@link
   * LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}.
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}
   */
  @Test
  @DisplayName("Test resetRatingsAndFlowClassificationRulesCondition(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorDao.resetRatingsAndFlowClassificationRulesCondition(Condition)"
  })
  void testResetRatingsAndFlowClassificationRulesCondition2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualResetRatingsAndFlowClassificationRulesConditionResult =
        new LogicalFlowDecoratorDao(dsl)
            .resetRatingsAndFlowClassificationRulesCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = cast(? as varchar), \"logical_flow_decorator\".\"flow_classification_rule_id\" = cast(? as bigint), \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\" = cast(? as bigint) where \"application\".\"entity_lifecycle_status\" = cast(? as varchar)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setNull(anyInt(), eq(-5));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualResetRatingsAndFlowClassificationRulesConditionResult);
  }

  /**
   * Test {@link
   * LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LogicalFlowDecoratorDao#resetRatingsAndFlowClassificationRulesCondition(Condition)}
   */
  @Test
  @DisplayName("Test resetRatingsAndFlowClassificationRulesCondition(Condition); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LogicalFlowDecoratorDao.resetRatingsAndFlowClassificationRulesCondition(Condition)"
  })
  void testResetRatingsAndFlowClassificationRulesCondition_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowDecoratorRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep2 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.setNull(Mockito.<Field<Object>>any())).thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<LogicalFlowDecoratorRecord> updateSetMoreStep3 =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.setNull(Mockito.<Field<Object>>any())).thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<LogicalFlowDecoratorRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualResetRatingsAndFlowClassificationRulesConditionResult =
        new LogicalFlowDecoratorDao(dsl)
            .resetRatingsAndFlowClassificationRulesCondition(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).setNull(isA(Field.class));
    verify(updateSetMoreStep2).setNull(isA(Field.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualResetRatingsAndFlowClassificationRulesConditionResult);
  }

  /**
   * Test {@link LogicalFlowDecoratorDao#fetchFlowDataTypePopulation(Condition)}.
   *
   * <p>Method under test: {@link LogicalFlowDecoratorDao#fetchFlowDataTypePopulation(Condition)}
   */
  @Test
  @DisplayName("Test fetchFlowDataTypePopulation(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDecoratorDao.fetchFlowDataTypePopulation(Condition)"})
  void testFetchFlowDataTypePopulation() throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito
                .<RecordMapper<
                        Record13<
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object>,
                        Object>>
                    any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep3 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectJoinPartitionByStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep4 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep4.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep4);

    SelectOnConditionStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep5 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep5.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep4);

    SelectOnStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep5);

    SelectJoinStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record13<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<FlowDataType> actualFetchFlowDataTypePopulationResult =
        logicalFlowDecoratorDao.fetchFlowDataTypePopulation(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep5).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep4).on(isA(Condition.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFetchFlowDataTypePopulationResult.isEmpty());
  }
}
