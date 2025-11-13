package org.finos.waltz.service.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition.Builder;
import org.finos.waltz.model.user.ImmutableUserPreference;
import org.finos.waltz.model.user.UserPreference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentDefinitionServiceDiffblueTest {
  /**
   * Test {@link AssessmentDefinitionService#getById(long)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentDefinition AssessmentDefinitionService.getById(long)"})
  void testGetById() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    when(assessmentDefinitionDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    AssessmentDefinition actualById = assessmentDefinitionService.getById(1L);

    // Assert
    verify(assessmentDefinitionDao).getById(1L);
    assertTrue(actualById instanceof ImmutableAssessmentDefinition);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Definition Group", actualById.definitionGroup());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualById.cardinality());
    assertEquals(EntityKind.ALL, actualById.entityKind());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualById.visibility());
    assertTrue(actualById.isReadOnly());
  }

  /**
   * Test {@link AssessmentDefinitionService#findAll()}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findAll()"})
  void testFindAll() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    Set<AssessmentDefinition> actualFindAllResult = assessmentDefinitionService.findAll();

    // Assert
    verify(assessmentDefinitionDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findByEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findByEntityKind(EntityKind)"})
  void testFindByEntityKind() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    Set<AssessmentDefinition> actualFindByEntityKindResult =
        assessmentDefinitionService.findByEntityKind(EntityKind.ALL);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.ALL);
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findByEntityKindAndQualifier(EntityKind,
   * EntityReference)}.
   *
   * <p>Method under test: {@link
   * AssessmentDefinitionService#findByEntityKindAndQualifier(EntityKind, EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityKindAndQualifier(EntityKind, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentDefinitionService.findByEntityKindAndQualifier(EntityKind, EntityReference)"
  })
  void testFindByEntityKindAndQualifier() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKindAndQualifier(
            Mockito.<EntityKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    Set<AssessmentDefinition> actualFindByEntityKindAndQualifierResult =
        assessmentDefinitionService.findByEntityKindAndQualifier(EntityKind.ALL, null);

    // Assert
    verify(assessmentDefinitionDao).findByEntityKindAndQualifier(eq(EntityKind.ALL), isNull());
    assertTrue(actualFindByEntityKindAndQualifierResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AssessmentDefinitionService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    Set<AssessmentDefinition> actualFindByEntityReferenceResult =
        assessmentDefinitionService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.ALL);
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AssessmentDefinitionService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    Set<AssessmentDefinition> actualFindByEntityReferenceResult =
        assessmentDefinitionService.findByEntityReference(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.ALL);
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findByPrimaryDefinitionsForKind(EntityKind, Optional)}.
   *
   * <p>Method under test: {@link
   * AssessmentDefinitionService#findByPrimaryDefinitionsForKind(EntityKind, Optional)}
   */
  @Test
  @DisplayName("Test findByPrimaryDefinitionsForKind(EntityKind, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentDefinitionService.findByPrimaryDefinitionsForKind(EntityKind, Optional)"
  })
  void testFindByPrimaryDefinitionsForKind() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act
    Set<AssessmentDefinition> actualFindByPrimaryDefinitionsForKindResult =
        assessmentDefinitionService.findByPrimaryDefinitionsForKind(
            EntityKind.ALL, qualifierReference);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.ALL), isA(Optional.class));
    assertTrue(actualFindByPrimaryDefinitionsForKindResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#save(AssessmentDefinition)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#save(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test save(AssessmentDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentDefinitionService.save(AssessmentDefinition)"})
  void testSave() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.save(Mockito.<AssessmentDefinition>any())).thenReturn(1L);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    Long actualSaveResult = assessmentDefinitionService.save(null);

    // Assert
    verify(assessmentDefinitionDao).save(isNull());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link AssessmentDefinitionService#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionDao} {@link AssessmentDefinitionDao#remove(long)} return
   *       one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given AssessmentDefinitionDao remove(long) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentDefinitionService.remove(long)"})
  void testRemove_givenAssessmentDefinitionDaoRemoveReturnOne_thenReturnTrue() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.remove(anyLong())).thenReturn(1);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    boolean actualRemoveResult = assessmentDefinitionService.remove(1L);

    // Assert
    verify(assessmentDefinitionDao).remove(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentDefinitionService#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link AssessmentDefinitionDao} {@link AssessmentDefinitionDao#remove(long)} return
   *       zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given AssessmentDefinitionDao remove(long) return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssessmentDefinitionService.remove(long)"})
  void testRemove_givenAssessmentDefinitionDaoRemoveReturnZero_thenReturnFalse() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.remove(anyLong())).thenReturn(0);
    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            mock(UserPreferenceDao.class));

    // Act
    boolean actualRemoveResult = assessmentDefinitionService.remove(1L);

    // Assert
    verify(assessmentDefinitionDao).remove(1L);
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link AssessmentDefinitionService#findFavouritesForUser(String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  @DisplayName("Test findFavouritesForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findFavouritesForUser(String)"})
  void testFindFavouritesForUser() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value("42")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult =
        assessmentDefinitionService.findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findFavouritesForUser(String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  @DisplayName("Test findFavouritesForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findFavouritesForUser(String)"})
  void testFindFavouritesForUser2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value(",")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult =
        assessmentDefinitionService.findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findFavouritesForUser(String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  @DisplayName("Test findFavouritesForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findFavouritesForUser(String)"})
  void testFindFavouritesForUser3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value("")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult =
        assessmentDefinitionService.findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findFavouritesForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  @DisplayName("Test findFavouritesForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findFavouritesForUser(String)"})
  void testFindFavouritesForUser_thenReturnEmpty() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult =
        assessmentDefinitionService.findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findFavouritesForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  @DisplayName("Test findFavouritesForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findFavouritesForUser(String)"})
  void testFindFavouritesForUser_thenReturnEmpty2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult =
        assessmentDefinitionService.findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#findFavouritesForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#findFavouritesForUser(String)}
   */
  @Test
  @DisplayName("Test findFavouritesForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.findFavouritesForUser(String)"})
  void testFindFavouritesForUser_thenReturnEmpty3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualFindFavouritesForUserResult =
        assessmentDefinitionService.findFavouritesForUser("janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouritesForUserResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#addFavourite(long, String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  @DisplayName("Test addFavourite(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.addFavourite(long, String)"})
  void testAddFavourite() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value("42")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult =
        assessmentDefinitionService.addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#addFavourite(long, String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  @DisplayName("Test addFavourite(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.addFavourite(long, String)"})
  void testAddFavourite2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value(",")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult =
        assessmentDefinitionService.addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#addFavourite(long, String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  @DisplayName("Test addFavourite(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.addFavourite(long, String)"})
  void testAddFavourite3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value("")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult =
        assessmentDefinitionService.addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#addFavourite(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder key {@code Key} value {@code 42} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  @DisplayName(
      "Test addFavourite(long, String); given ArrayList() add builder key 'Key' value '42' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.addFavourite(long, String)"})
  void testAddFavourite_givenArrayListAddBuilderKeyKeyValue42Build_thenReturnEmpty() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult =
        assessmentDefinitionService.addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#addFavourite(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder key {@code Key} value {@code 42} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  @DisplayName(
      "Test addFavourite(long, String); given ArrayList() add builder key 'Key' value '42' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.addFavourite(long, String)"})
  void testAddFavourite_givenArrayListAddBuilderKeyKeyValue42Build_thenReturnEmpty2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult =
        assessmentDefinitionService.addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#addFavourite(long, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#addFavourite(long, String)}
   */
  @Test
  @DisplayName("Test addFavourite(long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.addFavourite(long, String)"})
  void testAddFavourite_thenReturnEmpty() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualAddFavouriteResult =
        assessmentDefinitionService.addFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualAddFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#removeFavourite(long, String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  @DisplayName("Test removeFavourite(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.removeFavourite(long, String)"})
  void testRemoveFavourite() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value("42")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult =
        assessmentDefinitionService.removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#removeFavourite(long, String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  @DisplayName("Test removeFavourite(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.removeFavourite(long, String)"})
  void testRemoveFavourite2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value(",")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult =
        assessmentDefinitionService.removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#removeFavourite(long, String)}.
   *
   * <p>Method under test: {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  @DisplayName("Test removeFavourite(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.removeFavourite(long, String)"})
  void testRemoveFavourite3() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(
        ImmutableUserPreference.builder()
            .key("assessment-rating.favourites.included")
            .value("")
            .build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult =
        assessmentDefinitionService.removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#removeFavourite(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder key {@code Key} value {@code 42} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFavourite(long, String); given ArrayList() add builder key 'Key' value '42' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.removeFavourite(long, String)"})
  void testRemoveFavourite_givenArrayListAddBuilderKeyKeyValue42Build_thenReturnEmpty() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult =
        assessmentDefinitionService.removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#removeFavourite(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder key {@code Key} value {@code 42} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFavourite(long, String); given ArrayList() add builder key 'Key' value '42' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.removeFavourite(long, String)"})
  void testRemoveFavourite_givenArrayListAddBuilderKeyKeyValue42Build_thenReturnEmpty2() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult =
        assessmentDefinitionService.removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionService#removeFavourite(long, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionService#removeFavourite(long, String)}
   */
  @Test
  @DisplayName("Test removeFavourite(long, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentDefinitionService.removeFavourite(long, String)"})
  void testRemoveFavourite_thenReturnEmpty() {
    // Arrange
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findFavourites(Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.savePreferencesForUser(
            Mockito.<String>any(), Mockito.<List<UserPreference>>any()))
        .thenReturn(1);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionService assessmentDefinitionService =
        new AssessmentDefinitionService(
            assessmentDefinitionDao,
            mock(MeasurableDao.class),
            mock(MeasurableRatingDao.class),
            mock(LegalEntityRelationshipDao.class),
            userPreferenceDao);

    // Act
    Set<AssessmentDefinition> actualRemoveFavouriteResult =
        assessmentDefinitionService.removeFavourite(1L, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findFavourites(isA(Set.class), isA(Set.class));
    verify(userPreferenceDao, atLeast(1)).getPreferencesForUser("janedoe");
    verify(userPreferenceDao).savePreferencesForUser(eq("janedoe"), isA(List.class));
    assertTrue(actualRemoveFavouriteResult.isEmpty());
  }
}
