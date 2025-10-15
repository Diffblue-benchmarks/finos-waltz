package org.finos.waltz.data.person;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.OrderField;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
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
class PersonDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PersonDao personDao;

  /**
   * Test {@link PersonDao#findAllEmails()}.
   *
   * <p>Method under test: {@link PersonDao#findAllEmails()}
   */
  @Test
  @DisplayName("Test findAllEmails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findAllEmails()"})
  void testFindAllEmails() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    List<String> actualFindAllEmailsResult = personDao.findAllEmails();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findDirectsByEmployeeId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findDirectsByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findDirectsByEmployeeId(String); when '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findDirectsByEmployeeId(String)"})
  void testFindDirectsByEmployeeId_when42_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.andNot(Mockito.<Field<Boolean>>any()))
        .thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindDirectsByEmployeeIdResult = personDao.findDirectsByEmployeeId("42");

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).andNot(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindDirectsByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findAllManagersByEmployeeId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findAllManagersByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllManagersByEmployeeId(String); when '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findAllManagersByEmployeeId(String)"})
  void testFindAllManagersByEmployeeId_when42_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.andNot(Mockito.<Field<Boolean>>any()))
        .thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindAllManagersByEmployeeIdResult =
        personDao.findAllManagersByEmployeeId("42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).andNot(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllManagersByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#all()}.
   *
   * <p>Method under test: {@link PersonDao#all()}
   */
  @Test
  @DisplayName("Test all()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.all()"})
  void testAll() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualAllResult = personDao.all();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualAllResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#bulkSave(List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#bulkSave(List)}
   */
  @Test
  @DisplayName(
      "Test bulkSave(List); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PersonDao.bulkSave(List)"})
  void testBulkSave_givenDefaultDSLContextWithDialectIsSql99_thenReturnEmptyArrayOfInt() {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertArrayEquals(new int[] {}, personDao.bulkSave(new ArrayList<>()));
  }

  /**
   * Test {@link PersonDao#findPersonsByAttestationInstanceId(long)}.
   *
   * <p>Method under test: {@link PersonDao#findPersonsByAttestationInstanceId(long)}
   */
  @Test
  @DisplayName("Test findPersonsByAttestationInstanceId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findPersonsByAttestationInstanceId(long)"})
  void testFindPersonsByAttestationInstanceId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.andNot(Mockito.<Field<Boolean>>any()))
        .thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindPersonsByAttestationInstanceIdResult =
        personDao.findPersonsByAttestationInstanceId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).andNot(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindPersonsByAttestationInstanceIdResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#countAllUnderlingsByKind(String)}.
   *
   * <p>Method under test: {@link PersonDao#countAllUnderlingsByKind(String)}
   */
  @Test
  @DisplayName("Test countAllUnderlingsByKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonDao.countAllUnderlingsByKind(String)"})
  void testCountAllUnderlingsByKind() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetchMap(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.andNot(Mockito.<Field<Boolean>>any()))
        .thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<PersonKind, Integer> actualCountAllUnderlingsByKindResult =
        personDao.countAllUnderlingsByKind("42");

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep2).andNot(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualCountAllUnderlingsByKindResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByIds(Set)"})
  void testFindByIds_givenOne_whenHashSetAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<Long> ids = new HashSet<>();
    ids.add(1L);

    // Act
    Set<Person> actualFindByIdsResult = personDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByIds(Set)"})
  void testFindByIds_givenZero_whenHashSetAddZero() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<Long> ids = new HashSet<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Set<Person> actualFindByIdsResult = personDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByIds(Set)"})
  void testFindByIds_whenHashSet() throws DataAccessException {
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
    Set<Person> actualFindByIdsResult = personDao.findByIds(new HashSet<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_given42_whenHashSetAdd42() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<String> empIds = new HashSet<>();
    empIds.add("42");
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personDao.findByEmployeeIds(empIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_givenFoo_whenHashSetAddFoo() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<String> empIds = new HashSet<>();
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personDao.findByEmployeeIds(empIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_whenHashSet() throws DataAccessException {
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
    Set<Person> actualFindByEmployeeIdsResult = personDao.findByEmployeeIds(new HashSet<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_given42_whenHashSetAdd42() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<String> emails = new HashSet<>();
    emails.add("42");
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personDao.findActivePeopleByEmails(emails);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_givenFoo_whenHashSetAddFoo() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    HashSet<String> emails = new HashSet<>();
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personDao.findActivePeopleByEmails(emails);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_whenHashSet() throws DataAccessException {
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
    Set<Person> actualFindActivePeopleByEmailsResult =
        personDao.findActivePeopleByEmails(new HashSet<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findActivePeopleByUserRole(String)}.
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByUserRole(String)}
   */
  @Test
  @DisplayName("Test findActivePeopleByUserRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByUserRole(String)"})
  void testFindActivePeopleByUserRole() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<Person> actualFindActivePeopleByUserRoleResult =
        personDao.findActivePeopleByUserRole("Role");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindActivePeopleByUserRoleResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_givenOne_whenArrayListAddOne() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personDao.findDirectsForPersonIds(personIds);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_givenZero_whenArrayListAddZero() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(0L);
    personIds.add(1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personDao.findDirectsForPersonIds(personIds);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_whenArrayList() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult =
        personDao.findDirectsForPersonIds(new ArrayList<>());

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }
}
