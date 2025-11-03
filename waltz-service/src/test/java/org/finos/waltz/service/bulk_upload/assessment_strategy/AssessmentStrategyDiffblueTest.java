package org.finos.waltz.service.bulk_upload.assessment_strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
import java.util.List;
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
   * Test {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)}.
   * <p>
   * Method under test: {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)}
   */
  @Test
  @DisplayName("Test mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "AssessmentRatingRecord AssessmentStrategy.mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)"})
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
    when(tx.newRecord(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(assessmentRatingRecord);
    Tuple3<Long, Long, String> assessmentInfo = new Tuple3<>(1L, 1L, "V3");

    // Act
    AssessmentStrategy.mkAssessmentRatingRecord(tx, 1L, assessmentInfo, mock(Timestamp.class), "janedoe");

    // Assert
    verify(assessmentRatingRecord).setAssessmentDefinitionId(eq(1L));
    verify(assessmentRatingRecord).setDescription(eq("V3"));
    verify(assessmentRatingRecord).setEntityId(eq(1L));
    verify(assessmentRatingRecord).setEntityKind(eq("LEGAL_ENTITY_RELATIONSHIP"));
    verify(assessmentRatingRecord).setIsReadonly(eq(false));
    verify(assessmentRatingRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(assessmentRatingRecord).setLastUpdatedBy(eq("janedoe"));
    verify(assessmentRatingRecord).setProvenance(eq("waltz"));
    verify(assessmentRatingRecord).setRatingId(eq(1L));
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
   * Test {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)}.
   * <ul>
   *   <li>Given {@link AssessmentRatingRecord#AssessmentRatingRecord()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentStrategy#mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)}
   */
  @Test
  @DisplayName("Test mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String); given AssessmentRatingRecord()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "AssessmentRatingRecord AssessmentStrategy.mkAssessmentRatingRecord(DSLContext, Long, Tuple3, Timestamp, String)"})
  void testMkAssessmentRatingRecord_givenAssessmentRatingRecord() {
    // Arrange
    DSLContext tx = mock(DSLContext.class);
    when(tx.newRecord(Mockito.<Table<AssessmentRatingRecord>>any())).thenReturn(new AssessmentRatingRecord());

    // Act
    AssessmentStrategy.mkAssessmentRatingRecord(tx, 1L, new Tuple3<>(1L, 1L, "V3"), mock(Timestamp.class), "janedoe");

    // Assert
    verify(tx).newRecord(isA(Table.class));
  }
}
