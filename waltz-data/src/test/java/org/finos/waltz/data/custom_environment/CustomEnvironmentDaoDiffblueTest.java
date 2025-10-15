package org.finos.waltz.data.custom_environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.custom_environment.CustomEnvironment;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment.Builder;
import org.finos.waltz.schema.tables.records.CustomEnvironmentRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomEnvironmentDaoDiffblueTest {
  @InjectMocks private CustomEnvironmentDao customEnvironmentDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link CustomEnvironmentDao#findAll()}.
   *
   * <p>Method under test: {@link CustomEnvironmentDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CustomEnvironmentDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<CustomEnvironment> actualFindAllResult = customEnvironmentDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link CustomEnvironmentDao#findByOwningEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentDao#findByOwningEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByOwningEntityRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CustomEnvironmentDao.findByOwningEntityRef(EntityReference)"})
  void testFindByOwningEntityRef_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<CustomEnvironment> actualFindByOwningEntityRefResult =
        customEnvironmentDao.findByOwningEntityRef(
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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByOwningEntityRefResult.isEmpty());
  }

  /**
   * Test {@link CustomEnvironmentDao#create(CustomEnvironment)}.
   *
   * <ul>
   *   <li>Given {@link CustomEnvironmentRecord} {@link CustomEnvironmentRecord#getId()} return one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentDao#create(CustomEnvironment)}
   */
  @Test
  @DisplayName(
      "Test create(CustomEnvironment); given CustomEnvironmentRecord getId() return one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentDao.create(CustomEnvironment)"})
  void testCreate_givenCustomEnvironmentRecordGetIdReturnOne_thenReturnLongValueIsOne()
      throws DataAccessException {
    // Arrange
    CustomEnvironmentRecord customEnvironmentRecord = mock(CustomEnvironmentRecord.class);
    when(customEnvironmentRecord.getId()).thenReturn(1L);

    InsertResultStep<CustomEnvironmentRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(customEnvironmentRecord);

    InsertSetMoreStep<CustomEnvironmentRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<CustomEnvironmentRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<CustomEnvironmentRecord>>any()))
        .thenReturn(insertSetStep);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Long actualCreateResult =
        customEnvironmentDao.create(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    verify(customEnvironmentRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link CustomEnvironmentDao#create(CustomEnvironment)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentDao#create(CustomEnvironment)}
   */
  @Test
  @DisplayName("Test create(CustomEnvironment); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentDao.create(CustomEnvironment)"})
  void testCreate_thenReturnNull() throws DataAccessException {
    // Arrange
    InsertResultStep<CustomEnvironmentRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new CustomEnvironmentRecord());

    InsertSetMoreStep<CustomEnvironmentRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<CustomEnvironmentRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<CustomEnvironmentRecord>>any()))
        .thenReturn(insertSetStep);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Long actualCreateResult =
        customEnvironmentDao.create(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link CustomEnvironmentDao#create(CustomEnvironment)}.
   *
   * <ul>
   *   <li>When {@link CustomEnvironment} {@link CustomEnvironment#externalId()} return of {@code
   *       foo}.
   *   <li>Then calls {@link CustomEnvironment#externalId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentDao#create(CustomEnvironment)}
   */
  @Test
  @DisplayName(
      "Test create(CustomEnvironment); when CustomEnvironment externalId() return of 'foo'; then calls externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentDao.create(CustomEnvironment)"})
  void testCreate_whenCustomEnvironmentExternalIdReturnOfFoo_thenCallsExternalId()
      throws DataAccessException {
    // Arrange
    InsertResultStep<CustomEnvironmentRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new CustomEnvironmentRecord());

    InsertSetMoreStep<CustomEnvironmentRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<CustomEnvironmentRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<CustomEnvironmentRecord>>any()))
        .thenReturn(insertSetStep);

    CustomEnvironment environment = mock(CustomEnvironment.class);
    when(environment.groupName()).thenReturn("Group Name");
    when(environment.owningEntity())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(environment.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(environment.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(environment.description()).thenReturn(ofResult2);

    // Act
    Long actualCreateResult = customEnvironmentDao.create(environment);

    // Assert
    verify(environment).externalId();
    verify(environment).name();
    verify(environment).description();
    verify(environment).groupName();
    verify(environment, atLeast(1)).owningEntity();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link CustomEnvironmentDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomEnvironmentDao.remove(Long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<CustomEnvironmentRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<CustomEnvironmentRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.delete(Mockito.<Table<CustomEnvironmentRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = customEnvironmentDao.remove(1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomEnvironmentDao.remove(Long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<CustomEnvironmentRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<CustomEnvironmentRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.delete(Mockito.<Table<CustomEnvironmentRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = customEnvironmentDao.remove(1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }
}
