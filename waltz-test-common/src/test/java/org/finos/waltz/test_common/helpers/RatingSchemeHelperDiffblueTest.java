package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.schema.tables.records.AccessLogRecord;
import org.finos.waltz.schema.tables.records.RatingSchemeRecord;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class RatingSchemeHelperDiffblueTest {
  /**
   * Method under test: {@link RatingSchemeHelper#createEmptyRatingScheme(String)}
   */
  @Test
  void testCreateEmptyRatingScheme() throws DataAccessException {
    // Arrange
    RatingSchemeHelper ratingSchemeHelper = new RatingSchemeHelper();
    ReflectionTestUtils.setField(ratingSchemeHelper, "ratingSchemeService", mock(RatingSchemeService.class));
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.<Object>of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<Object>>any())).thenReturn(selectJoinStep);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dslContext.newRecord(Mockito.<Table<RatingSchemeRecord>>any())).thenReturn(new RatingSchemeRecord());
    when(dslContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);
    ReflectionTestUtils.setField(ratingSchemeHelper, "dsl", dslContext);

    // Act
    long actualCreateEmptyRatingSchemeResult = ratingSchemeHelper.createEmptyRatingScheme("Name");

    // Assert
    verify(dslContext).newRecord(Mockito.<Table<Record>>any());
    verify(dslContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateEmptyRatingSchemeResult);
  }

  /**
   * Method under test:
   * {@link RatingSchemeHelper#saveRatingItem(long, String, int, String, String)}
   */
  @Test
  void testSaveRatingItem() {
    // Arrange
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.saveRatingItem(anyLong(), Mockito.<RatingSchemeItem>any())).thenReturn(1L);
    RatingSchemeHelper ratingSchemeHelper = new RatingSchemeHelper();
    ReflectionTestUtils.setField(ratingSchemeHelper, "ratingSchemeService", ratingSchemeService);
    ReflectionTestUtils.setField(ratingSchemeHelper, "dsl", mock(DSLContext.class));

    // Act
    Long actualSaveRatingItemResult = ratingSchemeHelper.saveRatingItem(1L, "Name", 1, "Color", "Code");

    // Assert
    verify(ratingSchemeService).saveRatingItem(eq(1L), isA(RatingSchemeItem.class));
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Method under test:
   * {@link RatingSchemeHelper#saveRatingItem(long, String, int, String, String, String)}
   */
  @Test
  void testSaveRatingItem2() {
    // Arrange
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.saveRatingItem(anyLong(), Mockito.<RatingSchemeItem>any())).thenReturn(1L);
    RatingSchemeHelper ratingSchemeHelper = new RatingSchemeHelper();
    ReflectionTestUtils.setField(ratingSchemeHelper, "ratingSchemeService", ratingSchemeService);
    ReflectionTestUtils.setField(ratingSchemeHelper, "dsl", mock(DSLContext.class));

    // Act
    long actualSaveRatingItemResult = ratingSchemeHelper.saveRatingItem(1L, "Name", 1, "Color", "Code", "42");

    // Assert
    verify(ratingSchemeService).saveRatingItem(eq(1L), isA(RatingSchemeItem.class));
    assertEquals(1L, actualSaveRatingItemResult);
  }
}
