package org.finos.waltz.data.licence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.List;
import org.finos.waltz.model.licence.ImmutableSaveLicenceCommand;
import org.finos.waltz.model.licence.Licence;
import org.finos.waltz.model.licence.SaveLicenceCommand;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.LicenceRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.GroupField;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.NoDataFoundException;
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
class LicenceDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LicenceDao licenceDao;

  /**
   * Test {@link LicenceDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given DSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceDao.findAll()"})
  void testFindAll_givenDSLContextSelectThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link LicenceDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceDao.findAll()"})
  void testFindAll_givenSelectJoinStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Licence> actualFindAllResult = new LicenceDao(dsl).findAll();

    // Assert
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link LicenceDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep fetch(RecordMapper) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceDao.findAll()"})
  void testFindAll_givenSelectJoinStepFetchThrowNoDataFoundException_thenCallsSelect()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link LicenceDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DefaultDSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectSelectStep from(TableLike) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceDao.findAll()"})
  void testFindAll_givenSelectSelectStepFromThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).findAll());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link LicenceDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given DSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getById(long)"})
  void testGetById_givenDSLContextSelectThrowNoDataFoundException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link LicenceDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} return
   *       {@code null}.
   *   <li>Then calls {@link SelectConditionStep#fetchOneInto(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectConditionStep fetchOneInto(Class) return 'null'; then calls fetchOneInto(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getById(long)"})
  void testGetById_givenSelectConditionStepFetchOneIntoReturnNull_thenCallsFetchOneInto()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<LicenceRecord>>any())).thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} throw
   *       {@link NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectConditionStep fetchOneInto(Class) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getById(long)"})
  void testGetById_givenSelectConditionStepFetchOneIntoThrowNoDataFoundException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<LicenceRecord>>any()))
        .thenThrow(new NoDataFoundException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link SelectJoinStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectJoinStep where(Condition) throw NoDataFoundException(); then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getById(long)"})
  void testGetById_givenSelectJoinStepWhereThrowNoDataFoundException_thenCallsWhere() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link SelectSelectStep#from(TableLike)}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectSelectStep from(TableLike) throw NoDataFoundException(); then calls from(TableLike)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getById(long)"})
  void testGetById_givenSelectSelectStepFromThrowNoDataFoundException_thenCallsFrom() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getById(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link LicenceDao#getByExternalId(String)}.
   *
   * <p>Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getByExternalId(String)"})
  void testGetByExternalId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<LicenceRecord>>any()))
        .thenThrow(new NoDataFoundException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given DSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getByExternalId(String)"})
  void testGetByExternalId_givenDSLContextSelectThrowNoDataFoundException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link LicenceDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectConditionStep fetchOneInto(Class) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectConditionStepFetchOneIntoReturnNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<LicenceRecord>>any())).thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getByExternalId("42"));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} return
   *       {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectConditionStep fetchOneInto(Class) return 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectConditionStepFetchOneIntoReturnNull_whenNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<LicenceRecord>>any())).thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getByExternalId(null));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectJoinStep where(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectJoinStepWhereThrowNoDataFoundException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getByExternalId("42"));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link LicenceDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectSelectStep from(TableLike) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Licence LicenceDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectSelectStepFromThrowNoDataFoundException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).getByExternalId("42"));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link LicenceDao#countApplications()}.
   *
   * <ul>
   *   <li>Given {@link SelectHavingStep} {@link SelectHavingStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#countApplications()}
   */
  @Test
  @DisplayName(
      "Test countApplications(); given SelectHavingStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LicenceDao.countApplications()"})
  void testCountApplications_givenSelectHavingStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<Long>> actualCountApplicationsResult = licenceDao.countApplications();

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualCountApplicationsResult.isEmpty());
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnFalse()
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
    LicenceDao licenceDao = new LicenceDao(dsl);

    // Act
    boolean actualSaveResult =
        licenceDao.save(
            ImmutableSaveLicenceCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"licence\" set \"licence\".\"name\" = cast(? as varchar), \"licence\".\"description\" = cast(? as varchar), \"licence\".\"external_id\" = cast(? as varchar), \"licence\".\"last_updated_by\" = cast(? as varchar), \"licence\".\"last_updated_at\" = cast(? as datetime), \"licence\".\"provenance\" = cast(? as varchar) where \"licence\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    LicenceDao licenceDao = new LicenceDao(dsl);

    // Act
    boolean actualSaveResult =
        licenceDao.save(
            ImmutableSaveLicenceCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"licence\" set \"licence\".\"name\" = cast(? as varchar(4)), \"licence\".\"description\" = cast(? as varchar(43)), \"licence\".\"external_id\" = cast(? as varchar(2)), \"licence\".\"last_updated_by\" = cast(? as varchar(7)), \"licence\".\"last_updated_at\" = cast(? as timestamp), \"licence\".\"provenance\" = cast(? as varchar(5)) where \"licence\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
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
    LicenceDao licenceDao = new LicenceDao(dsl);

    // Act
    boolean actualSaveResult =
        licenceDao.save(
            ImmutableSaveLicenceCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"licence\" set \"licence\".\"name\" = ?, \"licence\".\"description\" = ?, \"licence\".\"external_id\" = ?, \"licence\".\"last_updated_by\" = ?, \"licence\".\"last_updated_at\" = ?, \"licence\".\"provenance\" = ? where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code false}.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given PreparedStatement execute() return 'false'; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_givenPreparedStatementExecuteReturnFalse_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LicenceDao licenceDao = new LicenceDao(dsl);

    // Act
    boolean actualSaveResult =
        licenceDao.save(
            ImmutableSaveLicenceCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"licence\" set \"licence\".\"name\" = ?, \"licence\".\"description\" = ?, \"licence\".\"external_id\" = ?, \"licence\".\"last_updated_by\" = ?, \"licence\".\"last_updated_at\" = ?, \"licence\".\"provenance\" = ? where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LicenceDao licenceDao = new LicenceDao(dsl);

    // Act
    boolean actualSaveResult =
        licenceDao.save(
            ImmutableSaveLicenceCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"licence\" set \"licence\".\"name\" = ?, \"licence\".\"description\" = ?, \"licence\".\"external_id\" = ?, \"licence\".\"last_updated_by\" = ?, \"licence\".\"last_updated_at\" = ?, \"licence\".\"provenance\" = ? where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveLicenceCommand, String); given PreparedStatement setNull(int, int) does nothing; then calls setNull(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_givenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LicenceDao licenceDao = new LicenceDao(dsl);

    // Act
    boolean actualSaveResult =
        licenceDao.save(
            ImmutableSaveLicenceCommand.builder()
                .description(null)
                .externalId("42")
                .id(1L)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"licence\" set \"licence\".\"name\" = ?, \"licence\".\"description\" = ?, \"licence\".\"external_id\" = ?, \"licence\".\"last_updated_by\" = ?, \"licence\".\"last_updated_at\" = ?, \"licence\".\"provenance\" = ? where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement).setNull(2, 12);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link LicenceDao#save(SaveLicenceCommand, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NoDataFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveLicenceCommand, String); then throw NoDataFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.save(SaveLicenceCommand, String)"})
  void testSave_thenThrowNoDataFoundException() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<LicenceRecord>>any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.save(null, "janedoe"));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#deleteFrom(Table)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext deleteFrom(Table) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDefaultDSLContextDeleteFromThrowNoDataFoundException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LicenceRecord>>any())).thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).remove(1L));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"licence\" where \"licence\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsMariadb() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);

    // Act
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(connection).prepareStatement("delete from `licence` where `licence`.`id` = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(connection).prepareStatement("delete from \"licence\" where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
      throws SQLException {
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
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(connection).prepareStatement("delete from \"licence\" where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);

    // Act
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(connection).prepareStatement("delete from licence where licence.id = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<LicenceRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<LicenceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LicenceRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteUsingStep where(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenDeleteUsingStepWhereThrowNoDataFoundException() {
    // Arrange
    DeleteUsingStep<LicenceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LicenceRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new LicenceDao(dsl).remove(1L));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given PreparedStatement getWarnings() return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_givenPreparedStatementGetWarningsReturnNull_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualRemoveResult = new LicenceDao(dsl).remove(1L);

    // Assert
    verify(connection).prepareStatement("delete from \"licence\" where \"licence\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link LicenceDao#remove(long)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LicenceDao.remove(long)"})
  void testRemove_thenCallsDeleteFrom() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LicenceRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new NoDataFoundException());

    DeleteUsingStep<LicenceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<LicenceRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.remove(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }
}
