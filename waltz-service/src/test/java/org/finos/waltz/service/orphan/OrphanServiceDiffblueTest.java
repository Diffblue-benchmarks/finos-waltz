package org.finos.waltz.service.orphan;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.orphan.OrphanDao;
import org.finos.waltz.model.orphan.OrphanRelationship;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrphanServiceDiffblueTest {
  /**
   * Test {@link OrphanService#findApplicationsWithNonExistingOrgUnit()}.
   *
   * <p>Method under test: {@link OrphanService#findApplicationsWithNonExistingOrgUnit()}
   */
  @Test
  @DisplayName("Test findApplicationsWithNonExistingOrgUnit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection OrphanService.findApplicationsWithNonExistingOrgUnit()"})
  void testFindApplicationsWithNonExistingOrgUnit() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findApplicationsWithNonExistentOrgUnit()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindApplicationsWithNonExistingOrgUnitResult =
        new OrphanService(orphanDao).findApplicationsWithNonExistingOrgUnit();

    // Assert
    verify(orphanDao).findApplicationsWithNonExistentOrgUnit();
    assertTrue(actualFindApplicationsWithNonExistingOrgUnitResult instanceof List);
    assertTrue(actualFindApplicationsWithNonExistingOrgUnitResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindApplicationsWithNonExistingOrgUnitResult);
  }

  /**
   * Test {@link OrphanService#findOrphanMeasurableRatings()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanMeasurableRatings()}
   */
  @Test
  @DisplayName("Test findOrphanMeasurableRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection OrphanService.findOrphanMeasurableRatings()"})
  void testFindOrphanMeasurableRatings() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanMeasurableRatings()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanMeasurableRatingsResult =
        new OrphanService(orphanDao).findOrphanMeasurableRatings();

    // Assert
    verify(orphanDao).findOrphanMeasurableRatings();
    assertTrue(actualFindOrphanMeasurableRatingsResult instanceof List);
    assertTrue(actualFindOrphanMeasurableRatingsResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanMeasurableRatingsResult);
  }

  /**
   * Test {@link OrphanService#findOrphanFlowClassificationRulesByOrgUnit()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanFlowClassificationRulesByOrgUnit()}
   */
  @Test
  @DisplayName("Test findOrphanFlowClassificationRulesByOrgUnit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection OrphanService.findOrphanFlowClassificationRulesByOrgUnit()"})
  void testFindOrphanFlowClassificationRulesByOrgUnit() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanFlowClassificationRulesByOrgUnit()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanFlowClassificationRulesByOrgUnitResult =
        new OrphanService(orphanDao).findOrphanFlowClassificationRulesByOrgUnit();

    // Assert
    verify(orphanDao).findOrphanFlowClassificationRulesByOrgUnit();
    assertTrue(actualFindOrphanFlowClassificationRulesByOrgUnitResult instanceof List);
    assertTrue(actualFindOrphanFlowClassificationRulesByOrgUnitResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanFlowClassificationRulesByOrgUnitResult);
  }

  /**
   * Test {@link OrphanService#findOrphanFlowClassificationRulesByApp()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanFlowClassificationRulesByApp()}
   */
  @Test
  @DisplayName("Test findOrphanFlowClassificationRulesByApp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection OrphanService.findOrphanFlowClassificationRulesByApp()"})
  void testFindOrphanFlowClassificationRulesByApp() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanFlowClassificationRulesByApp()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanFlowClassificationRulesByAppResult =
        new OrphanService(orphanDao).findOrphanFlowClassificationRulesByApp();

    // Assert
    verify(orphanDao).findOrphanFlowClassificationRulesByApp();
    assertTrue(actualFindOrphanFlowClassificationRulesByAppResult instanceof List);
    assertTrue(actualFindOrphanFlowClassificationRulesByAppResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanFlowClassificationRulesByAppResult);
  }

  /**
   * Test {@link OrphanService#findOrphanFlowClassificationRulesByDataType()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanFlowClassificationRulesByDataType()}
   */
  @Test
  @DisplayName("Test findOrphanFlowClassificationRulesByDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection OrphanService.findOrphanFlowClassificationRulesByDataType()"})
  void testFindOrphanFlowClassificationRulesByDataType() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanFlowClassificationRulesByDataType())
        .thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanFlowClassificationRulesByDataTypeResult =
        new OrphanService(orphanDao).findOrphanFlowClassificationRulesByDataType();

    // Assert
    verify(orphanDao).findOrphanFlowClassificationRulesByDataType();
    assertTrue(actualFindOrphanFlowClassificationRulesByDataTypeResult instanceof List);
    assertTrue(actualFindOrphanFlowClassificationRulesByDataTypeResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanFlowClassificationRulesByDataTypeResult);
  }

  /**
   * Test {@link OrphanService#findOrphanChangeInitiatives()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanChangeInitiatives()}
   */
  @Test
  @DisplayName("Test findOrphanChangeInitiatives()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanService.findOrphanChangeInitiatives()"})
  void testFindOrphanChangeInitiatives() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    when(orphanDao.findOrphanChangeInitiatives()).thenReturn(new ArrayList<>());

    // Act
    List<OrphanRelationship> actualFindOrphanChangeInitiativesResult =
        new OrphanService(orphanDao).findOrphanChangeInitiatives();

    // Assert
    verify(orphanDao).findOrphanChangeInitiatives();
    assertTrue(actualFindOrphanChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link OrphanService#findOrphanLogicalDataFlows()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanLogicalDataFlows()}
   */
  @Test
  @DisplayName("Test findOrphanLogicalDataFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanService.findOrphanLogicalDataFlows()"})
  void testFindOrphanLogicalDataFlows() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    when(orphanDao.findOrphanLogicalDataFlows()).thenReturn(new ArrayList<>());

    // Act
    List<OrphanRelationship> actualFindOrphanLogicalDataFlowsResult =
        new OrphanService(orphanDao).findOrphanLogicalDataFlows();

    // Assert
    verify(orphanDao).findOrphanLogicalDataFlows();
    assertTrue(actualFindOrphanLogicalDataFlowsResult.isEmpty());
  }

  /**
   * Test {@link OrphanService#findOrphanPhysicalFlows()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanPhysicalFlows()}
   */
  @Test
  @DisplayName("Test findOrphanPhysicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanService.findOrphanPhysicalFlows()"})
  void testFindOrphanPhysicalFlows() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    when(orphanDao.findOrphanPhysicalFlows()).thenReturn(new ArrayList<>());

    // Act
    List<OrphanRelationship> actualFindOrphanPhysicalFlowsResult =
        new OrphanService(orphanDao).findOrphanPhysicalFlows();

    // Assert
    verify(orphanDao).findOrphanPhysicalFlows();
    assertTrue(actualFindOrphanPhysicalFlowsResult.isEmpty());
  }

  /**
   * Test {@link OrphanService#findOrphanAttestatations()}.
   *
   * <p>Method under test: {@link OrphanService#findOrphanAttestatations()}
   */
  @Test
  @DisplayName("Test findOrphanAttestatations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrphanService.findOrphanAttestatations()"})
  void testFindOrphanAttestatations() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    when(orphanDao.findOrphanAttestatations()).thenReturn(new ArrayList<>());

    // Act
    List<OrphanRelationship> actualFindOrphanAttestatationsResult =
        new OrphanService(orphanDao).findOrphanAttestatations();

    // Assert
    verify(orphanDao).findOrphanAttestatations();
    assertTrue(actualFindOrphanAttestatationsResult.isEmpty());
  }
}
