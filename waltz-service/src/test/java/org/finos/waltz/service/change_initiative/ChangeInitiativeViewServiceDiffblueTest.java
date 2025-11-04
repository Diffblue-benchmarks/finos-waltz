package org.finos.waltz.service.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.change_initiative.ChangeInitiative;
import org.finos.waltz.model.change_initiative.ChangeInitiativeView;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiativeView;
import org.jooq.Condition;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeInitiativeViewServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  void testGetForEntityReference() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeViewService changeInitiativeViewService = new ChangeInitiativeViewService(changeInitiativeDao,
        mock(EntityRelationshipDao.class), assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeInitiativeView actualForEntityReference = changeInitiativeViewService.getForEntityReference(ref);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.CHANGE_INITIATIVE));
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    verify(ref, atLeast(1)).kind();
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  void testGetForEntityReference2() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    changeInitiativeList.add(mock(ChangeInitiative.class));
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeViewService changeInitiativeViewService = new ChangeInitiativeViewService(changeInitiativeDao,
        mock(EntityRelationshipDao.class), assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeInitiativeView actualForEntityReference = changeInitiativeViewService.getForEntityReference(ref);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.CHANGE_INITIATIVE));
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    verify(ref, atLeast(1)).kind();
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  void testGetForEntityReference3() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    changeInitiativeList.add(mock(ChangeInitiative.class));
    changeInitiativeList.add(mock(ChangeInitiative.class));
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeViewService changeInitiativeViewService = new ChangeInitiativeViewService(changeInitiativeDao,
        mock(EntityRelationshipDao.class), assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeInitiativeView actualForEntityReference = changeInitiativeViewService.getForEntityReference(ref);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.CHANGE_INITIATIVE));
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    verify(ref, atLeast(1)).kind();
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  void testGetForEntityReference4() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    assessmentRatingList.add(mock(AssessmentRating.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(assessmentRatingList);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeViewService changeInitiativeViewService = new ChangeInitiativeViewService(changeInitiativeDao,
        mock(EntityRelationshipDao.class), assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeInitiativeView actualForEntityReference = changeInitiativeViewService.getForEntityReference(ref);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.CHANGE_INITIATIVE));
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    verify(ref, atLeast(1)).kind();
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult = actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  void testGetForEntityReference5() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any())).thenReturn(new ArrayList<>());
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    when(assessmentDefinition.ratingSchemeId()).thenReturn(1L);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(assessmentDefinition);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeViewService changeInitiativeViewService = new ChangeInitiativeViewService(changeInitiativeDao,
        mock(EntityRelationshipDao.class), assessmentRatingDao, assessmentDefinitionDao, ratingSchemeDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeInitiativeView actualForEntityReference = changeInitiativeViewService.getForEntityReference(ref);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.CHANGE_INITIATIVE));
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    verify(ref, atLeast(1)).kind();
    verify(assessmentDefinition).ratingSchemeId();
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualForEntityReference.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualForEntityReference.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualForEntityReference.ratings());
  }
}
