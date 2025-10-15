package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.schema.tables.records.ApplicationGroupOuEntryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
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
class AppGroupOrganisationalUnitDaoDiffblueTest {
  @InjectMocks private AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AppGroupOrganisationalUnitDao#getEntriesForGroup(long)}.
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#getEntriesForGroup(long)}
   */
  @Test
  @DisplayName("Test getEntriesForGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupOrganisationalUnitDao.getEntriesForGroup(long)"})
  void testGetEntriesForGroup() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    List<AppGroupEntry> actualEntriesForGroup =
        appGroupOrganisationalUnitDao.getEntriesForGroup(1L);

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualEntriesForGroup.isEmpty());
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenFour() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = appGroupOrganisationalUnitDao.removeOrgUnit(4L, 1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenOne() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = appGroupOrganisationalUnitDao.removeOrgUnit(1L, 1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = appGroupOrganisationalUnitDao.removeOrgUnit(3L, 1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test removeOrgUnit(long, long); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.removeOrgUnit(long, long)"})
  void testRemoveOrgUnit_whenTwo() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = appGroupOrganisationalUnitDao.removeOrgUnit(2L, 1L);

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenFour() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = appGroupOrganisationalUnitDao.addOrgUnit(4L, 1L);

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenOne() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = appGroupOrganisationalUnitDao.addOrgUnit(1L, 1L);

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = appGroupOrganisationalUnitDao.addOrgUnit(3L, 1L);

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Test {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  @DisplayName("Test addOrgUnit(long, long); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupOrganisationalUnitDao.addOrgUnit(long, long)"})
  void testAddOrgUnit_whenTwo() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);
    when(dSLContext.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = appGroupOrganisationalUnitDao.addOrgUnit(2L, 1L);

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }
}
