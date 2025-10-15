package org.finos.waltz.data.orphan;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.orphan.OrphanRelationship;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
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
class OrphanDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private OrphanDao orphanDao;

  /**
   * Test {@link OrphanDao#findApplicationsWithNonExistentOrgUnit()}.
   *
   * <p>Method under test: {@link OrphanDao#findApplicationsWithNonExistentOrgUnit()}
   */
  @Test
  @DisplayName("Test findApplicationsWithNonExistentOrgUnit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findApplicationsWithNonExistentOrgUnit()"})
  void testFindApplicationsWithNonExistentOrgUnit() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindApplicationsWithNonExistentOrgUnitResult =
        orphanDao.findApplicationsWithNonExistentOrgUnit();

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindApplicationsWithNonExistentOrgUnitResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanMeasurableRatings()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanMeasurableRatings()}
   */
  @Test
  @DisplayName("Test findOrphanMeasurableRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanMeasurableRatings()"})
  void testFindOrphanMeasurableRatings() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanMeasurableRatingsResult =
        orphanDao.findOrphanMeasurableRatings();

    // Assert
    verify(dSLContext, atLeast(1)).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep, atLeast(1))
        .fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any());
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualFindOrphanMeasurableRatingsResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanFlowClassificationRulesByOrgUnit()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanFlowClassificationRulesByOrgUnit()}
   */
  @Test
  @DisplayName("Test findOrphanFlowClassificationRulesByOrgUnit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanFlowClassificationRulesByOrgUnit()"})
  void testFindOrphanFlowClassificationRulesByOrgUnit() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanFlowClassificationRulesByOrgUnitResult =
        orphanDao.findOrphanFlowClassificationRulesByOrgUnit();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindOrphanFlowClassificationRulesByOrgUnitResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanFlowClassificationRulesByApp()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanFlowClassificationRulesByApp()}
   */
  @Test
  @DisplayName("Test findOrphanFlowClassificationRulesByApp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanFlowClassificationRulesByApp()"})
  void testFindOrphanFlowClassificationRulesByApp() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanFlowClassificationRulesByAppResult =
        orphanDao.findOrphanFlowClassificationRulesByApp();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).or(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindOrphanFlowClassificationRulesByAppResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanFlowClassificationRulesByDataType()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanFlowClassificationRulesByDataType()}
   */
  @Test
  @DisplayName("Test findOrphanFlowClassificationRulesByDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanFlowClassificationRulesByDataType()"})
  void testFindOrphanFlowClassificationRulesByDataType() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record3<Object, Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanFlowClassificationRulesByDataTypeResult =
        orphanDao.findOrphanFlowClassificationRulesByDataType();

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindOrphanFlowClassificationRulesByDataTypeResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanChangeInitiatives()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanChangeInitiatives()}
   */
  @Test
  @DisplayName("Test findOrphanChangeInitiatives()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanChangeInitiatives()"})
  void testFindOrphanChangeInitiatives() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanChangeInitiativesResult =
        orphanDao.findOrphanChangeInitiatives();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindOrphanChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanLogicalDataFlows()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanLogicalDataFlows()}
   */
  @Test
  @DisplayName("Test findOrphanLogicalDataFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanLogicalDataFlows()"})
  void testFindOrphanLogicalDataFlows() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record2<Object, Object>> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.unionAll(Mockito.<Select<Record2<Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep3 =
        mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanLogicalDataFlowsResult =
        orphanDao.findOrphanLogicalDataFlows();

    // Assert
    verify(dSLContext, atLeast(1))
        .select(isA(SelectField.class), Mockito.<SelectField<Object>>any());
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3, atLeast(1)).and(isA(Condition.class));
    verify(selectConditionStep2, atLeast(1)).and(Mockito.<Condition>any());
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectConditionStep).unionAll(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualFindOrphanLogicalDataFlowsResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanAttestatations()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanAttestatations()}
   */
  @Test
  @DisplayName("Test findOrphanAttestatations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanAttestatations()"})
  void testFindOrphanAttestatations() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record2<Object, Object>> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct(
            Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanAttestatationsResult =
        orphanDao.findOrphanAttestatations();

    // Assert
    verify(dSLContext).selectDistinct(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindOrphanAttestatationsResult.isEmpty());
  }

  /**
   * Test {@link OrphanDao#findOrphanPhysicalFlows()}.
   *
   * <p>Method under test: {@link OrphanDao#findOrphanPhysicalFlows()}
   */
  @Test
  @DisplayName("Test findOrphanPhysicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanDao.findOrphanPhysicalFlows()"})
  void testFindOrphanPhysicalFlows() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record3<Object, Object, Object>> selectOrderByStep =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.unionAll(Mockito.<Select<Record3<Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrphanRelationship> actualFindOrphanPhysicalFlowsResult =
        orphanDao.findOrphanPhysicalFlows();

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).unionAll(isA(Select.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindOrphanPhysicalFlowsResult.isEmpty());
  }
}
