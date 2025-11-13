package org.finos.waltz.data.person;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
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
import org.jooq.SelectLimitPercentStep;
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
   * Test {@link PersonDao#getByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#getByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test getByEmployeeId(String); then return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonDao.getByEmployeeId(String)"})
  void testGetByEmployeeId_thenReturnImmutablePerson() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Person actualByEmployeeId = new PersonDao(dsl).getByEmployeeId("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualByEmployeeId instanceof ImmutablePerson);
    assertEquals("42", actualByEmployeeId.employeeId());
    assertEquals("42", actualByEmployeeId.userId());
    assertEquals("Display Name", actualByEmployeeId.displayName());
    assertEquals("Display Name", actualByEmployeeId.name());
    assertEquals("jane.doe@example.org", actualByEmployeeId.email());
    assertEquals(EntityKind.ALL, actualByEmployeeId.kind());
    assertEquals(PersonKind.EMPLOYEE, actualByEmployeeId.personKind());
    assertTrue(actualByEmployeeId.isRemoved());
  }

  /**
   * Test {@link PersonDao#getById(long)}.
   *
   * <p>Method under test: {@link PersonDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Person actualById = new PersonDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualById instanceof ImmutablePerson);
    assertEquals("42", actualById.employeeId());
    assertEquals("42", actualById.userId());
    assertEquals("Display Name", actualById.displayName());
    assertEquals("Display Name", actualById.name());
    assertEquals("jane.doe@example.org", actualById.email());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(PersonKind.EMPLOYEE, actualById.personKind());
    assertTrue(actualById.isRemoved());
  }

  /**
   * Test {@link PersonDao#getByUserEmail(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#getByUserEmail(String)}
   */
  @Test
  @DisplayName("Test getByUserEmail(String); then return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonDao.getByUserEmail(String)"})
  void testGetByUserEmail_thenReturnImmutablePerson() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

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

    // Act
    Person actualByUserEmail = new PersonDao(dsl).getByUserEmail("jane.doe@example.org");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(1);
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualByUserEmail instanceof ImmutablePerson);
    assertEquals("42", actualByUserEmail.employeeId());
    assertEquals("42", actualByUserEmail.userId());
    assertEquals("Display Name", actualByUserEmail.displayName());
    assertEquals("Display Name", actualByUserEmail.name());
    assertEquals("jane.doe@example.org", actualByUserEmail.email());
    assertEquals(EntityKind.ALL, actualByUserEmail.kind());
    assertEquals(PersonKind.EMPLOYEE, actualByUserEmail.personKind());
    assertTrue(actualByUserEmail.isRemoved());
  }

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
   * Test {@link PersonDao#getActiveByUserEmail(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#getActiveByUserEmail(String)}
   */
  @Test
  @DisplayName("Test getActiveByUserEmail(String); then return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonDao.getActiveByUserEmail(String)"})
  void testGetActiveByUserEmail_thenReturnImmutablePerson() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.andNot(Mockito.<Field<Boolean>>any()))
        .thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Person actualActiveByUserEmail =
        new PersonDao(dsl).getActiveByUserEmail("jane.doe@example.org");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).andNot(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualActiveByUserEmail instanceof ImmutablePerson);
    assertEquals("42", actualActiveByUserEmail.employeeId());
    assertEquals("42", actualActiveByUserEmail.userId());
    assertEquals("Display Name", actualActiveByUserEmail.displayName());
    assertEquals("Display Name", actualActiveByUserEmail.name());
    assertEquals("jane.doe@example.org", actualActiveByUserEmail.email());
    assertEquals(EntityKind.ALL, actualActiveByUserEmail.kind());
    assertEquals(PersonKind.EMPLOYEE, actualActiveByUserEmail.personKind());
    assertTrue(actualActiveByUserEmail.isRemoved());
  }

  /**
   * Test {@link PersonDao#findDirectsByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findDirectsByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findDirectsByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findDirectsByEmployeeId(String)"})
  void testFindDirectsByEmployeeId_thenReturnEmpty() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindDirectsByEmployeeIdResult =
        new PersonDao(dsl).findDirectsByEmployeeId("42");

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findAllManagersByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllManagersByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findAllManagersByEmployeeId(String)"})
  void testFindAllManagersByEmployeeId_thenReturnEmpty() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindAllManagersByEmployeeIdResult =
        new PersonDao(dsl).findAllManagersByEmployeeId("42");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualAllResult = new PersonDao(dsl).all();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindPersonsByAttestationInstanceIdResult =
        new PersonDao(dsl).findPersonsByAttestationInstanceId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); given minus one; when HashSet() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByIds(Set)"})
  void testFindByIds_givenMinusOne_whenHashSetAddMinusOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    HashSet<Long> ids = new HashSet<>();
    ids.add(-1L);
    ids.add(1L);

    // Act
    Set<Person> actualFindByIdsResult = personDao.findByIds(ids);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao#PersonDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findByIds(Set); given PersonDao(DSLContext) with dsl is DSLContext; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByIds(Set)"})
  void testFindByIds_givenPersonDaoWithDslIsDSLContext_whenHashSetAddOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    HashSet<Long> ids = new HashSet<>();
    ids.add(1L);

    // Act
    Set<Person> actualFindByIdsResult = personDao.findByIds(ids);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  @DisplayName("Test findByIds(Set); given PersonDao; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByIds(Set)"})
  void testFindByIds_givenPersonDao_whenHashSet() throws DataAccessException {
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
   *   <li>Given empty string.
   *   <li>When {@link HashSet#HashSet()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); given empty string; when HashSet() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_givenEmptyString_whenHashSetAddEmptyString()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    HashSet<String> empIds = new HashSet<>();
    empIds.add("");
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personDao.findByEmployeeIds(empIds);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao#PersonDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findByEmployeeIds(Set); given PersonDao(DSLContext) with dsl is DSLContext; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_givenPersonDaoWithDslIsDSLContext_whenHashSetAddFoo()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    HashSet<String> empIds = new HashSet<>();
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personDao.findByEmployeeIds(empIds);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); given PersonDao; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_givenPersonDao_whenHashSet() throws DataAccessException {
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
   *   <li>Given empty string.
   *   <li>When {@link HashSet#HashSet()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName(
      "Test findActivePeopleByEmails(Set); given empty string; when HashSet() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_givenEmptyString_whenHashSetAddEmptyString()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    HashSet<String> emails = new HashSet<>();
    emails.add("");
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personDao.findActivePeopleByEmails(emails);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao#PersonDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName(
      "Test findActivePeopleByEmails(Set); given PersonDao(DSLContext) with dsl is DSLContext; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_givenPersonDaoWithDslIsDSLContext_whenHashSetAddFoo()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    HashSet<String> emails = new HashSet<>();
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personDao.findActivePeopleByEmails(emails);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonDao#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); given PersonDao; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonDao.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_givenPersonDao_whenHashSet() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<Person> actualFindActivePeopleByUserRoleResult =
        new PersonDao(dsl).findActivePeopleByUserRole("Role");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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
   *   <li>Given minus one.
   *   <li>When {@link ArrayList#ArrayList()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link PersonDao#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName(
      "Test findDirectsForPersonIds(List); given minus one; when ArrayList() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonDao.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_givenMinusOne_whenArrayListAddMinusOne()
      throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(-1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personDao.findDirectsForPersonIds(personIds);

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(1L);
    personIds.add(-1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personDao.findDirectsForPersonIds(personIds);

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PersonDao personDao = new PersonDao(dsl);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult =
        personDao.findDirectsForPersonIds(new ArrayList<>());

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }
}
