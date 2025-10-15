package org.finos.waltz.data.user;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.user.UserPreference;
import org.finos.waltz.schema.tables.records.UserPreferenceRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
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
class UserPreferenceDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private UserPreferenceDao userPreferenceDao;

  /**
   * Test {@link UserPreferenceDao#getPreferencesForUser(String)}.
   *
   * <p>Method under test: {@link UserPreferenceDao#getPreferencesForUser(String)}
   */
  @Test
  @DisplayName("Test getPreferencesForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserPreferenceDao.getPreferencesForUser(String)"})
  void testGetPreferencesForUser() throws DataAccessException {
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
    List<UserPreference> actualPreferencesForUser =
        userPreferenceDao.getPreferencesForUser("janedoe");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualPreferencesForUser.isEmpty());
  }

  /**
   * Test {@link UserPreferenceDao#clearPreferencesForUser(String)}.
   *
   * <p>Method under test: {@link UserPreferenceDao#clearPreferencesForUser(String)}
   */
  @Test
  @DisplayName("Test clearPreferencesForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserPreferenceDao.clearPreferencesForUser(String)"})
  void testClearPreferencesForUser() throws DataAccessException {
    // Arrange
    DeleteConditionStep<UserPreferenceRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<UserPreferenceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<UserPreferenceRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    userPreferenceDao.clearPreferencesForUser("janedoe");

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }
}
