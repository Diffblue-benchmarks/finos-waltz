package org.finos.waltz.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.waltz.model.settings.ImmutableUpdateSettingsCommand;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.model.settings.UpdateSettingsCommand;
import org.finos.waltz.schema.tables.records.SettingsRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
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
class SettingsDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SettingsDao settingsDao;

  /**
   * Test {@link SettingsDao#findAll()}.
   *
   * <p>Method under test: {@link SettingsDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SettingsDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any())).thenReturn(objectList);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Collection<Setting> actualFindAllResult = settingsDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(objectList, actualFindAllResult);
  }

  /**
   * Test {@link SettingsDao#indexByPrefix(String)}.
   *
   * <p>Method under test: {@link SettingsDao#indexByPrefix(String)}
   */
  @Test
  @DisplayName("Test indexByPrefix(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SettingsDao.indexByPrefix(String)"})
  void testIndexByPrefix() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<Field<Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
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
    Map<String, String> actualIndexByPrefixResult = settingsDao.indexByPrefix("Prefix");

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchMap(isA(Field.class), isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualIndexByPrefixResult.isEmpty());
  }

  /**
   * Test {@link SettingsDao#update(UpdateSettingsCommand)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SettingsDao#update(UpdateSettingsCommand)}
   */
  @Test
  @DisplayName(
      "Test update(UpdateSettingsCommand); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SettingsDao.update(UpdateSettingsCommand)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<SettingsRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<SettingsRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<SettingsRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<SettingsRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<SettingsRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateResult =
        settingsDao.update(
            ImmutableUpdateSettingsCommand.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateResult);
  }
}
