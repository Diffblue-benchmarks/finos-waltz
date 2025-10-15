package org.finos.waltz.data.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.measurable_rating.ImmutableRemoveMeasurableRatingCommand;
import org.finos.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand;
import org.finos.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand.Builder;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating.RemoveMeasurableRatingCommand;
import org.finos.waltz.model.measurable_rating.SaveMeasurableRatingCommand;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.MeasurableRatingRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalCallable;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MeasurableRatingDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private MeasurableRatingDao measurableRatingDao;

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any()))
        .thenThrow(new NotFoundException("MR_SAVE_INSERT_FAILED", "An error occurred"));

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave2() throws DataAccessException {
    // Arrange
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave3() throws DataAccessException {
    // Arrange
    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave4() throws DataAccessException {
    // Arrange
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave5() throws DataAccessException {
    // Arrange
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave6() throws DataAccessException {
    // Arrange
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave7() throws DataAccessException {
    // Arrange
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave8() throws DataAccessException {
    // Arrange
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave9() throws DataAccessException {
    // Arrange
    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave10() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave11() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave12() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName("Test save(SaveMeasurableRatingCommand, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave13() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute())
        .thenThrow(new NotFoundException("MR_SAVE_UPDATE_FAILED", "An error occurred"));

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName(
      "Test save(SaveMeasurableRatingCommand, boolean); given PreparedStatement getResultSet() return 'null'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave_givenPreparedStatementGetResultSetReturnNull_thenCallsPrepareStatement()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setBoolean(6, true);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return {@code UPDATE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName(
      "Test save(SaveMeasurableRatingCommand, boolean); given UpdateConditionStep execute() return one; then return 'UPDATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave_givenUpdateConditionStepExecuteReturnOne_thenReturnUpdate()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act
    Operation actualSaveResult =
        measurableRatingDao.save(
            isPrimaryResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .previousRating('A')
                .provenance("Provenance")
                .rating('A')
                .build(),
            true);

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(Operation.UPDATE, actualSaveResult);
  }

  /**
   * Test {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return zero.
   *   <li>Then calls {@link UpdateConditionStep#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#save(SaveMeasurableRatingCommand, boolean)}
   */
  @Test
  @DisplayName(
      "Test save(SaveMeasurableRatingCommand, boolean); given UpdateConditionStep execute() return zero; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation MeasurableRatingDao.save(SaveMeasurableRatingCommand, boolean)"})
  void testSave_givenUpdateConditionStepExecuteReturnZero_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep =
        mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep2 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep3 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep3.and(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateConditionStep<MeasurableRatingRecord> updateConditionStep4 =
        mock(UpdateConditionStep.class);
    when(updateConditionStep4.and(Mockito.<Condition>any())).thenReturn(updateConditionStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetMoreStep<MeasurableRatingRecord> updateSetMoreStep6 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    UpdateSetFirstStep<MeasurableRatingRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep6);
    when(dSLContext.update(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.save(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build(),
                true));
    verify(dSLContext).fetchExists(isA(Select.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep4).and(isA(Condition.class));
    verify(updateConditionStep3).and(isA(Condition.class));
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test checkRatingExists(SaveMeasurableRatingCommand); given DSLContext fetchExists(Select) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.checkRatingExists(SaveMeasurableRatingCommand)"})
  void testCheckRatingExists_givenDSLContextFetchExistsReturnFalse_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act
    boolean actualCheckRatingExistsResult =
        measurableRatingDao.checkRatingExists(
            isPrimaryResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .previousRating('A')
                .provenance("Provenance")
                .rating('A')
                .build());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertFalse(actualCheckRatingExistsResult);
  }

  /**
   * Test {@link MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test checkRatingExists(SaveMeasurableRatingCommand); given DSLContext fetchExists(Select) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.checkRatingExists(SaveMeasurableRatingCommand)"})
  void testCheckRatingExists_givenDSLContextFetchExistsReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act
    boolean actualCheckRatingExistsResult =
        measurableRatingDao.checkRatingExists(
            isPrimaryResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .previousRating('A')
                .provenance("Provenance")
                .rating('A')
                .build());

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualCheckRatingExistsResult);
  }

  /**
   * Test {@link MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test checkRatingExists(SaveMeasurableRatingCommand); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.checkRatingExists(SaveMeasurableRatingCommand)"})
  void testCheckRatingExists_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act
    boolean actualCheckRatingExistsResult =
        measurableRatingDao.checkRatingExists(
            isPrimaryResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .previousRating('A')
                .provenance("Provenance")
                .rating('A')
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\", \"measurable_rating\".\"measurable_id\", \"measurable_rating\".\"rating\", \"measurable_rating\".\"description\", \"measurable_rating\".\"last_updated_at\", \"measurable_rating\".\"last_updated_by\", \"measurable_rating\".\"provenance\", \"measurable_rating\".\"is_readonly\", \"measurable_rating\".\"is_primary\", \"measurable_rating\".\"id\" from \"measurable_rating\" where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(3, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCheckRatingExistsResult);
  }

  /**
   * Test {@link MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingDao#checkRatingExists(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test checkRatingExists(SaveMeasurableRatingCommand); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.checkRatingExists(SaveMeasurableRatingCommand)"})
  void testCheckRatingExists_thenThrowNotFoundException() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.checkRatingExists(
                isPrimaryResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .previousRating('A')
                    .provenance("Provenance")
                    .rating('A')
                    .build()));
    verify(dSLContext).fetchExists(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test remove(RemoveMeasurableRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.remove(
                entityReferenceResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test remove(RemoveMeasurableRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove2() {
    // Arrange
    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.remove(
                entityReferenceResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test remove(RemoveMeasurableRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove3() {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.remove(
                entityReferenceResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test remove(RemoveMeasurableRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove4() {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.remove(
                entityReferenceResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test remove(RemoveMeasurableRatingCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove5() throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute())
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.remove(
                entityReferenceResult
                    .lastUpdate(
                        ImmutableUserTimestamp.builder()
                            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                            .by("By")
                            .build())
                    .measurableId(1L)
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveMeasurableRatingCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRatingDao.remove(
            entityReferenceResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"measurable_rating\" where (\"measurable_rating\".\"entity_kind\" = cast(? as varchar) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"measurable_id\" = cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveMeasurableRatingCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRatingDao.remove(
            entityReferenceResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"measurable_rating\" where (\"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"measurable_id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveMeasurableRatingCommand); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRatingDao.remove(
            entityReferenceResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test remove(RemoveMeasurableRatingCommand); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.remove(RemoveMeasurableRatingCommand)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRatingDao.remove(
            entityReferenceResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity6() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity7() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity8() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity9() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity10() {
    // Arrange
    MeasurableRatingDao measurableRatingDao =
        new MeasurableRatingDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findForEntity(ref));
    verify(ref).kind();
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity11() {
    // Arrange
    MeasurableRatingDao measurableRatingDao =
        new MeasurableRatingDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    List<MeasurableRating> actualFindForEntityResult =
        measurableRatingDao.findForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.findForEntity(EntityReference)"})
  void testFindForEntity_thenCallsSelect() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("ref cannot be null", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById6() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById7() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#getById(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getById(long)"})
  void testGetById_thenCallsFetchOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId6() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId7() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId8() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId9() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#getByDecommId(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getByDecommId(long)}
   */
  @Test
  @DisplayName("Test getByDecommId(long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating MeasurableRatingDao.getByDecommId(long)"})
  void testGetByDecommId_thenCallsFetchOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getByDecommId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory5() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep4);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory6() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory7() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory8() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory9() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName("Test findByCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.findByCategory(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#findByCategory(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#findByCategory(long)}
   */
  @Test
  @DisplayName(
      "Test findByCategory(long); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableRatingDao.findByCategory(long)"})
  void testFindByCategory_givenSelectConditionStepFetchReturnArrayList_thenReturnList()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(objectList);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    Collection<MeasurableRating> actualFindByCategoryResult =
        measurableRatingDao.findByCategory(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByCategoryResult instanceof List);
    assertTrue(actualFindByCategoryResult.isEmpty());
    assertSame(objectList, actualFindByCategoryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId2() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId3() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId4() {
    // Arrange
    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId5() {
    // Arrange
    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId6() {
    // Arrange
    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId7() {
    // Arrange
    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId8() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId9() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId10() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class, () -> measurableRatingDao.tallyByMeasurableCategoryId(1L));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#tallyByMeasurableCategoryId(long)}
   */
  @Test
  @DisplayName("Test tallyByMeasurableCategoryId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableRatingDao.tallyByMeasurableCategoryId(long)"})
  void testTallyByMeasurableCategoryId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<Long>> actualTallyByMeasurableCategoryIdResult =
        measurableRatingDao.tallyByMeasurableCategoryId(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualTallyByMeasurableCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.removeForCategory(null, 1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory2() {
    // Arrange
    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory3() {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory4() {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory5() {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory6() throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute())
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory7() {
    // Arrange
    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName("Test removeForCategory(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory8() {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.removeForCategory(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test removeForCategory(EntityReference, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    int actualRemoveForCategoryResult =
        measurableRatingDao.removeForCategory(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"measurable_rating\" where (\"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar) and \"measurable_rating\".\"measurable_id\" in (select \"measurable\".\"id\" from \"measurable\" where \"measurable\".\"measurable_category_id\" = cast(? as bigint)) and \"measurable_rating\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveForCategoryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test removeForCategory(EntityReference, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    int actualRemoveForCategoryResult =
        measurableRatingDao.removeForCategory(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"measurable_rating\" where (\"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar(3)) and \"measurable_rating\".\"measurable_id\" in (select \"measurable\".\"id\" from \"measurable\" where \"measurable\".\"measurable_category_id\" = cast(? as bigint)) and \"measurable_rating\".\"is_readonly\" = 0)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveForCategoryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test removeForCategory(EntityReference, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    int actualRemoveForCategoryResult =
        measurableRatingDao.removeForCategory(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"measurable_rating\" where (\"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ? and \"measurable_rating\".\"measurable_id\" in (select \"measurable\".\"id\" from \"measurable\" where \"measurable\".\"measurable_category_id\" = ?) and \"measurable_rating\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveForCategoryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#removeForCategory(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test removeForCategory(EntityReference, long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.removeForCategory(EntityReference, long)"})
  void testRemoveForCategory_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<MeasurableRatingRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<MeasurableRatingRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    when(dSLContext.deleteFrom(Mockito.<Table<MeasurableRatingRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveForCategoryResult =
        measurableRatingDao.removeForCategory(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveForCategoryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#hasMeasurableRatings(Select)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#hasMeasurableRatings(Select)}
   */
  @Test
  @DisplayName(
      "Test hasMeasurableRatings(Select); given DSLContext fetchExists(Select) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.hasMeasurableRatings(Select)"})
  void testHasMeasurableRatings_givenDSLContextFetchExistsReturnFalse_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    boolean actualHasMeasurableRatingsResult =
        measurableRatingDao.hasMeasurableRatings(mock(Select.class));

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertFalse(actualHasMeasurableRatingsResult);
  }

  /**
   * Test {@link MeasurableRatingDao#hasMeasurableRatings(Select)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchExists(Select)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#hasMeasurableRatings(Select)}
   */
  @Test
  @DisplayName(
      "Test hasMeasurableRatings(Select); given DSLContext fetchExists(Select) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.hasMeasurableRatings(Select)"})
  void testHasMeasurableRatings_givenDSLContextFetchExistsReturnTrue_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    boolean actualHasMeasurableRatingsResult =
        measurableRatingDao.hasMeasurableRatings(mock(Select.class));

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualHasMeasurableRatingsResult);
  }

  /**
   * Test {@link MeasurableRatingDao#hasMeasurableRatings(Select)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#hasMeasurableRatings(Select)}
   */
  @Test
  @DisplayName("Test hasMeasurableRatings(Select); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRatingDao.hasMeasurableRatings(Select)"})
  void testHasMeasurableRatings_thenThrowNotFoundException() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> measurableRatingDao.hasMeasurableRatings(mock(Select.class)));
    verify(dSLContext).fetchExists(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations2() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations3() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations4() {
    // Arrange
    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations5() {
    // Arrange
    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                new HashSet<>(), null, 1L, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations6() {
    // Arrange
    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations7() {
    // Arrange
    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations8() {
    // Arrange
    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations9() {
    // Arrange
    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedRatingOperations(Set, EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new NotFoundException("rating_read_only", "An error occurred"));

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedRatingOperations(
                operationsForEntityAssessment,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L,
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set, EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedRatingOperations(Set,
   * EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedRatingOperations(Set, EntityReference, long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedRatingOperations(Set, EntityReference, long, String)"
  })
  void testCalculateAmendedRatingOperations_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new Tuple2<>("V1", true));

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Operation> operationsForEntityAssessment = new HashSet<>();

    // Act
    Set<Operation> actualCalculateAmendedRatingOperationsResult =
        measurableRatingDao.calculateAmendedRatingOperations(
            operationsForEntityAssessment,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "janedoe");

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualCalculateAmendedRatingOperationsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link HashSet#HashSet()} add {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedAllocationOperations(Set, long, String); given 'ADD'; when HashSet() add 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedAllocationOperations(Set, long, String)"
  })
  void testCalculateAmendedAllocationOperations_givenAdd_whenHashSetAddAdd()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<Operation> operationsForAllocation = new HashSet<>();
    operationsForAllocation.add(Operation.ADD);

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult =
        measurableRatingDao.calculateAmendedAllocationOperations(
            operationsForAllocation, 1L, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(3, actualCalculateAmendedAllocationOperationsResult.size());
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedAllocationOperations(Set, long, String); given 'ATTEST'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedAllocationOperations(Set, long, String)"
  })
  void testCalculateAmendedAllocationOperations_givenAttest_thenReturnSizeIsFour()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<Operation> operationsForAllocation = new HashSet<>();
    operationsForAllocation.add(Operation.ATTEST);
    operationsForAllocation.add(Operation.ADD);

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult =
        measurableRatingDao.calculateAmendedAllocationOperations(
            operationsForAllocation, 1L, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(4, actualCalculateAmendedAllocationOperationsResult.size());
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ATTEST));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedAllocationOperations(Set, long, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedAllocationOperations(Set, long, String)"
  })
  void testCalculateAmendedAllocationOperations_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult =
        measurableRatingDao.calculateAmendedAllocationOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"measurable_category\" join \"user_role\" on (\"user_role\".\"role\" = \"measurable_category\".\"rating_editor_role\" and \"user_role\".\"user_name\" = ?) where \"measurable_category\".\"id\" = ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "janedoe");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedAllocationOperationsResult.size());
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set,
   * long, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedAllocationOperations(Set, long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedAllocationOperations(Set, long, String)"
  })
  void testCalculateAmendedAllocationOperations_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult =
        measurableRatingDao.calculateAmendedAllocationOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedAllocationOperations(Set, long, String); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedAllocationOperations(Set, long, String)"
  })
  void testCalculateAmendedAllocationOperations_thenReturnSizeIsThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    Set<Operation> actualCalculateAmendedAllocationOperationsResult =
        measurableRatingDao.calculateAmendedAllocationOperations(new HashSet<>(), 1L, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(3, actualCalculateAmendedAllocationOperationsResult.size());
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedAllocationOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set, long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#calculateAmendedAllocationOperations(Set,
   * long, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedAllocationOperations(Set, long, String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableRatingDao.calculateAmendedAllocationOperations(Set, long, String)"
  })
  void testCalculateAmendedAllocationOperations_thenThrowNotFoundException()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.calculateAmendedAllocationOperations(
                new HashSet<>(), 1L, "janedoe"));
    verify(dSLContext).fetchExists(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test migrateRatings(Long, Long, String); given DSLContext fetchCount(Select) return three; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableRatingDao.migrateRatings(Long, Long, String)"})
  void testMigrateRatings_givenDSLContextFetchCountReturnThree_thenCallsTransaction()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    measurableRatingDao.migrateRatings(1L, 1L, "42");

    // Assert
    verify(dSLContext, atLeast(1)).fetchCount(Mockito.<Select<?>>any());
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test migrateRatings(Long, Long, String); given DSLContext fetchCount(Select) return three; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableRatingDao.migrateRatings(Long, Long, String)"})
  void testMigrateRatings_givenDSLContextFetchCountReturnThree_thenCallsTransaction2()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    measurableRatingDao.migrateRatings(null, 1L, "42");

    // Assert
    verify(dSLContext, atLeast(1)).fetchCount(Mockito.<Select<?>>any());
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test migrateRatings(Long, Long, String); given DSLContext; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableRatingDao.migrateRatings(Long, Long, String)"})
  void testMigrateRatings_givenDSLContext_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> measurableRatingDao.migrateRatings(1L, null, "42"));
  }

  /**
   * Test {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test migrateRatings(Long, Long, String); given PreparedStatement getResultSet() return 'null'; then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableRatingDao.migrateRatings(Long, Long, String)"})
  void testMigrateRatings_givenPreparedStatementGetResultSetReturnNull_thenCallsCommit()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setNull(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    new MeasurableRatingDao(dsl).migrateRatings(1L, 1L, "42");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setNull(1, 4);
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#migrateRatings(Long, Long, String)}
   */
  @Test
  @DisplayName("Test migrateRatings(Long, Long, String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableRatingDao.migrateRatings(Long, Long, String)"})
  void testMigrateRatings_thenThrowNotFoundException() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any()))
        .thenThrow(
            new NotFoundException(
                "Migrating ratings from measurable: {} to {}", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.migrateRatings(1L, 1L, "42"));
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getSharedRatingsCount(Long, Long); given DSLContext fetchCount(Select) return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedRatingsCount(Long, Long)"})
  void testGetSharedRatingsCount_givenDSLContextFetchCountReturnThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedRatingsCount = measurableRatingDao.getSharedRatingsCount(1L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedRatingsCount(Long, Long); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedRatingsCount(Long, Long)"})
  void testGetSharedRatingsCount_thenReturnMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualSharedRatingsCount = new MeasurableRatingDao(dsl).getSharedRatingsCount(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating\" where \"measurable_rating\".\"measurable_id\" = ? intersect select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating\" where \"measurable_rating\".\"measurable_id\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1, actualSharedRatingsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedRatingsCount(Long, Long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedRatingsCount(Long, Long)"})
  void testGetSharedRatingsCount_thenThrowNotFoundException() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getSharedRatingsCount(1L, 1L));
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedRatingsCount(Long, Long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedRatingsCount(Long, Long)"})
  void testGetSharedRatingsCount_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedRatingsCount = measurableRatingDao.getSharedRatingsCount(4L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedRatingsCount(Long, Long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedRatingsCount(Long, Long)"})
  void testGetSharedRatingsCount_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedRatingsCount = measurableRatingDao.getSharedRatingsCount(3L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedRatingsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedRatingsCount(Long, Long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedRatingsCount(Long, Long)"})
  void testGetSharedRatingsCount_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedRatingsCount = measurableRatingDao.getSharedRatingsCount(2L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  @DisplayName(
      "Test getSharedDecommsCount(Long, Long); given DSLContext fetchCount(Select) return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedDecommsCount(Long, Long)"})
  void testGetSharedDecommsCount_givenDSLContextFetchCountReturnThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedDecommsCount = measurableRatingDao.getSharedDecommsCount(1L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedDecommsCount(Long, Long); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedDecommsCount(Long, Long)"})
  void testGetSharedDecommsCount_thenReturnMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualSharedDecommsCount = new MeasurableRatingDao(dsl).getSharedDecommsCount(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating\".\"measurable_id\" = ? intersect select \"measurable_rating\".\"entity_id\", \"measurable_rating\".\"entity_kind\" from \"measurable_rating_planned_decommission\" join \"measurable_rating\" on \"measurable_rating_planned_decommission\".\"measurable_rating_id\" = \"measurable_rating\".\"id\" where \"measurable_rating\".\"measurable_id\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1, actualSharedDecommsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedDecommsCount(Long, Long); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedDecommsCount(Long, Long)"})
  void testGetSharedDecommsCount_thenThrowNotFoundException() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(NotFoundException.class, () -> measurableRatingDao.getSharedDecommsCount(1L, 1L));
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedDecommsCount(Long, Long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedDecommsCount(Long, Long)"})
  void testGetSharedDecommsCount_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedDecommsCount = measurableRatingDao.getSharedDecommsCount(4L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedDecommsCount(Long, Long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedDecommsCount(Long, Long)"})
  void testGetSharedDecommsCount_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedDecommsCount = measurableRatingDao.getSharedDecommsCount(3L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#getSharedDecommsCount(Long, Long)}
   */
  @Test
  @DisplayName("Test getSharedDecommsCount(Long, Long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableRatingDao.getSharedDecommsCount(Long, Long)"})
  void testGetSharedDecommsCount_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    int actualSharedDecommsCount = measurableRatingDao.getSharedDecommsCount(2L, 1L);

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingItem(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingItem(EntityReference, long, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingItem(EntityReference, long, String, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingItem(EntityReference, long, String, String)"
  })
  void testSaveRatingItem_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    boolean actualSaveRatingItemResult =
        measurableRatingDao.saveRatingItem(
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
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertFalse(actualSaveRatingItemResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transactionResult(TransactionalCallable)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(EntityReference, long, boolean, String); given DSLContext transactionResult(TransactionalCallable) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingIsPrimary(EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_givenDSLContextTransactionResultReturnTrue() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenReturn(true);

    // Act
    boolean actualSaveRatingIsPrimaryResult =
        measurableRatingDao.saveRatingIsPrimary(null, 1L, true, "janedoe");

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(EntityReference, long, boolean, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingIsPrimary(EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    boolean actualSaveRatingIsPrimaryResult =
        measurableRatingDao.saveRatingIsPrimary(
            ImmutableEntityReference.builder()
                .description("Description")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            true,
            "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(EntityReference, long, boolean, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingIsPrimary(EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    boolean actualSaveRatingIsPrimaryResult =
        measurableRatingDao.saveRatingIsPrimary(
            ImmutableEntityReference.builder()
                .description("Description")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            true,
            "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(eq(1), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(EntityReference, long, boolean, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingIsPrimary(EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_thenReturnFalse() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenReturn(false);

    // Act
    boolean actualSaveRatingIsPrimaryResult =
        measurableRatingDao.saveRatingIsPrimary(null, 1L, true, "janedoe");

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertFalse(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long, boolean, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingIsPrimary(EntityReference, long,
   * boolean, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingIsPrimary(EntityReference, long, boolean, String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingIsPrimary(EntityReference, long, boolean, String)"
  })
  void testSaveRatingIsPrimary_thenThrowNotFoundException() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () -> measurableRatingDao.saveRatingIsPrimary(null, 1L, true, "janedoe"));
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}.
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName("Test saveRatingDescription(EntityReference, long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingDescription(EntityReference, long, String, String)"
  })
  void testSaveRatingDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    boolean actualSaveRatingDescriptionResult =
        measurableRatingDao.saveRatingDescription(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "The characteristics of someone or something",
            "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"description\" = cast(? as varchar(43)), \"measurable_rating\".\"last_updated_by\" = cast(? as varchar(7)), \"measurable_rating\".\"last_updated_at\" = cast(? as timestamp) where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar(3)))");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transactionResult(TransactionalCallable)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(EntityReference, long, String, String); given DSLContext transactionResult(TransactionalCallable) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingDescription(EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_givenDSLContextTransactionResultReturnFalse() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenReturn(false);

    // Act
    boolean actualSaveRatingDescriptionResult =
        measurableRatingDao.saveRatingDescription(
            null, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(EntityReference, long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingDescription(EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    boolean actualSaveRatingDescriptionResult =
        measurableRatingDao.saveRatingDescription(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "The characteristics of someone or something",
            "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"description\" = cast(? as varchar), \"measurable_rating\".\"last_updated_by\" = cast(? as varchar), \"measurable_rating\".\"last_updated_at\" = cast(? as datetime) where (\"measurable_rating\".\"measurable_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_id\" = cast(? as bigint) and \"measurable_rating\".\"entity_kind\" = cast(? as varchar))");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(EntityReference, long, String, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingDescription(EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    MeasurableRatingDao measurableRatingDao = new MeasurableRatingDao(dsl);

    // Act
    boolean actualSaveRatingDescriptionResult =
        measurableRatingDao.saveRatingDescription(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "The characteristics of someone or something",
            "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "update \"measurable_rating\" set \"measurable_rating\".\"description\" = ?, \"measurable_rating\".\"last_updated_by\" = ?, \"measurable_rating\".\"last_updated_at\" = ? where (\"measurable_rating\".\"measurable_id\" = ? and \"measurable_rating\".\"entity_id\" = ? and \"measurable_rating\".\"entity_kind\" = ?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(EntityReference, long, String, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingDescription(EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_thenReturnTrue() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenReturn(true);

    // Act
    boolean actualSaveRatingDescriptionResult =
        measurableRatingDao.saveRatingDescription(
            null, 1L, "The characteristics of someone or something", "janedoe");

    // Assert
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertTrue(actualSaveRatingDescriptionResult);
  }

  /**
   * Test {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingDao#saveRatingDescription(EntityReference, long,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test saveRatingDescription(EntityReference, long, String, String); then throw NotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRatingDao.saveRatingDescription(EntityReference, long, String, String)"
  })
  void testSaveRatingDescription_thenThrowNotFoundException() {
    // Arrange
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        NotFoundException.class,
        () ->
            measurableRatingDao.saveRatingDescription(
                null, 1L, "The characteristics of someone or something", "janedoe"));
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
  }
}
