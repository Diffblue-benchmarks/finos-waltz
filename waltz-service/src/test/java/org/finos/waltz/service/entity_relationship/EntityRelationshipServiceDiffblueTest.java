package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.entity_relationship.Directionality;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship.Builder;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityRelationshipServiceDiffblueTest {
  @Mock private EntityRelationshipDao entityRelationshipDao;

  @InjectMocks private EntityRelationshipService entityRelationshipService;

  /**
   * Test {@link EntityRelationshipService#getById(Long)}.
   *
   * <p>Method under test: {@link EntityRelationshipService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationship EntityRelationshipService.getById(Long)"})
  void testGetById() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(entityRelationshipDao.getById(Mockito.<Long>any()))
        .thenReturn(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .description("The characteristics of someone or something")
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .relationship("127.0.0.1")
                .build());

    // Act
    EntityRelationship actualById = entityRelationshipService.getById(1L);

    // Assert
    verify(entityRelationshipDao).getById(1L);
    EntityReference aResult2 = actualById.a();
    assertTrue(aResult2 instanceof ImmutableEntityReference);
    EntityReference bResult = actualById.b();
    assertTrue(bResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableEntityRelationship);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", aResult2.description());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, aResult2.id());
    assertEquals(EntityKind.ALL, aResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, aResult2.entityLifecycleStatus());
    assertEquals(aResult2, bResult);
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference, Directionality, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(ref, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference, Directionality, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity2() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(ref, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference, Directionality, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity3() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(ref, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>Given {@code DEPRECATES}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DEPRECATES}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); given 'DEPRECATES'; when ArrayList() add 'DEPRECATES'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_givenDeprecates_whenArrayListAddDeprecates_thenReturnEmpty() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<RelationshipKind> relationshipKinds = new ArrayList<>();
    relationshipKinds.add(RelationshipKind.DEPRECATES);
    relationshipKinds.add(RelationshipKind.HAS);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.ANY, relationshipKinds);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>Given {@code HAS}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code HAS}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); given 'HAS'; when ArrayList() add 'HAS'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_givenHas_whenArrayListAddHas_thenReturnEmpty() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<RelationshipKind> relationshipKinds = new ArrayList<>();
    relationshipKinds.add(RelationshipKind.HAS);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.ANY, relationshipKinds);

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>Then return first lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); then return first lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_thenReturnFirstLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(ref, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult instanceof List);
    assertEquals(1, actualFindForEntityResult.size());
    EntityRelationship getResult = ((List<EntityRelationship>) actualFindForEntityResult).get(0);
    assertTrue(getResult instanceof ImmutableEntityRelationship);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", getResult.lastUpdatedBy());
    assertEquals("Provenance", getResult.provenance());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName("Test findForEntity(EntityReference, Directionality, List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(ref, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult instanceof List);
    assertEquals(2, actualFindForEntityResult.size());
    EntityRelationship getResult = ((List<EntityRelationship>) actualFindForEntityResult).get(1);
    assertTrue(getResult instanceof ImmutableEntityRelationship);
    assertEquals(((List<EntityRelationship>) actualFindForEntityResult).get(0), getResult);
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code ANY}.
   *   <li>Then first a return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'ANY'; then first a return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenAny_thenFirstAReturnImmutableEntityReference() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.ANY, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertEquals(1, actualFindForEntityResult.size());
    EntityRelationship getResult = ((List<EntityRelationship>) actualFindForEntityResult).get(0);
    EntityReference aResult2 = getResult.a();
    assertTrue(aResult2 instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableEntityRelationship);
    assertEquals("The characteristics of someone or something", aResult2.description());
    assertEquals(1L, aResult2.id());
    assertEquals(EntityKind.ALL, aResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, aResult2.entityLifecycleStatus());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code ANY}.
   *   <li>Then first b return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'ANY'; then first b return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenAny_thenFirstBReturnImmutableEntityReference() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.ANY, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertEquals(2, actualFindForEntityResult.size());
    EntityRelationship getResult = ((List<EntityRelationship>) actualFindForEntityResult).get(0);
    assertTrue(getResult.b() instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableEntityRelationship);
    EntityRelationship getResult2 = ((List<EntityRelationship>) actualFindForEntityResult).get(1);
    assertTrue(getResult2 instanceof ImmutableEntityRelationship);
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code ANY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'ANY'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenAny_thenReturnEmpty() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.ANY, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'SOURCE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenSource_thenReturnEmpty() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'SOURCE'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenSource_thenReturnEmpty2() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.SOURCE, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code TARGET}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'TARGET'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenTarget_thenReturnEmpty() {
    // Arrange
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.TARGET, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code TARGET}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'TARGET'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenTarget_thenReturnEmpty2() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.TARGET, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#findForEntity(EntityReference, Directionality, List)}.
   *
   * <ul>
   *   <li>When {@code TARGET}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#findForEntity(EntityReference,
   * Directionality, List)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference, Directionality, List); when 'TARGET'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForEntity(EntityReference, Directionality, List)"
  })
  void testFindForEntity_whenTarget_thenReturnEmpty3() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualFindForEntityResult =
        entityRelationshipService.findForEntity(null, Directionality.TARGET, new ArrayList<>());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isNull());
    assertTrue(actualFindForEntityResult instanceof List);
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link EntityRelationshipService#removeRelationship(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationshipDao} {@link
   *       EntityRelationshipDao#remove(EntityRelationshipKey)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipService#removeRelationship(EntityRelationshipKey)}
   */
  @Test
  @DisplayName(
      "Test removeRelationship(EntityRelationshipKey); given EntityRelationshipDao remove(EntityRelationshipKey) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean EntityRelationshipService.removeRelationship(EntityRelationshipKey)"})
  void testRemoveRelationship_givenEntityRelationshipDaoRemoveReturnTrue_thenReturnTrue() {
    // Arrange
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    // Act
    Boolean actualRemoveRelationshipResult = entityRelationshipService.removeRelationship(null);

    // Assert
    verify(entityRelationshipDao).remove(isNull());
    assertTrue(actualRemoveRelationshipResult);
  }

  /**
   * Test {@link EntityRelationshipService#removeRelationship(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipService#removeRelationship(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test removeRelationship(EntityRelationshipKey); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean EntityRelationshipService.removeRelationship(EntityRelationshipKey)"})
  void testRemoveRelationship_thenReturnFalse() {
    // Arrange
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(false);

    // Act
    Boolean actualRemoveRelationshipResult = entityRelationshipService.removeRelationship(null);

    // Assert
    verify(entityRelationshipDao).remove(isNull());
    assertFalse(actualRemoveRelationshipResult);
  }

  /**
   * Test {@link EntityRelationshipService#createRelationship(EntityRelationship)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationshipDao} {@link
   *       EntityRelationshipDao#create(EntityRelationship)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#createRelationship(EntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test createRelationship(EntityRelationship); given EntityRelationshipDao create(EntityRelationship) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean EntityRelationshipService.createRelationship(EntityRelationship)"})
  void testCreateRelationship_givenEntityRelationshipDaoCreateReturnTrue_thenReturnTrue() {
    // Arrange
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    // Act
    Boolean actualCreateRelationshipResult = entityRelationshipService.createRelationship(null);

    // Assert
    verify(entityRelationshipDao).create(isNull());
    assertTrue(actualCreateRelationshipResult);
  }

  /**
   * Test {@link EntityRelationshipService#createRelationship(EntityRelationship)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationshipService#createRelationship(EntityRelationship)}
   */
  @Test
  @DisplayName("Test createRelationship(EntityRelationship); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean EntityRelationshipService.createRelationship(EntityRelationship)"})
  void testCreateRelationship_thenReturnFalse() {
    // Arrange
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(false);

    // Act
    Boolean actualCreateRelationshipResult = entityRelationshipService.createRelationship(null);

    // Assert
    verify(entityRelationshipDao).create(isNull());
    assertFalse(actualCreateRelationshipResult);
  }

  /**
   * Test {@link EntityRelationshipService#findForGenericEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipService#findForGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForGenericEntitySelector(IdSelectionOptions); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.findForGenericEntitySelector(IdSelectionOptions)"
  })
  void testFindForGenericEntitySelector_thenReturnList() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.findForGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(entityRelationshipList);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<EntityRelationship> actualFindForGenericEntitySelectorResult =
        entityRelationshipService.findForGenericEntitySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityRelationshipDao).findForGenericEntitySelector(isA(GenericSelector.class));
    assertTrue(actualFindForGenericEntitySelectorResult instanceof List);
    assertTrue(actualFindForGenericEntitySelectorResult.isEmpty());
    assertSame(entityRelationshipList, actualFindForGenericEntitySelectorResult);
  }

  /**
   * Test {@link EntityRelationshipService#deleteForGenericEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityRelationshipService#deleteForGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteForGenericEntitySelector(IdSelectionOptions); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int EntityRelationshipService.deleteForGenericEntitySelector(IdSelectionOptions)"
  })
  void testDeleteForGenericEntitySelector_thenReturnOne() {
    // Arrange
    when(entityRelationshipDao.deleteForGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(1);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteForGenericEntitySelectorResult =
        entityRelationshipService.deleteForGenericEntitySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(entityRelationshipDao).deleteForGenericEntitySelector(isA(GenericSelector.class));
    assertEquals(1, actualDeleteForGenericEntitySelectorResult);
  }

  /**
   * Test {@link EntityRelationshipService#migrateEntityRelationships(EntityReference,
   * EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * EntityRelationshipService#migrateEntityRelationships(EntityReference, EntityReference, String)}
   */
  @Test
  @DisplayName("Test migrateEntityRelationships(EntityReference, EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationshipService.migrateEntityRelationships(EntityReference, EntityReference, String)"
  })
  void testMigrateEntityRelationships() {
    // Arrange
    doNothing()
        .when(entityRelationshipDao)
        .migrateEntityRelationships(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any(), Mockito.<String>any());

    // Act
    entityRelationshipService.migrateEntityRelationships(null, null, "42");

    // Assert
    verify(entityRelationshipDao).migrateEntityRelationships(isNull(), isNull(), eq("42"));
  }

  /**
   * Test {@link EntityRelationshipService#getEntityRelationshipsByKind(RelationshipKind)}.
   *
   * <p>Method under test: {@link
   * EntityRelationshipService#getEntityRelationshipsByKind(org.finos.waltz.model.rel.RelationshipKind)}
   */
  @Test
  @DisplayName("Test getEntityRelationshipsByKind(RelationshipKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection EntityRelationshipService.getEntityRelationshipsByKind(org.finos.waltz.model.rel.RelationshipKind)"
  })
  void testGetEntityRelationshipsByKind() {
    // Arrange
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.getEntityRelationshipsByKind(
            Mockito.<org.finos.waltz.model.rel.RelationshipKind>any()))
        .thenReturn(entityRelationshipList);

    // Act
    Collection<EntityRelationship> actualEntityRelationshipsByKind =
        entityRelationshipService.getEntityRelationshipsByKind(null);

    // Assert
    verify(entityRelationshipDao).getEntityRelationshipsByKind(isNull());
    assertTrue(actualEntityRelationshipsByKind instanceof List);
    assertTrue(actualEntityRelationshipsByKind.isEmpty());
    assertSame(entityRelationshipList, actualEntityRelationshipsByKind);
  }
}
