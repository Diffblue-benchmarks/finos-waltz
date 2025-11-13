package org.finos.waltz.data.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.schema.tables.records.MeasurableRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.OrderField;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSeekStep2;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.MappingException;
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
class MeasurableDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private MeasurableDao measurableDao;

  /**
   * Test {@link MeasurableDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findAll()"})
  void testFindAll_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findAll()"})
  void testFindAll_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
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
    List<Measurable> actualFindAllResult = new MeasurableDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link MeasurableDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectConditionStep fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findAll()"})
  void testFindAll_givenSelectConditionStepFetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link SelectJoinStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep where(Condition) throw IllegalArgumentException(); then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findAll()"})
  void testFindAll_givenSelectJoinStepWhereThrowIllegalArgumentException_thenCallsWhere() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findAll());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findAll()"})
  void testFindAll_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findAll());
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable MeasurableDao.getById(long)"})
  void testGetById_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectConditionStep fetchOne(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable MeasurableDao.getById(long)"})
  void testGetById_givenSelectConditionStepFetchOneThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link SelectJoinStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectJoinStep where(Condition) throw IllegalArgumentException(); then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable MeasurableDao.getById(long)"})
  void testGetById_givenSelectJoinStepWhereThrowIllegalArgumentException_thenCallsWhere() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable MeasurableDao.getById(long)"})
  void testGetById_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableMeasurable}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableMeasurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable MeasurableDao.getById(long)"})
  void testGetById_thenReturnImmutableMeasurable() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Measurable actualById = new MeasurableDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(0, actualById.position());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(1L, actualById.categoryId());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertTrue(actualById.concrete());
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link MeasurableDao#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test findByExternalId(String); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByExternalId(String)"})
  void testFindByExternalId_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test findByExternalId(String); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByExternalId(String)"})
  void testFindByExternalId_givenSelectConditionStepFetchReturnArrayList_thenReturnList()
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<Measurable> actualFindByExternalIdResult =
        new MeasurableDao(dsl).findByExternalId("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(objectList, actualFindByExternalIdResult);
  }

  /**
   * Test {@link MeasurableDao#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test findByExternalId(String); given SelectConditionStep fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByExternalId(String)"})
  void testFindByExternalId_givenSelectConditionStepFetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test findByExternalId(String); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByExternalId(String)"})
  void testFindByExternalId_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByExternalId("42"));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test findByExternalId(String); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByExternalId(String)"})
  void testFindByExternalId_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByExternalId("42"));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualUpdateConcreteFlagResult =
        new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"concrete\" = cast(? as bit(1)), \"measurable\".\"last_updated_at\" = cast(? as datetime), \"measurable\".\"last_updated_by\" = cast(? as varchar) where \"measurable\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement).setString(3, "42");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    boolean actualUpdateConcreteFlagResult =
        new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"concrete\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement).setString(3, "42");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateConcreteFlagResult =
        new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenUpdateSetFirstStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenUpdateSetMoreStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenUpdateSetMoreStepSetThrowIllegalArgumentException2() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given UpdateSetMoreStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenUpdateSetMoreStepWhereThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateConcreteFlag(1L, true, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName("Test updateConcreteFlag(Long, boolean, String); then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_thenCallsUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.updateConcreteFlag(1L, true, "42"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateName(1L, "42", "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
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
    boolean actualUpdateNameResult = new MeasurableDao(dsl).updateName(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"name\" = cast(? as varchar), \"measurable\".\"last_updated_at\" = cast(? as datetime), \"measurable\".\"last_updated_by\" = cast(? as varchar) where \"measurable\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
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
    boolean actualUpdateNameResult = new MeasurableDao(dsl).updateName(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"name\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateNameResult = new MeasurableDao(dsl).updateName(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateSetFirstStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateName(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateSetMoreStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateName(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateSetMoreStepSetThrowIllegalArgumentException2() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateName(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given UpdateSetMoreStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_givenUpdateSetMoreStepWhereThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateName(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  @DisplayName("Test updateName(long, String, String); then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateName(long, String, String)"})
  void testUpdateName_thenCallsUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.updateName(1L, "42", "42"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateDescription(1L, "42", "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
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
    boolean actualUpdateDescriptionResult =
        new MeasurableDao(dsl).updateDescription(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"description\" = cast(? as varchar), \"measurable\".\"last_updated_at\" = cast(? as datetime), \"measurable\".\"last_updated_by\" = cast(? as varchar) where \"measurable\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
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
    boolean actualUpdateDescriptionResult =
        new MeasurableDao(dsl).updateDescription(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"description\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateDescriptionResult =
        new MeasurableDao(dsl).updateDescription(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateSetFirstStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateDescription(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateSetMoreStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateDescription(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateSetMoreStepSetThrowIllegalArgumentException2() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateDescription(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given UpdateSetMoreStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_givenUpdateSetMoreStepWhereThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateDescription(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String, String); then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateDescription(long, String, String)"})
  void testUpdateDescription_thenCallsUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.updateDescription(1L, "42", "42"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateExternalId(1L, "42", "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    boolean actualUpdateExternalIdResult = new MeasurableDao(dsl).updateExternalId(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"external_id\" = cast(? as varchar), \"measurable\".\"last_updated_at\" = cast(? as datetime), \"measurable\".\"last_updated_by\" = cast(? as varchar) where \"measurable\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    boolean actualUpdateExternalIdResult = new MeasurableDao(dsl).updateExternalId(1L, "42", "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"external_id\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given UpdateConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenUpdateConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateExternalIdResult = new MeasurableDao(dsl).updateExternalId(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenUpdateSetFirstStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateExternalId(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenUpdateSetMoreStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateExternalId(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenUpdateSetMoreStepSetThrowIllegalArgumentException2() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateExternalId(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given UpdateSetMoreStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenUpdateSetMoreStepWhereThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new MeasurableDao(dsl).updateExternalId(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#update(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName("Test updateExternalId(long, String, String); then calls update(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateExternalId(long, String, String)"})
  void testUpdateExternalId_thenCallsUpdate() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.updateExternalId(1L, "42", "42"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName("Test create(Measurable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate() throws DataAccessException {
    // Arrange
    InsertResultStep<MeasurableRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new MeasurableRecord());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep11);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    Long actualCreateResult =
        measurableDao.create(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(false)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName("Test create(Measurable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate2() throws DataAccessException {
    // Arrange
    InsertResultStep<MeasurableRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new MeasurableRecord());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep11);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    Long actualCreateResult =
        measurableDao.create(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description(null)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#insertInto(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given DSLContext insertInto(Table) throw IllegalArgumentException(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenDSLContextInsertIntoThrowIllegalArgumentException_whenNull() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).create(null));
    verify(dsl).insertInto(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertResultStep} {@link InsertResultStep#fetchOne()} return {@link
   *       MeasurableRecord#MeasurableRecord()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertResultStep fetchOne() return MeasurableRecord(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertResultStepFetchOneReturnMeasurableRecord_thenReturnNull()
      throws DataAccessException {
    // Arrange
    InsertResultStep<MeasurableRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new MeasurableRecord());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep11);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    Long actualCreateResult =
        measurableDao.create(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertResultStep} {@link InsertResultStep#fetchOne()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertResultStep fetchOne() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertResultStepFetchOneThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    InsertResultStep<MeasurableRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep11);
    when(dSLContext.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link
   *       InsertSetMoreStep#returning(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep returning(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepReturningThrowIllegalArgumentException() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep11);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException2() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException3() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException4() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException5() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException6() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException7() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException8() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException9() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetMoreStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetMoreStepSetThrowIllegalArgumentException10() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);

    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep10);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#create(Measurable)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetStep} {@link InsertSetStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable); given InsertSetStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableDao.create(Measurable)"})
  void testCreate_givenInsertSetStepSetThrowIllegalArgumentException() {
    // Arrange
    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.create(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableDao#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateParentId(1L, 1L, "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    boolean actualUpdateParentIdResult = new MeasurableDao(dsl).updateParentId(1L, 1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"parent_id\" = cast(? as bigint), \"measurable\".\"external_parent_id\" = (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = cast(? as bigint)), \"measurable\".\"last_updated_at\" = cast(? as datetime), \"measurable\".\"last_updated_by\" = cast(? as varchar) where \"measurable\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "42");
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableDao#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    boolean actualUpdateParentIdResult = new MeasurableDao(dsl).updateParentId(1L, 1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"parent_id\" = ?, \"measurable\".\"external_parent_id\" = (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = ?), \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "42");
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableDao#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenUpdateSetFirstStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).updateParentId(1L, 1L, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).moveChildren(1L, 1L, "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    boolean actualMoveChildrenResult = new MeasurableDao(dsl).moveChildren(1L, 1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"parent_id\" = cast(? as bigint), \"measurable\".\"external_parent_id\" = (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = cast(? as bigint)), \"measurable\".\"last_updated_at\" = cast(? as datetime), \"measurable\".\"last_updated_by\" = cast(? as varchar) where \"measurable\".\"parent_id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "42");
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMoveChildrenResult);
  }

  /**
   * Test {@link MeasurableDao#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    boolean actualMoveChildrenResult = new MeasurableDao(dsl).moveChildren(1L, 1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"measurable\" set \"measurable\".\"parent_id\" = ?, \"measurable\".\"external_parent_id\" = (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = ?), \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"parent_id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "42");
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMoveChildrenResult);
  }

  /**
   * Test {@link MeasurableDao#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenDefaultDSLContextWithDialectIsSql99_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new MeasurableDao(new DefaultDSLContext(SQLDialect.SQL99))
                .moveChildren(1L, null, "42"));
  }

  /**
   * Test {@link MeasurableDao#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableDao.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenUpdateSetFirstStepSetThrowIllegalArgumentException() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MeasurableDao(dsl).moveChildren(1L, 1L, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByCategoryId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByCategoryId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId3() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByCategoryId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId4() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L, statuses));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L, statuses));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses3() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L, statuses));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses4() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L, new HashSet<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses5() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L, new HashSet<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findByCategoryId(1L, new HashSet<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <ul>
   *   <li>Given {@code REMOVED}.
   *   <li>When {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName(
      "Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'; given 'REMOVED'; when HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses_givenRemoved_whenHashSetAddRemoved()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.REMOVED);
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableDao.findByCategoryId(1L, statuses);

    // Assert
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableDao.findByCategoryId(1L, statuses);

    // Assert
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableDao#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Measurable> actualFindByCategoryIdResult = new MeasurableDao(dsl).findByCategoryId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByParentId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#and(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given SelectConditionStep and(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenSelectConditionStepAndThrowIllegalArgumentException() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByParentId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#orderBy(OrderField,
   *       OrderField)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given SelectConditionStep orderBy(OrderField, OrderField) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenSelectConditionStepOrderByThrowIllegalArgumentException() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByParentId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByParentId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSeekStep2} {@link SelectSeekStep2#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given SelectSeekStep2 fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenSelectSeekStep2FetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Measurable> actualFindByParentIdResult = new MeasurableDao(dsl).findByParentId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParentIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSeekStep2} {@link SelectSeekStep2#fetch(RecordMapper)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given SelectSeekStep2 fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenSelectSeekStep2FetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectSeekStep2<Record, Object, Object> selectSeekStep2 = mock(SelectSeekStep2.class);
    when(selectSeekStep2.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(), Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep2);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByParentId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep2).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class), isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByParentId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(Long); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableDao.findByParentId(Long)"})
  void testFindByParentId_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByParentId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableDao.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findExternalIdToIdMapByCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableDao.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId2() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findExternalIdToIdMapByCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableDao.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId3() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findExternalIdToIdMapByCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableDao.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId4() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findExternalIdToIdMapByCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableDao.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.findExternalIdToIdMapByCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchMap(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableDao.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, Long> actualFindExternalIdToIdMapByCategoryIdResult =
        measurableDao.findExternalIdToIdMapByCategoryId(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchMap(isA(Field.class), isA(Field.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindExternalIdToIdMapByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole2() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole3() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole4() {
    // Arrange
    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole5() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole6() {
    // Arrange
    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole7() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole8() {
    // Arrange
    when(dSLContext.selectDistinct(Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne()).thenThrow(new IllegalArgumentException());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).selectDistinct(isA(SelectField.class));
    verify(selectConditionStep).fetchOne();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link Record1} {@link Record1#get(Field)} return {@code Get}.
   *   <li>Then return {@code Get}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRatingEditRole(EntityReference); given Record1 get(Field) return 'Get'; then return 'Get'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole_givenRecord1GetReturnGet_thenReturnGet()
      throws IllegalArgumentException, DataAccessException {
    // Arrange
    Record1<Object> record1 = mock(Record1.class);
    when(record1.get(Mockito.<Field<Object>>any())).thenReturn("Get");

    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne()).thenReturn(record1);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    String actualRequiredRatingEditRole =
        measurableDao.getRequiredRatingEditRole(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(record1).get(isA(Field.class));
    verify(selectConditionStep).fetchOne();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
    assertEquals("Get", actualRequiredRatingEditRole);
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link Record1} {@link Record1#get(Field)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRatingEditRole(EntityReference); given Record1 get(Field) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole_givenRecord1GetThrowIllegalArgumentException()
      throws IllegalArgumentException, DataAccessException {
    // Arrange
    Record1<Object> record1 = mock(Record1.class);
    when(record1.get(Mockito.<Field<Object>>any())).thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne()).thenReturn(record1);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(record1).get(isA(Field.class));
    verify(selectConditionStep).fetchOne();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectOnStep} {@link SelectOnStep#on(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getRequiredRatingEditRole(EntityReference); given SelectOnStep on(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole_givenSelectOnStepOnThrowIllegalArgumentException() {
    // Arrange
    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.selectDistinct(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableDao.getRequiredRatingEditRole(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(dsl).selectDistinct(isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  @DisplayName("Test getRequiredRatingEditRole(EntityReference); then return '-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MeasurableDao.getRequiredRatingEditRole(EntityReference)"})
  void testGetRequiredRatingEditRole_thenReturn1() throws SQLException {
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
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    String actualRequiredRatingEditRole =
        measurableDao.getRequiredRatingEditRole(
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
            "select distinct \"measurable_category\".\"rating_editor_role\" from \"measurable_category\" join \"measurable\" on \"measurable_category\".\"id\" = \"measurable\".\"measurable_category_id\" left outer join \"measurable_rating\" on \"measurable_rating\".\"measurable_id\" = \"measurable\".\"id\" left outer join \"measurable_rating_planned_decommission\" on \"measurable_rating\".\"id\" = \"measurable_rating_planned_decommission\".\"id\" where \"measurable_rating_planned_decommission\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals("-1", actualRequiredRatingEditRole);
  }

  /**
   * Test {@link MeasurableDao#findByOrgUnitId(Long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByOrgUnitId(Long); given DSLContext select(SelectFieldOrAsterisk[]) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByOrgUnitId(Long)"})
  void testFindByOrgUnitId_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByOrgUnitId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableDao#findByOrgUnitId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByOrgUnitId(Long); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByOrgUnitId(Long)"})
  void testFindByOrgUnitId_givenSelectConditionStepFetchReturnArrayList_thenReturnList()
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<Measurable> actualFindByOrgUnitIdResult = new MeasurableDao(dsl).findByOrgUnitId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByOrgUnitIdResult instanceof List);
    assertTrue(actualFindByOrgUnitIdResult.isEmpty());
    assertSame(objectList, actualFindByOrgUnitIdResult);
  }

  /**
   * Test {@link MeasurableDao#findByOrgUnitId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByOrgUnitId(Long); given SelectConditionStep fetch(RecordMapper) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByOrgUnitId(Long)"})
  void testFindByOrgUnitId_givenSelectConditionStepFetchThrowIllegalArgumentException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findByOrgUnitId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByOrgUnitId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByOrgUnitId(Long); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByOrgUnitId(Long)"})
  void testFindByOrgUnitId_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByOrgUnitId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findByOrgUnitId(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test findByOrgUnitId(Long); given SelectSelectStep from(TableLike) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableDao.findByOrgUnitId(Long)"})
  void testFindByOrgUnitId_givenSelectSelectStepFromThrowIllegalArgumentException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MeasurableDao(dsl).findByOrgUnitId(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link Batch} {@link Batch#execute()} return array of {@code int} with one and
   *       minus one.
   *   <li>Then calls {@link DSLContext#batch(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given Batch execute() return array of int with one and minus one; then calls batch(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenBatchExecuteReturnArrayOfIntWithOneAndMinusOne_thenCallsBatch()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, new ArrayList<>(), "42");

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(0, actualReorderResult);
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link Batch} {@link Batch#execute()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link DSLContext#batch(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given Batch execute() throw IllegalArgumentException(); then calls batch(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenBatchExecuteThrowIllegalArgumentException_thenCallsBatch()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenThrow(new IllegalArgumentException());
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableDao.reorder(1L, new ArrayList<>(), "42"));
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#update(Table)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given DefaultDSLContext update(Table) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenDefaultDSLContextUpdateThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any()))
        .thenThrow(new IllegalArgumentException());
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#and(Condition)} return
   *       {@link UpdateConditionStep}.
   *   <li>Then calls {@link DefaultDSLContext#batch(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given UpdateConditionStep and(Condition) return UpdateConditionStep; then calls batch(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenUpdateConditionStepAndReturnUpdateConditionStep_thenCallsBatch()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenReturn(mock(UpdateConditionStep.class));

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, ids, "42");

    // Assert
    verify(batch).execute();
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(0, actualReorderResult);
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#and(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given UpdateConditionStep and(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenUpdateConditionStepAndThrowIllegalArgumentException() {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link UpdateSetFirstStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given UpdateSetFirstStep set(Field, Object) throw IllegalArgumentException(); then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenUpdateSetFirstStepSetThrowIllegalArgumentException_thenCallsSet() {
    // Arrange
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link UpdateSetMoreStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException(); then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenUpdateSetMoreStepSetThrowIllegalArgumentException_thenCallsSet() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link UpdateSetMoreStep#set(Field, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given UpdateSetMoreStep set(Field, Object) throw IllegalArgumentException(); then calls set(Field, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenUpdateSetMoreStepSetThrowIllegalArgumentException_thenCallsSet2() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given UpdateSetMoreStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenUpdateSetMoreStepWhereThrowIllegalArgumentException() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given zero; when ArrayList() add zero; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_givenZero_whenArrayListAddZero_thenCallsAddBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, ids, "42");

    // Assert
    verify(connection).createStatement();
    verify(statement, atLeast(1)).addBatch(Mockito.<String>any());
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualReorderResult);
  }

  /**
   * Test {@link MeasurableDao#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  @DisplayName("Test reorder(long, List, String); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableDao.reorder(long, List, String)"})
  void testReorder_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, new ArrayList<>(), "42");

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualReorderResult);
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory() {
    // Arrange
    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory2() {
    // Arrange
    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory3() {
    // Arrange
    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory4() {
    // Arrange
    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory5() throws MappingException {
    // Arrange
    SelectConditionStep<Record4<Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField, SelectField, SelectField,
   *       SelectField)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName(
      "Test findHierarchyForCategory(long); given DSLContext select(SelectField, SelectField, SelectField, SelectField) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectOnStep} {@link SelectOnStep#on(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName(
      "Test findHierarchyForCategory(long); given SelectOnStep on(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory_givenSelectOnStepOnThrowIllegalArgumentException() {
    // Arrange
    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectOnStep} {@link SelectOnStep#on(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName(
      "Test findHierarchyForCategory(long); given SelectOnStep on(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory_givenSelectOnStepOnThrowIllegalArgumentException2() {
    // Arrange
    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.findHierarchyForCategory(1L));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableDao#findHierarchyForCategory(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableDao.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory_thenReturnEmpty() throws MappingException {
    // Arrange
    SelectConditionStep<Record4<Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchGroups(
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<MeasurableHierarchy> actualFindHierarchyForCategoryResult =
        measurableDao.findHierarchyForCategory(1L);

    // Assert
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectConditionStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindHierarchyForCategoryResult.isEmpty());
  }
}
