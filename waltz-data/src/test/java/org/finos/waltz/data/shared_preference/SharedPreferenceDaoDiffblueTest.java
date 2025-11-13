package org.finos.waltz.data.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreference;
import org.finos.waltz.model.shared_preference.SharedPreference;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;
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
class SharedPreferenceDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SharedPreferenceDao sharedPreferenceDao;

  /**
   * Test {@link SharedPreferenceDao#getPreference(String, String)}.
   *
   * <p>Method under test: {@link SharedPreferenceDao#getPreference(String, String)}
   */
  @Test
  @DisplayName("Test getPreference(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SharedPreference SharedPreferenceDao.getPreference(String, String)"})
  void testGetPreference() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    SharedPreference actualPreference =
        new SharedPreferenceDao(dsl).getPreference("Key", "Category");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualPreference instanceof ImmutableSharedPreference);
    LocalDateTime lastUpdatedAtResult = actualPreference.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualPreference.lastUpdatedBy());
    assertEquals("42", actualPreference.value());
    assertEquals("Category", actualPreference.category());
    assertEquals("Key", actualPreference.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SharedPreferenceDao#findPreferencesByCategory(String)}.
   *
   * <p>Method under test: {@link SharedPreferenceDao#findPreferencesByCategory(String)}
   */
  @Test
  @DisplayName("Test findPreferencesByCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SharedPreferenceDao.findPreferencesByCategory(String)"})
  void testFindPreferencesByCategory() throws DataAccessException {
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
    List<SharedPreference> actualFindPreferencesByCategoryResult =
        new SharedPreferenceDao(dsl).findPreferencesByCategory("Category");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindPreferencesByCategoryResult.isEmpty());
  }

  /**
   * Test {@link SharedPreferenceDao#savePreference(SharedPreference)}.
   *
   * <ul>
   *   <li>Given {@code 2020-03-01}.
   *   <li>Then calls {@link SharedPreference#lastUpdatedAt()}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceDao#savePreference(SharedPreference)}
   */
  @Test
  @DisplayName(
      "Test savePreference(SharedPreference); given '2020-03-01'; then calls lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SharedPreferenceDao.savePreference(SharedPreference)"})
  void testSavePreference_given20200301_thenCallsLastUpdatedAt() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    SharedPreference sharedPreference = mock(SharedPreference.class);
    when(sharedPreference.lastUpdatedBy()).thenReturn("2020-03-01");
    when(sharedPreference.value()).thenReturn("42");
    when(sharedPreference.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(sharedPreference.category()).thenReturn("Category");
    when(sharedPreference.key()).thenReturn("Key");

    // Act
    boolean actualSavePreferenceResult = sharedPreferenceDao.savePreference(sharedPreference);

    // Assert
    verify(sharedPreference).lastUpdatedAt();
    verify(sharedPreference).lastUpdatedBy();
    verify(sharedPreference, atLeast(1)).category();
    verify(sharedPreference, atLeast(1)).key();
    verify(sharedPreference).value();
    verify(dSLContext).executeUpdate(isA(UpdatableRecord.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSavePreferenceResult);
  }

  /**
   * Test {@link SharedPreferenceDao#savePreference(SharedPreference)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeUpdate(UpdatableRecord)} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceDao#savePreference(SharedPreference)}
   */
  @Test
  @DisplayName(
      "Test savePreference(SharedPreference); given DSLContext executeUpdate(UpdatableRecord) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SharedPreferenceDao.savePreference(SharedPreference)"})
  void testSavePreference_givenDSLContextExecuteUpdateReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(1);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    SharedPreferenceDao sharedPreferenceDao = new SharedPreferenceDao(dsl);

    // Act
    boolean actualSavePreferenceResult =
        sharedPreferenceDao.savePreference(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    // Assert
    verify(dsl).executeUpdate(isA(UpdatableRecord.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSavePreferenceResult);
  }

  /**
   * Test {@link SharedPreferenceDao#savePreference(SharedPreference)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeUpdate(UpdatableRecord)} return two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceDao#savePreference(SharedPreference)}
   */
  @Test
  @DisplayName(
      "Test savePreference(SharedPreference); given DSLContext executeUpdate(UpdatableRecord) return two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SharedPreferenceDao.savePreference(SharedPreference)"})
  void testSavePreference_givenDSLContextExecuteUpdateReturnTwo_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeUpdate(Mockito.<UpdatableRecord<?>>any())).thenReturn(2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    SharedPreferenceDao sharedPreferenceDao = new SharedPreferenceDao(dsl);

    // Act
    boolean actualSavePreferenceResult =
        sharedPreferenceDao.savePreference(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    // Assert
    verify(dsl).executeUpdate(isA(UpdatableRecord.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertFalse(actualSavePreferenceResult);
  }

  /**
   * Test {@link SharedPreferenceDao#savePreference(SharedPreference)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#executeInsert(TableRecord)}.
   * </ul>
   *
   * <p>Method under test: {@link SharedPreferenceDao#savePreference(SharedPreference)}
   */
  @Test
  @DisplayName("Test savePreference(SharedPreference); then calls executeInsert(TableRecord)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SharedPreferenceDao.savePreference(SharedPreference)"})
  void testSavePreference_thenCallsExecuteInsert() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    SharedPreferenceDao sharedPreferenceDao = new SharedPreferenceDao(dsl);

    // Act
    boolean actualSavePreferenceResult =
        sharedPreferenceDao.savePreference(
            ImmutableSharedPreference.builder()
                .category("Category")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .value("42")
                .build());

    // Assert
    verify(dsl).executeInsert(isA(TableRecord.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualSavePreferenceResult);
  }
}
