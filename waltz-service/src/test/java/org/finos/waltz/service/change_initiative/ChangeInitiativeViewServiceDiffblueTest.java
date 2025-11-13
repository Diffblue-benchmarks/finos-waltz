package org.finos.waltz.service.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.change_initiative.ChangeInitiative;
import org.finos.waltz.model.change_initiative.ChangeInitiativeKind;
import org.finos.waltz.model.change_initiative.ChangeInitiativeView;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative.Builder;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiativeView;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.jooq.Condition;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeInitiativeViewServiceDiffblueTest {
  @Mock private AssessmentDefinitionDao assessmentDefinitionDao;

  @Mock private AssessmentRatingDao assessmentRatingDao;

  @Mock private ChangeInitiativeDao changeInitiativeDao;

  @InjectMocks private ChangeInitiativeViewService changeInitiativeViewService;

  @Mock private EntityRelationshipDao entityRelationshipDao;

  @Mock private RatingSchemeDAO ratingSchemeDAO;

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference3() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(-2L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference4() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(-2L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference5() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(-2L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference6() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(-2L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference7() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(-2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference8() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(-2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference9() {
    // Arrange
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(-2L)
            .build());
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(assessmentRatingList);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDAO).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(2, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitions size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getForEntityReference(EntityReference); then return assessmentDefinitions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnAssessmentDefinitionsSizeIsOne() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(assessmentDefinitionSet);

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.assessmentDefinitions().size());
    Set<ChangeInitiative> changeInitiativesResult = actualForEntityReference.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualForEntityReference.ratingSchemeItems());
    assertSame(changeInitiativesResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getForEntityReference(EntityReference); then return changeInitiatives size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnChangeInitiativesSizeIsOne() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getForEntityReference(EntityReference); then return changeInitiatives size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnChangeInitiativesSizeIsOne2() {
    // Arrange
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();

    Builder descriptionResult =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult =
        descriptionResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult =
        kindResult
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    Builder descriptionResult2 =
        ImmutableChangeInitiative.builder()
            .changeInitiativeKind(ChangeInitiativeKind.INITIATIVE)
            .description("The characteristics of someone or something");

    Builder kindResult2 =
        descriptionResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL);

    Builder provenanceResult2 =
        kindResult2
            .lastUpdate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance");
    changeInitiativeList.add(
        provenanceResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.changeInitiatives().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getForEntityReference(EntityReference); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(ratingSchemeItemList);

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.ratingSchemeItems().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getForEntityReference(EntityReference); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnRatingSchemeItemsSizeIsOne2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(ratingSchemeItemList);

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.ratingSchemeItems().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return ratings is assessmentDefinitions.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getForEntityReference(EntityReference); then return ratings is assessmentDefinitions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnRatingsIsAssessmentDefinitions() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratings());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return ratings size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference); then return ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnRatingsSizeIsOne() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }

  /**
   * Test {@link ChangeInitiativeViewService#getForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return ratings size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeInitiativeViewService#getForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getForEntityReference(EntityReference); then return ratings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChangeInitiativeView ChangeInitiativeViewService.getForEntityReference(EntityReference)"
  })
  void testGetForEntityReference_thenReturnRatingsSizeIsOne2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDao = mock(RatingSchemeDAO.class);
    when(ratingSchemeDao.fetchItems(Mockito.<Condition>any())).thenReturn(new ArrayList<>());

    ChangeInitiativeViewService changeInitiativeViewService =
        new ChangeInitiativeViewService(
            changeInitiativeDao,
            mock(EntityRelationshipDao.class),
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDao);

    // Act
    ChangeInitiativeView actualForEntityReference =
        changeInitiativeViewService.getForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(assessmentDefinitionDao).findByEntityKind(EntityKind.CHANGE_INITIATIVE);
    verify(assessmentRatingDao).findByGenericSelector(isA(GenericSelector.class));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(ratingSchemeDao).fetchItems(isA(Condition.class));
    assertTrue(actualForEntityReference instanceof ImmutableChangeInitiativeView);
    assertEquals(1, actualForEntityReference.ratings().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        actualForEntityReference.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.changeInitiatives());
    assertSame(assessmentDefinitionsResult, actualForEntityReference.ratingSchemeItems());
  }
}
