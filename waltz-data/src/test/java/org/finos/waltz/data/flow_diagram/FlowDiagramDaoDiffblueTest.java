package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.flow_diagram.FlowDiagram;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram;
import org.finos.waltz.schema.tables.records.FlowDiagramRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectQuery;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdatableRecord;
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
class FlowDiagramDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private FlowDiagramDao flowDiagramDao;

  /**
   * Test {@link FlowDiagramDao#getById(long)}.
   *
   * <p>Method under test: {@link FlowDiagramDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDiagram FlowDiagramDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    FlowDiagram actualById = new FlowDiagramDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableFlowDiagram);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Layout Data", actualById.layoutData());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertFalse(actualById.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link FlowDiagramDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() throws DataAccessException {
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

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(dsl);

    // Act
    List<FlowDiagram> actualFindByEntityReferenceResult =
        flowDiagramDao.findByEntityReference(
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
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramDao#create(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link FlowDiagram} {@link FlowDiagram#editorRole()} return empty.
   *   <li>Then calls {@link FlowDiagram#description()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#create(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test create(FlowDiagram); given empty; when FlowDiagram editorRole() return empty; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramDao.create(FlowDiagram)"})
  void testCreate_givenEmpty_whenFlowDiagramEditorRoleReturnEmpty_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);

    FlowDiagram flowDiagram = mock(FlowDiagram.class);
    Optional<String> emptyResult = Optional.empty();
    when(flowDiagram.editorRole()).thenReturn(emptyResult);
    when(flowDiagram.isRemoved()).thenReturn(true);
    when(flowDiagram.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagram.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flowDiagram.name()).thenReturn("Name");
    when(flowDiagram.layoutData()).thenReturn("Layout Data");
    Optional<Long> ofResult = Optional.of(42L);
    when(flowDiagram.id()).thenReturn(ofResult);
    when(flowDiagram.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    long actualCreateResult = flowDiagramDao.create(flowDiagram);

    // Assert
    verify(flowDiagram).description();
    verify(flowDiagram).id();
    verify(flowDiagram).isRemoved();
    verify(flowDiagram).lastUpdatedAt();
    verify(flowDiagram).lastUpdatedBy();
    verify(flowDiagram).name();
    verify(flowDiagram).editorRole();
    verify(flowDiagram).layoutData();
    verify(flowDiagramRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link FlowDiagramDao#create(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao#FlowDiagramDao(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#create(FlowDiagram)}
   */
  @Test
  @DisplayName("Test create(FlowDiagram); given FlowDiagramDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramDao.create(FlowDiagram)"})
  void testCreate_givenFlowDiagramDaoWithDslIsDSLContext() throws DataAccessException {
    // Arrange
    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(dsl);

    // Act
    long actualCreateResult =
        flowDiagramDao.create(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .build());

    // Assert
    verify(flowDiagramRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link FlowDiagramDao#create(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link FlowDiagram} {@link FlowDiagram#editorRole()} return of {@code 42}.
   *   <li>Then calls {@link FlowDiagram#description()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#create(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test create(FlowDiagram); given of '42'; when FlowDiagram editorRole() return of '42'; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramDao.create(FlowDiagram)"})
  void testCreate_givenOf42_whenFlowDiagramEditorRoleReturnOf42_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);

    FlowDiagram flowDiagram = mock(FlowDiagram.class);
    Optional<String> ofResult = Optional.of("42");
    when(flowDiagram.editorRole()).thenReturn(ofResult);
    when(flowDiagram.isRemoved()).thenReturn(true);
    when(flowDiagram.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagram.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flowDiagram.name()).thenReturn("Name");
    when(flowDiagram.layoutData()).thenReturn("Layout Data");
    Optional<Long> ofResult2 = Optional.of(42L);
    when(flowDiagram.id()).thenReturn(ofResult2);
    when(flowDiagram.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    long actualCreateResult = flowDiagramDao.create(flowDiagram);

    // Assert
    verify(flowDiagram).description();
    verify(flowDiagram).id();
    verify(flowDiagram).isRemoved();
    verify(flowDiagram).lastUpdatedAt();
    verify(flowDiagram).lastUpdatedBy();
    verify(flowDiagram).name();
    verify(flowDiagram).editorRole();
    verify(flowDiagram).layoutData();
    verify(flowDiagramRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link FlowDiagramDao#create(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link FlowDiagram} {@link FlowDiagram#id()} return empty.
   *   <li>Then calls {@link FlowDiagram#description()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#create(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test create(FlowDiagram); given of '42'; when FlowDiagram id() return empty; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramDao.create(FlowDiagram)"})
  void testCreate_givenOf42_whenFlowDiagramIdReturnEmpty_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);

    FlowDiagram flowDiagram = mock(FlowDiagram.class);
    Optional<String> ofResult = Optional.of("42");
    when(flowDiagram.editorRole()).thenReturn(ofResult);
    when(flowDiagram.isRemoved()).thenReturn(true);
    when(flowDiagram.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagram.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flowDiagram.name()).thenReturn("Name");
    when(flowDiagram.layoutData()).thenReturn("Layout Data");
    Optional<Long> emptyResult = Optional.empty();
    when(flowDiagram.id()).thenReturn(emptyResult);
    when(flowDiagram.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    long actualCreateResult = flowDiagramDao.create(flowDiagram);

    // Assert
    verify(flowDiagram).description();
    verify(flowDiagram).id();
    verify(flowDiagram).isRemoved();
    verify(flowDiagram).lastUpdatedAt();
    verify(flowDiagram).lastUpdatedBy();
    verify(flowDiagram).name();
    verify(flowDiagram).editorRole();
    verify(flowDiagram).layoutData();
    verify(flowDiagramRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link FlowDiagramDao#update(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link FlowDiagram} {@link FlowDiagram#editorRole()} return empty.
   *   <li>Then calls {@link FlowDiagram#description()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#update(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test update(FlowDiagram); given empty; when FlowDiagram editorRole() return empty; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.update(FlowDiagram)"})
  void testUpdate_givenEmpty_whenFlowDiagramEditorRoleReturnEmpty_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    FlowDiagram flowDiagram = mock(FlowDiagram.class);
    Optional<String> emptyResult = Optional.empty();
    when(flowDiagram.editorRole()).thenReturn(emptyResult);
    when(flowDiagram.isRemoved()).thenReturn(true);
    when(flowDiagram.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagram.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flowDiagram.name()).thenReturn("Name");
    when(flowDiagram.layoutData()).thenReturn("Layout Data");
    Optional<Long> ofResult = Optional.of(42L);
    when(flowDiagram.id()).thenReturn(ofResult);
    when(flowDiagram.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualUpdateResult = flowDiagramDao.update(flowDiagram);

    // Assert
    verify(flowDiagram).description();
    verify(flowDiagram).id();
    verify(flowDiagram).isRemoved();
    verify(flowDiagram).lastUpdatedAt();
    verify(flowDiagram).lastUpdatedBy();
    verify(flowDiagram).name();
    verify(flowDiagram).editorRole();
    verify(flowDiagram).layoutData();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link FlowDiagramDao#update(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao#FlowDiagramDao(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#update(FlowDiagram)}
   */
  @Test
  @DisplayName("Test update(FlowDiagram); given FlowDiagramDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.update(FlowDiagram)"})
  void testUpdate_givenFlowDiagramDaoWithDslIsDSLContext() throws DataAccessException {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(dsl);

    // Act
    boolean actualUpdateResult =
        flowDiagramDao.update(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .build());

    // Assert
    verify(dsl).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link FlowDiagramDao#update(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link FlowDiagram} {@link FlowDiagram#editorRole()} return of {@code 42}.
   *   <li>Then calls {@link FlowDiagram#description()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#update(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test update(FlowDiagram); given of '42'; when FlowDiagram editorRole() return of '42'; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.update(FlowDiagram)"})
  void testUpdate_givenOf42_whenFlowDiagramEditorRoleReturnOf42_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    FlowDiagram flowDiagram = mock(FlowDiagram.class);
    Optional<String> ofResult = Optional.of("42");
    when(flowDiagram.editorRole()).thenReturn(ofResult);
    when(flowDiagram.isRemoved()).thenReturn(true);
    when(flowDiagram.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagram.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flowDiagram.name()).thenReturn("Name");
    when(flowDiagram.layoutData()).thenReturn("Layout Data");
    Optional<Long> ofResult2 = Optional.of(42L);
    when(flowDiagram.id()).thenReturn(ofResult2);
    when(flowDiagram.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualUpdateResult = flowDiagramDao.update(flowDiagram);

    // Assert
    verify(flowDiagram).description();
    verify(flowDiagram).id();
    verify(flowDiagram).isRemoved();
    verify(flowDiagram).lastUpdatedAt();
    verify(flowDiagram).lastUpdatedBy();
    verify(flowDiagram).name();
    verify(flowDiagram).editorRole();
    verify(flowDiagram).layoutData();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link FlowDiagramDao#update(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link FlowDiagram} {@link FlowDiagram#id()} return empty.
   *   <li>Then calls {@link FlowDiagram#description()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#update(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test update(FlowDiagram); given of '42'; when FlowDiagram id() return empty; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.update(FlowDiagram)"})
  void testUpdate_givenOf42_whenFlowDiagramIdReturnEmpty_thenCallsDescription()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);

    FlowDiagram flowDiagram = mock(FlowDiagram.class);
    Optional<String> ofResult = Optional.of("42");
    when(flowDiagram.editorRole()).thenReturn(ofResult);
    when(flowDiagram.isRemoved()).thenReturn(true);
    when(flowDiagram.description()).thenReturn("The characteristics of someone or something");
    when(flowDiagram.lastUpdatedBy()).thenReturn("2020-03-01");
    when(flowDiagram.name()).thenReturn("Name");
    when(flowDiagram.layoutData()).thenReturn("Layout Data");
    Optional<Long> emptyResult = Optional.empty();
    when(flowDiagram.id()).thenReturn(emptyResult);
    when(flowDiagram.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    boolean actualUpdateResult = flowDiagramDao.update(flowDiagram);

    // Assert
    verify(flowDiagram).description();
    verify(flowDiagram).id();
    verify(flowDiagram).isRemoved();
    verify(flowDiagram).lastUpdatedAt();
    verify(flowDiagram).lastUpdatedBy();
    verify(flowDiagram).name();
    verify(flowDiagram).editorRole();
    verify(flowDiagram).layoutData();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link FlowDiagramDao#update(FlowDiagram)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#update(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test update(FlowDiagram); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.update(FlowDiagram)"})
  void testUpdate_givenPreparedStatementExecuteReturnTrue_thenReturnFalse() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(dsl);

    // Act
    boolean actualUpdateResult =
        flowDiagramDao.update(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_diagram\" set \"flow_diagram\".\"name\" = ?, \"flow_diagram\".\"description\" = ?, \"flow_diagram\".\"layout_data\" = ?, \"flow_diagram\".\"last_updated_at\" = ?, \"flow_diagram\".\"last_updated_by\" = ?, \"flow_diagram\".\"is_removed\" = ?, \"flow_diagram\".\"editor_role\" = ? where \"flow_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(6, false);
    verify(preparedStatement).setLong(8, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link FlowDiagramDao#updateName(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#updateName(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.updateName(long, String)"})
  void testUpdateName_givenPreparedStatementExecuteReturnTrue_thenReturnFalse()
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
    boolean actualUpdateNameResult = new FlowDiagramDao(dsl).updateName(1L, "Name");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_diagram\" set \"flow_diagram\".\"name\" = ? where \"flow_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link FlowDiagramDao#updateName(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#updateName(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.updateName(long, String)"})
  void testUpdateName_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<FlowDiagramRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<FlowDiagramRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateNameResult = new FlowDiagramDao(dsl).updateName(1L, "Name");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link FlowDiagramDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.updateDescription(long, String)"})
  void testUpdateDescription_givenPreparedStatementExecuteReturnTrue_thenReturnFalse()
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
    boolean actualUpdateDescriptionResult = new FlowDiagramDao(dsl).updateDescription(1L, "Des");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_diagram\" set \"flow_diagram\".\"description\" = ? where \"flow_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "Des");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link FlowDiagramDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.updateDescription(long, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<FlowDiagramRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<FlowDiagramRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateDescriptionResult = new FlowDiagramDao(dsl).updateDescription(1L, "Des");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link FlowDiagramDao#deleteById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#deleteById(long, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long, String); given PreparedStatement execute() return 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.deleteById(long, String)"})
  void testDeleteById_givenPreparedStatementExecuteReturnTrue_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteByIdResult = new FlowDiagramDao(dsl).deleteById(1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_diagram\" set \"flow_diagram\".\"is_removed\" = ?, \"flow_diagram\".\"last_updated_at\" = ?, \"flow_diagram\".\"last_updated_by\" = ? where \"flow_diagram\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement).setString(3, "janedoe");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Test {@link FlowDiagramDao#deleteById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#deleteById(long, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramDao.deleteById(long, String)"})
  void testDeleteById_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<FlowDiagramRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<FlowDiagramRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<FlowDiagramRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualDeleteByIdResult = new FlowDiagramDao(dsl).deleteById(1L, "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Test {@link FlowDiagramDao#clone(long, String, String)} with {@code long}, {@code String},
   * {@code String}.
   *
   * <p>Method under test: {@link FlowDiagramDao#clone(long, String, String)}
   */
  @Test
  @DisplayName("Test clone(long, String, String) with 'long', 'String', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramDao.clone(long, String, String)"})
  void testCloneWithLongStringString() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("42")
                .layoutData("Layout Data")
                .name("Name")
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Long actualCloneResult = new FlowDiagramDao(dsl).clone(1L, "New Name", "42");

    // Assert
    verify(flowDiagramRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCloneResult.longValue());
  }

  /**
   * Test {@link FlowDiagramDao#clone(long, String, String)} with {@code long}, {@code String},
   * {@code String}.
   *
   * <p>Method under test: {@link FlowDiagramDao#clone(long, String, String)}
   */
  @Test
  @DisplayName("Test clone(long, String, String) with 'long', 'String', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramDao.clone(long, String, String)"})
  void testCloneWithLongStringString2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("New Name")
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Long actualCloneResult = new FlowDiagramDao(dsl).clone(1L, "New Name", "42");

    // Assert
    verify(flowDiagramRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCloneResult.longValue());
  }

  /**
   * Test {@link FlowDiagramDao#clone(long, String, String)} with {@code long}, {@code String},
   * {@code String}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#clone(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test clone(long, String, String) with 'long', 'String', 'String'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramDao.clone(long, String, String)"})
  void testCloneWithLongStringString_thenReturnLongValueIsOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    FlowDiagramRecord flowDiagramRecord = mock(FlowDiagramRecord.class);
    when(flowDiagramRecord.getId()).thenReturn(1L);

    InsertResultStep<FlowDiagramRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(flowDiagramRecord);

    InsertSetMoreStep<FlowDiagramRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<FlowDiagramRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<FlowDiagramRecord>>any())).thenReturn(insertSetStep);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Long actualCloneResult = new FlowDiagramDao(dsl).clone(1L, "New Name", "42");

    // Assert
    verify(flowDiagramRecord).getId();
    verify(dsl).insertInto(isA(Table.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCloneResult.longValue());
  }

  /**
   * Test {@link FlowDiagramDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link FlowDiagramDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowDiagramDao.search(EntitySearchOptions)"})
  void testSearch() throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.getQuery()).thenReturn(selectQuery);

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Collection<FlowDiagram> actualSearchResult =
        flowDiagramDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectQuery).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep).getQuery();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(objectList, actualSearchResult);
  }

  /**
   * Test {@link FlowDiagramDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link FlowDiagramDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowDiagramDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(mock(DSLContext.class));

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Collection<FlowDiagram> actualSearchResult =
        flowDiagramDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link FlowDiagramDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowDiagramDao.search(EntitySearchOptions)"})
  void testSearch3() throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.getQuery()).thenReturn(selectQuery);

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    FlowDiagramDao flowDiagramDao = new FlowDiagramDao(dsl);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Collection<FlowDiagram> actualSearchResult =
        flowDiagramDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search")
                .userId("42")
                .build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectQuery).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep).getQuery();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(40);
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(objectList, actualSearchResult);
  }

  /**
   * Test {@link FlowDiagramDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#limit()} return one.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given one; when EntitySearchOptions limit() return one; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowDiagramDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_whenEntitySearchOptionsLimitReturnOne_thenCallsLimit()
      throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.getQuery()).thenReturn(selectQuery);

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    Collection<FlowDiagram> actualSearchResult = flowDiagramDao.search(options);

    // Assert
    verify(options).limit();
    verify(options).searchQuery();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectQuery).fetch(isA(RecordMapper.class));
    verify(selectLimitPercentStep).getQuery();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(1);
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(objectList, actualSearchResult);
  }
}
