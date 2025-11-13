package org.finos.waltz.service.bulk_upload.assessment_strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import java.util.List;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.finos.waltz.schema.tables.records.AssessmentRatingRecord;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentStrategyDiffblueTest {
  /**
   * Test {@link AssessmentStrategy#determineStrategy(BulkUpdateMode, Cardinality)}.
   *
   * <ul>
   *   <li>Then return {@link AddOnlyMultiValuedDefinitionStrategy}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentStrategy#determineStrategy(BulkUpdateMode, Cardinality)}
   */
  @Test
  @DisplayName(
      "Test determineStrategy(BulkUpdateMode, Cardinality); then return AddOnlyMultiValuedDefinitionStrategy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentStrategy AssessmentStrategy.determineStrategy(BulkUpdateMode, Cardinality)"
  })
  void testDetermineStrategy_thenReturnAddOnlyMultiValuedDefinitionStrategy() {
    // Arrange, Act and Assert
    assertTrue(
        AssessmentStrategy.determineStrategy(BulkUpdateMode.ADD_ONLY, Cardinality.ZERO_MANY)
            instanceof AddOnlyMultiValuedDefinitionStrategy);
  }

  /**
   * Test {@link AssessmentStrategy#determineStrategy(BulkUpdateMode, Cardinality)}.
   *
   * <ul>
   *   <li>Then return {@link AddOnlySingleValuedDefinitionStrategy}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentStrategy#determineStrategy(BulkUpdateMode, Cardinality)}
   */
  @Test
  @DisplayName(
      "Test determineStrategy(BulkUpdateMode, Cardinality); then return AddOnlySingleValuedDefinitionStrategy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentStrategy AssessmentStrategy.determineStrategy(BulkUpdateMode, Cardinality)"
  })
  void testDetermineStrategy_thenReturnAddOnlySingleValuedDefinitionStrategy() {
    // Arrange, Act and Assert
    assertTrue(
        AssessmentStrategy.determineStrategy(BulkUpdateMode.ADD_ONLY, Cardinality.ZERO_ONE)
            instanceof AddOnlySingleValuedDefinitionStrategy);
  }

  /**
   * Test {@link AssessmentStrategy#determineStrategy(BulkUpdateMode, Cardinality)}.
   *
   * <ul>
   *   <li>When {@code REPLACE}.
   *   <li>Then return {@link ReplaceStrategy}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentStrategy#determineStrategy(BulkUpdateMode, Cardinality)}
   */
  @Test
  @DisplayName(
      "Test determineStrategy(BulkUpdateMode, Cardinality); when 'REPLACE'; then return ReplaceStrategy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentStrategy AssessmentStrategy.determineStrategy(BulkUpdateMode, Cardinality)"
  })
  void testDetermineStrategy_whenReplace_thenReturnReplaceStrategy() {
    // Arrange, Act and Assert
    assertTrue(
        AssessmentStrategy.determineStrategy(BulkUpdateMode.REPLACE, Cardinality.ZERO_ONE)
            instanceof ReplaceStrategy);
  }

  /**
   * Test {@link AssessmentStrategy#determineAddOnlyStrategy(Cardinality)}.
   *
   * <ul>
   *   <li>Then return {@link AddOnlyMultiValuedDefinitionStrategy}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentStrategy#determineAddOnlyStrategy(Cardinality)}
   */
  @Test
  @DisplayName(
      "Test determineAddOnlyStrategy(Cardinality); then return AddOnlyMultiValuedDefinitionStrategy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentStrategy AssessmentStrategy.determineAddOnlyStrategy(Cardinality)"})
  void testDetermineAddOnlyStrategy_thenReturnAddOnlyMultiValuedDefinitionStrategy() {
    // Arrange, Act and Assert
    assertTrue(
        AssessmentStrategy.determineAddOnlyStrategy(Cardinality.ZERO_MANY)
            instanceof AddOnlyMultiValuedDefinitionStrategy);
  }

  /**
   * Test {@link AssessmentStrategy#determineAddOnlyStrategy(Cardinality)}.
   *
   * <ul>
   *   <li>Then return {@link AddOnlySingleValuedDefinitionStrategy}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentStrategy#determineAddOnlyStrategy(Cardinality)}
   */
  @Test
  @DisplayName(
      "Test determineAddOnlyStrategy(Cardinality); then return AddOnlySingleValuedDefinitionStrategy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentStrategy AssessmentStrategy.determineAddOnlyStrategy(Cardinality)"})
  void testDetermineAddOnlyStrategy_thenReturnAddOnlySingleValuedDefinitionStrategy() {
    // Arrange, Act and Assert
    assertTrue(
        AssessmentStrategy.determineAddOnlyStrategy(Cardinality.ZERO_ONE)
            instanceof AddOnlySingleValuedDefinitionStrategy);
  }

  /**
   * Test {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp,
   * String)}.
   *
   * <p>Method under test: {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long,
   * Tuple3, Timestamp, String)}
   */
  @Test
  @DisplayName("Test mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingRecord AssessmentStrategy.mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)"
  })
  void testMkAssessmentRatingRecord() {
    // Arrange
    AssessmentRatingRecord assessmentRatingRecord = mock(AssessmentRatingRecord.class);
    doNothing().when(assessmentRatingRecord).setAssessmentDefinitionId(Mockito.<Long>any());
    doNothing().when(assessmentRatingRecord).setDescription(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setEntityId(Mockito.<Long>any());
    doNothing().when(assessmentRatingRecord).setEntityKind(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setIsReadonly(Mockito.<Boolean>any());
    doNothing().when(assessmentRatingRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(assessmentRatingRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setProvenance(Mockito.<String>any());
    doNothing().when(assessmentRatingRecord).setRatingId(Mockito.<Long>any());

    DSLContext tx = mock(DSLContext.class);
    when(tx.newRecord(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(assessmentRatingRecord);
    Tuple3<Long, Long, String> assessmentInfo = new Tuple3<>(1L, 1L, "V3");

    // Act
    AssessmentStrategy.mkAssessmentRatingRecord(tx, 1L, assessmentInfo, null, "janedoe");

    // Assert
    verify(assessmentRatingRecord).setAssessmentDefinitionId(1L);
    verify(assessmentRatingRecord).setDescription("V3");
    verify(assessmentRatingRecord).setEntityId(1L);
    verify(assessmentRatingRecord).setEntityKind("LEGAL_ENTITY_RELATIONSHIP");
    verify(assessmentRatingRecord).setIsReadonly(false);
    verify(assessmentRatingRecord).setLastUpdatedAt(isNull());
    verify(assessmentRatingRecord).setLastUpdatedBy("janedoe");
    verify(assessmentRatingRecord).setProvenance("waltz");
    verify(assessmentRatingRecord).setRatingId(1L);
    verify(tx).newRecord(isA(Table.class));
    List<?> toListResult = assessmentInfo.toList();
    assertEquals(3, toListResult.size());
    Object getResult = toListResult.get(0);
    assertEquals(1L, ((Long) getResult).longValue());
    Long resultLong = assessmentInfo.v2;
    assertSame(resultLong, getResult);
    assertSame(resultLong, toListResult.get(1));
  }

  /**
   * Test {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentRatingRecord#AssessmentRatingRecord()}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long,
   * Tuple3, Timestamp, String)}
   */
  @Test
  @DisplayName(
      "Test mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String); given AssessmentRatingRecord()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRatingRecord AssessmentStrategy.mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)"
  })
  void testMkAssessmentRatingRecord_givenAssessmentRatingRecord() {
    // Arrange
    DSLContext tx = mock(DSLContext.class);
    when(tx.newRecord(Mockito.<Table<AssessmentRatingRecord>>any()))
        .thenReturn(new AssessmentRatingRecord());

    // Act
    AssessmentStrategy.mkAssessmentRatingRecord(
        tx, 1L, new Tuple3<>(1L, 1L, "V3"), null, "janedoe");

    // Assert
    verify(tx).newRecord(isA(Table.class));
  }
}
