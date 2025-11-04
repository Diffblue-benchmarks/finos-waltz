package org.finos.waltz.data.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.assessment_definition.AssessmentRipplerJobConfiguration;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.InsertQuery;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.TableImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingRipplerDiffblueTest {
  /**
   * Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  void testRippleAssessments() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Long actualRippleAssessmentsResult = (new AssessmentRatingRippler(dsl, settingsDao)).rippleAssessments();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertEquals(0L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  void testRippleAssessments2() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any())).thenReturn(1L);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Long actualRippleAssessmentsResult = (new AssessmentRatingRippler(dsl, settingsDao)).rippleAssessments();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
    assertEquals(1L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String, String, String, String, Optional)}
   */
  @Test
  void testRippleAssessment() throws DataAccessException {
    // Arrange
    SelectConditionStep<AssessmentDefinitionRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(Mockito.<RecordMapper<AssessmentDefinitionRecord, Object>>any()))
        .thenThrow(new UnsupportedOperationException("Cannot ripple assessment as definition: %s not found"));
    SelectWhereStep<AssessmentDefinitionRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.selectFrom(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(selectWhereStep);
    when(tx.insertQuery(Mockito.<Table<Record>>any())).thenReturn(mock(InsertQuery.class));
    tx.insertQuery(new TableImpl<>("Name"));
    Optional<IdSelectionOptions> scope = Optional.of(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> AssessmentRatingRippler.rippleAssessment(tx, "42",
        "Provenance", "jane.doe@example.org", "alice.liddell@example.org", scope));
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    verify(tx).insertQuery(isA(Table.class));
    verify(tx).selectFrom(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String, String, String, String, Optional)}
   */
  @Test
  void testRippleAssessment2() throws DataAccessException {
    // Arrange
    AssessmentDefinitionRecord assessmentDefinitionRecord = mock(AssessmentDefinitionRecord.class);
    when(assessmentDefinitionRecord.getRatingSchemeId()).thenThrow(new IllegalArgumentException("foo"));

    HashMap<Object, AssessmentDefinitionRecord> objectAssessmentDefinitionRecordMap = new HashMap<>();
    objectAssessmentDefinitionRecordMap.put("42", assessmentDefinitionRecord);
    SelectConditionStep<AssessmentDefinitionRecord> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(Mockito.<RecordMapper<AssessmentDefinitionRecord, Object>>any()))
        .thenReturn(objectAssessmentDefinitionRecordMap);
    SelectWhereStep<AssessmentDefinitionRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    DefaultDSLContext tx = mock(DefaultDSLContext.class);
    when(tx.selectFrom(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(selectWhereStep);
    when(tx.insertQuery(Mockito.<Table<Record>>any())).thenReturn(mock(InsertQuery.class));
    tx.insertQuery(new TableImpl<>("Name"));
    Optional<IdSelectionOptions> scope = Optional.of(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AssessmentRatingRippler.rippleAssessment(tx, "42", "Provenance", "42", "42", scope));
    verify(assessmentDefinitionRecord).getRatingSchemeId();
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
    verify(tx).insertQuery(isA(Table.class));
    verify(tx).selectFrom(isA(Table.class));
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig3() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig4() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException("job.RIPPLE_ASSESSMENTS."));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AssessmentRatingRippler(new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig());
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig5() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig6() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("jobURIPPLE_ASSESSMENTSU", "jobURIPPLE_ASSESSMENTSU");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig7() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "42");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig8() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  void testFindRippleConfig9() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("jobURIPPLE_ASSESSMENTSU", "jobURIPPLE_ASSESSMENTSU");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "42");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult = (new AssessmentRatingRippler(
        new DefaultDSLContext(SQLDialect.SQL99), settingsDao)).findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix(eq("job.RIPPLE_ASSESSMENTS."));
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }
}
