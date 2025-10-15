package org.finos.waltz.data.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridCreateCommand;
import org.finos.waltz.model.report_grid.ImmutableReportGridUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridColumnDefinitionsUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
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
  void testFindAllDefinitions2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.findAllDefinitions());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridDefinition> actualFindAllDefinitionsResult = reportGridDao.findAllDefinitions();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
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
  void testFindGridDefinitionsForUser2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findGridDefinitionsForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findGridDefinitionsForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
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
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findGridDefinitionsForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridDefinition> actualFindGridDefinitionsForUserResult =
        reportGridDao.findGridDefinitionsForUser("janedoe");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
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
  void testFindGridInfoForUser2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findGridInfoForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findGridInfoForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
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
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findGridInfoForUser("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridInfo> actualFindGridInfoForUserResult =
        reportGridDao.findGridInfoForUser("janedoe");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
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
  void testFindCellDataByGridId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findCellDataByGridId(1L, null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
  void testFindCellDataByGridId3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.findCellDataByGridId(1L, null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridId(long, GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test findCellDataByGridId(long, GenericSelector); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridId(long, GenericSelector)"})
  void testFindCellDataByGridId_thenCallsFetchOne() throws DataAccessException {
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
  void testFindCellDataByGridExternalId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCellDataByGridExternalId("42", null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
  void testFindCellDataByGridExternalId3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findCellDataByGridExternalId("42", null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#findCellDataByGridExternalId(String, GenericSelector)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#findCellDataByGridExternalId(String,
   * GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test findCellDataByGridExternalId(String, GenericSelector); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.findCellDataByGridExternalId(String, GenericSelector)"})
  void testFindCellDataByGridExternalId_thenCallsFetchOne() throws DataAccessException {
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
  void testGetGridDefinitionById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.getGridDefinitionById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.getGridDefinitionById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionById(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionById(long)}
   */
  @Test
  @DisplayName("Test getGridDefinitionById(long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionById(long)"})
  void testGetGridDefinitionById_thenCallsFetchOne() throws DataAccessException {
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
  void testGetGridInfoById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.getGridInfoById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.getGridInfoById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#getGridInfoById(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#getGridInfoById(long)}
   */
  @Test
  @DisplayName("Test getGridInfoById(long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridInfo ReportGridDao.getGridInfoById(long)"})
  void testGetGridInfoById_thenCallsFetchOne() throws DataAccessException {
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
  void testGetGridDefinitionByExternalId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.getGridDefinitionByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.getGridDefinitionByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ReportGridDao#getGridDefinitionByExternalId(String)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#getGridDefinitionByExternalId(String)}
   */
  @Test
  @DisplayName("Test getGridDefinitionByExternalId(String); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridDefinition ReportGridDao.getGridDefinitionByExternalId(String)"})
  void testGetGridDefinitionByExternalId_thenCallsFetchOne() throws DataAccessException {
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
   *   <li>Given {@link DSLContext} {@link DSLContext#transaction(TransactionalRunnable)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#updateColumnDefinitions(long,
   * ReportGridColumnDefinitionsUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand); given DSLContext transaction(TransactionalRunnable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportGridDao.updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand)"
  })
  void testUpdateColumnDefinitions_givenDSLContextTransactionDoesNothing() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    reportGridDao.updateColumnDefinitions(1L, null);

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
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
   * <ul>
   *   <li>Then calls {@link DSLContext#newRecord(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String); then calls newRecord(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate_thenCallsNewRecord() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ReportGridRecord>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class, () -> reportGridDao.create(null, "janedoe"));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ReportGridDao#create(ReportGridCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(ReportGridCreateCommand, String); then calls prepareStatement(String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate_thenCallsPrepareStatement() throws SQLException {
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
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#create(ReportGridCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(ReportGridCreateCommand, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ReportGridDao.create(ReportGridCreateCommand, String)"})
  void testCreate_thenCallsPrepareStatement2() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any()))
        .thenThrow(new DataIntegrityViolationException("waltz"));
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
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
            "insert into \"report_grid\" (\"name\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"external_id\", \"kind\", \"subject_kind\") values (cast(? as varchar(4)), cast(? as varchar(43)), cast(? as timestamp), cast(? as varchar(7)), cast(? as varchar(5)), cast(? as varchar(36)), cast(? as varchar(6)), cast(? as varchar(3))) returning \"report_grid\".\"id\"");
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
    when(dSLContext.update(Mockito.<Table<ReportGridRecord>>any())).thenReturn(updateSetFirstStep);

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
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
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
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
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
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
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
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
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
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
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
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).set(isA(Field.class), isA(Object.class));
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
  void testFindDefinitionsForOwner2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findDefinitionsForOwner("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
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
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataIntegrityViolationException.class,
        () -> reportGridDao.findDefinitionsForOwner("janedoe"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
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
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
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
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataIntegrityViolationException("Msg"));

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
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerResult =
        reportGridDao.findDefinitionsForOwner("janedoe");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
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
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    when(dSLContext.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = reportGridDao.remove(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ReportGridDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportGridDao.remove(long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ReportGridRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<ReportGridRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = reportGridDao.remove(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
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
    when(dSLContext.deleteFrom(Mockito.<Table<ReportGridRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> reportGridDao.remove(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
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
    // Arrange, Act and Assert
    assertTrue(reportGridDao.fetchMeasurableHierarchyData(null, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector, Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridDao#fetchMeasurableHierarchyData(GenericSelector,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test fetchMeasurableHierarchyData(GenericSelector, Collection); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ReportGridDao.fetchMeasurableHierarchyData(GenericSelector, Collection)"})
  void testFetchMeasurableHierarchyData_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(reportGridDao.fetchMeasurableHierarchyData(null, null).isEmpty());
  }
}
