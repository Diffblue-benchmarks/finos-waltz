package org.finos.waltz.data.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.sql.rowset.RowSetMetaDataImpl;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.physical_flow.PhysicalFlowParsed;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.schema.tables.records.PhysicalSpecificationRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalCallable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.tools.jdbc.DefaultResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PhysicalSpecificationDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalSpecificationDao physicalSpecificationDao;

  /**
   * Test {@link PhysicalSpecificationDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<PhysicalSpecification> actualFindByEntityReferenceResult =
        physicalSpecificationDao.findByEntityReference(
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
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep3).or(isA(Condition.class));
    verify(selectConditionStep2).or(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<PhysicalSpecification> actualFindByEntityReferenceResult =
        physicalSpecificationDao.findByEntityReference(
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
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep3).or(isA(Condition.class));
    verify(selectConditionStep2).or(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationDao#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationDao.findByIds(Collection)"})
  void testFindByIds_givenOne_whenArrayListAddOne() throws DataAccessException {
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

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(objectList, actualFindByIdsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationDao.findByIds(Collection)"})
  void testFindByIds_givenZero_whenArrayListAddZero() throws DataAccessException {
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

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(objectList, actualFindByIdsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#findByIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationDao.findByIds(Collection)"})
  void testFindByIds_whenArrayList() throws DataAccessException {
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
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationDao.findByIds(new ArrayList<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(objectList, actualFindByIdsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#findByExternalId(String)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationDao.findByExternalId(String)"})
  void testFindByExternalId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    HashSet<Object> objectSet = new HashSet<>();
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectSet);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Collection<PhysicalSpecification> actualFindByExternalIdResult =
        physicalSpecificationDao.findByExternalId("42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByExternalIdResult instanceof Set);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(objectSet, actualFindByExternalIdResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#getByParsedFlow(PhysicalFlowParsed)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#getByParsedFlow(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName(
      "Test getByParsedFlow(PhysicalFlowParsed); given SelectConditionStep fetchOne(RecordMapper) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalSpecification PhysicalSpecificationDao.getByParsedFlow(PhysicalFlowParsed)"
  })
  void testGetByParsedFlow_givenSelectConditionStepFetchOneReturnNull_thenReturnNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    PhysicalFlowParsed flow = mock(PhysicalFlowParsed.class);
    when(flow.owner())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(flow.name()).thenReturn("Name");
    when(flow.format()).thenReturn(DataFormatKindValue.of("42"));

    // Act
    PhysicalSpecification actualByParsedFlow = physicalSpecificationDao.getByParsedFlow(flow);

    // Assert
    verify(flow).format();
    verify(flow).name();
    verify(flow, atLeast(1)).owner();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertNull(actualByParsedFlow);
  }

  /**
   * Test {@link PhysicalSpecificationDao#isUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#fetchOne(Field)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#isUsed(long)}
   */
  @Test
  @DisplayName(
      "Test isUsed(long); given SelectSelectStep fetchOne(Field) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalSpecificationDao.isUsed(long)"})
  void testIsUsed_givenSelectSelectStepFetchOneReturnFalse_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(false);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsUsedResult = physicalSpecificationDao.isUsed(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).fetchOne(isA(Field.class));
    assertFalse(actualIsUsedResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#isUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#fetchOne(Field)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#isUsed(long)}
   */
  @Test
  @DisplayName(
      "Test isUsed(long); given SelectSelectStep fetchOne(Field) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalSpecificationDao.isUsed(long)"})
  void testIsUsed_givenSelectSelectStepFetchOneReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn(true);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    boolean actualIsUsedResult = physicalSpecificationDao.isUsed(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).fetchOne(isA(Field.class));
    assertTrue(actualIsUsedResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.markRemovedIfUnused(long)"})
  void testMarkRemovedIfUnused_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualMarkRemovedIfUnusedResult = new PhysicalSpecificationDao(dsl).markRemovedIfUnused(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = cast(? as bit(1)) where (\"physical_specification\".\"id\" = cast(? as bigint) and not exists (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"specification_id\" = cast(? as bigint) and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "REMOVED");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkRemovedIfUnusedResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.markRemovedIfUnused(long)"})
  void testMarkRemovedIfUnused_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualMarkRemovedIfUnusedResult = new PhysicalSpecificationDao(dsl).markRemovedIfUnused(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = cast(? as boolean) where (\"physical_specification\".\"id\" = cast(? as bigint) and not exists (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"specification_id\" = cast(? as bigint) and \"physical_flow\".\"is_removed\" = 0 and \"physical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar(7)))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "REMOVED");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkRemovedIfUnusedResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.markRemovedIfUnused(long)"})
  void testMarkRemovedIfUnused_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualMarkRemovedIfUnusedResult = new PhysicalSpecificationDao(dsl).markRemovedIfUnused(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = ? where (\"physical_specification\".\"id\" = ? and not exists (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"specification_id\" = ? and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "REMOVED");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMarkRemovedIfUnusedResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#markRemovedIfUnused(long)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(long); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.markRemovedIfUnused(long)"})
  void testMarkRemovedIfUnused_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecificationRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualMarkRemovedIfUnusedResult = physicalSpecificationDao.markRemovedIfUnused(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualMarkRemovedIfUnusedResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateExternalId(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateExternalId(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateExternalId(long, String)"})
  void testUpdateExternalId_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    int actualUpdateExternalIdResult = new PhysicalSpecificationDao(dsl).updateExternalId(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"external_id\" = cast(? as varchar) where (\"physical_specification\".\"id\" = cast(? as bigint) and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateExternalId(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateExternalId(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateExternalId(long, String)"})
  void testUpdateExternalId_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    int actualUpdateExternalIdResult = new PhysicalSpecificationDao(dsl).updateExternalId(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"external_id\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateExternalId(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateExternalId(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateExternalId(long, String)"})
  void testUpdateExternalId_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecificationRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateExternalIdResult = physicalSpecificationDao.updateExternalId(1L, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#makeActive(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.makeActive(Long)"})
  void testMakeActive_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualMakeActiveResult = new PhysicalSpecificationDao(dsl).makeActive(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = cast(? as bit(1)) where (\"physical_specification\".\"id\" = cast(? as bigint) and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#makeActive(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.makeActive(Long)"})
  void testMakeActive_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    int actualMakeActiveResult = new PhysicalSpecificationDao(dsl).makeActive(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"is_removed\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#makeActive(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.makeActive(Long)"})
  void testMakeActive_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualMakeActiveResult = new PhysicalSpecificationDao(dsl).makeActive(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"is_removed\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#makeActive(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.makeActive(Long)"})
  void testMakeActive_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    int actualMakeActiveResult = new PhysicalSpecificationDao(dsl).makeActive(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update physical_specification set is_removed = ? where (physical_specification.id = ? and physical_specification.is_readonly = 0)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, false);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#makeActive(Long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#makeActive(Long)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.makeActive(Long)"})
  void testMakeActive_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecificationRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualMakeActiveResult = physicalSpecificationDao.makeActive(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String,
   * long)}
   */
  @Test
  @DisplayName("Test propagateDataTypesToLogicalFlows(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.propagateDataTypesToLogicalFlows(String, long)"})
  void testPropagateDataTypesToLogicalFlows() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult =
        new PhysicalSpecificationDao(dsl).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String,
   * long)}
   */
  @Test
  @DisplayName("Test propagateDataTypesToLogicalFlows(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.propagateDataTypesToLogicalFlows(String, long)"})
  void testPropagateDataTypesToLogicalFlows2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult =
        new PhysicalSpecificationDao(dsl).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String,
   * long)}
   */
  @Test
  @DisplayName("Test propagateDataTypesToLogicalFlows(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.propagateDataTypesToLogicalFlows(String, long)"})
  void testPropagateDataTypesToLogicalFlows3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult =
        new PhysicalSpecificationDao(dsl).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String,
   * long)}
   */
  @Test
  @DisplayName("Test propagateDataTypesToLogicalFlows(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.propagateDataTypesToLogicalFlows(String, long)"})
  void testPropagateDataTypesToLogicalFlows4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult =
        new PhysicalSpecificationDao(dsl).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#propagateDataTypesToLogicalFlows(String,
   * long)}
   */
  @Test
  @DisplayName("Test propagateDataTypesToLogicalFlows(String, long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.propagateDataTypesToLogicalFlows(String, long)"})
  void testPropagateDataTypesToLogicalFlows_thenReturnOne() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult =
        physicalSpecificationDao.propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}
   */
  @Test
  @DisplayName(
      "Test updateFormat(long, DataFormatKindValue); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateFormat(long, DataFormatKindValue)"})
  void testUpdateFormat_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(dsl);

    // Act
    int actualUpdateFormatResult =
        physicalSpecificationDao.updateFormat(1L, DataFormatKindValue.of("42"));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"format\" = cast(? as varchar) where (\"physical_specification\".\"id\" = cast(? as bigint) and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateFormatResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}
   */
  @Test
  @DisplayName(
      "Test updateFormat(long, DataFormatKindValue); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateFormat(long, DataFormatKindValue)"})
  void testUpdateFormat_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(dsl);

    // Act
    int actualUpdateFormatResult =
        physicalSpecificationDao.updateFormat(1L, DataFormatKindValue.of("42"));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"format\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateFormatResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateFormat(long, DataFormatKindValue)}
   */
  @Test
  @DisplayName(
      "Test updateFormat(long, DataFormatKindValue); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateFormat(long, DataFormatKindValue)"})
  void testUpdateFormat_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecificationRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateFormatResult =
        physicalSpecificationDao.updateFormat(1L, DataFormatKindValue.of("42"));

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateFormatResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateDescription(long, String)"})
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
    int actualUpdateDescriptionResult =
        new PhysicalSpecificationDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"description\" = cast(? as varchar) where (\"physical_specification\".\"id\" = cast(? as bigint) and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateDescription(long, String)"})
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
    int actualUpdateDescriptionResult =
        new PhysicalSpecificationDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_specification\" set \"physical_specification\".\"description\" = ? where (\"physical_specification\".\"id\" = ? and \"physical_specification\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationDao.updateDescription(long, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalSpecificationRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalSpecificationRecord> updateSetMoreStep =
        mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalSpecificationRecord> updateSetFirstStep =
        mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalSpecificationRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDescriptionResult =
        physicalSpecificationDao.updateDescription(
            1L, "The characteristics of someone or something");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName("Test calculateAmendedSpecOperations(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" from db_root where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = cast(? as varchar) and \"user_role\".\"user_name\" = cast(? as varchar)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertTrue(actualCalculateAmendedSpecOperationsResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link HashSet#HashSet()} add {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedSpecOperations(Set, String); given 'ADD'; when HashSet() add 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations_givenAdd_whenHashSetAddAdd() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<Operation> operationsForEntity = new HashSet<>();
    operationsForEntity.add(Operation.ADD);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(operationsForEntity, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(3, actualCalculateAmendedSpecOperationsResult.size());
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedSpecOperations(Set, String); given 'ATTEST'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations_givenAttest_thenReturnSizeIsFour()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<Operation> operationsForEntity = new HashSet<>();
    operationsForEntity.add(Operation.ATTEST);
    operationsForEntity.add(Operation.ADD);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(operationsForEntity, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(4, actualCalculateAmendedSpecOperationsResult.size());
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ATTEST));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedSpecOperations(Set, String); given DSLContext fetchExists(Select) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations_givenDSLContextFetchExistsReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualCalculateAmendedSpecOperationsResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedSpecOperations(Set, String); given PreparedStatement getResultSet() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations_givenPreparedStatementGetResultSetReturnNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedSpecOperationsResult.size());
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedSpecOperations(Set, String); given 'true'; when HashSet(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations_givenTrue_whenHashSet_thenCallsClose()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PhysicalSpecificationDao physicalSpecificationDao = new PhysicalSpecificationDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertTrue(actualCalculateAmendedSpecOperationsResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set, String)}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationDao#calculateAmendedSpecOperations(Set,
   * String)}
   */
  @Test
  @DisplayName("Test calculateAmendedSpecOperations(Set, String); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationDao.calculateAmendedSpecOperations(Set, String)"})
  void testCalculateAmendedSpecOperations_thenReturnSizeIsThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    Set<Operation> actualCalculateAmendedSpecOperationsResult =
        physicalSpecificationDao.calculateAmendedSpecOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(3, actualCalculateAmendedSpecOperationsResult.size());
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedSpecOperationsResult.contains(Operation.UPDATE));
  }
}
