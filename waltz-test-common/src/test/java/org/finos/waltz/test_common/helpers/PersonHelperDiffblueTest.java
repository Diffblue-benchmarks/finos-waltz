package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.data.user.UserDao;
import org.finos.waltz.schema.tables.records.PersonRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class PersonHelperDiffblueTest {
  /**
   * Method under test: {@link PersonHelper#updateIsRemoved(Long, boolean)}
   */
  @Test
  void testUpdateIsRemoved() throws DataAccessException {
    // Arrange
    PersonHelper personHelper = new PersonHelper();
    ReflectionTestUtils.setField(personHelper, "userDao", mock(UserDao.class));
    UpdateConditionStep<PersonRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PersonRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PersonRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<PersonRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(personHelper, "dsl", dslContext);

    // Act
    boolean actualUpdateIsRemovedResult = personHelper.updateIsRemoved(1L, true);

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualUpdateIsRemovedResult);
  }

  /**
   * Method under test: {@link PersonHelper#updateIsRemoved(Long, boolean)}
   */
  @Test
  void testUpdateIsRemoved2() throws DataAccessException {
    // Arrange
    PersonHelper personHelper = new PersonHelper();
    ReflectionTestUtils.setField(personHelper, "userDao", mock(UserDao.class));
    UpdateConditionStep<PersonRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);
    UpdateSetMoreStep<PersonRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PersonRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<PersonRecord>>any())).thenReturn(updateSetFirstStep);
    ReflectionTestUtils.setField(personHelper, "dsl", dslContext);

    // Act
    boolean actualUpdateIsRemovedResult = personHelper.updateIsRemoved(1L, true);

    // Assert
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualUpdateIsRemovedResult);
  }

  /**
   * Method under test: {@link PersonHelper#updateManager(Long, Long)}
   */
  @Test
  void testUpdateManager() throws DataAccessException {
    // Arrange
    PersonHelper personHelper = new PersonHelper();
    ReflectionTestUtils.setField(personHelper, "userDao", mock(UserDao.class));
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<Field<Object>>any())).thenReturn("Fetch One");
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    UpdateConditionStep<PersonRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<PersonRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetFirstStep<PersonRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.update(Mockito.<Table<PersonRecord>>any())).thenReturn(updateSetFirstStep);
    when(dslContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    ReflectionTestUtils.setField(personHelper, "dsl", dslContext);

    // Act
    personHelper.updateManager(1L, 1L);

    // Assert
    verify(dslContext).select(isA(SelectField.class));
    verify(dslContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(selectConditionStep).fetchOne(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
