package org.finos.waltz.data.user;

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
import org.finos.waltz.schema.tables.records.UserRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private UserDao userDao;

  /**
   * Test {@link UserDao#getPassword(String)}.
   *
   * <p>Method under test: {@link UserDao#getPassword(String)}
   */
  @Test
  @DisplayName("Test getPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserDao.getPassword(String)"})
  void testGetPassword() throws DataAccessException {
    // Arrange
    Record1<Object> record1 = mock(Record1.class);
    when(record1.value1()).thenReturn("Value1");

    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne()).thenReturn(record1);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    String actualPassword = userDao.getPassword("janedoe");

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(record1).value1();
    verify(selectConditionStep).fetchOne();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals("Value1", actualPassword);
  }

  /**
   * Test {@link UserDao#create(String, String)}.
   *
   * <p>Method under test: {@link UserDao#create(String, String)}
   */
  @Test
  @DisplayName("Test create(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserDao.create(String, String)"})
  void testCreate() throws DataAccessException {
    // Arrange
    InsertReturningStep<UserRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(1);

    InsertSetMoreStep<UserRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<UserRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<UserRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);
    when(dSLContext.insertInto(Mockito.<Table<UserRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualCreateResult = userDao.create("janedoe", "Password Hash");

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link UserDao#findAllUserNames()}.
   *
   * <p>Method under test: {@link UserDao#findAllUserNames()}
   */
  @Test
  @DisplayName("Test findAllUserNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserDao.findAllUserNames()"})
  void testFindAllUserNames() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    List<String> actualFindAllUserNamesResult = userDao.findAllUserNames();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectJoinStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllUserNamesResult.isEmpty());
  }

  /**
   * Test {@link UserDao#deleteUser(String)}.
   *
   * <p>Method under test: {@link UserDao#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserDao.deleteUser(String)"})
  void testDeleteUser() throws DataAccessException {
    // Arrange
    DeleteConditionStep<UserRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<UserRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.delete(Mockito.<Table<UserRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualDeleteUserResult = userDao.deleteUser("janedoe");

    // Assert
    verify(dSLContext).delete(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteUserResult);
  }

  /**
   * Test {@link UserDao#resetPassword(String, String)}.
   *
   * <p>Method under test: {@link UserDao#resetPassword(String, String)}
   */
  @Test
  @DisplayName("Test resetPassword(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserDao.resetPassword(String, String)"})
  void testResetPassword() throws DataAccessException {
    // Arrange
    UpdateConditionStep<UserRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<UserRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<UserRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<UserRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualResetPasswordResult = userDao.resetPassword("janedoe", "Password Hash");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualResetPasswordResult);
  }
}
