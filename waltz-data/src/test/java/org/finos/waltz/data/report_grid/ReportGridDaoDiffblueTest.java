package org.finos.waltz.data.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.ImmutableGenericSelector;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridCreateCommand;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ImmutableReportGridInfo;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridColumnDefinitionsUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDerivedColumnDefinition;
import org.finos.waltz.model.report_grid.ReportGridInfo;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.model.report_grid.ReportGridUpdateCommand;
import org.finos.waltz.schema.tables.records.ReportGridRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalRunnable;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
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
import org.springframework.dao.DataIntegrityViolationException;

@ExtendWith(MockitoExtension.class)
class ReportGridDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ReportGridDao reportGridDao;

  /**
   * Test {@link ReportGridDao#findAllDefinitions()}.
   *
   * <p>Method under test: {@link ReportGridDao#findAllDefinitions()}
   */
  @Test
  @DisplayName("Test findAllDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findAllDefinitions()"})
  void testFindAllDefinitions() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> new ReportGridDao(dsl).findAllDefinitions());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findAllDefinitions()}.
   *
   * <p>Method under test: {@link ReportGridDao#findAllDefinitions()}
   */
  @Test
  @DisplayName("Test findAllDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findAllDefinitions()"})
  void testFindAllDefinitions2() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.findAllDefinitions());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findAllDefinitions()}.
   *
   * <p>Method under test: {@link ReportGridDao#findAllDefinitions()}
   */
  @Test
  @DisplayName("Test findAllDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findAllDefinitions()"})
  void testFindAllDefinitions3() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.findAllDefinitions());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ReportGridDao#findAllDefinitions()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetchSet(RecordMapper)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findAllDefinitions()}
   */
  @Test
  @DisplayName(
      "Test findAllDefinitions(); given SelectJoinStep fetchSet(RecordMapper) return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findAllDefinitions()"})
  void testFindAllDefinitions_givenSelectJoinStepFetchSetReturnHashSet_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridDefinition> actualFindAllDefinitionsResult =
        new ReportGridDao(dsl).findAllDefinitions();

    // Assert
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllDefinitionsResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridDefinitionsForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridDefinitionsForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser3() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridDefinitionsForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser4() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridDefinitionsForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser5() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findGridDefinitionsForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findGridDefinitionsForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findGridDefinitionsForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findGridDefinitionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGridDefinitionsForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridDefinitionsForUser(String)"})
  void testFindGridDefinitionsForUser_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridDefinition> actualFindGridDefinitionsForUserResult =
        new ReportGridDao(dsl).findGridDefinitionsForUser("janedoe");

    // Assert
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindGridDefinitionsForUserResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridInfoForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridInfoForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser3() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridInfoForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser4() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findGridInfoForUser("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser5() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findGridInfoForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findGridInfoForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findGridInfoForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findGridInfoForUser(String)}
   */
  @Test
  @DisplayName("Test findGridInfoForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findGridInfoForUser(String)"})
  void testFindGridInfoForUser_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridInfo> actualFindGridInfoForUserResult =
        new ReportGridDao(dsl).findGridInfoForUser("janedoe");

    // Assert
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindGridInfoForUserResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridId(long, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findCellDataByGridId(1L, null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridId(long, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findCellDataByGridId(1L, null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridId(long, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId3() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("xs cannot be null"));
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findCellDataByGridId(1L, null));
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridId(long, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId4() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findCellDataByGridId(1L, null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridId(long, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findCellDataByGridId(1L, null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test findCellDataByGridId(long, GenericSelector); given SelectConditionStep fetchOne(RecordMapper) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId_givenSelectConditionStepFetchOneReturnNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridCell> actualFindCellDataByGridIdResult =
        reportGridDao.findCellDataByGridId(
            1L,
            ImmutableGenericSelector.builder()
                .kind(EntityKind.ALL)
                .selector(mock(Select.class))
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindCellDataByGridIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridId(long, GenericSelector); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridCell> actualFindCellDataByGridIdResult =
        new ReportGridDao(dsl).findCellDataByGridId(1L, null);

    // Assert
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindCellDataByGridIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findCellDataByGridExternalId("42", null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findCellDataByGridExternalId("42", null));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId3() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("xs cannot be null"));
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findCellDataByGridExternalId("42", null));
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId4() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCellDataByGridExternalId("42", null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId5() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCellDataByGridExternalId("42", null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test findCellDataByGridExternalId(String, GenericSelector); given SelectConditionStep fetchOne(RecordMapper) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId_givenSelectConditionStepFetchOneReturnNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridCell> actualFindCellDataByGridExternalIdResult =
        reportGridDao.findCellDataByGridExternalId(
            "42",
            ImmutableGenericSelector.builder()
                .kind(EntityKind.ALL)
                .selector(mock(Select.class))
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindCellDataByGridExternalIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridCell> actualFindCellDataByGridExternalIdResult =
        new ReportGridDao(dsl).findCellDataByGridExternalId("42", null);

    // Assert
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindCellDataByGridExternalIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName("Test findCellDataByGridExternalId(String, GenericSelector); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId_thenReturnEmpty2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<RecordMapper<Record, Object>>any(),
            Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridCell> actualFindCellDataByGridExternalIdResult =
        new ReportGridDao(dsl).findCellDataByGridExternalId(null, null);

    // Assert
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    verify(dsl, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindCellDataByGridExternalIdResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionById(long)"})
  void testGetGridDefinitionById() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).getGridDefinitionById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionById(long)"})
  void testGetGridDefinitionById2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).getGridDefinitionById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionById(long)"})
  void testGetGridDefinitionById3() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.getGridDefinitionById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionById(long)"})
  void testGetGridDefinitionById4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.getGridDefinitionById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long); then return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionById(long)"})
  void testGetGridDefinitionById_thenReturnImmutableReportGridDefinition()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ReportGridDefinition actualGridDefinitionById =
        new ReportGridDao(dsl).getGridDefinitionById(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualGridDefinitionById instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualGridDefinitionById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualGridDefinitionById.lastUpdatedBy());
    assertEquals("Name", actualGridDefinitionById.name());
    assertEquals("Provenance", actualGridDefinitionById.provenance());
    assertEquals(
        "The characteristics of someone or something", actualGridDefinitionById.description());
    assertEquals(EntityKind.ALL, actualGridDefinitionById.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualGridDefinitionById.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualGridDefinitionById.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualGridDefinitionById.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridDao#getGridInfoById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  @DisplayName("Test getGridInfoById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridDao.getGridInfoById(long)"})
  void testGetGridInfoById() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> new ReportGridDao(dsl).getGridInfoById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridInfoById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  @DisplayName("Test getGridInfoById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridDao.getGridInfoById(long)"})
  void testGetGridInfoById2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> new ReportGridDao(dsl).getGridInfoById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridInfoById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  @DisplayName("Test getGridInfoById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridDao.getGridInfoById(long)"})
  void testGetGridInfoById3() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.getGridInfoById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridInfoById(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  @DisplayName("Test getGridInfoById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridDao.getGridInfoById(long)"})
  void testGetGridInfoById4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.getGridInfoById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#getGridInfoById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridInfo}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  @DisplayName("Test getGridInfoById(long); then return ImmutableReportGridInfo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridDao.getGridInfoById(long)"})
  void testGetGridInfoById_thenReturnImmutableReportGridInfo() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridInfo.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .gridId(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .visibilityKind(ReportGridKind.PUBLIC)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ReportGridInfo actualGridInfoById = new ReportGridDao(dsl).getGridInfoById(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualGridInfoById instanceof ImmutableReportGridInfo);
    LocalDateTime lastUpdatedAtResult = actualGridInfoById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualGridInfoById.lastUpdatedBy());
    assertEquals("Name", actualGridInfoById.name());
    assertEquals("Provenance", actualGridInfoById.provenance());
    assertEquals("The characteristics of someone or something", actualGridInfoById.description());
    assertEquals(1L, actualGridInfoById.gridId());
    assertEquals(EntityKind.ALL, actualGridInfoById.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualGridInfoById.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionByExternalId(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionByExternalId(String)"})
  void testGetGridDefinitionByExternalId() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).getGridDefinitionByExternalId("42"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionByExternalId(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionByExternalId(String)"})
  void testGetGridDefinitionByExternalId2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).getGridDefinitionByExternalId("42"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionByExternalId(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionByExternalId(String)"})
  void testGetGridDefinitionByExternalId3() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.getGridDefinitionByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionByExternalId(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionByExternalId(String)"})
  void testGetGridDefinitionByExternalId4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.getGridDefinitionByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableReportGridDefinition}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getGridDefinitionByExternalId(String); then return ImmutableReportGridDefinition")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionByExternalId(String)"})
  void testGetGridDefinitionByExternalId_thenReturnImmutableReportGridDefinition()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableReportGridDefinition.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(ReportGridKind.PUBLIC)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ReportGridDefinition actualGridDefinitionByExternalId =
        new ReportGridDao(dsl).getGridDefinitionByExternalId("42");

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualGridDefinitionByExternalId instanceof ImmutableReportGridDefinition);
    LocalDateTime lastUpdatedAtResult = actualGridDefinitionByExternalId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualGridDefinitionByExternalId.lastUpdatedBy());
    assertEquals("Name", actualGridDefinitionByExternalId.name());
    assertEquals("Provenance", actualGridDefinitionByExternalId.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualGridDefinitionByExternalId.description());
    assertEquals(EntityKind.ALL, actualGridDefinitionByExternalId.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualGridDefinitionByExternalId.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualGridDefinitionByExternalId.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(
        derivedColumnDefinitionsResult, actualGridDefinitionByExternalId.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid2() {
    // Arrange
    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid3() {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid4() {
    // Arrange
    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid5() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid6() {
    // Arrange
    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record1<Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid7() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record1<Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid8() {
    // Arrange
    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record1<Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid9() {
    // Arrange
    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record1<Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<Field<Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record1<Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCommentSupportingColumnIdsForGrid(1L));
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  @DisplayName("Test findCommentSupportingColumnIdsForGrid(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCommentSupportingColumnIdsForGrid(long)"})
  void testFindCommentSupportingColumnIdsForGrid_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<Field<Object>>any())).thenReturn(new HashSet<>());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record1<Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectOnStep<Record1<Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record1<Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Set<Long> actualFindCommentSupportingColumnIdsForGridResult =
        reportGridDao.findCommentSupportingColumnIdsForGrid(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindCommentSupportingColumnIdsForGridResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportGridDao.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand)"
  })
  void testUpdateColumnDefinitions_thenCallsTransaction() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    new ReportGridDao(dsl).updateColumnDefinitions(1L, null);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link ReportGridDao#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand)}.
   *
   * <ul>
   *   <li>Then throw {@link DataIntegrityViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand); then throw DataIntegrityViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportGridDao.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand)"
  })
  void testUpdateColumnDefinitions_thenThrowDataIntegrityViolationException() {
    // Arrange
    doThrow(new DataIntegrityViolationException("Msg"))
        .when(dSLContext)
        .transaction(Mockito.<TransactionalRunnable>any());

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.updateColumnDefinitions(1L, null));
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link ReportGridDao#create(ReportGridCreateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenThrow(new DataIntegrityViolationException("waltz"));
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.create(
                ImmutableReportGridCreateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build(),
                "janedoe"));
    verify(connection)
        .prepareStatement(
            eq(
                "insert into \"report_grid\" (\"name\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"external_id\", \"kind\", \"subject_kind\") values (?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
  }

  /**
   * Test {@link ReportGridDao#create(ReportGridCreateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getWarnings()).thenThrow(new DataIntegrityViolationException("waltz"));
    doThrow(new DataIntegrityViolationException("waltz"))
        .when(preparedStatement)
        .setString(anyInt(), Mockito.<String>any());

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.create(
                ImmutableReportGridCreateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build(),
                "janedoe"));
    verify(connection)
        .prepareStatement(
            eq(
                "insert into \"report_grid\" (\"name\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"external_id\", \"kind\", \"subject_kind\") values (?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link ReportGridDao#create(ReportGridCreateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenThrow(new DataIntegrityViolationException("waltz"));
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.create(
                ImmutableReportGridCreateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build(),
                "janedoe"));
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link ReportGridDao#create(ReportGridCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(ReportGridCreateCommand, String); given PreparedStatement getResultSet() return 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate_givenPreparedStatementGetResultSetReturnNull_thenReturnMinusOne()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act
    long actualCreateResult =
        reportGridDao.create(
            ImmutableReportGridCreateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build(),
            "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(-1L, actualCreateResult);
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(long, ReportGridUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate() {
    // Arrange
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName("Test update(long, ReportGridUpdateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenThrow(new DataIntegrityViolationException("Msg"));

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);
    when(dSLContext.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#update(Table)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given DSLContext update(Table) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenDSLContextUpdateThrowDataIntegrityViolationExceptionWithMsg() {
    // Arrange
    when(dSLContext.update(Mockito.<Table<ReportGridRecord>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.update(1L, null, "janedoe"));
    verify(dSLContext).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<ReportGridRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep5 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep5);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act
    long actualUpdateResult =
        reportGridDao.update(
            1L,
            ImmutableReportGridUpdateCommand.builder()
                .description("The characteristics of someone or something")
                .kind(ReportGridKind.PUBLIC)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1L, actualUpdateResult);
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetFirstStep} {@link UpdateSetFirstStep#set(Field, Object)} throw
   *       {@link DataIntegrityViolationException#DataIntegrityViolationException(String)} with
   *       {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given UpdateSetFirstStep set(Field, Object) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenUpdateSetFirstStepSetThrowDataIntegrityViolationExceptionWithMsg() {
    // Arrange
    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given UpdateSetMoreStep set(Field, Object) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenUpdateSetMoreStepSetThrowDataIntegrityViolationExceptionWithMsg() {
    // Arrange
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given UpdateSetMoreStep set(Field, Object) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenUpdateSetMoreStepSetThrowDataIntegrityViolationExceptionWithMsg2() {
    // Arrange
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given UpdateSetMoreStep set(Field, Object) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenUpdateSetMoreStepSetThrowDataIntegrityViolationExceptionWithMsg3() {
    // Arrange
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateSetMoreStep} {@link UpdateSetMoreStep#set(Field, Object)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, ReportGridUpdateCommand, String); given UpdateSetMoreStep set(Field, Object) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.update(long, ReportGridUpdateCommand, String)"})
  void testUpdate_givenUpdateSetMoreStepSetThrowDataIntegrityViolationExceptionWithMsg4() {
    // Arrange
    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<ReportGridRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<ReportGridRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);
    ReportGridDao reportGridDao = new ReportGridDao(dsl);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () ->
            reportGridDao.update(
                1L,
                ImmutableReportGridUpdateCommand.builder()
                    .description("The characteristics of someone or something")
                    .kind(ReportGridKind.PUBLIC)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findDefinitionsForOwner("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findDefinitionsForOwner("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner3() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findDefinitionsForOwner("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner4() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> new ReportGridDao(dsl).findDefinitionsForOwner("janedoe"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner5() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findDefinitionsForOwner("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findDefinitionsForOwner("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findDefinitionsForOwner(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findDefinitionsForOwner(String)}
   */
  @Test
  @DisplayName("Test findDefinitionsForOwner(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findDefinitionsForOwner(String)"})
  void testFindDefinitionsForOwner_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerResult =
        new ReportGridDao(dsl).findDefinitionsForOwner("janedoe");

    // Assert
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindDefinitionsForOwnerResult.isEmpty());
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new DataIntegrityViolationException("Msg"));

    DeleteUsingStep<ReportGridRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.remove(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#deleteFrom(Table)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DSLContext deleteFrom(Table) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDSLContextDeleteFromThrowDataIntegrityViolationExceptionWithMsg() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<ReportGridRecord>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.remove(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualRemoveResult = new ReportGridDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"report_grid\" where \"report_grid\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnFalse()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualRemoveResult = new ReportGridDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement("delete from \"report_grid\" where \"report_grid\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<ReportGridRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = new ReportGridDao(dsl).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} throw {@link
   *       DataIntegrityViolationException#DataIntegrityViolationException(String)} with {@code
   *       Msg}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteUsingStep where(Condition) throw DataIntegrityViolationException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDeleteUsingStepWhereThrowDataIntegrityViolationExceptionWithMsg() {
    // Arrange
    DeleteUsingStep<ReportGridRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> new ReportGridDao(dsl).remove(1L));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector, Collection)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector,
   * Collection)}
   */
  @Test
  @DisplayName("Test fetchMeasurableHierarchyData(GenericSelector, Collection); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.fetchMeasurableHierarchyData(GenericSelector, Collection)"})
  void testFetchMeasurableHierarchyData_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new ReportGridDao(new DefaultDSLContext(SQLDialect.SQL99))
            .fetchMeasurableHierarchyData(null, null)
            .isEmpty());
  }

  /**
   * Test {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test fetchMeasurableHierarchyData(GenericSelector, Collection); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.fetchMeasurableHierarchyData(GenericSelector, Collection)"})
  void testFetchMeasurableHierarchyData_whenArrayList_thenReturnEmpty() {
    // Arrange
    ReportGridDao reportGridDao = new ReportGridDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(reportGridDao.fetchMeasurableHierarchyData(null, new ArrayList<>()).isEmpty());
  }
}
