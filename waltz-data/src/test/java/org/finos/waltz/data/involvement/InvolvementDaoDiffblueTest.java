package org.finos.waltz.data.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.involvement.ImmutableInvolvement;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Builder;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.schema.tables.records.InvolvementRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TableRecord;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InvolvementDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private InvolvementDao involvementDao;

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findByEntityReference(null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findByEntityReference(null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findByEntityReference(null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findByEntityReference(
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
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference5() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findByEntityReference(
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
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findByEntityReference(
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
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() throws DataAccessException {
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    List<Involvement> actualFindByEntityReferenceResult =
        involvementDao.findByEntityReference(
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
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#findByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEmployeeId(String)"})
  void testFindByEmployeeId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.findByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEmployeeId(String)"})
  void testFindByEmployeeId2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.findByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findByEmployeeId(String)}
   */
  @Test
  @DisplayName(
      "Test findByEmployeeId(String); given DSLContext select(SelectFieldOrAsterisk[]) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEmployeeId(String)"})
  void testFindByEmployeeId_givenDSLContextSelectThrowUnsupportedOperationException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.findByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findByEmployeeId(String)}
   */
  @Test
  @DisplayName(
      "Test findByEmployeeId(String); given SelectJoinStep where(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEmployeeId(String)"})
  void testFindByEmployeeId_givenSelectJoinStepWhereThrowUnsupportedOperationException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.findByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findByEmployeeId(String)}
   */
  @Test
  @DisplayName(
      "Test findByEmployeeId(String); given SelectSelectStep from(TableLike) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEmployeeId(String)"})
  void testFindByEmployeeId_givenSelectSelectStepFromThrowUnsupportedOperationException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.findByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findByEmployeeId(String)"})
  void testFindByEmployeeId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    List<Involvement> actualFindByEmployeeIdResult = involvementDao.findByEmployeeId("42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findExistingInvolvementKindIdsForUser(null, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser2() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findExistingInvolvementKindIdsForUser(null, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser3() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findExistingInvolvementKindIdsForUser(null, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser4() {
    // Arrange
    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findExistingInvolvementKindIdsForUser(null, "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser5() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findExistingInvolvementKindIdsForUser(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<Field<Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findExistingInvolvementKindIdsForUser(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findExistingInvolvementKindIdsForUser(EntityReference, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementDao.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<Field<Object>>any())).thenReturn(new HashSet<>());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Set<Long> actualFindExistingInvolvementKindIdsForUserResult =
        involvementDao.findExistingInvolvementKindIdsForUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExistingInvolvementKindIdsForUserResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId4() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName(
      "Test findAllByEmployeeId(String); given DSLContext select(SelectFieldOrAsterisk[]) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_givenDSLContextSelectThrowUnsupportedOperationException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectOnStep} {@link SelectOnStep#on(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName(
      "Test findAllByEmployeeId(String); given SelectOnStep on(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_givenSelectOnStepOnThrowUnsupportedOperationException() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> involvementDao.findAllByEmployeeId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    List<Involvement> actualFindAllByEmployeeIdResult = involvementDao.findAllByEmployeeId("42");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference() {
    // Arrange
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findPeopleByEntityReference(null));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findPeopleByEntityReference(null));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findPeopleByEntityReference(null));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference4() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findPeopleByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference5() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findPeopleByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findPeopleByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference7() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.findPeopleByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementDao.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Person> actualFindPeopleByEntityReferenceResult =
        involvementDao.findPeopleByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindPeopleByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#executeInsert(TableRecord)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName(
      "Test save(Involvement); given DSLContext executeInsert(TableRecord) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
  void testSave_givenDSLContextExecuteInsertReturnOne_thenReturnOne() throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(0);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    int actualSaveResult =
        involvementDao.save(
            employeeIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .kindId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then calls {@link Involvement#kindId()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName(
      "Test save(Involvement); given DSLContext fetchCount(Select) return three; then calls kindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
  void testSave_givenDSLContextFetchCountReturnThree_thenCallsKindId() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.kindId()).thenReturn(1L);
    when(involvement.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualSaveResult = involvementDao.save(involvement);

    // Assert
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).entityReference();
    verify(involvement).kindId();
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(0, actualSaveResult);
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName(
      "Test save(Involvement); given DSLContext fetchCount(Select) return three; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
  void testSave_givenDSLContextFetchCountReturnThree_thenReturnZero() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    int actualSaveResult =
        involvementDao.save(
            employeeIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .kindId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(0, actualSaveResult);
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName(
      "Test save(Involvement); given DSLContext fetchCount(Select) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
  void testSave_givenDSLContextFetchCountThrowUnsupportedOperationException()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.save(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName(
      "Test save(Involvement); given PreparedStatement getResultSet() return 'null'; then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
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
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementDao involvementDao = new InvolvementDao(dsl);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    int actualSaveResult =
        involvementDao.save(
            employeeIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .kindId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), anyBoolean());
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(0, actualSaveResult);
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Involvement} {@link Involvement#isReadOnly()} return {@code true}.
   *   <li>Then calls {@link Involvement#isReadOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName(
      "Test save(Involvement); given 'true'; when Involvement isReadOnly() return 'true'; then calls isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
  void testSave_givenTrue_whenInvolvementIsReadOnlyReturnTrue_thenCallsIsReadOnly()
      throws DataAccessException {
    // Arrange
    when(dSLContext.executeInsert(Mockito.<TableRecord<?>>any())).thenReturn(1);
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(0);

    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.kindId()).thenReturn(1L);
    when(involvement.isReadOnly()).thenReturn(true);
    when(involvement.provenance()).thenReturn("Provenance");
    when(involvement.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualSaveResult = involvementDao.save(involvement);

    // Assert
    verify(involvement, atLeast(1)).employeeId();
    verify(involvement, atLeast(1)).entityReference();
    verify(involvement).isReadOnly();
    verify(involvement, atLeast(1)).kindId();
    verify(involvement).provenance();
    verify(dSLContext).executeInsert(isA(TableRecord.class));
    verify(dSLContext).fetchCount(isA(Select.class));
    assertEquals(1, actualSaveResult);
  }

  /**
   * Test {@link InvolvementDao#save(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#save(Involvement)}
   */
  @Test
  @DisplayName("Test save(Involvement); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.save(Involvement)"})
  void testSave_givenUnsupportedOperationException() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenThrow(new UnsupportedOperationException());
    when(involvement.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.save(involvement));
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).entityReference();
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Involvement} {@link Involvement#employeeId()} return {@code 42}.
   *   <li>Then calls {@link Involvement#kindId()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName(
      "Test remove(Involvement); given '42'; when Involvement employeeId() return '42'; then calls kindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_given42_whenInvolvementEmployeeIdReturn42_thenCallsKindId()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.kindId()).thenReturn(1L);
    when(involvement.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.remove(involvement));
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).entityReference();
    verify(involvement).kindId();
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#deleteFrom(Table)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName(
      "Test remove(Involvement); given DSLContext deleteFrom(Table) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_givenDSLContextDeleteFromThrowUnsupportedOperationException()
      throws DataAccessException {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.remove(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName(
      "Test remove(Involvement); given DSLContext fetchCount(Select) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_givenDSLContextFetchCountThrowUnsupportedOperationException()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.remove(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).fetchCount(isA(Select.class));
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName(
      "Test remove(Involvement); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    int actualRemoveResult =
        involvementDao.remove(
            employeeIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .kindId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).fetchCount(isA(Select.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveResult);
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName(
      "Test remove(Involvement); given DeleteConditionStep execute() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_givenDeleteConditionStepExecuteThrowUnsupportedOperationException()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new UnsupportedOperationException());

    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.remove(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).fetchCount(isA(Select.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName(
      "Test remove(Involvement); given DeleteUsingStep where(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_givenDeleteUsingStepWhereThrowUnsupportedOperationException()
      throws DataAccessException {
    // Arrange
    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            involvementDao.remove(
                employeeIdResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .kindId(1L)
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).fetchCount(isA(Select.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName("Test remove(Involvement); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_givenUnsupportedOperationException() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenThrow(new UnsupportedOperationException());
    when(involvement.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.remove(involvement));
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).entityReference();
  }

  /**
   * Test {@link InvolvementDao#remove(Involvement)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#remove(Involvement)}
   */
  @Test
  @DisplayName("Test remove(Involvement); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.remove(Involvement)"})
  void testRemove_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementDao involvementDao = new InvolvementDao(dsl);

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    int actualRemoveResult =
        involvementDao.remove(
            employeeIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .kindId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where (\"involvement\".\"entity_kind\" = ? and \"involvement\".\"entity_id\" = ? and \"involvement\".\"employee_id\" = ? and \"involvement\".\"kind_id\" = ? and \"involvement\".\"is_readonly\" = ?)) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(5, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Test {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findInvolvementsByKindAndEntityKind(Long, EntityKind)"})
  void testFindInvolvementsByKindAndEntityKind() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findInvolvementsByKindAndEntityKind(Long, EntityKind)"})
  void testFindInvolvementsByKindAndEntityKind2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findInvolvementsByKindAndEntityKind(Long, EntityKind)"})
  void testFindInvolvementsByKindAndEntityKind3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findInvolvementsByKindAndEntityKind(Long, EntityKind)"})
  void testFindInvolvementsByKindAndEntityKind4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findInvolvementsByKindAndEntityKind(Long, EntityKind)"})
  void testFindInvolvementsByKindAndEntityKind5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findInvolvementsByKindAndEntityKind(Long, EntityKind)"})
  void testFindInvolvementsByKindAndEntityKind_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<Involvement> actualFindInvolvementsByKindAndEntityKindResult =
        involvementDao.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindInvolvementsByKindAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#bulkStoreInvolvements(Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  @DisplayName(
      "Test bulkStoreInvolvements(Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkStoreInvolvements(Set)"})
  void testBulkStoreInvolvements_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, involvementDao.bulkStoreInvolvements(new HashSet<>()));
  }

  /**
   * Test {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findByKindIdAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findByKindIdAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findByKindIdAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind4() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findByKindIdAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.findByKindIdAndEntityKind(1L, EntityKind.ALL));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementDao.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    // Act
    Set<Involvement> actualFindByKindIdAndEntityKindResult =
        involvementDao.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements() {
    // Arrange
    when(dSLContext.batch(Mockito.<Collection<Query>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.bulkDeleteInvolvements(new HashSet<>()));
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements2() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenThrow(new UnsupportedOperationException());

    HashSet<Involvement> involvements = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.bulkDeleteInvolvements(involvements));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements3() {
    // Arrange
    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenReturn(deleteUsingStep);

    HashSet<Involvement> involvements = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.bulkDeleteInvolvements(involvements));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<Involvement> involvements = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("Employee Id");
    involvements.add(
        employeeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(involvements);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext, atLeast(1)).deleteFrom(isA(Table.class));
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <ul>
   *   <li>Given {@link Batch} {@link Batch#execute()} return array of {@code int} with one and
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName(
      "Test bulkDeleteInvolvements(Set); given Batch execute() return array of int with one and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements_givenBatchExecuteReturnArrayOfIntWithOneAndMinusOne()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <ul>
   *   <li>Given {@link Batch} {@link Batch#execute()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName(
      "Test bulkDeleteInvolvements(Set); given Batch execute() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements_givenBatchExecuteThrowUnsupportedOperationException()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenThrow(new UnsupportedOperationException());
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> involvementDao.bulkDeleteInvolvements(new HashSet<>()));
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} return {@link
   *       DeleteConditionStep}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName(
      "Test bulkDeleteInvolvements(Set); given DeleteUsingStep where(Condition) return DeleteConditionStep")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements_givenDeleteUsingStepWhereReturnDeleteConditionStep()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DeleteUsingStep<InvolvementRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<Involvement> involvements = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(involvements);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName(
      "Test bulkDeleteInvolvements(Set); given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements_givenStatementAddBatchDoesNothing_thenCallsAddBatch()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementDao involvementDao = new InvolvementDao(dsl);

    HashSet<Involvement> involvements = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(involvements);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "delete from \"involvement\" where (\"involvement\".\"entity_kind\" = 'ALL' and \"involvement\".\"entity_id\" = 1 and \"involvement\".\"employee_id\" = '42' and \"involvement\".\"kind_id\" = 1)");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementDao#bulkDeleteInvolvements(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementDao#bulkDeleteInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementDao.bulkDeleteInvolvements(Set)"})
  void testBulkDeleteInvolvements_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementDao involvementDao = new InvolvementDao(dsl);

    // Act
    int actualBulkDeleteInvolvementsResult = involvementDao.bulkDeleteInvolvements(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualBulkDeleteInvolvementsResult);
  }
}
