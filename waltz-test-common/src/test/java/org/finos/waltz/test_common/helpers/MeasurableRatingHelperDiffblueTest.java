package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.schema.tables.records.AccessLogRecord;
import org.finos.waltz.schema.tables.records.MeasurableRatingRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Select;
import org.jooq.Table;
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
class MeasurableRatingHelperDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private MeasurableRatingHelper measurableRatingHelper;

  /**
   * Test {@link MeasurableRatingHelper#saveRatingItem(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingHelper#saveRatingItem(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(EntityReference, long, String, String); given DSLContext fetchExists(Select) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingHelper.saveRatingItem(EntityReference, long, String, String)"
  })
  void testSaveRatingItem_givenDSLContextFetchExistsReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.newRecord(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(new MeasurableRatingRecord());

    // Act
    boolean actualSaveRatingItemResult =
        measurableRatingHelper.saveRatingItem(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "Rating Code",
            "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingHelper#saveRatingItem(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return twelve.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingHelper#saveRatingItem(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(EntityReference, long, String, String); given UpdateConditionStep execute() return twelve; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingHelper.saveRatingItem(EntityReference, long, String, String)"
  })
  void testSaveRatingItem_givenUpdateConditionStepExecuteReturnTwelve_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(12);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.newRecord(Mockito.<Table<Record>>any())).thenReturn(new AccessLogRecord());
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);
    when(dSLContext.newRecord(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(new MeasurableRatingRecord());

    // Act
    boolean actualSaveRatingItemResult =
        measurableRatingHelper.saveRatingItem(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "Rating Code",
            "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).newRecord(Mockito.<Table<Record>>any());
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualSaveRatingItemResult);
  }
}
