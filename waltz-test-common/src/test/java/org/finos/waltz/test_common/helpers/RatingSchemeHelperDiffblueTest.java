package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RatingSchemeHelperDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private RatingSchemeHelper ratingSchemeHelper;

  @Mock private RatingSchemeService ratingSchemeService;

  /**
   * Test {@link RatingSchemeHelper#createEmptyRatingScheme(String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeHelper#createEmptyRatingScheme(String)}
   */
  @Test
  @DisplayName("Test createEmptyRatingScheme(String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long RatingSchemeHelper.createEmptyRatingScheme(String)"})
  void testCreateEmptyRatingScheme_thenReturnOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    Optional<Object> ofResult = Optional.of(1L);
    when(selectConditionStep.fetchOptional(Mockito.<Field<Object>>any())).thenReturn(ofResult);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.newRecord(Mockito.<Table<RatingSchemeRecord>>any()))
        .thenReturn(new RatingSchemeRecord());
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    long actualCreateEmptyRatingSchemeResult = ratingSchemeHelper.createEmptyRatingScheme("Name");

    // Assert
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchOptional(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertEquals(1L, actualCreateEmptyRatingSchemeResult);
  }

  /**
   * Test {@link RatingSchemeHelper#saveRatingItem(long, String, int, String, String)} with {@code
   * schemeId}, {@code name}, {@code position}, {@code color}, {@code code}.
   *
   * <p>Method under test: {@link RatingSchemeHelper#saveRatingItem(long, String, int, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(long, String, int, String, String) with 'schemeId', 'name', 'position', 'color', 'code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RatingSchemeHelper.saveRatingItem(long, String, int, String, String)"})
  void testSaveRatingItemWithSchemeIdNamePositionColorCode() {
    // Arrange
    when(ratingSchemeService.saveRatingItem(anyLong(), Mockito.<RatingSchemeItem>any()))
        .thenReturn(1L);

    // Act
    Long actualSaveRatingItemResult =
        ratingSchemeHelper.saveRatingItem(1L, "Name", 1, "Color", "Code");

    // Assert
    verify(ratingSchemeService).saveRatingItem(eq(1L), isA(RatingSchemeItem.class));
    assertEquals(1L, actualSaveRatingItemResult.longValue());
  }

  /**
   * Test {@link RatingSchemeHelper#saveRatingItem(long, String, int, String, String, String)} with
   * {@code schemeId}, {@code name}, {@code position}, {@code color}, {@code code}, {@code
   * externalId}.
   *
   * <p>Method under test: {@link RatingSchemeHelper#saveRatingItem(long, String, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(long, String, int, String, String, String) with 'schemeId', 'name', 'position', 'color', 'code', 'externalId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long RatingSchemeHelper.saveRatingItem(long, String, int, String, String, String)"
  })
  void testSaveRatingItemWithSchemeIdNamePositionColorCodeExternalId() {
    // Arrange
    when(ratingSchemeService.saveRatingItem(anyLong(), Mockito.<RatingSchemeItem>any()))
        .thenReturn(1L);

    // Act
    long actualSaveRatingItemResult =
        ratingSchemeHelper.saveRatingItem(1L, "Name", 1, "Color", "Code", "42");

    // Assert
    verify(ratingSchemeService).saveRatingItem(eq(1L), isA(RatingSchemeItem.class));
    assertEquals(1L, actualSaveRatingItemResult);
  }
}
