package org.finos.waltz.service.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.user.UserPreference;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentDefinitionServiceDiffblueTest {
  /**
   * Method under test: {@link AssessmentDefinitionService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.getById(anyLong())).thenReturn(null);

    // Act
    AssessmentDefinition actualById = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        mock(UserPreferenceDao.class))).getById(1L);

    // Assert
    verify(assessmentDefinitionDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AssessmentDefinitionService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);

    // Act
    Set<AssessmentDefinition> actualFindAllResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        mock(UserPreferenceDao.class))).findAll();

    // Assert
    verify(assessmentDefinitionDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(assessmentDefinitionSet);

    // Act
    Set<AssessmentDefinition> actualFindByEntityKindResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        mock(UserPreferenceDao.class))).findByEntityKind(EntityKind.ALL);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.ALL));
    assertTrue(actualFindByEntityKindResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindByEntityKindResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findByEntityKindAndQualifier(EntityKind, EntityReference)}
   */
  @Test
  void testFindByEntityKindAndQualifier() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(
        assessmentDefinitionDao.findByEntityKindAndQualifier(Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
            .thenReturn(assessmentDefinitionSet);

    // Act
    Set<AssessmentDefinition> actualFindByEntityKindAndQualifierResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class)))
            .findByEntityKindAndQualifier(EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKindAndQualifier(eq(EntityKind.ALL), isNull());
    assertTrue(actualFindByEntityKindAndQualifierResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindByEntityKindAndQualifierResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(assessmentDefinitionSet);
    AssessmentDefinitionService assessmentDefinitionService = new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        mock(UserPreferenceDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<AssessmentDefinition> actualFindByEntityReferenceResult = assessmentDefinitionService
        .findByEntityReference(entityReference);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(eq(EntityKind.ALL));
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findByPrimaryDefinitionsForKind(EntityKind, Optional)}
   */
  @Test
  void testFindByPrimaryDefinitionsForKind() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(assessmentDefinitionSet);
    AssessmentDefinitionService assessmentDefinitionService = new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        mock(UserPreferenceDao.class));
    Optional<EntityReference> qualifierReference = Optional.of(mock(EntityReference.class));

    // Act
    Set<AssessmentDefinition> actualFindByPrimaryDefinitionsForKindResult = assessmentDefinitionService
        .findByPrimaryDefinitionsForKind(EntityKind.ALL, qualifierReference);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.ALL), isA(Optional.class));
    assertTrue(actualFindByPrimaryDefinitionsForKindResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindByPrimaryDefinitionsForKindResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#save(AssessmentDefinition)}
   */
  @Test
  void testSave() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);

    // Act
    Long actualSaveResult = (new AssessmentDefinitionService(assessmentDefinitionDao, mock(MeasurableDao.class),
        mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class)))
            .save(null);

    // Assert
    verify(assessmentDefinitionDao).save(isNull());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test: {@link AssessmentDefinitionService#remove(long)}
   */
  @Test
  void testRemove() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.remove(anyLong())).thenReturn(1);

    // Act
    boolean actualRemoveResult = (new AssessmentDefinitionService(assessmentDefinitionDao, mock(MeasurableDao.class),
        mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class)))
            .remove(1L);

    // Assert
    verify(assessmentDefinitionDao).remove(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentDefinitionService#remove(long)}
   */
  @Test
  void testRemove2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.remove(anyLong())).thenReturn(0);

    // Act
    boolean actualRemoveResult = (new AssessmentDefinitionService(assessmentDefinitionDao, mock(MeasurableDao.class),
        mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class), mock(UserPreferenceDao.class)))
            .remove(1L);

    // Assert
    verify(assessmentDefinitionDao).remove(eq(1L));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreference).key();
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.key()).thenReturn("Key");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreference2).key();
    verify(userPreference).key();
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser4() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn("42");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreference2).key();
    verify(userPreference).key();
    verify(userPreference2).value();
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser5() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn(",");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreference2).key();
    verify(userPreference).key();
    verify(userPreference2).value();
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser6() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn(null);
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreference2).key();
    verify(userPreference).key();
    verify(userPreference2).value();
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  void testFindFavouritesForUser7() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn("");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult = (new AssessmentDefinitionService(
        assessmentDefinitionDao, mock(MeasurableDao.class), mock(MeasurableRatingDao.class),
        mock(LegalEntityRelationshipDao.class), userPreferenceDao)).findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser(eq("janedoe"));
    verify(userPreference2).key();
    verify(userPreference).key();
    verify(userPreference2).value();
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualFindFavouritesForUserResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference, atLeast(1)).key();
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.key()).thenReturn("Key");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite4() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn("42");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite5() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn(",");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite6() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn(null);
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  void testAddFavourite7() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn("");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualAddFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualAddFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference, atLeast(1)).key();
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.key()).thenReturn("Key");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite4() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn("42");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite5() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn(",");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite6() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn(null);
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }

  /**
   * Method under test:
   * {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  void testRemoveFavourite7() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentDefinitionSet);
    UserPreference userPreference = mock(UserPreference.class);
    when(userPreference.key()).thenReturn("Key");
    UserPreference userPreference2 = mock(UserPreference.class);
    when(userPreference2.value()).thenReturn("");
    when(userPreference2.key()).thenReturn("assessment-rating.favourites.included");

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(userPreference2);
    userPreferenceList.add(userPreference);
    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any())).thenReturn(userPreferenceList);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult = (new AssessmentDefinitionService(assessmentDefinitionDao,
        mock(MeasurableDao.class), mock(MeasurableRatingDao.class), mock(LegalEntityRelationshipDao.class),
        userPreferenceDao)).removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser(eq("janedoe"));
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    verify(userPreference2, atLeast(1)).key();
    verify(userPreference, atLeast(1)).key();
    verify(userPreference2, atLeast(1)).value();
    assertTrue(actualRemoveFavouriteResult.isEmpty());
    assertSame(assessmentDefinitionSet, actualRemoveFavouriteResult);
  }
}
