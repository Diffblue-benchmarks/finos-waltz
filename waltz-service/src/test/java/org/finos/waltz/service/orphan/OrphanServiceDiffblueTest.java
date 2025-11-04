package org.finos.waltz.service.orphan;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.orphan.OrphanDao;
import org.finos.waltz.model.orphan.OrphanRelationship;
import org.junit.jupiter.api.Test;

class OrphanServiceDiffblueTest {
  /**
   * Method under test:
   * {@link OrphanService#findApplicationsWithNonExistingOrgUnit()}
   */
  @Test
  void testFindApplicationsWithNonExistingOrgUnit() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findApplicationsWithNonExistentOrgUnit()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindApplicationsWithNonExistingOrgUnitResult = (new OrphanService(orphanDao))
        .findApplicationsWithNonExistingOrgUnit();

    // Assert
    verify(orphanDao).findApplicationsWithNonExistentOrgUnit();
    assertTrue(actualFindApplicationsWithNonExistingOrgUnitResult instanceof List);
    assertTrue(actualFindApplicationsWithNonExistingOrgUnitResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindApplicationsWithNonExistingOrgUnitResult);
  }

  /**
   * Method under test: {@link OrphanService#findOrphanMeasurableRatings()}
   */
  @Test
  void testFindOrphanMeasurableRatings() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanMeasurableRatings()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanMeasurableRatingsResult = (new OrphanService(orphanDao))
        .findOrphanMeasurableRatings();

    // Assert
    verify(orphanDao).findOrphanMeasurableRatings();
    assertTrue(actualFindOrphanMeasurableRatingsResult instanceof List);
    assertTrue(actualFindOrphanMeasurableRatingsResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanMeasurableRatingsResult);
  }

  /**
   * Method under test:
   * {@link OrphanService#findOrphanFlowClassificationRulesByOrgUnit()}
   */
  @Test
  void testFindOrphanFlowClassificationRulesByOrgUnit() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanFlowClassificationRulesByOrgUnit()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanFlowClassificationRulesByOrgUnitResult = (new OrphanService(
        orphanDao)).findOrphanFlowClassificationRulesByOrgUnit();

    // Assert
    verify(orphanDao).findOrphanFlowClassificationRulesByOrgUnit();
    assertTrue(actualFindOrphanFlowClassificationRulesByOrgUnitResult instanceof List);
    assertTrue(actualFindOrphanFlowClassificationRulesByOrgUnitResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanFlowClassificationRulesByOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link OrphanService#findOrphanFlowClassificationRulesByApp()}
   */
  @Test
  void testFindOrphanFlowClassificationRulesByApp() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanFlowClassificationRulesByApp()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanFlowClassificationRulesByAppResult = (new OrphanService(orphanDao))
        .findOrphanFlowClassificationRulesByApp();

    // Assert
    verify(orphanDao).findOrphanFlowClassificationRulesByApp();
    assertTrue(actualFindOrphanFlowClassificationRulesByAppResult instanceof List);
    assertTrue(actualFindOrphanFlowClassificationRulesByAppResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanFlowClassificationRulesByAppResult);
  }

  /**
   * Method under test:
   * {@link OrphanService#findOrphanFlowClassificationRulesByDataType()}
   */
  @Test
  void testFindOrphanFlowClassificationRulesByDataType() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanFlowClassificationRulesByDataType()).thenReturn(orphanRelationshipList);

    // Act
    Collection<OrphanRelationship> actualFindOrphanFlowClassificationRulesByDataTypeResult = (new OrphanService(
        orphanDao)).findOrphanFlowClassificationRulesByDataType();

    // Assert
    verify(orphanDao).findOrphanFlowClassificationRulesByDataType();
    assertTrue(actualFindOrphanFlowClassificationRulesByDataTypeResult instanceof List);
    assertTrue(actualFindOrphanFlowClassificationRulesByDataTypeResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanFlowClassificationRulesByDataTypeResult);
  }

  /**
   * Method under test: {@link OrphanService#findOrphanChangeInitiatives()}
   */
  @Test
  void testFindOrphanChangeInitiatives() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanChangeInitiatives()).thenReturn(orphanRelationshipList);

    // Act
    List<OrphanRelationship> actualFindOrphanChangeInitiativesResult = (new OrphanService(orphanDao))
        .findOrphanChangeInitiatives();

    // Assert
    verify(orphanDao).findOrphanChangeInitiatives();
    assertTrue(actualFindOrphanChangeInitiativesResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanChangeInitiativesResult);
  }

  /**
   * Method under test: {@link OrphanService#findOrphanLogicalDataFlows()}
   */
  @Test
  void testFindOrphanLogicalDataFlows() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanLogicalDataFlows()).thenReturn(orphanRelationshipList);

    // Act
    List<OrphanRelationship> actualFindOrphanLogicalDataFlowsResult = (new OrphanService(orphanDao))
        .findOrphanLogicalDataFlows();

    // Assert
    verify(orphanDao).findOrphanLogicalDataFlows();
    assertTrue(actualFindOrphanLogicalDataFlowsResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanLogicalDataFlowsResult);
  }

  /**
   * Method under test: {@link OrphanService#findOrphanPhysicalFlows()}
   */
  @Test
  void testFindOrphanPhysicalFlows() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanPhysicalFlows()).thenReturn(orphanRelationshipList);

    // Act
    List<OrphanRelationship> actualFindOrphanPhysicalFlowsResult = (new OrphanService(orphanDao))
        .findOrphanPhysicalFlows();

    // Assert
    verify(orphanDao).findOrphanPhysicalFlows();
    assertTrue(actualFindOrphanPhysicalFlowsResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanPhysicalFlowsResult);
  }

  /**
   * Method under test: {@link OrphanService#findOrphanAttestatations()}
   */
  @Test
  void testFindOrphanAttestatations() {
    // Arrange
    OrphanDao orphanDao = mock(OrphanDao.class);
    ArrayList<OrphanRelationship> orphanRelationshipList = new ArrayList<>();
    when(orphanDao.findOrphanAttestatations()).thenReturn(orphanRelationshipList);

    // Act
    List<OrphanRelationship> actualFindOrphanAttestatationsResult = (new OrphanService(orphanDao))
        .findOrphanAttestatations();

    // Assert
    verify(orphanDao).findOrphanAttestatations();
    assertTrue(actualFindOrphanAttestatationsResult.isEmpty());
    assertSame(orphanRelationshipList, actualFindOrphanAttestatationsResult);
  }
}
